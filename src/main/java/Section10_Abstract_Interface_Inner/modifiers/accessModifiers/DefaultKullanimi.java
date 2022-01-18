package Section10_Abstract_Interface_Inner.modifiers.accessModifiers;

class Main
{
    public static void main(String[] args)
    {
        DefaultKullanimi innerNesnesi = new DefaultKullanimi("asel",8); // erisim belirleyicisi public olan classtan bir nesne urettim
        /*
            public oldugu icin zaten her yerden erisebilmeyi bekliyorum
            innerNesnesi. dedigimde;
            * default degisken olan 'isim' desikenine
            * default method olan 'defaultIntMethod()' a
            * default method olan 'defaultVoidMemthod()' a
            * dwfault inner class olan 'defaultInnerClass{}' a
            erisebiliyorum

            Yani default olan hethangi bir yapi, ayni package icinden farkli bir class icerisinden cagirilabiliyor



         */
    }
}

public class DefaultKullanimi
{

    //default varible nedir:
    String isim = "Tugba"; // default degisken
    public int sayi=5; // public degisken
    public void publicMethod(){} // public method



    //default method nedir: methodumuzun basina herhangi bir erisim belirleyici keyword koymaz isek java bu methoda
    // icinde bulundugu paket icinden erisilebilecek bir sinir koyar. Bu methodlara paket disindan erisilemez
    void defaultVoidMethod1() {}

    int defaultIntMethod()
    {
        return 0;
    }

    class DefaultInnertClass
    {
        int defaultInnerDegisken = 1;
        void defaultInnerMethod(){}
    }

    public DefaultKullanimi(String isim, int sayi) {
        this.isim = isim;
        this.sayi = sayi;
    }
}


//default class nedir: classimizin basina herhangi bir erisim belirleyici keyword koymaz isek java bu classa
// icinde bulundugu paket icinden erisilebilecek bir sinir koyar. Bu classlara  paket disindan erisilemez, paket dısından kalitim alinamaz
class DefaultClass {}


// sub classtan da default degisken ve methoda erisebildigimizi asagidaki classi inceleyerek gorelim:
class SubClass extends DefaultKullanimi
{

    public SubClass(String isim, int sayi) {
        super(isim, sayi); // pubblic ve default degiskene erisildi
    }

    @Override // public methoda erisildi
    public void publicMethod() {
        super.publicMethod();
    }

    @Override // default methoda erisildi
    int defaultIntMethod() {
        return super.defaultIntMethod();
    }
}


