package Section10_Abstract_Interface_Inner.nestedClass.staticNestedClass;

public class StaticDahiliSiniflar
{
    public static void main(String[] args)
    {
        CerceveSinif cerceveSinif = new CerceveSinif();
        cerceveSinif.nesneDegiskeni = 5;
        cerceveSinif.method();
        cerceveSinif.staticMethod(); // nesne ile eristim
        CerceveSinif.staticMethod(); // class adi ile eristim


        // ic sinifa eriselim, bunun icin bir nesne uretmek zorundayiz
        CerceveSinif.IcSinif icSinif = new CerceveSinif.IcSinif();
        icSinif.icSinifNesneDegiskeni = 5;
        icSinif.icSinifMethodu();
        CerceveSinif.IcSinif.icSinifStaticMethodu(); // static alanlara da erisebiliyorum
        CerceveSinif.IcSinif.icSinifStaticDegisken = 52; // static alanlara da erisebiliyorum





    }

}
