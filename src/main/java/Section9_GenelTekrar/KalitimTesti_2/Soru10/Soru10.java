package Section9_GenelTekrar.KalitimTesti_2.Soru10;

public class Soru10
{
    public static void main(String[] args)
    {
        BSinifi b=new BSinifi(); // obje uretildi, staticler ilkleme bloklari ve constructorlar calisacak
        System.out.println(b.degisken+" statik:"+BSinifi.statikDegisken);
    }
}
//B sinifindan nesne üretilirse statikDegisken ve degisken değerleri sırasıyla ne olur

class ASinifi
{
    static int statikDegisken = 222; // burasi 110 oldu

    int degisken = 111;

    {
        statikDegisken = statikDegisken++ - ++degisken; // 222 yi kullan sonra 1 arttir, degiskeni once arttir sonra kullan -->110 , degisken artik 112
    }
}

class BSinifi extends ASinifi
{
    {
        degisken = statikDegisken-- + --degisken; // 110 u kullan sonra 1 azalt, static degisken artyik 109, degiskeni once azalt sonra kullan  112-1 kullanilacak-->221
    }
}
