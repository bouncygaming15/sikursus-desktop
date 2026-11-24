package view;

import config.Database;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import report.ReportService;

/**
 * Form Pembayaran (CRUD + cetak laporan rentang tanggal).
 * Seluruh tampilan dibuat dengan kode, tanpa NetBeans GUI Builder.
 */
public class PembayaranFrame extends JFrame {

    // ===== Item untuk combo pendaftaran =====
    private static class PendaftaranItem {
        final int id;
        final String label;

        PendaftaranItem(int id, String label) {
            this.id = id;
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    // ===== Komponen =====
    private final JComboBox<PendaftaranItem> cmbPendaftaran = new JComboBox<>();
    private final JTextField txtTanggal = new JTextField(12);
    private final JTextField txtNominal = new JTextField(12);
    private final JComboBox<String> cmbMetode =
            new JComboBox<>(new String[]{"TUNAI", "TRANSFER", "QRIS"});
    private final JComboBox<String> cmbStatus =
            new JComboBox<>(new String[]{"MENUNGGU", "LUNAS", "BATAL"});

    private final JButton btnSimpan = new JButton("Simpan");
    private final JButton btnUbah = new JButton("Ubah");
    private final JButton btnHapus = new JButton("Hapus");
    private final JButton btnReset = new JButton("Reset");

    private final JTextField txtTanggalAwal = new JTextField(10);
    private final JTextField txtTanggalAkhir = new JTextField(10);
    private final JButton btnCetakPembayaran = new JButton("Cetak Laporan Pembayaran");

    private final DefaultTableModel model = new DefaultTableModel(
            new String[]{"ID", "ID Daftar", "Peserta", "Kelas",
                "Tanggal", "Nominal", "Metode", "Status"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JTable tblPembayaran = new JTable(model);

    private int selectedId = -1;

    public PembayaranFrame() {
        setTitle("Data Pembayaran - SIKURSUS Desktop");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 620);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(8, 8));
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(buatPanelForm(), BorderLayout.NORTH);
        add(buatPanelTabel(), BorderLayout.CENTER);
        add(buatPanelLaporan(), BorderLayout.SOUTH);

        pasangEvent();

        resetForm();
        muatPendaftaran();
        muatTabel();
    }

    // ================= TAMPILAN =================

    private JPanel buatPanelForm() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Form Pembayaran"));

        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 6, 4, 6);
        g.anchor = GridBagConstraints.WEST;
        g.fill = GridBagConstraints.HORIZONTAL;

        // Baris 0: pendaftaran
        g.gridx = 0; g.gridy = 0; g.weightx = 0;
        panel.add(new JLabel("Pendaftaran"), g);
        g.gridx = 1; g.gridwidth = 3; g.weightx = 1;
        panel.add(cmbPendaftaran, g);
        g.gridwidth = 1;

        // Baris 1: tanggal + nominal
        g.gridx = 0; g.gridy = 1; g.weightx = 0;
        panel.add(new JLabel("Tanggal (yyyy-MM-dd)"), g);
        g.gridx = 1; g.weightx = 1;
        panel.add(txtTanggal, g);
        g.gridx = 2; g.weightx = 0;
        panel.add(new JLabel("Nominal (Rp)"), g);
        g.gridx = 3; g.weightx = 1;
        panel.add(txtNominal, g);

        // Baris 2: metode + status
        g.gridx = 0; g.gridy = 2; g.weightx = 0;
        panel.add(new JLabel("Metode"), g);
        g.gridx = 1; g.weightx = 1;
        panel.add(cmbMetode, g);
        g.gridx = 2; g.weightx = 0;
        panel.add(new JLabel("Status"), g);
        g.gridx = 3; g.weightx = 1;
        panel.add(cmbStatus, g);

        // Baris 3: tombol
        JPanel tombol = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        tombol.add(btnSimpan);
        tombol.add(btnUbah);
        tombol.add(btnHapus);
        tombol.add(btnReset);
        g.gridx = 0; g.gridy = 3; g.gridwidth = 4; g.weightx = 1;
        panel.add(tombol, g);

        return panel;
    }

