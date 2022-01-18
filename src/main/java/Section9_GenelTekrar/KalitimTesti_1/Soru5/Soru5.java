package Section9_GenelTekrar.KalitimTesti_1.Soru5;

public class Soru5
{
    public static void main(String[] args)
    {
        BSinifi.staticMethod(); // Burada statik olmayan bir Class ile static bir methoda erismeye calisiyoruz, BLOCK DEGİL DİKKAT!!!
        // static methodlar herhangi bir obje olusturmaya gerek kalinmaksizin, dogrudan class isimleri ile cagirilabilirler
        // eger classimda tanimlanmis bir statik method cagiriliyor ise, direk classimdaki yazdirilir, ust classlara bakilmaz

    }
}
class ASinifi
{
    static void staticMethod()
    {
        System.out.println("ASinifi");
    }
}

class BSinifi extends ASinifi
{
    static void staticMethod()
    {
        System.out.println("BSinifi");
    }
}
/*
    cikti: B Sinifi
*/
