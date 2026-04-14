import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        mahasiswa[] mhs = new mahasiswa[3];
        mhs[0] = new mahasiswa("22001", "Andi", "Teknik Informatika");
        mhs[1] = new mahasiswa("22002", "Budi", "Teknik Informatika");
        mhs[2] = new mahasiswa("22003", "Citra", "Sistem Informasi Bisnis");

        buku[] buku = new buku[4];
        buku[0] = new buku("B001", "Algoritma", 2020);
        buku[1] = new buku("B002", "Basis Data", 2019);
        buku[2] = new buku("B003", "Pemrograman", 2021);
        buku[3] = new buku("B004", "Fisika", 2024);

        peminjaman[] pinjam = new peminjaman[5];
        pinjam[0] = new peminjaman(mhs[0], buku[0], 7);
        pinjam[1] = new peminjaman(mhs[1], buku[1], 3);
        pinjam[2] = new peminjaman(mhs[2], buku[2], 10);
        pinjam[3] = new peminjaman(mhs[2], buku[3], 6);
        pinjam[4] = new peminjaman(mhs[0], buku[1], 4);

        int pilih;
        do {
            System.out.println("\n=== Sistem Perpustakaan JTI ===");
            System.out.println("1. Data Mahasiswa & Buku");
            System.out.println("2. Data Peminjaman");
            System.out.println("3. Sorting Denda Terbesar");
            System.out.println("4. Searching Berdasarkan NIM");
            System.out.println("5. Rata-rata lama peminjaman");
            System.out.println("6. Keluar");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();

            switch (pilih) {

                case 1:
                    System.out.println("\nData Mahasiswa:");
                    for (int i = 0; i < mhs.length; i++) {
                        mhs[i].tampilMahasiswa();
                    }

                    System.out.println("\nData Buku:");
                    for (int i = 0; i < buku.length; i++) {
                        buku[i].tampilBuku();
                    }
                    break;

                case 2:
                    System.out.println("\nData Peminjaman:");
                    for (int i = 0; i < pinjam.length; i++) {
                        pinjam[i].tampilPeminjaman();
                    }
                    break;

                case 3:
                    // Insertion Sort - Descending Denda
                    for (int i = 1; i < pinjam.length; i++) {
                        peminjaman key = pinjam[i];
                        int j = i - 1;

                        while (j >= 0 && pinjam[j].denda < key.denda) {
                            pinjam[j + 1] = pinjam[j];
                            j--;
                        }
                        pinjam[j + 1] = key;
                    }

                    System.out.println("\nData setelah sorting (denda terbesar):");
                    for (int i = 0; i < pinjam.length; i++) {
                        pinjam[i].tampilPeminjaman();
                    }
                    break;

                case 4:
                    // Bubble Sort - Ascending NIM
                    for (int i = 0; i < pinjam.length - 1; i++) {
                        for (int j = 0; j < pinjam.length - i - 1; j++) {

                            int nim1 = Integer.parseInt(pinjam[j].mhs.nim);
                            int nim2 = Integer.parseInt(pinjam[j + 1].mhs.nim);

                            if (nim1 > nim2) {
                                peminjaman temp = pinjam[j];
                                pinjam[j] = pinjam[j + 1];
                                pinjam[j + 1] = temp;
                            }
                        }
                    }

                    System.out.print("Masukkan NIM yang dicari: ");
                    int cari = sc.nextInt();

                    // Binary Search
                    int left = 0;
                    int right = pinjam.length - 1;
                    boolean ketemu = false;

                    while (left <= right) {
                        int mid = (left + right) / 2;

                        int nimMid = Integer.parseInt(pinjam[mid].mhs.nim);

                        if (nimMid == cari) {
                            pinjam[mid].tampilPeminjaman();
                            ketemu = true;
                            break;
                        } else if (nimMid < cari) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }

                    if (!ketemu) {
                        System.out.println("Data tidak ditemukan!");
                    }
                    break;

                case 5 :
                    int total = 0;
                    for (int i = 0 ; i < pinjam.length ; i++) {
                        total += pinjam[i].lamaPinjam;
                    }

                    int rata = total/pinjam.length;

                    System.out.println("Rata - rata lama peminjaman = "+rata+" hari");
            }
        } while (pilih != 6);
    }
}