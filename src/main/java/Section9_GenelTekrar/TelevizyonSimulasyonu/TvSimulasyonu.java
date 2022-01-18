package Section9_GenelTekrar.TelevizyonSimulasyonu;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class TvSimulasyonu
{
    static Scanner tara = new Scanner(System.in); // tum class ve methodlarin erismesini istedigim icin burada tanimliyorum
    /* ancak bu durumda da non-static olan tara statik olan main mmethod gibi methodlar icincen cagirilamaz,
       o yuzden tarayi static olarak tanimliyoruz
       boyklece herhangi bir nesne uretmeden cagirabilecegiz
       zaten static demek classa ozgu ve classin her yerinden erisilebilir demekti, class adi ile cagirilabilir demekti
     */
    static Televizyon tv; // bir kullanici yalnizca 1 tv kurabilsin diye yaptik

    public static void main(String[] args)
    {

        menuGoster(); // kullanicidan degwer alarak menuyu kullandirmamiz gerekiyor,
        boolean cikis = false;

        while (cikis==false) // Kullanicvi 0'a basmadigi surece menunun gosterilmesi icin dongu tanimlıyorum
        {
            System.out.println("Seciminiz: (Menuyu Gormek Icin 8'i tuslayiniz)");
            int secim = tara.nextInt();

            switch (secim)
            {
                case 1:
                    tvKurVeKanallariOlustur();
                    break;
                case 2:
                    tvAc();
                    break;
                case 3:
                    sesArttir();
                    break;
                case 4:
                    sesAzalt();
                    break;
                case 5:
                    kanalDegistir();
                    break;
                case 6:
                    kanalBilgisiniGoster();
                    break;
                case 7:
                    tvKapat();
                    break;
                case 8:
                    menuGoster();
                    break;
                case 0:
                    System.out.println("Sistemden Cikiliyor.. ");
                    cikis=true;
                    break;
                default:
                    System.out.println("0 ile 8 Arasinda Bir Deger Giriniz");
                    break;
            }

        }
    }

    private static void kanalBilgisiniGoster()
    {
        if(tv!=null)
        {
            tv.aktifKanaliGoster();
        }
        else
        {
            System.out.println("Lutfen Once TV'yi Kurun ve Kanallari Olusturun.");
        }

    }

    private static void kanalDegistir()
    {
        /* kanali degistirebilmek icin televizyonumuzun acik olmasi lazim
           ancak bu kontrolu burada degil televizyon classinda yapmam daha mantikli
           cunku tv nin acik olup olmamasi dogrudan onu ilgilendiriyor
         */
        if(tv!=null)
        {
            System.out.println("Hangi Kanala Gitmek Istiyorsunuz: \n");
            int acilmasiIstenenKanal = tara.nextInt();
            tv.kanalDegistir(acilmasiIstenenKanal);
        }
        else
        {
            System.out.println("Lutfen Once TV'yi Kurun ve Kanallari Olusturun.");
        }

    }

    private static void sesArttir()
    {
        if(tv!=null) // yani tv olusturulmus ise
        {
            tv.sesArttir();
        }
        else
        {
            System.out.println("Lutfen Once TV'yi Kurun ve Kanallari Olusturun.");
        }
    }
    private static void sesAzalt()
    {
        if(tv!=null) // yani tv olusturulmus ise
        {
            tv.sesAzalt();
        }
        else
        {
            System.out.println("Lutfen Once TV'yi Kurun ve Kanallari Olusturun.");
        }
    }

    private static void tvKapat()
    {
        if(tv!=null)
        {
            tv.tvKapat(); // TV'nin acik mi kapali mi oldugunu kontrol etmek tvKapat Methodunun gorevi
        }
        else
        {
            System.out.println("Lutfen Once TV'yi Kurun, Kanallari Olusturun, TV'yi Acin ve Ardindan Kapatmayi Deneyin");
        }
    }

    private static void tvAc()
    {
        if(tv!=null) // tv henuz olusturulmamis ise onu acmamizin bir anlami olmaz
        {
            tv.tvAc();
        }
        else
        {
            System.out.println("Lutfen Once TV'yi Kurun ve Kanallari Olusturun.");
        }
    }

    private static void tvKurVeKanallariOlustur()
    {
        /*
          *  Burada programi calistirdigimizda kullanicidan alinacak veriler consolda ard arda soruldu,
             birini veri sorulup cevap alindiktan sonra ikinci veriye gecilemdi.
             daha onceki kullanicidan veri aldıgımız yapilarda bu durumla karsilasmistik ve cozum olarak basta bir kere bos olarak
             tara.nextLine();
             ifadesini calistirmamiz gerekiyordu

          *  Diger bir durum ise, kullanicidan alinacak verileri if yapisinin icine koyduk.
             Cunku, tv nin bir kere olusturulmasini istiyoruz ve olusturduktan sonra menuden tekrar 1 in secilmesi durumunda
             tekrardan kullaniciya gidip verileri sormasin, sorsa bile zaten olusturmayacak sekilde kodlarimi yazmistim
             ancak gereksiz yere sormasini da istemiyorum, bu yuzden Scanner kodlarimi if yapisi icine yazdim
        */


        if(tv==null) // bir kullanici yalnizca 1 tv olusturabilsin diye boyle yaptik
        {
            tara.nextLine();
            System.out.println("Televizyonun Markasini Giriniz:");
            String marka = tara.nextLine();
            System.out.println("Televizyonun Boyutunu Giriniz:");
            String boyut = tara.nextLine();
            tv = new Televizyon(marka,boyut);
            System.out.println(tv);
        }
        else
        {
            System.out.println(tv + " Bilgileri ile olusturulmus bir tv mevcut.");
        }

    }

    private static void menuGoster()
    {
        System.out.println("****************MENU******************");
        System.out.println("0 --> Cikis" +"\n"+
                "1 --> Televizyonu Kur" +"\n"+
                "2 --> Televizyonu Ac" +"\n"+
                "3 --> Sesi Arttir" +"\n"+
                "4 --> Sesi Azalt" +"\n"+
                "5 --> Kanali Degistir"+"\n"+
                "6 --> Kanal Bilgisini Goster"+"\n"+
                "7 --> Televizyonu Kapat"+"\n"+
                "8 --> Menuyu Goster"+"\n");
    }
}
