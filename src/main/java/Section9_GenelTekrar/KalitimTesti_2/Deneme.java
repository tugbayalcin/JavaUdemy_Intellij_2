package Section9_GenelTekrar.KalitimTesti_2;



public class Deneme
{
    public static void main(String[] args) {
        {
            BSinifi b = new BSinifi(); // nesne olusturuldugu icin once statik alanlara ardindan ilkleme alanlarina ve en son constructora bakacagiz
        }
    }
}
class ASinifi
{
   static
   {
       System.out.println("static alan calisti");
   }

   {
       System.out.println("A nin ilkleme blogu calisti");
   }
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

class BSinifi extends ASinifi {
    {
        System.out.println("B nin ilkleme blogu calisti");
    }

    public BSinifi() {
        System.out.println(staticMethod(i));
    }
}

