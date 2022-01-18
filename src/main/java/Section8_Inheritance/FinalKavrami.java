package Section8_Inheritance;

public class FinalKavrami
{

    //<editor-fold desc="FinalNotes">
        /*
          * FINAL=DEGISTIRILEMEZ

          * FINAL DEGİSKEN: bir degiskenin final olarak tanimlanmasi demek, ona ilk deger atamasi yapildiktan sonra bu degerin asla
            degistirilemeyecek olmasi demektir.
            Genellikle pi sayisi gibi sabitleri bu sekilde tanimlariz.

          * FINAL METHOD/FINAL CLASS:
            Final olan bir classtan kalitim yolu ile baska bir class uretemeyiz(extend edilemez)
          ! Yani final classlar super class olamaz
          ! Final methodlar override edilemez (yani guncellenemez), ancak sub classtan cagirilip kullanilabilir

        */
    //</editor-fold>

    public static void main(String[] args)
    {
        int sayi; // integer bir sayi declare ettim
        sayi =1; // sayiya ilk defa deger atadim, initialize ettim

        int sayi2 = 10;; // integer bir sayi tanimladim ve ilk defa deger atadim
        sayi2=15; // sayinin tuttugu degeri yeni bir atama yaparak degistirdik

        final int sayi3; // final kullanarak integer bir sayi tanimladim
        sayi3=5; // sayiya ilk defa deger atadim. Herhangi bir sikinti yok

        final int sayi4 =50; // FINAL kullanarak integer bir sayi tanimladim ve ILK DEFA deger atadim
       // sayi4=55; // degeri DEGİSTİRMEK icin yeni bir atama yapmaya calistigimda hata aliyorum,
                    // hatanin uzerine geldigimde sayi degsikenini final olarak tanimladigimi soyluyor

        Math.random(); // bu class bir final classtir.
                       // ben desem ki bu class benim icin yeterli degil.
                       // ben bu classi super class olarak kullanip yeni bir class olusturayim
                       // hem bu classtaki bilgileri kullanayim hem de ihtiyacim olan ek bilgileri de bu classa ekleyeyim
                       // dırırırım !! yapamadik. Cunku Math classi finaldir ve final classlar super class olamazlar

        Cat d1 = new Cat(); // her Cat bir Cat tir
        Cat d2 = new Kaplan(); // her Kaplan bir Cat tir
        Cat d3 = new Tekir();
        d1.goster(); //
        d2.goster(); //
        d3.goster(); //
        // yukaridaki iki satir runtime aninda neyi calistiracagina karar verir (cattekini mi kaplandakini mi)
        // ve bu karari vermek icin bazi kontroller gerceklestirdigi icin performans anlaminda biraz sikintimiz olur
        // eger bizim goster methodumuz final ise, method diger classlarda override edilemeyecegi icin tek ve biriciktir
        // kontrol etmeye gerek kalmadan dogrudan Cat methodundaki goster methodu calisir
        // bundan dolayi performans verimliligi saglar

    }

}
final class Parents {}
//class Child extends Parents{ } --> ERROR
class Cat
{
    final public void catMethod() // static de yapabiliriz, static class final olsa da olmasa da alttaki sinif onu degistiremez
    {
        System.out.println("Parenttaki parentMethod methodu calisti");
    }
    public void goster()
    {
        System.out.println("Cat teki goster methodu calisti");
    }

}
class Kaplan extends Cat
{
   public void kaplanMethod()
   {
       catMethod(); // super classin final methodu cagirilabildi
   }

    @Override
    public void goster() {
        System.out.println("Kaplandaki goster methodu calisti");
    }
}
class Tekir extends Cat
{

}