package Section12_CollectionFramework;

import java.util.*;

public class C02_ArrayListKavrami
{
    public static void main(String[] args)
    {
        // java.util altinda bulunuyor, hemen import edildi

        // Bellekte 10 tane eleman tutan bir ArrayList olusturur
        ArrayList <Integer> sayilar = new ArrayList<>(); // Burada olusan Arrayin bboyutu default olarak 10'dur.
        sayilar.add(1);
        sayilar.add(2);
        sayilar.add(3);

        // verdiginiz deger kadar eleman tutacak bir ArrayList olusturur
        ArrayList <String> isimler = new ArrayList<>(1000);
        isimler.add("tugba");
        isimler.add("asel");
        isimler.add("emre");

        // arrayListi verilen sayi kadar eleman tutacak sekilde arttirir (performans iyilestirme adina kullanilir)
        isimler.ensureCapacity(100); // ben sana kapasite vermemistim sen 10 ile basladin ama benim daha
                                                // cook elemanim var ekleyecek,sen performanstan dusme ve kendini simdiden hazirla

        // arrayList'i sadece icindeki elemanlari tutacak sekilde kucultur, ensureCapacity'nin tam tersi
        isimler.trimToSize(); //

        // Burada gorecegiz ki isimler listesindeki elemanlar isimlerYedek listesine atandi, biz hic eleman eklememistik
        ArrayList<String> isimlerYedek = new ArrayList<>(isimler);
        System.out.println(isimlerYedek);

        // eleman sayisini gosterir
        System.out.println(isimlerYedek.size());

        // listenin bos olup olmadigini soyler, bos ise true dondurur
        System.out.println(isimlerYedek.isEmpty());

        // tum listeyi siler, temizler
        isimlerYedek.clear();
        System.out.println(isimlerYedek.isEmpty()); // artik turue degerini verecek

        // verilen elemanin listemizde bulunup bulunmadigini kontrol eder
        System.out.println(isimler.contains("tugba"));
        System.out.println(isimler.contains("merve"));

        // arraylistimi bir arraya donusturur
        String[] isimlerDizisi = (String[]) isimler.toArray(new String[0]); // arraylistimi bir arraya donusturur
        System.out.println(isimlerDizisi[1]);

        // belirli indexteki elemani okumak
        System.out.println(isimler.get(0));

        // belirli indekteki elemani guncellemek
        isimler.set(0,"yeni tugba"); // once degistirdim
        //System.out.println(isimler.set(0,"yeni tugba")); // dersem once yazar sonra degistirir
        System.out.println(isimler.get(0)); // sonra yazdirdim

        // belirli bir indekse eleman yerlestirmek (eklemek, degistirmek degil)
        isimler.add(2,"boru");
        System.out.println(isimler);

        // belirli bir indeksteki elemani silmek
        isimler.remove("yeni tugba"); // 1.yol: direk elemani verdim
        isimler.remove(2); // 2.yol: indexi verdim --> olmayan index verirsen hata alirsin
        // dikkat !! yeni tugba elemanini cikardiktan sonra listem artik 3 elemanli yani son indexi 2
        System.out.println(isimler);
        isimler.add("Mirnav");
        isimler.add("Lokum");
        isimler.add("Pamuk");
        isimler.add("Pekmez"); // buradaki add, ArrayList teki add
        System.out.println(isimler);

        // belirli indeksler arasindaki elemanlari yeni bir listeye atamak
        //! ArrayList<String> yeniIsimlerListesi = isimler.subList(1,3); // boyle yazdigimda hata veriyor, detayli inceleme yap, uzerine gel
        // kuyllandigim methodun parametrelerini ve geris donus tipini incele ve sorunu bbul
        // subList methodu geriye String tutunde bir liste donduruyormus
        // Bu yazdigimiz kodda geriye donecek olan sey bir list (esitligin sag tarafi)
        // ve biz bunu bir arrayList e atamaya calisiyoruz(esitligin sol tarafi) o yuzden hata aliyoruz
        List<String> yeniIsimlerListesi = isimler.subList(1,3);  // ust sinif nesnesine alt sinif nesnesi baglamak gibi
        // list bir interface dir
        // Bu methodun boyle yazilmasinin sebebi;
        // ArrayList gibi LinkedList benzeri baska interfaceler de vardir
        // Bunlarin hepsi List interfaceinin alt interfaceleridir
        // Bu method List interfaceinden implemente edilen tum interfacelerce kullanilabilisin diye,
        // daha genel bir ifade olmasi adina bu sekilde bir geri donus tipi belirlenmis
        yeniIsimlerListesi.add("Minnos"); // Buradaki add, List interfaceindeki add
        // yeni olusan liste ile yine ayni methodlari kullanabilirim ancak bu liste kesinlikle bir ArrayList tir diyemem,
        System.out.println(yeniIsimlerListesi);

        // iki listeyi birlestirmek, belirli bir indeksten sonra birlestirmek
        ArrayList<String> erkekIsimleri = new ArrayList<>();
        erkekIsimleri.add("emre");
        erkekIsimleri.add("ahmet");
        ArrayList<String> kadinIsimleri = new ArrayList<>();
        kadinIsimleri.add("tugba");
        kadinIsimleri.add("zeynep");
        erkekIsimleri.addAll(kadinIsimleri); // en sona ekleyecek
        System.out.println(erkekIsimleri);
        erkekIsimleri.addAll(0,kadinIsimleri); // verdigimiz indekse ekleyecek
        System.out.println(erkekIsimleri);

        // arrayi listeye donusturmek
        String[] sehirler = {"Istanbul","Izmir","Ankara"};
        System.out.println(sehirler); // dizi oldugu icin hashcode yazdirir
        ArrayList<String> sehirlerliste;
        Arrays.asList(sehirler); // bu method geriye bir liste dondurur
        // ben bu listeyi alip sehirlerListe ye atayabilir miyim bakalim:
        // sehirlerliste = Arrays.asList(sehirler); // hata verdi
        // o zaman sehirlerList i ArrayList yerine List seklinde tanimlasam
        List<String> sehirlerliste2 = Arrays.asList(sehirler); // hata yok :) harika
        System.out.println(sehirlerliste2);

        ArrayList<String> sehirler2 = new ArrayList<>(Arrays.asList(sehirler)); // constructor icine liste yazdik,
        // artik listemiz bir arrayList oldu
        System.out.println(sehirler2);

        List<String> sehirler3 = new ArrayList<>(); // ust sinif degiskenini alt sinif nesnesine bagladik, polymorphism, yalnizca List in methodlarina erisebilecek
        Collections.addAll(sehirler3,sehirler); // sehirleri, sehirler3 e ekleyecek
        System.out.println(sehirler3);

        // Dokumantasyonundan buna ve daha pek cok bilgiye ulasabilirsin
        // Mesela ArrayList parametre kabul eden bir constructora sahiptir
        // ArrayList baska bir ArrayList'i parammetre olarak alabilir (Bunlari hep dokumantasyondan ogreniyoruz)

    }
}
