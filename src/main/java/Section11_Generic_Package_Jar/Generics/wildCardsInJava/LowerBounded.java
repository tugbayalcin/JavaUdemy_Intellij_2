package Section11_Generic_Package_Jar.Generics.wildCardsInJava;

import java.util.Arrays;
import java.util.List;

public class LowerBounded {

    // WildCard'lar <T> deki T gibi isimlendirmelerin yerine ? isareti konularak yazilir
    // Bilinmeyen tip anlamina gelir
    // 3'e ayrilirlar : Unbounded, Upper Bounded ve Lower Bounded
    // UnBounded: Kalitim ile sinirlandirilmamis wildCard'lardir SINIRSIZ
    // Bounded: Kalitim ile sinirlandirilmis WildCard'lardir. UpperBounded ve LowerBounded olarak ikiye ayrilir
    // UpperBounded: Kalitim yapisini extend anahtar kelimesiyle kullanir. Listeden okuma yapilacagi zaman kullanilir UST SINIR
    // LowerBounded: Kalitim yapisini super anahtar kelimesiyle kullanir. Listeye ekleme yapilacagi zaman kullanilir ALT SINIR

    // hem alt sinir hem de ust sinir ayni anda kullanilamaz

    // Lower Bounded Wildcards: --> ALTSINIR
    // It is expressed using the wildcard character (‘?’), followed by the super keyword, followed by its lower bound: <? super A>.
    // Syntax: Collectiontype <? super A>

    // Here arguments can be Integer or superclass of Integer(which is Number).
    // The method printOnlyIntegerClassorSuperClass will only take Integer or its superclass objects.
    // However if we pass list of type Double then we will get compilation error.
    // It is because only the Integer field or its superclass can be passed .
    // Double is not the superclass of Integer.

    public static void main(String[] args)
    {
        //Lower Bounded Integer List
        List<Integer> list1= Arrays.asList(4,5,6,7);

        //Integer list object is being passed
        printOnlyIntegerClassorSuperClass(list1);

        //Number list
        List<Number> list2= Arrays.asList(4,5,6,7);

        //Integer list object is being passed
        printOnlyIntegerClassorSuperClass(list2);
    }

    public static void printOnlyIntegerClassorSuperClass(List<? super Integer> list)
    {
        // en az integer olacak sekilde integer ve ust siniflarini parametre olarak gecebilirsin diyor
        // ancak burada double gectigimizde hata aliyoruz
        // cunku double her ne kadar kapsam anlaminda integer'i iceriyor olsa da,
        // Integer'in bir ust sinifi degildir
        System.out.println(list);
    }
}
