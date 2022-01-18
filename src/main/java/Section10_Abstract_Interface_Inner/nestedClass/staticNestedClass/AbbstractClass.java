package Section10_Abstract_Interface_Inner.nestedClass.staticNestedClass;

public class AbbstractClass // Soyut Siniflar
{
    public static void main(String[] args)
    {
        //<editor-fold desc="Abstract Class">
        /*
            Abstract sınıf nesne üretilmeyen ve soyut metotlar barındıran bir yapıdır.
            Metotların sadece tanımları bulunur ve bu sınıftan türetilen alt sınıflar bu metotların içeriklerini
            kendilerine göre oluşturulmak zorundadır.

            Bir kalıtım hiyerarşisinde alt sınıftan üst sınıfa doğru gidildikçe daha genel ve özel alanların olmadığı bir yapıya doğru gidilir.
            Canlı > Hayvan > Ayı > Kutup Ayısı burada Canlı sınıfı en genel, Kutup Ayısı ise en spesifik sınıftır.
            Canlı sınıfı altındaki sınıfların en genel özelliklerini taşır ve bazen bu sınıf o kadar soyut olur ki
            bundan bir nesne üretmek gerekmez. Sadece belli ortak özellikleri barındırmasını sağlamak için böyle bir sınıfı kullanırız.

            Abstract sınıflar diğer sınıf yapısına oldukça benzer. Ama bazı farklılıkları bulunur.
            • Abstract sınıflardan new ile yeni bir nesne üretemezsiniz.
            • Abstract sınıflarda metotların tanımı olur, içerikleri olmaz. Bu
                içerikler abstract sınıftan türetilmiş sınıflarca yazılır.
            • İçerikleri yazılmayan bu metotlar abstract metot olarak tanımlanır. Bir
                sınıfta bir tane abstract metotun olması o sınıfı abstract yapmaya
            yeterlidir.
            • Bir metot abstract ise o sınıf mutlaka abstract olmalı. Ve bu metotlar
                static olamazlar.
            • Her ne kadar new ile yeni nesne üretilmese de abstract sınıfların da
                constructorları vardır ve alt sınıftan bir nesne üretildiğinde bu kurucu
                metotlar sırasıyla calıstırılır.
            • Abstract sınıflarda hiç metot da olmayabilir. Alt sınıfları bir üst sınıf
                tanımında toplamak için böyle bir durum olabilir.
            • Üst sınıf normal bir sınıf iken alt sınıf abstract olabilir. Object sınıfı
                normal iken olusturacagımız bir sınıf abstract olabilir.
                Bunların dışında soyut sınıflar normal sınıflara benzer. Birleştirici bir
                rol oynarlar. Polimorfizm ve geç bağlama sayesinde bu sınıfın
                değişşkenlerine alt sınıf nesneleri bağlanabilir.
         */
        //</editor-fold>
            // GeometrilSekil gs1 = new GeometrilSekil(); diyemeyiz. Burada bir inner class olusur ama o bir nesne degildir
        GeometrilSekil kare = new Kare(5); // ust sinifa baglarsak sadece ust siniftaki methodlari gorebiliriz
        kare.cevreHesapla();
        kare.alanHesapla();
           // kare.adiniSoyle(); yalnizca kareye ozgu olan methoda eriaemiyoruz bunun sebebi ise late binding
        ((Kare)kare).adiniSoyle(); // erisebilmek icin down casting yapmak zorundayiz

           // Dikdortgen dikdortgen = new Dikdortgen(10,12); // bunu yapmakta hicbir sakinca yok,
           // boylece dikdortgene ve ust sinifa ait olan her seyi cagirabiliriz
           // dikdortgen.adiniSoyle(); diyebilirisn
        GeometrilSekil dikdortgen = new Dikdortgen(10,12);
        dikdortgen.cevreHesapla();
        dikdortgen.alanHesapla();
        ((Dikdortgen)dikdortgen).adiniSoyle();

        GeometrilSekil daire = new Daire(5);
        daire.alanHesapla();
        daire.cevreHesapla();

        alanlariKarsilastir(kare,dikdortgen);
        alanVeCevreyiSoyle(kare);
        alanVeCevreyiSoyle(dikdortgen);
        alanVeCevreyiSoyle(daire);
    }
    public static void alanlariKarsilastir(Kare k1, Kare k2) {}
    public static void alanlariKarsilastir(Dikdortgen d1, Kare k2) {} // overloading
    public static void alanlariKarsilastir(Dikdortgen d1, Dikdortgen d2) {}
    public static void alanlariKarsilastir(Kare k1, Daire dr1) {}
    // yukarıdaki gibi bircok farkli olasilik olabilir.
    // ancak ben her vir olasilik icin method overloading yapmak yerine polymorphism sayesinde tek bir adimda tum isi halledebilirim
    public  static  void alanlariKarsilastir(GeometrilSekil gs1, GeometrilSekil gs2)
    {
        // cunku buraya yollayacagimiz her kare, dikdortgen, daire nin ust sinifi GeometrikSekil
        // ayrica ben objelerimi tanimlarken Geometrik Sekil obje = new ... dedim. Bunu dememin sebebi, tek adimdaki bu satiri yazabilmek idi
        if(gs1.getHesaplananAlan() < gs2.getHesaplananAlan())
        {
            System.out.println("Birinci parametredeki nesnenin alani, ikinci parametredeki nesnenin alanindan kucuktur.");
        }
        else if(gs1.getHesaplananAlan() > gs2.getHesaplananAlan())
        {
            System.out.println("Birinci parametredeki nesnenin alani, ikinci parametredeki nesnenin alanindan buyuktur.");
        }
        else
        {
            System.out.println("Alanlar birbirlerine esittir.");
        }
    }

