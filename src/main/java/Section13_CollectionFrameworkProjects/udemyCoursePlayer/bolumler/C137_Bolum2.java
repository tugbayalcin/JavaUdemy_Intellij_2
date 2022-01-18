package Section13_CollectionFrameworkProjects.udemyCoursePlayer.bolumler;

public class C137_Bolum2
{
    /*
        Adim 1: Kurs class'ini gelistirmeye devam ediyoruz
                * kursYayindaKontrol() methodu olusturuldu --> hocadan afrkli yaptim ileride sorun olursa bak!!
                * kursaOgrenciEkle() methodu olusturuldu

        Adim 2: Ogrenci class'ina gidildi
                * katildigimKurslar arrayList'i olusturuldu ve constructor'a eklendi
                * toString methodu override edildi ve super'in toString'i de return kismina eklendi

        Adim 3: Main class olusturuldu
                * Bir ogrenci nesnesi olusturuldu (Ali)
                * Bir egitmen nesnesi olusturuldu (Emre)

        Adim 4: Egitmen class'ina gidildi
                * toString methodu eklendi ve super.toString() return edilecek sekilde duzenlendi, zaten kendine ait herhangi bi variable'i yoktu

        Adim 5: Main class'ina gidildi
                * olusturulan objeler yazdirildi
                * 4 tane ders objesi olusturuldu (d1,d2,d3 ve d4)
                * bir kurs olusturuldu (java kursu)

        Adim 6: Kisi class'ina gidildi
                * kurstakiToplamDerslerinDakikaSuresi() methodu ve kursYayinda() methdou private yapildi
                   (bu method yalnizca Kisi class'indaki memthodlar tarafindan kullanilabilsin diye private yaptik
                   cunku bu method ogrenci eklerken kullanilan bir yardimci method)

        Adim 7: Kurs class'ina gidildi
                * egitmenEkle methoduna if kosulu eklenerek, eklenecek egitmenin zaten ekli olup olmadigi kontrol edilerek
                  ekleme isleminin yapilmasi saglandi

        Adim 8: Main class'ina gidildi
                * javaKursu'na d1,d2,d3 ve d4 dersleri eklendi

        Adim 9: Kurs class'ina gidildi
                * egitmenSil methoduna if kosulu eklenerek, silinecek egitmen eger basEgitmen ise silinmesin ozelligi eklendi
                  burada equals methodu kullanilarak karsilastirma yapilmasi gerekiyor ancak ctrl n dedikten sonra gelenleri
                  hoca fazla buldu ve nedense yanindaki tikleri kaldirarak istedigini de secmedi ve egitmenin adi ile
                  basEgitmenin adini getirerek String class'indaki equals methoduna gore karsilastirdi
                  burada da basegitmenin yerini garantilemek icin, basEgitmeni ekledigimiz kod satirinda ozellikle 0. index
                  diye belirtti

        Adim 10: Main class'ina gidildi
                * javaKursu ile egitmen silme methodu denendi
                * deneme adidna baska bir egitmen olusturuldu, javaKursu'na eklendi ve silme methodu ile silindi

        Adim 11: Kurs class'ina gidildi
                * Kursa ogrenciyi bizim eklememiz cok sacma. Ogrenci kursu almak istiyorsa gelip kendi kayit olmali
                  yani kursa ogrenci ekleme isi Kurs class'inda degil Ogrenci class'inda gerceklesmeli
                * bu yuzden ogrenciEkle() methodu silindi

       Adim 12: Main class'ina gidildi
                * ogr1.kursaKatil(javaKursu) diyerek ve cikan hatada more action tiklayip 2. satirdaki create'i secip
                  ardindan hangi Ogrenci class'inda olusturulmasini istedigimizi secerek methodu olusturuldu
                * methodun ici istedigimiz kosullari saglayacak sekilde olusturuldu (this kullandim :) )
                  burada artik kursYayindaKontrol methodunu kullanacagimiz icin methodun access modifier'ini private'dan alip
                  public yapmamiz gerekiyor
                * kursa katilacak olan ogrenci, Kurs class'indaki ogrenci listesini tutan ArrayList'e eklenecegi icin
                  burada o araryList'i kullanamiz yani ona erisebilmemiz gerekiyor,
                  bu yuzden gidip onun getter methodunu olusturuyoruz
                * eklenemedigi durum icin sout ile bir aciklama yazdirmak istiyoruz ve bu aciklamayi yazarken kurs adi
                  isimli degiskeni yazdirmak istiyoruz ancak bu degisken private olarak tanimlandigi icin ersemiyoruz
                  Kurs class'ina giderek bu degisken icin getter methodu olusturmaliyiz

       Adim 13: Kurs class'ina gidildi
                * adim 12'de anlatilanlar icin;
                * ogrenciListesi icin getter method olusturuldu
                * kursAdi icin getter method olusturuldu

       Note:  Ben kursaKatil methodunu bir ogrencinin bir kursa yalnizca 1 kere katilmasini saglayacak sekilde
              yazdim. Hoca boyle yazmadi. Ileride sikinti olursa bakar ve duzeltirsin

     */
}
