package Section13_CollectionFrameworkProjects.udemyCoursePlayer.project;

public class Egitmen extends Ogrenci // DIKKAT! Kisiden degil Ogrenci'den kalittik, her egitmen de bir ogrencidir
{
    // Kisi class'inin parametreli constructor'ini kullanarak bir Ogrenci constructor'i olusturalim
    public Egitmen(String isim, String tanitimYazisi, String kullaniciAdi) {
        super(isim, tanitimYazisi, kullaniciAdi); // bu satirda Ogrenci class'inin constructor'i calisiyor
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
