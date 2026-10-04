package app;
import java.util.ArrayList;
import model.Instruktur;
import model.Orang;
import model.Peserta;

public class DemoInheritance {
      public static void main(String[] args) {
        ArrayList<Orang> daftarOrang = new ArrayList<>();

        daftarOrang.add(new Peserta(
                1, "Mart Kellin", "081284405065",
                "2924017", "Informatika"));

        daftarOrang.add(new Peserta(
                2, "M Yawad Arrahman", "081233445466",
                "2924007", "Informatika"));

        Peserta pesertaUji = new Peserta(
                3, "Nama Lama", "081276542345",
                "2924031", "Informatika");
        // Setter milik parent tetap dapat digunakan oleh object Peserta.
        pesertaUji.setNama("Caesar Raja Yusri");
        daftarOrang.add(pesertaUji);

        daftarOrang.add(new Instruktur(
                101, "Ammar Husein", "081211110001",
                "Java Desktop"));

        daftarOrang.add(new Instruktur(
                102, "Rizal Maulana", "081211110002",
                "Data Science"));

        System.out.println("=== DATA SIKURSUS ===");
        daftarOrang.forEach((orang) -> {
            System.out.println(orang.getInfo());
          });

        System.out.println("Jumlah object: " + daftarOrang.size());
    }
}
