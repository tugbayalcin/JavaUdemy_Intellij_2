package Section9_GenelTekrar.KalitimTesti_1.Soru1;

public class Soru1
{
    public static void main(String[] args)
    {
        A a = new B();
        // burada a: obje, A Classi: Declaration Type,   B Classi:Actual Type
        // a objesi ile A classinin verilerine erisebiliriz, B'ye erisemeyiz
        // Ancak B Classi A Classindan kalitildigi icin her ikisinde de ortak olan methodlar olacaktir (B de override edilmis halde)
        // bu durumda a objesi ortak methodlardan birine erismek istediginde B Classindaki method calisacaktir,
        // method B'de yoksa bir ust sinifa bakilir ve bulunan ilk classta calistirilir
        System.out.println(a.i);

    }
}class A
{
    int i = 30;
}

class B extends A
{
    int i = 50; // aslinda buradaki i degiskeni kalitilmamis, j gibi bambaska bir degisken
}
/*
    CIKTISI NEDİR: 30

    NOTES:
   * Polymorphism'de objenin scope alani super classtir.
   * Obje sub classin yalnizca ve yalniza super classtan override ettigi methodlara erisebilir ve calistirabilir
   * Aranan method sub classta override edilmis olarak bulunmuyorsa sirasiyla bir ust classa bakilarak arama yapilir
*/


