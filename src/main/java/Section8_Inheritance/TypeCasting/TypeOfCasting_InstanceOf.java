package Section8_Inheritance.TypeCasting;

public class TypeOfCasting_InstanceOf
{
    // instanceof: herhangi bir nesnenin belirtilen ture ait olup olmadigina bakar, true ya da false dondurur
    public static void main(String[] args)
    {
        GeometrikSekil gs1 = new GeometrikSekil();
        Kare k1 = new Kare(5);
        Dikdortgen d1 = new Dikdortgen(10,12);

        GeometrikSekil gs2 = new Kare(5); // alt sinif ust sinifa otomatik olarak donusturulur. IMPLICIT/DOLAYLI YOLDAN CASTING
        GeometrikSekil gs3 = new Dikdortgen(5,10); // alt sinif boyut olarak  ust sinifa esit veya buyuktur
        Dikdortgen d2 = new Kare(5);
        // her kare bir dikdortgen, her dikdortgen bir geometrik sekil ve her kare bir geometrik sekil oldugu icin bu atamalari yapabiliriz


        // bu atamalar asagidaki ornek ile birebir aynidir
        long a=5; // buyuk
        int b=5; // kucuk
        a=b; // kucuk buyuge ataniyor, herhangi bir sikinti yok, autoCasting
        b=(int)a; // buyuk olani kucuk olana atamaya calisiyoruz, casting yapmak zorundayiz, asagidaki d3=gs3 satiri ile ayni

        // simdi de tam tersini deneyelim

        /*
        Dikdortgen d3 = gs3; // bize kizdi. aslinda gs3 bir dikdortgen idi, ve biz d3 diye de bir dikdortgen tanimladik
                             // peki o zaman bu kodun hemen calismasi gerekmez miydi, compiler akilli olmadigi icin bunu anlayamadi
                             // cunku gs3 un bir dikdortgen oldugunu calisma aninda anlayacak, su an anlayamiyor
                             // burada bizim bir casting islemi yapmamiz gerekiyor

        */
        Dikdortgen d3 = (Dikdortgen) gs3; // type Casting yapildi. Ust sinifi alt sinifa casting ettigimiz icin DOWNCASTING denir
                                          // Ayni zamanda gs3 un ne oldugunu dogrudan soyledigimiz icin EXPLICIT/direct olarak soyleme denir.
        Daire daire1 = new Daire();
        Dortgen dortgen1 = new Dortgen();
        alaniGoster(gs1);
        alaniGoster(k1);
        alaniGoster(d1);
        alaniGoster(daire1);
        alaniGoster(dortgen1);
    /*
        IMPLICIT: Dolayli yoldan casting. Dolayli deniyor cunku her kare bir geometrik sekil oldugundan kare
        otomatik olarak cast edilir ve burada bu bir cikarim yaparak bu sonuca ulasdtigimiz icin dolayli olarak adlandirilir
        EXPLICIT: Dogrudan casting. Direk objenin ne oldugunu basina yazdigimiz ve herhangi bir cikarimda bulunmadigimiz icin denir
    */
    }
    public static void alaniGoster(GeometrikSekil sekil)
    {
        // sekil.alanHesapla(); bu satiri polymorphism sayesinde yazabildik
        // simdi polymprphism olmasaydi ne olurdu ona bakalim

        if(sekil instanceof Kare)
        {
            Kare gecici = (Kare)sekil;
            gecici.alanHesapla();
            System.out.println("Kare icindeki alanHesapla cagirildi");
        }
        else if(sekil instanceof Dikdortgen)
        {
            Dikdortgen gecici = (Dikdortgen) sekil;
            gecici.alanHesapla();
            System.out.println("Dikdortgen sekil icindeki alan hesapla cagirildi");
        }
        else if(sekil instanceof Daire)
        {
            Daire gecici = (Daire) sekil;
            gecici.alanHesapla();
            System.out.println("Daire sekil icindeki alan hesapla cagirildi");
        }
        else if(sekil instanceof Dortgen)
        {
            Dortgen gecici = (Dortgen) sekil;
            gecici.alanHesapla();
            System.out.println("Dortgenin sekil icindeki alan hesapla cagirildi");
        }
        else
        {
            sekil.alanHesapla();
            System.out.println("Geometrik sekil icindeki alan hesapla cagirildi.");
        }
        // instance of kullanirken if (sekil instanceof GeometrikSekil) diye baslasaydik
        // kodumuz daima geometrik sekildeki alanHesapla methodunu cagiracakti.
        // Cunku en nihayetinde verdigimiz her sekil de bir geometrik sekil olacakti ve kodumuz istedigimiz sonucu vermeyecekti
        // bunu onlemek icin daima en ust classimizi en son kosul olarak yazmaliyiz.
        // hatta dikdortgen de karenin ustunde olamaz, yoksa kare de bir dikdortgen oldugu icin, ondan kalitildigi icin
        // kare kosuluna gecemeden dikdortgen icerisindeki alanHesapla() methodu calistirilirdi
        // burada kalitilan her sinif icin bir else if blogu olusturmak zorunda oldugumuz icin bir kod karmasasi olusacakti
        // hatta ben yeni classlar uretip bunlari da geometrik sekilden inherit etmek istesem,
        // polymorphism olmadiginda onlari da else if bloklarina eklemem gerecekekken
        // polymorphism olddugunda hicbir sey yapmadan dogrudan alanHesapla() methodunu kullanabilecektim
        // bu yuzden iyi ki polymorphism var



    }
}
class GeometrikSekil // burada extend Object yazmiyor ama javada otomatik olarak, yazilmasa bile, tum classlar Object classindan kalitim alir
{
    private  int en;
    private int boy;

