package Section11_Generic_Package_Jar.VeterinerlerBirligiSimulasyonu;

public class Kopek extends Hayvan
{
    private int asiSayisi;
    private String tur;
    private String cins;

    public Kopek(String dogumTarihi, boolean kayitli, int asiSayisi, String cins) {
        super(dogumTarihi, kayitli);
        this.asiSayisi = asiSayisi;
        this.tur = "Kopek";
        this.cins = cins;
    }

    @Override
    void bilgileriGoster()
    {
        System.out.println(toString() + " " + super.toString()); // ilk to string bu classtaki verileri getiri, ikincisi ise super classtakileri getirir
    }

    public int getAsiSayisi() {
        return asiSayisi;
    }

    public void setAsiSayisi(int asiSayisi) {
        this.asiSayisi = asiSayisi;
    }

    @Override
    public String toString() {
        return "Kopek{" +
                "asiSayisi=" + asiSayisi +
                ", tur='" + tur + '\'' +
                ", cins='" + cins + '\'' +
                '}';
    }
}
