package Section9_GenelTekrar.KalitimTesti_2.Soru6;

public class Soru6
{
    public static void main(String[] args)
    {
        System.out.println(new BSinifi().statikDegisken); // obje sout icinde tanimlanmis ve herhangi bir degiskene atanmamis, tek bir kes kullanilip yok olacak
    }
}
class ASinifi
{
    static int statikDegisken; // bu degiskene default olarak 0 atandi.

    static
    {
        statikDegisken++; // burada 1 oldu, diger methodun statigine gececek
    }

    {
        ++statikDegisken; // burada tekrar 1 oldu
    }
}

class BSinifi extends ASinifi
{
    static
    {
        --statikDegisken; // burada 0 oldu
    }

    {
        statikDegisken--; // burada tekrar 0 oldu
    }
}
