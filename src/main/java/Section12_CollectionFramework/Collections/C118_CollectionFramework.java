package Section12_CollectionFramework.Collections;

public class C118_CollectionFramework
{
    /*
        Collection; interface ve abstract class'lar kullanilarak olusturulmus bir yapidir.
        Bir grup nesneyi(farkli tipte bile olsa) bir arada tutmaya yarar
        Simdiye kadar olan bilgilerimizle objelerimizi array'ler icerisinde tutuyorduk
        Ancak Array yapisinin static olmai ve olusturulduktan sonra degistirilemez olmasi gibi dezavantajlari
        bizi baska yollar aramaya surukledi
        Bu yol da Collection'a gidiyor :)

        Collection: INTERFACE --> Butun verileri birarada tutmamizi saglayan yapi
        Collections: CLASS --> Collection yapisinda kullanilan azi onemli methodlari iceren class

        Collection != Collections
        [ Array -> Arrays gibi === Bu tur class'lara Utility Class denir ]

        Class yapilarinda en ustte ata class olarak OBJECT class'i bulunurdu ve butun classlar Object classindan turetilirdi
        Interface yapilarinda ise ITERABLE interface'i ata interface'dir ve bircok interface bu interface'den kalitilir
        Collection interface'i de Iterable interface'inden kalitilmistir.

        Iterable interface'inin bir tane methodu vardir. Bu method iterator methodudur.
        Iterator methodu collection icerisindeki elemanlari gezebilmemizi saglar

        Temel collection yapilari sunlardir;
        LIST: Bildigimiz liste yapisi. ArrayList, Vector, LinkedList etc
              Collection interface'inden turetilmistir
              Iterable -> Collection -> List

        SET: Matematikteki kumelere benzer. En onemli ozelligi tekrarlanmayan veriler icermesidir
             Elemanlari unique(tekrarsiz) olarak saklar.
             Collection interface'inden turetilmistir
             Iterable -> Collection -> Set

        QUEUE: Kuyruk yapisindadir. Ilk giren ilk cikar mantiginda calisir.
               Collection interface'inden turetilmistir
               Iterable -> Collection -> Queue

         --> Bu uc yapi; yapi olarak ayni, ozellik olarak farklidir.
             Simdi gorecegimiz Map ise yapi olarak tamamen bunlardan farklidir

        MAP: Anahtar-Deger yapisi ile verileri saklar.
             Collection interface'inden turetilmemistir. Ust interface'i yoktur, en ustte kendisi vardir.

        Collection interface'inin 14 tane methodu vardir.
        Iterable methodunu da extends ettigi icin bu interface'in tek methodu olan iterator methodunu override eder
        Dolayisiyla 15 tane methodu olur ve Collection'i extends/implements eden her interface/class bu methodlari implement etmek zorundadir

    */
}
