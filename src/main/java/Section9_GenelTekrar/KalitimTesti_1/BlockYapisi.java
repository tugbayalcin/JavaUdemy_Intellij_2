package Section9_GenelTekrar.KalitimTesti_1;

public class BlockYapisi
{
    // statik degisken ve blocklar yalnizca BIRKES-BIRGEC calisir
    public static void main(String[] args)
    {
        //sadece declare olan degisken/variablelar compiler tarafindan islem gormezler.
        String s;//yari pri+refe
        int aa;//tam pri
        ASinifi ac;//tam refe
        ASinifi a = new ASinifi();//A classi ziyaret edildi
        System.out.println("************");
        BSinifi b = new BSinifi();//A classi B'nin babasi oldugu yine ziyaret edilecek


        ASinifi c = new BSinifi();//-polimorphism-cokbicimlilik
    }
}
class ASinifi
{
    static int a=52;//static variable/ class variable

    int b=10;//field/ property/instance-object variable/member variable
    static
    {
        System.out.println("A static block");
    }
    // instance initialization block
    {
        System.out.println("A instance initialize block");
    }
    public ASinifi()
    {
        System.out.println("Constructor A");
    }

    static void AsinifiStaticMethodu()//methodlar cagrilarak calistirildiklari icin, ASinifi a = new ASinifi(); satiri da
    //bu statik methodu cagirip calistirmadigi icin de bu method calismadi
    //calistirmak istersek -> ClassName.StaticMethodName ya da ClassObjectName.StaticMethodName
    {
        System.out.println("A Class'i - Static Methodu");
    }
}
class BSinifi extends ASinifi
{
    static int a=52;
    int d=3;

    //birden fazla static block varsa sirasiyla calistirilirlar- VE SADECE BIRKES CALISIRLAR
    static
    {
        System.out.println("B static block");
    }
    static
    {
        System.out.println("B static block 2");
    }
    // instance initialization block
    {
        System.out.println("B instance initialize block");
    }
    public BSinifi()
    {
        System.out.println("Constructor B");
    }
}
/*
    NOTES:
    * Calisma Sirasi:
    1.Static alanlar
    2.Instance Initialize Block
    3.Constructor

    * KALITIMDA ISE;
    1.ust siniftan baslanarak oncelikler static methodlar calisir
    2.ust siniftan baslayarak sinifin initialize blocku ve constructor methodlari calisir ve bitince bir alt sinifa gecer
*/
