package Section13_CollectionFrameworkProjects.udemyCoursePlayer.project;

public class Ders {
    private int dersNo;
    private String dersBaslik;
    private double dakika;

    public Ders(){} // parametresiz constructor

    public Ders(int dersNo, String dersBaslik, double dakika) {
        this.dersNo = dersNo;
        this.dersBaslik = dersBaslik;
        this.dakika = dakika;
    }

    public int getDersNo() {
        return dersNo;
    }

    public String getDersBaslik() {
        return dersBaslik;
    }

    public double getDakika() {
        return dakika;
    }

    @Override
    public String toString() {
        return "Ders{" +
                "dersNo=" + dersNo +
                ", dersBaslik='" + dersBaslik + '\'' +
                ", dakika=" + dakika +
                '}';
    }
}