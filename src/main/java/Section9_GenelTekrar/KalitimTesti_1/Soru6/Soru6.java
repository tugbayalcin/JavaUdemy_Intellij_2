package Section9_GenelTekrar.KalitimTesti_1.Soru6;

public class Soru6
{
    public static void main(String[] args)
    {
        BSinifi n = new BSinifi();
    }
}
class ASinifi
{
    static
    {
        System.out.println('1');
    }
    // isimsiz blok--> static bloctan sonra, constructordan once calisir calisir
    {
        System.out.println('2');
    }

    public ASinifi()
    {
        System.out.println('3');
    }
}

class BSinifi extends ASinifi
{
    static
    {
        System.out.println('4');
    }

    {
        System.out.println('5');
    }

    public BSinifi()
    {
        System.out.println('6');
    }
}
/*
    cikti:
            1
            4
            2
            3
            5
            6

            NOTES:
          * Calisma Sirasi  Su Sekilde
            1.en ustten baslayarak tum static alan ve methodlar sirari ile calisir
            2.en ust classa tekrar gidilir, isimsiz alanlar varsa once onlar, ardindan constructor calisir ve bir alt classa gecilir

*/
