package Section7_JavaOOP.Composition;

public class Composition
{

    /**
     * Inheritance'daki gibi classalr arasinda kan bagi yoktur.
     * Composition'da 1 ya da 1 den fazla classlar  bir araya gelerek Yeni buyuk bir class olustururlar. Mesela;
     * Motor+Koltuk+Lastik+Cam+Far+DisBoya = Araba
     * Yukardaki her kelime bir classtir, birleserek yeni tum ozellikleri barindiran Araba Classi meydana getirirler.
     *
     * Ornek2;
     *
     * Hamur Class(su,un,tuz)+IcHarc Class(domates,sogan,kiyma,Baharat Class(pulbiber,kekik,kimyon,nane,karaBiber))+...+..=Manti Class
     *
     * @param args
     */

    public static void main(String[] args)
    {
        //As a User, I want to create a car
        Araba myAraba = new Araba();// ilk motor olustu, Sonra Araba - Yani 2 tane class olustu
        myAraba.hareketeGec();
        myAraba.durmayaBasla();
        System.out.println("-------------------------------------------------------------------------------------");

        //Araba myAraba2= new Araba(new Motor("MercedesMotoru",150),new Koltuk("Krem","SuniDeri",true),"Gri","Mercedes C180",2017);

        Motor myMotor=new Motor("MercedesMotoru",150);
        Koltuk myKoltuk=new Koltuk("Krem","SuniDeri",true);
        Araba myAraba2= new Araba(myMotor,myKoltuk,"Gri","Mercedes C180",2017);

        //System.out.println(myMotor);
        //System.out.println(myKoltuk);
        System.out.println(myAraba2);


    }
}
class Motor
{
    private String isim;
    private int beygirGucu;

    public Motor()
    {
        isim = "Honda";
        beygirGucu = 135;
        System.out.println(isim + " isimli ve " + beygirGucu + " beygir guclu motor olustu");
    }

    public Motor(String isim, int beygirGucu){
        this.isim=isim;
        this.beygirGucu=beygirGucu;
    }

    public void calistir()
    {
        System.out.println("Motor Calistirildi");
    }
    public void durdur()
    {
        System.out.println("Motor Durduruldu");
    }

    @Override
    public String toString() {
        return "Motor{" +
                "isim='" + isim + '\'' +
                ", beygirGucu=" + beygirGucu +
                '}';
    }
}
class Araba
{
    // her arabanin mmutlaka bir motoru vardir
    // ben motor verilerini yeniden tanimlamak yerine yukarida olusturdugum class i kullanacagim
    // asagidaki kod satirinin "private int i;" kodundan hicbir farki yoktur, int yerine kendi degiskenim olan Motor classini kullaniyorum
    private Motor arabaMotoru; // KOMPOZİSYON: Burada daha onceden olusturulmus bir classi kullaniyorum
    private Koltuk koltukTakimi;
    private String renk; // KOMPOZİSYON: Daha onceden tanidigimiz String classi buraya cagirmak da bir kompozisyondur
    private String marka;
    private int uretimYili;

    //JAVA'da KONU ADI -> Static ve default Blocklar
    static{

    }
    //default block
    {
        /*
        method gibi dusun, olurda class bir constructor'i ile calistirilirsa(new Araba(), new Araba(... , ... ,... ...))
        constructor'in ici calismadan once Static block'un ici calisir
        sonra default block'un ici calisir
        sonra istedigin constructor'in ici calisir.

         */
    }

    public Araba()//Araba Class'inni default constructor ile calistirdigim an
    {

        arabaMotoru = new Motor();// degiskenim obje idi, objemi default olarak tanimladim.
                                  // degisken primitive olsa idi direk degerini verebilirdik
        koltukTakimi=new Koltuk();
        renk = "Kırmızı";
        marka = "Toyota";
        uretimYili = 2019;
        System.out.println(renk + " renkli, " + uretimYili + " model " + marka + " marka araba olusturuldu.");

    }

    public Araba(Motor arabaMotoru, Koltuk koltukTakimi, String renk, String marka, int uretimYili) {
        //Parameter olarak aldigimiz arabaMotoru ve KoltukTakimi objeleri aldik.
        //Ve bu objeler sayesinde Motor ve Koltuk Classlarina eristik ve deger atadik
        //BU OLAYA -> COMPOSITION denir.
        this.arabaMotoru = arabaMotoru;//isim , beygirGucu
        this.koltukTakimi = koltukTakimi;//isim, renk, waterProof
        this.renk = renk;
        this.marka = marka;
        this.uretimYili = uretimYili;
    }

    public void hareketeGec()
    {
        System.out.println("Araba Harekete Geciyor.");
    }
    public void durmayaBasla()
    {
        System.out.println("Araba Durmaya Basladi");
    }


    @Override
    public String toString() {
        return "Araba{" +
                arabaMotoru +" , "+
                koltukTakimi+
                ", renk='" + renk + '\'' +
                ", marka='" + marka + '\'' +
                ", uretimYili=" + uretimYili +
                '}';
    }
}

class Koltuk
{
    private String renk;
    private String model;
    private Boolean waterproof;

    public Koltuk(String renk, String model, Boolean waterproof) {
        this.renk = renk;
        this.model = model;
        this.waterproof = waterproof;
    }

    public Koltuk() {
    }


    @Override
    public String toString() {
        return "Koltuk{" +
                "renk='" + renk + '\'' +
                ", model='" + model + '\'' +
                ", waterproof=" + waterproof +
                '}';
    }
}