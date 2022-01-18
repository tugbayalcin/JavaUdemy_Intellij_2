package Section10_Abstract_Interface_Inner.nestedClass.nonStaticNestedClass.memberInnerClass;

public class NestedClassKullanimi
{
    public static void main(String[] args)
    {
      String[] sehirler = {"Ankara","Bursa","İzmir"};

        // StringDiziYazdir sinifina dogrudan erisemiyorum, nesne ureterek erismeyi deneyelim
        // ancak burada inner classtan nesne uretecegimiz icin kodumuz su sekilde olacaktir:
        // (dikkatli incele) class.inner class obj = new class.new inner class
        // bunu yapabilmek icin inner class erisim bbelirteci private olmamali
        YaziciSinif.StringDiziYazdir nesne = new YaziciSinif().new StringDiziYazdir(); // 1.yol
        nesne.stringDiziYazdir(sehirler); // burada artik inner class elemanlarina (private olmayanlara) erisebiliyoruz

        YaziciSinif yaziciSinif = new YaziciSinif(); // 2.yol
        // classtan bir nesne olusturdum
        YaziciSinif.StringDiziYazdir stringDiziYazdir = yaziciSinif.new StringDiziYazdir();
        // nesneyi kullanarak class icine girdim ve inner class nesnesi olusturdum
        stringDiziYazdir.stringDiziYazdir(sehirler);

        System.out.println("3 tane ic ice classa erisim nasil olur gorelim");
        A.B.C nesne3 = new A().new B().new C();
        nesne3.methodC();

        A.B nesne4 = new A().new B();
        nesne4.methodB(); // buradan method C ye erisim yok. cunku C den nesne uretilmemis
        nesne4.new C().methodC(); //


    }
}
