package Section10_Abstract_Interface_Inner.sinavlar.sinav8;

public class Cevaplar
{
    public static void main(String[] args)
    {
        /*
            CEVAP 1: inner claslarda static method yer alamaz.
                     ancak static final olursa olur.

                     cunku program calistirildiginda ilk once statik alanlar olusturulur,
                     ancak biz daha inner classa erisebilmek icin bir nesne uretmemisiz ki icine girip icindeki static alanlari görebilelim,
                     göremeyiz

                     static finalise bir sabit oldugu icin dogrudan olusturulmasinda hicbir sakinca yoktur

            CEVAP 2: static demek sinifa ozgu demek, nesneden bagimsiz demek
                     dolayisi ile onlara erismek icin nesne tanimlamayaq gerek yok

                     önce yazdir sonra arttir!!!

            CEVAP 3: statik olmayan alanlara erisim icin oncelikle nesne olusturmaliyiz

            CEVAP 4: static bir inner class, dis classin yalnizca static elemanlarina erisebilir,
                     digerlerine erisebilmek icin dis classtan bir nesne uretmelidir

            CEVAP 5: kodda abstract class icerisinde anonymous inner class kullanimi var
                     abstract classlarda bulunan abstract methodlar mutlaka override edilmelidir
                     program calisacak, once statik alanlari sonra da default alanlari calistiracak

            CEVAP 6: Bir anonymous inner classtan yalnizca bir tsne nesne olusturabiliriz
                     Birden fazla nesneye ihtiyac duyuyorsak her biri icin yeniden anonymous inner class olusturmamiz gerekiyordu

            CEVAP 8: Local inner class kullanimi var.
                     Local inner classlarin yasam alani tanimlandiklari yapi ile sinirlidir.
                     Yapi disarisinda kullanilamaz ve nesne olusturamazlar

            CEVAP 9: Nesne olusturruldugunda ilk olarak static alan(2 yazdirdi), ardindan default alan(1 yazdirdi) ve
                     sonrasinda constructor(public X()) calisir
                     constructor tetiklendiginde Y sinifindan bir nesne uretiyor(icine kod o sekilde yazilmis)
                     Y classinda da statik ve default alanlar var. Bunlar da static-->default-->constructor sirasi ile calisacaklar

                     son kisimda Y den yeniden nesne olusuyor, burada once static alan sonra default alan calisacak diye
                     dusunursek hata yapariz
                     cunku static alanlar program calistirildigi anda ve yalnizca 1 kere calisir.
                     bu yüzden default alan calisacak ve ekrana 3 yazdiracaktir

            CEVAP 10: ABC den nesne uretildigi anda default block calisacak ve i degerini 1 azaltarak 101 yapacak
                      ardindan constructor calisacak --> o da i yi 1 azaltti: i=100
                      henüz i bir seye atanmadigi icin -- ifadesinin onde veya arkada olmasinin bir anlami yok

                      !!! XYZ den nesne uretildiginde i degerine once ABC de bulunan i degeri yani 100 atanacak
                      ardindan i iki sefer 1 arttirilacak, sonuc olarak i=102 olacak mi -->HAYIR !!!

                      XYZ classinin icinde direct olarak i yazilmis olsa idi evet yukarida yazdiklarimiz dogru olacakti
                      ancak int i = this.i denmis, yani bu siniftaki i diyor. Bu sinif dedigi sey XYZ
                      XYZ de i daha onceden tanimlanmis mi --> Hayir
                      Dolayisiyla aslinda i, bu sinif icerisinde default deger olan 0 degerini tutuyor ve iki kere
                      arttirma islemine maruz kaliyor. Boylece i nin son degeri i=2 olacaktir

                      son satirda ise yukaridaki iki satirda yapilan islem yeni bir nesne olusturularak tekrarlaniyor
                      yabi bunun da ciktisi 2 olacak

         */
    }
}
