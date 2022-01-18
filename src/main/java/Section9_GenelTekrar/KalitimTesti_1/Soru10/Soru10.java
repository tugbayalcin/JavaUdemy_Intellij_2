package Section9_GenelTekrar.KalitimTesti_1.Soru10;

public class Soru10
{
    public static void main(String[] args)
    {
        BSinifi b = new BSinifi();
    }
}
class ASinifi
{
    static String metin = "AAA";

    static
    {
        metin = metin + "BBB"; // AAABBB 1
    }

    {
        metin = "AAABBB"; // AAABBB 3
    }
}

class BSinifi extends ASinifi
{
    static
    {
        metin = metin + "BBBAAA"; // AAABBBBBBAAA 2
    }

    {
        System.out.println(metin); // 3
    }
}

/*
        cikti:
                AAABBB
*/

