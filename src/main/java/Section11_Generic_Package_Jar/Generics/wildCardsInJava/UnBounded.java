package Section11_Generic_Package_Jar.Generics.wildCardsInJava;

import java.util.Arrays;
import java.util.List;

public class UnBounded {

    // WildCard'lar <T> deki T gibi isimlendirmelerin yerine ? isareti konularak yazilir
    // Bilinmeyen tip anlamina gelir
    // 3'e ayrilirlar : Unbounded, Upper Bounded ve Lower Bounded
    // UnBounded: Kalitim ile sinirlandirilmamis wildCard'lardir
    // Bounded: Kalitim ile sinirlandirilmis WildCard'lardir. UpperBounded ve LowerBounded olarak ikiye ayrilir
    // UpperBounded: Kalitim yapisini extend anahtar kelimesiyle kullanir. Listeden okuma yapilacagi zaman kullanilir
    // LowerBounded: Kalitim yapisini super anahtar kelimesiyle kullanir. Listeye ekleme yapilacagi zaman kullanilir

    // ? kullanilmasinin sebebi su
    // Kare ornegimize bakacak olursak; <T extend Number> seklinde bir wild card kullandik
    // Yani genis kapsamli class'imiz acik bir sekilde belli idi
    // Peki ben her iki type'i da generic yapmak istesem, yani daha sonra method/class/interface kullanilirken girilmesini istesem
    // Bu durumda da <? extend T> yapisi ortaya cikmis olacak

    // Unbounded Wildcard:
    // Kalitim ile sinirlandirilmamis wildcard anlamina gelir.
    // Tipini bilmedigimiz verileri okumak icin kullanilir
    // tipe bagli olmayan methodlari kullanirken ( mesela list yazdir diyoruz ama tum listleri yazdiriyor tip onemli degil derken)
    // ve object class'i tarfindan saglanan islevsellik kullanilirken faydali olur
    // asagida bunun bir ornegi var ama anlamadim ?????????
    // This wildcard type is specified using the wildcard character (?), for example, List.
    // This is called a list of unknown type.
    // These are useful in the following cases
    // When writing a method which can be employed using functionality provided in Object class.
    // When the code is using methods in the generic class that don’t depend on the type parameter

    public static void main(String[] args)
    {

        //Integer List
        List<Integer> list1= Arrays.asList(1,2,3);
        List<?> list11= Arrays.asList(1,2,3);

        //Double list
        List<Double> list2=Arrays.asList(1.1,2.2,3.3);

        printlist(list1);
        printList2(list1);

        printlist(list11);
        printList2(list11);

        printlist(list2);
        printList2(list2);
    }

    private static void printlist(List<?> list) // soru1: sadece tek bir type kullanilacak ise sagiadki gibi T koyamaz miydik?, farki ne
    {
        System.out.println(list);
    }

    private static <R> void printList2(List<R> list)
    {
        System.out.println(list);
    }

    public void printList(List<?> list)  // soru 2: bu ornek internettem.
    {
        for (Object object : list) {
            System.out.println(object);
        }
    } // Ben eger gelecek type'i bilmiyorsam ve bu type da wrapper veya String degilse yani ogrenci,sporcu,.. gibiyse
      // Object'ten olusturulmus bir obje ile bu class'i gezemem, burada Object ile sinirlandirilmis bir T olmasi gerekmez miydi
}
