package Section9_GenelTekrar.KalitimTesti_2.Soru1;

public class Soru1
{
    public static void main(String[] args)
    {
        BSinifi b = new BSinifi(); // nesne olusturuldugu icin once statik alanlara ardindan ilkleme alanlarina ve en son constructora bakacagiz
    }
}
class ASinifi
{
    int i = 1010;

    public ASinifi()
    {
        i = i++ + i-- - i; // 1010+1011-1010=1011
    }

    static int staticMethod(int i)
    {
        return --i; // 1010 donecek
    }
}

class BSinifi extends ASinifi
{
    public BSinifi()
    {
        System.out.println(staticMethod(i));
    }
}
// b objesi olusurken, kalitim aldigi classtan itibaren
// 1. statik blogu var mı
// 2. isimsiz blogu var mı
// 3. artik constructor ımı calistirabilirim
// b a dan kalitim aldigi icin once a nin constructor ı calisacak
// constructor statikmethoda git ve i yi cagir diyor