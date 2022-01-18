package Section12_CollectionFramework.Collections;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class C132_SortedAndNavigatorInterfaces
{
    public static void main(String[] args) {

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("1");
        treeSet.add("2");
        treeSet.add("3");
        treeSet.add("4");

        TreeMap<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("1",1);
        treeMap.put("2",2);
        treeMap.put("3",3);
        treeMap.put("4",4);

        // Set ve Map yapilarinin her ikisinin de implement ettigi Sorted interface'i vardir
        // Bu interface Map'de SortedMap, Set'de SortedSet olarak karsimiza cikar.


        // ===========================================================================
        //                  SORTEDSET VE SORTEDMAP METHODLARI
        // ===========================================================================

        // Bu interface'ler treeSet ve treeMap icin gecerlidir.
        // Diger map ve set'ler icin gecerli, degildir

        // TREESET VE TREEMAP ICIN COMPARATOR--------------------------------------------------------------
        System.out.println(treeMap.comparator()); // map'i olustururken bir comparator tanimladiysak onu verir
        System.out.println(treeSet.comparator());
        // -------------------------------------------------------------------------------------------------

        // TREESET ICIN SUBSET -----------------------------------------------------------------------------
        TreeSet<String> yedekSet = (TreeSet<String>) treeSet.subSet("2","4");
        // 2'den 4'e kadar olan elemanlari al ve bir subSet olustur ve ata demek, inclusive ve exclusive gecerlidir
        System.out.println(yedekSet);
        // --------------------------------------------------------------------------------------------------

        // TREEMAP ICIN SUBMAP ------------------------------------------------------------------------------
        System.out.println(treeMap.subMap("2", "4")); // {2=2, 3=3} subMap olustur ve direct ekrana yazdir, kullan at mode
        // ---------------------------------------------------------------------------------------------------

        // TREESET ICIN HEADSET (to Element) -----------------------------------------------------------------
        System.out.println(treeSet.headSet("3")); // [1, 2] 3'e kadar olan elemanlari yazdirir
        // yazilan deger exclusive'dir
        // peki listede olmayan bir sey yazarsak ne olur
        System.out.println(treeSet.headSet("7")); // [1, 2, 3, 4]
        // hepsini yazdirir, cunku artik liste icin bir sinir olmamis olur
        // ---------------------------------------------------------------------------------------------------

        // TREEMAP ICIN HEADSET (to Key)  --------------------------------------------------------------------
        System.out.println(treeMap.headMap("3")); // {1=1, 2=2}
        // ---------------------------------------------------------------------------------------------------

        // TREESET ICIN TAIL (from Element) ------------------------------------------------------------------
        System.out.println(treeSet.tailSet("3")); // [3, 4] 3. elemandan itibaren listenin geri kalanini yazdirir
        // yazilan deger inclusive'dir
        // ---------------------------------------------------------------------------------------------------

        // TREEMAP ICIN TAIL (from Key) ----------------------------------------------------------------------
        System.out.println(treeMap.tailMap("3")); // {3=3, 4=4}
        // ---------------------------------------------------------------------------------------------------

        // TREESET ICIN first() ------------------------------------------------------------------------------
        System.out.println(treeSet.first()); // ilk elemani okur
        // ---------------------------------------------------------------------------------------------------

        // TREEMAP ICIN firstKey() ---------------------------------------------------------------------------
        System.out.println(treeMap.firstKey()); // ilk elemani okur
        // ---------------------------------------------------------------------------------------------------

        // TREESET ICIN last() -------------------------------------------------------------------------------
        System.out.println(treeSet.last()); // son elemani okur
        // ---------------------------------------------------------------------------------------------------

        // TREEMAP ICIN lastKey() ----------------------------------------------------------------------------
        System.out.println(treeMap.lastKey()); // son elemani okur
        // ---------------------------------------------------------------------------------------------------

        // ===========================================================================
        //                  NAVIGABLESET VE NAVIGABLEMAP METHODLARI
        // ===========================================================================

        // navigable: gezilebilir demektir

        // TREESET ICIN lower() ------------------------------------------------------------------------------
        System.out.println(treeSet.lower("3")); // 3'den kucuk ilk elemani okur
        // ---------------------------------------------------------------------------------------------------

        // TREEMAP ICIN lowerKey() ---------------------------------------------------------------------------
        System.out.println(treeMap.lowerKey("3")); // 3'den kucuk ilk keyi okur
        // ---------------------------------------------------------------------------------------------------

        // TREESET ICIN floor() ------------------------------------------------------------------------------
        System.out.println(treeSet.floor("5"));
        // Listede olmayan 5 degeri icin 5'den kucuk ilk elemani okur
        System.out.println(treeSet.floor("0")); // null verir
        // ---------------------------------------------------------------------------------------------------

        // TREEMAP ICIN floorKey() ---------------------------------------------------------------------------
        System.out.println(treeMap.floorKey("5"));
        // Listede olmayan 5 degeri icin 5'den kucuk ilk elemani okur
        System.out.println(treeMap.floorKey("0")); // nnull verir
        // ---------------------------------------------------------------------------------------------------

        // TREESET ICIN ceiling() ----------------------------------------------------------------------------
        System.out.println(treeSet.ceiling("0"));
        // Listede olmayan 0 degeri icin 0'dan buyuk ilk elemani okur
        System.out.println(treeSet.ceiling("7")); // null verir
        // ---------------------------------------------------------------------------------------------------

        // TREEMAP ICIN ceilingKey() -------------------------------------------------------------------------
        System.out.println(treeMap.ceilingKey("0"));
        // Listede olmayan 0 degeri icin 0'dan buyuk ilk elemani okur
        System.out.println(treeMap.ceilingKey("7")); // null verdi
        // ---------------------------------------------------------------------------------------------------

        // TREESET ICIN higher() -----------------------------------------------------------------------------
        System.out.println(treeSet.higher("3")); // 3'den buyuk ilk elemani okur
        // ---------------------------------------------------------------------------------------------------

        // TREEMAP ICIN higherKey() --------------------------------------------------------------------------
        System.out.println(treeMap.higherKey("3")); // 3'den buyuk ilk keyi okur
        // ---------------------------------------------------------------------------------------------------

        // TREESET ICIN pollFirst()-pollLast() ---------------------------------------------------------------
        System.out.println(treeSet.pollFirst()); // ilk elemani gosterir ve listeden siler
        System.out.println(treeSet.pollLast()); // son elemani gosterir ve listeden siler
        // ---------------------------------------------------------------------------------------------------

        // TREEMAP ICIN higherKey()-pollLast() ---------------------------------------------------------------
        System.out.println(treeMap.pollFirstEntry()); // ilk elemani gosterir ve listeden siler
        System.out.println(treeMap.pollLastEntry()); // son elemani gosterir ve listeden siler
        // ---------------------------------------------------------------------------------------------------

        // TREESET ICIN descendingIterator() -----------------------------------------------------------------
        Iterator<String> iterator = treeSet.descendingIterator();
        System.out.print("Set Descending");
        while(iterator.hasNext())
        {
            System.out.print (iterator.next() + ", "); // sondan basa dogru yazdiracak
        }
        // ---------------------------------------------------------------------------------------------------

        // TREEMAP ICIN descendingIterator() -----------------------------------------------------------------
        Iterator<String> iterator1 = treeMap.descendingKeySet().descendingIterator();
        System.out.print("Map Descending");
        while(iterator1.hasNext())
        {
            System.out.print (iterator1.next() + ", "); // sondan basa dogru yazdiracak
        }
        // bu sanki iyi calismadi daha sonra buna tekrar detayli olarak bak !!!!
        // ---------------------------------------------------------------------------------------------------









    }

}
