package app;

import model.Instruktur;
import model.Kursus;
import model.Peserta;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class UjiValidasi {

    private interface Aksi {
        void jalankan();
    }

    public static void main(String[] args) {
        int pass = 0;
        int total = 9;

        pass += harusBerhasil("Peserta valid", () -> {
            Peserta peserta = new Peserta(1, "Alya", "081234567890", "252001", "Informatika");
        });

        pass += harusBerhasil("Instruktur valid", () -> {
            Instruktur instruktur = new Instruktur(2, "Dina", "081211110001", "Java Desktop");
        });

        pass += harusDitolak("ID negatif", () -> {
            Peserta peserta = new Peserta(-1, "Alya", "081234567890", "252001", "Informatika");
        });

        pass += harusDitolak("Nama kosong", () -> {
            Peserta peserta = new Peserta(1, "", "081234567890", "252001", "Informatika");
        });

        pass += harusDitolak("No HP huruf", () -> {
            Peserta peserta = new Peserta(1, "Alya", "telepon", "252001", "Informatika");
        });

        pass += harusDitolak("NIM kosong", () -> {
            Peserta peserta = new Peserta(1, "Alya", "081234567890", "", "Informatika");
        });

        pass += harusDitolak("Prodi kosong", () -> {
            Peserta peserta = new Peserta(1, "Alya", "081234567890", "252001", "");
        });

        pass += harusDitolak("Keahlian kosong", () -> {
            Instruktur instruktur = new Instruktur(2, "Dina", "081211110001", "");
        });

        pass += harusDitolak("Biaya negatif", () -> {
            Kursus k = new Kursus();
            k.setBiaya(-100000);
        });

        System.out.println("\nHASIL: " + pass + "/" + total + " TEST PASS");
        if (pass != total) {
            throw new IllegalStateException("Masih ada test validasi yang gagal");
        }
    }

    private static int harusBerhasil(String nama, Aksi aksi) {
        try {
            aksi.jalankan();
            System.out.println("PASS | " + nama);
            return 1;
        } catch (RuntimeException ex) {
            System.out.println("FAIL | " + nama + " | " + ex.getMessage());
            return 0;
        }
    }

    private static int harusDitolak(String nama, Aksi aksi) {
        try {
            aksi.jalankan();
            System.out.println("FAIL | " + nama + " | input invalid tidak ditolak");
            return 0;
        } catch (IllegalArgumentException ex) {
            System.out.println("PASS | " + nama + " | DITOLAK: " + ex.getMessage());
            return 1;
        }
    }
}