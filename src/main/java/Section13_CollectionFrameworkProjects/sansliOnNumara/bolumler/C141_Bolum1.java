package Section13_CollectionFrameworkProjects.sansliOnNumara.bolumler;

public class C141_Bolum1
{
    /*
        Adim 1: HashMap olusturuldu, class seviyesinde ve static olarak olusturuldu
                bunun sebebi class icinde olusturacagimiz tum methodlar icerisinden erisilebilir olmasini istememiz
                ayni zamanda class'a ait bir yapi oldugu icin herhangi bir objenin yaptigi degisiklik tum sinifi etkileyecek
                yani degisiklik herkes icin gecerli olmus olacak ki ornegimiz icin ihtiyacimiz olan ozellik tam da bu
                --> class seviyesine global alan da denir ve burada yaptigimiz tanimlamalar isimizi oldukca kolaylastirir
                    ancak algoritma yetenegimizi gostermemizi engeller, basite kacmak gibidir,
                    hatta okullarda hocalar soru cozumunde bu global alanin kullanimini kisitlarlarmis ki algoritma
                    kurularak cozum yontemi olusturulabilsin
                Biz class seviyesinden alip main icerisinden tanimlayarak sorumuzu cozmeye devam edelim

        Adim 2: mapiSayilarlaDoldur() methodu olusturuldu
        Adim 3: sayiOlustur() methodu olusturuldu
               * Burada URETILERCEK_SAYI_MAX_SINIR final static degisken olarak class seviyesinde tanimlandi
                 Ancak ben methoda parametre olarak gecmeyi tercik ederidm
               * URETILERCEK_SAYI_MIKTARI final static degisken olarak class seviyesinde tanimlandi

        Adim 4: sayilarlaDoldur() methodu icerisinde for dongusu ile 1 milyon kez sayi olusturulmasi saglandi




     */
}
