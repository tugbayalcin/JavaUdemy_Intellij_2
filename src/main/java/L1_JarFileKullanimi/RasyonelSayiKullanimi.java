package L1_JarFileKullanimi;

//import Section11_Generic_Package_Jar.JarFileOlusturma.RasyonelSayi;
//import Section11_Generic_Package_Jar.JarFileOlusturma.Main;

import Section11_Generic_Package_Jar.JarFileOlusturma.*; //Bu satir yukardaki 2 importu da kapsar

import static Section11_Generic_Package_Jar.GenericClass.IntegerDiziYazdir.*;//Kullanilmayan import'lar gri yanar

public class RasyonelSayiKullanimi
{
    public static void main(String[] args)
    {
        //IMPORT1 --> obje olusturma
        RasyonelSayi rasyonelSayi = new RasyonelSayi(2,3); // rasyonel sayi classindan bir nesne olusturuldu
        RasyonelSayi rasyonelSayi2 = new RasyonelSayi(4,5);

        RasyonelSayi toplam = rasyonelSayi.toplama(rasyonelSayi2); // olusan bu nesne ile rasyonel sayi classindaki toplama methoduna erisildi
        System.out.println(toplam);


        //IMPORT2 --> statişc elemanlara class adi ile erisme
        //Main Class'inin icindeki static main(String[] args) methodu cagrildi.
        Main mainClassObj=new Main(); // buradaki Main, class olan Main. Main classindan obje olusturuldu
        //mainClassObj.main(new String[]{"1","2"}); // obje kullanilarak main methoda erisildi

        // ancak biz static elemanlara erismek istiyorsak, boyle bir kullanim pek de hos degildir.
        // static elemanlar class adi ile erisilebilen elemanlar oldugu icin asagidaki gibi bir kullanim daha dogru olur

        //Static Bir methodun dogru cagrilma yolu; -> ClassAdi.MethodAdi();

        String[] strArray=null; // dizi tanimladim
        Main.main(strArray); // ClassAdi.MethodAdi(tanimladigim dizi);


        //IMPORT3 --> static import ile bir classin static methodunu direk kullanabilme
        yazdir(new int[]{1,2,3});


        //BILGI -> .jar file icindeki kodlari degistiremezsin(read-only mode)
        //BILGI-> .jar file'lar birer kopyadir
        // o zaman orjinal dosyada yaptigim degisiklikler jar file calistiran projede gecerli olmaz -evet
        //.jar file'ini guncellemek istiyorsan, tekrardan jar olusturup, tekrardan entegre etmelisin hoca oyle yaptı zaten
        //BILGI -> // or /* */ ile yazilan commentler Jar file'da gozukmez, Resmi Comment -> Java Document /** */ kullanmak gerekir


    }
}

