package Section11_Generic_Package_Jar.JarFileOlusturma;

import java.util.Objects;

public class RasyonelSayi implements Comparable<RasyonelSayi>
{
    private int pay;
    private int payda;

    public RasyonelSayi() // default degerlerini kendim atadigim constructorım
    {
        pay=0;
        payda=1;
    }
    public RasyonelSayi(int pay, int payda) // degerleri kullanicidan aldigim constructor
    {
        int ebob = ebobBul(pay,payda);
        this.pay = ((payda > 0) ? 1:-1) * (pay / ebob); // paydaya eksi deger yazilirsa bunu pay kismina yazdirmak istiyorum ve bu kontrolu ternary ile yapiyorum
        this.payda = Math.abs(payda) / ebob; // her ikisi de - girildiginde sonucum pozitif cikmali diye bu kontrolu yazmam gerekiyor
    }

    private int ebobBul(int pay, int payda) // kullanici 2/4 girerse ben bunu 1/2 seklinde yazdirayim ki islem kolayligi olsun diye ebob buluyorum
    {
        int payMutlakDeger= Math.abs(pay); // kullanici negatif deger girdiginde onu pozitif olarak kullanmak icin Math kutuphanesindeki mutlak deger methodundan yararlaniyorum
        int paydaMutlakDeger= Math.abs(payda);
        int ebob = 1;

        for(int i=1; i<= payMutlakDeger && i<= paydaMutlakDeger; i++) // opay ve opaydamdan hangisinin buyuk oldugunu bilmedigim icin, i yi onlarin her ikisinden de kucuk tutmaya calisiyorum
        {
            if(payMutlakDeger % i ==0 && paydaMutlakDeger % i==0) // her ikisine de bolunmeli ki sadelestirme yapabileyim
            {
                ebob = i; // i her ikisini de kalansiz boldu ise o zaman ebobumuzdur
            }
        }
        return ebob;
    }

    public RasyonelSayi toplama(RasyonelSayi toplanacakSayi)
    {
        int yeniPay = (this.pay * toplanacakSayi.payda) + (this.payda * toplanacakSayi.pay); // a/b + c/d icin toplam (ad+bc)/bd olur, bunu yazmaya calisiyoruz
        int yeniPayda = this.payda * toplanacakSayi.payda;
        RasyonelSayi toplam = new RasyonelSayi(yeniPay,yeniPayda);

        return toplam;
    }

    public RasyonelSayi cikarma(RasyonelSayi cikarilacakSayi)
    {
        int yeniPay = (this.pay * cikarilacakSayi.payda) - (this.payda * cikarilacakSayi.pay); // a/b + c/d icin toplam (ad+bc)/bd olur, bunu yazmaya calisiyoruz
        int yeniPayda = this.payda * cikarilacakSayi.payda;
        RasyonelSayi fark = new RasyonelSayi(yeniPay,yeniPayda);
        return fark;
    }

    public RasyonelSayi carpma(RasyonelSayi carpilacakSayi)
    {
        int yeniPay = this.pay * carpilacakSayi.pay;
        int yeniPayda = this.payda * carpilacakSayi.payda;
        RasyonelSayi carpim = new RasyonelSayi(yeniPay,yeniPayda);
        return carpim;
    }

    public RasyonelSayi bolme(RasyonelSayi bolunecekSayi)
    {
        int yeniPay = this.pay * bolunecekSayi.payda;
        int yeniPayda = this.payda * bolunecekSayi.pay;
        RasyonelSayi bolum = new RasyonelSayi(yeniPay,yeniPayda);
        return bolum;
    }

    @Override
    public String toString() {
       if(payda ==1)
       {
           return pay + ""; // pa integer oldugu ve bizim geriye string dondurmemiz gerektigi icin yanina "" ekledik ve concat kurallari geregi urasi string oldu
       }
       else
       {
           return pay + "/" + payda;
       }
    }

    @Override
    public int compareTo(RasyonelSayi o) {
        if(this.cikarma(o).pay > 0) // iki sayiyi birbirinden cikaririz ve sonu cnegatif gelirse ilk sayi kucuktur, pozitif gelirse ilk sayi buyuktur, mantigimiz bu olacak
        {
            return 1;
        }
        else if(this.cikarma(o).pay < 0)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RasyonelSayi)) return false;
        RasyonelSayi that = (RasyonelSayi) o;
        return pay == that.pay && payda == that.payda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pay, payda);
    }
}
