package view;

import config.Database;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import report.ReportService;

/**
 * Frame Pendaftaran (Pertemuan 13, Tahap 6-7).
 * Dibuat murni lewat kode (Java class), tanpa JFrame Form Designer.
 * Kolom indeks 0 pada JTable = id_pendaftaran.
 */
public class PendaftaranFrame extends JFrame {

    private static final String SQL_PENDAFTARAN =
        "SELECT p.id_pendaftaran, ps.nim, ps.nama AS nama_peserta, kls.nama_kelas, "
        + "krs.nama_kursus, ins.nama AS nama_instruktur, p.tanggal_daftar, "
        + "p.status AS status_pendaftaran "
        + "FROM pendaftaran p "
        + "INNER JOIN peserta ps ON p.id_peserta = ps.id_peserta "
        + "INNER JOIN kelas kls ON p.id_kelas = kls.id_kelas "
        + "INNER JOIN kursus krs ON kls.id_kursus = krs.id_kursus "
        + "INNER JOIN instruktur ins ON kls.id_instruktur = ins.id_instruktur "
        + "ORDER BY p.id_pendaftaran";

    private JTable tblPendaftaran;
    private DefaultTableModel model;
    private JButton btnRefresh;
    private JButton btnCetakTerpilih;
    private JButton btnCetakSemua;
    private JButton btnLaporanPembayaran;
    private JButton btnTutup;
    private JLabel lblJumlah;

    public PendaftaranFrame() {
        initUI();
        muatData();
    }

    private void initUI() {
        setTitle("SIKURSUS - Data Pendaftaran");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 500);
        setMinimumSize(new Dimension(780, 400));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ===== Header =====
        JPanel pnlHeader = new JPanel(new BorderLayout());
        pnlHeader.setBackground(new Color(33, 37, 41));
        pnlHeader.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));

        JLabel lblJudul = new JLabel("DATA PENDAFTARAN KURSUS");
        lblJudul.setForeground(Color.WHITE);
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 18));
        JLabel lblSub = new JLabel("Pilih satu baris lalu Cetak Terpilih, atau klik Cetak Semua");
        lblSub.setForeground(new Color(190, 195, 200));
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 12));

        JPanel pnlTeks = new JPanel(new GridLayout(2, 1, 0, 2));
        pnlTeks.setOpaque(false);
        pnlTeks.add(lblJudul);
        pnlTeks.add(lblSub);
        pnlHeader.add(pnlTeks, BorderLayout.WEST);

        // ===== Toolbar tombol =====
        JPanel pnlTombol = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnlTombol.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(220, 220, 220)));
        btnRefresh = new JButton("Refresh");
        btnCetakTerpilih = new JButton("Cetak Terpilih");
        btnCetakSemua = new JButton("Cetak Semua");
        btnLaporanPembayaran = new JButton("Laporan Pembayaran");
        pnlTombol.add(btnRefresh);
        pnlTombol.add(btnCetakTerpilih);
        pnlTombol.add(btnCetakSemua);
        pnlTombol.add(btnLaporanPembayaran);

        JPanel pnlAtas = new JPanel(new BorderLayout());
        pnlAtas.add(pnlHeader, BorderLayout.NORTH);
        pnlAtas.add(pnlTombol, BorderLayout.CENTER);
        add(pnlAtas, BorderLayout.NORTH);

        // ===== Tabel =====
        model = new DefaultTableModel(new Object[]{
            "ID", "NIM", "Peserta", "Kelas", "Kursus", "Instruktur", "Tanggal", "Status"
        }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblPendaftaran = new JTable(model);
        tblPendaftaran.setRowHeight(24);
        tblPendaftaran.setFillsViewportHeight(true);
        tblPendaftaran.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblPendaftaran.getTableHeader().setReorderingAllowed(false);
        tblPendaftaran.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));

        int[] lebar = {40, 80, 150, 70, 200, 140, 90, 80};
        for (int i = 0; i < lebar.length; i++) {
            tblPendaftaran.getColumnModel().getColumn(i).setPreferredWidth(lebar[i]);
        }
        DefaultTableCellRenderer tengah = new DefaultTableCellRenderer();
        tengah.setHorizontalAlignment(SwingConstants.CENTER);
        tblPendaftaran.getColumnModel().getColumn(0).setCellRenderer(tengah);
        tblPendaftaran.getColumnModel().getColumn(6).setCellRenderer(tengah);

        JScrollPane scroll = new JScrollPane(tblPendaftaran);
        scroll.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        add(scroll, BorderLayout.CENTER);

        // ===== Footer =====
        JPanel pnlBawah = new JPanel(new BorderLayout());
        pnlBawah.setBorder(BorderFactory.createEmptyBorder(6, 16, 12, 16));
        lblJumlah = new JLabel("Total: 0 pendaftaran");
        lblJumlah.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnTutup = new JButton("Tutup");
        pnlBawah.add(lblJumlah, BorderLayout.WEST);
        pnlBawah.add(btnTutup, BorderLayout.EAST);
        add(pnlBawah, BorderLayout.SOUTH);

        // ===== Event =====
        btnRefresh.addActionListener(e -> muatData());
        btnCetakTerpilih.addActionListener(e -> cetakTerpilih());
        btnCetakSemua.addActionListener(e -> cetakSemua());
        btnLaporanPembayaran.addActionListener(e -> new PembayaranFrame().setVisible(true));
        btnTutup.addActionListener(e -> dispose());
    }

    private void muatData() {
        model.setRowCount(0);
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_PENDAFTARAN);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_pendaftaran"),
                    rs.getString("nim"),
                    rs.getString("nama_peserta"),
                    rs.getString("nama_kelas"),
                    rs.getString("nama_kursus"),
                    rs.getString("nama_instruktur"),
                    rs.getDate("tanggal_daftar"),
                    rs.getString("status_pendaftaran")
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "Gagal memuat data pendaftaran: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        lblJumlah.setText("Total: " + model.getRowCount() + " pendaftaran");
    }

    /** Tahap 6-7: ambil id_pendaftaran dari baris terpilih (kolom indeks 0), kirim ke report. */
    private void cetakTerpilih() {
        int row = tblPendaftaran.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this,
                "Pilih satu data pendaftaran terlebih dahulu.");
            return;
        }
        int idPendaftaran = Integer.parseInt(
            tblPendaftaran.getValueAt(row, 0).toString());
        System.out.println("ID terpilih: " + idPendaftaran); // Bukti 6
        ReportService.cetakPendaftaran(idPendaftaran);
    }

    /** Cetak semua: kirim seluruh baris tabel ke report (key = nama field di laporan_pendaftaran). */
    private void cetakSemua() {
        String[] field = {"id_pendaftaran", "nim", "nama_peserta", "nama_kelas",
            "nama_kursus", "nama_instruktur", "tanggal_daftar", "status_pendaftaran"};
        java.util.List<java.util.Map<String, ?>> rows = new java.util.ArrayList<>();
        for (int i = 0; i < model.getRowCount(); i++) {
            java.util.Map<String, Object> baris = new java.util.HashMap<>();
            for (int c = 0; c < field.length; c++) {
                baris.put(field[c], model.getValueAt(i, c));
            }
            rows.add(baris);
        }
        ReportService.cetakSemuaPendaftaran(rows);
    }

    // Untuk uji cepat tanpa form lain
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new PendaftaranFrame().setVisible(true));
    }
}