package Section11_Generic_Package_Jar.Generics.wildCardsInJava;

import java.util.Arrays;
import java.util.List;

public class UpperBounded {

    // WildCard'lar <T> deki T gibi isimlendirmelerin yerine ? isareti konularak yazilir
    // Bilinmeyen tip anlamina gelir
    // 3'e ayrilirlar : Unbounded, Upper Bounded ve Lower Bounded
    // UnBounded: Kalitim ile sinirlandirilmamis wildCard'lardir
    // Bounded: Kalitim ile sinirlandirilmis WildCard'lardir. UpperBounded ve LowerBounded olarak ikiye ayrilir
    // UpperBounded: Kalitim yapisini extend anahtar kelimesiyle kullanir. Listeden okuma yapilacagi zaman kullanilir
    // LowerBounded: Kalitim yapisini super anahtar kelimesiyle kullanir. Listeye ekleme yapilacagi zaman kullanilir

    // The question mark (?) is known as the wildcard in generic programming.
    // It represents an unknown type.
    // The wildcard can be used in a variety of situations such as the type of a parameter, field, or local variable; sometimes as a return type.
    // Unlike arrays, different instantiations of a generic type are not compatible with each other, not even explicitly.
    // This incompatibility may be softened by the wildcard if ? is used as an actual type parameter.

    // T ypes of wildcards in Java:
    // Upper Bounded Wildcards: --> USTSINIR
    // These wildcards can be used when you want to relax the restrictions on a variable.
    // For example, say you want to write a method that works on List < integer >, List < double >, and List < number > , you can do this  using an upper bounded wildcard.
    // To declare an upper-bounded wildcard, use the wildcard character (‘?’), followed by the extends keyword, followed by its upper bound.
    public static void main(String[] args)
    {

        //Upper Bounded Integer List
        List<Integer> list1= Arrays.asList(4,5,6,7);

        //printing the sum of elements in list
        System.out.println("Total sum is:"+sum(list1));
        System.out.println("Total sum is:"+sum2(list1));

        //Double list
        List<Double> list2=Arrays.asList(4.1,5.1,6.1);

        //printing the sum of elements in list
        System.out.println("Total sum is:"+sum(list2));
        System.out.println("Total sum is:"+sum2(list2));

        //Total sum is:22.0
        //Total sum is:22.0
        //Total sum is:15.299999999999999
        //Total sum is:15.299999999999999
    }

    private static double sum(List<? extends Number> list) // burayane gelecegini bilmiyorum ama gelecek sey mutlaka number olsun diyor, kisitliyor
    {
        double sum=0.0;
        for (Number i: list)
        {
            sum+=i.doubleValue();
        }

        return sum;
    }

    // yukaridaki gibi parametre icerisinde generic kullanabiliyorsam, return type'dan once <> yazmaya ne gerek var?
    // acaba su yuzden mi, ben gelen type'i belki parametre olarak kullanmayavcagim ama method icerisinde kullanacagim
    private static <R extends Number> double sum2(List<R> list)
    {
        double sum=0.0;
        for (Number i: list)
        {
            sum+=i.doubleValue();
        }

        return sum;
    }


}
