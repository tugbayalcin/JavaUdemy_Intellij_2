package Section12_CollectionFramework.Maps.hashMap;

import java.util.HashMap;
import java.util.Iterator;

public class C128_HashMapDebug
{
    public static void main(String[] args) {

        HashMap<String,Integer> map = new HashMap<>(16,0.75f);
        // constructor'a ctrl p yap.
        // initial capasity default olarak 16'dir
        // ve eger biz bunu degistirmek istiyorsak 2'nin katlari olarak secmeliyiz
        // load factor float bir degerdir ve varsayilani da 0.75f dir
        // bunun anlami initial kapacity'nin 0.75'i yani 3/4'i doldugu zaman sen git initial capacity'yi 2 katina cikar
        // 16 icin 3/4 12'dir ve ille 12 eleman ekledigimizde dolmaz, bir indise birden fazla da eleman geleilecegi icin daha fazla
        // eleman eklediginde dolabilir
        // 12btane ekleyince de dolabilir, dolmayadabilir

        map.put("emre",1);
        map.put("fb",2);
        map.put(null,1234456);
        map.put("Ea",3);
        // bu asamada 9,19,20,21 ve 22. satirlara breakpoint koyarak debuglayalim

        System.out.println(map.get("Ea"));

        // HashMap ve Map yapilari for gibi dongulerle gezilebilecegi gibi iterator ile de gezilebilir
        Iterator iterator0 = map.entrySet().iterator();
        Iterator iterator = map.keySet().iterator();
        Iterator iterator1 = map.values().iterator();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
            // iterator.add()   --> diyemiyoruz
            // map.put("ghjhh",9); DIKKAT --> CTE vermez ama calistirdiginda RTE alirsin
            // sen bir yapiyi gezerek goruntuleme yaptigin esnada goruntuleme tamamen bitmeden ekleme ve cikarma yapmaya
            // kalktiginda ConcurrentModificationException alirsin (eszamanli duzenleme hatasi)
            //  map.remove("ghjhh",9); --> ayni sekilde, cikarma da yapilamaz

            // zaten iterator'in amaci elemanlari egzmek idi, modifiye etmek degil
        }

        // hashMap'de sira yoktur
        // ekledigim siraya gore ver diyemeyiz
        // sirali yazdirma istedigimiz durumlarda hashMap kullanisli degildir
        // tek amaci verilen degerleri key ve value olarak sira gozetmeksizin saklamaktir
        // aslinda sira ile yazdiriyor ama debug'daki table tree'yi yukaridan asagiya olacak sekilde yazdiriyor



    }
}
