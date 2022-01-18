package Section12_CollectionFramework.Maps.linkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class C129_LinkedHashMap
{
    public static void main(String[] args) {

        // LinkedHashMap de (soyut olan)Map interface'inin somut alt siniflarindan biridir ve
        // Verilerimizi Map yapilarinda saklamak istedigimizde soyut Map'den obje uretemedigimiz icin
        // onun somut alt siniflarini(map interface'ini implement etmis somut alt siniflar) kullaniriz
        // Bunlardan ilki HashMap idi, yakindan inceledik ve ogrendik
        // Sİmdi de LinkedHashMap'e bakalim:
        // LinkedHashMap HashMap class'ini extend eder !!
        // Yani HashMap'in ozellesmis bbir halidir
        // calisma yapisi bireir aynidir, yalnizca ek olarak before ve after degerlerini tutarak
        // ekleme sirasina gore yazdirilabilmesini saglar

        // HashMap'den en buyuk farki: Degerleri okurken ekeleme sirasina gore okuyabiliyoruz

        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
        // burada da initial capacity vardir ve default olarak 16 dir
        // load factor yine default olarak 0.75f dir
        // farkli olarak access order diye bir sey var normalde bu deger false'dur
        // ben true yaparsam linkedHashMap'in HashMap'den hicbir farki kalmaz
        // false oldugunda, elemanlarimi ekledigim siraya gore okuyabilme ozelligini elimde tutmus oluyorum
        // yabi 12 tane index dolduktan sonra capacity otomatik olarak 2 katina cikarilacak
        // ayrica parametre olarak yine bir map verebiliriz
        // boylece eski map'imizin bir kopyasini linkedHashMap degiskenimize atamis oluruz

        linkedHashMap.put("emre",1);
        linkedHashMap.put(null,2);
        linkedHashMap.put("hasan",3);
        linkedHashMap.put("ali",4);

        System.out.println(linkedHashMap);

        System.out.println("Key'leri Gezelim");
        for(String each : linkedHashMap.keySet())
        {
            System.out.println(each);
        }
        System.out.println("Value'lari Gezelim");
        for(Integer each : linkedHashMap.values())
        {
            System.out.println(each);
        }
        System.out.println("Entry'leri Gezelim");
        for(Map.Entry each : linkedHashMap.entrySet())
        {
            //System.out.println(each);
            System.out.println("Key: " + each.getKey() + " Value: " + each.getValue());
        }
        // ben boyle yaptim, hoca da asagidaki gibi gosterdi
        for(Map.Entry<String,Integer> each : linkedHashMap.entrySet())
        {
            //System.out.println(each);
            System.out.println("Key: " + each.getKey() + " Value: " + each.getValue());
        }

        System.out.println(linkedHashMap.get("hasan")); // !!! hasan'i buyuk harfle yazdigimda exception vermedi null yazdirdi



    }
}
