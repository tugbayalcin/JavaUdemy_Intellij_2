package Section12_CollectionFramework.Maps.hashMap;

import java.util.HashMap;
import java.util.Objects;

public class C127_HashMapCalismaMantigi
{
    public static void main(String[] args) {

        // Esit objeler, calisan bir process icinde aynı hash koduna sahip olmalidir.
        // Esit olmayan objelerin ayni hash code'lari olabilri
        // Dolayisiyla ayni hash koduna sahip objeler esit olamayabilir.
        // Yine bundan dolayi hashCode'lar key olarak kullanilmamalidir cunku bir yapida nadir de olsa collision olma ihtimali vardir
        // INDEX YAPISI VARDIR

        String st1 = "emre";
        String st2 = "hasan";
        String st3 = "emre";

        System.out.println(st1.hashCode()); // 3117275
        System.out.println(st2.hashCode()); // 99049543
        System.out.println(st3.hashCode()); // 3117275
        // emre'ler icin ayni hashCode yazdirdi, bunun sebebi String Pool idi
        // buradaki hashCode aslinda objemizin bellek adresi degildir.
        // objelerin bellek adreslerine erismek mumkun degildir
        // Bu hashCode bizim objemizin integer karsiligidir, baska bir sey degildir
        // hashCode()'nin uzerine gelirsen nasil hesaplandigini gorursun

        // peki benim kendi olusturdugum class ve objelerim icin de bu boyle midir bakalim
        Ogrenci ogr1 = new Ogrenci(1,"emre");
        System.out.println(ogr1.hashCode()); // 1134712904
        ogr1.i=2; // ogr1 objemizdeki i degerini degistirdik, isim ayni kaldi
        System.out.println(ogr1.hashCode()); // 1134712904
        // hashCode'da bir degisiklik olmadi
        // simdi de isim degerinde degisiklik yapalim
        ogr1.isim = "tugba yalcin";
        System.out.println(ogr1.hashCode()); // 1134712904
        // yine bir degisiklik olmadi (bana kalirsa objenin kendisini tuttugu icin beleee)
        // hoca diyor ki bu durum yazdirilan hashCode'un bellek adresi oldugunu kanitlamaz diyor (hala inanmiyorum)
        // hani biz burada kendi urettigimiz class'i kullandik ya
        // e biz hashCode() methodu filan override etmemistik, nereden geldi bu hashCode, bi uzerine gelipo de bakalim bakalim
        // tabiki de ata class olan Object class'indan geliyor amaaa
        // documantasyona baktigimizda native diye bir sey goruyoruz ki bu javaya ait bir sey degil
        // c++ diline ait bir sey, yani javanin arkasinda c ve c++ calisiyor
        // ve bu method kendi kafasina gore bize hashCode uretiyor

        Ogrenci ogr2 = new Ogrenci(2,"tugba yalcin");
        System.out.println(ogr2.hashCode());  // 985922955

        // note: bence hoca burada videoda yanlis bir ifade kullaniyor, hash bellek olsa idi obj1'in hash'i ile
        // obj2'nin hash i ayni olurdu diyor
        // hashleri ayni degil
        // hash bellek adresi de degil
        // ancak obj1 ve obj2 nin bellek adresler yani reference degerleri de FARKLIDIR
        // isim ve isim3 te reference ayni olabilir cunku bunlar string pool dedigimiz ozel bir bellekte tutuluyorlar
        // kendilerine ozel bir depolama sistemi var
        // ve diger objelerle bu sekilde kiyaslanamazlar

        // bunlarin disinda;
        // hashCode bir sifreleme algoritmasidir
        // veriyi kodlar
        // bizim anlamayacagimiz karisik bir yapiya donusturur
        // ancak hash cozucu methodlarla okundugunda tekrar anlamli haline geri doner
        // islevi ve gorevi verileri gizleyerek saklamaktir

        // hashCode != reference(yani bellek adresi)

        System.out.println("equals ve == karsilastirmasi");
        System.out.println(ogr1 == ogr2); // adres kontrolu yapar --> FALSE
        System.out.println(ogr1.equals(ogr2)); // icerik kontrolu yapar --> FALSE
        // equals tanimli degilse icerik kontrolu yapamaz ve hashCode() kontrolu yapar, bu iki nesne farkli oldugu icin
        // dolayisiyla farkli hash degerlerine sahip oldugu icin false doner
        System.out.println(ogr1.equals(ogr1)); // --> TRUE
        // burada equals tanimli olmadigi halde (override edilmedigi halde) true dondu
        // cunku hashcode'lari karsilastiriyor ve biz bir objeyi kendisiyle karsilastirdik
        // yani hash degeri ayni olmak zorundaydi zaten
        
        // simdi gidip ogrenci class'inda equals() ve hashCode() methodlarini override edelim

        // artikogrenci class'i icin equals methodu var oldugundan asagidaki kod artik true donduracektir
        System.out.println(ogr1.equals(ogr2)); // true
        System.out.println(ogr1.hashCode()); // 1642132382
        System.out.println(ogr2.hashCode()); // 1642132382
        // icerikleri ayni oldugu icin ayni hashCode'u olusturuyorlar

        // birbirine esit olan iki objenin hashCode'larinin ayni olmasi, hashMap'in duzgun calismasi acisindan onemlidir

        HashMap<String,Integer> map = new HashMap<>(); // bellekte default olarak 16 indexli bir array olustu (bu array'e table denir)
        map.put("emre",1);
        map.put("hasan",2);
        //  burada degerlerin ne oldugunun hicbir onemi yok
        // key olarak ne verildiyse onun hashCode'u hesaplanir

        // simdi; olaylari olus sirasiyla inceleyelim bakalim arkada neler oluyor
        // 1. yukarida gorduk ki hashCode methodu key degerini alarak onu bazi matematiksel islemmlerden gecirerek hashCode uretiyor
        // 2. uretilen hashCode bir algoritmadan geciriliyor ve boylece bu elemanin table'da hangi indise konulacagina kara veriyor
        // bu arrayin her eleman icin (her indexte) bucket denilen kutucuklari var ve veriler (onlara da node diyoruz) bu bucketlarda tutuluyor
        // nodelar 4 bolmeden olusur: ilk bolmede key, ikinci bolmede value, ucuncu bolmmede hashCode ve dorduncu bolmede next yazar, baslangicta null tutar

        // peki madem keyler belli bir mmatematiksel formule gore hash'e donusturuluyor
        // o zaman birbirinden faklı keylerin hash'i ayni cikamaz mi ya da hash'i farkli olsa bile
        // index bulma algoritmasi bu iki hash'e ayni index'i gosteremez mi  --> gosterebilir hatta buna collision denir
        // cikarsa ne olur --> ayni hash'ler ayni index degeri ureteceginden her iki elemani da ayni index'e mi koyacagim
        // ikinci eleman gelip bakacak ki kendisine uygun gorulen index dolu, gelip onun uzerine de oturamaz, yoksa ilk eleman ezilir gider kaybolur ve erisemeyiz
        // o zaman der ki ben de senin yanina gelip oturayim
        // ve o indexte/baskette bir node daha acilarak obje verileri buraya yazilir
        // ve artik ilk objenin next kutusu null tutmaz
        // bu 2. objeyi gosterir


        // null degerler'in hash'inin neye gore hangi class'a gore hesaplanacagi belliolmadigindan
        // dogrudan 0. index'e yazilirlar
        // farklı hashCode'larin ayni index degerini uretebilecegini unutma !!!






    }
}

class Ogrenci
{
    int i;
    String isim;

    public Ogrenci(int i, String isim) {
        this.i = i;
        this.isim = isim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // birebir olarak ayni reference degerini gosterip gostermedigini kontrol eder
        if (!(o instanceof Ogrenci)) return false; // Buraya gelen parametre bir ogrenci instance'i mi ona bakiyor zaten degilse karsilastirmaya hic gerek yok diyor (instanceof = polymorphism olmasaydi)
        Ogrenci ogrenci = (Ogrenci) o; // data casting yapip bir ogrenci degiskenine atiyor
        return i == ogrenci.i && Objects.equals(isim, ogrenci.isim);
            // benim class'imdaki i degiskenim, parametre olarak gelen objenin i degiskenine esitse VE
            // (burada deger integer olduug icin == ile karsilastirma yapiliyor)
            // Objects class'indaki equals methodu gelsin ve bu class'daki isim ile karsilastirma yapilan objenin isim degiskeni
            // ayni mi baksin
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, isim); // Objects class'indaki hash methodu gelsin ve bu class'daki isim ile i degiskeni icin
                                      // hash olustursun
    }
}
