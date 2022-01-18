package Section10_Abstract_Interface_Inner.nestedClass.nonStaticNestedClass.memberInnerClass;

public class Workbook
{

}
class SarmalayiciClass // dıstaki classim olustu
{
    public int publicDegisken =0;
    private int privateDegisken = 1;
    protected int protectedDegisken =2;
    int defaultDegisken =3;
    static int staticDegisken =4;
    final int finalDegisken =5;

    public static int publicStaticDegisken =6;
    static final int staticFinalDegisken = 7;
    public static final int publicStaticFinalDegisken =8;
    static private int staticPrivateDegisken =9;


    public static void SarmalayiciClassMethodu()
    {
        //static olmayan ic classimi kullanma
        SarmalayiciClass sarmalayici = new SarmalayiciClass(); // dis classimdan bir nesne olustu
        InnerClass innerclassobjesi = sarmalayici.new InnerClass(); // dis class nesnesini kullanarak static olmayan ic classtan bir nesne urettim
        innerclassobjesi.InnerClassMethodu(); // urettigim ic class objesini kullanarak ic classtaki methoda eristim

        // yukarida methodlara erisebildigimizi gorduk
        // sarmalayici class bu ic class objesi ile ic classtaki hangi degiskenlere erisebilir bakalim:
        System.out.println(innerclassobjesi.innerPublicDegisken);
        System.out.println(innerclassobjesi.innerPrivateDegisken);
        System.out.println(innerclassobjesi.innerProtectedDegisken);
        System.out.println(innerclassobjesi.innerDefaultDegisken);
        System.out.println(innerclassobjesi.innerFinalDegisken);
        System.out.println(innerclassobjesi.innerStaticFinalDegisken);
        System.out.println(innerclassobjesi.innerPublicStaticFinalDegisken);
        // hepsine erisebildik



        // static ic classimi kullanma
        StaticInnerClass staticInnerClassNesnesi = new StaticInnerClass();

        // sarmalayici class bu ic class objesi ile static ic classtaki hangi degiskenlere erisebilir bakalim:
        System.out.println(staticInnerClassNesnesi.staticInnerPublicDegisken);
        System.out.println(staticInnerClassNesnesi.staticInnerPrivateDegisken);
        System.out.println(staticInnerClassNesnesi.staticInnerProtectedDegisken);
        System.out.println(staticInnerClassNesnesi.staticInnerDefaultDegisken);
        System.out.println(staticInnerClassNesnesi.staticInnerStaticDegisken);
        System.out.println(staticInnerClassNesnesi.staticInnerFinalDegisken);
        System.out.println(staticInnerClassNesnesi.staticInnerPublicStaticDegisken);
        System.out.println(staticInnerClassNesnesi.staticInnerStaticFinalDegisken);
        System.out.println(staticInnerClassNesnesi.staticInnerPublicStaticFinalDegisken);
        System.out.println(staticInnerClassNesnesi.staticInnerStaticPrivateDegisken);
        // tum degiskenlere erisebildik, simdi methodlara aerisebiliyor muyuz bakalim:
        staticInnerClassNesnesi.StaticInnerClassMethodu(); // static olmayan methoda eristim
        staticInnerClassNesnesi.StaticInnerClassStaticMethodu(); // buna da eristim ama elimle yazmam gerekti ve sari yakti
        // yani diyor ki bu methoda obje ile erismene gerek yok, direk class adi ile erisebilirsin
        StaticInnerClass.StaticInnerClassStaticMethodu(); // seklinde bir erisim daha dogru olur


        // simdi de local class nasil olur ona bakalim, su anda SarmalayiciClass sinifinin SarmalayiciClassMethodu
        // methodu icerisindeyiz ve ben bu mmethod icerisinde bbir class tanimlayacgim
        // bu classin yasam alani method sinirlarindan ibaret olur
        class LocalClass
        {

        }
        LocalClass localClass = new LocalClass();  // local classimdan nesne olusturdum
        // Local Classlara sadece tanimlanmis olduklari block ya da method icerisinden erisilebilir.
        // Local Classlar ise ayni ic siniflar gibi sarmalayici siniflarinin alan ve methodlarina erisebilirler





    }

    // clasimda tanimladigim her turku erisim belirleyicine sahip degiskenlerimden hangilerine inner classtan erisebildigimize bakalim

    public class InnerClass // static olmayan ic classim olustu
    {
        public int innerPublicDegisken =0;
        private int innerPrivateDegisken = 1;
        protected int innerProtectedDegisken =2;
        int innerDefaultDegisken =3;
        // static int staticDegisken =4; static olmayan yerde static seyler tanimlayammayiz
        final int innerFinalDegisken =5;

        // public static int publicStaticDegisken =6; // static olmayan yerde static seyler tanimlayammayiz
        static final int innerStaticFinalDegisken = 7; // --> static final tanimlayabildigimize dikkat !!
        public static final int innerPublicStaticFinalDegisken =8; // --> static final tanimlayabildigimize dikkat !!
        // static private int staticPrivateDegisken =9; // static olmayan yerde static seyler tanimlayammayiz

        // inner class icerisine constructor tanimlayabiliriz
        public InnerClass() {}

