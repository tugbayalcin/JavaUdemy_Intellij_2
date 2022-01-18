package interfaces_For_Iterations;

//NOTE
/*

                           Iteratorr
- Java'da bir interface'dir
- ile bir List'i bastan sona gezebiliriz(Gezmek-taramak=Traversing)
- Set, List, Queue, DeQue, and also implemented classes of Mapp interface. ile calisabilir
- onemli methıdlari: hasNext(), next() ve remove() dur
- Yani, sadece OKUMA - SILME'ye yarar.

======================================================================================
 YAPILAN ISLEMLER SADECE GEZILIRKEN YAPILIR. INDEX NUMARASI ILE YAPILMAZ

 */


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteratorr
{
    public static void main(String[] args)
    {
        iterator01();
        map03();

    }



    static void iterator01()
    {

        // Creating an ArrayList class object
        // Declaring object of integer type
        List<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 3));

        //Adding new elements into List<Integer>
        Stream.of(4,5,6,7,8,9).collect(Collectors.toCollection(() -> al));

        // Printing the elements in the List
        System.out.println(al);



        // At the beginning itr(cursor) will point to index just before the first element in al
        // imlec ilk index'in hemen onunde baslar.
        Iterator itr = al.iterator();

        System.out.println("Bastan Sona - forward direction: ");

        //al arrayList'ini itr objesi temsil eder.
        //hashNext() ile imlecin onunde eleman var mi ona bakilir
        while (itr.hasNext())
        {
            //  Moving cursor to next element
            int i = (Integer)itr.next();

            // Getting even elements one by one
            System.out.print(i + " ");

            // Removing odd elements
            if (i % 2 != 0)
                itr.remove();
        }

        // Command for next line
        System.out.println();

        // Printing the elements inside the object
        System.out.println(al);

    }

    static void map03()
    {

         Map<String, String> map;
            map = new HashMap<String, String>();
            map.put("1", "bir");
            map.put("2", "iki");
            map.put("3", "uc");

        // using iterators
        Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();

        while(itr.hasNext())
        {
            Map.Entry<String, String> entry = itr.next();
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }
    }


}


