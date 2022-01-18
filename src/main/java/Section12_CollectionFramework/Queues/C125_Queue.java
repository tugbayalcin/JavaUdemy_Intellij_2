package Section12_CollectionFramework.Queues;

import java.util.*;

public class C125_Queue
{
    public static void main(String[] args) {

        {

            System.out.println();
            // Queue demek kuyruk demektir
            // Bir interface'tir yani soyut bir yapidir
            // Biz soyut yapilari somut classlar araciligiyle kullaniyorduk (extends ve implements ederek)
            // Queue Interface'inin somut classs'i Priority Queue'dir


            /* ============ QUEUE ============ */

            // Collection interface'inden turetilmistir
            // Ilk giren ilk cikar mantigiyla calisir
            // yani bildigimiz kuyruk, sira mantigi
            // Priority Queue ise biraz farklidir
            // Burada elemanlar oncelige gore siralanir
            // En kucuk degeri olan kuyrugun basina gecer
            // Kuyrugun basi ve sonu vardir
            // Elemanlar sona eklenir, bas taraftan cikartilir, kuyrugun ortasina eleman eklenmez, kaynak yasak :)
            // ** Burada null degerlere izin verilmez
            // Ayni elemanlar tekrar eklenebilir, unique yapisi yoktur
            // Listler gibi random access yoktur, ortadakilerle kimse konusamaz

        /*
            --> poll(): methodu ile elemani kuyrukrtan cikartiriz, eleman yoksa null deger dondurur
            --> remove(): methodu da ayni amac icin kullanilabilir ancak eleman yoksa hata verir

            --> peek(): methodu ile en bastaki elemani gorebiliriz, eger eleman yok ise null doner
            --> element(): methodu da ayni amac icin kullanilabilir ancak eleman yoksa hata verir

            --> offer(): methodu ile kuyrugun sonuna eleman eklenir ve eger basarili olunmazsa null deger doner.
            --> add(): methodu da ayni amac icin kullanilabilir ancak ekleme basarisiz oldugunda hata verir

            // remove, element, add methodlari List'lere ozgu methodlar oldugundan burada da kullanilabiliyor ancak
            // poll, peek, offer methodlari Queue yapisina ozgu methodlar oldugundan daha efectif sonuclar verecektir
        */

            /* Priority Queue Class'i --> Torpilli Queue :) */
            // Elemanlari belirli bir siraya gore saklayan somut siniftir.
            // Wrapper ve String siniflar icin herhangi bir sey yapamaya gerek yoktur
            // ancak kendi class'larimizi (kendi veri turumuzu) kullanirken bu class'larin
            // Comparable interface'ini implements etmesi gerekir ki java siralamayi neye gore yapabilecegini bilsin
            // Eger String ve Wrapperlar icin normal siralama istemiyorsak
            // bu class'lardan object uretirken comparator interface'ini gerceklestirme istegimizi belirtmeliyiz
            // yani kensimiz override ederek icini istedigimiz gibi degistirmeliyiz
        }
        linkedListIleQueue();
        priorityQueue();
        ogrenciQueue();


    }
    public static void linkedListIleQueue()
    {
        // Queue de bir interface oldugu icin new diyerek object uretmemiz mumkun degildir
        // ancak yazmaya calistigimizda editor bize ... gosteriyor, bu durumda aklimiza anonymous inenr class gelmesi gerekiyor
        // zaten enter'a bastigimizda biiiiiirsuru override method karsimiza cikiyor
        // Bu ne demek oluyor, bir sinif bvar ve bu sinif bu methodlarin heeepsini gerceklestiriyor
        // ve ben de bu siniftan bir object uretiyorum

        // Biz burada oyle yapmayacagiz ve bir somut sinif yardimi araciligiyla nesne uretecegiz

        Queue<Integer> sayilar = new LinkedList<>();
        // LinkedList de ayni zamanda queue'den turetildigi icin hem list hem de queue gibi calisabiliyor

        // eleman ekleyelim
        sayilar.offer(1);
        sayilar.add(2);
        sayilar.offer(2);
        sayilar.offer(3);
        sayilar.offer(3);
        sayilar.offer(23);


        System.out.println(sayilar); // ekledigimi sirada yazdirdi --> first in first out
        System.out.println(sayilar.peek()); // ilk elemani gosterir ve silmez
        System.out.println(sayilar.poll()); // ilk elemani gosterir ve gosterdikten sonra kuyruktan cikarir
        System.out.println(sayilar);
        // tum elemanlari ve hatta daha fazlasini listeden cikaralim, yani olmayan elmanalri da cikarmaya calisalim
        System.out.println(sayilar.poll());
        System.out.println(sayilar.poll());
        System.out.println(sayilar.poll());
        System.out.println(sayilar.poll());
        System.out.println(sayilar.poll()); // son elemani da cikardi
        // System.out.println(sayilar.remove()); // exception verir cunku olmayan bir degeri cikarmaya calisiyorum
        System.out.println(sayilar.poll()); // null dondurdu
        System.out.println(sayilar.poll()); // null dondurdu
        System.out.println(sayilar); // bos liste yazdirdi []
    }
    public static void priorityQueue()
    {
        PriorityQueue<String> isimler = new PriorityQueue<>();

        isimler.offer("Zeynep");
        isimler.offer("Ali");
        isimler.offer("Ayse");
        isimler.offer("Beyhan");
        isimler.offer("Beril");
        isimler.offer("Veli");
        isimler.offer("Tugba");
        // bunu soyle aklinda tutabilirsin: offer teklif demektir ve bu eleman kuyruga girebilmek icin teklif dunuyor
        // kuyruga girebilir miyim, lutfen beni de bu kuyruga alin diyor
        System.out.println(isimler); // [Ali, Ayse, Beyhan, Beril, Veli, Tugba]
        // udemy'de hocada sirayla yazdirmadi ancak bende sirayla yazdirdi ???
        // basina zeynep ekleyince bende de kafasi karisti ve siralama bozuldu
        // sirayla ayzdirmadigi icin hoca kuyrugu iterator ile gezmek istedi ve bu yapi bir list olmadigi icin list iterator'i degil
        // genel buyuk interface olan Iterable'daki iterator2i dogrudan kullandik
        System.out.println("while ile yazdirmayi deneyelim: ");
        Iterator<String> iterator = isimler.iterator();
        while(iterator.hasNext())
        {
            System.out.print (iterator.next() + ", ");
        }
        // hocada yine sirali calismadi ama bende sirali calisiyor ???
        // basina zeynep ekleyince bende de kafasi karisti ve siralama bozuldu

        // Normalde bekledigimiz sonuc alfabetik sirali olarak yazdirmasi
        // cunku String class'indaki comparator methodunun varsayilan calisma sekli bu
        // ancak java bize bunu garanti etmiyor :0 saskinim
        // biz eger tam olarak siralanmis bir cikti istiyorsak kuyrugun mantigini kullanmaliyiz
        // hadi yapalim

        System.out.println("Elemanlari pull ile cikararak yazdirmayi deneyelim :");
        while(!isimler.isEmpty()) // bos olana kadar elemanlari cikar demek
        {
            System.out.println(isimler.poll());
        }

        // asagiya remove ile de cikarmayi yazdik ama pull ile cikardiktan sonra
        // zaten hic eleman kalmayacagi icin bize bir sey yazdirmayacak, liste bos oldugu icin while hic calismayacak
        System.out.println("Elemanlari remove ile cikararak yazdirmayi deneyelim :");
        while(!isimler.isEmpty()) // bos olana kadar elemanlari cikar demek
        {
            System.out.println(isimler.remove());
        }

        // aslinda benim istedigim tek sey listeyi gormekti, cikarmak degildi
        // cikarmadan gorebilmemin bir yolu yok mudur
        // yoktur cunku boyle bir istegin varsa kuyruk yapisini kullanman mantikli olmaz
        // arrayList ile yapip collection.sort kullanarak siralama yapabilir ve sirali bir liste elde edebilirsin

        // peki bu sirali yapi nasil olusuyor
        // String class'i Comparable interface'ini implement ettiginden burada eleman eklerken bir onceki elemanla kiyas yapiyor




    }
    public static void ogrenciQueue()
    {
        // simdi kendi objem ile bir queue olusturmayi denyeylim
        Queue<Ogrenci> ogrenciKuyruk = new PriorityQueue<>();

        // ogr1= new blabla demedik, amacimiz objeyi elimizde tutmak, tekrar tekrar kullanmak degil, sadece listeye eklemek
        ogrenciKuyruk.offer(new Ogrenci(1,82));
        ogrenciKuyruk.offer(new Ogrenci(3,70));
        ogrenciKuyruk.offer(new Ogrenci(2,96));
        ogrenciKuyruk.offer(new Ogrenci(6,12));
        ogrenciKuyruk.offer(new Ogrenci(5,18));

        // adim1: ogrenci class'ini olusturduk
        // adim2: iki tane degisken tanimladik
        // adim3: kolayca obje olusturabilelim diye constructor tanimladik
        // adim4: HENUZ COMPARABLE CLASSİNİ İMPLEMENT ETMEDİK

        // dolayisiyla tam bu asamada calistirirsak class cast exeption aliriz
        // biz oncelikli bir kuyruk olusturduk
        // oncelikli kuyruklarda verilen data type a gore natural order yaparak ekleme yapar
        // ancak biz classimizin natural orderini henuz tanimlamadik
        // tanimlayabilmek icin clasimizin comparable interface'ini implement etmesi gerekiyor
        // bunu yaptigimizda mecburen compareTo methodunu override etmemiz gerekecek ve biz de siralama kuralimizi yazabilecegiz
        // hadi yapalim,  yaptik ve gelip kuyrugumuzu bir yazdiralim (yazdirmadan once toString'i de override etmeyi unutma)

        System.out.println(ogrenciKuyruk);
        // yazdirdik ama tam anlamiyla sirali cikmadi ve biz bu objeyi for dongusuyle filan da gezemeyiz, while dongusu kullanmamiz lazim

        System.out.println("while dongusu ve poll methodu ile sirali yazdirmayi deneyelim: ");
        while(!ogrenciKuyruk.isEmpty())
        {
            System.out.print(ogrenciKuyruk.poll());
        }
        // guzelce yazdirdigini gorduk
        // tam etrsi siralama istiyorsak compareTo methodundaki -1 ile 1 in yerini degistirebiliriz

        // ben yalnizca buraya ozel note gore degil de id'ye gore siralama yapmak istiyorsam soyle bir sey yapabilirim
        // constructor icine new Comparator yazarim ve override edilmesi gereken method kendiliginden gelir, anonymous a benziyor
        // sonra gider methodun icini degistiririm

        // aslinda hoca ogrenciKuyruk uzerinde bunu gosterdi ama
        // ben karismasin ve her ikisini de goreim diye yari bir kuyruk daha olustayim
        Queue<Ogrenci> ogrenciKuyruk2 = new PriorityQueue<>(new Comparator<Ogrenci>() {
            @Override
            public int compare(Ogrenci o1, Ogrenci o2) {
                if(o1.id < o2.id)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
                // butun id'ler unique oldugu icin ayni degerden bir tane daha olmadigi icin esitlik kosulunu hic yazmadik
            }
        });
        // benim sinifimda comparable olmasina ragmen o calismadi
        // comparable bir class'a uygulanir
        // comparator ise direkt olarak comparable'in uygulanmadigi veya uygulanmasini istemedigimiz durumlarda kullanilir
        // comparable da comparator da bir interface'dir
        // burada comparator soyut bir yapi oldugu icin ve bundan dolayi nesne uretemeyecegim icin anonymous class yardimiyla
        // methoda erisim sagladim
        // nesnenin icindeki comparable'a bakma buradaki comparator'in kurallarini uygula demis oldum
        // aynis eyi comparable ile yapamazdik

        ogrenciKuyruk2.offer(new Ogrenci(1,82));
        ogrenciKuyruk2.offer(new Ogrenci(3,70));
        ogrenciKuyruk2.offer(new Ogrenci(2,96));
        ogrenciKuyruk2.offer(new Ogrenci(6,12));
        ogrenciKuyruk2.offer(new Ogrenci(5,18));



    }
    static class Ogrenci implements Comparable<Ogrenci>
    {
        int id;
        int notDegeri;

        public Ogrenci(int id, int notDegeri) {
            this.id = id;
            this.notDegeri = notDegeri;
        }

        @Override
        public int compareTo(Ogrenci o) {
            if(this.notDegeri > o.notDegeri)
            {
                return 1;
            }
            else if(this.notDegeri < o.notDegeri)
            {
                return -1;
            }
            else
            {
                return 0;
            }

        } // artik priority queue onceligimi biliyor ve not degerine gore siralama yapacak

        @Override
        public String toString() {
            return "\nOgrenci{" +
                    "id=" + id +
                    ", notDegeri=" + notDegeri +
                    '}';
        }
    }
}

