package Section13_CollectionFrameworkProjects.udemyCoursePlayer.bolumler;

public class C138_Bolum3
{
    /*
        Note: Biz artik farkli kurslar alan bir ogrencinin, bu kurslardaki dersleri karisik olarak oynatma listesine ekleyerek
              kullanabilmmesini istiyoruz. Yani ogrenci kurs sirasina gore ders dinelemk zorunda degil
              istedigi gibi karisik kaset de yapabilir, kodlarimizi  bu dogrultuda yazacagiz

        Adim 1: Ogrenci class'ina gidildi
               * izlenecekDersListesi LinekdList'i olusturuldu.
                 yukaridaki aciklamada anlatilani yapmak icin bir linked list olusturduk ve artik bu listedeki dersler
                 arasinda iterator ile gezecegiz

               * izlenecekDersEkle methodu olusturuldu (ogrencinin kendisi bu listeye dersler ekleyecek)
               * kurstakiDersler arrayList'inin getter methodu olusturuldu (private oldugu icin ona erisebilmek adina)

        Adim 2: Main class'ina gidildi
               * olusturulan izlenecekDersEkle methodu denendi
                 var olan bir ders ile denendi
                 var olmayan ders ile denemek icin d6 dersi olusturuldu
               * androidKursu isimli kurs olusturuldu
               * d6 dersi androidKursu'na eklendi
               * ogr1 objesi androidKursu'na katildi --> hatta kursa da katilamadi
               * ogr1 objesi icin d6 dersi izlenecekDersListesi'ne eklendi --> eklenemedi look up^
                 (katilamadik cunku su andaki kosullara gore android kursu yayinda olmadigi icin kursa katilamiyoruz)
               * kursu yayina alabilmek icin d6,d7,d8,d9,d10 derslerini olusturalim ve ekleyelim
               * ben kendim kursa ders ekle ve ders sil methodlarinda kontrol uyguladim

        Adim 3: Main class'ina gidildi
               * listeyiOynat methodunun taslagi olusturuldu

        Adim 4: Ogrenci class'ina gidildi
               * izlenecekDersListesi'nin getter methodu olusturuldu

        Adim 5: Main class'ina gidildi
               * main method'dan listeyiOynat(ogr1.getIzlenecekDersListesi()); methodu cagirildi
                 bu list bir linkedList oldugu icin icinde iterator ile gezebiliriz
               * menuGoster() methodu olusturuldu ve listeyiOynat() methodu icinden cagirildi

     */
}
