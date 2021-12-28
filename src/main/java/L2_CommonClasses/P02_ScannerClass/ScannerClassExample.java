package L2_CommonClasses.P02_ScannerClass;

import java.util.*;

public class ScannerClassExample
{
    public static void main(String[] args) {
        String str = "Hello/This is JavaTpoint/My name is Abhishek."; // kendi string metnimi olusturuyorum
        String str2 = "Hi-Hello/This is JavaTpoint/My name is Tugba"; // kendi string metnimi olusturuyorum
        //Create scan with the specified String Object
        Scanner scan = new Scanner(str); // kullanicidan System.in ile veri almak yerine kendi metnimi okumasini istiyorum, yalnizca 1 string cumlem var
        System.out.println("Boolean Result: "+scan.hasNextBoolean()); // hasNextBoolean(): scanner objesinin tuttugu girdigden sonra 2. bir girdi daha var mi ona bakar
        //Change the delimiter of this scan
        scan.useDelimiter("/");
        //Printing the tokenized Strings
        System.out.println("---Tokenizes String---");
        while(scan.hasNext()){ // bir sonraki adimda veri var mi yok mu diye bakar
            System.out.println(scan.next()); // veri varsa yurur, ilerler
        }
        //Display the new delimiter
        System.out.println("Delimiter used: " +scan.delimiter());
        scan.close();
    }
}
