package Section10_Abstract_Interface_Inner.comparable_comparator;

public class ComparableVSComparator
{
    /*
        COMPARABLE
        * 1 tane methodu vardir: compareTo(param1) --> Tek parametre alir
        * Bir elemanin digerleriyle nasil karsilastirilacagini javaya soylemis oluruz
        * Bir nesnenin benzer turdeki nesnelerle karsilastirilmasi icin kullanilir (sinifin kendi elemanlarini karsilastirmasi gibi)
        * Kendi objemi siralamak istedigimde kullanislidir
        * (Ogrenci classinin ogr1,ogr2,... objelerinden bir arrayList yapip siralamak istedigimde etc)

        COMPARATOR
        * 8 tane methodu  vardir: compare(param1, param2) --> Iki parametre alir
                                  reversed()
                                  thenComparing(Comparator other)
                                  thenComparingInt(ToIntFunction keyExtractor)
                                  thenComparingLong(ToLongFunction keyExtractor)
                                  thenComparingDouble(ToDoubleFunction keyExtractor)
                                  thenComparing(Function keyExtractor)
                                  thenComparing(Function keyExtractor, Comparator keyComparator)
        * Soyle bir objem oldugunu dusunelim:
          -----------------------------------------------
          public Kisi(String isim, int yas) {
          this.isim = isim;
          this.yas = yas;
          }
          -----------------------------------------------
          Kullanimi:
          Collections.sort(aile);
          -----------------------------------------------
          Yani hem String isim degiskeni hem de Integer yas degiskenlerini iceriyor
          en comparable interface'ini implement ettigimde compareTo methodu ile karsilastirma yaptirabilmek icin
          bu degiskenlerden birini secmem gerekecekti
          ve sişralamam bunbdan sonra daima o degiskene gore yapilmis olacakti
          Peki ben bazen isme gore bazen de yasa gore siralama yapmak istedigimde ne yapabilirim:
          O zaman yardimimiza Comparator interface'i yetisiyor.
          Kullanimini gorelim:
          ----------------------------------------------- getIsim()'e gore
          import java.util.Comparator;
          public class IsimComparator implements Comparator<Kisi> {
          @Override
          public int compare(Kisi o1, Kisi o2) {
          return o1.getIsim().compareTo(o2.getIsim());           --> Burada dikkat edersen o1 objesi ile once karsilastirma yapmak
          }}                                                     istedigimiz degiskeni ardindan da karsilastirma methodunu cagiriyoruz
          -----------------------------------------------

          ----------------------------------------------- getYas()'a gore
          import java.util.Comparator;

          public class YasComparator implements Comparator<Kisi> {
          @Override
          public int compare(Kisi o1, Kisi o2) {

          if(o1.getYas()>o2.getYas())
              return 1;
          else if(o1.getYas()<o2.getYas())
              return -1;
          else
              return 0;
          }}
          -----------------------------------------------
          Kullanimi:
          Collections.sort(aile,new YasComparator()); // yaşa göre sıralama yapar
          Collections.sort(aile,new IsimComparator()); // isme göre sıralama yapar





     */
}
