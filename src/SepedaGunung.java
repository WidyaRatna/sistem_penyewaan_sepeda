public class SepedaGunung extends Sepeda {
    private boolean suspensi;

    // Constructor: memanggil constructor superclass
    public SepedaGunung(String idSepeda, double harga, int totalUnit, boolean suspensi) {
        super(idSepeda, "Gunung", harga, totalUnit);
        this.suspensi = suspensi;
        this.kategori = "Sepeda Khusus"; // akses protected dari superclass
    }

    @Override
    public void infoSepeda() { // Overriding method infoSepeda
        super.infoSepeda();
        System.out.println("Suspensi: " + (suspensi ? "Ya" : "Tidak"));
    }
}
