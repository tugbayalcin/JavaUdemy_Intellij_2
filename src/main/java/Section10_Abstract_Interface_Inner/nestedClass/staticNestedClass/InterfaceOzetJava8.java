package Section10_Abstract_Interface_Inner.nestedClass.staticNestedClass;

public class InterfaceOzetJava8
{
    public static void main(String[] args)
    {
        // interface ler yuzde yuz abstract ytapilardir
        SinifA a = new SinifA();
        a.methodA();
        InterfaceA.staticMethod();
    }
}
interface InterfaceA
{
    void methodA(); // interface icindeki standart methodlar soyut olur ici doldurulamaz
    default void defaultMethodA() // java 8 den sonra default method ile ici doldurulabilir method yazabilmeye basladik
    {
        System.out.println("Ben default methodum");
    }
    static final int sayi = 10; // degisken tanimlayabiliriz ancak static ve final olmak zorundadir. tanimlandigi anda atamasi yapilmalidir
    static void staticMethod() // java 8 den sonra interface icerisinde static methodlar tanimlayabiliyoruz
    {
        System.out.println("Ben static methodum");
        // dogrudan interface adi ile cagirilip kullanilabilir.
    }


}
class SinifA implements InterfaceA
{
    @Override
    public void methodA()
    {
        defaultMethodA(); // bunu biz yazdik
    }

    // static method buraya override edilemez

    @Override
    public void defaultMethodA() {
        System.out.println("Ben a sinifi icindeki default methodum ");
    }
}
