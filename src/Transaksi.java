public class Transaksi {
    private String idTransaksi;
    private Pelanggan pelanggan;
    private Sepeda sepeda;
    private int durasiJam;
    private boolean selesai;

    // Constructor: membuat objek Transaksi baru dan langsung menandai sepeda sebagai 'dipinjam'
    public Transaksi(String idTransaksi, Pelanggan pelanggan, Sepeda sepeda, int durasiJam) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.sepeda = sepeda;
        this.durasiJam = durasiJam;
        this.selesai = false;
        this.sepeda.pinjam();
    }

    public String getIdTransaksi() { return idTransaksi; }
    public boolean isSelesai() { return selesai; } // Getter untuk status selesai

    // Method untuk proses pengembalian: cek status lalu kembalikan sepeda
    public void kembalikan() {
        if (!selesai) {
            sepeda.kembalikan();
            selesai = true;
        }
    }

    // Hitung biaya sewa berdasarkan durasi dan harga sepeda (menggunakan getter sepeda)
    public double hitungBiaya() {
        return durasiJam * sepeda.getHargaSewaPerJam();
    }

    // Tampilkan ringkasan transaksi ke console
    public void infoTransaksi() {
        System.out.println("Transaksi: " + idTransaksi);
        System.out.println("Pelanggan: " + pelanggan.getNama());
        System.out.println("Sepeda: " + sepeda.getJenis() + " (" + sepeda.getIdSepeda() + ")");
        System.out.println("Durasi: " + durasiJam + " jam");
        System.out.println("Total: Rp " + hitungBiaya());
        System.out.println("Status: " + (selesai ? "Selesai" : "Berjalan"));
    }
}
