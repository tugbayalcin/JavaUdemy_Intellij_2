package Section11_Generic_Package_Jar.Generics.GenericClass;

import java.util.ArrayList;
import java.util.List;

public class Workbook
{
    // Genericlerin Interface ile kullanimi
    public interface Comparable<T> {
        public int compareTo(T object);
    }
    // Genericlerin Class ile kullanimi
    public class Printer<T> {
        public void print(T object) {
            System.out.println(object);
        }
    }
    // Genericlerin Method ile kullanimi -1
    public <T> T myGenericMethod(){
        T object = null;
        //***
        return object;
    }
    // Genericlerin Method ile kullanimi -2
    public <T> T myGenericMethodWithParameter(T object){
        return object;
    }
    // Genericlerin Method ile kullanimi -3
    public <T> void myGenericVoidMethod(T object){
        System.out.println(object);
    }



    public static void main(String[] args)
    {
        exampleForExeption();
        typeSafety();

    }
    public static void exampleForExeption()
    {
            // asagidaki kodda calisma esnasinda ClassCastExeption hatasini aliriz
            List list = new ArrayList();
            list.add("Merhaba Dünya");
            list.add(123);
            for (int i = 0; i < list.size(); i++) {
                String string = (String) list.get(i);
            }

            // simdi bu kodu generic kullanarak yeniden yazalim
            List<String> list2 = new ArrayList<String>();
            list2.add("Merhaba Dünya");
            // list2.add(123);   --> bu satır hata vermeye devam etmesin diye yorum satiri yaptim, normalde acik olmali
            for (int i = 0; i < list2.size(); i++) {
                String string = list2.get(i);
            }
            // burada ise derleme yani compile time esnasinda --> list2.add(123); <-- satirinda 123 elemaninin alti kirmizi yanar
            // yani derleme esnasinda hata aliriz
            // java bize der ki senin listen yalnizca string alabiliyorken sen buraya integer deger girdin
            // ya burayi string yap ya da listenin veri tipini integer olarak degistir
        }

    public static void typeSafety()
    {
        class Lives{}
        class Person extends Lives{}
        class Animal extends Lives{}

        // Generic kullanmadan
        class PersonRepository // zaten temelde canli olan Person tipindeki veriyi tutan class
        {
            public void savePerson(Person person) // person verisini saklamak icin yazilan method
            {
                System.out.println();
            }
        }
        class AnimalRepository // zaten temelde canli olan Animal tipindeki veriyi tutan class
        {
            public void saveAnimal(Animal animal)
            {
                System.out.println(); // animal verisini saklamak icin yazilan method
            }
        }

        // Generic kullanarak
        class GenericRepository <Lives> // canli olan tum veri tiplerini tutan super class
        {
            public void save(Lives object) // canlidan kalitim alan yani temelde canli olan tum verileri saklamak icin yazilan method
            {
                System.out.println();
                // burada generic bir tanimlama yaparak onceki iki method ile ayni isi yapan tek bir method yazarak kod fazlaligindan
                // kurtulmus olduk
            }
        }
    }




}
