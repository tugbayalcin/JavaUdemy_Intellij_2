package interfaces_For_Iterations;

/*

Enumaration Interface'i VECTOR , STACK,  HASHTABLE'lari gezmeye yarar.
Cok kullanilmaz
JDK 1.0'den beri vardir. Iterator, lIstIterator yokken bu vardi.
SADECE GEZME ISINE YARAR. SILME - EKLEME - SET ISLEMLERI YAPILAMAZ

elements() ile obje olusturulur.
Enumeration e = v.elements();


IKI ANA METHOD VARDIR:
    1. public boolean hasMoreElements(): This method tests if this enumeration contains more elements or not.
                                         Daha gezilecek elemanin var mi

    2. public Object nextElement(): This method returns the next element of this enumeration.
                                    It throws NoSuchElementException if no more element is present

 */


import java.util.Enumeration;
import java.util.Vector;

public class Enumaration
{
    public static void main(String[] args) {
        enumaration01();
    }


    static void enumaration01()
    {
        // Creating a vector object
        Vector v = new Vector();

        // Iterating over vector object
        for (int i = 0; i < 10; i++)
            v.addElement(i);

        // Printing elements in vector object
        System.out.println(v);

        //elements() methoduyla obje olusturulur.
        Enumeration e = v.elements();


        while (e.hasMoreElements())
        {
            // Moving cursor to next element
            int i = (Integer)e.nextElement();

            // Print above elements in object
            System.out.print(i + " ");
        }
    }
}
