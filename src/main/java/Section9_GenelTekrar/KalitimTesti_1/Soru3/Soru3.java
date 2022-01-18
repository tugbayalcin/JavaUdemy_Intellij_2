package Section9_GenelTekrar.KalitimTesti_1.Soru3;

public class Soru3
{
    public static void main(String[] args)
    {
        CSinifi c = new CSinifi(); // bu satir yalnizca Sinif A ve Sinif B yazdirdi

        System.out.println(c.metin); // bu satir Sinif C yazdirdi,
        // eger C sinifinda metin = "Sinif C" olmasa idi, gidip bir ust sinifa bakacak ve eger bulursa yazdiracakti

    }
}
class ASinifi
{
    String metin = "Sınıf A"; // bu classta herhangi bir yazma eylemi yok, yalnizca atama var
}

class BSinifi extends ASinifi
{
    String metin = "Sınıf B"; // B classinin metin degiskenine atama yapildi

    {
        System.out.println(super.metin); // A classinin metin degiskeni yazdirildi
    }
}

class CSinifi extends BSinifi {
    String metin = "Sınıf C"; // C classinin metin degiskenine atama yapildi

    {
        System.out.println(super.metin); // B classinin metin degiskeni yazdirildi
    }
}

/* cikti:
           Sinif A
           Sinif B
           Sinif C

* */
