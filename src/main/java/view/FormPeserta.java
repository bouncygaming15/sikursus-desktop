
package view;

import dao.PesertaDAO;
import javax.swing.JOptionPane;
import model.Peserta;


public class FormPeserta extends javax.swing.JFrame {
 public FormPeserta() {
        initComponents();

        buttonGroupJenisKelamin.add(rbLaki);
        buttonGroupJenisKelamin.add(rbPerempuan);

        cmbKursus.removeAllItems();
        cmbKursus.addItem("-- Pilih Kursus --");
        cmbKursus.addItem("Java Desktop");
        cmbKursus.addItem("Data Science");
        cmbKursus.addItem("Web Programming");
        cmbKursus.addItem("UI/UX Design");

        txtRingkasan.setText(""); // Kosongkan ringkasan di awal
    }   // <- INI YANG HILANG: penutup constructor
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupJenisKelamin = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        txtProdi = new javax.swing.JTextField();
        txtNoHp = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtKodeAkses = new javax.swing.JPasswordField();
        cmbKursus = new javax.swing.JComboBox<>();
        cbModul = new javax.swing.JCheckBox();
        cbSertifikat = new javax.swing.JCheckBox();
        cbRekaman = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRingkasan = new javax.swing.JTextArea();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Form Pendaftaran Kursus");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("NIM");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Nama Peserta");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Jenis Kelamin");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Program Studi");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Nomor HP");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Kode Akses");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Kursus");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Fasilitas");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Ringkasan");

        rbLaki.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbLaki.setText("Laki - Laki");

        rbPerempuan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbPerempuan.setText("Perempuan");

        cmbKursus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Java Desktop", "Data Science", "UI/UX" }));

        cbModul.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbModul.setText("Modul Cetak");

        cbSertifikat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbSertifikat.setText("Sertifikat");

        cbRekaman.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbRekaman.setText("Akses Rekaman");

        txtRingkasan.setColumns(20);
        txtRingkasan.setRows(5);
        jScrollPane1.setViewportView(txtRingkasan);

        btnSimpan.setBackground(new java.awt.Color(153, 255, 255));
        btnSimpan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 204, 153));
        btnReset.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnReset.setText("Reset");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(cbModul)
                            .addGap(18, 18, 18)
                            .addComponent(cbSertifikat)
                            .addGap(18, 18, 18)
                            .addComponent(cbRekaman))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(rbLaki)
                            .addGap(18, 18, 18)
                            .addComponent(rbPerempuan))
                        .addComponent(txtNim)
                        .addComponent(txtNama)
                        .addComponent(txtProdi)
                        .addComponent(txtNoHp)
                        .addComponent(txtEmail)
                        .addComponent(txtKodeAkses)
                        .addComponent(cmbKursus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rbLaki)
                    .addComponent(rbPerempuan))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtKodeAkses, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbKursus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbModul)
                    .addComponent(cbSertifikat)
                    .addComponent(cbRekaman))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(271, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
 // 1. Ambil input
        String nim = txtNim.getText().trim();
        String nama = txtNama.getText().trim();
        String prodi = txtProdi.getText().trim();
        String noHp = txtNoHp.getText().trim();
        String email = txtEmail.getText().trim();

        String jenisKelamin = "";
        if (rbLaki.isSelected()) {
            jenisKelamin = "L";
        } else if (rbPerempuan.isSelected()) {
            jenisKelamin = "P";
        }

        // 2. Validasi
        if (nim.isEmpty() || nama.isEmpty() || prodi.isEmpty()
                || jenisKelamin.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "NIM, nama, jenis kelamin, dan prodi wajib diisi.",
                    "Validasi",
                    javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // 3. Bentuk object Peserta
        Peserta peserta = new Peserta(
                nim, nama, jenisKelamin, prodi, noHp, email
        );

        // 4. Panggil DAO
        PesertaDAO dao = new PesertaDAO();

        try {
            boolean berhasil = dao.insert(peserta);

            if (berhasil) {
                javax.swing.JOptionPane.showMessageDialog(
                        this, "Data peserta berhasil disimpan."
                );
                clearForm();
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Data tidak tersimpan.",
                        "Informasi",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );
            }
        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Gagal menyimpan data:\n" + e.getMessage(),
                    "Database Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }
     private void clearForm() {
        txtNim.setText("");
        txtNama.setText("");
        buttonGroupJenisKelamin.clearSelection();
        txtProdi.setText("");
        txtNoHp.setText("");
        txtEmail.setText("");
        cmbKursus.setSelectedIndex(0);
        cbModul.setSelected(false);
        cbSertifikat.setSelected(false);
        cbRekaman.setSelected(false);
        txtRingkasan.setText("");
        txtNim.requestFocus();
    }
     
     private void tampilkanRingkasan() {
        String nim = txtNim.getText().trim();
        String nama = txtNama.getText().trim();
        String prodi = txtProdi.getText().trim();
        String noHp = txtNoHp.getText().trim();
        String email = txtEmail.getText().trim();
        String jenisKelamin = rbLaki.isSelected() ? "Laki-laki" : (rbPerempuan.isSelected() ? "Perempuan" : "-");
        
        String kursusDipilih = cmbKursus.getSelectedIndex() > 0 ? cmbKursus.getSelectedItem().toString() : "-";
        double biayaDasar = hitungBiayaDasar(kursusDipilih);
        double biayaFasilitas = hitungBiayaFasilitas();
        double totalBiaya = biayaDasar + biayaFasilitas;

        StringBuilder sb = new StringBuilder();
        sb.append("PENDAFTARAN & PENYIMPANAN DATA\n");
        sb.append("--------------------------------------------------\n");
        sb.append("NIM        : ").append(nim.isEmpty() ? "-" : nim).append("\n");
        sb.append("Nama       : ").append(nama.isEmpty() ? "-" : nama).append("\n");
        sb.append("Gender     : ").append(jenisKelamin).append("\n");
        sb.append("Prodi      : ").append(prodi.isEmpty() ? "-" : prodi).append("\n");
        sb.append("No HP      : ").append(noHp.isEmpty() ? "-" : noHp).append("\n");
        sb.append("Email      : ").append(email.isEmpty() ? "-" : email).append("\n");
        sb.append("Kursus     : ").append(kursusDipilih).append("\n");
        sb.append("Biaya Dasar: Rp").append(String.format("%,.0f", biayaDasar).replace(',', '.')).append("\n");
        sb.append("Fasilitas  :\n").append(buatRingkasanFasilitas()).append("\n");
        sb.append("--------------------------------------------------\n");
        sb.append("TOTAL BIAYA: Rp").append(String.format("%,.0f", totalBiaya).replace(',', '.'));

        txtRingkasan.setText(sb.toString());
    }
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
        return "Tidak ada fasilitas tambahan";
        }
        StringBuilder hasil = new StringBuilder();
        for (int i = 0; i < jumlah; i++) {
        hasil.append("- ").append(fasilitasDipilih[i]).append("\n");
        }
        return hasil.toString();
    }
    private boolean validasiInput() {
        String nim = txtNim.getText().trim();
        String nama = txtNama.getText().trim();
        String prodi = txtProdi.getText().trim();
        
        if (nim.isEmpty()) {
            JOptionPane.showMessageDialog(this, "NIM wajib diisi.", "Validasi", JOptionPane.WARNING_MESSAGE);
            txtNim.requestFocus();
            return false;
        }
        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama peserta wajib diisi.", "Validasi", JOptionPane.WARNING_MESSAGE);
            txtNama.requestFocus();
            return false;
        }
        if (!rbLaki.isSelected() && !rbPerempuan.isSelected()) {
            JOptionPane.showMessageDialog(this, "Pilih jenis kelamin terlebih dahulu.", "Validasi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (prodi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Program studi wajib diisi.", "Validasi", JOptionPane.WARNING_MESSAGE);
            txtProdi.requestFocus();
            return false;
        }
        if (cmbKursus.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Pilih kursus terlebih dahulu.", "Validasi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nim = txtNim.getText().trim();
        String nama = txtNama.getText().trim();
        String prodi = txtProdi.getText().trim();
        String noHp = txtNoHp.getText().trim();
        String email = txtEmail.getText().trim();
        String kodeAkses = new String(txtKodeAkses.getPassword()); // Mengambil input password
        String jenisKelamin = "";
        
        if (rbLaki.isSelected()) {
            jenisKelamin = "L";
        } else if (rbPerempuan.isSelected()) {
            jenisKelamin = "P";
        }
        
        // Validasi input wajib
        if (nim.isEmpty() || nama.isEmpty() || prodi.isEmpty() || jenisKelamin.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "NIM, nama, jenis kelamin, dan prodi wajib diisi.",
                "Validasi",
                javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        // --- TAMBAHKAN VALIDASI KODE AKSES DI SINI ---
        if (!kodeAkses.equals("PBO2026")) { // Ganti "PBO2026" dengan kode akses yang Anda inginkan
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Kode akses salah!",
                "Validasi",
                javax.swing.JOptionPane.WARNING_MESSAGE
            );
            txtKodeAkses.requestFocus();
            return;
        }
        // ---------------------------------------------
        
        Peserta peserta = new Peserta(nim, nama, jenisKelamin, prodi, noHp, email);
        PesertaDAO dao = new PesertaDAO();
        try {
            boolean berhasil = dao.insert(peserta);
            if (berhasil) {
                javax.swing.JOptionPane.showMessageDialog(this, "Data peserta berhasil disimpan.");
                
                // Ringkasan muncul setelah klik simpan
                tampilkanRingkasan(); 
                
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Data tidak tersimpan.",
                    "Informasi",
                    javax.swing.JOptionPane.WARNING_MESSAGE
                );
            }
        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Gagal menyimpan data:\n" + e.getMessage(),
                "Database Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPeserta().setVisible(true);
            }
        });
    }//GEN-LAST:event_btnSimpanActionPerformed
               
    /**
     * @param args the command line arguments
     */
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.ButtonGroup buttonGroupJenisKelamin;
    private javax.swing.JCheckBox cbModul;
    private javax.swing.JCheckBox cbRekaman;
    private javax.swing.JCheckBox cbSertifikat;
    private javax.swing.JComboBox<String> cmbKursus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtKodeAkses;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtNoHp;
    private javax.swing.JTextField txtProdi;
    private javax.swing.JTextArea txtRingkasan;
    // End of variables declaration//GEN-END:variables

    private double hitungBiayaDasar(String kursusDipilih) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private double hitungBiayaFasilitas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
