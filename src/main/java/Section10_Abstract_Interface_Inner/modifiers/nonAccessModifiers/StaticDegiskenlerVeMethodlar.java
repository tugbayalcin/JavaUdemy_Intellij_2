package Section10_Abstract_Interface_Inner.modifiers.nonAccessModifiers;

import java.util.Arrays;


public class StaticDegiskenlerVeMethodlar
{
    public static void main(String[] args)
    {
        Memur m1= new Memur();//heapte m1 alani olustu
        m1.setIsim("Emre");//isim static variable degil, instance variable
        m1.setMaas(4000);//maas static degil
        // gordugumuz gibi class icindeki alanlara erisebilmek icin muhakkak bir object uretmek zorundayiz
        // object classin kapisidir

        Memur m2= new Memur();//heapte m2 alani olustu
        m2.setIsim("Hasan");
        m2.setMaas(4500);

        Memur m3= new Memur();//m3 alani
        m3.setIsim("Ayse");
        m3.setMaas(2500);

        Memur[] memurObjeleriniTutanArray={m1,m2,m3};
        System.out.println(Arrays.toString(memurObjeleriniTutanArray));

        m3.bilgileriGoster();

        Memur.kanunuSoyle(); // tum classi ilgilendirdigi icin, static oldugu icin class adi ile erisebildik
        m1.kanunuSoyle(); // tum classi ilgilendirdigi icin, static oldugu icin her bir obje ile de erisebildik
        m2.kanunuSoyle(); // tum classi ilgilendirdigi icin, static oldugu icin her bir obje ile de erisebildik
        m3.kanunuSoyle(); // tum classi ilgilendirdigi icin, static oldugu icin her bir obje ile de erisebildik

        // degerlerim nesneye gore degisiyırsa static kullanmamaliyim
        // degerlerim tum nesneler icin ayni ise, her biri icin degiskenlik gostermiyor ise, yani classa ozgu ise static kullanmaliyim
        // class a ozgu seyleri object ile cagirabilirim --> m1.kanunuSoyle diyebilirim cunku kanun tum objeler icin ayni
        // ancak objecte ozgu seyleri class ile cagiramam  --> Memur.bilgileriGoster diyemem cunku class hangi objenin bilgisini getirecegini bilemez, kafasi karisir, her bir objenin bilgisi farkli
        // class yalnizca statik olana erisebilir, yani tum objectler icin ayni olana, her bir objectin kutusuna girip bakamaz
        // kutunun icinde de o objecte ozgu, onu digerlerinden farkli kilan veriler vardir

        // Static olmayan (instance method) bir method ile;
        // static olan ve olmayan tum degisken ve methodlara erisebiliriz.

        // Static olan (class method) method ile ;
        // static olan degisken ve methodlara erisebilirken, static olmayan yani instance yani nesneye ozgu olan
        // degisken ve methodlara erisemeyiz.

        // statik demek class a ait demek
        // non-statik(instance variable veya instance method olarak gecer) classin objectlerine aittir

        // classin static degiskelerine hem objectler ile hem de class adi ile erisebiliriz
        // classin static olmayan degiskenlerine ise yalnizca objectler ile erisebiliriz
        // static olan seyleri class adiyla cagirabiliyoruz, burada amac classtan ekstra object uretmeden
        // yalnizca class adini kullanarak kisa yoldan erisim saglayabilmek

        //  !!! Static methodlarla ilgili bilinmesi gereken en onemli sey sudur:
        //  static methodlar icinden static olmayan bir sinif ogesine erisemeyiz   !!!

        // garbage collector static degiskenlere dokunmazlar!!!



        System.out.println("Nesne sayisi m1: " +m1.olusturulanMemurNesnesi);
        System.out.println("Nesne sayisi m1: " +m2.olusturulanMemurNesnesi);
        System.out.println("Nesne sayisi m1: " +m3.olusturulanMemurNesnesi);
        System.out.println("Nesne sayisi m1: " +Memur.olusturulanMemurNesnesi);


    }

}
class Memur
{
    private String isim; //objeye ozgudur
    private int maas;     //objeye ozgudur
    // public int olusturulanMemurNesnesi; bu sekilde yazinca instance degisken
    public static int olusturulanMemurNesnesi; // bu sekilde yazinca class degiskeni, statik memoryde
    // private de olabilirdi ancak o zaman obje ile veya class ile cagiramazdik, yalnizca var olurdu getter kullanmamiz gerekirdi

    public Memur()
    {
        olusturulanMemurNesnesi++;

    }
    public String getIsim()
    {
        return isim;

    }
    public void setIsim(String isim)
    {
        this.isim = isim;

    }
    public int getMaas()
    {
        return maas;

    }
    public void setMaas(int maas)
    {
        if(maas<0)
        {
            maas =0;
        }
        else
        {
            this.maas = maas;
        }


    }
    public static void kanunuSoyle() // burasi static bir method oldugu icin object ile cagirmak zorunda degiliz. Class adi ile cagirabiliriz. Cunku classin icindeki tum objectler bu methoda erisebiliyor
    {
        System.out.println("657 Sayili Kanun Gecerlidir");

    }

    public void bilgileriGoster() // burasi objectleirn cagirabilecegi bir method
    {
        System.out.println("Olusturulan Memur Nesnesi:" + olusturulanMemurNesnesi);

    }

    /*
        Statik degiskenler olusturuldugunda ait oldugu sinif icin hafizada bir tek yer acilir.
        Olusturulan her bir nesne icin tekrardan bellekte yer kaplamazlar.

        Statik degiskenler nesneye bagli olmadan olusturulduklari icin, onlara nesne yaratilmaksızın erisilir.
        Yani statik degiskenler hicbir nesne oluşturulmadan veya var olan tum nesneler silindikten de sonra da erisilebilirler.

        Statik bir degisken nesnelerden bagimsiz olarak sahip oldugu veriyi kendine ozel olan bellekte tutar.
    */


    //toString() methodunu Object Classindan alip icini degistirirsem(overriding yaparsam)
    //memur classinin herhangi objesini yazdirmak istedigimde objenin stackte tutulan reference numarasi degil toSTRING() methodu yazilir


    @Override
    public String toString() {
        return "Memur{" +
                "isim='" + isim + '\'' +
                ", maas=" + maas +
                '}';
        //herhanfi bir memur objesini (m1.m2,m3 olabilir) icini gormek yazdirmk icin
        // return ile yukardaki degeri yazdiririz

        //toString() methodu heapte olusan memur objelerinin tercumanidir, o alanlarda tutulan degerlere bakar
        //yukarda return eder
    }
}