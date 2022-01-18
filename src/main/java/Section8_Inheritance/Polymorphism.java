package Section8_Inheritance;

public class Polymorphism
{

    //<editor-fold desc="PolymorphismNotes">
    /*
       UPCASTING: Ust sinif nesnesinin bir alt sinif nesnesini gostermesidir
       DOWNCASTING: Alt sinif nesnesinin bir ust sinif nesnesini gostermesidir, ancak burada alt sinifin tipi belirtilmelidir

       Polymorphism 2 tipte karsimiza cikabilir
      * 1.Compile Time Polymorphism(static polymorphism):
        OVERLOADING ile elde edilir. (overloading methodlar early binding kullanir)
        bir sinifta ayni isimde birden fazla method veya operator yer alabilir

      * 2.Runtime Polymorphism:(dynamic polymorphism):
        OVERRIDING ile elde edilir. (override methodlar late binding kullanir)
        inheritance iliskisi bulunan birden fazla sinifta ayni isimde ve temelde ayni gorevi yapan bir method bulunur

      * Polymorphism late binding ile iliskilidir
        Bkz: Section8_Inheritance > Binding.java > Binding > BindingNotes
    */
    //</editor-fold>



    public static void main(String[] args)
    {
        Hayvan h1 = new Hayvan();
        Kopek kopek1 = new Kopek("Golden");
        Kedi kedi1 = new Kedi("Van Kedisi"); // bildigimiz yollardan classa ait obje urettik. Kedi tipinde kedi objesi olustu
        Hayvan kedi2 = new Kedi("Tekir"); // Polymorphism. Hayvan tipinde kedi objesi olustu

        int i =5; // dedigimizde buradaki int, degiskenimizin veri tipini gosteriyordu
                  // tamamen ayni mantik ile hayvan da kedi2 degiskenimin veri tipidir.
                  // peki bu ne ise yariyor
        adiniSoyle(h1);
        adiniSoyle(kedi1);
        adiniSoyle(kopek1); // runtime binding --> Hayvan classindaki mi yoksa kopek classindaki mi calisacak henuz belli degil
        kedi2.adiniSoyle(); // compiler time binding -->kedinin icindeki adini soyle calisti


    }
    // POLYMORPHISM: ust sinif objesinin alt sinif nesnelerini referance etmesidir
    // UPCASTING: Alt sinifin ust sinifa cast edilmesi
    // BINDING: baglama - compilertime da anlasilmasi --> kedi1.adiniSoyle() seklinde olur
    // LATE BINDING: gec baglama -  nesnenin baglanacagi nesnenin runtime esnasinda  anlasilmasi, polymorphism olmadan gec baglanma olmaz. -->adiniSoyle(kedi1) seklinde olur
    public static void adiniSoyle(Hayvan hayvan) // burada Hayvan classinin hayvan degiskeni, Hayvan classindan kalitilan
    // classlarin objelerine referance eder, yani Hayvan kedi1 yazarsak Kedi Classinin toStringi,
    // Hayvan kopek1 yazarsak Kopek Classinin toStringi calisir
    {
        hayvan.adiniSoyle(); // parametre olarak Hayvan kedi1 yazdigimizda : kedi1.adiniSoyle() olarak calisacak,
                             // yani Kedi Classinin toString methodu calisacak
    }
    /*
    asagidaki methodlari her bis class icin tek tek olusturmak yerine, yukaridaki gibi, bu classalrin kalitim aldigi classi
    oarametre olarak gonderebildigimiz bir method yazarsak cok daha az satirda isimizi halletmis oluruz
    boylece ata class kendisinden kalitim alan classlara referance etmis olur
    bu olaya polymorphism denir.
    public static void adiniSoyle(Kedi k) {}
    public static void adiniSoyle(Kopek k) {}

     */
}
class Hayvan
{
    private int ayakSayisi;

    public int getAyakSayisi() {
        return ayakSayisi;
    }

    public void setAyakSayisi(int ayakSayisi) {
        this.ayakSayisi = ayakSayisi;
    }

    public void adiniSoyle()
    {
        System.out.println("Ben Hayvan Classi Objectiyim");
    }
}
class Kopek extends Hayvan
{
    private String tur;

    public Kopek(String tur) {
        setAyakSayisi(4);
        setTur(tur);
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    @Override
    public void adiniSoyle() {
        System.out.println("Ben bir Kopek Nesnesiyim");
    }
}
class Kedi extends Hayvan
{
    private String cins;

    public Kedi(String cins) {
        setAyakSayisi(4);
        setCinsi(cins);
    }

    public String getCinsi() {
        return cins;
    }

    public void setCinsi(String cinsi) {
        this.cins = cinsi;
    }

    @Override
    public void adiniSoyle() {
        System.out.println("Ben Bir Kedi Nesnesiyim");
    }
}

    /*
        daha iyi anlayabilmen icin:
        Bir superClass dusun
        3 tane subclassi olsun
        SuperClassta bir method tanimladim
        3 subClasta da bu methodu override ettim
        gidip main methoduna; subClass1.superClassMethod();
                              subClass2.superClassMethod();
                              subClass3.superClassMethod();
        yazdigimda subClasslarin icindeki override edilmis methodlar calisacak

    */



