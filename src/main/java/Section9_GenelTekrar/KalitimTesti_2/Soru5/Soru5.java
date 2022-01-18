package Section9_GenelTekrar.KalitimTesti_2.Soru5;

public class Soru5
{
    public static void main(String[] args)
    {
        BSinifi b = new BSinifi(); // nesne uretildi, constructorlar calisacak, constructor yok, static alan yok, ilkleme alani yok, method var, methoda erisebilmem icin objeye ihtiyacim var

        System.out.println(b.bMetotu(50)); // b nesnesi uzerinden methoda erisecegiz
    }
}
class ASinifi
{
    int methodOfA(int i) // i  buraya 250 olarak geldi
    {
        i /= 10; // 250/10=25 i artik 25 oldu

        return i; // i=25 bi dondur
    }
}

class BSinifi extends ASinifi
{
    int bMetotu(int i) // yukaridan i=50 geldi
    {
        i *= 5; // i= 250 oldu

        return methodOfA(i); // bu olusan i yi al methodOfA ya koy diyor
    }
}

