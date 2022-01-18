package Section7_JavaOOP.bolumSonuOdevler;

public class BolumSonuOdev_1
{   // SORU1: CemberDaire isimlibir sinif olusturun. Bu sinifin yarişcap alan bir kurucusu olsun.
    // cevre ve alanini hesaplayan methodlar yazin

    public static void main(String[] args)
    {
        CemberDaire cember1 = new CemberDaire(5);
        System.out.printf("Yaricapi 5 olan cemberin cevresi: %.2f", cember1.cevreBul()); // virgulden sonra 2 basamagi kullanmasi icin boyle yazdik ve printf kullandik
        System.out.printf("\nYaricapi 5 olan dairenin alani: %.2f", cember1.alanBul());
    }
}

class CemberDaire
{
    private int yaricap;
    public final static double PI=3.14;

    public CemberDaire(int r)
    {
        this.yaricap=r;

    }
    public double cevreBul()
    {
        return 2*PI*yaricap;

    }
    public double alanBul()
    {
        return PI*Math.pow(yaricap, 2);

    }
}
