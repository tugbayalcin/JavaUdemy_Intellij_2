package Section12_CollectionFramework.Sets;

import java.util.*;

public class C131_SetSiniflari
{
    public static void main(String[] args) {

        // bazen verilerimizi listemiz icerisinde unique olarak yani tekrarsiz olarak saklamak isteyebiliriz
        // bu gibi durumlarda Set yapisindan faydalaniriz
        // matematikteki kumeler gibi dusunebiliriz
        // ayni olan elemanin tekrar kumeye yazilmasina izin verilemz, zaten o elemandan kumede bir tane vardir
        // Set yapisi yalnizca KEY'leri saklayan ozel bir HashMap'dir
        // random access yoktur. Yani git bana suradaki elemani getir diyemiyoruz
        // bir elemana erismek istiyorsak gezintiye cikmamiz gerekiyor

        // Set bir interface oldugu icin onu implement etmis somut siniflar araciligi ile kullanabiliyorduk
        // Set icin 3 farkli somut class karsimiza cikiyor
        // 1. HashSet : HashMap'de oldugu gibi, amacim yalnizca elemanlari saklamak ve tekrarsiz olmasini saglamak
        // 2. LinkedHashSet: LinkedHashMap'de oldugu gibi elemanlar ekleme sirasina gore unique olarak listelenir
        // 3. TreeSet: TreeMap'de oldugu gibi ozel bir siralama ile listelemek istedigimizde kullanilir
        // Yapilar Map ile tamamen benzerlik gosteriyor
        // tree'lerde elemanlar null olarak saklanamaz, cunku null baska bir seyle karsilastirilamaz dolayisiyla hata verir



        // ====== HashSet =====
        HashSet<String> harfler = new HashSet<>();
        // burada Map'lerdeki gibi key ve value yok
        // yalnizca key var ve
        // biz generik olarak hangi veri tipinin unique olmasini istiyorsak,
        // tekrarsiz olmasini istiyorsak buraya o veri tipinin Class'ini belirtiyoruz

        // Constructor'larina bakacak olursak:
        // initial capacity'nin ve load factor'un burada da oldugunu goruruz
        harfler.add("a");
        harfler.add("d");
        harfler.add("c");
        harfler.add("d");
        harfler.add("2");
        harfler.add("e");
        harfler.add("a");
        harfler.add("d");
        harfler.add("d");

        System.out.println(harfler); // [a, 2, c, d, e]
        // atama sirasina gore degil debug'da gordugun table yapisinin hiyerarsisine gore yazdiriliyor
        // bir nevi indise gore yazdiriliyor
        // ayni indisi paylasanlar da, o indise once hangi eleman geldiyse o siraya gore yazdiriliyor
        // keyleri tutuyor dedik ama yine arka planda bu key'lerin value karsiligi olarak bos bir object ataniyor
        // documantasyonu inceleyerek bu bilgiye erisebilirsin

        // yani aslinda Set yapisi herhangi bir value'su olmayan
        // ya da tum value'leri ayni ve bos bir obje olan bir HashMap'den baska bir sey degildir


        // ====== LinkedHashSet =====
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("a");
        linkedHashSet.add("d");
        linkedHashSet.add("c");
        linkedHashSet.add("d");
        linkedHashSet.add("2");
        linkedHashSet.add("e");
        linkedHashSet.add("a");
        linkedHashSet.add("d");
        linkedHashSet.add("d");

        System.out.println(linkedHashSet); // [a, d, c, 2, e]
        // elemanlar ekleme sirasina gore unique olarak listelenecek

        // Set yapisi da Collection'dan turedigi icin collection'daki methodlar kullanilabilir
        // String[] geciciDizi = (String[]) linkedHashSet.toArray(); // Set yapimizi array'e dondurur ancak cast yapmak gerekir
        // System.out.println(Arrays.toString(geciciDizi));
        // exception aldik : ClassCastException, yani cast yapamadi
        // Cunku toArray() methodu geriye object donduruyor
        // Bundan dolayi gecici array'imizin tipini object yapalim
        Object[] geciciDizi = (Object[]) linkedHashSet.toArray();
        System.out.println(Arrays.toString(geciciDizi));


        // ====== TreeSet =====
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("a");
        treeSet.add("1");
        treeSet.add("d");
        treeSet.add("c");
        treeSet.add("d");
        treeSet.add("2");
        treeSet.add("z");
        treeSet.add("e");
        treeSet.add("a");
        treeSet.add("d");
        treeSet.add("d");

        System.out.println(treeSet); // [1, 2, a, c, d, e, z]  --> String oldugu icin natural order yapti
        // rakamlarin unicode degerleri harflerden daha kucuk oldugu icin en basa olnlar yazildi

        // iterator kullanarak set yapisini gezmeyi deneyelim
        Iterator<String> iterartor = treeSet.iterator();
        while(iterartor.hasNext())
        {
            System.out.println(iterartor.next());
        }






    }
}