        public void InnerClassMethodu()
        {
            System.out.println(publicDegisken); // public degiskene erisildi
            System.out.println(privateDegisken); // private degiskene erisildi
            System.out.println(protectedDegisken); // protected degiskene erisildi
            System.out.println(defaultDegisken); // default degiskene erisildi
            System.out.println(staticDegisken); // static degiskene erisildi
            System.out.println(finalDegisken); // final degiskene erisildi
            System.out.println(publicStaticDegisken); // public static degiskene erisildi
            System.out.println(staticFinalDegisken); // static final degiskene erisildi
            System.out.println(publicStaticFinalDegisken); // public static final degiskene erisildi
            System.out.println(staticPrivateDegisken); // static private degiskene erisldi
            // static olmayan inner classim, static olaman sarmalayici classimdaki tum ogelere erisebilir

        }
        // class static degilse, methodlari da static olamaz
    }

    public static class StaticInnerClass // statşic ic classim olıustu
    {
        public int staticInnerPublicDegisken =0;
        private int staticInnerPrivateDegisken = 1;
        protected int staticInnerProtectedDegisken =2;
        int staticInnerDefaultDegisken =3;
        static int staticInnerStaticDegisken =4;
        final int staticInnerFinalDegisken =5;

        public static int staticInnerPublicStaticDegisken =6;
        static final int staticInnerStaticFinalDegisken = 7;
        public static final int staticInnerPublicStaticFinalDegisken =8;
        static private int staticInnerStaticPrivateDegisken =9;

        public StaticInnerClass() {} // constructor tanimlanabilir

        public void StaticInnerClassMethodu()
        {
            // System.out.println(publicDegisken); // public degiskene erisilemedi
            // System.out.println(privateDegisken); // private degiskene erisilemedi
            // System.out.println(protectedDegisken); // protected degiskene erisilemedi
            // System.out.println(defaultDegisken); // default degiskene erisilemedi
            System.out.println(staticDegisken); // static degiskene erisildi
            // System.out.println(finalDegisken); // final degiskene erisilemedi
            System.out.println(publicStaticDegisken); // public static degiskene erisildi
            System.out.println(staticFinalDegisken); // static final degiskene erisildi
            System.out.println(publicStaticFinalDegisken); // public static final degiskene erisildi
            System.out.println(staticPrivateDegisken); // static private degiskene erisldi
        }
        public static void StaticInnerClassStaticMethodu()
        {
           // System.out.println(publicDegisken); // public degiskene erisilemedi
           // System.out.println(privateDegisken); // private degiskene erisilemedi
           // System.out.println(protectedDegisken); // protected degiskene erisilemedi
           // System.out.println(defaultDegisken); // default degiskene erisilemedi
            System.out.println(staticDegisken); // static degiskene erisildi
           // System.out.println(finalDegisken); // final degiskene erisilemedi
            System.out.println(publicStaticDegisken); // public static degiskene erisildi
            System.out.println(staticFinalDegisken); // static final degiskene erisildi
            System.out.println(publicStaticFinalDegisken); // public static final degiskene erisildi
            System.out.println(staticPrivateDegisken); // static private degiskene erisldi
        }
        // Methodum static olasun ya da olmasin inner classim static ise, sarmalayici classimin yalnizca static elemanlartina erisebilir
    }

    public void LocalClassTanimi()
    {
        // Burada veya Sarmalayici class icerisinde {} kod blogu arasinda tanimlanan classtir
        // Erisim Durumu ic classlar ile aynidir
        // Yani, local class non-static ise sarmalayici classin her elemanina erisebilir
        // local class static ise sarmalayici classin yalnizca static elemanlarina erisebilir
        class LocalClass
        {
            public LocalClass() {} // constructor tanimlanabilir
        }
    }

    public static void Anonymous()
    {
        // Bir sinifin alt sinifi gibi tanimlanisi:
        SarmalayiciClass2 sarmalayiciClass = new SarmalayiciClass2() // degisken tanimlar gibi baslayip {}; ile block actik ve icine kodlarimizi yaziyoruz
        {
            public void ekranaYaz()
            {
                System.out.println("Anonymus class icindeki ekrana yaz methodu calisti");
            }
        };
        // buradaki ekrana yaz methodunu cagirmak icin sarmalayiciClass objesini kullaniriz
        // buradaki ekranaYaz() methodu orjinal ekrana yaz methodunu override etmiş, yani onu gecersiz kilmistir.

        // anonymous class icindeki ekranaYaz() methodunu calistiralim
        sarmalayiciClass.ekranaYaz();

        // nesne olusturarak sarmalayiciClass2 nini icindeki ekranaYaz() methodunu calistiralim
        SarmalayiciClass2 sarmalayiciClassObjesi = new SarmalayiciClass2();
        sarmalayiciClassObjesi.ekranaYaz();

        // Bir interfacein implementasyonu ngibi tanimlanisi:
        Arayuz arayuz = new Arayuz()  // interfaceden arayuz objesi olsuturduk ve ardindan {}; acarak anonymous class olusturup icine interface in istedigimiz methodu override ettik
        {
            @Override
            public void Yazdir() {
                System.out.println("Anonymous classin Yazdir methodu(interface)");
            }
        };
        // boylece tum interface i implement etmek yerine sadece istedigimiz methodlari implement edebiliriz

    }
}
    class SarmalayiciClass2
    {
        public void ekranaYaz()
        {
            System.out.println("Sarmalayici class icindeki ekrana yaz methodu calisti");
        }
        //
    }
    interface Arayuz
    {
        public void Yazdir();
    }

