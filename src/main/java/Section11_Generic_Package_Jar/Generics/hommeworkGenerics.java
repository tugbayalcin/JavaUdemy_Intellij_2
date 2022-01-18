package Section11_Generic_Package_Jar.Generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class hommeworkGenerics
{
    {
        System.out.println("GENERİCS");
        /*
            NOTES : https://medium.com/bili%C5%9Fim-hareketi/java-generics-7948a2da58d3
            // calisami bu adresteki bilgileri referans alarak olusturdum,
            calisirken wildcard kismi icin ozellikle siteden bakilmasi tavsiye olunur


            Farkli referance tipleri alan bir yapi (method, class, interface) olarak dusunebiliriz
            Yapinin basinda hangi data type ile calisacagimizi belirtiriz
            ve yapi boyunca Type olarak belirlenen, Type'in kulanildigi her yer bizim belirttigimiz tipe donuserek calisir


            Bu olay her seyin atasi olarak bildigimiz Object class ile yapilamaz miydi?
            Yapilabilirdi, zaten Generics oncesi bu sekilde bir kullanim saglaniyordu ancak birazdan gorecegiz ki
            bu cok da guvenli bir kullanim degil. Neden mi? --> example1 methoduna bakalim

            Generic'in ne oldugunu ve neden kullanildigini anladik
            Simdi de nasil ve hangi yapilarla kullanildigina bakalim
            Genericler method, class ve interface'lerle birlikte kullanilabilirler
            Method ile kullanimi icin example2'ye bakalim
            Class ile kullanimi icin example3'e bakalim
            Interface ile kullanimi icin example4 ve example5'e  bakalim
        */

    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Merhaba Dünya");
        //list.add(123);
        for (int i = 0; i < list.size(); i++) {
            String string = list.get(i);
        }
    }

}
class example1
{
    public static void main(String[] args)
    {
        System.out.println(7);

    }

    public static void example1()
    {
        List liste2 = new ArrayList(); // listem olustu butun veri tiplerini alabilen arraylist
        liste2.add(new String("String bir deger -OBJECT"));
        // Farkli veri turleri ile calisabilecegim bir liste istiyorum ve henuz generic bilmiyorum
        // Yapacagim ilk sey Object class'ini kullanmak olacaktir

        List<Object> liste = new ArrayList<Object>(); // listem olustu
        // simdi ben stringlerden olusan bir listem olsun istiyorum ve eleman eklemeye basliyorum
        // String de Object class'indan turetildigi icin hicbir sorun olmayacak ve kolaylikla elemanimi ekleyebilecegim

        liste.add("Tugba");
        liste.add("Asel");
        liste.add(true);
        liste.add(1.0);
        liste.add(123);

        // gordugumuz gibi bir hata yok
        // ama aslinda ben listeme bir integer sayi eklemis oldum
        // ya dalginligima geldi ve "" koymayi unuttum
        // ya kodumda degisiklik yapan baska biri ekledi
        // ya ben stringlerle calisacagimi unutup ekledim
        // ya da ben salagim ve kodlama bilmiyorum ne is yapacagimi bilmiyorum ve boyle bir ekleme yaptim
        // henuz editorum ne yapmaya calistigimdan haberdar olmadigi icin hata vermiyor

        // simdi listemizi yazdirmayi deneyelim
        System.out.println(liste); // ciktimiz soyle olur:  [Tugba, Asel, Kedi, 123]

        // peki ben liste uzerinde islemlerime devam etsem ve soyle bir kod yazsam
        for (int i = 0; i < liste.size(); i++)
        {
            String string = (String) liste.get(i);
        }
        // burada bir for dongusuyle listeyi gezip, her bir elemani string bir degiskene atamaya calisiyorum
        // hatta ne olur ne olmaz sen her seyi String'e casting yap ve ata diyorum
        // ancak Integer ifadeler bu sekilde String'e cevrilemezlerdi
        // Integer.toString() methodu kullanarak cevireblirim yalnizca

        // dolayisiyla burada cte olarak gormedigim ama programi calistirdigimda yani runtime'da alacagim bir hata avrdir
        // class cast exeption
        // bu gibi durumlarda ve yalnizca String ya da yalnizca Integer class'ina ait methodlari
        // karisik listemde kullanmaya kalktigimda daima hata alacagim

        // zaten benim istedigim sey suydu
        // ben bir liste yazayim
        // bu liste istedigimde tamamen String olsun, ya da Integer olsun, ya da Ogrenci olsun
        // karisik bir liste istemiyorum ama, karismasini da engelleyemiyorum

        // iste bu gibi guvenlik sorunlarini cozmeye yarayan
        // daha kisa kod yazmamizi saglayan
        // yazilan kodun baska yerlerde tekrar tekrar kullanilailmesini saglayan yapi
        // GENERİC yapisidir

        // Genericler ile hatalarimiz rte'ye donusmeden once cte olarak karsimiza cikar ve kodumuzu kolay yonetebilmemizi sagalr


    }
}

