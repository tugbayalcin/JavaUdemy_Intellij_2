package Section12_CollectionFramework.Lists.arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListToArraySolutions
{
    public static void main(String[] args)
    {
        //Exception Handling Way1 -> Try-Catch Blocks
        try
        {
            // deneme0();
            // deneme1();
            deneme2();
            // deneme3();
            // deneme4();

        }
        catch (ClassCastException e){
            System.out.println(e);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }


    static void deneme0()//en ilkel hali - algorithm 'i kendimiz yazariz
    {
        List<Integer> al = new ArrayList<Integer>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);

        Integer[] arr = new Integer[al.size()];

        // ArrayList to Array Conversion
        for (int i = 0; i < al.size(); i++)
            arr[i] = al.get(i);

        for (Integer x : arr)
            System.out.print(x + " ");

    }

    static void deneme1()//List<Integer> -> Object[] - calisir
    {
        List<Integer> al = new ArrayList<Integer>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);

        Object[] objects = al.toArray();//toArray() return type'i Object[]'tir

        // Printing array of objects
        for (Object obj : objects)
            System.out.print(obj + " ");

    }

    static void deneme2()////List<Integer> -> Integer[]  ClassCastException Aliriz
    {
        List<Integer> al = new ArrayList<Integer>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);

        // Error: incompatible types: Object[]
        // cannot be converted to Integer[]

        Integer[] objects = (Integer[]) al.toArray();


        for (Integer obj : objects)
            System.out.println(obj);
    }

    static void deneme3()//Alternatif solution
    {
        List<Integer> al = new ArrayList<Integer>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);

        Integer[] arr = new Integer[al.size()];
        arr = al.toArray(arr);

        for (Integer x : arr)
            System.out.print(x + " ");
    }

    static void deneme4()//En pratik En kisa Hali - Functional Programlama ile
    {
        List<Integer> al = new ArrayList<Integer>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);

        // ArrayList to Array Conversion
        int[] arr = al.stream().mapToInt(i -> i).toArray();

        for (int x : arr)
            System.out.print(x + " ");
    }

}
