import java.util.ArrayList;
import java.util.Scanner;

public class SistemPenyewaan {
    private ArrayList<Sepeda> daftarSepeda = new ArrayList<>();
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    // Overloading
    public void tambahSepeda(Sepeda sepeda) {
        daftarSepeda.add(sepeda);
    }

    public void tambahSepeda(String id, String jenis, double harga, int totalUnit) {
        daftarSepeda.add(new Sepeda(id, jenis, harga, totalUnit));
    }

    public void tampilkanSepeda() {
        for (Sepeda s : daftarSepeda) {
            s.infoSepeda();  // polymorphism → subclass override infoSepeda()
            System.out.println("----------------------");
        }
    }

    public Sepeda cariSepeda(String idSepeda) {
        for (Sepeda s : daftarSepeda) {
            if (s.getIdSepeda().equals(idSepeda)) {
                return s;
            }
        }
        return null;
    }

    public boolean hapusSepeda(String idSepeda) {
        Sepeda s = cariSepeda(idSepeda);
        if (s != null) {
            daftarSepeda.remove(s);
            return true;
        }
        return false;
    }

    public Transaksi sewaSepeda(String idTransaksi, Pelanggan pelanggan, String idSepeda, int durasiJam) {
        for (Sepeda s : daftarSepeda) {
            if (s.getIdSepeda().equals(idSepeda) && s.getUnitTersedia() > 0) {
                Transaksi t = new Transaksi(idTransaksi, pelanggan, s, durasiJam);
                daftarTransaksi.add(t);
                return t;
            }
        }
        System.out.println("Sepeda tidak tersedia!");
        return null;
    }

    public void kembalikanSepeda(String idTransaksi) {
        for (Transaksi t : daftarTransaksi) {
            if (t.getIdTransaksi().equals(idTransaksi) && !t.isSelesai()) {
                t.kembalikan();
                System.out.println("Sepeda berhasil dikembalikan!");
                return;
            }
        }
        System.out.println("Transaksi tidak ditemukan / sudah selesai!");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SistemPenyewaan sistem = new SistemPenyewaan();

        // Tambah data awal
        sistem.tambahSepeda(new SepedaGunung("S01", 15000, 5, true));
        sistem.tambahSepeda(new SepedaLipat("S02", 12000, 3, 11.5));
        sistem.tambahSepeda(new SepedaListrik("S03", 20000, 2, 500));

        int pilihan;
        do {
            System.out.println("\n=== MENU ADMIN PENYEWAAN SEPEDA ===");
            System.out.println("1. Lihat Daftar Sepeda");
            System.out.println("2. Tambah Sepeda Baru (Umum)");
            System.out.println("3. Input Transaksi Sewa");
            System.out.println("4. Lihat Semua Transaksi");
            System.out.println("5. Pengembalian Sepeda");
            System.out.println("6. Update Data Sepeda");
            System.out.println("7. Hapus Sepeda");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- Daftar Sepeda ---");
                    sistem.tampilkanSepeda();
                    break;

                case 2:
                    System.out.print("ID Sepeda: ");
                    String id = input.nextLine();
                    System.out.print("Jenis Sepeda: ");
                    String jenis = input.nextLine();
                    System.out.print("Harga Sewa/jam: ");
                    double harga = input.nextDouble();
                    System.out.print("Jumlah Unit: ");
                    int total = input.nextInt();
                    sistem.tambahSepeda(id, jenis, harga, total);
                    System.out.println("Sepeda berhasil ditambahkan!");
                    break;

                case 3:
                    System.out.print("Nama Pelanggan: ");
                    String nama = input.nextLine();
                    Pelanggan p = new Pelanggan("P" + (sistem.daftarTransaksi.size() + 1), nama);

                    System.out.println("\n--- Daftar Sepeda ---");
                    sistem.tampilkanSepeda();

                    System.out.print("Masukkan ID Sepeda yang ingin disewa: ");
                    String idSepeda = input.nextLine();

                    System.out.print("Durasi sewa (jam): ");
                    int durasi = input.nextInt();

                    String idTrans = "T" + (sistem.daftarTransaksi.size() + 1);
                    Transaksi t = sistem.sewaSepeda(idTrans, p, idSepeda, durasi);
                    if (t != null) {
                        System.out.println("Transaksi berhasil dibuat!");
                        t.infoTransaksi();
                    }
                    break;

                case 4:
                    System.out.println("\n--- Daftar Transaksi ---");
                    for (Transaksi tr : sistem.daftarTransaksi) {
                        tr.infoTransaksi();
                        System.out.println("------------------");
                    }
                    break;

                case 5:
                    System.out.print("Masukkan ID Transaksi untuk pengembalian: ");
                    String idT = input.nextLine();
                    sistem.kembalikanSepeda(idT);
                    break;

                case 6: // update data sepeda
                    System.out.print("Masukkan ID Sepeda yang ingin diupdate: ");
                    String idUpdate = input.nextLine();
                    Sepeda s = sistem.cariSepeda(idUpdate);
                    if (s != null) {
                        System.out.println("Data lama:");
                        s.infoSepeda();
                        System.out.print("Masukkan harga baru: ");
                        double hargaBaru = input.nextDouble();
                        System.out.print("Masukkan total unit baru: ");
                        int totalBaru = input.nextInt();
                        s.setHargaSewaPerJam(hargaBaru);
                        s.setTotalUnit(totalBaru);
                        System.out.println("Data sepeda berhasil diperbarui!");
                    } else {
                        System.out.println("Sepeda dengan ID tersebut tidak ditemukan!");
                    }
                    break;

                case 7: // hapus sepeda
                    System.out.print("Masukkan ID Sepeda yang ingin dihapus: ");
                    String idHapus = input.nextLine();
                    if (sistem.hapusSepeda(idHapus)) {
                        System.out.println("Sepeda dengan ID " + idHapus + " berhasil dihapus.");
                    } else {
                        System.out.println("Sepeda tidak ditemukan!");
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);

        input.close();
    }
}
