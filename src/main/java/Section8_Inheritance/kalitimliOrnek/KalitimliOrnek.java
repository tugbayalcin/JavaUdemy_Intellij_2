package Section8_Inheritance.kalitimliOrnek;

public class KalitimliOrnek
{
    public static void main(String[] args)
    {
        Personel mudur = new Personel("Ahmet",123345,40,"Müdür");
        System.out.println(mudur); // personel classinin constructor inda yalnizca pozisyon degiskenine atama yapilirsa,
                                   // her ne kadar Kisi classinin elemanlari da personele ait olsa da,
                                   // tanimlamasi yapilmadigi icin default degerleri yazdirilacaktir ve de personel classinda olmadigi icin
                                   // ata classtaki toString methodu calisir
        Ogrenci tugba = new Ogrenci("tugba", 121212,13,152);
        System.out.println(tugba);

        MezunOgrenci mezun = new MezunOgrenci("Hasan",223535,35,678,"Ankara");
    }
}

class Kisi {
    private String isim;
    private long tcKimlik;
    private int yas;

    public Kisi() {
        isim = "Henüz Atanmadı";
        tcKimlik = 0;
        yas = 18;
    }

    public Kisi(String isim, long tcKimlik, int yas) {
        this.isim = isim;
        this.tcKimlik = tcKimlik;
        setYas(yas); // bunu bu sekilde degistirmemizin sebebi: eger ben bu constructos ile bir obje olusturup yas parametresine -4
        // girse idim yas -4 olarak yazdirilacakti. ama ben setter methıdda bunun kontrolunu yapan bir if eklemistim.
        // buraya da yas degerini o set methodu ile gelip yazmaya calisirsam, kontrol saglanacak ve daha dogru sonuc almis olacagim
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public long getTcKimlik() {
        return tcKimlik;
    }

    public void setTcKimlik(long tcKimlik) {
        this.tcKimlik = tcKimlik;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        if (yas >= 18)
            this.yas = yas;
        else this.yas = 18;
    }

    @Override
    public String toString() {
        return "Kisi{" +
                "Isim='" + isim + '\'' +
                ", TC Kimlik=" + tcKimlik +
                ", Yas=" + yas +
                '}';
    }
}
class Personel extends Kisi // her bir personel ayni zamanda bir kisi oldugu icin turetebildik
{
    private String pozisyon;

    // constructor otomatik olustururken bize super sinifin hangi constructorunu kullanarak olusturacaksin diye soruyor !!!
    public Personel(String isim, long tcKimlik, int yas, String pozisyon)
    {
        setYas(yas);
        setIsim(isim);
        setTcKimlik(tcKimlik);
        this.pozisyon = pozisyon;
    }

    public String getPozisyon() {
        return pozisyon;
    }

    public void setPozisyon(String pozisyon) {
        this.pozisyon = pozisyon;
    }

    @Override
    public String toString() {
        return "Personel{" +
                "pozisyon='" +  pozisyon + '\'' +"Isim='" + getIsim() + '\'' +
                ", TC Kimlik=" + getTcKimlik() +
                ", Yas=" + getYas() +
        '}';
    }
}
class Ogrenci extends Kisi
{
    private int ogrenciNo;

    public Ogrenci(String isim, long tcKimlik, int yas, int ogrenciNo) {
      //  setYas(yas);
      //  setIsim(isim);
      // setTcKimlik(tcKimlik);
        // bu satirlar yerine daha pratik bir sey yapalim
        super(isim, tcKimlik, yas); // super. yazarsak ust sinifin methodlarina, super() yazarsak ust sinifin constructorlarina erisiriz
        this.ogrenciNo = ogrenciNo; // daima super satırı, yeni tanimlanacak degiskenlerin ustunde yer almali
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(int ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                " isim=" + getIsim() +
                ", yas=" + getYas()+
                ", tc kimlik=" + getTcKimlik()+
                ", ogrenciNo=" + ogrenciNo +
                '}';
    }
}
class MezunOgrenci extends Ogrenci
{
    private String calismaYeri;

    public MezunOgrenci(String isim, long tcKimlik, int yas, int ogrenciNo, String calismaYeri) {
        super(isim, tcKimlik, yas, ogrenciNo);
        this.calismaYeri=calismaYeri;
    }
}