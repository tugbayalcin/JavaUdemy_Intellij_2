package Section10_Abstract_Interface_Inner.modifiers.accessModifiers;

public class Denemeler
{
    int a=5;
    String isim1 = "emre";
    static String adres1 = "Etobicoke";
    final String soyisim1 = "duman";
    final static String memleket1 = "Kayseri";

    void method ()
    {
        int i=0;
    }

    final void finalMethod() // override edilemez !!!
    {
        int j=1;
    }

}
// class Cocuk extends FinalClass --> final class extend edilemez !!!
final class FinalClass extends Denemeler
{
    int b =6;
    String isim = "tugba";
    static String adres = "Istanbul"; // constructorda yer almaz
    final String soyisim = "yalcin"; // constructorda yer almaz
    final static String memleket = "Bartin"; // constructorda yer almaz

    public void setIsim(String isim)  // isim degiskenine yeni deger atamasi yapildi
    {
        this.isim = "yeni isim";
    }

    public static void setAdres(String adres)  // adres degiskenine yeni deger atamasi yapildi
    {
        FinalClass.adres = "yeni adres";
    }

    public String getSoyisim()  // setter methodu yok, yalnizca cagirabiliyorum, yeni atama yapamiyorum
    {
        return soyisim;
    }

    public static String getMemleket()  // setter methodu yok, yalnizca cagirabiliyorum, yeni atama yapamiyorum
    {
        return memleket;
    }

    public FinalClass(int b, String isim) {
        this.b = b;
        this.isim = isim;
        super.a =9;
        super.isim1 = "isim1";
        // super.soyisim1 = "soyisim1"; final oldugu icin hata verdi
        super.method();
        super.finalMethod(); // override edemiyorum ama bu sekilde cagirabiliyorum. Burasi zaten git superimdeki methodu calistir demek
    }


    @Override // final olmayan method overrie edildi
    void method() {
        super.method();
    }
    // final method override edilemez

}

