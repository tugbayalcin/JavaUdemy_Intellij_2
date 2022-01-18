package Section9_GenelTekrar.KalitimTesti_2.Soru7;

public class Soru7
{
    public static void main(String[] args)
    {
        Main main = new Main(5, 10); // nesne uretilmis, Main classta 2 tane integer deger alan constructor olmali yoksa hata aliriz
    }
}
class Main {
    public Main(int i, int j)
    {
        System.out.println(method(i, j));
    }

    int method(int i, int j)
    {
        return i++ + ++j; // i yi kullan sonra bir arttir, j yi arttir ondan sonra kullan
    }
}

