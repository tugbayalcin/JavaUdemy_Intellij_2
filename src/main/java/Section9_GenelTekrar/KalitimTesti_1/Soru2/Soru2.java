package Section9_GenelTekrar.KalitimTesti_1.Soru2;

public class Soru2
{
    public static void main(String[] args)
    {
        CSinifi c = new CSinifi();
    }
}
class ASinifi
{
    // asagidaki blok default block/ instance initialization block yapisidir
    {
        System.out.println(1);
    }
}

class BSinifi extends ASinifi
{
    {
        System.out.println(2);
    }
}

class CSinifi extends BSinifi
{
    {
        System.out.println(3);
    }
}

/*
 Cıktısı:
            1
            2
            3
 NOTES:
  * Javada bir nesne üretildiğinde kurucu metot tetiklenir.
  * Bu kurucu metottan önce çalışan bazı yapılarımız bulunur bunlar statik bloklar ve isimsiz bloklardır.
  * C sınıfından bir nesne üretildiğinde üst sınıftan alt sınıfa dogru isimsiz kod blokları da tetikleneceği için
  * ekranda sırasıyla 1 2 3 değerleri görülür
 */

