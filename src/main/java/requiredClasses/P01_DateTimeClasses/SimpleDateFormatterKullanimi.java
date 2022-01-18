package requiredClasses.P01_DateTimeClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatterKullanimi
{
    // Bakiniz: https://www.javatpoint.com/java-simpledateformat
    // SimpleDateFormatter Javada tarih ve saati bicimlendirmek ve ayristirmak icin methodlar saglar
    // SimpleDateFormat, java.text.DateFormat sınıfından kalitim alan tarihi biçimlendirme ve ayrıştırma için kullanilan somut bir sınıftır.
    // Biçimlendirme: Tarihi dizeye dönüştürme
    // Ayrıştırma: Dizeyi tarihe dönüştürme

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate= formatter.format(date);
        System.out.println(strDate);
    }
}
