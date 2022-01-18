package interfaces_For_Iterations;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//NOTE
/*

Map 'leri direk iterator kullanarak gezemeyiz. Cunku Map'ler Collection Degildirler.
Map.Entry<K, V>
Java'daki tum Map cesitleri Map interface'ini implement eder
(HashMap, TreeMap, LinkedHashMap, Hashtable,

 */
public class Mapp
{
    public static void main(String[] args)
    {
        map01();
        map02();
        map03();
        map04();
        map05();
    }

    public static Map<String, String> map;

    static
    {
        map = new HashMap<String, String>();
        map.put("1", "bir");
        map.put("2", "iki");
        map.put("3", "uc");
    }

    static void map01()
    {
        System.out.println("================ map01 ================");

        // using for-each loop for iteration over Map.entrySet()
        for (Map.Entry<String,String> entry : map.entrySet())
        {
            System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
        }
    }

    static void map02()
    {
        System.out.println("================ map02 ================");

        // using keySet() for iteration over keys
        for (String sayi : map.keySet())
            System.out.println("key: " + sayi);

        // using values() for iteration over values
        for (String yazi : map.values())
            System.out.println("value: " + yazi);
    }

    static void map03()
    {
        System.out.println("================ map03 ================");

        // using iterators
        Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();

        while(itr.hasNext())
        {
            Map.Entry<String, String> entry = itr.next();
            System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
        }
    }

    static void map04()
    {
        System.out.println("================ map04 ================");

        // forEach(action) method to iterate map
        map.forEach((k,v) -> System.out.println("Key = "+ k + ", Value = " + v));
    }

    static void map05()
    {
        System.out.println("================ map05 ================");

        // looping over keys
        for (String sayi : map.keySet())
        {
            // search  for value
            String yazi = map.get(sayi);
            System.out.println("Key = " + sayi + ", Value = " + yazi);
        }
    }
}
