package Section13_CollectionFrameworkProjects.udemyCoursePlayer.project;

import java.util.ArrayList;

public class Kurs
{
    private String kursAdi;
    private ArrayList<Ders> kurstakiDersler;
    private ArrayList<Egitmen> kursEgitmenleri; // bir kursun birden fazla egitmeni olabiliyor, bu yuzden arrayList'te tutuyoruz
    private ArrayList<Ogrenci> kursOgrencileri;
    private boolean yayinda; // herhangi bir kursun toplam ders saati 1 saatten az ise yayinlanmasina izin verilmiyor
    // biz de burada ders sayisi en az 5 ve toplam icerik en az 60 dk olsun isteyelim

    public Kurs(){} // parametresiz constructor

    // burada tum egitmen isimlerini ve tum ders isimlerini tutan arrayler ile yayinda olup olmadigini almaya gerek yok
    // bu yuzden cıonstructor'i duzenliyorum
    // ve bu degiskenler henuz olusturulmadigi icin, parametre de alamadikalri icin onlari burada tanimliyorum
    // karsilarina new yazarak onlar icin bir obje olusturulmasini sagliyorum
    public Kurs(String kursAdi, Egitmen basEgitmen) {
        this.kursAdi = kursAdi;
        this.kurstakiDersler = new ArrayList<>();
        this.kursEgitmenleri = new ArrayList<>(); // arrayList tanimlandi
        this.kursOgrencileri = new ArrayList<>();
        // kursOgrencileri.add(basEgitmen); // her egitmen ayni zamanda bir ogrenci olabilir diyerek kalitim yapmistik
        // ancak bir egitmen kendi kursunun ogrencisi olamaz, bu yuzden burayi silelim
        kursEgitmenleri.add(0, basEgitmen); // basEgitmen array'e eklendi
        // bir kursun birden afzla egitmeni olabilirdi ancak bunlardan biri oncu digerleri yardimci olmali
        // oncu egitmeni basEgitmen olarak belirledik ve bu constructor ile List'e ekledik
        this.yayinda = false; // parametre almadigimşz icin degerini elimizle atadik

    }

    public ArrayList<Ogrenci> getKursOgrencileri() {
        return kursOgrencileri;
    }

    public String getKursAdi() {
        return kursAdi;
    }

    public ArrayList<Ders> getKurstakiDersler() {
        return kurstakiDersler;
    }

    public void kursaEgitmenEkle(Egitmen yeniEgitmen)
    {
        if(!kursEgitmenleri.contains(yeniEgitmen))
        {
            kursEgitmenleri.add(yeniEgitmen);
            System.out.println(yeniEgitmen.getIsim() + " kurs egitmeni olarak atandi.");
        }
        else
        {
            System.out.println(yeniEgitmen.getIsim() + " zaten kursta tanimli bir egitmendir.");
        }

    }

    public void kurstanEgitmenSil(Egitmen silinecekEgitmen) // belki yanlislikla ekledik
    {
        if(silinecekEgitmen.getIsim().equalsIgnoreCase(kursEgitmenleri.get(0).getIsim()))
        {
            System.out.println(silinecekEgitmen.getIsim() + " kursun bas Egitmeni oldugu icin silme islemi gerceklestirilemedi");
        }
        else
        {
            kursEgitmenleri.remove(silinecekEgitmen);
            System.out.println(silinecekEgitmen.getIsim() + " kurs egitmenliginden cikarildi.");
        }

    }

    public void kursaDersEkle(Ders eklenecekDers)
    {
        if(!kurstakiDersler.contains(eklenecekDers))
        {
            kurstakiDersler.add(eklenecekDers);
            System.out.println(eklenecekDers + " isimli ders kursa basariyla eklendi");
        }
        else
        {
            System.out.println(eklenecekDers + " isimli ders kursta zaten mevcuttur.");
        }

    }

    public void kurstanDersSil(Ders silinecekDers) // belki yanlislikla ekledik
    {
        if(kurstakiDersler.contains(silinecekDers))
        {
            kurstakiDersler.remove(silinecekDers);
            System.out.println(silinecekDers + " isimli ders kurstan basariyla silindi");
        }
        else
        {
            System.out.println(silinecekDers + " isimli ders kursta zaten mevcut degildir.");
        }

    }

    public int kurstakiDersSayisi()
    {
        return kurstakiDersler.size();
    }

    private int kurstakiToplamDerslerinDakikaSuresi()
    {
        // bu method yalnizca Kisi class'indaki memthodlar tarafindan kullanilabilsin diye private yaptik
        // cunku bu method ogrenci eklerken kullanilan bir yardimci method

        // foreach ile daha kolay yapabiliriz
        double toplamSure=0;
        /*
        for(int i=0; i<kurstakiDersler.size(); i++)
        {
            toplamSure += kurstakiDersler.get(i).getDakika();
        }
         */
        for (Ders ders : kurstakiDersler)
        {
            toplamSure += ders.getDakika();
        }
        return (int)toplamSure; // toplam sure double idi, biz int'e donusturerek return ediyoruz
                                // cunku bize lazim olan kusurat degil 60'dan buyuk olup olmadigi
    }

    public boolean kursYayindaKontrol()
    {
        // bu method yalnizca Kisi class'indaki memthodlar tarafindan kullanilabilsin diye private yaptik
        // cunku bu method ogrenci eklerken kullanilan bir yardimci method
        // edit: kursaKatil methodunu bu class'tan ogrenci class'ina tasidigimiz icin artik bu method private olamaz
        // yeniden public yaptik

        // kursa ogrenci ekleyebilmek icin, once kursun yayinda olup olmadigini kontrol etmemiz gerekiyor
        // bunun icin de kosullarin saglanip saglanmadigina bakalim
        if(kurstakiDersler.size() >= 5 && kurstakiToplamDerslerinDakikaSuresi() >= 60)
        {
            yayinda = true;
            // return true; hoca boyle yapti
        }
        //else return false; hoca boyle yapti
        // ben oyle yapmadim cunku constructor'da zaten yayinda=false olarak tanimlamistik, benimki daha kisa
        return yayinda;
    }

}
