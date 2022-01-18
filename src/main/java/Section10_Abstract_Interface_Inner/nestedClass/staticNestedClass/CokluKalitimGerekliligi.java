package Section10_Abstract_Interface_Inner.nestedClass.staticNestedClass;

import java.util.ArrayList;

public class CokluKalitimGerekliligi
{
    //<editor-fold desc="Neden Coklu Kalitim Yapamiyoruz"
/*
     class MuslumBaba extends ArabeskSarkici,PopSarkicisi

        Muslum baba hem arabesk sarki hem de pop sarkisi soyleyebilir,
        ama java ayni anda iki classtan kalitim almama izin vermiyor
        bunun sebebi ;
        Sarkici muslum = new MuslumBaba();
        dedigimde benim erisebilecegim methodlar Sarkici classinda, uygulayacgim yer MuslumBaba classinda
        benim cagirdigim bir method sub classta yoksa ata classa bakilir ve oradaki calistirilir idi
        simdi hem pop sarkicida hem de arabesk sarkicida yer alan sarki soyle methodunun MuslumBaba classinda override edilmedigini dusunelim
        biz bir obje ile bu methoda erismek isteyelim
        MuslumBaba classinda olmadigi icin ata classa bakilacaktir
        ancak 2 tane ata classimiz var ve ikisinde de bu method var
        peki biz hangisini kullanacagiz ???
        iste tam da bu noktadaki karisiklik yuzunden iki classtan kalitim yani coklu kalitim alamiyoruz
 */
//</editor-fold>

    public static void main(String[] args)
    {
        PopSarkiciOzellikleri popSarkici1 = new Tarkan();
        PopSarkiciOzellikleri popSarkici2 = new Hadise();
        // her ikisi de bir cati altinda toplanmis oldu

        PopSarkiciOzellikleri dizi[] = new PopSarkiciOzellikleri[5];
        dizi[0]=popSarkici1;
        dizi[1]=popSarkici2;

        ArrayList<PopSarkiciOzellikleri> sarkicilar = new ArrayList<>();
        sarkicilar.add(popSarkici1);
        sarkicilar.add(popSarkici2);

        popSarkici1.sahnedeDansEt();


    }
}
interface Kisi
{
    void yemekYe();
    void sporYap(); // normalde methodun icini asla ve asla dolduramayiz
    default void adiniSoyle() // ancak java8 sonrasi default method olusturabiliyoruz. ve bunu ekleyince diger siniflar bunu override etmek zorunda değil
    {
        System.out.println("Ben Kisi interfaceiyim");
    }
}
interface OgrenciOzellikleri extends Kisi,UniversiteOgrencisi // interface ler de kalitilabilir
{
    void dersCalis();
    void okulaGit();

}
interface UniversiteOgrencisi
{
    void finallereCalis();
}
class Student implements OgrenciOzellikleri
{
    @Override
    public void yemekYe() {

    }

    @Override
    public void sporYap() {

    }

    @Override
    public void dersCalis() {

    }

    @Override
    public void okulaGit() {

    }

    @Override
    public void finallereCalis() {

    }
}
// !!! soyut bir classs (abstract class) bir interface i implement ettiginde buradaki methodlari yazmak zorunda degildir !!!
// cunku soyut siniflar zaten bir obje olusturamadigi icin gidip de interface icindeki methodu cagiramayacak
// ancak bunu yaptigimizda Sarkicidan extend alan classlara gidip Kisi deki methodlari implement etmeliyiz
abstract class Sarkici implements Kisi
{
    abstract void sarkiSoyle();
}
interface ArabeskSarkiciOzellikleri
{
    void sahnedeCayIc(); // bu methodlar varsayilan olarak publictir, public keywordu eklesek bile soluk renkli yazar
    int yas = 5; // burada degisken de tanimlayabiliriz. ancak bu degiskenler varsayilan olarak static final dir. ve tanimlandigi yerde deger atanmasi zorunludur
    // neden static: cunku interface lerden nesne uretemiyoruz, abstact class gibidirler ve normal classlardan farkli olarak constructorlari yoktur
    //
}
interface PopSarkiciOzellikleri extends Kisi // buraya her ekledigin yeni methofu implements alan classlara oıverride etmelisin
{
    void sahnedeDansEt();
    void    duetYap();
}
class Tarkan implements PopSarkiciOzellikleri
{
    @Override
    public void sahnedeDansEt() {}

    @Override
    public void duetYap() {}

    @Override
    public void yemekYe() {

    }

    @Override
    public void sporYap() {

    }
}
class Hadise implements PopSarkiciOzellikleri
{
    @Override
    public void sahnedeDansEt() {}

    @Override
    public void duetYap() {}

    @Override
    public void yemekYe() {

    }

    @Override
    public void sporYap() {

    }
}

class ArabeskSarkici extends Sarkici
{
    @Override
    void sarkiSoyle()
    {
        System.out.println("Arabesk sarkici sarki soyluyor. ");
    }

    @Override
    public void yemekYe() {

    }

    @Override
    public void sporYap() {

    }
}
class PopSarkicisi extends Sarkici
{
    @Override
    void sarkiSoyle()
    {
        System.out.println("Pop sarkicisi sarki soyluyor");
    }

    @Override
    public void yemekYe() {

    }

    @Override
    public void sporYap() {

    }
}
class MuslumBaba implements ArabeskSarkiciOzellikleri, PopSarkiciOzellikleri // iki farkli interface kullanabiliyoruym
{
    @Override
    public void sahnedeCayIc() {}

    @Override
    public void sahnedeDansEt() {}

    @Override
    public void duetYap() {}

    @Override
    public void yemekYe() {

    }

    @Override
    public void sporYap() {

    }
}


