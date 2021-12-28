package L2_CommonClasses.P03_ConsoleClass;

import java.io.Console;

public class ConsoleClassExamples
{
    public static void main(String[] args) {
        // Console Class'i console'dan girdi almak icin kullanilir
        // Metinleri ve dsifreleri okumak icin methodlar sunar
        // Console Class'ini kullanarak sifre okursak, kullaniciya gosterilmez /(terminalde yazarken gorunmuyordu hatırlarsan)
        // public final class Console extends Object implements Flushable


        Console c = System.console();
        String text = c.readLine();
        System.out.println( "Metin: " + text);

        //------------------------------------------

        Console t = System.console();
        System.out.println("Enter your name: ");
        String n = t.readLine();
        System.out.println("Welcome "+n);

        // Example: read password ----------------------

        Console y=System.console();
        System.out.println("Enter password: ");
        char[] ch=y.readPassword();
        String pass=String.valueOf(ch);//converting char array into string
        System.out.println("Password is: "+pass);
    }
}
