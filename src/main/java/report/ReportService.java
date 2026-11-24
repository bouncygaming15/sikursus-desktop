package report;

import config.Database;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public final class ReportService {

    private ReportService() {}

    // ===== Pertemuan 12: laporan peserta =====
    public static void tampilkanLaporanPeserta() {
        try (Connection conn = Database.getConnection()) {
            InputStream in = ReportService.class.getResourceAsStream(
                "/report/laporan_peserta.jasper");
            if (in == null) {
                throw new IllegalStateException(
                    "File laporan_peserta.jasper tidak ditemukan di resource.");
            }
            JasperPrint print = JasperFillManager.fillReport(
                in, new HashMap<>(), conn);
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Gagal membuka laporan: " + e.getMessage(),
                "Laporan Peserta", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===== Pertemuan 13: laporan pendaftaran (parameter ID) =====
    public static void cetakPendaftaran(int idPendaftaran) {
        try (Connection conn = Database.getConnection();
             InputStream in = ReportService.class.getResourceAsStream(
                 "/report/laporan_pendaftaran.jasper")) {
            if (in == null) {
                throw new IllegalStateException(
                    "File laporan_pendaftaran.jasper tidak ditemukan");
            }
            Map<String, Object> params = new HashMap<>();
            params.put("P_ID_PENDAFTARAN", idPendaftaran);

            JasperPrint print = JasperFillManager.fillReport(in, params, conn);
            if (print.getPages().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                    "Data laporan tidak ditemukan.");
                return;
            }
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Gagal mencetak laporan: " + ex.getMessage());
        }
    }

    // ===== Pertemuan 13: cetak semua pendaftaran =====
    // Memakai laporan_pendaftaran.jasper yang sama. Data dikirim dari aplikasi (baris JTable)
    // lewat JRMapCollectionDataSource, jadi query WHERE/parameter pada report tidak dipakai
    // dan semua baris tampil dalam satu tabel.
    public static void cetakSemuaPendaftaran(List<Map<String, ?>> rows) {
        if (rows == null || rows.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Belum ada data pendaftaran.");
            return;
        }
        try (InputStream in = ReportService.class.getResourceAsStream(
                 "/report/laporan_pendaftaran.jasper")) {
            if (in == null) {
                throw new IllegalStateException(
                    "File laporan_pendaftaran.jasper tidak ditemukan");
            }
            JasperPrint print = JasperFillManager.fillReport(
                in, new HashMap<String, Object>(), new JRMapCollectionDataSource(rows));
            if (print.getPages().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data laporan tidak ditemukan.");
                return;
            }
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Gagal mencetak laporan: " + ex.getMessage());
        }
    }

    // ===== Pertemuan 13: laporan pembayaran (rentang tanggal) =====
    public static void cetakPembayaran(java.sql.Date awal, java.sql.Date akhir) {
        try (Connection conn = Database.getConnection();
             InputStream in = ReportService.class.getResourceAsStream(
                 "/report/laporan_pembayaran.jasper")) {
            if (in == null) {
                throw new IllegalStateException(
                    "File laporan_pembayaran.jasper tidak ditemukan");
            }
            Map<String, Object> params = new HashMap<>();
            params.put("P_TANGGAL_AWAL", awal);
            params.put("P_TANGGAL_AKHIR", akhir);

            JasperPrint print = JasperFillManager.fillReport(in, params, conn);
            if (print.getPages().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                    "Tidak ada transaksi pada rentang tanggal tersebut.");
                return;
            }
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Gagal mencetak laporan: " + ex.getMessage());
        }
    }
}