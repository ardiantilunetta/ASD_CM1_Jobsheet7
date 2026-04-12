public class mahasiswa {

    String nim, nama, prodi;
    mahasiswa (String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }
    void tampilMahasiswa() {
        System.out.println(nim + " | " + nama + " | " + prodi);
    }
}