    public static void alanVeCevreyiSoyle(GeometrilSekil gs1)
    {
        System.out.print("Cevre:");
        gs1.cevreHesapla();
        System.out.println();
        System.out.print("Alan:");
        gs1.alanHesapla();
    }

}
// abstarct classlarin abstract olmayan methodlari olabilir.
// ancak bir clastta tek bir tane bile abstract method varsa, class da abstract olmak zorundadir
 abstract class GeometrilSekil
 {
    private int birinciKenar; // tum geommetrik sekillerde ortaktir
    // Ikinci kenarimiz olmadigi icin methıd icini yazamiyoruz bile, buradan aslinda bu sinifi abstarct yapmamiz gerektigini anliyoruz
     private int hesaplananAlan;

    abstract public void cevreHesapla(); // abstract methodun icine bir sey yazilamayacagi icin bu sekilde bitirilmesi gerekir

    abstract public void alanHesapla(); // alt classlar bu methodlara sahip olmak zorundadirlar

     public int getHesaplananAlan() {
         return hesaplananAlan;
     }

     public void setHesaplananAlan(int hesaplananAlan) {
         this.hesaplananAlan = hesaplananAlan;
     }

     public int getBirinciKenar() {
        return birinciKenar;
    }

    public void setBirinciKenar(int birinciKenar) {
        this.birinciKenar = birinciKenar;
    }
}
// asagidaki classi yazdigin anda java hata verir.
// Der ki senin super classinda iki method var onlari hemen implement etmelisin
// ctrl n ile implement ettik
// eger etmese idik java bize derdi ki; ya buraya methodlarini override edeceksin, ya da  bu classi da abstract yapacaksin !.
 class Kare extends GeometrilSekil
 {
    public Kare(int kenar)
    {
        this.setBirinciKenar(kenar);
    }

    @Override
    public void cevreHesapla()
    {
        System.out.println("Karenin Çevresi: "+getBirinciKenar()*4);
    }

    @Override
    public void alanHesapla()
    {
        setHesaplananAlan(getBirinciKenar()*getBirinciKenar());
        System.out.println("Karenin Alani: "+ getHesaplananAlan());

    }

    public void adiniSoyle()
    {
        System.out.println("Ben bir kare nesnesiyim.");
    }
}
 class Dikdortgen extends GeometrilSekil
 {
    private int ikinciKenar;

    public Dikdortgen(int birinciKenar,int ikinciKenar)
    {
        setBirinciKenar(birinciKenar);
        this.ikinciKenar = ikinciKenar;
    }

    public int getIkinciKenar() {
        return ikinciKenar;
    }

    public void setIkinciKenar(int ikinciKenar) {
        this.ikinciKenar = ikinciKenar;
    }

    @Override
    public void cevreHesapla()
    {
        System.out.println("Dikdortgenin Cevresi:"+2*(getBirinciKenar()+ ikinciKenar));
    }

    @Override
    public void alanHesapla()
    {
        setHesaplananAlan(getBirinciKenar()*ikinciKenar);
        System.out.println("Dikdortgenin Alani:"+getHesaplananAlan());
    }

     public void adiniSoyle()
     {
         System.out.println("Ben bir dikdortgen nesnesiyim.");
     }

}
 class Daire extends GeometrilSekil
 {
     public Daire(int yaricap)
     {
         setBirinciKenar(yaricap);
     }

     @Override
     public void cevreHesapla()
     {
         System.out.println("Dairenin Cevresi:"+2 * 3.14 * getBirinciKenar());
     }

     @Override
     public void alanHesapla()
     {
         setHesaplananAlan((int) (3.14 * getBirinciKenar()*getBirinciKenar()));
         System.out.println("Dairenin Alani:"+ getHesaplananAlan());
     }
 }
