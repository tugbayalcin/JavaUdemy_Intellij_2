package Section12_CollectionFramework.Maps.treeMap;

import java.util.Comparator;
import java.util.TreeMap;

public class C130_TreeMapAndRedBlackTree
{
    public static void main(String[] args) {

        // HashMap: key-value olarak verileri saklar
        // LinkedHashMap: ek olarak ekleme sirasina gore goruntuleme saglar
        // TreeMap: verileri ekleme sirasina gore degil de ozel bir siraya gore saklayabilmemizi saglar

        // TreeMap, AbstarctMap class'ini extend eder; NavigableMap, Clonable ve Serializable inetrface'lerini implement eder
        // AbstractAMp de Map interface'ini implement eder. Yani  Map'de tanimlanan methodlar burada da kullanilabilir
        // O halde TreeMap'i farkli kilan ozellikler  NavigableMap, Clonable ve Serializable inetrface'lerinden gelir
        // NavigalbeMap --> LowerEntry --> LowerKey: Parametre olarak verilen key'den daha kucuk olan keyleri entry seklinde verir
        // System.out.println(kareStringTreeMap.lowerKey(k1));
        // NavigalbeMap --> HigherEntry --> HigherKey: Parametre olarak verilen key'den daha buyuk olan keyleri entry seklinde verir
        // System.out.println(kareStringTreeMap.higherKey(k1));

        TreeMap<String,Integer> treeMap = new TreeMap<>();
        // constructor parametrelerine baktigimiz zaman;
        // 1. bir map'i parametre olarak alabildigini goruyoruz
        // bunu kullandigimizda parametre olarak verdigimiz map'deki veriler SIRALANARAK treeMap objesine eklenir
        // burada siralamadan bahsettigimiz icin hemen aklimiza Comparable-Comparator gelmeli
        // Dolayisiyla Wrapper classlar ve String class'i zaten Comparable'i implement ettigi icin bir sorun olmazken

        // Kendi olusturdugumuz classlarda da Comparable-Comparator interface'lerinden ihtiyacimiz olani implement etmeliyiz
        // 2.


        treeMap.put("emre", 1);
        treeMap.put("hasan", 2);
        treeMap.put("ayse", 3);
        treeMap.put("ali", 4);

        // treemap'i okumak icin for/foreach/iterator 'dan birini kullanabiliriz
        System.out.println(treeMap); // bununla da sirali yazdirabiliriz
        // harta almadik cunku keylerimiz String ve String class'i Comparable interface'ini implement ediyordu zaten

        // Buranin arka yapisi HashMap ve LinkedHashMap'ten tamamen farkli :(

        // simdi oncelijkle kendi classimizi olusturalim.
        // Class'imiz 2 degiskeni olan bir kare olsun
        // Constructor ve toString ekleyelim
        // Simdi de bu class'i key type oarak kabul eden bir TreeMap olusturalim

        TreeMap<Kare, String> kareStringTreeMap = new TreeMap<>(new Comparator<Kare>() {
            @Override
            public int compare(Kare o1, Kare o2) {
                System.out.println("Comparator interface'inin compare() methodu calisti \nYani anonymous class calisti");
                if(o1.kenar < o2.kenar)
                    return -1;
                else if(o1.kenar > o2.kenar)
                    return 1;
                else
                    return 0;
            }
        });
        // kareden nesneler olusturalim ki map'e ekleyebilelim
        Kare k1 = new Kare(4, "Mavi");
        Kare k2 = new Kare(2,"Sari");
        Kare k3 = new Kare(6,"Yesil");

        kareStringTreeMap.put(k1, "mavi kare");
        kareStringTreeMap.put(k2, "sari kare");
        kareStringTreeMap.put(k3, "yesil kare");

        System.out.println(kareStringTreeMap);
        // burada exception veriyor cunku treeMap siralama yapardi ancak burada nete gore siralama yapacagini bilmiyor
        // ve biz comparable interface'ini class'imizda impement etmedik

        // Burada 2 cozum yolu uygulayabiliriz
        // 1) treeMap olusturuken constructor parametresi olarak COMPARATOR interface'ini kullanan bir sinif gecebiliriz
        // sirf bu islem icin bir class olusturmaya gerek yok, bunun herine anonymous class'lardan faydalanabiliriz
        // simdi yukariya gidip bu 1. yolu uygulayalim
        // ardindan da yazdirmayi deneyelim
        // 2) dogrudan Kare sinifina gidip COMPARABLE interface'ini implement edebiliriz

        // su an biz her ikisini de yapmis olduk ve calistirinca ayni sonucu gorduk
        // peki hangisine gore calisti?
        // bunu anlamak icin Kare class'imdaki compareTo() methodunun icine sout ile bir not yazdirabilirim
        // benzer sekilde  anonymous class icine de bir not ekleyerek bunun yazdirailirim

        // anonymous class calisti
        // yani constructor(kurucuya)'a ne evrdiysek o calisti
        // anonymous class tanimlamamis olsaydik Kare class'inin implementasyonu calismis olacakti
        // inanmazsan gor de bak
        // ikisinden yalnzca birinin calisma sebebi de su:
        // ben anonymous icinde kenara gore, class sicindeki methodda renge gore siralama yapma algoritmasi yazmis olabilirdim
        // ve bu durumda compiler'in kafasi karisabilirdi, hangisini calistiracagini bilemezdi
        // bu yuzden guvene almak adina yalnizca bir tanesi calisir




    }
}
class Kare implements Comparable<Kare> // Buraya generic olarak kare vermezsen otomatik olarak object alir ve methodu
{                                      // override ederken gelen parametre ile kare nesnesindeki degiskenlere erisemem kirmizi yakar
    int kenar;
    String renk;

    public Kare(int kenar, String renk) {
        this.kenar = kenar;
        this.renk = renk;
    }

    @Override
    public String toString() {
        return "Kare{" +
                "kenar=" + kenar +
                ", renk='" + renk + '\'' +
                '}';
    }

    @Override
    public int compareTo(Kare o) {
        System.out.println("Comparable interface'inin compareTo() methodu calisti \nYani Kare classinin implementasyonu calisti");
        if(this.kenar < o.kenar)
            return -1;
        else if(this.kenar > o.kenar)
            return 1;
        else
            return 0;

    }
}
