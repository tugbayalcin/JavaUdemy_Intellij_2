package Section8_Inheritance;

public class KalitimsizOrnek
{
    public static void main(String[] args)
    {
        Personel mudur = new Personel("Ahmet",111111111,-8);
        System.out.println(mudur);

        Ogrenci tugba = new Ogrenci("Tugba",18,123321,235);
        System.out.println(tugba);
    }
}

class Personel
{
    private String isim;
    private long tcKimlik;
    private int yas;

    public Personel()
    {
        isim = "Henüz Atanmadı";
        tcKimlik = 0;
        yas = 18;
    }

    public Personel(String isim, long tcKimlik, int yas) {
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
        if(yas>=18)
        this.yas = yas;
        else this.yas=18;
    }

    @Override
    public String toString() {
        return "Personel{" +
                "Isim='" + isim + '\'' +
                ", TC Kimlik=" + tcKimlik +
                ", Yas=" + yas +
                '}';
    }
}

class Ogrenci
{
    private String isim;
    private int yas;
    private long tcKimlik;
    private int okulNo;

    public Ogrenci()
    {
        isim = "Henüz Atanmadı.";
        yas = 0;
        tcKimlik = 0;
        okulNo = 5000;
    }
    public Ogrenci(String isim, int yas, long tcKimlik, int okulNo) {
        this.isim = isim;
        setYas(yas);
        this.tcKimlik = tcKimlik;
        this.okulNo = okulNo;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        if(yas>=7)
        this.yas = yas;
        else this.yas = 7;
    }

    public long getTcKimlik() {
        return tcKimlik;
    }

    public void setTcKimlik(long tcKimlik) {
        this.tcKimlik = tcKimlik;
    }

    public int getOkulNo() {
        return okulNo;
    }

    public void setOkulNo(int okulNo) {
        this.okulNo = okulNo;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "isim='" + isim + '\'' +
                ", yas=" + yas +
                ", tcKimlik=" + tcKimlik +
                ", okulNo=" + okulNo +
                '}';
    }

}