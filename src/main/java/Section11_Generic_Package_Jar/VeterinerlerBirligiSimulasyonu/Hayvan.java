package Section11_Generic_Package_Jar.VeterinerlerBirligiSimulasyonu;

abstract public class Hayvan // abstract classim
{

    // degiskenlerim
    private String dogumTarihi;
    private boolean kayitli;

    // constructorum
    public Hayvan(String dogumTarihi, boolean kayitli)
    {
        this.dogumTarihi = dogumTarihi;
        this.kayitli = kayitli;
    }
    // abstract class nesne uretemez peki oı zaman biz neden constructor tanimladik, alt siniflar kullanabilsin diyeee

    // getter ve setterlarim
    public String getDogumTarihi()
    {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public boolean isKayitli() {
        return kayitli;
    }

    public void setKayitli(boolean kayitli) {
        this.kayitli = kayitli;
    }

    // methodlarim
    @Override
    public String toString() {
        return "Hayvan{" +
                "dogumTarihi='" + dogumTarihi + '\'' +
                ", kayitli=" + kayitli +
                '}';
    }
    abstract void bilgileriGoster();
    // bu method abstract oldugu icin Hayvan classindan turetilen her nesne bu methodu override etmek zorunda

}
