package Section7_JavaOOP.bolumSonuOdevler;

public class BolumSonuOdev_2
{   // SORU2: Ogrenci isimli sinif olusturun. Bu sinifta ogrencinin IDsi ve nor degeri tutulmali.
    // 100 elemanli bir dizide ID ve not degerlerini rastgele olusturarak bu ogrencileri saklayin
    // ve bu pogrencileri aldiklari notlara gore azalan sirada yazdiran methodu olusturun
    public static void main(String[] args)
    {
        OgrenciOdev tumOgrenciler[] = new OgrenciOdev[100];
        // dizide integer veya double degil ogrenci saklayacagiz
        // o yuzden kendi degiskenimizi kullaniyoruz
        for(int i=0;i<100;i++) // 100 tane rastgele not ve id si olan ogrenci olusturdu
        {
            int rastgeleID =(int) Math.random()*5000;
            int rastgeleNot =(int) Math.random()*101    ;

            OgrenciOdev ogrenciYeni=new OgrenciOdev(rastgeleID,rastgeleNot);
            tumOgrenciler[i]=ogrenciYeni;
        }
        ogrencileriNotlarinaGoreSirala(tumOgrenciler);
        for(int i=0;i<100;i++)
        {
           tumOgrenciler[i].ogrenciBilgileriniYazdir(); // zaten methodun icinde println oldugu icin direk yaziyoruz

        }
    {
        
    }
    }

    private static void ogrencileriNotlarinaGoreSirala(OgrenciOdev[] tumOgrenciler)
    {
        for(int i=0; i<tumOgrenciler.length-1; i++)
        {
            // en kucuk elemanin ve indeksinin bulunmasi
            int oAnkiEnBuyukSayi = tumOgrenciler[i].getNotDegeri(); // i. sayiyi en kucuk sayi kabul ettik
            int oAnkiEnBuyukElemaninIndeksi = i;

            for(int j=i+1; j<tumOgrenciler.length; j++) // i yi en kucuk kabul ettikten sonra bu dongu sayesinde diger elemanlarla karsilastirmasini yapacagiz
            {                                  // bu dongu en kucuk sayi 0. indise gelene kadar devam etmis oluyor,
                // her bir indis icin dizi eleman sayisi kadar tekrar tekrar calisarak bunu yapiyor,
                // yani ilk elemani sirayla tum diger elemanlar ile karsilastirmis oluyor
                if(oAnkiEnBuyukSayi < tumOgrenciler[j].getNotDegeri()) // bu su demek: en kucuk sayimdan daha kucuk bir sayi buldum
                {
                    oAnkiEnBuyukSayi = tumOgrenciler[j].getNotDegeri(); // sayiyi degiskenime aktardim, henüz yer degistirme yapmadim,
                    // sadece yeni en kücük sayimi hafizamda tuttum
                    oAnkiEnBuyukElemaninIndeksi = j; // indeksi degiskenime aktardim, henüz yer degistirme yapmadim,
                    // sadece yeni en kücük sayimin indeksini hafizamda tuttum
                }
            }
            if(oAnkiEnBuyukElemaninIndeksi != i) // yeni buldugum en kucuk eleman, en kucuk saydigim indekste yer almiyorsa
            {                                    // yer degistirmeyi yapan if burasi
                tumOgrenciler[oAnkiEnBuyukElemaninIndeksi] = tumOgrenciler[i]; // en kucuk elemani en kucuk indekse koymak icin yer degistiryorum
                tumOgrenciler[i].setNotDegeri(oAnkiEnBuyukSayi) ;
            }
        }
    }
}

class OgrenciOdev
{
    private int id;
    private int notDegeri;


    public OgrenciOdev(int id, int notDegeri)
    {
        this.id = id;
        this.notDegeri = notDegeri;

    }

    public int getId()
    {
        return id;

    }
    public void setId(int id)
    {
        this.id = id;

    }
    public int getNotDegeri()
    {
        return notDegeri;

    }
    public void setNotDegeri(int notDegeri)
    {
        this.notDegeri = notDegeri;

    }
    public void ogrenciBilgileriniYazdir()
    {
        System.out.println("ID: " +id+"NOT: " +notDegeri);

    }
}
