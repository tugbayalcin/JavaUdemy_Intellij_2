package Section12_CollectionFramework.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class C133_CollectionsMethods
{
    public static void main(String[] args) {

        Student student1 = new Student(1, "Abdullah");
        Student student2 = new Student(9, "Sinem");
        Student student3 = new Student(5, "Ezgi");

        ArrayList<Student> ogrenciler = new ArrayList<>();
        ogrenciler.add(student1);
        ogrenciler.add(student2);
        ogrenciler.add(student3);

        // Collections.max() ---------------------------------------------------------------------------------------
        Student enBuyukOgrenci = Collections.max(ogrenciler, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.isim.compareTo(o2.isim)<0)
                {
                    return -1;
                }
                else if(o1.isim.compareTo(o2.isim)>0)
                {
                    return 1;
                }
                else
                    return 0;
            }
        });
        System.out.println("Max Ogrenci: " + enBuyukOgrenci);
        // Collections classinin max methodu parametre olarak aldigi arraylist icindeki en buyuk elemani dondurur
        // ama bunun icin wrapper classlar veya String class'i ile calismiyorsak, kendi olusturdugumuz bir class ile calisiyorsak
        // bu class ya Comparale interface'ini implement etmeli (compareTo() methodunu override etmeli)
        // ya da Comparater interface'ini kullanarak bir anonymous class uretmeli ve yalnizca bu objeye ozgu,
        // tek kullanimlik bir siralama methodu olarak compare() methodunu override etmeli

        // ----------------------------------------------------------------------------------------------------------

        // Collections.min() ---------------------------------------------------------------------------------------

        // yukarida anonymous class ile yaptiklarimiz yalnizca o obje işcin gecerli oldugundan burada min()
        // methodunu kullanmaya calistigimizda compiler yine kirmizi yakacak
        // cunku ben burada neye gore karsilastirma yapacagimi bilmiyorum diyor
        // cozum yontemleri ise yine ayni sekilde
        // ya Comparale interface'ini implement edecegiz ya da yenişden anonymous class kullanacagiz

        Student enKucukOgrenci = Collections.min(ogrenciler);
        System.out.println("En Kucuk Ogrenci: " + enKucukOgrenci);
        // ----------------------------------------------------------------------------------------------------------

        // Collections.sort() ---------------------------------------------------------------------------------------

        System.out.println("Isim ile siralamadan once liste: " + ogrenciler);
        Collections.sort(ogrenciler);
        System.out.println("Isim ile siraladiktan sonra liste: " + ogrenciler);
        // artik bizim classimiz Comparable'i  implement ediyor ve compareTo() methodu isim degiskenine gore siralama yapiyor
        // peki ben isme gore degil de id'ye gore siralamak istersem ne yapacagim?
        // yukaridaki kodlarim isim siralamasina gore calisan override methodumu kullaniyor, yani methodumu da degistiremem,
        // kodum bozulur
        // iste bu gibi durumlarda anonymous class olusturarak compareTo() methodunu istedigimiz degiskene gore override
        // ederek kulanabiliriz
        System.out.println("Isim ile siraladiktan sonra, id ile siralamadan once liste: " + ogrenciler);
        Collections.sort(ogrenciler, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.id < o2.id)
                    return 1;
                else if(o1.id > o2.id)
                    return -1;
                else return 0;
                // buyukten kucuge dogru siralayalim istedik ve kodumuzu ona gore yazdik
            }

        });
        System.out.println("id ile siralamdiktan sonra liste: " + ogrenciler);

        // ----------------------------------------------------------------------------------------------------------

        // Collections.shuffle() ------------------------------------------------------------------------------------

        // liste elemanlarini karistirir, her run ettigimizde yeniden karistirarak farkli bir siralama ile listeyi dondurur
        Collections.shuffle(ogrenciler);
        System.out.println("Karistirildiktan sonra liste: " + ogrenciler);

        // ----------------------------------------------------------------------------------------------------------

        // Collections.binarySearch() -------------------------------------------------------------------------------

        // Bir collection yapisinda eleman aramak istedigimizde, contains() gibi methodlar tum yapiyi
        // bastan sona (lineer olarak) gezerek elemani bulmaya calisir. Ancak cok fazla eleman oldugu zaman bu yontem kullanisli olmaz
        // Bu yuzden binarySearch() gibi arama yontemleri kullaniriz, ancak binarySearch() kullanabilmek icin bir sartimiz vardi
        // o sart da yapinin sirali olmasi idi
        // sort ile yapiyi siraladiktan sonra
        // hic sikinti olmadan binarySearch() dogru bir sekilde calisacaktir
        // calistirlmamis olsa idi yanlis sonuc dondurecekti, sort'dan sonra shuffle yaparak listeyi karistirdigimizda ise
        // birkac denemede dogru sonuc verdigini dusunebiliriz ancak karistirarak denemeye devam ettigimizde yanlis sonuc verdigini goruruz
        // binarySearc() aranilan elemanin index'ini dondurur
        // eleman collection icinde yok ise de, olsaydi nerede olurdu diye bir hesaplama yaparak negatif bir deger dondurur

        Collections.sort(ogrenciler);
        int sonuc = Collections.binarySearch(ogrenciler,student2);
        System.out.println("Sonuc: " + sonuc);

        // ----------------------------------------------------------------------------------------------------------

        // Collections.reverse() ------------------------------------------------------------------------------------

        Collections.reverse(ogrenciler);
        System.out.println("Ogrenciler listesi ters siralandi: " + ogrenciler);

        // ----------------------------------------------------------------------------------------------------------

        // Collections.copy() ---------------------------------------------------------------------------------------

        ArrayList<Student> yedekListe = new ArrayList<>(); // kopyalanacak yedek liste oluısturuldu
        yedekListe.add(new Student(6,"ayse"));
        yedekListe.add(new Student(22,"fatma"));
        yedekListe.add(new Student(8,"ela"));
        yedekListe.add(new Student(9,"leyla"));
        Collections.copy(yedekListe,ogrenciler); // once yedek, sonra kopyalanacak dizi paraöetre olarak veriliyor
        // ancak burada onemli bir detay var yedek listenin size'i kaynak listenin size'indan buyuk veya esit olmak zorundadir
        // yoksa exception firlatir ve kopyalama yapilmazs
        System.out.println("yedekListe: " + yedekListe);
        // elemalari eklememis, yedekListe'nin ilk 3 elemanini, kaynak listenin ilk 3 elemani ile degistirmis
        // yani yedek listenin elemanlarini kaynak liste elemanlarini kullanark set etmis
        // yedek listedeki geri kalan elemanlara dokunmuyo, onlar oldugu gibi kaliyor

        // eger ben yalnizca ogrencilerin birebir kopyasini almak istersem su yolla cok kolay bir sekilde yapabilirim
        ArrayList<Student> yedekListe2 = new ArrayList<>(ogrenciler);
        // yedek liste olusturulurken ogrenciler'in copy'si olarak olusturuldu
        // ogrenciler'i constructor'in icine koyduk
        System.out.println("yedekListe2: " + yedekListe2);









    }
}




class Student implements Comparable<Student>
{
    int id;
    String isim;

    public Student(int id, String isim) {
        this.id = id;
        this.isim = isim;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(this.isim.compareTo(o.isim) <0)
        {
            return -1;
        }
        else if(this.isim.compareTo(o.isim) >0)
        {
            return 1;
        }
        else return 0;
    }
}
