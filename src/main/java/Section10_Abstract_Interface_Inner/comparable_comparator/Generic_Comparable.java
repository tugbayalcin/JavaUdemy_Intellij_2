package Section10_Abstract_Interface_Inner.comparable_comparator;



public class Generic_Comparable
{


    public static void main(String args[])
    {
        Integer inums[] = { 3, 6, 2, 8, 6 };
        Character chs[] = { 'b', 'r', 'p', 'w' };

        MyClass2<Integer> a = new MyClass2<>(inums);
        MyClass2<Character> b = new MyClass2<>(chs);

        int i1 = a.max();
        System.out.println(i1);

        System.out.println(b.max());




        //Kendi Classimdan 3 obje olusturdum
        Ogrencii ogr1=new Ogrencii(10,"Ayse");
        Ogrencii ogr2=new Ogrencii(20,"Fatma");
        Ogrencii ogr3=new Ogrencii(30,"Zeynep");
        //tum objerimi arrayin icine attim
        Ogrencii[] ogrencilerArrayi={ogr1,ogr2,ogr3};

        //simdi arrayimin icinden en buyuk olani RETRUN ETMEK ISTIYORUM
        MyClass2<Ogrencii> c = new MyClass2<>(ogrencilerArrayi);

        Ogrencii ismiEnSondaOlanOgrenci= c.max();
        System.out.println(ismiEnSondaOlanOgrenci);
        System.out.println(ismiEnSondaOlanOgrenci.isim);

        //Sorting yap
        //max min getir
        //birebir compareTo yap
        System.out.println(ogr1.compareTo(ogr2));

    }
}

class Ogrencii implements Comparable<Ogrencii>
{
    int numara;
    String isim;

    public Ogrencii(int numara, String isim) {
        this.numara = numara;
        this.isim = isim;
    }

    @Override
    public String toString() {
        return "Ogrencii{" +
                "numara=" + numara +
                ", isim='" + isim + '\'' +
                '}';
    }

    //isim'e gore siralama icin override edilmis compareTo()
    //BUYUKTEN KUCUGE SIRALAR
    @Override
    public int compareTo(Ogrencii o)
    {

        if(this.isim.compareTo(o.isim)>0)   //bu isim in ilk harfinin ascii kodu bir sonraki name'inkinden küçükse
            return 1;                       // if'in ici -1<0

        else if(this.isim.compareTo(o.isim) < 0)
            return -1;

        else
            return 0;


    }


}


interface MinMax2<T>
{
    T max();
}

class MyClass2<T extends Comparable<T>> implements MinMax2<T>//Kendi Generic Class'imi olustrudum
{                                                            //Kendi generic interface'imi implements ediyor
    private T[] vals;                                         //T tipinin kesinlikle Comparable interface'ini implements etmis olmasi sartini koydum
    //Mesela->Integer, String, Float, gibi veri tiplerinin wrapper classlari Comparable'i inplements
    public MyClass2(T[] o)                                  //ettikleri icin runtime esnasinda hata almam
    {
        vals = o;
    }

    public T max()
    {
        //Arrayin icindeki max degeri return etme algoritmasi
        T v = vals[0];
        for (int i = 1; i < vals.length; i++)
        {
            if (vals[i].compareTo(v) > 0)//BURADAKI compareTo() methodu hangi veritipiyle calisiyorsam o class'tan geliyor.Mesela;
            {                            //String array ile calisiyorsam String Classindan
                v = vals[i];             //Ogrencii array ile calisiyorsam Ogrencii Classindan geliyor
            }
        }
        return v;
    }

}


