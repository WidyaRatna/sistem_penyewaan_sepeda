public class Sepeda {
    private String idSepeda;
    private String jenis;
    private double hargaSewaPerJam;
    private int totalUnit;
    private int unitDipinjam;

    protected String kategori;

    // Constructor Overloading
    public Sepeda(String idSepeda, String jenis, double hargaSewaPerJam) {
        this(idSepeda, jenis, hargaSewaPerJam, 1);// memanggil constructor kedua
    }

    public Sepeda(String idSepeda, String jenis, double hargaSewaPerJam, int totalUnit) {
        this.idSepeda = idSepeda;
        this.jenis = jenis;
        this.hargaSewaPerJam = hargaSewaPerJam;
        this.totalUnit = totalUnit;
        this.unitDipinjam = 0;
        this.kategori = "Umum"; 
    }

    // (Encapsulation)
    public String getIdSepeda() { return idSepeda; }
    public void setIdSepeda(String idSepeda) { this.idSepeda = idSepeda; }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public double getHargaSewaPerJam() { return hargaSewaPerJam; }
    public void setHargaSewaPerJam(double hargaSewaPerJam) { this.hargaSewaPerJam = hargaSewaPerJam; }

    public int getTotalUnit() { return totalUnit; }
    public void setTotalUnit(int totalUnit) { this.totalUnit = totalUnit; }

    public int getUnitDipinjam() { return unitDipinjam; }
    public void setUnitDipinjam(int unitDipinjam) { this.unitDipinjam = unitDipinjam; }

    public int getUnitTersedia() { return totalUnit - unitDipinjam; }

    public void pinjam() {
        if (getUnitTersedia() > 0) unitDipinjam++; // hanya pinjam jika masih tersedia
    }

    public void kembalikan() {
        if (unitDipinjam > 0) unitDipinjam--; // hanya kembalikan jika ada yg dipinjam
    }

    // Polymorphism (bisa dioverride oleh subclass)
    public void infoSepeda() {
        System.out.println("ID: " + idSepeda);
        System.out.println("Jenis: " + jenis);
        System.out.println("Harga/jam: Rp " + hargaSewaPerJam);
        System.out.println("Total: " + totalUnit);
        System.out.println("Dipinjam: " + unitDipinjam);
        System.out.println("Tersedia: " + getUnitTersedia());
        System.out.println("Kategori: " + kategori);
    }
}
