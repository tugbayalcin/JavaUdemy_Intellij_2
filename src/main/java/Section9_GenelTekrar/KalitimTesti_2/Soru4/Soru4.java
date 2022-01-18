package Section9_GenelTekrar.KalitimTesti_2.Soru4;

public class Soru4 extends ASinifi // extend edildigi icin static methodlar tetiklendi
{
    {
        a = new int[5]; //  baba classtan kalittigim a degiskenine yeni bir dizi atıyorum, o da 5 elemanli, tum elemanlari 0, ve eski dizi artik erisilemez
    }

    {
        System.out.println(a[0]);
    }

    public static void main(String[] args)
    {
        Soru4 main = new Soru4(); // Soru4 classindan nesne uretilmis, ilkleme alanlari calisacak
    }
}
class ASinifi
{
    int[] a = new int[5]; // 5 elemanli dizi uretildi

    {
        a[0] = 10; // ilk elemanina 10 atandi, diger elemanlara vartsayilan olarak  atandi
    }
}
