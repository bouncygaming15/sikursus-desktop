
package latihan;

/**
 *
 * @author USER
 */
public class LatihanBidangDatar {
    public static void main(String[] args) {
         String namaBidang = "Persegi Panjang";
        double panjang = 15.0;
        double lebar = 8.0;

        // Rumus Luas dan Keliling
        double luas = panjang * lebar;
        double keliling = 2 * (panjang + lebar);

        // Menampilkan Hasil
        System.out.println("=== Perhitungan Bidang Datar ===");
        System.out.println("Bidang Datar : " + namaBidang);
        System.out.println("Panjang      : " + panjang + " cm");
        System.out.println("Lebar        : " + lebar + " cm");
        System.out.println("Luas         : " + luas + " cm persegi");
        System.out.println("Keliling     : " + keliling + " cm");
}
}
