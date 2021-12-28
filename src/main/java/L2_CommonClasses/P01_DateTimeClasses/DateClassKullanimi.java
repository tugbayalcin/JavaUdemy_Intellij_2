package L2_CommonClasses.P01_DateTimeClasses;

import java.util.Date;

public class DateClassKullanimi
{
    public static void main(String[] args)
    {
        // Bakiniz:  https://www.geeksforgeeks.org/date-class-java-examples/
        //           https://www.geeksforgeeks.org/util-date-class-methods-java-examples/
        //<editor-fold desc="DateClass">
   /*
      * Date sinifi milisabniye hassasiyetinde bir ani temsil eder
      * Java.util paketinde bulunan date classi Serializable, Cloneable and Comparable interfacelerini implement eder
      * Javada tarih ve saat bicimlendirme islemlerinde kullanislidir

      CONSTRUCTORS
      Date() : Geçerli tarih ve saati temsil eden tarih nesnesi oluşturur.
      Date(long milliseconds) : 1 Ocak 1970, 00:00:00 GMT'den bu yana verilen milisaniye için bir tarih nesnesi oluşturur.
      Date(int year, int month, int date)
      Date(int year, int month, int date, int hrs, int min)
      Date(int year, int month, int date, int hrs, int min, int sec)
      Date(String s)
      NOTE: Date classinin son 4 constructoru kullanimdan kaldirilmistir


      BAZI ONEMLI METHODLAR
      * boolean after(Date date): Geçerli tarihin verilen tarihten sonra olup olmadığını test eder.
      * boolean before(Date date) : Geçerli tarihin verilen tarihten önce olup olmadığını test eder.
      * int CompareTo(Date date) : Geçerli tarihi verilen tarihle karşılaştırır. Tarih bağımsız değişkeni Tarih'e eşitse 0 döndürür; Tarih, Tarih bağımsız değişkeninden önceyse 0'dan küçük bir değer; ve Tarih, Tarih bağımsız değişkeninden sonraysa 0'dan büyük bir değer.
      * long getTime() : Bu Date nesnesi tarafından temsil edilen 1 Ocak 1970, 00:00:00 GMT'den bu yana geçen milisaniye sayısını döndürür.
      * void setTime(long time) : Geçerli tarih ve saati verilen zamana değiştirir.


    */
        //</editor-fold>

        example1_Constructors();
        example2_Methods();

    }
    public static void example1_Constructors()
    {
        Date d1 = new Date();
        System.out.println("Current date is " + d1);
        Date d2 = new Date(2323223232L);
        System.out.println("Date represented is "+ d2 ); // temsil edilen tarih
        Date d3 = new Date(2021,10,24); // kullanimdan kalktigi icin uztu cizik
        System.out.println("Today is "+ d3 );
    }
    public static void example2_Methods()
    {
        // Creating date
        Date d1 = new Date(2000, 11, 21);
        Date d2 = new Date();  // Current date
        Date d3 = new Date(2010, 1, 3);

        boolean a = d3.after(d1);
        System.out.println("Date d3 comes after " +
                "date d2: " + a);

        boolean b = d3.before(d2);
        System.out.println("Date d3 comes before "+
                "date d2: " + b);

        int c = d1.compareTo(d2);
        System.out.println(c);

        System.out.println("Miliseconds from Jan 1 "+
                "1970 to date d1 is " + d1.getTime());

        System.out.println("Before setting "+d2);
        d2.setTime(204587433443L);
        System.out.println("After setting "+d2);

        /*
        CIKTI:
        d3 tarihi d2 tarihinden sonra gelir: true
        d3 tarihi d2 tarihinden önce gelir: yanlış
        1
        Ocak 1970'den d1 tarihine kadar 1 milisaniye 60935500800000'dir
        12 Temmuz Salı ayarlanmadan önce 13:13:16 UTC 2016
        25 Haziran Cuma ayarlandıktan sonra 21:50:33 UTC 1976
         */
    }
}

