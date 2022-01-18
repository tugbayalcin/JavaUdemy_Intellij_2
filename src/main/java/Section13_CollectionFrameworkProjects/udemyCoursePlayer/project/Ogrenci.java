package Section13_CollectionFrameworkProjects.udemyCoursePlayer.project;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ogrenci extends Kisi
{
    private ArrayList<Kurs> katildigiKurslar;
    private LinkedList<Ders> izlenecekDersListesi;

    // Kisi class'inin parametreli constructor'ini kullanarak bir Ogrenci constructor'i olusturalim
    public Ogrenci(String isim, String tanitimYazisi, String kullaniciAdi) {
        super(isim, tanitimYazisi, kullaniciAdi); //bu satirda ust sinifin constructor'i calisiyor
        katildigiKurslar = new ArrayList<>();
        izlenecekDersListesi = new LinkedList<>();

    }

    public LinkedList<Ders> getIzlenecekDersListesi() {
        return izlenecekDersListesi;
    }

    @Override
    public String toString() {
        return super.toString() + "Ogrenci{" +
                "katildigimKurslar=" + katildigiKurslar +
                '}';
    }

    public void kursaKatil(Kurs katilinacakKurs)

    {
        if(!katilinacakKurs.getKursOgrencileri().contains(this)) {
            if (katilinacakKurs.kursYayindaKontrol()) // boolean degerler icin kosul yazmamiza gerek yoktu, remember
            {
                katilinacakKurs.getKursOgrencileri().add(this);
                this.katildigiKurslar.add(katilinacakKurs); // buraya da eklemeliyiz ki kodumuz tutarli olsun
                // hoca bu satirda this kullanmadi ama ben kullanma geregi hissettim
                System.out.println(this.getIsim() + " kullanicisi " + katilinacakKurs.getKursAdi() + " isimli kursa katildi.");
            } else {
                System.out.println(katilinacakKurs.getKursAdi() + " isimli kurs yayinda olmadigi icin katilamazsiniz.");
            }
        }
        else
        {
            System.out.println(katilinacakKurs.getKursAdi() + " isimli kursa daha onceden katilmissiniz. Tekrar katilamazsiniz");
        }
    }

    public void izlenecekDersEkle(Ders izlenecekDers)
    {
        // burada oncelikle izlenecekDers bir kursta var mi
        // ve de ogrenci o kursa katildi mi kontrollerini yapmaliyiz
        if(katildigiKurslar.size()>0) // ogrencinin katildigi en az bir kurs varsa gel iceri gir
        {
            boolean dersBulundu = false;
            for (Kurs each : katildigiKurslar) // ogrencinin katildigi kurslari tek tek gez
            {
                if(each.getKurstakiDersler().contains(izlenecekDers)) // bu kurslardan herhangi biri izlenece dersi iceriyor mu bak
                {
                    izlenecekDersListesi.add(izlenecekDers); // iceriyorsa playList'e ekle
                    System.out.println("Izlenecekler Listesine "
                            + each.getKursAdi() + " isimli kursta bulunan "
                            + izlenecekDers.getDersBaslik() + " isimli ders basariyla eklendi."); // ve kullaniciya bir mesaj goster
                    dersBulundu = true; // ayni ders birden fazla kursta bulunabilecegi icin, bir kere bulundıgında eklemesi yeterli
                    break; // bulduktan sora gezmeye devam etmesine gerek yok, donguden cikilsin
                }
            }
            if(!dersBulundu) // ders bulundu true degil ise
            {
                System.out.println("Girilen ders kayitli kurslarinizda bulunamadi.");
            }
            // true olmasi durumunda zaten yukarida ekleme islemini yapip mesaj yazdirmistik
        }

    }
}
