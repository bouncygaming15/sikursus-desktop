
package view;
    import javax.swing.JOptionPane;
    import model.Kursus;

public class FormPendaftaranAwal extends javax.swing.JFrame {

    
    public FormPendaftaranAwal() {
       initComponents();
        getRootPane().setDefaultButton(btnProses);

        // Batas minimum menjaga form tetap nyaman saat window diperkecil.
        setMinimumSize(new java.awt.Dimension(700, 520));

        // Ukuran awal yang nyaman. Saat di-maximize, GroupLayout akan menyesuaikan.
        setSize(new java.awt.Dimension(900, 560));
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKodeKursus = new javax.swing.JTextField();
        txtBiaya = new javax.swing.JTextField();
        txtDiskon = new javax.swing.JTextField();
        cmbKursus = new javax.swing.JComboBox<>();
        btnProses = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbLevel = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Form Pendaftaran");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Kode Kursus");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Biaya Kursus");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Nama Kursus");

        txtKodeKursus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtBiaya.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtDiskon.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtDiskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiskonActionPerformed(evt);
            }
        });

        cmbKursus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cmbKursus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Java Desktop Fundamental", "Data Science", "UI/UX" }));

        btnProses.setBackground(new java.awt.Color(51, 153, 255));
        btnProses.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnProses.setText("Proses");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 0, 0));
        btnReset.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Diskon (%)");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Level");

        cmbLevel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cmbLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Basic" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel7))
                                        .addGap(10, 10, 10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel5)
                                        .addGap(6, 6, 6)))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtKodeKursus)
                                    .addComponent(cmbKursus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel1))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(btnProses, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtKodeKursus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbKursus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProses, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
  String kode = txtKodeKursus.getText().trim();
        String nama = cmbKursus.getSelectedItem().toString();
        String level = cmbLevel.getSelectedItem().toString();
        String strBiaya = txtBiaya.getText().trim();
        String strDiskon = txtDiskon.getText().trim();

        if (kode.isEmpty() || strBiaya.isEmpty() || strDiskon.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Kode kursus, biaya, dan diskon wajib diisi.",
                    "Validasi Input",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double biaya = Double.parseDouble(strBiaya);
            double diskon = Double.parseDouble(strDiskon);

            if (biaya < 0) {
                JOptionPane.showMessageDialog(this,
                        "Biaya tidak boleh bernilai negatif.",
                        "Validasi Input",
                        JOptionPane.WARNING_MESSAGE);
                txtBiaya.requestFocus();
                return;
            }

            if (diskon < 0 || diskon > 100) {
                JOptionPane.showMessageDialog(this,
                        "Diskon harus berada pada rentang 0 sampai 100.",
                        "Validasi Input",
                        JOptionPane.WARNING_MESSAGE);
                txtDiskon.requestFocus();
                return;
            }

            Kursus kursus = new Kursus(kode, nama, level, biaya);
            double total = kursus.hitungBiayaSetelahDiskon(diskon);

            String pesan = "Kursus: " + nama
                    + "\nKode: " + kode
                    + "\nLevel: " + level
                    + "\nBiaya awal: Rp" + String.format("%,.0f", biaya)
                    + "\nDiskon: " + diskon + "%"
                    + "\nBiaya akhir: Rp" + String.format("%,.0f", total);

            JOptionPane.showMessageDialog(this,
                    pesan,
                    "Hasil Pendaftaran Kursus",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Biaya dan diskon harus berupa angka.\nContoh biaya: 500000 | diskon: 10",
                    "Input Tidak Valid",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnProsesActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // Munculkan pop-up konfirmasi
        int konfirmasi = JOptionPane.showConfirmDialog(this, 
                "Apakah Anda yakin ingin menghapus semua isian form?", 
                "Konfirmasi Reset", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);
        
        // Jika user memilih YES
        if (konfirmasi == JOptionPane.YES_OPTION) {
            txtKodeKursus.setText("");
            cmbKursus.setSelectedIndex(0);
            cmbLevel.setSelectedIndex(0);
            txtBiaya.setText("");
            txtDiskon.setText("");
            
            // Kembalikan kursor ke kolom paling atas (Kode Kursus)
            txtKodeKursus.requestFocus();
        }
       
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtDiskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiskonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiskonActionPerformed
    private double hitungTotal(double biaya, int jumlah) {
        return biaya * jumlah;
    }
    /**
     * @param args the command line arguments
     */
    //<editor-fold defaultstate="collapsed" desc="/*comment*/">
   public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPendaftaranAwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormPendaftaranAwal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cmbKursus;
    private javax.swing.JComboBox<String> cmbLevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtBiaya;
    private javax.swing.JTextField txtDiskon;
    private javax.swing.JTextField txtKodeKursus;
    // End of variables declaration//GEN-END:variables
}
