package Section10_Abstract_Interface_Inner.nestedClass.nonStaticNestedClass.memberInnerClass;

public class YaziciSinif
{
    // erişim belirteci ne olursa olsun dis sinifta tanimlanan her sey ic sinifta, ic sinifta da tanimlanan her sey dis sinifta kullanilabilir

    // sinifimin icindeki degiskenler
    private int privateDegisken = 1;
    int defaultDegisken = 2;
    protected int protectedDegisken = 3;
    public int publicDegisken = 4;

    // sinifimin icindeki methodlar
    private void privateMethod()
    {
        // ic classtan bir nesne uretelim
        StringDiziYazdir nesne = new StringDiziYazdir();
        System.out.println(privateDegisken);
        System.out.println(defaultDegisken);
        System.out.println(protectedDegisken);
        System.out.println(publicDegisken);
    }
    void defaultMethod(){}
    protected void protectedMethod(){}
    public void publicMethod(){}

    // sinifimin icindeki siniflar
    class StringDiziYazdir
    {

        private int privateDegiskenInner = 1;
        int defaultDegiskenInner = 2;
        protected int protectedDegiskenInner = 3;
        public int publicDegiskenInner = 4;


        // static int sayi = 5;
        // inner classlar static declaration a sahip olamazlar
        // ama su sekilde bir kullanim olabilir
        static final int sayi = 5; // bu deger uretildi ve artik degistirilemeyecegi icin erisilmesinde sikinti yok
        // inner classlar static blocklara da sahip olamazlar ancak default blocklara sahip olabilirler

        public void stringDiziYazdir(String[] dizi)
        {
            System.out.println(privateDegisken); // private degiskene bbile erisebildim
            System.out.println(defaultDegisken); // default degiskene de eristim
            System.out.println(protectedDegisken); // zaten private a erisiyorsam bunlara rahatlikla erisebilirim
            System.out.println(publicDegisken); // private a erisip digerlerine erisememe gibi bir durum olamaz
            // outer class'daki erisim belirteci ne olursa olsun tum degiskenelre erisebildim

            privateMethod(); // methodlara da erisim saglayabiliyorum
            defaultMethod();
            protectedMethod();
            publicMethod();
            // outer class'daki erisim belirteci ne olursa olsun tum methodlara da erisebildim

            for(String gecici:dizi)
            {
                System.out.println(gecici);
            }
        }
    }

    //  member inner class denir
    abstract class AbstractInnerClass{} // tanimlanabilir
    final class FinalInnerClass{} // tanimlanabilir
   // abstract final class dfsd{} bir class hem final hem abstract olamaz


}
class A
{
    class B
    {
        void methodB(){}
        private int k=4;
        C cNesnesi = new C();

        class C
        {
           B bNesnesi = new B();

            void methodC(){}
            // static int b = 1;  inner classlarda statik degiskenler olamaz
            // static void methodD(){}  inner classlarda static methodlar olamaz
            // inner classlar yalnizca ve yalnizca static olmayan alanlar tanimlanabilir
            // ancak static final degisken olmasina izin verilebilir, methoda izin verilmez
            static final int b =1; // static final degisken tanimlanabildi
            // static final void methodD(){} // static final olan method tanimlanamadi

            // default kod bloguna izin verilir
            {

            }
            // static kod bloguna izin verilmez
            // static {}

        }
    }
}
