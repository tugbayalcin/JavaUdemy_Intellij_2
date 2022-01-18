package Section8_Inheritance;

public class StringClassMethods
{
    public static void main(String[] args)
    {
        String isim = "   tugba   ";
        System.out.println(isim.length()); // .LENGTH: verilen stringin kac karakterden olustugunu soyler, geriye int deger dondurur
        System.out.println(isim.charAt(5)); // .CHARAT: girilen indekste bulunan karakteri verir
        System.out.println(isim.concat("yalcin")); // .CONCAT: girilen stringi verilen stringin sonuna ekler, ama isim degismez, yeni bir kutu olusur, bu ifadeyi elde etmek istiyorsan yeni bir degiskene ataman gerekir
        String yeni = isim.concat("yalcin");
        System.out.println(yeni);
        System.out.println(yeni.toUpperCase()); // .TOUPPERCASE: stringin butun karakterlerini buyuk harfe cevirir
        System.out.println(yeni.toLowerCase()); // .TOLOWERCASE: stringin butun karakterlerini kucuk harfe cevirir
        System.out.println(isim.trim()); // .TRİM: stringin basindaki ve sonundaki bosluklari siler. String degistirilemez oldugu icin aslinda yeni bir kutu olusur, isim bundan etkilenmez,u ifadeyi elde etmek istiyorsan yeni bir degiskene ataman gerekir
        String yepyeni = isim.trim();
        System.out.println(yepyeni);

        // Bir nesne yardimi ile ulasilabilen methodlara instance method denir. isim.concat() gibi.
        // Burada isim bir nesne, concat() ise instance methoddur

        String ay = "Haziran";
        String ay2 = "Mart";
        String ay4 = "Mart";
        String ay5 = "mart";
        System.out.println(ay.equals(ay2)); // FALSE
        System.out.println(ay4.equals(ay2)); // TRUE
        System.out.println(ay4.equalsIgnoreCase(ay5)); // .EQUALSIGNORECASE: stringleri bbuyuk kucuk harfe bakmaksizin karsilastirir
        System.out.println(ay.compareTo(ay2)); // .COMPARETO: stringleri alfabetik olarak karsilastirir, esitse 0,ay alfabede daha once ise -1, daha sonra ise +1 dondurur
        System.out.println(ay.startsWith("H")); // .STARTSWITH: stringim girilen harf ile mi basliyor ona bakar ve true ya da false dondurur, buyuk kucuk harf duyarliligi vardir
        System.out.println(ay.endsWith("n")); // .ENDSWITH: stringim girilen harf ile mi bitiyor
        System.out.println(ay.contains("an")); // .CONTAINS: girilen string veya char ifade benim stringimde yer aliyor mu ona bakar ve true false dondurur
        System.out.println(yeni.trim().substring(3)); // .SUVBSTRING: aldigi parametre sayisina gore, stringimin girilen indeksten sonraki kismini veya  girilen indeksler arasinda kalan kismini yazdirir
        System.out.println(yeni.trim().indexOf("b")); // .INDEXOF: girilen karakterin stringimde ilk defa hangi indekste kullanildigini soyler
        System.out.println(yeni.trim().lastIndexOf("a")); // .LASTINDEXOF: girilen karakterin stringimde son defa hangi indekste kullanildigini soyler

        System.out.println("tugba"+"yalcin"+5+". sinif");
        // burada + operatoru concate olarak gorev yapacaktir.  arada int deger olmasina ragmen islem string ifade icverdigi icin
        // tum veriler string olarak kabul edilir ve islem devam eder
        System.out.println(5+6); // burada ise + operatoru asli gorevini gerceklestirir

        int sayi=5;
        int sayi2=6;
        String sayi3 = "4";
        System.out.println(sayi+sayi2); // sayilari topladi
        System.out.println(sayi+sayi3); // burada sayilari toplayamaz, hepsine string muamelesi yapar ve 5 in yanina  yazar
        // eger toplamasini istiyorsak bir cesit type cating yapmamiz gerekir
        System.out.println(Integer.parseInt(sayi3)+sayi); // .WRAPPER.PARSWRAP : stringleri ilgili primitive tiplere dondurur

    }
}
