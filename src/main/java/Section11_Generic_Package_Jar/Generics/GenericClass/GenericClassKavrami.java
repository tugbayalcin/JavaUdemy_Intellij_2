package Section11_Generic_Package_Jar.Generics.GenericClass;

import java.util.ArrayList;

public class GenericClassKavrami
{
    public static void main(String[] args)
    {
        // ayni isi yapip farkli turdeki parametreleri alan sinif veya methodlarda kullanilir
        String[] isimler = {"tugba","asel","yalcin"};
        int[] sayilar = {1,5,7};
        char[] karakterler = {'a','b','c'};

        StringDiziYazdir.yazdir(isimler);
        IntegerDiziYazdir.yazdir(sayilar);
        CharacterDiziYazdir.yazdir(karakterler);

        // elmas isaretinin icini biz dolduruyoruz, hangi veri turu ile calismak istiyorsak onu yaziyoruz
        GenericDiziYazdir<String>stringGenericDiziYazdir = new GenericDiziYazdir<String>();
        StringDiziYazdir.yazdir(isimler);

        GenericDiziYazdir<Integer>integerGenericDiziYazdir = new GenericDiziYazdir<Integer>();
        IntegerDiziYazdir.yazdir(sayilar);

        GenericDiziYazdir<Character>characterGenericDiziYazdir = new GenericDiziYazdir<Character>();
        CharacterDiziYazdir.yazdir(karakterler);
        // new den sonraki elmasa wrapper tipi yazmaz isen, dizilerini primitive tipte degil wrapper tipte tanimlamak zorunda kalirsin
        // peki oraya bir sey yazmak zorunda miyiz, hayir

        // Boylece tek bir class olusturarak tum veri tiplerim icin ayni isi yaptırabilmis oldum


           // Generic Type bize guvenli kod yazma ortami sunar. Bunu nasil yaptigina bakalim:
           // Sehirleri tutan bir arrayim olsun istiyorum, asagidaki gibi tanimliyor ve yazdiriyorum
        ArrayList listem = new ArrayList(); // ArrayList<String> listem = new ArrayList(); daha guvenli ve
        listem.add("Ankara");
        listem.add("Istanbul");
        listem.add("Izmir");
        // asagidaki dizi yazdir kodunu bir calistiralim.Dizimin ne icerdigini bilmedigim icin ata class olan
        // Object class ile foreach dongumu olusturuyorum. Hicbir sorun yok gibi gorunuyor.
        // simdi de dizime string olmayan ifadeler eklemeyi deneyecegim
        listem.add(1); // buralari kirmizi yakar
        listem.add(true); // buralari kirmizi yakar
        listem.add(5.4); // buralari kirmizi yakar
        // yeniden yazdiralim. hala bir sikinti yok. Cunku zaten bu ifadeler de Object class elemanlari.
        // su an farkli turler barindiran bir dizim var
        // peki ben listem uzerinde bazi kontroller veya methodlar gerceklestirmek istesem nasil olacak
        // iste isler burada karismaya basliyor
        // mesela length methodunu dusunelim, ben elemanlarimin kac karakterden olustugunu merak ediyorum
        // ancak bu methodu kullanmak istedigimde ıonce bir casting sorunu ile karsilasacagim
        // bunu cozmek basit olsa da programi calistirdigimda compiler integer degerle karsilastiginda hata verecek
        // yani programim istedigim gibi calismayacak
        // peki generik type kullandigimda ne olacak
        // generik type elmaslari icerisine dizimin string olacagini soyledigim anda dizimdeki string disindaki
        // ifadeler hemen kirmizi yanacaklar
        for (Object gecici:listem)
        {
            System.out.println(gecici); // System.out.println(((String) gecici).length()); length methodu kullanilirken cast edilmis hali
        }


    }
}
