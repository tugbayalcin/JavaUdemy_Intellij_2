package Section7_JavaOOP.bolumSonuOdevler;

public class BolumSonuOdev_4
{   // SORU4: Bir banka hesabi icin sinif tasarlayin.
    // Bu sinifta hesabin kime ait oldugunu tutan hesapNo,hesaptakiPara,para yatirma ve cekme methodlari olsun
    // Ayrica bu hesaplarda olan tum parayi, acilan hesap sayisini, yapilan toplam para cekme ve para yatirma sayisini
    // gosteren bir method ve iki hesabi para degiskenine gore birbiri ile kıyaslayacak method bulunmali

    public static void main(String[] args)
    {
        Banka tugba = new Banka(123,500);
        Banka yalcin = new Banka(321,1500);
        Banka asel = new Banka(435,2200);
        asel.paraYatir(250);
        tugba.paraCek(600);
        yalcin.paraCek(450);
        Banka.bankaOzetiGoater();
        tugba.kiyasla(yalcin);
        yalcin.kiyasla(tugba);

    }
}

class Banka
{
    private int hesapNo;
    private int hesapBakiye;
    private static int tumBankaBakiyesi=0;
    private static int tumHesapSayisi=0;
    private static int islemSayisi=0;

    public Banka(int hesapNo, int hesapBakiye)
    {
        this.hesapNo = hesapNo;
        this.hesapBakiye = hesapBakiye;
        tumBankaBakiyesi+=hesapBakiye;
        tumHesapSayisi ++;
    }

    public int getHesapNo()
    {
        return hesapNo;

    }
    public void setHesapNo(int hesapNo)
    {
        this.hesapNo = hesapNo;

    }
    public int getHesapBakiye()
    {
        return hesapBakiye;

    }
    public void setHesapBakiye(int hesapBakiye)
    {
        this.hesapBakiye = hesapBakiye;

    }
    public void paraYatir(int paraMiktari)
    {
        this.hesapBakiye += paraMiktari;
        islemSayisi++;

    }
    public void paraCek(int paraMiktari)
    {
        if(this.hesapBakiye>=paraMiktari)
        {
            this.hesapBakiye -= paraMiktari;
            islemSayisi++;
            tumBankaBakiyesi-=paraMiktari;
        }
        else
        {
            System.out.println("Hesabinizda Yeterli Bakiye Yoktur");
        }


    }
    public static void bankaOzetiGoater()
    {
        System.out.println("Bankadaki Hesap Satisi: " + tumHesapSayisi);
        System.out.println("Bankadaki Toplam Para: " + tumBankaBakiyesi);
        System.out.println("Bankada Yapilan Tum İslemlerin Sayisi: " + islemSayisi);
    }
    public void kiyasla(Banka kiyaslanacakHesap)
    {
        if(this.getHesapBakiye() < kiyaslanacakHesap.getHesapBakiye())
        {
            System.out.println(this.getHesapNo() + " hesap no'lu kisinin parasi " + kiyaslanacakHesap.getHesapNo() + " hesap no'lu kisinin parasindan azdir");
        }
        else if(this.getHesapBakiye() > kiyaslanacakHesap.getHesapBakiye())
        {
            System.out.println(this.getHesapNo() + " hesap no'lu kisinin parasi " + kiyaslanacakHesap.getHesapNo() + " hesap no'lu kisinin parasindan coktur");
        }
        else
        {
            System.out.println(this.getHesapNo() + " hesap no'lu kisinin parasi " + kiyaslanacakHesap.getHesapNo() + " hesap no'lu kisinin parasina esittir");

        }

    }
}
