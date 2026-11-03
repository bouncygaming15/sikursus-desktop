package model;

public class Peserta extends Orang {

    private String nim;
    private String jenisKelamin;
    private String prodi;
    private String email;

    public Peserta() {
        super();
    }

   public Peserta(String nim, String nama, String jenisKelamin,
               String prodi, String noHp, String email) {
    super();
    setNama(nama);
    setNoHp(noHp);
    this.nim = nim;
    this.jenisKelamin = jenisKelamin;
    this.prodi = prodi;
    this.email = email;
}

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }

    public String getProdi() { return prodi; }
    public void setProdi(String prodi) { this.prodi = prodi; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}