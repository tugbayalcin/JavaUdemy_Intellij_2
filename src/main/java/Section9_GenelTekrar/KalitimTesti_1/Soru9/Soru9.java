package Section9_GenelTekrar.KalitimTesti_1.Soru9;

public class Soru9
{
    public static void main(String[] args)
    {
        BSinifi b = new BSinifi();
    }
}
class ASinifi
{
    int m = 222;

    {
        m = m++; // m=222;

        System.out.println(m); // m=222;
    }
}

class BSinifi extends ASinifi
{
    {
        System.out.println(methodB());
    }

    int methodB()
    {
        return m-- + --m;
    } // (222)+(221-1) (kullan=222)(1 azalt 221)+(1 azalt 220)(kullan=220)
}

/*
    cikti:
            222
            442
*/
