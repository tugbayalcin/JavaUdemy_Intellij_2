package Section8_Inheritance;

import java.sql.SQLOutput;

public class ImmutableString
{
    public static void main(String[] args)
    {
        // STRING; REFERANCE TIPLI BIR VERIDIR, PRIMITIVE DEGILDIR !!!
        // STRİNG POOL'DA TUTULAN STRİNGLER IMMUTABLE'DIR, YANI DEGISTIRILEMEZLER, SABITTIRLER

        // String name = ”metin”; --> string poolda depolandi, yani ayni metni iceren yalnizca 1 kutu olacak ve o metne giden tum degiskenler ayni reference adresini tutacak
        // String name = new String(“metin”); --> heapte depolandi, her new dedigimizde yeni bir kutu olustu ve her birinin reference adresi farkli

        String isim = new String("tugba");
        String ad = new String("tugba");

        System.out.println(isim==ad); // FALSE dedi cunku reference karsilastirdi ve bu stringler string poolda degil
        System.out.println(isim.equals(ad)); // TRUE dedi cunku icerik karsilastirdi

        String abc = "tugba";
        String def = "tugba";
        String def2 = "tugba"; // def, def2, def3, def degiskenlerinin hepsi ayni kutuyu gosteriyor
        String def3 = "tugba"; // string poolda yalnizca 1 tane tugba yazan kutu var, degisken sayisi kadar tugba yazmiyor, zaten tekrari engellemek icin string pool var
        String def4 = "tugba"; // def, def2, def3, def degiskenlerinin tuttgu reference degerleri ayni

        abc = "tugba yalcin"; // gidip tugba yazan kutunun icine yalcin eklemedi, eski kutu cop oldu, gidip yepyeni bir kutu olusturup icine tugba yalcin yazdi
        System.out.println(def); // tugba yazdi --> abc nin degismesi digerlerini etkilemedi, cunku abc artik byeni bir kutuya gidiyor, eski kutu degismedi String poolda bulunan stringler bu yuzden ımmutabledir
        System.out.println(abc==def); // TRUE dedi cunku bu degiskenler string poolda tek 1 kere tek 1 kutuda depolandi

        // concat() methodu, degiskenimizin sonuna bir seyler eklemeye yarar
        String xyz = "tugba";
        xyz.concat(" yalcin");
        System.out.println(xyz); // yine tugba yazdi
        // bu demek oluyor ki gercekten string pooldaki kutunun icine gidip ekleme yapamiyoruz
        // xyz.concat(" yalcin") dedigimizde java gitti string poolda yeni bir kutu acti,
        // once icine xyz nin tuttugu degeri sonra da concat icine girilen degeri yazdi
        // biz xyz.concat(" yalcin") ifadesini bir degiskene atamaz isek o kutuya erisemeyiz
        String yeni = xyz.concat(" yalcin"); // artik kutumuzun reference degerini tutan bir degiskenimiz var
        System.out.println(yeni);

        String soyisim = new String("yalcin");
        String soyad = "yalcin";

        System.out.println(soyisim==soyad); // FALSE cunku ayni kutuda degiller biri string poolda diğeri heapteki serbest alanda

        // eger ben obje gibi tanimladigim bir stringi string poola yerlestirmek istiyorsam soyle yaparim
        String adres = new String("Istanbul").intern();
        // boylece istanbul hem heapte hem de string poolda yer aldi, artik adres degiskeni iki tane reference adresi tutuyor
    }
}
