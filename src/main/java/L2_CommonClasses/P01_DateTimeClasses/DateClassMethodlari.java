package L2_CommonClasses.P01_DateTimeClasses;

import java.util.Date;

public class DateClassMethodlari
{
    public static void main(String[] args)
    {
        // 1.toString():
        // Java.util.Date.tostring() methodu gecerli tarih ve saati goruntuler
        // Burada Date nesnesi bir stringe donusturulur ve su sekilde temsil edilir: gün ay gg ss:dd:ss zz yyyy
        /*
        gün : haftanın günü
        ay : ay
        gg : ayın günü
        ss : saat
        aa : dakika
        ss : saniye
        zz : saat dilimi
        yyyy : yıl 4 ondalık basamağa kadar
         */
        Date d0 = new Date();
        System.out.println(d0.toString());

        // 2.setTime() :
        // Date nesnesini 1 Ocak 1970 00:00:00 GMT'den sonraki zaman milisaniyesi olan bir zaman noktasını temsil edecek şekilde ayarlar.
        // Geriye milisaniye dondurur

        // 3.hashCode():
        // Date nesnesi icin bir karma kod degeri dondurur

        Date mydate = new Date();

        // Displaying the current date and time
        System.out.println("System date : "+ mydate.toString() ); // Sistem tarihi : 01 Kasım Salı 02:37:18 IST 2016

        // Is used to set time by milliseconds. Adds 15680
        // milliseconds to January 1, 1970 to get new time.
        mydate.setTime(15680);

        System.out.println("Time after setting:  " + mydate.toString());// Ayarlamadan sonraki süre: Per Ocak 01 05:30:15 IST 1970

        int d = mydate.hashCode();
        System.out.println("Amount (in ms) by which time" +
                " is shifted :  " + d); // Zamanın kaydırıldığı miktar (milisaniye olarak) : 15680


        // 4.after():
        // Gecerli tarihin belirtilen tarihten sonra olup olmadigini kontrol eder

        // 5.clone():
        // Gecilen Date nesnesinin kopyasini dondurur

        // 6.before():
        // Gecerli tarihin belirtilen tarihten once olup olmadigini kontrol eder

        // create 2 dates
        Date date1 = new Date(2016, 11, 18);
        Date date2 = new Date(1997, 10, 27);

        // Use of after() to check date2 is after date1
        boolean a = date2.after(date1);
        System.out.println("Is date2 is after date1 : " + a); // tarih2, tarih1'den sonra mı: yanlış

        // Use of after() to check date2 is after date1
        a = date1.after(date2);
        System.out.println("Is date1 is after date2 : " + a); // tarih1 tarih2'den sonra mı: doğru
        System.out.println("");

        // Use of clone() method
        Object date3 = date1.clone();
        System.out.println("Cloned date3 :" + date3.toString()); // Klonlama tarihi3 : 18 Aralık Pzt 00:00:00 IST 3916
        System.out.println("");

        // Use of before() to check date2 is after date1
        boolean b = date2.before(date1);
        System.out.println("Is date2 is before date1 : " + a); // tarih2, tarih1'den önce mi: doğru


        // 7.compareTo():
        // Iki tarihi karsilastirir ve karsilastirmaya gore -1,0,1 dondurur
        /*
            0 : tartışılan tarih = verilen tarih ise.
           -1 : tartışılan tarih > verilen tarih ise.
            1: tartışılan tarih < verilen tarih ise.
         */


        // 8.equals():
        // Iki tarihin milisaniye farkina gore esit olup olmadigini kontrol eder

        // 9.getTime():
        // 1 Ocak 1970, 00:00:00 GMT'ye atifta bulunarak, tartisilşan tarihin milisaniye sayisiyla sonuclanir.

        Date d1 = new Date(97, 10, 27);
        Date d2 = new Date(97, 6, 12);

        // Use of compareto() method
        int comparison = d1.compareTo(d2);    // d1 > d2 : 1
        int comparison2 = d2.compareTo(d1);   // d2 > d1 :-1
        int comparison3 = d1.compareTo(d1);   // d1 = d1 : 0

        System.out.println("d1 > d2 : " + comparison);
        System.out.println("d1 < d2 : " + comparison2);
        System.out.println("d1 = d1 : " + comparison3);
        System.out.println("");

        // Use of equal() method
        boolean r1 = d1.equals(d2);
        System.out.println("Result of equal() r1 : " + r1); // equal() r1'in sonucu: false

        boolean r2 = d1.equals(d1);
        System.out.println("Result of equal() r2 : " + r2); // equal() r2'nin sonucu: true
        System.out.println("");


        // Use of getTime() method
        long count1 = d1.getTime();
        long count2 = d1.getTime();
        System.out.println("Milliseconds of d1 : " + count1); // d1'in milisaniyesi: 880569000000
        System.out.println("Milliseconds of d2 : " + count2); // Milisaniye d2 : 880569000000
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
