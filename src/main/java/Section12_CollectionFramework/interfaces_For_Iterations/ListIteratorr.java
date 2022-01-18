package interfaces_For_Iterations;

import java.util.*;


//NOTE
/*
                           ListIteratorr
- Java'da bir interface'dir.
- ile bir List'i bastanSona sondanBasa gezebiliriz.
- sadece List ile kullanilabilir.-> (ArrayList , LinkedList , Stack)
- 'in nonemli methodlari add(), set(), hasNext(), next(), hasPrevious(), previous() and remove() 'dur
- Yani sadece *EKLEME* - OKUMA - SILME'ye yarar

======================================================================================
 YAPILAN ISLEMLER SADECE GEZILIRKEN YAPILIR. INDEX NUMARASI ILE YAPILMAZ

 */
public class ListIteratorr
{
    public static void main(String[] args)
    {
        listIterator01();
        listIterator02();
        listIterator03();

    }


    static void listIterator01()
    {
        System.out.println("================ listIterator01 ================");

        List<String> listObject = new ArrayList<String>();
        listObject.add("Java");
        listObject.add("Selenium");

        ListIterator it = listObject.listIterator();
        int indexNumber=0;



        System.out.println("Bastan Sona - forward direction: ");
        while (it.hasNext())
        {
            System.out.println(it.next());
        }

        System.out.println("--------------------------------------------");

        System.out.println("Sondan Basa - backward direction: ");
        while (it.hasPrevious())
        {
            System.out.println(it.previous());
        }
    }

    static void listIterator02()
    {
        System.out.println("================ listIterator02 ================");
        ArrayList<Integer> aList= new ArrayList<Integer>();
        aList.add(1);
        aList.add(2);
        aList.add(3);


        System.out.println("Elements of ArrayList: ");
        aList.stream().forEach(System.out::println);

        ListIterator<Integer> l= aList.listIterator();


        //By Default, varsayilan olarak, index 0'in gerisinden baslar
        l.next();//0. index'e git
        l.set(80000);//0. Index'i 1'den 80000'e degistir

        System.out.println("\nNow the ArrayList elements are: ");
        aList.stream().forEach(System.out::println);



    }

    static void listIterator03()
    {
        System.out.println("================ listIterator03 ================");

        // Creating an object of ArrayList class
        ArrayList al = new ArrayList();

        // Adding elements to the Arraylist object
        for (int i = 0; i < 10; i++)
            al.add(i);

        System.out.println(al);//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        ListIterator ltr = al.listIterator();



        while (ltr.hasNext())
        {
            int i = (Integer)ltr.next();//gezdigimiz elementi int'e atadik

            System.out.print(i + " ");//0 1 2 3 4 5 6 7 8 9

            // Changing even numbers to odd and
            // adding modified number again in
            // iterator
            if (i % 2 == 0)
            {
                //cift sayilara 1 ekleyip tek sayi yapiyoruz
                i++;
                ltr.set(i);

                //ciftken tek olan sayinin onune hemen tek sayiyi yine ekliyoruz
                ltr.add(i);

                //buradaki tek amac-> set(), add() methodlarini gormek :)
            }
        }

        // Print and display statements
        System.out.println();
        System.out.println(al);//[1, 1, 1, 3, 3, 3, 5, 5, 5, 7, 7, 7, 9, 9, 9]

        al.stream().forEach(System.out::print);//111333555777999

    }
}
