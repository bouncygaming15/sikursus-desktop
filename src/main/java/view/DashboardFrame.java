/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

// 1. IMPORT (paling atas, di bawah package)
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.User;
import util.UserSession;
import util.WindowManager;

public class DashboardFrame extends javax.swing.JFrame {

    /**
     * Creates new form DashboardFrame
     */
    public DashboardFrame() {
        initComponents();
         setLocationRelativeTo(null);
         setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
         
           // Sambungkan menu item ke method event
    miPeserta.addActionListener(this::miPesertaActionPerformed);
    miInstruktur.addActionListener(this::miInstrukturActionPerformed);
    miKursus.addActionListener(this::miKursusActionPerformed);
    miKelas.addActionListener(this::miKelasActionPerformed);
    miPembayaran.addActionListener(this::miPembayaranActionPerformed);
    miLogout.addActionListener(this::miLogoutActionPerformed);
    miTutup.addActionListener(this::miTutupActionPerformed);
    
    
        miPeserta.setIcon(loadIcon("/icons/Peserta.png"));
        miInstruktur.setIcon(loadIcon("/icons/Instruktur.png"));
        miKursus.setIcon(loadIcon("/icons/Kursus.png"));
        miKelas.setIcon(loadIcon("/icons/Kelas.png"));
        
        applySession();   
    }
    
      // 3. METHOD loadIcon() (letakkan di bawah constructor)
    private ImageIcon loadIcon(String path) {
        URL url = getClass().getResource(path);
        return url == null ? null : new ImageIcon(url);
    }


   private void applySession() {
        User user = UserSession.getCurrentUser();

        if (user == null) {
            JOptionPane.showMessageDialog(this,
                    "Session tidak ditemukan. Silakan login ulang.");
            dispose();
            SwingUtilities.invokeLater(
                    () -> new LoginFrame().setVisible(true));
            return;
        }

        lblUser.setText(user.getUsername());
        lblRole.setText(user.getRole());

        boolean admin = user.isAdmin();
        miInstruktur.setEnabled(admin);
        miKursus.setEnabled(admin);
        miKelas.setEnabled(admin);

        miPeserta.setEnabled(true);
        menuTransaksi.setEnabled(true);
        menuLaporan.setEnabled(true);
    }
   private void miLogoutActionPerformed(java.awt.event.ActionEvent evt) {
    int pilihan = JOptionPane.showConfirmDialog(this,
            "Logout dari aplikasi?",
            "Konfirmasi Logout",
            JOptionPane.YES_NO_OPTION);

    if (pilihan == JOptionPane.YES_OPTION) {
        WindowManager.closeAll();
        UserSession.clear();
        dispose();
        SwingUtilities.invokeLater(
                () -> new LoginFrame().setVisible(true));
    }
}
   private void miTutupActionPerformed(java.awt.event.ActionEvent evt) {
    int pilihan = JOptionPane.showConfirmDialog(this,
            "Tutup aplikasi SIKURSUS?",
            "Konfirmasi",
            JOptionPane.YES_NO_OPTION);

    if (pilihan == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
}
   
  private void miPesertaActionPerformed(java.awt.event.ActionEvent evt) {
    WindowManager.open(PesertaJFrame.class, PesertaJFrame::new);
}

private void miInstrukturActionPerformed(java.awt.event.ActionEvent evt) {
    WindowManager.open(InstrukturFrame.class, InstrukturFrame::new);
}

private void miKursusActionPerformed(java.awt.event.ActionEvent evt) {
    WindowManager.open(KursusFrame.class, KursusFrame::new);
}

private void miKelasActionPerformed(java.awt.event.ActionEvent evt) {
    WindowManager.open(KelasFrame.class, KelasFrame::new);
}
private void miTentangActionPerformed(java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(this,
            "SIKURSUS Desktop\nProject PBO - Program Studi Informatika");
}

private void miRefreshActionPerformed(java.awt.event.ActionEvent evt) {
    applySession();
}
private void miPembayaranActionPerformed(java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(this,
            "Modul Pembayaran sedang dikembangkan pada tahap project berikutnya.");
}

private void applyMenuTheme() {
    java.awt.Color bg = new java.awt.Color(51, 6, 148);

    jMenuBar1.setOpaque(true);
    jMenuBar1.setBackground(bg);

    javax.swing.JMenu[] menus = { menuMaster, menuTransaksi, menuLaporan,
                                  menuKeluar, miTentang, miRefresh };
    for (javax.swing.JMenu m : menus) {
        m.setOpaque(true);
        m.setBackground(bg);
        m.setForeground(java.awt.Color.WHITE);
    }
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupDashboard = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuMaster = new javax.swing.JMenu();
        miPeserta = new javax.swing.JMenuItem();
        miInstruktur = new javax.swing.JMenuItem();
        miKursus = new javax.swing.JMenuItem();
        miKelas = new javax.swing.JMenuItem();
        menuTransaksi = new javax.swing.JMenu();
        miPendaftaran = new javax.swing.JMenuItem();
        miPembayaran = new javax.swing.JMenuItem();
        menuLaporan = new javax.swing.JMenu();
        miLaporanPeserta = new javax.swing.JMenuItem();
        miLaporanPendaftaran = new javax.swing.JMenuItem();
        menuKeluar = new javax.swing.JMenu();
        miLogout = new javax.swing.JMenuItem();
        separator = new javax.swing.JMenuItem();
        miTutup = new javax.swing.JMenuItem();
        miTentang = new javax.swing.JMenu();
        miRefresh = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("SIKURSUS DESKTOP");

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(153, 153, 153));
        lblUser.setText("User : Admin");

        lblRole.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRole.setForeground(new java.awt.Color(153, 153, 153));
        lblRole.setText("Role : ADMIN");

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(236, 35));

