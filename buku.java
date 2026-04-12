public class buku {

    String kodeBuku, judul;
    int tahunTerbit;
    buku (String kodeBuku, String judul, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }
    void tampilBuku() {
        System.out.println(kodeBuku + " | " + judul + " | " + tahunTerbit);
    }
}
