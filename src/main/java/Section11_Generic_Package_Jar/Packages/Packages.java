package Section11_Generic_Package_Jar.Packages;

import java.util.Scanner;
import java.awt.*;

public class Packages
{
    /*
        PACKAGE KULLANMANIN FAYDALARI
         Programcilar ayni paketteki siniflarin birbiriyle alakali oldugunu kolayca anlar
         Sinif veya Interfaceleri packagelara ayirirsak kolayca bulabiliriz
         Package kullanarak yeni namespaceler olusur. Bu sayede sinif ve interface isimleri birbiriyle cakismaz
     */

    public static void main(String[] args)
    {
        /* package disindaki bir classi kullanmak istedigimizde java onu bize otomatik olarak import eder,
        // etmezse bizim etmemiz gerekir, import etmeden baska packagein bir elemanini kullanamayiz

        // bizim packageimiz disinda baska packagelarda Ogrenci isimli bir classin oldugunu düsünelim
        // ben 1. packagedaki Ogrenci classini kullanmak istedigimde (classi ilk kez cagirdigimda) hangi packagedakini sectiysem
        // o package import edilir
        // ardindan ben 2. packagedaki Ogrenci classini da kullanmka istedim
        // bu sefer import islemi yapilmaz ve kullanim PackageAdi.ClassAdi. ... seklinde olur
        // bunun sebebi her iki packageda da ayni class var ve ben bu classi cagirdigim zamman java hangisine gidecegini bilemiyor
        // bundan dolayi ilk kez cagirdigimda pacage import edilirken, sonraki packagelar tam adi ile yazilmak zorunda kaliyor

        // soyle bir kullanim da mevcut: biz hicbir packagei import etmeyelim. ama her kullanimd auzun uzun package adini yazalim, olur mu, olur
        // burada kullanacagim tam adresi verdigim icin editorun kafasi karismiyor

         */
        MyWindow window = new MyWindow("Ilk GUI");
        window.setVisible(true);
    }
}

