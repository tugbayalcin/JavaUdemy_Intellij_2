package Section8_Inheritance;

public class Binding
{

    //<editor-fold desc="BindingNotes">
    /*
             Erken ve Gec baglama olarak iki cesittir

         * Early Binding
           Bir methodun hangi nesneye ait oldugu derleme aninda belli ise buna erken baglanma denir
           Kod calismadan once her sey bellidir
           Bu yuzden hizlidir
           Overloading methodlar derleme aninda kararlastirildigindan bu yontemi kullanir

         * Late Binding
           Bir methodun hangi nesneye ait oldugu calisma aninda belli oluyorsa buna gec baglanma denir.
           Her sey calisma aninda belirlenir
           Bundan dolayi yavastir
           Overriding methodlar calisma aninda belirlendigi icin bu yontemi kullanir
           Rahat ve esnektir. Tiplere bbagli kalmadan calisilabilir




    */
    //</editor-fold>

    public static void main(String[] args)
    {
       // earlyBinding(); // static binding de denşir
        lateBinding(); // dynamic binding de denir
        /*
            FARKLARI:
            * Static Binding compile zamani, dynamic binding calisma(runtime) zamaninda olur
            * Static Binding statik ve final methodlarda olur, cunku bunlar degisatirilemez.
            * Dynamic Binding calisma aninda degiskenin degiskenin nesneye baglandigi zaman override edilmis methodlar sayesinde olur
            * Bundan dolayi dynamic binding olabilmesi icin polymorphism olmak zorundadir
        */
    }
    public static void earlyBinding()
    {
        UstSinifStatic.adiniSoyleStatic();

        UstSinifStatic ustSinif = new UstSinifStatic();
        ustSinif.adiniSoyleStatic(); // sari yaniyor, cunku statik methodu obje olusturmadan da cagirabilirsin,
        // obje olusturmana gerek yok, bu satir bosuna, git class adi ile cagir diyor
        AltSinifStatic.adiniSoyleStatic();

        UstSinifStatic ustSinifNesnesi = new UstSinifStatic();
        ustSinifNesnesi.adiniSoyleStatic();

        AltSinifStatic altSinifNesnesi = new AltSinifStatic();
        altSinifNesnesi.adiniSoyleStatic();

        UstSinifStatic ustSinif1 = new AltSinifStatic(); // POLYMORPHISM: Ust sinifin degiskeni AltSinifin referansini tutuyor
        ustSinif1.adiniSoyleStatic(); // peki burada alt sinifin mi yoksa ust sinifin mi adiniSoyle methodu calisacak
        // ustSinifin methodu cagirildi, compiler aninda karar verilir ve hizli calisir
        // verilen degisken hangi sinifta ise direk o sinifa bakar ve methodu calistirir, alt siniflara bakmaz
        // bu olaya STATİC BINDING/EARLY BİNDİNG/ERKEN BAGLAMA denir :
        // Gerceklesmesi icin methodun mutlaka ama mutlaka STATİC veya FINAL olmasi gerekir
    }
    public static void lateBinding()
    {
        UstSinifNonStatic ustSinifNonStatic = new UstSinifNonStatic();
        ustSinifNonStatic.adiniSoyle();

        AltSinifNonStatic altSinifNonStatic = new AltSinifNonStatic();
        altSinifNonStatic.adiniSoyle();

        UstSinifNonStatic ustSinifNonStatic1 = new AltSinifNonStatic(); // Polymorphism
        ustSinifNonStatic1.adiniSoyle(); // acaba hangi adiniSoyle calisacak -->Dinamic Binding
                                         // Alt sinifin override methodu calisti !!!

        /*
            Dynamic Binding'de birden fazla ust sinif oldugunda cagirilan method en alt siniftan en ust sinifa dogru aranir
            Bulunmazsa bir ust sinifa bakilir
        */
    }
}

class UstSinifStatic
{
    public static void adiniSoyleStatic() // static method sinif methodudur. sinif adi ile erisilebilir
    {
        System.out.println("Ust Sinifin Static Adini Soyle Methodu Cagirildi");
    }
    // STATİC METHODLAR KALITIM KULLANILSA BILE OVERRIDE EDİLEMEZLER!!! CUNKU YALNİZCA BULUNDUKLARI SINIFA OZGUDUR
    // Ancak methodu direk kopyalayip alt sinifa yapistirabiliriz, isimler ayni olsa da iki farkli method olarak işlev gorurler
}
class AltSinifStatic extends UstSinifStatic
{
    public static void adiniSoyleStatic() // static method sinif methodudur. sinif adi ile erisilebilir
    {
        System.out.println("Alt Sinifin Static Adini Soyle Methodu Cagirildi");
    }
}
class UstSinifNonStatic
{
    public void adiniSoyle()
    {
        System.out.println("Ust Sinifin Non-Static Adini Soyle Methodu Cagirildi");
    }
}
class AltSinifNonStatic extends UstSinifNonStatic
{
    public void adiniSoyleStatic()
    {
        System.out.println("Alt Sinifin Non-Static Adini Soyle Methodu Cagirildi");
    }

    @Override
    public void adiniSoyle()
    {
        System.out.println("Alt Sinifin Non-Static Adini Soyle Override Methodu Cagirildi");
    }
}

