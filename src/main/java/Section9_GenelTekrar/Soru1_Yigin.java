package Section9_GenelTekrar;

import java.util.ArrayList;

public class Soru1_Yigin
{

    public static void main(String[] args)
    {
        //<editor-fold desc="Soru_1">
        /*
           * Kendi yigin sinifinizi olusturun
             Yigin icindeki verileri son giren ilk cikar mantigiyla saklayan bir veri yapisidir.
             Ust uste dizilmis tabaklara benzetebilirsiniz. Sadece en ustteki veri disariya verilebilir

           * Sinifi olustururken elemanlsari tutacak bir ArrayList kullanabilirsiniz.
             Ayrica sinifta su methodlar olmali;
             -->bosMu() : boolean. Eegr hic eleman yoksa true dondurmeli
             -->kacElemanVar() : int. eleman sayisini dondurur
             -->pop() : Object. En ustteki elemani verir ve listeden cikarir
             -->push() : Object. Yiginin en ustune eleman ekler
             -->elemanGoster() : Object. En ustteki elemani gosterir ama yigindan cikarmaz
        */
        //</editor-fold>
        MyStack myStack = new MyStack();
        Ogrenci ogr1 = new Ogrenci("tugba",17,566776,10);
        Ogrenci ogr2 = new Ogrenci();
        Ogrenci ogr3 = new Ogrenci("yalcin",7,58797776,11);
        Ogrenci ogr4 = new Ogrenci("asel",8,2021,13);

        myStack.push(ogr1);
        myStack.push(ogr2);
        myStack.push(ogr3);
        myStack.push(ogr4);
        myStack.yazdir();

        myStack.pop();
        System.out.println(myStack.kacElemanVar()+ "tane eleman var "); // poptan sonra calistirdigim icin 3 var dedi,
        System.out.println("Listem Bos Mu: "+myStack.bosMu());
        System.out.println("Listemin Son Elemani: "+myStack.elemanGoster());
        myStack.yazdir();
        myStack.pop();
        myStack.pop();
        myStack.pop(); // 3 elemanli listemde 3 kere son elemani göster ve sil methodunu calisarak bosalttim, bakalim ne olacak
        myStack.yazdir();
        myStack.pop(); // hata veriyor cunku liste zaten bos ve ben bir seyi cikarmaya calisiyorum, gidip pop methodumu guncellemeliyim
        // guncelledik, simdi istedigimiz kadar pop methodunu calistirailiriz
        myStack.pop();
        myStack.pop();
        myStack.pop();


    }

}
class MyStack
{
    private ArrayList<Object> liste;
    // kac eleman girip cikjacagi belli olmadigi icin dizi gibi sabit elemanli bir yapi yerine ArrayLİst kullanmak daha avantajlidir
    // private olmasi disaridan .add ve .remove ile eleman eklenip cikarilmasini engeller, eleman ekleme islemlerini methodlar ile kontrol altina alacagim
    // arrayime te turden veri gelecegini bilmedigim icin en genel class olan Object classi kullaniyoruz, tum classlar Object classtan kalitilir
    public MyStack()
    {
        liste=new ArrayList<>();
    }
    public int kacElemanVar() // dısaridan erisilsin istedigim icin public yaptim
    {
        return liste.size(); // bu method vana listemde bulunan eleman sayisini geri dondurecek
    }
    public boolean bosMu()
    {
        //return liste.isEmpty(); // halihazirda var olan isEmpty methodunu kullanabiliriz veya
        if(liste.size()>0) // >0 ise eleman var demektir,
        {
            return false; // eleman varsa false
        }
        else return true; // eleman yoksa true dondurur
    }
    public Object elemanGoster()
    {
        return liste.get(kacElemanVar()-1);
        // liste.get() ile verilen indeksteki eleman gelirdi, ben son indeksimi bilmedigim icin kacElemanVar methodundan yararlaniyorum
        // indeksler 0 dan basladigi icin de 1 cikartiyorum.
    }
    public Object pop()
    {
        if(kacElemanVar()>0)
        {
            Object geriyeDondurulecekEleman = liste.get(kacElemanVar()-1);
            liste.remove(kacElemanVar()-1);
            return geriyeDondurulecekEleman;
        }
        else
        {
            System.out.println("Yigin Bos, Pop Yapilamaz");
            return null;
        }

    }
    public void push(Object eklenecekEleman)
    {
        liste.add(eklenecekEleman);
    }
    public void yazdir()
    {
        System.out.println("*************** YIGIN ICERIGI ***************   ");
        for(int i=0; i<liste.size(); i++)
        {
            System.out.println(i+ "Indekste: " + liste.get(i));
        }
    }
}
class Ogrenci
{
    private String isim;
    private int yas;
    private long tcKimlik;
    private int okulNo;

    public Ogrenci()
    {
        isim = "Henüz Atanmadı.";
        yas = 0;
        tcKimlik = 0;
        okulNo = 5000;
    }
    public Ogrenci(String isim, int yas, long tcKimlik, int okulNo) {
        this.isim = isim;
        setYas(yas);
        this.tcKimlik = tcKimlik;
        this.okulNo = okulNo;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        if(yas>=7)
            this.yas = yas;
        else this.yas = 7;
    }

    public long getTcKimlik() {
        return tcKimlik;
    }

    public void setTcKimlik(long tcKimlik) {
        this.tcKimlik = tcKimlik;
    }

    public int getOkulNo() {
        return okulNo;
    }

    public void setOkulNo(int okulNo) {
        this.okulNo = okulNo;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "isim='" + isim + '\'' +
                ", yas=" + yas +
                ", tcKimlik=" + tcKimlik +
                ", okulNo=" + okulNo +
                '}';
    }

}


