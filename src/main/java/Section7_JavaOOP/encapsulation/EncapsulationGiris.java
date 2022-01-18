package Section7_JavaOOP.encapsulation;

import java.util.Date;

public class EncapsulationGiris
{
    public static void main(String[] args)
    {
        // Bir classa girmenin iki yolu vardir
        // 1. Classtan object olustururuz.
        // Ornegin Date object=new Date()  --> Date classinin icindeki parametresiz Constructori  kullanarak Date classindan object olusturduk
        // object degiskeni(object) ile classin icindeki public olan tum degiskenlere, objectlere, methodlara, classlara erisilebilir
        // 2. Classin icine classin ismi ile girilir. Ornegin Date.parse
        // Classin ismi sadece ve sadece public static olan degiskenlere, objectlere, methodlara, classlara erisir
        // Ozetle, object ile classin tum public verilerine(degisken, object,method,class) ulasilirken
        // Classin ismi ile sadece classin icindeki hem public hem statik sartlarini saglayan verilere ulasilir

        // public keywordu --> Bir veriye classinin disaridan erisilebilmesini saglar
        // static keywordu --> Kondugu verinin classin ismi ile direct cagirilabilmesini saglar

        // 1.YOL:
        Date obj1=new Date();//Date Class'inin parameteresiz constructor methodu ile obje olusturuldu
        Date obj2=new Date(1997,03,29);//Date Class'inin 6 farkli constructorindan bir tanesidir ve bu constructor sayesinde object olusturduk

        long date1 = obj1.getTime();// long veri return eden public olan ancak non-static getTime methodunu object ile cagirdik
        System.out.println(date1);

        long date2 = obj2.UTC(2021,9,18,10,11,12);
        System.out.println(date2);
        // Date classinin objectiyle Date classinin icindeki herhangi bir veriye ulasabiliriz
        // Bu ornegimizde public static olan UTC methodunu cagirdik
        // DİKKAT!!: --> ObjectIsmi. dedigimiz an intellij bize static olan cevrleri gostermez.
        // Cunku intellij bizden static verileri cagirmamiz icin classs ismini kullanmamizi ister
        // Bu yaptigimiz ornek tamamen dogrudur. Mantik hatasi yoktur

        // 2.YOL:
        long date3 = Date.UTC(1995,5,5,17,15,13);
        System.out.println(date3);
        // Bu sefer classin icine bir object ile degil direct Classin ismi ile eristik
        // Classin ismi ile sadece ve sadece public arti static olan verilere ulasilir

        // bir Classi kullanabilmek icin object olusturuken, eger objecti class constructori ile olusturuyorsam,
        // object kutusunun icinde classin icinde olan her sey vardir
        // ancak eger class adi ile olusturursam, object kutusunun icinde yalnizca classin static ozellikte olan verileri yer alir
        // yani bir nevi alt kume olusmus olur
        // burada da public olan verilere erisebilirim, private olan veriler kutuda yer almasina ragmen erisim saglayamam


        // **** Bu sayfada bir classin icine nasil girilecegini ve hangi verilericagirabilecegimizi iki farkli yol ile ogrendik
        // **** Bundan sonraki encapsulation konusunda objecyt ile ve class ismi ile dahi erisilmesini istemedigimiz verilerin nasil olusturuldugunu ogrenecegiz
        // ****
    }
}
