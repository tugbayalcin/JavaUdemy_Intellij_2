package Section12_CollectionFramework.Maps.hashMap;

import java.util.HashMap;
import java.util.Map;

public class C126_MapInterfaceHashMapClass
{
    public static void main(String[] args) {

        {
            System.out.println();
        /* Collection'larda 4 ana interface vardir
        1. List
        2. Set (icerisinde daima bir map yapisi kullanir)
        3. Queue
        4. Map --> Diger 3'unden farklidir cunku Collection interface'inden turemez(Collection'i implements etmez
           Bunun sebebi map'in veri saklama yapisinin digerlerinden cok farkli olmasi

        Peki nedir bu farklilik:
        Aslinda map'in calisma yapisi bildigimiz sozluk yapisiyla birebir aynidir
        key-value olarak calisir
        mesela;
        ev: icinde yasanilan yer
        barinak: burada icinde yasanilan yer de yazilabilir farkli bir sey de yazilabilir

        ama bir sozlukte iki kere ev ya da iki kere veya daha fazla sayida barinak kelimesi yer almaz.
        Yani unıque'dir
        --> bu ornekte ev ve barinak dedigimiz kisim map'lerimizde key'e karsilik gelmektedşir
        Key'ler unique yapida olan elemanlardir
        ornegimizdeki tanimlamalar ise map'lerdeki value lara denk gelir
        Value'lar unique olmak zorunda degildirler, birden fazla kez yer alabilir ve farkli key'lere sahip olabilirler

        KEY + VALUE = ENTRY denir

        plaka kodu ve il adi ikilileri de bir key-value ikilisi olarak dusunulebilir
        biz sorgu yaparken bana key'i blablabla olan value'yu ver diyecegiz

        map yapilarinda 1 tane null degerli key tutabiliriz, onun da karsisina value atanabilir
        key degerleri herhangi bir sey olabilir
        simdiye kadar indekslerle calistik. aslinda onlar da bizim icin key gorevi gorduler
        map'deki key ise indeks yapisinin biraz daha gelismis halidir
        key degerleri indeksler gibi sadece 0,1,2,3 olmak zorunda degildir ve baska seyler de olabilir
        onemli olan tek sey keylerin birbirinden tamamen farkli olmasidir.

        * peki ben soyle bir sey yapsam;
        ev: icinde yasanilan yer
        ev:  odalari olan tas yapi

        gibi bir tane key degerine iki farkli value atamasi yapmaya kalktigimda en son atadigim value gecerli olur





         */
        }
        {
            System.out.println();
            /*
                Map bir inetrface'dir
                Interface'lerden object uretilemez
                Bundan dolayi interface'leri kullanabilmek icin somut yapilara somut siniflara ihtiyac duyariz
                Map icin 3 tane somut sinif vardir
                1. HashMap : Amac sadece key-value iliskisine gore veri saklamak oldugunda kullanilir
                2. LinkedHashMap: Ekleme sirasina gore degerlerimi gorebilirim
                3. TreeMap: Degerler belli bir kurala gore sirali olarak gorulmek istendiginde kullanilir
                            (String ve Wrapper class'lar icin natural order yapilirken kendi classlarimiz icin
                            comparable interface'ini implement edip compareTo methodunu override etmemiz gerekir)

                * 1.HashMap: Verileri dumduz hicbir ozelligi olmadan anahtar deger ikilisi olarak saklar
                  En basic somut siniftir
                  Index yapisi
                  indekse veya ekleme sirasina gore degil verdigimiz key'lerin hash'lerine gore
                  saklama yapacagi icin yazdirmak istedigimizde sirali bir yapi goremeyiz
                  ve biz sirali bir goruntuleme istiyorsak hashmap bizim ihtiyacimizi karsilamaz

                * 2.LinkedHashMap: HashMap'den turemistir, yani HashMap'in ozellesmis bir halidir
                  HashMap ozelliklerine ek olarak node yapisinda before ve after icin de kutular bulunur
                  Bu sayede ekleme sirasina gore goruntuleme yapabilmemize olanak saglar

                * 3.TreeMap: String ve Wrapper classlar icin naturel order ile
                  Kendi olusturdugum classlar icin ise Comparator interface'ini Implement edip compareTo methodunu override ettigim icin
                  methoda yazdigim kurala gore sirali olarak elşemanlarin yazdirilmasini istiyorsak
                  ilk iki sinif bizim ihtiyacimizi karsilamayacaktir ve Tree Map classina ihtiyac olusacaktir
                  null eleman saklanamaz cunku null baska bir seyle karsilastirilamaz dolayisiyla hata verir

                * ozetle
                  1. HashMap: key-value olarak verileri saklar
                  2. LinkedHashMap: ek olarak ekleme sirasina gore goruntuleme saglar
                  3. TreeMap: verileri ekleme sirasina gore degil de ozel bir siraya gore saklayabilmemizi saglar

            */
        }

        HashMap<Integer,String> plakalar = new HashMap<>();
        plakalar.put(01, "Adana");
        plakalar.put(34, "Istanbul");
        plakalar.put(16, "Bursa");
        plakalar.put(35, "Izmir");
        plakalar.put(06, "Ankara");
        // 01, 34, 16 bizim key degerlerimiz oldu
        // Adana, Istanbul ve Bursa value'lar oldu

        System.out.println(plakalar); // karman corman bir sirayla yazdirdi
        plakalar.get(16); // HashMap'de benim tek ilgilendigim nokta burasidir
        // ben kery degerini yazayim, java bana value'yu getirsin

        // Ben hashMap imi int-string olarak olusturdum
        // yani value'lerim string olacak
        // get methodu da parametre oplarak key alacagindan
        // parametresi int, return type'i string olan bir method olmus olacak
        // ve bana string dondurecegi icin ben bu degeri string bir degiskene kolaylikla atayabilirim
        String deger = plakalar.get(16); // bunun gibi
        System.out.println(deger);

        System.out.println(plakalar.size()); // collection'dan turememesine ragmen benzer methodlar urada da var
        System.out.println(plakalar.isEmpty()); // bos mu degil mi methodu
        // ben bir key icin yeniden value atmasi yaptigimda en son atadigim deger gecerli olur
        plakalar.put(06,"hdfıehl");
        System.out.println(plakalar.get(06)); // hdfıehl yazdirdi
        plakalar.put(null,"null deger"); // bakalim null key olabiliyor muymus
        System.out.println(plakalar.get(null)); // okuduuuuuu :)
        plakalar.put(null,"hefelrhverhe"); // null bile olsa unique olmasi gerektigi icin eski null keyi icin artik
                                           // value burada yazan seydir ve yazdirdigimizda bunu goruruz

        System.out.println(plakalar.containsKey(44)); // acaba benim plakalarim 44 diye bir key iceriyor mu, boolean dondurur
        System.out.println(plakalar.containsKey(16));
        System.out.println(plakalar.containsValue("Hakkari")); // acaba benim plakalarim Hakkari diye bir value iceriyor mu, boolean dondurur
        System.out.println(plakalar.containsValue("Bursa"));
        System.out.println(plakalar.containsValue("bursa")); // case sensitive oldugu icin false dedi

        System.out.println(plakalar.remove(35)); // verdigimiz key'deki entry'i siler ve value'yu ekrana yazdirir
        System.out.println(plakalar.size()); // silindigini buradan snlsysbilirsin
        // Documantasyondaki K key demek V value demek, methodlarin uzerine gelip aciklamalari okurken kolaylik saglar


        HashMap<Integer,String> plakalarYedek = new HashMap<>();
        System.out.println("PlakalarYedek atama oncesi size'i: " + plakalarYedek.size());
        plakalarYedek.putAll(plakalar); // kopyasini atamis oluyor
        System.out.println("PlakalarYedek atama sonrasi  size'i: " + plakalarYedek.size());

        plakalarYedek.clear();
        System.out.println("Clear sonrasi  size'i: " + plakalarYedek.size());

        // --> plakalar.equals();
        // --> plakalar.hashCode();
        // bu methodlar var ama Map bir interface oldugu icin interface'lerin ust sinifi olamaz
        // zaten map collection'dan bile gelmiyordu en tepede kendisi vardi
        // bu methodlar map'in kendisinde var, yani Object Class'indaki methodlar degil

        // simdi de foreach dongusuyle yapiyi gezmeye calisalim
        System.out.println("Keyleri Gorelim: ");
        for (Integer key: plakalar.keySet() )
        {
            System.out.println("Keyler: " + key);
        }
        System.out.println("Value'leri Gorelim: ");
        for (String value: plakalar.values() )
        {
            System.out.println("Values: " + value);
        }
        System.out.println("Entry'leri Gorelim: ");
        for (Map.Entry<Integer,String> entry : plakalar.entrySet() )
        {
            System.out.println("Entry: " + entry);
            // veya
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
        // Entry: map interface'inin icinde var olan bir inner interface'dir, uzerine gelip dokumantasyona gidebilirsin


    }
}
