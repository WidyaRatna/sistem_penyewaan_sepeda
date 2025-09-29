public class SepedaListrik extends Sepeda {
    private double kapasitasBaterai;

    public SepedaListrik(String idSepeda, double harga, int totalUnit, double kapasitasBaterai) {
        super(idSepeda, "Listrik", harga, totalUnit);
        this.kapasitasBaterai = kapasitasBaterai;
        this.kategori = "Sepeda Khusus"; // akses protected
    }

    @Override
    public void infoSepeda() {
        super.infoSepeda();
        System.out.println("Kapasitas Baterai: " + kapasitasBaterai + " Wh");
    }
}
