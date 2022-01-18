package Section8_Inheritance;

public class inheritance
{
    public static void main(String[] args)
    {
        /*
            * Kalitim yolu ile daha onvceden yazilmis kodlari kullanarak yeni siniflar olusturabiliriz

            * Kalitim ile bir sinif turetildigi sinifin private alanlari disindaki tum degisken ve methodlarina sahip olmus olur

            * Iki sinifi birbirinden turetmeli miyim konusunda kararsiz isek kendimize su soruyu sormaliyiz:
              "Acaba yeni sınıf, ust siniftan turetilebilecek bir sinif mi? Acaba Kaplan bir Kedi midir?"
              Cevap evet ise kaplan sinifi kedi sinifindan turetilebilir.

            * Turetme islemi extends anahtar kelimesi ile gerceklesir.
              class Kaplan extends Kedi{} boylece kaplan sinifi kedi sinifindaki private olmayan degisken ve methodlara erisebilir

            * Aslinda olusturdugumuz her sinif otomatik olarak bir siniftan turetilir. Javada her sinif Object dedigimiz bir ust siniftan
              gizli bir sekilde kalitilir.

            * Olusturdugumuz her sinif Object sinifinin methodlarina sahip olur. Bu methodlara sunlari ornek verebiliriz:
              1. clone: Nesneyi kopyalar
              2. equals(Object obj): obj ye bagli olan nesnenin kendisine esit olup olmadigini soyler
              3. finalize(): Cop toplayici tarafindan silinmeden once calistirilir
              4. hashCode(): Nesnenin hash codeunu verir. hashCoıde degerini objeler icin ID degeri olarak dusunebiliriz, ancak uniq degildir.
              5. toString(): Ilgili nesneyi string olarak ifade etmek icin kullanilir.

            * Java dilinde coklu kalitima izin verilmez. Her sinif en fazla bir siniftan turerilebilir.

            * Kalitim demek bir sinifin baska bir sinifi kopyalamasi demek degildir. Kalitim bir sinifin turetildigi sinifin
              alanlarina erisebilmesi ve gerekiyorsa kendi alanlarini olusturabilmesidir.
              KopekBalik > Balik > Hayvan > Object  bu yapida bir kopek baligi nesnesi olusturulmadan once mutlaka
              oncelikle objeck sonra hayvan daha sonra balik sinifi nesneleri olusturulur. En son kopek baliginin kurucu methodu calistirilir.
        */

        Dikdortgen d1 = new Dikdortgen(10,20);
        d1.ozellikYazdir(); // burada obje. dediginde kullanabilecegin methodlar cikiyor ya,
        // kendi classinin icinde olanlar bold, ust classinin icinde olanlar normal yazi olarak cikiyor
        System.out.println("d1 in ozellikleri: "+d1); // Dikdortgen classimda toString methodu olamdiginda bile
        // Dikdortgenin kalitim aldıgı GeometrikSekiller classinda olmasi dolayisi ile burasi hashCode yazdirmaz

        GeometrikSekil gs1 = new GeometrikSekil(5,10); // parantez icine gelip command p dersen hangi parametreleri aldigini gorersin
        System.out.println(gs1); // sunu yazdirir: Section8_Inheritance.GeometrikSekil@5f2050f6 --> paketAdi.methodAdi@hashCode

        // yukariyi yorum satirina cevirerek yalnizca asagiyi yazdir, goreceksin ki once geometrik sekil olusturuluyor sonra dikdortgen olusturuluyor sonra da kare
        Kare k1 = new Kare(10);
        k1.alanHesapla();
        k1.cevreHesapla();





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

/*
   * Dikdortgen classimiz icin lazim olan tum bilgiler GeometrikSekil classinda var
   * Acaba ben kompozisyon mu uygulamaliyim yoksa kalitim mi
   * Dikdortgen bir GeometrikSekil midir? Cevabım EVET oldugu icin KALITIM uygulamaliyim

*/

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
}
class Kare extends Dikdortgen
{
    public Kare(int en)  // karede en ve boy degerleri birbirine esit oldugu icin tek kenari parametre olarak alan constructor kullanmak daha mantiklidir
    {
        super(en); // super keywordu baba sinifi temsil eder, this icinde bulundugun sinifi temsil eder
        setBoy(en); // bunu yazarak alan ve cevre hesaplama methodlarini kullanilabilir hale getirdik
        System.out.println("Kare Oluşturuluyor...");
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
interface h
{

}


