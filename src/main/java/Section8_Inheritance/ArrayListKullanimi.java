package Section8_Inheritance;
import java.util.ArrayList;
public class ArrayListKullanimi
{
    public static void main(String[] args)
    {
       //classicArray();

        ArrayList<Telefon> telefonlar = new ArrayList<>();
        Telefon tel1 = new Telefon("Mi 8",3000); // objenin kendisi heapte tutuluyor
        Telefon tel2 = new Telefon("Mate 10 Pro",4500);
        Telefon tel3 = new Telefon("Iphone X",7000);
        // telefonlar[0]=tel1; ArrayList'te boyle diyemiyoruz hata veriyor
        // listeme eleman eklemek icin asagidaki yontemi kullaniyoruz
        telefonlar.add(tel1); // ELEMAN EKLEME
        telefonlar.add(0,tel2); // index belirterek de ekleme yapabiliriz ama gidip de 10 yazamiyoruz, dizide gereksiz yere bos alanlar olusmasina izin vermiyor
        telefonlar.add(tel3);
        telefonlar.remove(0); // ELEMAN CIKARMA-INDEKS ILE
        telefonlar.remove(tel3); // ELEMAN CIKARMA-ELEMAN ADI ILE
        telefonlar.remove(tel1);

        telefonlar.add(tel1);
        telefonlar.add(tel2);
        telefonlar.add(tel3);

        System.out.println(telefonlar.size()); // ARRAYLIST'IMDE KAC ELEMAN VAR DİYE BAKIYOR
        listeyiYazdir(telefonlar);

        telefonlar.add(tel1);
        telefonlar.add(0,tel3); // EKLEMEYI DIGER ELEMANLARI KAYDIRARAK YAPAR
        System.out.println("Degisikliklerden sonra liste:");
        telefonlar.set(3,tel2); //NEKLEMEYI ELEMANIN UZERINE YAZARAK YAPAR!!
        listeyiYazdir(telefonlar);
        System.out.println(telefonlar.contains(tel3)); // ICERIYOR MU, verilen eleman dize var mi ona bakar, true ya da false dondurur

    }

    private static void listeyiYazdir(ArrayList<Telefon> liste)
    {
        // asagidaki satir classic for ile dizi yazdir methodumuz
        /*
        for(int i=0; i<liste.size(); i++)
        {
            System.out.println(liste.get(i)); // listemin i. elemanini yazdiracak
        }
         */
        // asagidaki satir foreach ile dizi yazdir methodumuz
        for(Telefon oAnkiDeger : liste)
        {
            System.out.println(oAnkiDeger);
        }

    }

    public static void classicArray()
    {
        Telefon[] telefonlar = new Telefon[20];
        Telefon tel1 = new Telefon("Mi 8",3000); // objenin kendisi heapte tutuluyor
        Telefon tel2 = new Telefon("Mate 10 Pro",4500);
        Telefon tel3 = new Telefon("Iphone X",7000);

        telefonlar[0] = tel1; // objenin referansi heap icindeki dizinin 0. indeksinde tutuluyor
        telefonlar[1] = tel2;
        telefonlar[2] = tel3;

        System.out.println(telefonlar[1]); // yazdirdi

        // bana 20 telefon yetmedi 25 tane olsun istiyorum
        telefonlar = new Telefon[25];
        // burada java gidip 20 telefonun yanina 5 kutu daha eklemiyor, sıfırdan 25 kutu getiriyor
        // asil sorun ise artik eski telefonlarimiz burada yok !!
        System.out.println(telefonlar[1]); // null yazdirdi

        // eleman sayisi bilinmedigi durumlarda yeni yer acarken olusan sikinti veya bu ornekteki gibi 20 telefonluk yer
        // ayirip yalnizca 3 tanesini kullanarak bellekten gereksiz yere yer israfi olusturdugumuz durumlar dolayisi ile
        // dizleri pek tercih etmeyiz
        // bunun yerine ArrayList kullaniriz.
        // ArrayList dizi icerisinde bosluklar olmasina izin vermez. Bundan dolayi bir ara indise eleman eklenediginde
        // veya cikarildiginda diger elemanlar kaydirilir.
        // bu durum arkada cok fazla is yuku olusturmasina ve performans kaybina yol acar
    }
}
class Telefon
{
    String model;;
    int fiyat;

    public Telefon() {
    }

    public Telefon(String model, int fiyat) {
        this.model = model;
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "Telefon{" +
                "model='" + model + '\'' +
                ", fiyat=" + fiyat +
                '}';
    }
}
