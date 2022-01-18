package requiredClasses.P01_DateTimeClasses;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class LocalTimeKullanimi
{
    // Bakiniz: https://www.javatpoint.com/java-localtime
    // Java LocalTime sınıfı, default saat-dakika-saniye bicimiyle zamanı temsil eden degismez bir siniftir.
    // Object classindan kalitim alir ve Comparable interfacini uygular.

    public static void main(String[] args)
    {
        localTimeExample1();
        localTimeExample2();
        localTimeExample3();
        localTimeExample4();
        localTimeExample5();
    }
    public static void localTimeExample1()
    {
        LocalTime time = LocalTime.now(); // Saat dilimindeki sistem satainden gecerli saati alir
        System.out.println(time);
    }
    public static void localTimeExample2()
    {
        LocalTime time = LocalTime.of(10,43,12); // saat dakika ve saniye cinsinden alir
        System.out.println(time);
    }
    public static void localTimeExample3()
    {
        LocalTime time1 = LocalTime.of(10,43,12);
        System.out.println(time1);
        LocalTime time2=time1.minusHours(2); // belirtilen saat sayisini cikartarak kopyasini dondurur
        LocalTime time3=time2.minusMinutes(34); // belirtilen dakika sayisini cikartarak kopyasini dondurur
        System.out.println(time3);
    }
    public static void localTimeExample4()
    {
        LocalTime time1 = LocalTime.of(10,43,12);
        System.out.println(time1);
        LocalTime time2=time1.plusHours(4); // belirtilen saat sayisini ekleyerek kopyasini dondurur
        LocalTime time3=time2.plusMinutes(18); // belirtilen dakika sayisini ekleyerek kopyasini dondurur
        System.out.println(time3);
    }
    public static void localTimeExample5()
    {
        ZoneId zone1 = ZoneId.of("Asia/Kolkata");
        ZoneId zone2 = ZoneId.of("Asia/Tokyo");
        LocalTime time1 = LocalTime.now(zone1);
        System.out.println("India Time Zone: "+time1);
        LocalTime time2 = LocalTime.now(zone2);
        System.out.println("Japan Time Zone: "+time2);
        long hours = ChronoUnit.HOURS.between(time1, time2);
        System.out.println("Hours between two Time Zone: "+hours);
        long minutes = ChronoUnit.MINUTES.between(time1, time2);
        System.out.println("Minutes between two time zone: "+minutes);
    }
}
