package Section8_Inheritance;

public class e_Binding_Polymorphism
{
    public static void main(String[] args)
    {
        //<editor-fold defaultstate="collapsed" desc="early(compile time-static and final method)-late(run time-overrideable methods)binding">


        //kısacası polimorphism olayında alt sınıflardan sadece override edilmiş methodlara eritilir
        /*
            Static veya Early Binding veya Erken Bağlama
            static ve final metotlar compile time da bind edilir. Çünkübu metotlar override edilemezler.
            Bundan dolayıdaha kodu yazarken hangisinin çalıştırılacağıbellidir.
        */

        /*
            Dynamic Late Binding Geç Bağlama
            Her sınıf gizli bir kalıtımla Object sınıfından türetilebilir demiştik. Ve object sınıfının toString metotu bulunmaktaydı. Oluşturacağımız tüm sınıflar bu metotu override ederek kendi isteklerine göre değiştirebilirdi. Peki:

            Object obj=new GeometrikSekil();
            System.out.println(obj.toString());
            bu ifade de Object sınıfının mıyoksa GeometrikSekil sınıfının mıtoString metotu çağrılacak ? Gelin bu sorunu inceleyelim...

            Object obj=new GeometrikSekil();
            Object obj;
            obj=new Object();
            Her değişkenin mutlaka bir veri türüolmalıdır. Buna declared type denir.
            Değişken adımız obj, declared type : Object
            Bu değişken türüreferans tipli olduğu için ya null ya da declare edilmişveri türünden olan bir nesnenin referansınısaklar. Ayrıca declare edilmişsınıfın alt sınıflarının referanslarınıda saklayabilir.
            Geometrik şekil Object sınıfının alt sınıfıolduğu için sorun çıkmayacaktır. Ve obj değişkenin declared tipi Object bile olsa aslında GeometrikSekil türündeki nesneyi gösterir. Bundan dolayı;
            Değişken adımız obj, actual type : GeometrikSekil
            obj.toString() çağrıldığında hangi sınıftaki metotun tetikleneceği obj nesnesinin actual type'ına göre belirlenir. Yani obj.tostring çağrıldığında GeometrikSekil sınıfının toString metotu tetiklenir.
            Bu durumadinamik bağlama veya dynamic bindingdenir.Kısacasıkalıtım zincirinde bir metotun farklısınıflarca kullanılmasıdurumunda JVM'nin çalısma anında hangisini çalıstıracağına karar vermesi olayıdır.
            Birden fazla üst sınıf olduğunda cagrılan metot en alt sınıftan en üst sınıfa doğru aranır. Bulunmazsa bir üst sınıfa bakılır.

            Static binding compile zamanı, dinamik binding çalışma zamanında olur
            •
            Static bağlama static ve final metotlarda olur çünkü bunlar değiştirilemez.
            Dinamik binding çalışma anında değişkenin nesneye bağlandığızaman override edilmişmetotlar sayesinde olur.
            •
            Farkları
            Static binding compile zamanı(yesil oka basmadan), dinamik binding çalışma zamanında olur
            Static bağlama static ve final metotlarda olur çünkü bunlar değiştirilemez.
            Dinamik binding çalışma anında değişkenin nesneye bağlandığızaman override edilmişmetotlar sayesinde olur.
        */

        UstSinif.StaticMethod();//nesnesiz cagırdım static methodu
        //Üst sınıfın static adını söyle metotu çağrıldı
        AltSinif.StaticMethod();//nesnesiz cagırdım static methodu
        //Alt  sınıfın static adını söyle metotu çağrıldı

        UstSinif ustSinifNesnesi=new UstSinif();
        ustSinifNesnesi.StaticMethod();//nesneyle cagırdım statik metodu
        //Üst sınıfın static adını söyle metotu çağrıldı

        AltSinif altSinifNesnesi=new AltSinif();
        altSinifNesnesi.StaticMethod();//nesneyle cagırdım statik metodu
        //Alt  sınıfın static adını söyle metotu çağrıldı


        UstSinif ustSinif=new AltSinif();
        ustSinif.StaticMethod();//adiniSoyleStatic() bu method altsınıfta override edilemez.oyuzden üst sınftaki adiniSoyleStatic() cagrılır
        //Üst sınıfın static adını söyle metotu çağrıldı
        //STATIC - EARLY BINDING - COMPILE TIME BINDING - BECAUSE ustSinif object will not search for adiniSoyleStatic() method into other classes

        System.out.println(ustSinif.a);//UstSınıf
        //late binding olayı sadece overriding olayında olur
        //superclass'ta String a var subclass'ta da String a var ama overriding olayı yok.
        System.out.println(altSinifNesnesi.a);//AltSinif

        ustSinif.nonStaticMethod();//adiniSoyle() methodu static degil ve override edildi.als sınıftaki method cagrıldı.
        //Alt  sınıfın  1.non-static metotu çağrıldı
        //DYNAMIC - LATE BINDING - RUN TIME BINDING

        /**/ustSinif.nonStaticMethod2();//Üst sınıfın  2.non-static metotu çağrıldı static değil ve belirtilen alt sıınıfta bakıcak.baktı yok bi üste cıktı üstte var ve yazdırdı.2 alt sınıfta var aslında  bu method ama oraya bakmaz

        UstSinif ustsınıf=new AltSinif2();
        //DYNAMIC - LATE BINDING - RUN TIME BINDING
        ustsınıf.nonStaticMethod();//2 Alt  sınıfın  non-static 1.metotu çağrıldı
        ustsınıf.nonStaticMethod2();//2 Alt sınıfın  non-static 2.metotu çağrıldı
        ustsınıf.nonStaticMethod3();//Alt sınıfın  non-static 3.metotu çağrıldı-bu method altsinif2 de yok,üst sınıfta var.AMA altsınıf2'den direk EN üst sınıfa atlamaz teker teker bakar.
        ustsınıf.methodOfustSinif();//üst sınıfın kendine has methodu-bu method altsinif2 de yok-altsinifta yok üst sınıfta var ve yazdırdı
        //STATIC - EARLY BINDING - COMPILE TIME BINDING
        ustsınıf.StaticMethod();//MANUEL YAZDIM-Üst sınıfın static  metotu çağrıldı



// </editor-fold>
    }
}
        //<editor-fold defaultstate="collapsed" desc="bindingTypes">



