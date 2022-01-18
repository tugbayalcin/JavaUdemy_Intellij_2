package requiredClasses.P01_DateTimeClasses;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class LocaqlDateTimeKullanimi
{
    // Bakiniz: https://www.javatpoint.com/java-localdatetime
    // Java LocalDateTime classi, default bicimi yyyy-AA-gg-SS-aa-ss.zzz olan bir tarih-saati temsil eden degismez bir
    // tarih-saat nesnesidir.
    // Object classindan extend alir ve ChronoLocalDateTime interfacini uygular.

    public static void main(String[] args)
    {
        example1();
        example2();
        example3();
        example4();
        example5();

    }
    public static void example1()
    {
        // format()
        // Belirtilen bicimlendiriciyi kullanarak bu tarih-saati bicimlendirmek icin kullanilir.
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Before Formatting: " + now);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);
        System.out.println("After Formatting: " + formatDateTime);
    }
    public static void example2()
    {
        // now()
        // varsayilan sistem saatindeki gecerli tarih ve saati almak icin kullanilir
        LocalDateTime datetime1 = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = datetime1.format(format);
        System.out.println(formatDateTime);
    }
    public static void example3()
    {
        // get()
        // Belirtilen alanin degerini bu tarih-saatten int olarak almak icin kullanilir.
        LocalDateTime a = LocalDateTime.of(2017, 2, 13, 15, 56);
        System.out.println(a.get(ChronoField.DAY_OF_WEEK));
        System.out.println(a.get(ChronoField.DAY_OF_YEAR));
        System.out.println(a.get(ChronoField.DAY_OF_MONTH));
        System.out.println(a.get(ChronoField.HOUR_OF_DAY));
        System.out.println(a.get(ChronoField.MINUTE_OF_DAY));
    }
    public static void example4()
    {
        // minusDays()
        // belirtilen gun sayisi cikartilarak kopyasi dondurulur
        LocalDateTime datetime1 = LocalDateTime.of(2017, 1, 14, 10, 34);
        LocalDateTime datetime2 = datetime1.minusDays(100);
        System.out.println("Before Formatting: " + datetime2);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatDateTime = datetime2.format(format);
        System.out.println("After Formatting: " + formatDateTime );
    }
    public static void example5()
    {
        // plusDays()
        // belirtilen gun sayisi eklenerek kopyasi dondurulur
        LocalDateTime datetime1 = LocalDateTime.of(2017, 1, 14, 10, 34);
        LocalDateTime datetime2 = datetime1.minusDays(100);
        System.out.println("Before Formatting: " + datetime2);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatDateTime = datetime2.format(format);
        System.out.println("After Formatting: " + formatDateTime );
    }
}
