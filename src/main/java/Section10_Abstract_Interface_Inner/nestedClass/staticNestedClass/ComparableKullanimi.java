package Section10_Abstract_Interface_Inner.nestedClass.staticNestedClass;

import java.util.Arrays;

public class ComparableKullanimi
{
    public static void main(String[] args)
    {
        Ogrenci ogr1 = new Ogrenci(5,"tugba");
        Ogrenci ogr2 = new Ogrenci(3,"hasan");
        Ogrenci ogr3 = new Ogrenci(7,"ayse");

        Ogrenci[] ogrenciler = {ogr1,ogr2,ogr3};
        String[] isimler = {"ayse", "fatma", "hayriye", "aliye"};

        Arrays.sort(isimler);
        for(String i : isimler)
            System.out.println(i);
        // bu kod hata vermiyor cunku sort(siralama) isleminin yapilmasini saglayan compare methodu String classi icinde var

        System.out.println("Dizi siralanmadan once:");
        for (Ogrenci gecici:ogrenciler) // foreach--> ":" nin sag tarafina gezilecek dizi yazilir, sol tarafina ise gecici eleman atanir ve tipi ile birlikte yazilir
        {
            System.out.println(gecici);
        }

        Arrays.sort(ogrenciler); // buraya ben dizimin kendisini gonderdigim icin yapilan degisiklikler kalici olacaktir
        System.out.println("Dizi siralandiktan sonra:");
        for (Ogrenci gecici:ogrenciler)
        {
            System.out.println(gecici);
        }
        // hata aldik! Niye: sort isleminin yapilmasini saglayan compare methodu bizim classimizda yok da ondan,
        // sort neye gore siralayacagini bilmiyor
        // bu ozelligi bir anlasma gibi dusunursek gidip onu kabul edebilmek icin implement etemiz gerekiyor
        // ve ettigimiz anda comparable methodunu da implement edebiliyoruz
        // ! Arrays.sort bizi interface kullanmaya zorladi


    }
}
class Ogrenci implements Comparable<Ogrenci>
{
    int id;
    String ad;

    public Ogrenci(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                '}';
    }

    @Override // methodun icini istedigimiz gibi duzenledik
    public int compareTo(Ogrenci o)
    // id ye gore siralama
    /*
    {
        if(this.id < o.id)
        {
            return -1;
        }
        else if (this.id > o.id)
        {
            return 1;
        }
        else return 0;

    }

     */

    // ad a gçüöre siralama
    {
        if(this.ad.compareTo(o.ad) < 0)
        {
            return -1;
        } else if(this.ad.compareTo(o.ad) > 0)
        {
            return 1;
        }
        return 0;
    }
}
