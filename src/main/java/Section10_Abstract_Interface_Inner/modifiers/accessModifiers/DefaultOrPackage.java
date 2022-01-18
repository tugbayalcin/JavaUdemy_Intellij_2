package Section10_Abstract_Interface_Inner.modifiers.accessModifiers;

public class DefaultOrPackage
{
    // basina hicbir sey yazilmqyqnlqr java tarafindan default olarak kabul edilir
    // private dan biraz daha esnektir
    // ayni paket icinde olmak kosulu ile herkes herkese erisebilir
    int sayi =5;
    void method (){}
}
class Y extends DefaultOrPackage
{
    @Override
    void method() // methodlari override edebiliyorum
    {
        super.method();
        System.out.println(sayi); // sayiya buradan erisebiliyorum
    }

}
class InnerClass{}