class UstSinif
{
    /*
    Bir nesne örneğinin hangi nesneye bağlandığıve hangi nesneye ait olduğunun
    çalışma anında belirlenmesidir.(Runtime)
    k1.alanHesapla() --> bu ise derleme zamanında belirlenir(Compile time)
    */
    String a="UstSınıf";
    public static void StaticMethod()//üst-alt'ta var
    {
        System.out.println("Üst sınıfın static  metotu çağrıldı");
    }

    public void nonStaticMethod()//üst-alt-alt2'ta var
    {
        System.out.println("Üst sınıfın  1.non-static metotu çağrıldı");
    }

    public void nonStaticMethod2()//üst-alt2
    {
        System.out.println("Üst sınıfın  2.non-static metotu çağrıldı");
    }
    public void nonStaticMethod3()//üst-alt
    {
        System.out.println("Üst sınıfın  3.non-static metotu çağrıldı");
    }
    public void methodOfustSinif()
    {
        System.out.println("üst sınıfın kendine has methodu");
    }

}

class AltSinif extends UstSinif
{
    String a="AltSinif",b="AltSinif";

    //static method override edilmemez
    public static void StaticMethod()
    {
        System.out.println("Alt  sınıfın static metotu çağrıldı");
    }


    @Override//stataic olmayan method override edildi
    public void nonStaticMethod()
    {
        System.out.println("Alt  sınıfın  1.non-static metotu çağrıldı");
    }

    @Override
    public void nonStaticMethod3() {
        System.out.println("Alt  sınıfın  3.non-static metotu çağrıldı");
    }

}

class AltSinif2 extends AltSinif
{

    @Override//stataic olmayan method override edildi
    public void nonStaticMethod()
    {
        System.out.println("2 Alt  sınıfın  non-static 1.metotu çağrıldı");
    }
    @Override
    public void nonStaticMethod2() {
        System.out.println("2 Alt sınıfın  non-static 2.metotu çağrıldı");
    }

}

// </editor-fold>
