package Section10_Abstract_Interface_Inner.nestedClass.staticNestedClass;

public class CerceveSinif
{

        /*
        inner classlar ikiye ayrilir:
            1.Static Olmayan Inner Classlar
                1.1 Member
                1.2 Local
                1.3 Anonymouscx
            2.Static Olan Inner Classlar
            Kural: Inner class static ise dis siniftaki nesnelerden yalnizca static olanlara erisebilir, digerlerine erisemez
            inner class abbstract olabilir ancak inner class icindeki static memthod olamaz
         */

        int nesneDegiskeni;
        static int staticDegisken;
        public void method(){}
        static void staticMethod(){}

    static class IcSinif // abstract olabilir
    {
        int icSinifNesneDegiskeni;
        static int icSinifStaticDegisken;
        public void icSinifMethodu()
        {
            staticDegisken++;
            staticMethod();
        }
        static void icSinifStaticMethodu(){} // abstract olamaz

    }



}
