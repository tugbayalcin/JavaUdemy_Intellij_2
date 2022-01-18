package Section10_Abstract_Interface_Inner.comparable_comparator;

import java.util.Arrays;

//<editor-fold defaultstate="collapsed" desc="comparableKullanımı">

public class ComparableUsage
{
    public static void main(String args[])
    {
        String[] a1={"a","c","b"};
        Arrays.sort(a1);
        for(String obj :  a1)
            System.out.println(obj);// a b c yazdırcak



        ///String sınıfında compareTo() methodu olduğu için hata vermiyor
        //cünkü String ifadelerin ilk harfine göre sıralama yapar


        Studentt std1=new Studentt(1,"Pilot");
        Studentt std2=new Studentt(4,"Teğmen");
        Studentt std3=new Studentt(2,"Teğmen");
        Studentt std4=new Studentt(3,"Emre");

        Studentt[] StudentList={std1,std2,std3,std4};
        System.out.println("*******Before Sorting Out StudentList********");
        for(Studentt obj :  StudentList)
            System.out.println(obj);

        Arrays.sort(StudentList);//burada id'ye göre mi name'e göre mi sıralanacak bilemiyoruz
        //Cunku Studentt classımda compare() methodu bulunmuyor
        //Kendi yazdigim classimin kendi objelerimi nasil sort edicem- siraya gore dizicem?
        //Cevap Studentt Classi Comparable interface ini implemet edecek

        System.out.println("*******After Sorting Out StudentList********");
        for(Studentt obj :  StudentList)
            System.out.println(obj);
        /*
            *******After Sorting Out StudentList********
            Studentt{id=1, name=Pilot}
            Studentt{id=2, name=Teğmen}
            Studentt{id=3, name=Emre}
            Studentt{id=4, name=Teğmen}
        */

        System.out.println(std1.compareTo(std2));//ilk obje'nin id'si kiyaslama yapilan obje'nin id'sinden kucukse -1 return edilir
        System.out.println(std2.compareTo(std3));//durum tam tersiyse +1 return edilir
        System.out.println(std1.compareTo(std1));//id leri ayniysa 0 return edilir



        //EK TEKRAR - STRING CLASS'INDAKI compareTo() methodunun kullanimini hatirlayalim

        System.out.println("a".compareTo("c"));// a is less than c / -2
        System.out.println("a".compareTo("a"));//equal / 0
        System.out.println("b".compareTo("aaaa"));//b is greater than a / 1
        System.out.println("bb".compareTo("aa"));//b is greater than a / 1
        System.out.println("ab".compareTo("ac"));//b is greater than a / -1 ilk harfler esitse yana gecilir
    }
}

class Studentt implements Comparable<Studentt>//bu interface'in içinde sadece bir abstract method var
{
    int id;
    String name;

    public Studentt(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Studentt{" + "id=" + id + ", name=" + name + '}';
    }

    //id ye gore siralama icin override edilmis compareTo() kucukten->buyuge
    @Override
    public int compareTo(Studentt o)
    {

        if(this.id > o.id)
            return 1;
        else if(this.id < o.id)
            return -1;
        else
            return 0;

    }



   /*isim'e gore siralama icin override edilmis compareTo()
    @Override
    public int compareTo(Studentt o)
     {
        if(this.name.compareTo(o.name)<0)   //bu name in ilk harfinin ascii kodu bir sonraki name'inkinden küçükse
            return 1;   //nesne diğerinden küçükse eksi deger cıkar , sart saglanır

        else if(this.name.compareTo(o.name) > 0)
            return -1;  //büyükse sart sasglanır

        else
            return 0;
    }

    */


}

// </editor-fold>
