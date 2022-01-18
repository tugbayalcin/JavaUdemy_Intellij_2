package Section10_Abstract_Interface_Inner.modifiers.accessModifiers;

public class PublicKeywordKullanimi
{
    // public: Bana heeeeerrr yerden erisebilirsin demek

    //public variable:
    public int a =1;
    public static int b = 2;
    public static final int C = 3;

    //public method:
    public void publicVoidMethod(){} // geriye deger dondurmeyen public method
    public int publicIntMethod(){ return 0;} // geriye integer deger donduren public method
    public static void staticVoidMethod(){} // geriye deger dondurmeyen public ve static method
    public static int staticIntMethod(){return 1;} // geriye deger donduren public ve static method

    //public class:
    public class InnerClass{} //
    public static class StaticClass{}
    public static final class StaticFinalClass{}

    public abstract class PublicAbstractClass{}
    public static abstract class PSAClass{}

    public interface IPublicInterface{}
    public static interface IPublicStatic{} // diyor ki interfaceler icin static tanimlamasi yapmana gerek yok
    public static abstract interface IPublicStaticAbstract{}






}
