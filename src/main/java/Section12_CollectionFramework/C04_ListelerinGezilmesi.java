package Section12_CollectionFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class C04_ListelerinGezilmesi
{
    public static void main(String[] args) {

        // ArrayList = Bellekte tutulan ve dynamic olarak buyuyup kuculebilen bir dizi
        //             Elemanlari index tabanli saklanir
        ArrayList<Integer> sayilar1 = new ArrayList<>();
        sayilar1.add(1);
        sayilar1.add(2);
        sayilar1.add(3);
        sayilar1.add(4);

        ArrayList<Integer> sayilar2 = new ArrayList<>();
        sayilar2.add(3);
        sayilar2.add(4);
        sayilar2.add(5);
        sayilar2.add(6);

        System.out.println(sayilar1); // ArratList icindeki toString sayesinde dizimi dogrudan yazdirabiliyorum
        // Eger ben ArrayList icine kendi objemi koyar isem (Ogrenci Classi, Kisi Classi gibi),
        // o nesnenin icinde to String methodunu override etmeliyim ki buradaki gibi dogrudan sout ile yazdirabileyim

        // index tabanli oldugu icin for dongusu ile teker teker elemanlarini gezebiliriz
        // 1 -----------------------------------------------------------------------------------------------------------
        System.out.println("For Dongusuyle Gezmek");
        for(int i=0; i<sayilar1.size(); i++)
        {
            System.out.println(sayilar1.get(i));
        }
        // 2 -----------------------------------------------------------------------------------------------------------
        System.out.println("Gelismis For (foreach) Dongusuyle Gezmek");
        for (int temp:sayilar1) // sol tarafa ArrayList imin tipinde gecici bir eleman yaziyorum, sag tarafa gezilecek diziyi
        {
            // ArrayList icine wrapper class, foreach icine primitive type yazdik, sikinti olmaz java otomatik olarak donusturur
            System.out.println(temp);
        }
        //--------------------------------------------------------------------------------------------------------------
        // sayilar1'i gez ve sayilar2 ile ayni olan elemanlari sayilar1'den cikar
        System.out.println("sayilar1 ve sayilar2'de ortak olan elemanlar sayiar1'den cikarilsin");
        for (int i=0; i<sayilar1.size(); i++)
        {
            if(sayilar2.contains(sayilar1.get(i))) // sayilar2 dizisi o anki sayilar 1 elemanini iceriyor mu
            {
               // sayilar1.remove(i); --> yorum satirina aldim ki eleman silmesin asagidaki iteratorum calissin
            }
        }
        System.out.println("Cikarilma isleminden sonra sayilar1: " + sayilar1);
        // hatali calisti.
        // Mumkun oldugunca Listlerde iterator kullanarak elemanlari gezmeliyiz ki dogru sonuc elde edebilelim
        // Simdi burada olusan sikintiya yakindan bakalim:
        // ArrayList dynamic bir dizi oldugu icin ilk eleman cikarma isleminden sonra tum elemanlar kaydirilacak ve
        // her elemanin indisi degisecektir. Bu durum her eleman cikarildiginda gerceklesecek ve kayan ilk eleman
        // her seferinde kontrol yapisindan kacmis olacaktir, dolayisi ile yanlis sonuc elde etmis olacagiz
        // simdi iterator ile nasil yapabilecegimize bakalim:

        // ITERATOR ----------------------------------------------------------------------------------------------------

        System.out.println("Iterator ile Listenin Gezilmesi");
        Iterator<Integer> iterator = sayilar1.iterator(); // iterator demek listenin een basina bir ok koy ve her elemani gezdir demek
        while(iterator.hasNext()) // hasNext demek su demek: dizimin basindaki ok isaretinin saginda eleman var mi, yani listenin sonuna geldim mi gelmedim mi
        {
           // System.out.println(iterator.next()); // her dondugunde ıteratorun sagindaki elemani yazdirir
            if(sayilar2.contains(iterator.next()))
            {
                iterator.remove();
            }
        }
        System.out.println(sayilar1);

        // LIST ITERATOR -----------------------------------------------------------------------------------------------

        // ListIterator da bir interfacedir, ancak Iterator interface'inden turatilmistir
        System.out.println("List iterator ile Listenin Gezilmesi");
        ListIterator<Integer> listIterator = sayilar2.listIterator();
        while(listIterator.hasNext())
        {
            System.out.println(sayilar2.listIterator().next());
        }
        // List iterator ile diziyi tersten de gezebilirim, elemanlarin indexlerini ogrenebilirim gibi gibi cok yararli methodlar vardir

        // LIST ITERATIR TERSTEN ---------------------------------------------------------------------------------------

        System.out.println("List iterator ile Listenin Sondan Basa Gezilmesi");
        ListIterator<Integer> listIteratorSondanBasa = sayilar2.listIterator(sayilar2.size());// son elemanin indexi
        while(listIteratorSondanBasa.hasPrevious())
        {
            System.out.println("Index:" + listIteratorSondanBasa.previousIndex() + "eleman:  " + listIteratorSondanBasa.previous());
            // listIterator kullanirsam elemanlarimi yazdirmaz cunku ok isaretini eeen sola eeen basa koydu, parametre icine index olarak
            // baslamasini istedigim elemanin indeksini (bu soruda son index) yazarsam kodum guzelce, sorunsuzca calisir
        }
    }
}
