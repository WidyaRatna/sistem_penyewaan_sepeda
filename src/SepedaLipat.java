public class SepedaLipat extends Sepeda {
    private double berat;

    public SepedaLipat(String idSepeda, double harga, int totalUnit, double berat) {
        super(idSepeda, "Lipat", harga, totalUnit); // panggil superclass
        this.berat = berat;
        this.kategori = "Sepeda Khusus"; // akses protected
    }

    @Override
    public void infoSepeda() {
        super.infoSepeda(); // panggil method superclass
        System.out.println("Berat: " + berat + " kg");
    }
}
