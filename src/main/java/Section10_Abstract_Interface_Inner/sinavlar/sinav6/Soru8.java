package Section10_Abstract_Interface_Inner.sinavlar.sinav6;

public class Soru8
{
    public static void main(String[] args) {
        Y y = new Y(); // nesne olusurken hemen extend edilen classtan baslanir ve default blok ile  constructor calistirilir

        System.out.println(y.methodX());

        System.out.println(y.c);

        System.out.println(X.c);
    }
}
interface X
{
    char c = 'A';

    char methodX();
}

class Y implements X
{
    {
        System.out.println(c); // default blokta ekrana c yi yazdiran kod var, ilk ciktim buradan geliyor
    }

    public char methodX()
    {
        char c = this.c;

        return ++c;
    }
}

// cevap: A B A A