package Section9_GenelTekrar.KalitimTesti_2.Soru2;

public class Soru2
{
    public static void main(String[] args)
    {
        ASinifi a = new ASinifi(); // heapte a objesi var

        BSinifi b = new BSinifi(a); // heapte b objesi var, ancak b a'dan kalitim aldigi icin b icinde de a var ve bu a, A classindaki a nin bellek adresini tutuyor

        System.out.println(a.i); //  ekrana a nin icindeki i yi yazdir -->1010
        System.out.println(b.i); // b de i yok, superindaki i yazilir 1010

        System.out.println(b.a.i); // b.a demek b nin icindeki a ya git demek, o da referans tuttugu icin bizi A daki a ya goturur ve oradaki i yi yazariz -->1010

        b.a.i = 3232;

        System.out.println("--------");

        System.out.println(a.i); // a nin icindeki i degismisti --> 3232

        System.out.println(b.i); // b nin icindeki i hic degismedi -->1010
    }
}
class ASinifi
{
    int i = 1010;
}

class BSinifi extends ASinifi
{
    ASinifi a; // a sinifindan obje olustu, bu obje bizi ASinifina goturecek kapı, bu objeye atanan

    public BSinifi(ASinifi a)
    {
        this.a = a; // a: ASinifi@780   a: null
    } // constructora girilen objeyi bendeki a sinifi objesine atadik, a sinifi objesi girilen a nin referansini tutuyor
}

