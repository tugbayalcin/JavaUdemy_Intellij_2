package Section10_Abstract_Interface_Inner.nestedClass.nonStaticNestedClass.memberInnerClass;

public class NestedClassNotes
{
    /*

    Bknz: https://javaplanet.wordpress.com/2017/04/04/javada-ic-ice-gecmis-siniflar-nested-classes/

        * Bir class icerisinde baska bir classin yer almasi durumudur.
        * Buradaki temel amac içteki ve distaki classin ayni gorevi gerceklestirmek uzere birlikte gruplandirilmis ve gorevlendirilmis olmasidir
        * Bazi durumlarda icteki class yalnizca sarmalayici classi tarafindan kullanilabilir.

        * inner class ve nested class ayni seyler degildir
        * inner classlar static olmayan ic ice gecmis siniflardir
        * yani inner class nested classin bir alt daliidr

        * ic siniflari, onlari sarmalayan bir sinifin ogesi gibi dusunebiliriz.
        * sarmalayan sinifin degisken ve methodlarindan farkli degildir
        * bu sebeple onlarin alabilecegi acces modifierlari alabilirler
        * yani ic classlar public, default, protected veya private olabilirler
          (normalde bir class ya public ya da default olabilirdi)

        * javada ic ice gecmis sinif tipleri su sekildedir:
            1.static olmayan ic ice gecmis siniflar (non-static nested classes)
            2.static olan ic ice gecmis siniflar (static nested classes)
            3.yerel siniflar (local classes)
            4.anonim siniflar (anonymous classes)
     */

             //<editor-fold desc="1.STATIC OLMAYAN NESTED CLASS">
     /*

            ERISIM DURUMU: Sarmalayici sinif bu sinifin her elemanina erisebilir, ancak nested class'tan obje uretmesi gereklidir
                           Sarmalayici sinifin her elemanina erisebilir

            Icine constructor tanimlanabilir

            * Bu siniflara inner class da denir.
            * Inner classlar sarmalayici sinifin nesnesiyle baglantilidir.
            * Nasil ki static nested siniflar class adi ile cagiliyorsa,
            * static olmayanlar da sarmalayici sinifin nesnesi uzerinden cagirilirlar(tanimlanirlar)
            * static olmayan nested sinifin tanimi asagidaki gibi yapilir.

            public class SarmalayiciSinif
            {
                public class IcIceGecmisSinif
                {

                }
            }
            Bu siniftan nesne ise su sekilde uretilir:

            SarmalayiciSinif sarmalayici = new SarmalayiciSinif(); // dis classa ait bir nesne olusturuldu
            SarmalayiciSinif.IcIceGecmisSinif iciceGecmisSinif = sarmalayici.new IcIceGecmisSinif();
            // ic classa ait iciceGecmisSinif degiskeni sarmalayici nesnesi yardimi ile olusturuldu
            * new anahtar kelimesi sarmalayici nesnesiyle birlikte araya nokta konularak kullanilmistir.

            * Static olmayan ic siniflar, sarmalayici sinifin her elemanina (private olsa bile) erisebilir Bknz: workbook



     */
    //</editor-fold>

             //<editor-fold desc="2.STATIC NESTED CLASSES">
               /*
                 ERISIM DURUMU: Sarmalayici class her elemanina erisebilir (olusturulan obje ile her elemana, class adi ile static elemana erisir)
                                Bu class sarmalayici classinin yalnizca ve yalnizca static elemanlarina erisebilir

                 Icine constructor tanimlanabilir

                 Bu tip siniflar asagidaki gibi kullanilir:

          public class SarmalayiciSinif
          {
             public static class IcIceGecmisSinif
             {

             }
          }

         --> ic ice gecmis siniftan bir nesne uretmek icin basina sarmalayici sinifin adi yazilir:
             SarmalayiciSinif.IcIceGecmisSinif nesne = new SarmalayiciSinif.IcIceGecmisSinif();
             (static methodlar sinif adi ile cagirilirdi ya, onun gibi dusun, static class da class adi ile cagiriliyoır, nesne ile degil)


       * Ic ice gecmis sinif baska bir sinif icinde konumlandirilmis, temelde normal bir java sinifidir.
       * Static tanimlanmis olmasi sebebiyle, static bir ic sinif sarmalayici sinifinin yalnizca static elemanlarina erisebilir Bknz: workbook
       */
             //</editor-fold>

             //<editor-fold desc="3.LOCAL CLASSES">
             /*
                 Local Classlar yapisi itibariyle ic siniflara benzer ve sarmalayici sinifin bir methodunda ya da
                 kapsam blogunda (scope block {}) tanimlanir.

                 ERISIM DURUMU: Local Classlara sadece tanimlanmis olduklari block ya da method icerisinden erisilebilir.
                                Local Classlar ise ayni ic siniflar gibi sarmalayici siniflarinin alan ve methodlarina erisebilirler

                 Icine constructor tanimlanabilir.

              */
             //</editor-fold>

             //<editor-fold desc="4.ANONYMOUS CLASSES">
            /*
                Bir sinif ismine sahip olmayan ic ice gecmis sinif tiplerinden biridir.
                Bir sinifin alt sinifi gibi tanimlanabilirler
                Bir interfacein implementasyonu gibi de tanimlanabilirler.
                Anonymous classlar orneklendirildiklerinde tanimlanirlar.
                Bknz: workbook

                NESNE tanimlar gibi yapip sonrasinda {} parantezleri acarak icine sanki bir classtaymisiz gibi kodlarimizi
                yaziyoruz
                Iste burasi anonymous class oluyor
                Burada tanimladigimiz methodlara sarmalayici classtan erismen icin, anonymoud classinn basinda olusturdugumuz
                NESNE.methodAdi seklinde erisiyoruz.

                Anonymous siniflar icerisine blocklar ve methodlar tanimlayabiliriz
                Coınstructor tanimlayamayiz
                static initializer block tanimlayabiliriz
             */
             //</editor-fold>








}
