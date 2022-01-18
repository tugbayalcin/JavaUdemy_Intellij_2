package Section9_GenelTekrar.KalitimTesti_1.Soru8;

public class Soru8
{
    public static void main(String[] args)
    {
        BSinifi b = new BSinifi(15); // B sinifinda integer deger alan bir constructor var imis, var mı muhakkak bak!

        System.out.println(b.i); // i=150; --> YAZDIRILDI --> 3. YAZDIRMA
    }
}
class ASinifi
{
    int i = 21;

    public ASinifi(int j) // alt siniftasi super(j) satirindan dolayi buraya 15 geldi
    {
        System.out.println(i); // class icinde i = 21 tanimlanmis, degisiklik yok i=21; YAZDIRILDI--> ILK YAZDIRMZ

        this.i = j * 5; // 15*5=75 --> A sinifinin i degiskenine git 75'i ata. --> i=75
    }
}

class BSinifi extends ASinifi
{
    public BSinifi(int j) // mmain methoddan gelen 15 i aldik buraya atadik
    {
        super(j); // bir ust classa git ve oraya 15 degerini ata

        System.out.println(i); // A classindan buraya i=75 olarak geldi --> YAZDIRILDI --> 2. YAZDIRMA

        this.i = j * 10; // B classi icindeki i ye 15*10=150 degerini ata demek --> i=150; --> maindeki 2. satir tarafindan cagirilinca YAZDIRILDI
    }
}
/*
    cikti:
            21
            75
            150
*/
