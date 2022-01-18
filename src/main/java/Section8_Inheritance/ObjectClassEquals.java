package Section8_Inheritance;

import java.util.Objects;

public class ObjectClassEquals // true-false dondurur/ override edildiginde icerik karsilastirmasi yapar, edilmediginde == gorevi gorur
{
    public static void main(String[] args)
    {
        Kisi k1 = new Kisi(5,"tugba");
        System.out.println(k1);

        Kisi k2 = new Kisi(5,"tugba");
        System.out.println(k2);

        Object k3 = new Kisi(5,"tugba"); // scope alani Object
        System.out.println(k3);

        Object k4 = new Kisi(5,"tugba"); // scope alani Object
        System.out.println(k4);

        System.out.println("k1 ile k2 esit mi:"+k1.equals(k2)); // override edilmediginde false
        System.out.println("k3 ile k4 esit mi:"+k1.equals(k2)); // artik Object icindeki method calisacagi ve o da
                                // default olarak yalnizca referannce lari karsilastirdigi icin icin false verecek

        // k1. dedigimizde hem objectteki hem de Kisi classindaki verilere erisebiliriz
        // ancak k3 dedigimizde heapte kisi kadar alan olusur ancak scopumuz Object kadardir.
        // biz yine de Kiai classinin icindekilere erismek istiyorsak, elimizle methodu yazabiliriz,
        // ancak type casting yapmamiz gerekir yoksa hata verir
        System.out.println("k3 ile k4 equalsMine ile esit mi:"+((Kisi) k3).equalsMine((Kisi)k4));

        k1=k2;
        System.out.println("k1 ile k2 esit mi:"+k1.equals(k2)); // override olmasa bile ayni referansi ikisine de atamis oldum true
        System.out.println("k1'in hashcodu:"+k1.hashCode()+" k2'nin hashcodu:"+k2.hashCode());
        System.out.println("k1 ile k2 equalsMine ile esit mi:"+k1.equalsMine(k2));

        //ISTISNA1-STRING CLASS
        String isim = new String("tugba");
        String isim2 = new String("tugba");
        System.out.println("isimler esit mi:"+ isim.equals(isim2)); // burada aslinda bilgilerimize bakarak eger bu
        // classta toString methodumuz yoksa false gormemiz gerekecekti ancak true goruyoruz
        // cunku String kendi basina bir class ve bu classin toString methodu kendi icinde override edilerek ozellesmis bir method
        // String ifadeler gorunuste bellekte iki farkli yeri gostertseler de(aslinda gostermiyorlar, bir string string poolda
        // yalnizca 1 kere olusturulur) String class equalsi icerik karsilastirmasi yaptigi icin  daima true cikacaktir

        // ISTISNA2-WRAPPER CLASSLAR
        Integer sayi1 = new Integer(1);
        Integer sayi2 = new Integer(1);
        System.out.println("sayilar esit mi: " + sayi1.equals(sayi2));
        // yukarıda bellekteki yerleri farkli olmasina ragmen true sonucu verdi, referanslar degil icerikler kartsilastirildi

    }
}
class Kisi extends Object {
    int id;
    String isim;

    public Kisi() {
    }

    public Kisi(int id, String isim) {
        this.id = id;
        this.isim = isim;
    }

    @Override
    public String toString() {
        return "Kisi{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kisi kisi = (Kisi) o; // down casting
        return id == kisi.id && Objects.equals(isim, kisi.isim);
    }

    // burada parametre olarak equals(Kisi obj) vermek isteyebiliriz ancak hata aliriz.
    // Override etmenin kurali methodun parametrer sayisini ve parametre tipini degistirmemektir,
    // boylece yeni method ust sinifla eslesmeye devam eder
    // biz yine de Kisi obj ile devam etmek istiyorsak @override ifadesini sileriz.
    // Boylece kendimiz sipsifirdan bir method yazmis gibi oluruz
    // Asagida equalsMine seklinde yaptim, gorebilirsin,
    // Classin direk Kisi oldugunu bildigimiz icin bazi kontrollere gerek kalmadi ve kodm kisaldi
    public boolean equalsMine(Kisi o) {
        if (this == o) return true;
        return id == o.id && Objects.equals(isim, o.isim);
    }

        @Override
        public int hashCode ()
    {
        return Objects.hash(id, isim);
    }
}
class Calisan {
        int id;
        String isim;

        public Calisan() {
        }

        public Calisan(int id, String isim) {
            this.id = id;
            this.isim = isim;
        }
    }
