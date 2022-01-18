package Section11_Generic_Package_Jar.VeterinerlerBirligiSimulasyonu;

public class Kedi extends Hayvan
{

    private String tur; // zaten kedi classinda oldugumuz icin kullanicin gelip buraya kedi yazmasina gerek yok, o zaman constructor ında kendimiz tanimlayabiliriz ve parametre kismina eklemeyiz
    private String cins;

    // ust sinifin constructor iyla uyumlu constructor
    public Kedi(String dogumTarihi, boolean kayitli, String cinsi) {
        super(dogumTarihi, kayitli);
        this.tur = "Kedi";
        this.cins = cinsi;
    }

    // super classin override etmek zorunda oldugum methodu
    @Override
    void bilgileriGoster()
    {
        System.out.println(toString() + " kayitli mi:" + isKayitli() + " Dogum Tarihi:" + getDogumTarihi());
    }

    @Override
    public String toString() {
        return "Kedi{" +
                "tur='" + tur + '\'' +
                ", cins='" + cins + '\'' +
                '}';
    }
}
