package Immutable_mutable_Classes;

public class ImmutableObject {
    public static void main(String[] args) {


        /* KURALLAR
           Java’da değişmez sınıf yapmak için aşağıdaki adımları uygulamanız gerekir.

            Sınıfı, final anahtarı ile işaretlemek gerekir, böylece genişletilemez (extend edilemez).
            Sınıfın tüm alanlarını private yapın, böylece doğrudan erişime izin verilmez.
            Değişkenler için setter yöntemleri sağlamayın.
            Tüm değiştirilebilen alanları final yapın, böylece yalnızca bir kez atanabilir.
            Tüm alanların, contructor aracılığıyla ilk değerlerini atamasını sağla.
            Değiştirebilir olan tüm alanların dışarıya nesnelerin klonlanarak dönmesini gerçekleştirin.

           eger primitive tipleri kullanacaksak herhangi bir sikinti yok,cunku primitivde degiskenin kopyasi gider ve islem gorur
           ancak referance tipli degisken kullanacak isek sikinti var cunku referance tiplide degiskenin reference degeri,adresi,
           dolayisiyla da kendisi gittigi icin dogrudan kendisi islem gormus olur
           ki bu da bizim istemedigimiz bir durumdur, farkli cozum yollari dusunmeliyiz
        */
        String s1 = "s1";
        String s11 = new String("s1");
        String s2 = "s2";
        String s3 = "s3";
        String[] sler = {s1, s2, s3};
        String[] sler2 = new String[]{s1, s2, s3};


        String[] ureticiFirmalari = {"HP", "Fujitsu", "Dell"};//salliyorum, stringpool'a bu 3 deger olusturdu
        String[] ureticiFirmalari2 = new String[3];//ureticiFirmalar2[0]="mac";
        String[] ureticiFirmalari3 = new String[]{"mac", "windows", "linux"};


        Bilgisayar b1 = new Bilgisayar(8, 16, ureticiFirmalari);

        // Buraya initialize edilmemis dizi yazamazsin, object icindeki parametre kisminda tamimlama yapabilirsin, bunda sorun yok
        // Bilgisayar b1 = new Bilgisayar(8,16,new String[]{"HP","Fujitsu", "Dell"}); gibi
        bilgisayariYazdir(b1);

        int ramBoyutuKopyasi = b1.getRamBoyutu();//integer degerler pass by value ile tasinir, yani sadece deger kopyalanip atanir
        System.out.println(ramBoyutuKopyasi);//16
        System.out.println(ramBoyutuKopyasi = 32);

        String[] ureticiler = b1.getUreticiFirmalari();
        ureticiler[0] = "Apple";
        bilgisayariYazdir(b1);
        // burada yazdirdigimizda artik 0. elemanin Apple oldugunu goruruz
        // bu ise ımmutable olma ozelliginde istemedigimiz bir durum
        // bunun sebebi uretici firmalari isimli degiskenimiz dizi oldugu ici reference tiplidir.
        // reference tipli veriler bir sekilde degistirilebilirdir

        // bu yuzden getUreticiFirmalar methodunu degistirip dizinin kopyasini olusturarak kopya ile calismasini sagladik,
        // boylece class tam anlamiyla immutable olabildi

    }//static main methodun sonu

    //pass by reference
    public static void bilgisayariYazdir(Bilgisayar yazdirilacakBilgisayar)//yazdirilacakBilgisayar kelimesi b1 i temsil ediyor
    {
        //System.out.println("Cekirdek Sayisi: " + yazdirilacakBilgisayar.getCekirdekSayisi()+" Ram Miktari: "
        //      + yazdirilacakBilgisayar.getRamBoyutu()+ " Uretici Firmalari:" + Arrays.toString(yazdirilacakBilgisayar.getUreticiFirmalari()));

        System.out.println("Cekirdek Sayisi: " + yazdirilacakBilgisayar.getCekirdekSayisi() + " Ram Miktari: "
                + yazdirilacakBilgisayar.getRamBoyutu() + " Uretici Firmalari:" + yazdirilacakBilgisayar.getUreticiFirmalari()[0]);


    }
}
