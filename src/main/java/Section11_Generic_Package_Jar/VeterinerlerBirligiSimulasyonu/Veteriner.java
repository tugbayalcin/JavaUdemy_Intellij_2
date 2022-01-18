package Section11_Generic_Package_Jar.VeterinerlerBirligiSimulasyonu;

import java.util.ArrayList;

public class Veteriner extends Kisi
{
    private String mezunOlduguOkul;
    private int calismaSuresi;
    private ArrayList<Musteri> veterinerMusterileri;
    // veterinerlere musteri verdim ama sadece declaration, constructor icinde initialize etmeliyim
    // private oldugu icin ekleme cikarma yapabilmek icin disariya acilan bir public method tanimlamaliyim
    private int musteriSayisi;

    public Veteriner(String isim, String tcKimlik,String mezunOlduguOkul, int calismaSuresi) {
        super(isim, tcKimlik);
        this.mezunOlduguOkul = mezunOlduguOkul;
        this.calismaSuresi = calismaSuresi;
        veterinerMusterileri = new ArrayList<>();
        musteriSayisi = 0;
    }

    public void musteriEkle(Musteri musteri)
    {
        veterinerMusterileri.add(musteri);
        musteriSayisi++;
    }
    public void musterileriListele()
    {
        System.out.println(getIsim() + " kisisinin musterileri.");
        for (Musteri m:veterinerMusterileri)
        {
            m.kendiniTanit();
        }
        System.out.println();
    }

    @Override
    void kendiniTanit()
    {
        System.out.println(toString() + "Ben bir veterinerim.");
    }

    @Override
    public String toString() {
        return super.toString() + "Veteriner{" +
                "mezunOlduguOkul='" + mezunOlduguOkul + '\'' +
                ", calismaSuresi=" + calismaSuresi +
                '}';
    }
}
