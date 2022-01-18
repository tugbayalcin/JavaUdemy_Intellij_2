package Constructor.thisKullanimi;

public class ThisKonusuDetayli
{
    public static void main(String[] args)
    {
        /*
            This Nedir, Ne işe Yarar?

            this.isim
             Java’da bir methodun icinde o methodun ait oldugu siniftan yaratilacak nesneyi veya o nesnenin bir alt
             degiskenini tanimlamamiz gerektiginde kullandigimiz deyime this diyoruz..
             Bulundugumuz sinifta nesne daha tanimlanmadigi icin bu nesneyi direk olarak kullanamiyoruz.
             Iste this ile ait oldugu class icinde yaratilan methodlar o class’in nesnesini kullanabilmektedir.
             Basit olarak soylemek gerekirse this anahtar kelimesi o anda hangi nesne uzerinde islem yapiliyorsa o nesnenin
             referansini dondurur.

            Ust tarafi daha da basite indirgeyerek anlatacak olursak bir sinif icerisindeki bir methoda veya bir değiskene
            this ile erisebilir, cagirabilir ve kullanabiliriz. Kısaca this icerisinde bulundugu nesneyi gosteren referanstir.
            this anahtar kelimesini kullanarak ayni sinif icinde diger constructor methodlari da çagirabilme yeteneğgne sahibiz.

            Unutmamamız gereken sey ise, this anahtar kelimesini static metodlar icerisinde kullanamayiz.
            Cünkü this kelimesi sinifa ait nesnelerin olusturulmasiyla bellekte yer tutmaktadir.

            Constructor’un içindeki this anahtar kelimesi heap alanındaki nesneyi temsil etmektedir

            this()
            Bu kullanim ayni sinif icindeki diger yapici methodları da cagirabilmemizi saglar.
            Bir constructor icinden classin bir diger constructorini cagirabilmemizi saglar
            Bu sayede fazla kod satirindan kurtularak daha az satir ve daha az karisikliga sebep olmus oluruz
            Asagidaki classi ve constructor methodlarini inceleyelim ve this kullanimina ozellikle dikkatimizi verelim
        */

    }
}
class ThisConstructor
{
     int ogrenciNo;
     String isim;
     byte sinif;
     boolean aktif;

    public ThisConstructor(int ogrenciNo)
    {
        this.ogrenciNo=ogrenciNo;
    }
    public ThisConstructor(int ogrenciNo, String isim) // iki parametreli constructor
    {
        this(ogrenciNo);
        this.isim=isim;
    }
    public ThisConstructor(int ogrenciNo,String isim, byte sinif) // uc parametreli constructor
    {
        this(ogrenciNo,isim);
        this.sinif=sinif;
    }
    public ThisConstructor(int ogrenciNo,String isim, byte sinif, boolean aktif) // dort parametreli constructor
    {
        this(ogrenciNo,isim,sinif);
        this.aktif=aktif;
    }




       //     this() icine constructor parametrelerimi yaziyorum
   // bu kullanim yalnizca constructor methodlar icin gecerlidir
  //  NOT: boyle bir kullanim gerceklestirilecekse, bu this() anahtari uste yazilir,
   // alt satirlara yazilirsa hata verir

}
