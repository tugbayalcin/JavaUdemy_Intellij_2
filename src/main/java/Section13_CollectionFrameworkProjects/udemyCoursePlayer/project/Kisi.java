package Section13_CollectionFrameworkProjects.udemyCoursePlayer.project;

public abstract class Kisi
{
    // ben bu class'dan obje uretilmesini istemiyorum
    // bu class'a ortak ozellikleri koymak istiyorum, toplayici bir parent olsun istiyorum
    // bu yuzden class'imizi abstract yaptik
    private String isim;
    private String tanitimYazisi;
    private String kullaniciAdi;

    public Kisi(){} // parametresiz constructor

    public Kisi(String isim, String tanitimYazisi, String kullaniciAdi) {
        this.isim = isim;
        this.tanitimYazisi = tanitimYazisi;
        this.kullaniciAdi = kullaniciAdi;
    }
    // burada isim, tanitimYazisi ve kulaniciAdi ile ilgili degisiklikler yapmak istemiyorum
    // yapilabilir ama proje uzar
    // eger degisiklik yapmayacaksam setter methodlarina ihtiyacim yok
    // ancak ben bir objenin yalnizca isim degiskenine veya yalnizca kullaniciAdi'na erismek isteyebilirim
    // bunun icin getter methodlara ihtiyacim var

    public String getIsim() {
        return isim;
    }

    public String getTanitimYazisi() {
        return tanitimYazisi;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    // mutlaka kisi nesnesini yazdirmak isteyecegim icin lazim
    @Override
    public String toString() {
        return "Kisi{" +
                "isim='" + isim + '\'' +
                ", tanitimYazisi='" + tanitimYazisi + '\'' +
                ", kullaniciAdi='" + kullaniciAdi + '\'' +
                '}';
    }
}
