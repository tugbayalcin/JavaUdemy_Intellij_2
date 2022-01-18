package Section7_JavaOOP.encapsulation;

    public class OOP_Giris
    {
        public static void main(String[] args) {
            {
                // Bir okulumuz oldugunu ve çok sayida ogrencinin cesitli verilerini tutan bir program yazacagimiiz varsayalim
                // Yalnizca bir ogrenci icin isim,soyisim,tckimlikno,adres vs gibi cesitli bilgiler tutmak istiyorum
                // burada satırlarca kod olur ve bir karmasa yaratir
                // bunu engellemek icin yapabileceklerimize bakalim
                // Su anki bilgilerimiz dahilinde her bir veri turunu bir dizi icerisinde tutmayi dusunebiliriz
                // Ancak dizilerimizin eleman sayisi en bastan belli olmalıydi. fazladan eklenen her yeni ogrenci bizim
                // memoryde yeni bir dizimizin olusmasini saglayacak ve hafizayi kotu etkileyecektir
                // en bastan cok yuksek kapasiteli dizi tanimlamak da benzeri bir hafiza sorununa yol acar
                // bu durumda karsimiza classlar cikiyor ve sorunumuza cozum oluyor
                // classlar ile kendi veri turumuzu olusturabiliyoruz


                FirstClassOgrenci[] tumOgrenciler = new FirstClassOgrenci[500];


                // Asagida olusturmus oldugum FirstClassOgrenci ile  burada islemler yapalim:
                int sayi = 1; // standart degisken tanimlamasi
                FirstClassOgrenci tugba = new FirstClassOgrenci(); // bu satirin bir ust satirdan hicbir farki yok
                tugba.isim = "Tugba Yalcin";

                // tugba. yaptigim zaman sunlar oluyor:
                // tugba stackte 1. kutuda tutuluyor
                // . ya bastigim an stackjte 2. kutudaki referance numarasi calisiyor ve bizi heape goturuyor
                // ve karsimiza OgrenciNo, isim,sinif,aktif cikiyor
                // diyor ki ben kutuya gittim ama icinde bu field variables var. sen hangisini kullanmak istiyorsun
                tugba.sinif = 9;
                tugba.OgrenciNo = 235;
                tugba.aktif = true;
                tugba.ogrenciBilgileriniYazdir();// classimin icindeki method

                // asagida asel icin classimizi kullandik. Burada asel stackte 1. kutuya yazilir. Referance stackte 2. kutuya yazilir
                // ve isim,sinif,OgrenciNo,aktif bilgilerini iceren class kutusu heap te ayri bir yerde olusturulur
                FirstClassOgrenci asel = new FirstClassOgrenci();
                asel.isim = "Aseltosko";
                asel.sinif = 7;
                asel.OgrenciNo = 103;
                // ogrenci aktif yapmadigimiz icin varsayilan olarak false algilayacak idi
                // ancak kendi classimda varsayilan degerleri kendim belirleyebilirim ve bu yuzden aktif degiskeni icin defaultu
                // constructor method icinde ture olarak tanimladim. Bu yuzden ogrenci bilgilerim aktif degeri girilmese bile yazdirilacak
                asel.ogrenciBilgileriniYazdir();
                // su anda stackte 2 satirim ve heapte 2 kutum var. Kutulardan biri tugbanin digeri aselin

                int[] sayilar = new int[50]; // standart dizi tanimlamasi
                sayilar[0] = 1;
                int[] sayilarinHepsi = {5, 6, 9, 7}; // dogrudan dizi tanimlamasi
                // tipki dogrudan dizi tanimlamasinda oldugu gibi, classimin icinde yer alan degiskenleri de dogrudan tanimlayabilirim
                // bunun icin constructor method kullanilir
                // simdi classimla ayni isimde olan ancak class icindeki degiskenleri parametre olarak alan bir constructor
                // methodu classima ekledim ve asagidaki bilgileri girilmeyen ogrenci icin neler olacagina bakicam

                FirstClassOgrenci bos = new FirstClassOgrenci();
                bos.ogrenciBilgileriniYazdir();
                // ogrenciye hicbir deger atamadan yazdirmayi deniyoruz
                // ciktiya bakarsak aktifligin defaultunu true yaptigim icin ogrenci bilgileri yazdirilacak
                // ancak her birinin karsisinda javanin standart default degerleri yer alacak, cunku onlar icin ben ekstra bir default tanimlamasi yapmadim

                FirstClassOgrenci ayse = new FirstClassOgrenci(500, "Ayse Yilmaz", (byte) 5, true);
                ayse.ogrenciBilgileriniYazdir();

                FirstClassOgrenci ali = new FirstClassOgrenci("Ali"); // burada imleci parantez icine getirip ctrl p yaparsan alabilecegi parametreler cikar
                ali.ogrenciBilgileriniYazdir();
                // burada onemli bir nokta daha var
                // biz baska bir constructorda aktiflik degerinin defaultunu true olarak tanimladik ama su an yalnizca string alan constructor i calistiriyoruz
                // classin birden fazla constructori olabilir ancak yazdigimiz koda gore yalnizca bir tanesi calisir ve calisma esnasinda
                // o constructor icinde gecerli olan tanimlamalar islem gorur
                // dolayisi ile string alan constructorin aktiflik degerinin defaultu false olarak kalmis durumdadir
                // degistirmedigimiz surece bu constructori calistirmak istedigimizde aktif ogrenci yoktur ciktisini aliriz
                ali.aktif = true;
                ali.ogrenciBilgileriniYazdir();

                //****************************//

                // yukarida tanimlanan tugba ve asel birer object tir ve heapte yer alir. Heapte birer kutuyu temsil ederler
                // peki ben bunlari birbirine atamak istesem ne olur
                tugba = asel; // burada tugba ve asel referans tipli verilerdir ve bellek yonetiminden de bildigimiz gibi
                // asel in tuttugu referance degerini tugbanin icine atacak ve boylece artik tugba nin tuttugu kutuya erisimimiz olmayacak
                // onu da gerbage collector temizleyecek
                System.out.println("Tugba'nin bilgileri");
                tugba.ogrenciBilgileriniYazdir();
                System.out.println("Asel'in bilgileri:");
                asel.ogrenciBilgileriniYazdir();

                FirstClassOgrenci ogr1 = new FirstClassOgrenci();
                FirstClassOgrenci ogr2 = new FirstClassOgrenci();
                FirstClassOgrenci ogr3 = new FirstClassOgrenci();
                FirstClassOgrenci ogr4 = new FirstClassOgrenci();
                FirstClassOgrenci ogr5 = new FirstClassOgrenci();
                FirstClassOgrenci ogr6 = new FirstClassOgrenci();


                tumOgrenciler[0] = ogr1;
                tumOgrenciler[1] = ogr2;
                tumOgrenciler[2] = ogr3;
                tumOgrenciler[3] = ogr4;
                tumOgrenciler[4] = ogr5;
                tumOgrenciler[5] = ogr6;
                tumOgrenciler[6] = new FirstClassOgrenci(78, "boru", (byte) 3, true);

                tumOgrenciler[2].aktif = true;
                tumOgrenciler[2].sinif = 5;
                tumOgrenciler[2].ogrenciBilgileriniYazdir();


            }

        }
    }
        // class icinde tanimlanmis degisken: INSTANCE VARIABLE
        // method icinde tanimlanmis degisken: LOCAL VARIABLE

         class Ogrenci
        {
            private int ogrenciNo; // encapsulation konusu icin priveate yaptik
            private String isim; // private ozel demektir
            private byte sinif; // nu degiskenleri bu classa ozel kilar
            private boolean aktif; // disaridan erisimi engeller

            // simdi asagiya encapsulation icin methodlar tanimlayacagiz
            // biz method olusturmak istedigimizde java diyor ki
            // hmm sen ogrenciNo degiskeni ile ilgili method olusturmak istiyorsun o zaman ben hemen sana set vereyim diyor
            // degiskene method atayacagimiz methodlara SETTER method denir
            public void setOgrenciNo(int yeniOgrenciNo) {
                this.ogrenciNo = yeniOgrenciNo;
            } // SETTER

            // eger ben degeri okumak istiyorsam bunun icin de ayrica method olusturmam gerekir
            // bu method geriye bir deger dondurmeli ki okuyabileyim
            // bu sefer de java diyor ki hmm sen degşiskeni okumak istiyorsun o zaman ben sana get vereyim
            // degiskeni okuyyacagimiz methodlara GETTER method denir
            public int getOgrenciNo() // ben va rolani okumak istedigim icin herhangi bir parametre almayacak
            {
                return this.ogrenciNo;
            }

            // mouse right click --> generate --> getting and seting ile asagidakileri otomatik olarak olusturduk
            // ctrl+A yaparsan hepsini secer
            public String getIsim() {
                return isim;
            }

            public void setIsim(String isim) {
                this.isim = isim;
            }

            public byte getSinif() {
                return sinif;
            }

            public void setSinif(byte sinif) {
                this.sinif = sinif;
            }

            public boolean isAktif() {
                return aktif;
            }

            public void setAktif(boolean aktif) {
                this.aktif = aktif;
            }

            public Ogrenci() // parametresiz standart-basic constructor
            {
                // burasi ben eger hicbir constructor tanimlamaz isem java tarafindan otomatik olarak tanimlanir
            }

            public Ogrenci(int ogrenciNo) // tek parametreli constructor
            {
                // integer parametre alan bir constructor tanimladik ama bu hicbir ise yaramaz.
                // bizim girilen parametreyi class degiskenlerine tamamizn gerek
                this.ogrenciNo = ogrenciNo;
            }

            public Ogrenci(int ogrenciNo, String isim) // iki parametreli constructor
            {
                this.ogrenciNo = ogrenciNo;
                this.isim = isim;
            }

            public Ogrenci(int ogrenciNo, String isim, byte sinif) // uc parametreli constructor
            {
                this.ogrenciNo = ogrenciNo;
                this.isim = isim;
                this.sinif = sinif;
            }


            public Ogrenci(int ogrenciNo, String isim, byte sinif, boolean aktif) // dort parametreli constructor
            {
                this.ogrenciNo = ogrenciNo;
                this.isim = isim;
                this.sinif = sinif;
                this.aktif = aktif;
            }

            // OOP'nin en onemli ozelliklerinden biri bizi kod tekrarlarindan kurtarmasidir
            // yukarida her constructor icin ogrenciNo getiren bir kod yazdik. Oysa ki bunu yapan tek bir constructor olmasi bizim icin yeterlidir
            // bunun icin de this() keyword unu kullaniriz
            // this. bize class icindeki degiskenleri gezmemizi saglarken
            // this() ise class icindeki constructorlari gezmemizi saglar
            // boylece yukaridaki constructorlari su sekilde yeniden yazabiliriz

        /*
            public Ogrenci{}
            public Ogrenci(int ogrenciNo)
            {
                this.ogrenciNo=ogrenciNo;
            }
            public Ogrenci(int ogrenciNo,String isim) // iki parametreli constructor
            {
               this(ogrenciNo);
               this.isim=isim;
            }
            public Ogrenci(int ogrenciNo,String isim, byte sinif) // uc parametreli constructor
            {
               this(ogrenciNo,isim)
               this.sinif=sinif;
            }
            public Ogrenci(int ogrenciNo,String isim, byte sinif, boolean aktif) // dort parametreli constructor
            {
               this(ogrenciNo,isim,sinif)
               this.aktif=aktif;
            }

            this() icine constructor parametrelerimi yaziyorum
            bu kullanim yalnizca constructor methodlar icin gecerlidir
            NOT: boyle bir kullanim gerceklestirilecekse, bu this() anahtari uste yazilir,
            alt satirlara yazilirsa hata verir

        */

            /*
                Ogrenci ogr1 = new Ogrenci();
                Ogrenci ogr2 = new Ogrenci(5);
                Ogrenci ogr3 = new Ogrenci(5, "ogr3");
                Ogrenci ogr4 = new Ogrenci(5, "ogr4", (byte) 7);
                Ogrenci ogr5 = new Ogrenci(5, "ogr5", (byte) 7, true);
            */
            public void OgrenciBilgileriniYazdir() {
                if (aktif == true) {
                    System.out.println("Adim: " + isim + "Numaram: " + ogrenciNo + "Sinifim: " + sinif);
                } else {
                    System.out.println("Bu ogrenci aktif degildir.");
                }
            }


        }

         class Constructor // Kurucu Method
        {
            public void main(String[] args) {
                // Constructor methodlar nesne olusturdugumuz anda calistirilan methodlardır.
                // Herhangi bir geri donus tipi yoktur.
                // Bir constructorin yaptigi is, bir nesneyi ilk kullanima hazirlamaktir.

                // Constructor Method Ozellikleri
                // Yeni bir object olusturuldugunda otomatik olarak cagirilir
                // Public olmak zorundadirlar
                // Constructor Method kullanilirken new keyword u kullanilir
                // Bellekte objeye bir yer ayrilmasini saglar
                // Her cagrildiklarinda yeni bir obje olusturur
                // Geriye bir deger donmez ve void ile belirtilmez
                // Class adi ile birebir ayni olmalidir
                // Heap alaninda ne kadar yer ayrilacagi bu method sayesinde anlasilir
                // Bu method sinif icindeki degiskenlere varsayilan degerler atanirken de kullanilir
                // Yani constructor methodlar bellekten yer ayirmak ve ve bu yerde bulunan degerlere varsayilan degerlerini atamak icin kullanilir
                // Ayrica farkli constructorlarda bir object uretilirken farkli degerlerin atanmasi mumkundur.
                // Bir classin birden fazla constructor methodu olabilir.
                // Sistem hangisinin kullanilacagina bu methodun aldigi parametrelerin sayisina ve turune bakarar karar verir
                // Bu islem method overloading sayesinde gerceklesir

                // Javada her class icin varsayilan olarak ve herhangi bir parametre almayan bir constructor bulunur ve buna default constructor denir
                // Bunu biz yazmasak bile sistem otomatik olarak bunu olusturur ve new keywordu ile yeni bir object yarattigimiz anda bunu cagirir
                // NOT: Biz herhangi bir constructor tanimlamasi yaptigimizda artık java bizim icin default constructori otomatik olusturmayacaktir
                // Ogrenci tugba = new Ogrenci() diyebilmek icin varsayilan constructori elle belirlemeliyiz,
                // cunku var olan bir constructorimiz var ama parametre almayan yok ve biz parametre almayan kullanmak istiyorsak artik java bunu benim icin yapmiyor
                // bu yuzden eger kendimiz constructor tanimlamasi yapacaksak mutlaka bir tane parametre almayan ici bos bir constructor da tanimlamaliyiz

                // ORNEK
                // Dıkdortgen; icinde 2 tane int deger tutmak istedigim ve benim olusturdugum veri turunun adidir.
                // Bundan sonra bu veri turuyle olusturacagim degerlerin bir taslagidir.

                class Dikdortgen {
                    // objectin bildigi seyler, field variable
                    int en;
                    int boy;

                    public Dikdortgen() // public yazinca hemen cikti ve yaninda local variable yaziyor
                    {
                        // constructor method
                        // bunu yazmasak da sistem otomatik olarak bu kurucu methodu new keywordu ile
                        // yeni bir object olusturdugumuz anda calistirir
                        // veri dondurmez aam yine de void yazmayiz
                    }

                    public int alanHesapla() {
                        return en * boy;
                    }
                }

                // main method icerisinde bu taslaktan somut degerler olusturmak icin
                Dikdortgen d1 = new Dikdortgen(); // burasi Integer i1= new Integer() yapisinin aynisi
                d1.en = 5; // d1. dedigimizde Degisken classinin field variablesi karsimiza cikacak
                d1.boy = 10;

                Dikdortgen d2 = new Dikdortgen();
                d2.en = 3;
                d2.boy = 8;

        /*
          Bu ornekte;
          Dikfortgen: Veri Turu
          d1: Referance Adi
          new: Bana heap memoryden yer ayir
          new Dikdortgen(): Bana heap memoryden 2 tane int deger tutacak yer ayir
        */


            }

        }

         class FirstClassOgrenci
        {

            int OgrenciNo;
            String isim;
            byte sinif;
            boolean aktif;
            // yukarida yer alan veriler benim classimin sahip oldugu bilgilerdir. field vaiables denir

            public FirstClassOgrenci() // OVERLOADİNG
            {
                System.out.println("Ogrenci objesi olusturuluyor");
                aktif = true; // burada sunu dedik, aktifin varsayilan degerini true yap.
                // normalde boolean degiskenlerin defaultu false idi. ben kendi classimda bunu degistirdim ve true yaptim
            }
            // burasi constractor method
            // burasi sayesinde class kullanilirken bellekten ne kadar yer alacagim bilinmis oluyor
            // degiskenlerime default deger atamasini bu method icinden yapiyorum

            public FirstClassOgrenci(int OgrencininNumarasi, String isim, byte sinif, boolean aktif) // OVERLOADİNG
            {
                // burasi da bir constructor method ve class degiskenlerini parametre olarak aliyor
                // ancak parametre yazmak ile degiskenleri bu parametrelerle eslestirmek ayni sey degildir
                // bu method icerisinde tek tek hangi parametre hangi degiskene gidecek bunu soylememiz gerekiyor
                // ancak degisken adi ile parametre adi birebir ayni olmamali, yoksa algilamaz
                // veya this keywordunu kullaniriz.
                // this demek degiskene hafizada ayrilan yeri isaret eder, boylece parametre adiyla tipatip ayni olsa bile karismaz
                OgrenciNo = OgrencininNumarasi;  // 1.YOL
                this.isim = isim; // 2.YOL
                this.sinif = sinif;// OgrenciNo icin ayrilan yere parametre olarak girilen OgrencininNumarasi ni ata demek
                this.aktif = aktif;
            }

            // bir constructor parametre olarak classin tum degiskenlerini icermek zorunda degildir
            // ornegimiz uzerinden bakacak olursak
            public FirstClassOgrenci(String isim) // seklinde de constructor tanimlamasi yapılabilir
            {
                this.isim = isim;
            }

            // asagidaki methodlar ise classimin yapabilecegi islemlerdir
            public void dersAl() {
                System.out.println("Ogrenci ders aliyor.");
            }

            public void ogrenciBilgileriniYazdir() {
                if (aktif == true) {
                    System.out.println("Adim: " + isim + "Numaram: " + OgrenciNo + "Sinifim: " + sinif);
                } else {
                    System.out.println("Bu ogrenci aktif degildir.");
                }
            }

        }




