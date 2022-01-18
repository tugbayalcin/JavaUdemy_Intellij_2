package Section10_Abstract_Interface_Inner.nestedClass.nonStaticNestedClass.memberInnerClass.InnerClassExample;

public class Main
{
    public static void main(String[] args)
    {
        HesapMakinesi hm = new HesapMakinesi();

        HesapMakinesi.Toplama toplayici = hm.new Toplama();
        int toplam = toplayici.topla(5,6);
        System.out.println("Toplam:"+ toplam);

        HesapMakinesi.Cikarma cikarici = hm.new Cikarma();
        int fark = cikarici.cikar(9,4);
        System.out.println("Fark:"+fark);

        // daha farkli bir sekilde erismek isteyelim. tipki method cagirir gibi class cagirmak istiyoruz.gittik carpma classini private yaptik
        // gittik hesap makinemize methodumuzu yazdik, icini yukaridakine benzer bir sekilde doldurduk ve burada kullanacagiz
        int carpim = hm.carpma(6,4);
        System.out.println("Carpim:"+carpim);

        // local inner class ile yapalim
        String bolum = hm.bolme(10,2);
        if(!bolum.equals(" "))
        {
            System.out.println("Bolum:"+bolum);
        }


    }
}
