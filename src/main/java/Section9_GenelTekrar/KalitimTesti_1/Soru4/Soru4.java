package Section9_GenelTekrar.KalitimTesti_1.Soru4;

public class Soru4
{
    public static void main(String[] args)
    {
        CSinifi c = new CSinifi();
    }
}
class ASinifi
{
    static
    {
        System.out.println("333");
    }

    public ASinifi(){
        System.out.println("A Kurucusu");
    }
}

class BSinifi extends ASinifi
{
    static
    {
        System.out.println("222");
    }

    public BSinifi(){
        System.out.println("B Kurucusu");
    }

}

class CSinifi extends BSinifi
{
    static
    {
        System.out.println("111");
    }

    public CSinifi(){
        System.out.println("C Kurucusu");
    }
}
/*
    cikti:
    333
    222
    111
    A Kurucusu
    B Kurucusu
    C Kurucusu

    NOTES:
    Sınıflardaki static alanlar nesne oluşturulduğunda ilk tetiklenen alanlardır
    dolayisi ile once statik alanlardaki kodlar çalıştırılır,
    sonrasınıda kurucu metotlar üst sınıftan alt sınıfa doğru tetiklenir.

    static alanlara class adi ve obje ile erisebiliyoruz
    static
*/
