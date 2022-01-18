package Section12_CollectionFramework.Lists.arrayList;

import java.util.*;
import java.util.ArrayList;
public class C119_ArrayListKavrami
{
    public static void main(String[] args)
    {
        // java.util altinda bulunuyor, hemen import edildi

        // Bellekte 10 tane eleman tutan bir ArrayList olusturur
        // bunu nereden ogrendik
        // eger ArrayList'in documantasyonuna gidersen
        // private static final int DEFAULT_CAPACITY = 10;
        // seklinde bir yapi goreceksin, buradan anliyoruz
        // yani bu demek oluyor ki documantasyon okursan java bilgin artar, guzellesir ve en dogru bilgiyi ogrenmis olursun
        // yine documantasyona baktigimizda, eleman sayisi vererek ArrayList olusturmamiza imkan veren bir Constructor oldugunu goruyoruz
        // Bir arrayList baska bir ArrayList'i parametre olarak alabilir (doc'dan ogrendik)

        ArrayList <Integer> sayilar = new ArrayList<>(); // Burada olusan Arrayin boyutu default olarak 10'dur.
        sayilar.add(1);
        sayilar.add(2);
        sayilar.add(3);

        // verdiginiz deger kadar eleman tutacak bir ArrayList olusturur
        ArrayList <String> isimler = new ArrayList<>(20);
        isimler.add("tugba");
        isimler.add("asel");
        isimler.add("emre");

        // simdi sunu deneyelim. Ben initial capacity vererek bir list olusturayim ve listime bu capacity'den daha afzla eleman eklemeye calisayim
        ArrayList<Integer> denemeList = new ArrayList<>(3);
        denemeList.add(1);
        denemeList.add(2);
        denemeList.add(3);
        System.out.println("3 elemanli olarak olusturdugum listemin boyutu: " + denemeList.size());
        denemeList.add(4);
        System.out.println("3 elemanli olarak olusturdugum listeme 3'den fazla eleman ekledigimde olusan yeni boyutu: " + denemeList.size());

        System.out.println(denemeList);   // hicbir sikinti cikarmadan 4. elemani da ekledi ve yazdirdi

        // arrayListi verilen sayi kadar eleman tutacak sekilde arttirir (performans iyilestirme adina kullanilir)
        isimler.ensureCapacity(100); // ben sana kapasite vermemistim sen 10 ile basladin ama benim daha
                                                // cook elemanim var ekleyecek,sen performanstan dusme ve kendini simdiden hazirla

        // arrayList'i sadece icindeki elemanlari tutacak sekilde kucultur, ensureCapacity'nin tam tersi
        isimler.trimToSize(); //

        // Burada gorecegiz ki isimler listesindeki elemanlar isimlerYedek listesine atandi, biz hic eleman eklememistik
        // Yani bir arrayList baska bir ArrayList'i parametre olarak alabilir
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
        System.out.println(Arrays.toString(isimlerDizisi)); // techproed'den ogrendigim array yazdirma methodu
        System.out.println(isimlerDizisi[1]); // udemy'de hoca for dongusu acmamak icin yalnizca bir elemaninin yazdirdi
        // ArrayList'te farkli veri tipleri tutabilecegim icin(cunku generic yaptik) burada compiler emin olmak istiyor
        // senin ArrayListin belki string degildir o yuzden dogrudan atama yapamam once casting yapalim diyor
        // ayrica burada hoca yaparken hata aldi ve parantez icine new yazmasi gerektigini internetten arastirarak buldu.
        // new demek yeni bir dizi olusturmak demek ve benim atama yapmak istedigim isimlerDizisi daha onceden new ile olusturulmamisti,
        // acaba bundan dolayi mi boyle bir kullanim gerekti, benim daha onceden initialize ettigim bir dizi bu yapida new demeden
        // kopyalama atamasini gerceklestirir miydi, simdi ona bakalim

        String[] initIsimDizisi = new String[isimler.size()]; // oncelikle kopyalamak istedigim listin boyutunda bir array tanimladim
         initIsimDizisi = (String[]) isimler.toArray(new String[0]); // casting ve atama yaptim veee hata cikmadi, yukaridaki islemin aynisi gerceklesti
        // burada bir sikinti var cozunce notunu dusecegim
        // cozum: aslında yukarida yapilan sey declaration ve initialization'di.
        // yani new kwlimwsi kullanmadan objeyi declare ettim ve atamasini yaptim.
        // parantez icindeki new baska bir eyrden geliyor, nereden geldigini ve neden gelmek zorunda oldugunu bilmiyorum
        // bundan dolayi ben asagida dizimi tek satirda new + constructor ile olustursam dahi
        // atama yaparken (String[]) isimler.toArray(new String[0]); ifadesini kullanmak zorunda kaliyorum
        // degisen tek sey benim array'i olusturma seklim olmus oluyor

        // =================== ARRAYLIST SINIFI BOLUM 2 =================== //

        // belirli indexteki elemani okumak
        System.out.println(isimler.get(0));

        // belirli indekteki elemani guncellemek
        isimler.set(0,"yeni tugba"); // once degistirdim
        // index 0'da bulunan elemani al ve onun yerine yeni tugba yaz demek
        //System.out.println(isimler.set(0,"yeni tugba")); // dersem once yazar sonra degistirir
        System.out.println(isimler.get(0)); // sonra yazdirdim

        // belirli bir indekse eleman yerlestirmek (eklemek, degistirmek degil)
        isimler.add(2,"boru");
        System.out.println(isimler);
        // boylece listede araya eleman eklemis olduk ve 2. indeksten itibaren eski elemanlarin hepsi kaydirildi

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
        // kullandigim methodun parametrelerini ve geris donus tipini incele ve sorunu bul
        // subList methodu geriye String tutunde bir liste donduruyormus List<String>, yani list donduruyor arraylist degil
        // bu yuzden dobnecek olan seyi bir arraylist'e atayamam, list'e atamam gerekir
        // Bu yazdigimiz kodda geriye donecek olan sey bir list (esitligin sag tarafi)
        // ve biz bunu bir arrayList e atamaya calisiyoruz(esitligin sol tarafi) o yuzden hata aliyoruz
        List<String> yeniIsimlerListesi = isimler.subList(1,3);  // ust sinif nesnesine alt sinif nesnesi baglamak gibi
        // list bir interface dir
        // Bu methodun boyle yazilmasinin sebebi;
        // ArrayList gibi LinkedList benzeri baska interfaceler de vardir
        // Bunlarin hepsi List interfaceinin alt interfaceleridir
        // Bu method List interfaceinden implemente edilen tum interfacelerce kullanilabilisin diye,
        // daha genel bir ifade olmasi adina bu sekilde bir geri donus tipi belirlenmis
        // yani substring methodu aslinda List interface'inin methoduymus ve
        // List'i extends eden her interface tarafindan override edilmek zorundaymis
        // Dolayisiyla birden fazla tipte yapi override edecegi icin geri donus tipinde stabilizasyon saglamak adina
        // List interface'i bu methodun geri donus type'ini List olarak yazmis
        // override isleminde return type ve signature degistirilemeyecegi icin bu methodu kullanan tum interface ve class'lar
        // geriye bir List dondurmek zorundadir.
        // Bundan dolayi bu method kullanilirken polymorphism'den yararlanilir

        yeniIsimlerListesi.add("Minnos"); // Buradaki add, List interfaceindeki add
        // yeni olusan liste ile yine ayni methodlari kullanabilirim ancak bu liste kesinlikle bir ArrayList tir diyemem,
        // hoca yukaridaki cumleyi kurdu ancak ben yeni olusan seyin artik bir List oldugunu bildigim icin ve polymorphism geregi
        // bu objenin yalnizca List'te olan elemanlara erisebilecegini bildigim icin soyle bir deneme yaptim
        // ArrayList'te olup da List'te olmayan bir methodu bu yeniIsimlerListesi'yle cagirip cagiramayacagima baktim
        // bunun icin trimToSize methodunu kullandim
        // ve cagiramadigimi gordum.
        // yani yeniIsimlerListesi yalnizca ve yalnizca List methodlarina erisebiliyor, ArrayList degil !!!
        // burasi artik bir List'tir
        // note: Ust sinifa donusturulurken dikkat edilmesi gereken sudur.
        // Ust sinifa donusturulen nesne kendi sinifindaki ozel methodlara erisemezler.
        // Sadece Override edilmis methodlara ve ust sinifin methodlarina erisebilirler.
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


        // arrayi LIST'e donusturmek
        String[] sehirler = {"Istanbul","Izmir","Ankara"};
        System.out.println(sehirler); // dizi oldugu icin hashcode yazdirir
        System.out.println(Arrays.toString(sehirler)); // simdi guzelce yazdiracak
        ArrayList<String> sehirlerliste;
        Arrays.asList(sehirler); // bu method geriye bir LISTE dondurur
        // ben bu listeyi alip sehirlerListe ye atayabilir miyim bakalim: (sehirlerliste bir ARRAYLIST)
        // sehirlerliste = Arrays.asList(sehirler); // hata verdi
        // o zaman sehirlerliste'yi ARRAYLIST yerine LIST seklinde tanimlasam
        List<String> sehirlerliste2 = Arrays.asList(sehirler); // hata yok :) harika
        System.out.println(sehirlerliste2);

        /*
        Yukarida new keywordunu ve constructor kullanmadan nasil atama yapilabildigi kismi kafama takildi
        Su ornege bakarsan daha rahat anlarsin

        Deneme dk1; // obje olusturuldu/declare edildi ama initialize edilmedi
        dk1 = null; // obje initialize edildi

        Deneme dk2 = new Deneme();  // obje declare ve initialize edildi

        Note :
        Yeni nesneleri oluşturmanın 3 yöntemi vardır :
        Declaration (Tanımlama) : bir değişkene tipi ve adıyla atar ya da tanımlarsınız
        Instantiation (Örneklem) : “new” kelimesini kullanarak
        Initialization (Sıfırlama, Çağırma) : constructor metodunu çağırırsınız
         */

        // array'i ARRAYLIST'e donusturmek
        // burada constructor kullanarak atadik
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
