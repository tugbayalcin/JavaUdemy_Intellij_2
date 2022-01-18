package Section12_CollectionFramework.Lists.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.List;

public class C122_LinkedList // Bagli Liste
{
    public static void main(String[] args) {

        // calisma sekli olarak arrayListten farklilik gosterir
        // onun disinda temelde ikisi de listedir ve eleman tutar
        // biri dizi mantiginda, digeri adres mantiginda tutar

        LinkedList<Integer> sayilar = new LinkedList<>();
        // normalde ArrayListte buraya varsayilan olarak bir kapasite verebiliyorduk,
        // bos bir ArrayList olusturdugumda aslinda 10 elamanli bir dizi oplusturmus oluyordum ve bu dizi daha
        // sonrasinda dynamic olarak buyuyup kuculebiliyordu
        // LinkedListte boyle bir yapi yok
        // LinkedList diyor ki, sen bana bir collection verirsen bu collectiondaki elamanlari listene atayabilirim
        // ve sana bos bir LinkedList yerine dolu bir LinkedList saglayabilirim diyor
        // LinkedList index bazli calismaz, cunku dizi mantigi yoktur
        sayilar.add(1);
        sayilar.add(2);
        sayilar.add(4);
        sayilar.add(2,3);
        // Burada indexe atadi gibi dusunme
        // LinkedList List Interfaceinden inherit edildigi icin onun icinde bulunan add methodu calisacak ama cok farkli sekilde calisacak
        System.out.println(sayilar); // listeyi sout ile yazdirailirim
        System.out.println(sayilar.get(1)); // elemanini cagşirabilirim

        // farklara bakalım

        // LinkedList elemanlarina node denir
        // Listenin en basinda bir tane head adi verilen bir yapi vardir ve ilk node'un adresini tutar
        // Her node un basinda kendi adresini tutan bir bolum vardir
        // sonunda da kendisinden sonra gelecek nodeun adresini tutan bir bolum vardir, bir sonraki adimda nereye gidecegini anlar
        // Listenin son elemaninin sonunda tail yani kuyruk vardir
        // son elemanin kendisinden sonra gidecegi adres tail adresidir
        // LinkedList in elemanlarini gezmek performans acisindan sikintilidir,
        // Ancak veri ekleme ve silme hizlidir cunku array list'lerde oldugu gibi kaydirma islemi soz konusu degildir


        sayilar.set(1,10);
        ListIterator<Integer> iterator = sayilar.listIterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        //--------------------------------------------------------------------------------------------------------------

        LinkedList<Integer> sayilar1 = new LinkedList<>();
        ArrayList<Integer> sayilar2 = new ArrayList();

        long baslamaSuresi = System.currentTimeMillis();
        linkedListiHazirla(sayilar1);
        long bitisSuresi = System.currentTimeMillis();
        //System.out.println("Sirali olusmus LinkedList: " + sayilar1);
        System.out.println("LinkedList calisma suresi: " + (bitisSuresi-baslamaSuresi));

        long baslamaSuresi1 = System.currentTimeMillis();
        arrayListiHazirla(sayilar2);
        long bitisSuresi1 = System.currentTimeMillis();
        //System.out.println("Sirali olusmus ArrayList: " + sayilar2);
        System.out.println("ArrayList calisma suresi: " + (bitisSuresi1-baslamaSuresi1));


        for (int i=0; i<9; i++)
        {
            sayilar2.add((int)(Math.random()*5));
        }
        //--------------------------------------------------------------------------------------------------------------
        // ArrayList vs LinkedList



    }

    private static void arrayListiHazirla(ArrayList<Integer> sayilar2)
    {
        for (int i=0; i<10; i++)
        {
            int yeniEklenecekEleman = (int)(Math.random()*5);
            siraliekle(sayilar2,yeniEklenecekEleman);
        }
    }

    public static void linkedListiHazirla(LinkedList<Integer> sayilar1)
    {
        for (int i=0; i<10; i++)
        {
            int yeniEklenecekEleman = (int)(Math.random()*5);
            siraliekle(sayilar1,yeniEklenecekEleman);
        }
    }

    // siraliEkle nmethodu aciklama:
    // icine hem ArrayList hem de LinkedList alsin istedigim icin her ikisinin de ust interfacei olan List i paraöetre olarak gectim
    // ben random uretilen elemanlarimi listelere sirali olarak eklemek istedigim icin siraliEkle diye bir method tanimliyorum,
    // yoksa her eleman uretim sirasina gore liste sonuna eklenecekti


    public static boolean siraliekle(List<Integer> liste, int yeniEklenecekEleman)
    {
        ListIterator<Integer> iterator = liste.listIterator();

        while (iterator.hasNext())
        {
            int karsilastirmaSonucu = iterator.next().compareTo(yeniEklenecekEleman);
            if(karsilastirmaSonucu == 0) // elemanlar esittir
            {
                iterator.add(yeniEklenecekEleman);
                return true;
            }
            else if(karsilastirmaSonucu > 0)
            {
                iterator.previous(); // ekleyecegimmsayi daha kucuk oldugu icin itertorumu 1 bsasamak geri kaydirdim ve oraya eklettim
                iterator.add(yeniEklenecekEleman);
                return true;
            }
            else
            {

            }
        }
        iterator.add(yeniEklenecekEleman);
        // eleman ekleme methodu calisirken for dongusune girilecek ilk olusturulan elemandan sonra sirali ekle methodu calisacak
        // compiler buraya gelecek ancak karsilastirabilecegi bir sey yok, bu yuzden karsilastirma yapmadan while'a girmeden gidip
        // iterator.add(yeniEklenecekEleman);  satirini calistiracak ve ilk elemanini ekleyecek
        // ardindan bu method calismasini tamamlamis olacak ve
        // compiler yukaridaki ekleme methodundaki for dongusune kaldigi yerden devam edecek

        return true;
        // methodun neden geriye bir sey donudrmesi gerekitini ve hatta bu degerin neden boolean olmasi gerektigini anlamadim????

        // pek anlamadim ????

    }
}
