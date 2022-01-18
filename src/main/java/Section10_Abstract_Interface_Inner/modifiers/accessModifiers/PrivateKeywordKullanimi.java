package Section10_Abstract_Interface_Inner.modifiers.accessModifiers;

public class PrivateKeywordKullanimi
{
    public static void main(String[] args)
    {
        //<editor-fold desc="Private">
        /*
           * En kisitli erisim belirtecidir
           * Private belirteci sinif tanimlamalarinda kullanilamaz.
             Private, bulunulan class disindaki gorunurlugu kapatmak gibi dusunulebilir
           * Private degisken ve methodlar yalnizca bulundugu sinifa aittir
           * Constructor private yapilamaz. Yaptigimizda editor bize hata vermez
             ancak gidip bu cınstructor ile obje olusturmaya kalktigimizda kirmizi yakar
             Eger nesne uretemeyecek isem classin var olmasinin(simdilik) bir anlami olmayacagi icin, private yapmiyoruz
           * Ozetle Private yapilan kurucu method o siniftan nesne uretilmesini engeller
             ve bu siniftan kalitim ile yeni sinif olusturulamaz
           * Private ile innerclass tanimlanabilir

         */
        //</editor-fold>
    }

    private int a ; // private degisken
    private static int staticPrivateInt=10;
    private final static int PRIVATE_FINAL_STATIC_INT=11;

    private void method(){} // private method
    private static void privateStaticVoidMethod(){}
    private static final void privateStaticFinalVoidMethod(){}


    // private PrivateKullanimi(){} --> private constructor
    private class InnerClass {}
    private static class PrivateStaticInnerClass {}
    private static final class PrivateStaticFinalInnerClass {}


    private abstract class PrivateInnerAbstractClass{}
    private static abstract class PrivateStaticInnerAbstractClass{}
    //private static final abstract class PrivateStaAbsInnerClass{} - Compiler-time Eror


    private interface IPrivateInnerInterface{}
    private static interface IPrivateStaticInterface{}
    private static abstract interface IPrivateStaticAbstractInterface{}





}
    // class YeniSinif extends PrivateKullanimi{} --> private constructori olan classtan kalitim alinamaz
    //                                            --> tum kurucu methodlari private olan bir siniftan nesne uretilemez

/*
private class ASinifi
{
    private class BSinifi
    {
        //Inner class
    }
}
 Burada A sinifi jata verir. Cunku inner class private olabilir ancak dis class private olamaz
 */