    public GeometrikSekil()
    {
        System.out.println("GeometrikSekil Oluşturuluyor...");
    }
    public GeometrikSekil(int en, int boy)
    {
        this.en = en;
        this.boy = boy;
        System.out.println("GeometrikSekil Oluşturuluyor...");
    }
    public GeometrikSekil(int en)
    {
        this.en = en;
        System.out.println("GeometrikSekil Oluşturuluyor...");

    }

    public int getEn() {
        return en;
    }

    public void setEn(int en) {
        this.en = en;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }

    public void alanHesapla()
    {
        System.out.println("Alan: " + (en*boy)); // burada en*boy yerine getEn*getBoy da yazabiliriz.
        // ama zaten methodumuzu en ve boy un tanimli oldugu class icerisine yazdigimiz icin
        // dogrudan degiskenlerimizin kendisini de kullanabiliyoruz.
    }
    public void cevreHesapla()
    {
        System.out.println("Cevre: " + (2*(en+boy)));
    }
    @Override // bu method Object Classina ait bir method ve tum classlar Objest classindan kalitim aldigi icin burada
    // boyle bir method tanimlamamama ragmen kullanabiliyorum
    public String toString() {
        return "En:" + en + " Boy:"+ boy;
    }
}
class Dikdortgen extends GeometrikSekil // kalitim ile class, extends keywordü ile bu sekilde olusturulur
{
    // artik burada en ve boy olusturmamiza gerek yok, GeometrikSekilde private olsa bile biz getter method tanimladigimiz icin buradan cagirabiliyoruz

    public Dikdortgen(int en, int boy)  // burasi javanin otomatik olustur dedigimde olusturdugu constructor
    {
        super(en, boy);
        System.out.println("Dikdortgen Oluşturuluyor...");

    }

    public Dikdortgen(int en)  // burasi hocanin eliyle olusturdugu constructor
    {
        setEn(en); // buradaki mantik su: ben dikdortgen classima bir en degeri gonderiyorum
        // ancak dikdortgen sinifim da o degeri bir ust siniftan alarak kullaniyor
        // dolayisi ile benim dikdortgen icine aldigim parametreyi üst sinifa gondermem gerek
        // bunu da ust sinifin setter methodu oldugu icin yapabiliyorum, aldigim en degerini setter methoduna giriyorum
        // eger setter methodu olmasa idi degisken private oldugu icin ona erisemez ve degisiklik, atama islemlerini yapamazdik
        System.out.println("Dikdortgen Oluşturuluyor...");
    }

    @Override // kalitim ile baska classtan cagirdigim icin java override edildigini bu sekilde gosteriyor
    public int getEn() {
        return super.getEn();
    }

    @Override
    public int getBoy() {
        return super.getBoy();
    }


    public void ozellikYazdir() // bu method üst classta yok, yalnizca bende ve benden kalitim alacak classlarda olacak
    {
        System.out.println("Geometrik Şeklin Eni: "+getEn()+"Geometrik Şeklin Boyu: "+getBoy());
        System.out.println("Geometrik Şeklin Alanı: ");
        alanHesapla();
        System.out.println("Geometrik Şeklin Çevresi: ");
        cevreHesapla();

    }

    @Override
    public String toString() {
        return "Dikdortgenin Eni:"+getEn()+" Boyu:"+getBoy(); // artık dikdortgen classim kendi toString methoduna sahip
        // oldugu icin kalitim aldigi classin toString methodu calismayacak, kendi toString methodu calisacak
    }

    @Override
    public void alanHesapla() {
        super.alanHesapla();
    }
}
class Kare extends Dikdortgen
{
    public Kare(int en)  // karede en ve boy degerleri birbirine esit oldugu icin tek kenari parametre olarak alan constructor kullanmak daha mantiklidir
    {
        super(en); // super keywordu baba sinifi temsil eder, this icinde bulundugun sinifi temsil eder
        setBoy(en); // bunu yazarak alan ve cevre hesaplama methodlarini kullanilabilir hale getirdik
        System.out.println("Kare Oluşturuluyor...");
    }

    @Override
    public void alanHesapla() {
        super.alanHesapla();
    }
    /*
        Burada eger Dikdortgen Classinda parametresiz Dikdortgen() constructori yoksa, Kare classi bize bir hata verir ve
        bir constructor olusturmamizi ister(yukaridaki gibi). istedigi constructor tamamen Dikdortgen classinda tanimli olan degiskenler ile dogrudan iliskilidir
        java bize der ki;
        sen kendin constructor olusturdun o zaman ben karismam ve default olanini sana getirmem.
        eger sen de elinde parametresiz bir constructor tanimlamadi isen benim Dikdortgen classini kullanarak
        yeni bir class olusturabilmem icin tanimladigin constructoru buraya da getirmelisin
        tıpkı boy degerine deger atarken getter cagirip da icine yazmistik ya, aynen oyle, burada da constructor i cagirip icine yaziyoruz
        Dikdortgen classinda kac tane constructor varsa bizim onumuze doker ve der ki ben hangisine gore Kare classini olusturayim

    */
}
class Daire extends GeometrikSekil
{
    @Override
    public void alanHesapla() {
        System.out.println("Dairenin alan hesapla methodu calisti");
    }
}
class Dortgen extends GeometrikSekil
{
    @Override
    public void alanHesapla()
    {
        System.out.println("Dortgenin alan hesapla methodu calisti");
    }
}

