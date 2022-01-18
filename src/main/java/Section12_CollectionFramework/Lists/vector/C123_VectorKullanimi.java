package Section12_CollectionFramework.Lists.vector;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import java.util.stream.Collectors;

public class C123_VectorKullanimi
{
    public static void main(String[] args) {

        // Vector sinifi artik pek fazla kullanilmayan bir siniftir
        // Cunku ArrayList daha kullanisli

        /*
        Vektor Class: ArrayList class'i gibi dinamic olarak artan bir diziye benzer.
                      ArrayList'ten en temel farki vector class'i synchronized methodlara sahiptir.
                      Yani vector uzerinde sadece tek bir thread islem yapar,
                      diger thread'ler buradaki islemin bitmesini beklemek zorundadirlar

        Multi thread bir ortamda vector kullanimi daha mantiklidir. Tabi bu da beraberinde performans sorunlari getirebilir.
        Cunku bir thread ialem yaparken vector uzerine kilit koyar ve diger thread'ler bu islemin yapilmasini beklemek zorunda kalir
        Eger multi thread bir uygulama yapmiyorsak array list'i tercih etmek daha mantikli olacaktir.

        Vector<Integer> vector = new Vector<Integer>(3); diyerek 3 elemanli bir vector olusturmus oluruz
        vector.capacity() ile vctorumuzun o anki boyutunu gorebiliriz.
        Bu capacity asildigi anda vector capacity'sini 2 katina cikarir

        vector.setSize(20) diyerek vectorun boyutunu arttirabiliriz. Bu durumda vector bos olan elemanlara null degerleri atar

        Vektordeki elemanalri egzmek icin;
        Enumeration<Integer> en = vector.elements();
        while(en.hasMoreElements())
        {
            System.out.println(en.nextElement());
        }

        vector.firstElement() ve vector.lastElement() ile ilk ve son elemanlara ulasabiliriz.

        Bunlarin disinda vector kullanimi cok onerilmez, peki neden?
        * Thread safe ozelligini arraylist'lere de kazandirabiliriz
          Collections.synchronizedList(arrayList) dersek yapmis oluruz
        * Vectorlerdeki thread safe ozelligi cok fazla zaman alir.

        Eski bir siniftir, eski ozellikleri coktur o yuzden arrayList kullanalim.

         */

        Vector<String> sehirler = new Vector<>();
        sehirler.add("Bursa");
        sehirler.contains("Bursa"); // baktigimizda array list'teki methodlari veya cok benzerlerini gorebiliriz

        // constructor icerisine ctrl p dediginde parametre olarak neler alan constructor'lari var gorebilirsin
        Vector<String> sehirler2 = new Vector<>(2,10);
        // sen capacity olarak 2 ile basla ama olur da ben 2'yi gecersem capacity'yi 10 arttir demek oluyor

        System.out.println(sehirler.capacity()); // 2 yazdi -->sehirler2 methodunun capacity'sini yazdirir
        sehirler.add("Bursa");
        sehirler.add("Bursa");
        sehirler.add("Bursa");
        System.out.println(sehirler.capacity()); // 12 yazdi
        // eger ben capacity'yi bu sekilde arttirma emri vermemis olsaydim,
        // java default olarak capasity'yi eleman sayisinin 2 katina cikaracakti

        sehirler.setSize(20); // capacity'yi kendim set edebiliyorum
        System.out.println(sehirler.capacity()); // 20 yazdi

        // capacity() methodunda bit tuhaflik var, ??? capacity'm duzgun yazdiriliyor mu


        System.out.println(sehirler);
        // tekrarli degerleri ve null degeri tutabilen bir yapi

        System.out.println("first element: " + sehirler.firstElement());
        System.out.println("last element: " + sehirler.lastElement());

        // dizi elemanlarini for dongusu ile yazdirma
        System.out.println("For ile gezinti");
        for(int i=0; i<sehirler.size(); i++)
        {
            System.out.print(sehirler.get(i) + ", ");
        }
        // foreach kullanarak da yazdirabilirdik

        // vectorlerde iterator kullanilabilir mi?
        System.out.println("\nIterator ile gezinti");
        Iterator<String> iterator = sehirler.iterator();
        while(iterator.hasNext())
        {
            System.out.print(iterator.next() + ", ");
        }

        // Iterator'in vector icin olan hali enumaration ile gezmeyi deneyelim
        System.out.println("\nEnumaration ile gezinti");
        Enumeration<String> enumeration = sehirler.elements();
        while(enumeration.hasMoreElements())  // daha gezilecek eleman var mi diye soran method
        {
            System.out.print(enumeration.nextElement() + ", ");
        }

       // enumeration.remove(); diyemiyoruz boyle bir methodu yok
       // enumeration yalnizca listeyi gezebilmeye yarar. Ekleme, cikarma, set etme  gibi islemleri yapacak methodlari yoktur

       // Collections.synchronizedList(); buraya parametre olarak bir liste verdigimizde
       // listemiz synchorized olmus olacak ve vectorlere ihtiyacimiz kalmamis olacaktir


    }
}
