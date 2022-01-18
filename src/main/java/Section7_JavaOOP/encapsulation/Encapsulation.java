package Section7_JavaOOP.encapsulation;


//import Section7_JavaOOP.Ogrenci;

public class Encapsulation
{
    public static void main(String[] args)
    {
        // oncelikle veri turunu yazip bundan bir nesne olusturmaliyiz.
        // elimizde herhangi bir televizyon yok ama televizyonda olmasi gerekenleri tutan bir taslagimiz var
        Television tv = new Television();
        tv.ac(); // method
        tv.setSesSeviyesi(15); // private instance degiskeni kullanabilmemizi saglayan method
        tv.setKanal(5); // private instance degiskeni kullananabilmemizi saglayan method
        tv.kapat(); // method

        tv.goster();

    }
    public static void encapsulation() // burayi calistirmak istediginde main icinden cagir
    {
        // Classimda bulunan degiskenlerimin yalnizca sinifima ozgu  olmasini ve dsaridan  cagirilamamasinisaglar
        // Degiskenleri class icinde her yerde kullanayim ama class disina ciktigimda isim. dedigimde kimse bir sey gormesin
        Ogrenci ogr0= new Ogrenci();
        // ogr0. diyerek class icindeki butun alanlara erisebiliyoruz
        // eger degiskenimin basina private keywordu koyarsam, o degisken kendi classina ozel olur ve disaridan erisilemez
        // ogr0. dedigimde artik class degiskenlerine erisemiyorum, cunku onlari private yaptik
        // peki o zaman ne yapacagiz
        // constructor methodunu kullanarak o classin maininin calismasini saglayabiliriz
        Ogrenci ogr1= new Ogrenci(50,"tugba",(byte)3,true);
        ogr1.OgrenciBilgileriniYazdir();

        // ancak bu kullanim da her zaman saglikli degildir.
        // ogrenci sinif atladi ve biz private yuzunden sinif degiskenine deger atayamiyoruz
        // tekrar constructor kullanarak bu seferinde sinifi degistirir isek constructor bunu yeni bir ogrenci olarak algilar
        // ayni ogrencide degisiklik olarak algilamaz ve sorun olusur

        // ama ben illa ki o verileri kullanmak, okumak veya yazmak istiyorum peki bunu nasil yapacagim
        // class icinde tanimlanmis methodlarla
        // bunun icin set method public olarak tanimlanmali ki dısaridan erisilebilsin

        ogr1.setOgrenciNo(10); // buradan artik ogrenciNo'ya deger atayabilirim
        ogr1.OgrenciBilgileriniYazdir(); // simdi sikinti cikmadan yazdiracaktir
        System.out.println("Ogrenci No: " + ogr1.getOgrenciNo());

        // NOT: Get methodu return ile calısabildiği icin system.out.println kisminda hata vermez,
        // ancak set methodunu burada yazamayiz.
        // yazdirabilmek icin methoda ihtiyacimiz vardir


        // ***** ozetle degiskenlerimi olasi degisikliklerden korumak amaci ile erisilemez yaptigim, gizledigim,
        // ve onlara uzaktan erisim saglanarak kullanilabilmesini mumkun kilmak icin methodlar tanimladigim yapiya encapsulation denir

        // java her konuda bize yardimci olan bir dildir
        // classimizin icinde sol tiklayip generate secenegini secersek karsimiza harikulade seyler ciktigini goruruz
        // bu segment bize otomatik olarak construction, getter method, setter method,
        // getter ve setter methodlarini birlikte, ve cok daha fazlasini otomatik olarak olusturur

        ogr1.setIsim("yeni isim");
        ogr1.OgrenciBilgileriniYazdir();

    }

}
class Television
{

    // kullanici tv kapaliyken kanal secmeye, ses degistirmeye veya var olmayan sayida bir kanal acmaya calisabilir
    // boyle durumlari engellemek icin bu degiskenleri kullanicidan saklamali ama objectime gostermeliyim
    // iste burada devreye private giriyor

    private int kanal; // instance degisken
    private int sesSeviyesi; // instance degisken
    private boolean acik; // instance degisken

    public void ac()
    {
        if(acik==false)
        {
            System.out.println("Televizyon Açılıyor");
            acik = true;
        }
        else
        {
            System.out.println("Televizyon zaten açık");
        }

    }
    public void kapat()
    {
       if(acik==true)
       {
           System.out.println("Televizyon Kapanıyor");
           acik = false;
       }
       else
       {
           System.out.println("Televizyon Zaten Kapalı");
       }

    }
    public void setKanal(int yeniKanal)
    {
        if(acik && yeniKanal > 0 && yeniKanal<500)
        {
            kanal = yeniKanal;
        }
        else
        {
            System.out.println("TV Kapalı veya Yanlış Bir Kanal Değeri Girdiniz");
            kanal=1;

        }

    }
    public int getKanal()
    {
        return kanal;

    }
    public void setSesSeviyesi(int sesSeviyesi)
    {
       if(acik && sesSeviyesi>0 && sesSeviyesi<20)
       {
           this.sesSeviyesi = sesSeviyesi;
       }
       else
       {
           sesSeviyesi=1;
       }


    }
    public int getSesSeviyesi()
    {
        return sesSeviyesi;

    }
    public void setAcik(boolean acik)
    {
        this.acik = acik;

    }
    public boolean isAcik()
    {
        return acik;

    }
    public void goster()
    {
        System.out.println("TV açık: " +acik + "Kanal Numarası:" + kanal + "Ses Seviyesi: " + sesSeviyesi);
    }
}
