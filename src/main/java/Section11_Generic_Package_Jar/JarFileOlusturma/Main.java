package Section11_Generic_Package_Jar.JarFileOlusturma;

import java.util.Arrays;
import java.util.Collections;

public class Main
{
    public static void main(String[] args)
    {

        RasyonelSayi rs1 = new RasyonelSayi(3,4);
        System.out.println(rs1);

        RasyonelSayi rs2 = new RasyonelSayi(4,5);
        System.out.println(rs2);

        RasyonelSayi rs3 = new RasyonelSayi(3,-1);
        System.out.println(rs3);

        RasyonelSayi rs4 = new RasyonelSayi(-2,4);
        System.out.println(rs4);

        RasyonelSayi rs5 = new RasyonelSayi(-4,-7);
        System.out.println(rs5);

        System.out.println("****Dort Islem****");

        RasyonelSayi toplam = rs1.toplama(rs2);
        System.out.println(toplam);

        RasyonelSayi fark = rs1.cikarma(rs2);
        System.out.println(fark);

        RasyonelSayi carpim = rs1.carpma(rs2);
        System.out.println(carpim);

        RasyonelSayi bolum = rs1.bolme(rs2);
        System.out.println(bolum);

        RasyonelSayi[] sayilar = {rs1,rs2,rs3,rs4,rs5}; // rasyonel sayilar tutan bir dizi tanimladim
        // sayilarimi siralamak istiyorum ancak comparable interfaceini import etmem lazim, edip compareTo methodunu duzenliyorum
        Arrays.sort(sayilar);

        // sayilari tersten siralamak istiyorsam
        Arrays.sort(sayilar, Collections.reverseOrder());

        for (RasyonelSayi temp:sayilar)
        {
            System.out.print(temp + ", ");
        }
        System.out.println();
        System.out.println(rs1.equals(rs2));

    }
}