        menuMaster.setForeground(new java.awt.Color(255, 255, 255));
        menuMaster.setText("Master");
        menuMaster.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        miPeserta.setText("Peserta");
        menuMaster.add(miPeserta);

        miInstruktur.setText("Instruktur");
        menuMaster.add(miInstruktur);

        miKursus.setText("Kursus");
        menuMaster.add(miKursus);

        miKelas.setText("\tKelas");
        menuMaster.add(miKelas);

        jMenuBar1.add(menuMaster);

        menuTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        menuTransaksi.setText("Transaksi");
        menuTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        miPendaftaran.setText("Pendaftaran");
        miPendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPendaftaranActionPerformed(evt);
            }
        });
        menuTransaksi.add(miPendaftaran);

        miPembayaran.setText("Pembayaran");
        menuTransaksi.add(miPembayaran);

        jMenuBar1.add(menuTransaksi);

        menuLaporan.setForeground(new java.awt.Color(255, 255, 255));
        menuLaporan.setText("Laporan");
        menuLaporan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        miLaporanPeserta.setText("Laporan Peserta");
        menuLaporan.add(miLaporanPeserta);

        miLaporanPendaftaran.setText("Laporan Pendaftaran");
        menuLaporan.add(miLaporanPendaftaran);

        jMenuBar1.add(menuLaporan);

        menuKeluar.setForeground(new java.awt.Color(255, 255, 255));
        menuKeluar.setText("Keluar");
        menuKeluar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        miLogout.setText("Logout");
        menuKeluar.add(miLogout);

        separator.setText("separator");
        menuKeluar.add(separator);

        miTutup.setText("Tutup");
        menuKeluar.add(miTutup);

        jMenuBar1.add(menuKeluar);

        miTentang.setForeground(new java.awt.Color(255, 255, 255));
        miTentang.setText("Tentang Aplikasi");
        miTentang.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jMenuBar1.add(miTentang);

        miRefresh.setForeground(new java.awt.Color(255, 255, 255));
        miRefresh.setText("Refresh");
        miRefresh.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jMenuBar1.add(miRefresh);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 393, Short.MAX_VALUE)
                .addComponent(lblUser)
                .addGap(18, 18, 18)
                .addComponent(lblRole)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUser)
                    .addComponent(lblRole))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miPendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPendaftaranActionPerformed
        JOptionPane.showMessageDialog(this,
            "Modul Pendaftaran sedang dikembangkan pada tahap project berikutnya.");
    }//GEN-LAST:event_miPendaftaranActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUser;
    private javax.swing.JMenu menuKeluar;
    private javax.swing.JMenu menuLaporan;
    private javax.swing.JMenu menuMaster;
    private javax.swing.JMenu menuTransaksi;
    private javax.swing.JMenuItem miInstruktur;
    private javax.swing.JMenuItem miKelas;
    private javax.swing.JMenuItem miKursus;
    private javax.swing.JMenuItem miLaporanPendaftaran;
    private javax.swing.JMenuItem miLaporanPeserta;
    private javax.swing.JMenuItem miLogout;
    private javax.swing.JMenuItem miPembayaran;
    private javax.swing.JMenuItem miPendaftaran;
    private javax.swing.JMenuItem miPeserta;
    private javax.swing.JMenu miRefresh;
    private javax.swing.JMenu miTentang;
    private javax.swing.JMenuItem miTutup;
    private javax.swing.JPopupMenu popupDashboard;
    private javax.swing.JMenuItem separator;
    // End of variables declaration//GEN-END:variables
}
