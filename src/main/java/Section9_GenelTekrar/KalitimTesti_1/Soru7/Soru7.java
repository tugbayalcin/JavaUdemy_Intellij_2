package Section9_GenelTekrar.KalitimTesti_1.Soru7;

public class Soru7
{
    public static void main(String[] args)
    {
        N n = new N(10); // demek ki N classinda bir constructor var ve parametre olarak int deger aliyor,
        // soru cozerken bunun dogrulugunu kontrol etmen gerekiyor
    }
}
class M
{
    int i;

    public M(int i) // N classindaki silemlerden sonra buraya 11 atandi
    {
        this.i = i--; // i degiskenini bu sinifta bulunan i uye ata ve sonrasinda i yi bir azalt -->
        // artik M classindaki i=11 oldu ve de genel i=10 oldu. bu bizim hicbir isimize yaramaz.
        // atamadan sonraki degisiklik bizi ilgilendirmez, yemdir, kanma :)
    }
}

class N extends M
{
    public N(int i) // -->main methodda constructor icine yazilan 10, gelip buraya atanir
    {
        super(++i); // --> elindeki i degerini 1 arttir, 11 yap ve git bu 11 i ust sinifinda constractorunda integer alan yerdeki i ye ata

        System.out.println(i);
    }
}

/*
    cikti: 11
*/
