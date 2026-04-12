public class peminjaman {
    mahasiswa mhs;
    buku buku;
    int lamaPinjam;
    int batasPinjam = 5;
    int terlambat;
    int denda;
    
    peminjaman(mahasiswa mhs, buku buku, int lamaPinjam) {
        this.mhs = mhs;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
        hitungDenda();
    }

    void hitungDenda(){
        if (lamaPinjam > batasPinjam) {
            terlambat = lamaPinjam - batasPinjam;
        } else {
            terlambat = 0;
        }

        denda = terlambat * 2000;
    }

    void tampilPeminjaman() {
        System.out.println(mhs.nim + " | " + mhs.nama + " | " + buku.judul + " | " + lamaPinjam + " hari | Terlambat: " + terlambat + " hari | Denda: " + denda);
    }

}
