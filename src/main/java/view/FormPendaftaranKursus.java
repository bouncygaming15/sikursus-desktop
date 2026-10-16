package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class FormPendaftaranKursus extends JFrame {

    // ===== Komponen (nama variabel sesuai panduan) =====
    private JTextField txtNama;
    private JPasswordField txtKodeAkses;
    private JRadioButton rbMahasiswa;
    private JRadioButton rbUmum;
    private ButtonGroup groupJenis;
    private JComboBox<String> cmbKursus;
    private JCheckBox cbModul;
    private JCheckBox cbSertifikat;
    private JCheckBox cbRekaman;
    private JTextArea txtRingkasan;
    private JButton btnProses;
    private JButton btnReset;

    private final Font fontLabel = new Font("Serif", Font.BOLD, 15);
    private final Font fontIsi = new Font("Serif", Font.BOLD, 13);

    public FormPendaftaranKursus() {
        initKomponen();

        groupJenis.add(rbMahasiswa);
        groupJenis.add(rbUmum);

        cmbKursus.removeAllItems();
        cmbKursus.addItem("-- Pilih Kursus --");
        cmbKursus.addItem("Java Desktop");
        cmbKursus.addItem("Data Science");
        cmbKursus.addItem("Web Programming");
        cmbKursus.addItem("UI/UX Design");

        txtRingkasan.setEditable(false);

        btnProses.addActionListener(e -> btnProsesActionPerformed(e));
        btnReset.addActionListener(e -> btnResetActionPerformed(e));

        pack();
        setLocationRelativeTo(null);
    }

    // ===== Membangun tampilan (pengganti initComponents milik NetBeans) =====
    private void initKomponen() {
        setTitle("Form Pendaftaran Kursus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel root = new JPanel(null);
        root.setBackground(new Color(204, 204, 204));
        root.setPreferredSize(new Dimension(1000, 860));
        setContentPane(root);

        // Header
        JPanel header = new JPanel(null);
        header.setBackground(new Color(0, 51, 255));
        header.setBounds(0, 0, 1000, 75);
        JLabel judul = new JLabel("FORM PENDAFTARAN KURSUS", SwingConstants.CENTER);
        judul.setFont(new Font("Serif", Font.BOLD, 22));
        judul.setForeground(Color.WHITE);
        judul.setBounds(0, 0, 1000, 75);
        header.add(judul);
        root.add(header);

        // Kartu input
        JPanel card1 = new JPanel(null);
        card1.setBackground(Color.WHITE);
        card1.setBounds(25, 105, 950, 440);
        root.add(card1);

        card1.add(buatLabel("NAMA", 30, 30));
        txtNama = new JTextField();
        txtNama.setBounds(240, 28, 650, 32);
        card1.add(txtNama);

        card1.add(buatLabel("KODE AKSES", 30, 90));
        txtKodeAkses = new JPasswordField();
        txtKodeAkses.setBounds(240, 88, 650, 32);
        card1.add(txtKodeAkses);

        card1.add(buatLabel("JENIS PESERTA", 30, 165));
        rbMahasiswa = new JRadioButton("MAHASISWA");
        rbMahasiswa.setFont(fontIsi);
        rbMahasiswa.setBackground(Color.WHITE);
        rbMahasiswa.setBounds(240, 165, 140, 28);
        card1.add(rbMahasiswa);
        rbUmum = new JRadioButton("UMUM");
        rbUmum.setFont(fontIsi);
        rbUmum.setBackground(Color.WHITE);
        rbUmum.setBounds(400, 165, 100, 28);
        card1.add(rbUmum);
        groupJenis = new ButtonGroup();

        card1.add(buatLabel("KURSUS", 30, 230));
        cmbKursus = new JComboBox<>();
        cmbKursus.setBounds(240, 228, 650, 30);
        card1.add(cmbKursus);

        card1.add(buatLabel("FASILITAS", 30, 305));
        cbModul = new JCheckBox("MODUL CETAK");
        cbModul.setFont(fontIsi);
        cbModul.setBackground(Color.WHITE);
        cbModul.setBounds(240, 305, 150, 28);
        card1.add(cbModul);
        cbSertifikat = new JCheckBox("SERTIFIKAT");
        cbSertifikat.setFont(fontIsi);
        cbSertifikat.setBackground(Color.WHITE);
        cbSertifikat.setBounds(400, 305, 130, 28);
        card1.add(cbSertifikat);
        cbRekaman = new JCheckBox("AKSES REKAMAN");
        cbRekaman.setFont(fontIsi);
        cbRekaman.setBackground(Color.WHITE);
        cbRekaman.setBounds(540, 305, 170, 28);
        card1.add(cbRekaman);

        btnProses = new JButton("PROSES");
        btnProses.setFont(fontIsi);
        btnProses.setBackground(Color.WHITE);
        btnProses.setBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2));
        btnProses.setBounds(240, 380, 130, 30);
        btnProses.setFocusPainted(false);
        card1.add(btnProses);

        btnReset = new JButton("RESET");
        btnReset.setFont(fontIsi);
        btnReset.setBackground(Color.WHITE);
        btnReset.setBorder(BorderFactory.createLineBorder(new Color(255, 152, 0), 2));
        btnReset.setBounds(590, 380, 130, 30);
        btnReset.setFocusPainted(false);
        card1.add(btnReset);

        // Kartu ringkasan
        JPanel card2 = new JPanel(null);
        card2.setBackground(Color.WHITE);
        card2.setBounds(25, 575, 950, 260);
        root.add(card2);

        card2.add(buatLabel("RINGKASAN", 30, 20));
        txtRingkasan = new JTextArea();
        txtRingkasan.setFont(new Font("Monospaced", Font.PLAIN, 13));
        txtRingkasan.setBackground(new Color(232, 238, 240));
        txtRingkasan.setMargin(new java.awt.Insets(8, 8, 8, 8));
        JScrollPane sp = new JScrollPane(txtRingkasan);
        sp.setBounds(240, 20, 650, 220);
        card2.add(sp);
    }

    private JLabel buatLabel(String teks, int x, int y) {
        JLabel lbl = new JLabel(teks);
        lbl.setFont(fontLabel);
        lbl.setBounds(x, y, 200, 28);
        return lbl;
    }

    // ===== 1. Mengambil jenis peserta =====
    private String getJenisPeserta() {
        if (rbMahasiswa.isSelected()) {
            return "Mahasiswa";
        }
        if (rbUmum.isSelected()) {
            return "Umum";
        }
        return "";
    }

    // ===== 2. Biaya dasar dengan switch =====
    private double hitungBiayaDasar(String kursus) {
        switch (kursus) {
            case "Java Desktop":
                return 500_000;
            case "Data Science":
                return 650_000;
            case "Web Programming":
                return 450_000;
            case "UI/UX Design":
                return 400_000;
            default:
                return 0;
        }
    }

    // ===== 3. Biaya fasilitas =====
    private double hitungBiayaFasilitas() {
        double total = 0;
        if (cbModul.isSelected()) {
            total += 50_000;
        }
        if (cbSertifikat.isSelected()) {
            total += 75_000;
        }
        if (cbRekaman.isSelected()) {
            total += 40_000;
        }
        return total;
    }

    // ===== 4. Array + loop ringkasan fasilitas =====
    private String buatRingkasanFasilitas() {
        String[] fasilitasDipilih = new String[3];
        int jumlah = 0;

        if (cbModul.isSelected()) {
            fasilitasDipilih[jumlah] = "Modul Cetak";
            jumlah++;
        }
        if (cbSertifikat.isSelected()) {
            fasilitasDipilih[jumlah] = "Sertifikat";
            jumlah++;
        }
        if (cbRekaman.isSelected()) {
            fasilitasDipilih[jumlah] = "Akses Rekaman";
            jumlah++;
        }

        if (jumlah == 0) {
            return "Tidak ada fasilitas tambahan\n";
        }

        StringBuilder hasil = new StringBuilder();
        for (int i = 0; i < jumlah; i++) {
            hasil.append("- ").append(fasilitasDipilih[i]).append("\n");
        }
        return hasil.toString();
    }

    // ===== 5. Validasi =====
    private boolean validasiInput() {
        String nama = txtNama.getText().trim();
        String kode = new String(txtKodeAkses.getPassword());

        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nama peserta wajib diisi.",
                    "Validasi",
                    JOptionPane.WARNING_MESSAGE);
            txtNama.requestFocus();
            return false;
        }
        if (!kode.equals("PBO2026")) {
            JOptionPane.showMessageDialog(this,
                    "Kode akses demo salah.",
                    "Validasi",
                    JOptionPane.WARNING_MESSAGE);
            txtKodeAkses.requestFocus();
            return false;
        }
        if (!rbMahasiswa.isSelected() && !rbUmum.isSelected()) {
            JOptionPane.showMessageDialog(this,
                    "Pilih jenis peserta.",
                    "Validasi",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (cmbKursus.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Pilih kursus terlebih dahulu.",
                    "Validasi",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    // ===== 6. Reset =====
    private void resetForm() {
        txtNama.setText("");
        txtKodeAkses.setText("");
        groupJenis.clearSelection();
        cmbKursus.setSelectedIndex(0);
        cbModul.setSelected(false);
        cbSertifikat.setSelected(false);
        cbRekaman.setSelected(false);
        txtRingkasan.setText("");
        txtNama.requestFocus();
    }

    // ===== 7. Event tombol =====
    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {
        if (!validasiInput()) {
            return;
        }

        String nama = txtNama.getText().trim();
        String jenis = getJenisPeserta();
        String kursus = cmbKursus.getSelectedItem().toString();

        double biayaDasar = hitungBiayaDasar(kursus);
        double diskon = jenis.equals("Mahasiswa") ? biayaDasar * 0.10 : 0;
        double biayaFasilitas = hitungBiayaFasilitas();
        double total = biayaDasar - diskon + biayaFasilitas;

        String fasilitas = buatRingkasanFasilitas();

        String ringkasan
                = "PENDAFTARAN KURSUS\n"
                + "==============================\n"
                + "Nama            : " + nama + "\n"
                + "Jenis Peserta   : " + jenis + "\n"
                + "Kursus          : " + kursus + "\n"
                + "Biaya Dasar     : Rp" + String.format("%,.0f", biayaDasar) + "\n"
                + "Diskon          : Rp" + String.format("%,.0f", diskon) + "\n"
                + "Fasilitas:\n" + fasilitas
                + "Biaya Fasilitas : Rp" + String.format("%,.0f", biayaFasilitas) + "\n"
                + "==============================\n"
                + "TOTAL           : Rp" + String.format("%,.0f", total);

        txtRingkasan.setText(ringkasan);

        JOptionPane.showMessageDialog(this,
                "Pendaftaran berhasil diproses.",
                "Berhasil",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
        int pilihan = JOptionPane.showConfirmDialog(
            this,
            "Kosongkan seluruh input?",
            "Konfirmasi Reset",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

    if (pilihan == JOptionPane.YES_OPTION) {
        resetForm();
    }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormPendaftaranKursus().setVisible(true));
    }
}
