package Section11_Generic_Package_Jar.Generics.GenericClass;

public class Notes_Generic
{
    /*
        Generics, farkli reference veri tiplerini alan, hangi reference tipini alacagina karar verebilecegimiz ve uzerinde benzer
        islemler yapabilecegimiz bir siniftir

        Generics ifadeler Interface, Class ve Methodlarda kullanilabilir

        Neden Kullanilir?
            1.Catch Exeptipn: Genericler uygulamalarimizdaki hatalari minimuma indirmeyi amaclar.
              Runtime esnasinda olusan hatalari compilertime esnasinda yakalayabiliriz
              Ornek: Bknz: GenericClass/Workbook/ exampleForExeption(); methodu

            2.Type Safety: Tip Guvenli, Tip dogrulamasi anlamina gelir
              Javada bir degisken tanimlamak istedigimizde hangi tipte bir degisken oldugunu bildirmek zorundayiz
              Derleyici derleme esnasinda tum degiskenler icin tip dogrulamasi yapar ve yanlis bir atama yapildiginda hata verir

              Genericler, referance veri tiplerini tek bir yapi altinda toplayarak kod tekrarini engellemis olur ve daha
              temiz kod yazmamizi saglar
              Ayrica uygulamalarimizda kullandigimiz kodlarin cok daha etkili bir sekilde tasarlanmasina yardimci olur
              Ornek: Bknz: GenericClass/Workbook/ typeSafety(); methodu

           3.Casting: Generic kullaniminda casting islemine gerek duyulmaz.

        Comparable Interface
            Comparable interface i icinde compareTo() methodunu barindirina bir interfacedir
            Bu method ile nesnelerimizin elemanlari arasinda siralama yapabiliriz
            Dogrudan object classindan olan hali ile override edebilecegimiz gibi, icine istedigimiz siralama kosulunu
            saglayacak kodlar da ekleyebiliriz
            Mesela sehir isimlerini tutan bir arrayim var ve ben alfabetik siralama yapmak istiyorum
            bunun icin comparable interfaceini implement etmeli ve interface ile birlikte gelen override etmek zorunda oldugum compareTo()
            methodunun icine alfabetik siralama yapilmasini saglayan kodlarimi yazmaliyim
            Burada siralama tek bir kosula gore yapilabiklmektedir !!!

        Comparator Interface (Generic ozelliktedir)
            Peki ben listemdeki elemanlari birden fazla kosula gore siralamak istiyorsam ne yaparim?
            Ben string sehir isimlerimi alfabetik siraya gore degil de karakter sayisina gore siralamak istiyorum
            Bu durumda comparator interfaceni kullanirim
            Bu interfacede birden fazla compare methodu override edilir.


       */
}
