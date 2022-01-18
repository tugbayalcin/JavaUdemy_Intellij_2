package requiredClasses.P01_DateTimeClasses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateKullanimi
{
    // Bakiniz: https://www.javatpoint.com/java-localdate
    // Bu sinif Date'i default olarak yyyy-aa-gg biciminde temsil eden degşismez bir siniftir
    // Object classindan kalitim alir, ChronoLocalDate interfaceini implement eder
    public static void main(String[] args)
    {
        LocalDateExample1();
        LocalDateExample2();
        LocalDateExample3();
        LocalDateExample4();
        LocalDateExample5();

    }
    public static void LocalDateExample1()
    {
        LocalDate date = LocalDate.now(); // varsayilan saat dilimindeki sistem saatinde gecerli olan tarihi alir
        LocalDate yesterday = date.minusDays(1); // belirtilen gun sayisi cikarilir ve kopyasi dondurulur
        LocalDate tomorrow = yesterday.plusDays(2); // belirtilen gun sayisi eklenir ve kopyasi dondurulur
        System.out.println("Today date: "+date);
        System.out.println("Yesterday date: "+yesterday);
        System.out.println("Tomorrow date: "+tomorrow);
    }
    public static void LocalDateExample2()
    {
        // isLeapYear methosu girilen yilin artik yişl olup olmadigina bakar
        // true ya da false dondurur
        LocalDate date1 = LocalDate.of(2017, 1, 13);
        System.out.println(date1.isLeapYear());
        LocalDate date2 = LocalDate.of(2016, 9, 23);
        System.out.println(date2.isLeapYear());
    }
    public static void LocalDateExample3()
    {
        // atTime() methodu LocalDateTime olusturmak icin bu tarihi bir saatle birlestirmek icin kullanilir.
        LocalDate date = LocalDate.of(2017, 1, 13);
        LocalDateTime datetime = date.atTime(1,50,9);
        System.out.println(datetime);
    }
    public static void LocalDateExample4()
    {
        // Local Date'i Stringe Donusturme
        // Example 1
        LocalDate d1 = LocalDate.now();
        String d1Str = d1.format(DateTimeFormatter.ISO_DATE);
        System.out.println("Date1 in string :  " + d1Str);
        // Example 2
        LocalDate d2 = LocalDate.of(2002, 05, 01);
        String d2Str = d2.format(DateTimeFormatter.ISO_DATE);
        System.out.println("Date2 in string :  " + d2Str);
        // Example 3
        LocalDate d3 = LocalDate.of(2016, 11, 01);
        String d3Str = d3.format(DateTimeFormatter.ISO_DATE);
        System.out.println("Date3 in string :  " + d3Str);
    }
    public static void LocalDateExample5()
    {
        // Example 1
        String dInStr = "2011-09-01";
        LocalDate d1 = LocalDate.parse(dInStr);
        System.out.println("String to LocalDate : " + d1);
        // Example 2
        String dInStr2 = "2015-11-20";
        LocalDate d2 = LocalDate.parse(dInStr2);
        System.out.println("String to LocalDate : " + d2);
    }

}
