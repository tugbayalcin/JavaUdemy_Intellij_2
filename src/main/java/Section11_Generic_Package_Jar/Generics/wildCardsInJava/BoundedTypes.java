package Section11_Generic_Package_Jar.Generics.wildCardsInJava;

import java.util.Collection;

public class BoundedTypes
{
    public static void main(String[] args)
    {
        /*
            Olusturulacak Generic yapiya sinir koymamizi saglayan bir yapidir
            Biz Generic bir class yaptik ama bu class olabilecek tum type'lardan olusmasin da (Wrapper-String-Kendi Type'im),
            sadece daha kisitli bir type grubundan biri olsun istiyorsak bounded type'lardan faydalaniriz
            mesela yalnizca numeric olan int-double-float-long-byte olsun gibi
            ve bu type'lar java.lang.Number sınıfını extend ediyorlar
            Bu durumda ben Numeric class'i bounded type olarak kullanabilirim

            Bounded Types, Generic kullanilan her yapida kullanilabilir. --> Method/Class/Interface

            MULTIPLE BOUNDS: Java burada coklu sinirlandirmaya izin vermektedir
        */
    }
    // public static <T extends Object & Comparable < ? super T > > T max(Collection<? extends T> coll) {...}
    // bu satir multiple bounded ornegi ancak ben anlamadim, <>'lari ayristiramadim ve return type nerede ?
}
// Nasil Kullanilir:
class Kare<T extends Number> // number olan type'lar gelsin diyor, String'le sporcuyla kare olmaz diyor
{
    public double alanHesapla(T uzunluk)
    {
        return uzunluk.doubleValue() * uzunluk.doubleValue();
    }
}