    private JScrollPane buatPanelTabel() {
        tblPembayaran.setRowHeight(24);
        tblPembayaran.getTableHeader().setReorderingAllowed(false);
        tblPembayaran.getTableHeader().setFont(
                tblPembayaran.getTableHeader().getFont().deriveFont(Font.BOLD));

        // lebar kolom
        int[] lebar = {40, 70, 160, 80, 90, 100, 80, 90};
        for (int i = 0; i < lebar.length; i++) {
            tblPembayaran.getColumnModel().getColumn(i).setPreferredWidth(lebar[i]);
        }

        // format nominal rata kanan: 500.000
        final DecimalFormat fmt = new DecimalFormat("#,##0");
        DefaultTableCellRenderer rupiah = new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                if (value instanceof BigDecimal) {
                    setText(fmt.format(value));
                } else {
                    super.setValue(value);
                }
            }
        };
        rupiah.setHorizontalAlignment(SwingConstants.RIGHT);
        tblPembayaran.getColumnModel().getColumn(5).setCellRenderer(rupiah);

        // kolom ID rata tengah
        DefaultTableCellRenderer tengah = new DefaultTableCellRenderer();
        tengah.setHorizontalAlignment(SwingConstants.CENTER);
        tblPembayaran.getColumnModel().getColumn(0).setCellRenderer(tengah);
        tblPembayaran.getColumnModel().getColumn(1).setCellRenderer(tengah);

        JScrollPane scroll = new JScrollPane(tblPembayaran);
        scroll.setBorder(BorderFactory.createTitledBorder("Daftar Pembayaran"));
        scroll.setPreferredSize(new Dimension(800, 250));
        return scroll;
    }

    private JPanel buatPanelLaporan() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 6));
        panel.setBorder(BorderFactory.createTitledBorder(
                "Laporan Pembayaran per Rentang Tanggal"));
        panel.add(new JLabel("Dari"));
        panel.add(txtTanggalAwal);
        panel.add(new JLabel("Sampai"));
        panel.add(txtTanggalAkhir);
        panel.add(new JLabel("(yyyy-MM-dd)"));
        panel.add(btnCetakPembayaran);
        return panel;
    }

    // ================= EVENT =================

    private void pasangEvent() {
        btnSimpan.addActionListener(e -> simpan());
        btnUbah.addActionListener(e -> ubah());
        btnHapus.addActionListener(e -> hapus());
        btnReset.addActionListener(e -> resetForm());
        btnCetakPembayaran.addActionListener(e -> cetakPembayaran());

        tblPembayaran.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                isiFormDariTabel();
            }
        });
    }

    // ================= DATA =================

    private void muatPendaftaran() {
        cmbPendaftaran.removeAllItems();
        String sql = "SELECT p.id_pendaftaran, ps.nama, kls.nama_kelas "
                + "FROM pendaftaran p "
                + "INNER JOIN peserta ps ON p.id_peserta = ps.id_peserta "
                + "INNER JOIN kelas kls ON p.id_kelas = kls.id_kelas "
                + "ORDER BY p.id_pendaftaran";
        try (Connection conn = Database.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id_pendaftaran");
                String label = id + " - " + rs.getString("nama")
                        + " (" + rs.getString("nama_kelas") + ")";
                cmbPendaftaran.addItem(new PendaftaranItem(id, label));
            }
        } catch (Exception ex) {
            tampilError("Gagal memuat data pendaftaran", ex);
        }
    }

    private void muatTabel() {
        model.setRowCount(0);
        String sql = "SELECT pb.id_pembayaran, pb.id_pendaftaran, ps.nama, "
                + "kls.nama_kelas, pb.tanggal_bayar, pb.nominal, pb.metode, pb.status "
                + "FROM pembayaran pb "
                + "INNER JOIN pendaftaran p ON pb.id_pendaftaran = p.id_pendaftaran "
                + "INNER JOIN peserta ps ON p.id_peserta = ps.id_peserta "
                + "INNER JOIN kelas kls ON p.id_kelas = kls.id_kelas "
                + "ORDER BY pb.tanggal_bayar DESC, pb.id_pembayaran DESC";
        try (Connection conn = Database.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_pembayaran"),
                    rs.getInt("id_pendaftaran"),
                    rs.getString("nama"),
                    rs.getString("nama_kelas"),
                    rs.getDate("tanggal_bayar").toString(),
                    rs.getBigDecimal("nominal"),
                    rs.getString("metode"),
                    rs.getString("status")
                });
            }
        } catch (Exception ex) {
            tampilError("Gagal memuat data pembayaran", ex);
        }
    }

    private void simpan() {
        Object[] data = bacaForm();
        if (data == null) {
            return;
        }
        String sql = "INSERT INTO pembayaran "
                + "(id_pendaftaran, tanggal_bayar, nominal, metode, status) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            isiParameter(ps, data);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data pembayaran berhasil disimpan.");
            muatTabel();
            resetForm();
        } catch (Exception ex) {
            tampilError("Gagal menyimpan data", ex);
        }
    }

    private void ubah() {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data pada tabel terlebih dahulu.");
            return;
        }
        Object[] data = bacaForm();
        if (data == null) {
            return;
        }
        String sql = "UPDATE pembayaran SET id_pendaftaran = ?, tanggal_bayar = ?, "
                + "nominal = ?, metode = ?, status = ? WHERE id_pembayaran = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            isiParameter(ps, data);
            ps.setInt(6, selectedId);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data pembayaran berhasil diubah.");
            muatTabel();
            resetForm();
        } catch (Exception ex) {
            tampilError("Gagal mengubah data", ex);
        }
    }

    private void hapus() {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data pada tabel terlebih dahulu.");
            return;
        }
        int pilih = JOptionPane.showConfirmDialog(this,
                "Hapus pembayaran ID " + selectedId + "?",
                "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (pilih != JOptionPane.YES_OPTION) {
            return;
        }
        String sql = "DELETE FROM pembayaran WHERE id_pembayaran = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, selectedId);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data pembayaran berhasil dihapus.");
            muatTabel();
            resetForm();
        } catch (Exception ex) {
            tampilError("Gagal menghapus data", ex);
        }
    }

    // ================= BANTUAN FORM =================

    /** Membaca dan memvalidasi form. Mengembalikan null jika tidak valid. */
    private Object[] bacaForm() {
        PendaftaranItem item = (PendaftaranItem) cmbPendaftaran.getSelectedItem();
        if (item == null) {
            JOptionPane.showMessageDialog(this, "Pilih data pendaftaran.");
            return null;
        }

        java.sql.Date tanggal;
        try {
            tanggal = java.sql.Date.valueOf(txtTanggal.getText().trim());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    "Format tanggal salah. Gunakan yyyy-MM-dd, contoh 2026-11-24.");
            return null;
        }

        BigDecimal nominal;
        try {
            nominal = new BigDecimal(txtNominal.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nominal harus berupa angka.");
            return null;
        }
        if (nominal.signum() <= 0) {
            JOptionPane.showMessageDialog(this, "Nominal harus lebih dari 0.");
            return null;
        }

        return new Object[]{
            item.id,
            tanggal,
            nominal,
            cmbMetode.getSelectedItem().toString(),
            cmbStatus.getSelectedItem().toString()
        };
    }

    private void isiParameter(PreparedStatement ps, Object[] d) throws Exception {
        ps.setInt(1, (Integer) d[0]);
        ps.setDate(2, (java.sql.Date) d[1]);
        ps.setBigDecimal(3, (BigDecimal) d[2]);
        ps.setString(4, (String) d[3]);
        ps.setString(5, (String) d[4]);
    }

    private void isiFormDariTabel() {
        int row = tblPembayaran.getSelectedRow();
        if (row == -1) {
            return;
        }
        selectedId = (Integer) model.getValueAt(row, 0);
        int idDaftar = (Integer) model.getValueAt(row, 1);

        for (int i = 0; i < cmbPendaftaran.getItemCount(); i++) {
            if (cmbPendaftaran.getItemAt(i).id == idDaftar) {
                cmbPendaftaran.setSelectedIndex(i);
                break;
            }
        }
        txtTanggal.setText(model.getValueAt(row, 4).toString());
        txtNominal.setText(((BigDecimal) model.getValueAt(row, 5))
                .stripTrailingZeros().toPlainString());
        cmbMetode.setSelectedItem(model.getValueAt(row, 6));
        cmbStatus.setSelectedItem(model.getValueAt(row, 7));

        btnSimpan.setEnabled(false);
        btnUbah.setEnabled(true);
        btnHapus.setEnabled(true);
    }

    private void resetForm() {
        selectedId = -1;
        tblPembayaran.clearSelection();
        if (cmbPendaftaran.getItemCount() > 0) {
            cmbPendaftaran.setSelectedIndex(0);
        }
        txtTanggal.setText(java.sql.Date.valueOf(java.time.LocalDate.now()).toString());
        txtNominal.setText("");
        cmbMetode.setSelectedIndex(0);
        cmbStatus.setSelectedIndex(0);

        btnSimpan.setEnabled(true);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
    }

    // ================= LAPORAN =================

    private void cetakPembayaran() {
        String a = txtTanggalAwal.getText().trim();
        String b = txtTanggalAkhir.getText().trim();
        if (a.isEmpty() || b.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Tanggal awal dan akhir wajib diisi (yyyy-MM-dd).");
            return;
        }
        try {
            java.sql.Date awal = java.sql.Date.valueOf(a);
            java.sql.Date akhir = java.sql.Date.valueOf(b);
            if (awal.after(akhir)) {
                JOptionPane.showMessageDialog(this,
                        "Tanggal awal tidak boleh setelah tanggal akhir.");
                return;
            }
            ReportService.cetakPembayaran(awal, akhir);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    "Format tanggal salah. Gunakan yyyy-MM-dd, contoh 2026-11-01.");
        }
    }

    private void tampilError(String pesan, Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, pesan + ":\n" + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    // ================= UJI MANDIRI =================

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PembayaranFrame().setVisible(true));
    }
}