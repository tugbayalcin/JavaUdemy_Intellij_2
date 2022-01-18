package Section11_Generic_Package_Jar.Packages;

import java.util.Scanner; // java.util paketinin icindeki Scanner classi import edildi
import java.util.*; // java.util paketindeki TUM CLASSLAR import edildi
import java.util.Vector;
import static java.lang.System.*; //Using Static Import

class PackageNotes
{

    //<editor-fold desc="IMPORT PACKAGE">
    /*
        * Java'da paketler ilgili siniflari gruplamak icin kullanilir. Bunu bir klasor olarak duunebiliriz.
        * Classlarimiza verecegimiz isimlerin cakismasini onlemek ve daha korunakli bir kod yazmak adina paketlerden yararlaniriz.
        * Paketler iki kategoriye ayrilir:
            1.Yerlesik Paketler (Java API'sinden paketler)
            2.Kullanici Tanimli Paketler (kendi olusturdugummuz paketler)


            import package.name.Class;   // Import a single class
            import package.name.*;   // Import the whole package (without inner packages)
            import java.util.Scanner;   // gibi

            Yukaridaki ornekte java.util, bir paket iken Scanner, paketin bir sinifidir
            import isleminden sonra Scanner sinifini kullanmak icin sinifin bir nesnesini olusturmaliyiz ve bu object ile
            sinifta bulunan methodlardan harhangi birini kullanabiliriz

         * Bu anlattiklerimizin bir ornegini yapalim ve nasil kullanildigini gorelim, Bknz: MyClass isimli class

        IMPORT EDERKEN BILMEMIZ GEREKENLER
        * Baska bir paketten bir sinifa veya yonteme erismek icin tam adi kullanmamiz veya import etmemiz gerekir
        * Ayrica sinif veya method erisilebilir olmalidir. Erisilebbilirlik acces modifierlar ile belirlenir
        * Private uyelere yalnizca ayni sinif icinde erisilebilir.
        * Bu yuzden import etmek veya paketin tam adini yazmak bu uyelere erisebilmemizi saglamayacaktir
        * java.lang paketi java tarafindan otomatik olarak import edilir
          --> Bu anlatilanlarin ornegini de ImportDemo Classi ile gorelim


      */
    //</editor-fold>

    //<editor-fold desc="STATIC IMPORT">
    /*
        * Belirli bir sinif veya paketten yalnizca static olan uyeleri almak icin statşic import kullanabiliriz.
        * Bu sayede erismek istedigimiz elemanlar icin class adini kullanmamiz gerekmez.
        * Static uyenin adini yazarak dogrudan erisim saglayabiliriz.,
        * Ancak benim kendi classimda da, static olarak cagirdigim methodun adinda bir method varsa o zaman ne olacak;
        * O zaman class adi belirtmek zorunda kalacagiz

     */
    //</editor-fold>

}
class MyClass
{
    public static void main(String[] args)
    {
        // asagida kullanicidan veri almami saglayan Scanner classinin,
        Scanner myObj = new Scanner(System.in); // Claasim zaten import edilmisti, onu kullanabilmek icin classtan bir obje olusturuyorum,
                                                // ve constructorin benden istedigi parametre olan System.in objesini (System clasinin in seysi? ) yaziyorum

        System.out.println("Enter username"); // veri almadan once kullaniciya ne yazmasini istedigimizi soyledigimiz komut

        String userName = myObj.nextLine(); // kullanicidan aldigimiz veriyi tutmak icin bir degisken tanimliyoruz (String username)
                                            // ve bu degiskene, Classtan olusturdugumuz obje ile classa girerek nextLine() methodunu
                                            // kullaniyor ve degiskenimize kullanicidan aldigimiz degeri atiyoruz
                                            // nextLine() methodu String atamak icin kullanilir

        System.out.println("Username is: " + userName); // bu satiri yazarak degiskenimize atanan degeri gormek istiyoruz
    }
}
class ImportDemo
{
    public ImportDemo()
    {
        //Imported using keyword, hence able to access directly in the code without package qualification. IMPORT ORNEGI
        Vector v = new Vector();
        v.add("Tutorials");
        v.add("Point");
        v.add("India");
        System.out.println("Vector values are: "+ v);
        //Package not imported, hence referring to it using the complete package.  // PACKAGE TAM ADI YAZMA ORNEGİ
        ArrayList list = new ArrayList();
        list.add("Tutorix");
        list.add("India");
        System.out.println("Array List values are: "+ list);
    }

    public static void main(String[] args)
    {
        new ImportDemo();
    }
}
class StaticImportDemo
{
    // static MySystemClass out = new MySystemClass(); // kendi classima ait bir obje olusturdum ve onun da adi out
    String isim = "tugba";
    int sayi = 10;
   // simdi artik class ismi vermeden hicbir out nesnesini kullanamamm, hata alirim
    public static void main(String args[])
    {
        //System.out is not used as it is imported using the keyword static.
        System.out.println("Welcome to Tutorials Point"); // System classindaki println methodu, static importta class adi yazmazdim amaistisna olustu
        out.println(); //  MySystemClass2 classindaki println methodu , classtan uretilen static nesne ile cagirdik
        println();   // MySystemClass classindaki println methodu
        // eger kendi olusturdugum MySystemClass ini ve ondan olsuturdugum out objesini commandler isem
        // System.out.println = out.println olur
        // bunlardan ilki class adi ile cagirma, digeri static import sayesinde dogrudan nesne adi ile cagirma seklinde olur
       // System.out.println(isim); // static olmayan seyler static method icinden cagirilamaz, main methodu static bir methoddur
       // System.out.println(sayi); // static olmayan seyler static method icinden cagirilamaz, main methodu static bir methoddur
        // ancak obje olusturursak erisebiliriz
        out.println(new StaticImportDemo().isim);
        out.println(new StaticImportDemo().sayi);
        // new classConstructori().degiskenAdi
        // new classConstructori().methodAdi

    }
    static void println()
    {
        System.out.println("Kendi yazdigim println isimli method");
    }
    // out.println(); // artik boyle yazamiyorum compiler bana kiziyor,
    // cunku static import ile System classinin println methodu da burada ve java hangisini calistiracagini kestiremiyor
    // Bu yuzden class adi belirterek kullanmaliyim

}
/*
class MySystemClass
{
    static void println()
    {

    }
}

 */
