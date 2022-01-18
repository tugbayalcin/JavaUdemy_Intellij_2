package Section10_Abstract_Interface_Inner.comparable_comparator;

import requiredClasses.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator_Ornek1
{
    public static void main(String[] args)
    {

        Sporcu s1=new Sporcu("A",40);
        Sporcu s2=new Sporcu("C",100);
        Sporcu s3=new Sporcu("B",20);

        List<Sporcu> sporcuList=new ArrayList<>();
        sporcuList.add(s1);
        sporcuList.add(s2);
        sporcuList.add(s3);

        System.out.println("Yasa gore Kucukten -> Buyuge");

        Collections.sort(sporcuList,new YasComparator()); // yaşa göre sıralama yapar
        System.out.println(sporcuList);

        System.out.println("Isme gore Buyukten-Kucuge");
        Collections.sort(sporcuList,new IsimComparator()); // isme göre sıralama yapar
        System.out.println(sporcuList);
    }
}




class YasComparator implements Comparator<Sporcu> {
    @Override
    public int compare(Sporcu o1, Sporcu o2) {

        if(o1.getYas()>o2.getYas())
            return 1;
        else if(o1.getYas()<o2.getYas())
            return -1;
        else
            return 0;

    }
}

class IsimComparator implements Comparator<Sporcu>
{
    @Override
    public int compare(Sporcu o1, Sporcu o2) {

        if(o1.getIsim().compareTo(o2.getIsim())<0)
            return 1;
        else if(o1.getIsim().compareTo(o2.getIsim())>0)
            return -1;
        else
            return 0;

    }
}



class Sporcu2
{

    String isim;
    int yas;

    public Sporcu2(String isim, int yas) {
        this.isim = isim;
        this.yas = yas;
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
        this.yas = yas;
    }

    @Override
    public String toString() {
        return "Sporcu{" +
                "isim='" + isim + '\'' +
                ", yas=" + yas +
                '}';
    }

}
