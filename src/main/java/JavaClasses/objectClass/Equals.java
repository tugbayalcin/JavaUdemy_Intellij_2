package JavaClasses.objectClass;

import java.util.List;

public class Equals
{
    public static void main(String[] args) {
        // tek parametre alan bir methoddur
        // == ile karsilastirma yapar
        // yani karsilastirilacak objeleri reference degerlerine gore karsilastirir
        // simetriktir: x.equals(y) = y.equals(x)
        // gecislidir: x.equals(y) ve z.equals(y) => x.equals(z)


        Integer[] i = {2,3,5};
        Integer[] j = {2,3,5};
        Integer[] k = i;
        Integer[] l = i;

        System.out.println(i.equals(j)); // false: icerikleri ayni olmasina ragmen reference'leri farkli
        System.out.println(j.equals(i)); // gecisli

        System.out.println(i.equals(k)); // gecisli
        System.out.println(k.equals(i)); // gecisli

        System.out.println(i.equals(l)); // i l ile equal
        System.out.println(i.equals(k)); // i k ile equal
        System.out.println(l.equals(k)); // o zaman l ile k da equal
        System.out.println(k.equals(l)); // gecisli



    }
}
