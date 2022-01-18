package Section9_GenelTekrar.TelevizyonSimulasyonu;

import java.util.ArrayList;

public class Televizyon
{
    private String marka;
    private String boyut;
    private ArrayList<Kanal> kanallar; // composition, polimorphism, inheritance
    /* Kanal verisi tutan bir diziye gittim haber kanali atadim,
       cunku haber kanali da bir kanal ve kalitim almis, o yuzden dizi bu elemani da tutabilir

     */
    private boolean acik;
    private int ses;
    private int aktifKanal; // yani acik olan kanal
    /*
        Private degerleri kontrol etmek icin methodlar yaziyoruz.
     */

    public Televizyon(String marka, String boyut)
    {
        this.marka=marka;
        this.boyut=boyut;
        kanallar = new ArrayList<>();
        ses=10;
        aktifKanal = 1;
        kanallariOlustur();
        this.acik= false; // tv kapali olsa bile kanallar olusturulacak, bunu engellemek icin bir method yazalim

    }
    public void sesArttir()
    {
        if(ses<820 && acik==true)
        {
            ses++;
            System.out.println("Ses Seviyesi:"+ses);
        }
        else
        {
            System.out.println("Ses Maksimum Duzeydedir. Daha Fazla Arttirilamaz veya TV Kapali");
        }
    }
    public void sesAzalt()
    {
        if(ses>0 && acik)
        {
            ses--;
            System.out.println("Ses Seviyesi: "+ses);
        }
        else
        {
            System.out.println("Ses Miminimum Duzeydedir. Daha Fazla Azaltilamaz veya TV Kapali");
        }
    }
    public void tvAc()
    {
        if(acik==false)
        {
            acik=true;
            System.out.println("TV Acildi");
        }
        else
        {
            System.out.println("TV Zaten Acik");
        }
    }
    public void tvKapat()
    {
        if(acik==true)
        {
            acik=false;
            System.out.println("TV Kapandi");
        }
        else
        {
            System.out.println("TV Zaten Kapali");
        }
    }
    private void kanallariOlustur()
    {
        Kanal a = new Kanal();
        HaberKanali cnn = new HaberKanali("CNN",1,"Genel Haber");
        kanallar.add(cnn);
        HaberKanali bein = new HaberKanali("BeinSport",2,"Spor Haberi");
        kanallar.add(bein);
        MuzikKanali dreamTurk = new MuzikKanali("Dream Türk",3,"Yerli");
        kanallar.add(dreamTurk);
        MuzikKanali numberOne = new MuzikKanali("Number One",4,"Yabanci");
        kanallar.add(numberOne);
    }
    public void kanalDegistir(int acilmasiIstenenKanal)
    {
        if(acik) // acik==true demekle ayni,
        {
            if(acilmasiIstenenKanal != aktifKanal)
            {
                if(acilmasiIstenenKanal<=kanallar.size() && acilmasiIstenenKanal>=0) // listedeki kanal sayimdan daha buyuk bbir kanal sayisi girilmesini engellemek istiyorum
                {
                    aktifKanal=acilmasiIstenenKanal;
                    System.out.println("Kanal:"+acilmasiIstenenKanal+" \nBilgi: --> "+kanallar.get(aktifKanal-1).kanalBilgisiniGoster());
                }
                else
                {
                    System.out.println("Gecerli Bir Kanal Numarasi Giriniz.");
                }
            }
            else
            {
                System.out.println("Zaten "+aktifKanal+". Kanaldasiniz. Degistirme Yapilamadi.");
            }
        }
        else
        {
            System.out.println("Lutfen Once Televizyonu Aciniz.");
        }
    }
    public void aktifKanaliGoster()
    {
        if(acik)
        {
            System.out.println("Aktif Kanal: " + kanallar.get(aktifKanal-1).kanalBilgisiniGoster());
        }
        else
        {
            System.out.println("Lutfen Once Televizyonu Aciniz.");
        }
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    @Override
    public String toString() {
        return "Televizyon{" +
                "marka='" + marka + '\'' +
                ", boyut='" + boyut + '\'' +
                " olan TV olusturuldu. " +
                '}';
    }
}
