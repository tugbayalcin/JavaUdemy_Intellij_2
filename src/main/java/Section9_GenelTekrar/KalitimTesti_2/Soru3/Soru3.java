package Section9_GenelTekrar.KalitimTesti_2.Soru3;

public class Soru3 extends ASinifi // extend edildigi icin statik blocklar tetiklenmis oluyor
{
    static
    {
        a++; // 1
    }

    static
    {
        --b; // 1413
    }
    public static void main(String[] args)
    {
        System.out.println(a);

        System.out.println(b);
    }
}
class ASinifi // main method icerisinde A sinifinfan nesne uretilmedigi surece burasi asla calismayacak
{
    static int a, b = 1414; // java varsayilan olarak a=0 atıyor b=1414

    {
        --a; // nesne uretilmedigi icin kullanilmayacak
    }

    {
        b++; // nesne uretilmedigi icin kullanilmayacak
    }
}
// tuzak soru!!!
// eger main methodda nesne uretilmiyorsa classlar icindeki ilkleme bloklari, constructorlar tetiklenmez,
// dolayisi ile calismaz
