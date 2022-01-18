package Constructor.thisKullanimi;

import java.util.ArrayList;
import java.util.List;

public class ThisObjectIliskisi
{
    public static void main(String[] args)
    {
        List<Ogrenci> ogrenciListesi = new ArrayList<>();

        Ogrenci ogrenci1 = new Ogrenci(1, "Ali Bal");
        Ogrenci ogrenci2 = new Ogrenci(2, "Ayşe Yaman");

        ogrenci1.ekle(ogrenciListesi);
        ogrenci2.ekle(ogrenciListesi);

        System.out.println(ogrenciListesi);

        System.out.println(ogrenci1.getOgrenci());

    }


}

 class Ogrenci {

    private int no;
    private String isim;

    public Ogrenci(int no, String isim) {
        this.no = no;
        this.isim = isim;
    }

     public Ogrenci getOgrenci()
     {
         return this;//toString() varsa obje'nin ici gozukucek.Yoksa obje'nin reference numrasi yazar
     }

     public void ekle(List<Ogrenci> liste) {
         liste.add(this);
     }



     @Override
     public String toString() {
         return "Ogrenci{" +
                 "no=" + no +
                 ", isim='" + isim + '\'' +
                 '}';
     }
 }