class example2
{
    public static void main(String[] args) {
        myGenericMethod(123);

        int a =5;
        String s = null;

        System.out.println(myGenericMethodWithParameter(a));
        System.out.println(myGenericMethodWithParameter(s));

        myGenericVoidMethod(a);
        myGenericVoidMethod(s);

        myGenericVoidMethodWithoutParameter();


    }

    public static void example2()
    {
        // Generic yapisinin method ile kullanilmasi

        // Generic yapisini kullanirken <> isaretinden faydalaniriz
        // genellikle Type kelimesinin kisaltilmisi olan T harfi yaygin olarak kullanilir
        // Methodlarda kullanirken dikkat etmemiz gereken en onemli sey generic type'in return type'dan once
        // yazilmasidir
        // parametreli, parametresiz, return type'i olan ya da olmayan methodlarda kullanilabilir

    }

    // return type'i T olan parametresiz generic method
    public static <T> String myGenericMethod(T typeDegisken)
    {
        T degisken=null;

        System.out.println(typeDegisken);
        typeDegisken = null;
        return String.valueOf(typeDegisken);

        // main methodda kullanmayi deneyelim
        // nasil kullanilir bilemedim
    }

    // return type'i T olan parametreli generic method
    public static <T> T myGenericMethodWithParameter(T object)
    {
        return object;

        // main methoddan kullanmayi deneyelim
    }

    // return type'i olmayan parametreli generic method
    public static <T> void myGenericVoidMethod(T object)
    {
        System.out.println(object);
    }

    // return type'i olmayan parametresiz generic method
    public static <T> void myGenericVoidMethodWithoutParameter()
    {
        T object = null;
        System.out.println(object);

        // nasil kullaniliyor ???
    }



}

class example3
{
    public static void main(String[] args)
    {
        String s = null;
        Integer i = 0;

        Printer<String>  pr1 = new Printer<String>();
        pr1.print(s);

        Printer<Integer> pr2 = new Printer<Integer>();
        pr2.print(i);

    }

     static class Printer<T>
     {
        public void print(T object)
        {
            System.out.println(object);
        }
    }
    // class basta bir Type aliyor ve bu type'i icindeki methoda parametre olarak gonderiyor
    // main methodda bu classtan obje ureterek kullanmayi deneyelim
}

class example4 implements Comparable<String>
{

    public static void main(String[] args) {
        String s1 = "Tugba";
        String s2 = "Tuba";
        System.out.println(s1.compareTo(s2));

        example4 exp1 = new example4();
        example4 exp2 = new example4();


        // exp1.compareTo(exp2);
        // eger generic kullanmamis olsaydik buradaki hatayi ancak runtime'da farkedebilirdik
        // ancak generic kullandigimiz ve classin basinda type'imizi String olarak belirledigimiz icin
        // artik compareTo() methodumuz yalnizca 2 stringi karsilastirirken kullanilabileceltir
        // burada ben kendi veri turum olan example4 classindan olusturdugum objeleri kiyaslamaya kalktim
        // bunlar string olmadigi icin cte aldim ve koduma hemen mudahale edebildim

        Integer i1 = 0;
        Integer i2 = 0;
        System.out.println(i1.compareTo(i2)); // bunu neden kabul ediyor bilmiyorum


    }

//  burayi tam yapamadim galiba, birlikte bakariz
    @Override
    public int compareTo(String object) {
        if(this.equals(object))
        {
            return 1;
        }
        else
            return -1;
    }
}

class example5 implements Comparable<Integer>
{
    public static void main(String[] args) {

    }

    // yine yapamadim burada bir hata var birlikte bakariz
    @Override
    public int compareTo(Integer object) {
       /*
        if(this = object)
            return 0;
        else if(this<object)
            return -1;
        else
            return 1;

        */
        return 0;
    }
}

interface Comparable<T>
{
    int compareTo(T object);
}

class A implements Comparator
{
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

}
