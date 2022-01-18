package Section10_Abstract_Interface_Inner.nestedClass.staticNestedClass;

import java.util.ArrayList;

public class Interface
{
    //<editor-fold desc="Interface">
    /*
        1.Guzelligi: Iki farkli yapiyi bir arada toplayip onlari tekrar tekrar kullanabilmek
        2.Guzelligi: Aralarinda herhangi bir kalitim iliskisi bulunmadan bag kurabilmek

        iki sinifi benzer yapan sey onlarin ayni methodlara sahip olamsi yani ayni seyi yapabilmeleridir

        javada coklu kalitima izin verilmez, cunku isler icinden cikilamayacak kadar karisabilir
        interface yapisi bu konuda bize yardimci olur ve coklum kalitim olmadan yapilari birbirine baglayabilmemizi saglar

     */
    //</editor-fold>
    public static void main(String[] args)
    {
        Elma a = new Elma(); // bu zaten her durumda yazabildigim bir sey idi
        Yenilebilir aa = new Elma(); // bunlar ise kalitim sayesinde yapabildigim bir sey idi
        Yenilebilir bb = new Inek(); // ancak artik interface sayesinde de yapabiliyorum
        ArrayList<Yenilebilir> yenilebilenSeyler = new ArrayList<>();
    }
}
interface Yenilebilir // class tanimlar gibi yapiyoruz, sol click > new interface ile de yapabilirsin ancak kullanim amaci farkli olur
{
    void yenmeSekli(); // method tanimladik
    // class bunu kullanmak zorunda
    // ve burada icine hicbir sey yazamiyoruz
    // void asd (){} deyip süslü parantez icine bir sey yazamayiz
}
class Elma implements Yenilebilir
/* implement keywordu ile interface adi yazilarak bu sekilde kullanilir, yazar yazmaz hata verir,
   der ki interfacede olan methodu override etmek zorundasin henüz etmedin git ve cabucak et
   diger bir deyisle, interface bir anlasmadir ve eger sen anlasmayi kabul ediyor isen kosullarini uygulamak zorundasin
   kosullari da, anlasmada bulunan maddeleri kabul etmek ve gerceklestirmektir
   bu maddeler ise methodlardir

 */
{

    @Override
    public void yenmeSekli()
    {}
    void elmaMethodu(){}
}
class Inek implements Yenilebilir
{
    @Override
    public void yenmeSekli() {

    }
    void inekMethodu(){}
}

/*
    Yukaridaki classlara bakar isek, aslinda aralarinda cok da bir ortak nokta olmayan iki farkli yapiyi interface
    kullanarak tek bir cati altinda toplamis oldum, ve bunun kalitim kullanmadan yaptim
    Iki class birbirine jkalşitim iliskisi olmaksizin baglanabildiler
    bu sayede
        Elma a = new Elma(); // bu zaten her durumda yazabildigim bir sey idi
        Yenilebilir aa = new Elma(); // bunlar ise kalitim sayesinde yapabildigim bir sey idi
        Yenilebilir bb = new Inek(); // ancak artik interface sayesinde de yapabiliyorum
    seklinde kodlar da yazabiliyorum.
 */
