package Section12_CollectionFramework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.List;

public class C05LinkedList
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
        // Her node un basinda onun adresini tutan bir head kismi vardir
        // sonunda da kerndisinden sonra gelecek nodeun head kismi vardir, bir sonraki adimda nereye gidecegini anlar
        // Listenin son elemaninin sonunda tail yani kuyruk vardir
        // LinkedList in elemanlarini gezmek performns acisindan sikintilidir, veri ekleme ve silme hizlidir
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


        for (int i=0; i<9000000; i++)
        {
            sayilar2.add((int)(Math.random()*5));
        }
        //--------------------------------------------------------------------------------------------------------------
        // ArrayList vs LinkedList



    }

    private static void arrayListiHazirla(ArrayList<Integer> sayilar2)
    {
        for (int i=0; i<100000; i++)
        {
            int yeniEklenecekEleman = (int)(Math.random()*500000);
            siraliekle(sayilar2,yeniEklenecekEleman);
        }
    }

    public static void linkedListiHazirla(LinkedList<Integer> sayilar1)
    {
        for (int i=0; i<100000; i++)
        {
            int yeniEklenecekEleman = (int)(Math.random()*500000);
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
        return true;
    }
}
