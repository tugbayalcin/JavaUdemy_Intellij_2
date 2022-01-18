package Section13_CollectionFrameworkProjects.sansliOnNumara.project;

import java.util.*;

public class Main
{
    // static HashMap<Integer,Integer> map = new HashMap<>();
    // class seviyesinde ve static olarak tanimladik ki class icinde olusturacagimiz tum methodlar icerisinden erisilebilsin
    // algoritmamiz gelissin diye bu kolay yolu kullanmayip, main icerisinde map'imizi tanimlayarak sorumuzu cozmeye devam edelim

    static final int URETILERCEK_SAYI_MAX_SINIR = 60;
    static final int URETILERCEK_SAYI_MIKTARI = 1000000;
    public static void main(String[] args) {

        Map<Integer,Integer> olusturulanSayilarMap = new HashMap<>(); // benim icin eklenme sirasi onemli olmadigi icin hashmap kullandim
        List<Integer> olusturulanSayiListesi = new ArrayList<>();
        Set<Integer> sansliOnSayi = new HashSet<>();

        mapiSayilarlaDoldur(olusturulanSayilarMap);
        mapiListeyeYazdir(olusturulanSayilarMap,olusturulanSayiListesi);
        sansliOnSayiyiBul(sansliOnSayi,olusturulanSayiListesi);

        System.out.println("Listenin Size'i: " + olusturulanSayiListesi.size()); // 1000000 cikiyor, beklenen de buydu
        System.out.println("Map Size: " + olusturulanSayilarMap.size()); // 60 cikiyor, beklenen de buydu zaten
        System.out.println("Set Size: " + sansliOnSayi.size()); // 10 cikiyor, beklenen de buydu zaten

        System.out.println("Sansli 10 Sayi: ");
        for (Integer each : sansliOnSayi)
        {
            System.out.print(each + ", ");
        }

        // sirali olarak gormek istersem
        // Collections.sort(sansliOnSayi); kullanamiyorum type'imi begenmiyor
        // ancak set yapimi hashSet olarak degil de treeSet olarak tanimlarsam
        // Set<Integer> sansliOnSayi = new TreeSet<>();
        // Integer wrapper class'inda compareTo() methodu override edildigi icin ozel bir sira ile yazdirilacaktir




    }

    private static void sansliOnSayiyiBul(Set<Integer> sansliOnSayi, List<Integer> olusturulanSayiListesi)
    {
        // burada istiyorum ki liste gezilsin ve bastan baslayarak sayilar tekrarsiz olarak tek tek listeye alinsin
        // ve 10 tane sayi alininca durulsun
        // yani 5 5 5 6 6 8 2 2 2 2 gibi bir listeden 5 6 8 2 gelsin ve buranin eleman sayisi 10 olunca dursun
        // bunu while dongusu ile set size'i 10 olana kadar yaptirabiliriz
        Collections.shuffle(olusturulanSayiListesi); // listeyi karistirdik
        while(sansliOnSayi.size()<10)
        {
            int rastgeleIndex = (int)(Math.random() * URETILERCEK_SAYI_MIKTARI); // +1 demeye gerek yok cunku 0. indexten baslayip 999999'a kadar gidecegiz zaten
            sansliOnSayi.add(olusturulanSayiListesi.get(rastgeleIndex)); // eklenecek sayilari da bastan itibaren degil, random olarak aldik
        }
    }

    private static void mapiListeyeYazdir(Map<Integer, Integer> olusturulanSayilarMap, List<Integer> olusturulanSayiListesi)
    {
        // oncelikle asagidaki for dongusu ile map'i gezlim    --> BU FOR ILE LISTE GEZILDI
        for(Map.Entry<Integer,Integer> each : olusturulanSayilarMap.entrySet())
        {
            int key = each.getKey(); // key =9 oldugunu dusunelim
            int value = each.getValue(); // value = 15 oldugunu dusunelim
            // 9 sayisinin 15 kere olusturuldugu anlamina geliyor
            // ve ben 9 sayisini 15 kere array'ime ekleyecegim

            for(int i=0; i<value; i++) // value sayisi kadar dongu donecek    --> BU FOR ILE LISTE DOLDURULDU
            {
                olusturulanSayiListesi.add(key); // her dondugunde key degerini array'e ekleyecek
            }
        }
    }

    private static void mapiSayilarlaDoldur(Map<Integer, Integer> olusturulanSayilarMap)
    {
        for(int i=0; i<URETILERCEK_SAYI_MIKTARI; i++)
        {
            int randomSayi = sayiOlustur(); // olusturulan sayi bir int degiskene atandi
            // burada uretilen sayilari map'e koymadan once kontrol yapmaliyim
            // bu sayi daha onceden map'e eklenmis mi bakmaliyim
            // cunku eklenmis ise son olusturdugumu eskisinin uzerine yazar ve bu benim isime yaramaz
            if(olusturulanSayilarMap.containsKey(randomSayi))
            {
                int value = olusturulanSayilarMap.get(randomSayi);
                // randomSayi key idi, get(key) dedigimizde value getiriliyordu
                // randomSayi key'i var ise bunun value'su de vardir ve ben bu value'yu getirip integer bir
                // variable'a atadim, cunku simdi onu +1 yapip geri atayacagim
                olusturulanSayilarMap.put(randomSayi,++value); // uzerine geri yazdi ama artik value artmis olarak geri yazildi
            }
            else
            {
                olusturulanSayilarMap.put(randomSayi,1);
            }
        }
    }
    private static int sayiOlustur()
    {
        // brn olsam uretilecek sayi max sinir'i final yapmam, methoda parammetre gecerim
        return ((int)(Math.random() * URETILERCEK_SAYI_MAX_SINIR) + 1);
        // 0-1 arasinda uretilen sayilari 60 ile carparak 59'a kadar uretilmesini sagladik ve
        // bu sayilar double oldugu icin integer'a casting yaptik
        // 0 uretirse  kabul etmeyecegimiz icin +1 ekledik
    }
    
}


