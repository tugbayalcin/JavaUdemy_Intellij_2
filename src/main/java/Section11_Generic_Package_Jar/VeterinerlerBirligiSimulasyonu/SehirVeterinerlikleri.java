package Section11_Generic_Package_Jar.VeterinerlerBirligiSimulasyonu;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SehirVeterinerlikleri
{
    private String sehir;
    private int toplamVeterinerSayisi;
    private ArrayList<Veteriner> sehirdekiVeterinerler;

    public SehirVeterinerlikleri(String sehir) {
        this.sehir = sehir;
        sehirdekiVeterinerler = new ArrayList<>();
        toplamVeterinerSayisi = 0;
    }

    public void sehireVeterinerEkle(Veteriner veteriner)
    {
        sehirdekiVeterinerler.add(veteriner);
        toplamVeterinerSayisi++;
    }
    public void sehirdekiToplamVeterinerSayisiniBul()
    {
        System.out.println("Toplam veteriner sayisi:" + sehirdekiVeterinerler.size());
    }

    public void veterinerleriListele()
    {
        System.out.println(sehir + " sehrindeki veterinerler:");
        for (Veteriner v:sehirdekiVeterinerler)
        {
            v.kendiniTanit();
        }
        System.out.println();
    }
}
