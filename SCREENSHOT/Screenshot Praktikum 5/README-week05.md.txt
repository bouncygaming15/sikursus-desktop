# Pertemuan 5 - Inheritance

Parent: Orang
Child: Peserta, Instruktur
Relasi: Peserta is-a Orang; Instruktur is-a Orang.

Yang saya pahami:
1. Field umum (id, nama, noHp) cukup ditulis sekali di Orang sehingga tidak duplikatif.
2. super(id, nama, noHp) memanggil constructor parent karena constructor tidak diwariskan;
   child tetap harus punya constructor sendiri.
3. Is-a memakai inheritance (Peserta is-a Orang), sedangkan has-a memakai field/object
   (Kelas memiliki Instruktur, bukan Kelas extends Instruktur).

Error yang saya temui dan cara memperbaikinya:
- "call to super must be first statement": memindahkan super(...) ke baris pertama constructor.
- "nama has private access in Orang": mengganti akses langsung dengan getNama() / super.getInfo().