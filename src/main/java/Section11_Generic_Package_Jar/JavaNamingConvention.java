package Section11_Generic_Package_Jar;

public class JavaNamingConvention // isimlendirme kurallari
{
    public static void main(String[] args)
    {
        /*
            PACKAGES
             * Her zaman kucuk harfle baslamalidir
             * Tekil yani unique olmalidir
             * Genellikle internet Domain adresinin tersi ile baslar ve proje adini icerir
             * - yerine _ kullanilmasina ozen gosterilmelidir
             * Javadaki keywordleri iceriyorsa basina _ konulmalidir
             * Switch.abc.com --> com.abc._switch gibi
               1world.com --> com._1world
               experts-exchange.com --> com.experts_exchange etc..

            CLASS AND INTERFACE
             * CamelCase (Buyuk harfle baslar, Ikinci kelime de buyuk harfle baslar)
             * Isim olmalidir
             * ArrayList, LinkedList, FutbolTakimi etc..
             * Interface adlandirilirken icerdigi methodlari belli eden bir isim verilmelidir
             * Comparable interfacei onu implemente eden sinifin karsilastirma yapacagini belirtir

           METHOD
             * mixedCase (kucuk harfle baslanir, ikinci kelime buyuk harfle baslar)
             * Genellikle fiil ifadeleri icermelidir
             * Yapacagi isi belli eden ifadeler olmalidir
             * menuGoster, getIsim, oyuncuEkle etc..

           CONSTANST/SABITLER
             * Tamami buyuk harfle yazilmalidir
             * Sabit tanimlarken kelimeler _ ile ayrilmalidir
             * Final anahtar kelimesi ile tanimlanmalidir
             * Static final int MAKSIMUM_INTEGER etc...

           VARIABLE
             * mixedCase (kucuk harfle baslar, ikinci kelime buyuk harfle baslar)
             * Amlamli ve aciklayici olmalidir
             * _ kullanilmamalidir
             * i --> genellikle dongulerde kullanilmalidir
             * temp --> foreachde kullanilmalidir (gecici yerine yazilir)
             * birinciSayi, oyuncuAdi etc..

           TYPE PARAMETERS
             * E --> Element - Java Collections Frameworkte cok kullanilir
             * K --> Key
             * N --> Number
             * T --> Type
             * V --> Value


         */

    }
}
