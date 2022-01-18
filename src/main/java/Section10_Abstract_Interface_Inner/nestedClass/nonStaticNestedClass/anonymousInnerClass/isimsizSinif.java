package Section10_Abstract_Interface_Inner.nestedClass.nonStaticNestedClass.anonymousInnerClass;

public class isimsizSinif // anonim ic sinif
{
    public static void main(String[] args)
    {
        Hesaplayici hesaplayici = new Hesaplayici();
        hesaplayici.topla(5,6);

        /*
            Asagida yapacagimşz islem su:
            Hesaplayici hesaplayici1 = new Hesaplayici()
            dedikten sonra sanki yeni bir class olusturuyormusuz gibi {}; parantezlerimizi aciyoruz, sonuna ; koymayi unutmuyoruz
            ve parantezler arasina methodumuzu override edip icinde istedigimiz gibi degisiklik yapiyoruz
            ardinda methodu cagirmayi unutmuyoruz
            boylece ana classtaki methodu bozmadan kendi istedigim seyleri ekleyebildim
            bu yapiya anonymous class denir, bu 1. yol idi
         */
        Hesaplayici hesaplayici1 = new Hesaplayici()
        {
            @Override
            public void topla(int s1, int s2)
            {
                System.out.println("Iki sayinin toplami:");
                super.topla(s1, s2);
            }
        };
        hesaplayici1.topla(8,9);

        // 2.yol: normal sartlarda abstract classtan nesne uretilemez ancak buarada uretiyormus gibi yazip anonymous class olusturacagiz
        Canli canli = new Canli() {
            @Override
            void adiniSoyle() {
                System.out.println("Ben isimsiz siniftan geliyorum. Adim anonim");

            }

            @Override // bu methodu da kullanabiliyorum
            void selamVer() {
                System.out.println("Ben isimsiz siniftaki selam ver methoduyum");
            }
        }; // sinifim olustu ancak ekrana cikti vermez, onu cagirmaliyim
        canli.adiniSoyle();
        canli.selamVer();


        Gecici g = new Gecici();
        g.adiniSoyle();
        g.selamVer();

        // 3.yol ınterfacelerden anonymous class olusturma
        Yazdir yazdirNesnesi = new Yazdir() {
            @Override
            public void yazdir() {
                System.out.println("anonymous inner class yazdirNesnesi methodu");
            }
        };
        yazdirNesnesi.yazdir();


       /* YeniHesaplayici yeniHesaplayici = new YeniHesaplayici();
        yeniHesaplayici.topla(10,5);
        */
    }
}

class FakeSinif implements Yazdir
{

    @Override
    public void yazdir() {
        // boyle yapmis da interface i kullanmisiz gibi oluyor anonymousda
    }
}
interface Yazdir // interface lerden de nesne uretilemez
{
    void yazdir();
}
class Gecici extends Canli // abstract classtan inherit alindiginda abstract method mutlaka override edilmelidir. isterse diger methodlari da override edebilir
{

    @Override
    void adiniSoyle() {

    }

    @Override
    void selamVer() {
        System.out.println("Gecici");
    }
}
abstract class Canli // bu siniftan nesne uretemeyiz cunku abstract
{
    abstract void adiniSoyle();
    void selamVer()
    {
        System.out.println("Merhaba");
    }

}
class YeniHesaplayici extends Hesaplayici
{
    @Override
    public void topla(int s1, int s2) {
        System.out.println("Iki sayinin toplami:"); // tum bu yeni classi bu satiri bu methoda ozel olarak eklemek istememizdi
        super.topla(s1, s2); // bunun daha kisa yolu ise anonymous inner classlardie
    }
}
