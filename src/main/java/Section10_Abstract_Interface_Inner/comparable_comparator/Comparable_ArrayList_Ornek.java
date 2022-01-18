package Section10_Abstract_Interface_Inner.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparable_ArrayList_Ornek
{
    public static void main(String[] args)
    {
        Sporcu s1=new Sporcu("A",100);
        Sporcu s2=new Sporcu("C",30);
        Sporcu s3=new Sporcu("B",20);

        List<Sporcu> sporcuList=new ArrayList<>();
        sporcuList.add(s1);
        sporcuList.add(s2);
        sporcuList.add(s3);

        Collections.sort(sporcuList);
        System.out.println(sporcuList);
        //[Sporcu{isim='A', yas=10}, Sporcu{isim='B', yas=20}, Sporcu{isim='C', yas=30}]


        Collections.sort(sporcuList,Collections.reverseOrder());
        System.out.println(sporcuList);
        //[Sporcu{isim='C', yas=30}, Sporcu{isim='B', yas=20}, Sporcu{isim='A', yas=10}]

    }

}


class Sporcu implements Comparable<Sporcu> {

    String isim;
    int yas;

    public Sporcu(String isim, int yas) {
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

    @Override
    public int compareTo(Sporcu o) {
        return this.isim.compareTo(o.getIsim());
    }
}
