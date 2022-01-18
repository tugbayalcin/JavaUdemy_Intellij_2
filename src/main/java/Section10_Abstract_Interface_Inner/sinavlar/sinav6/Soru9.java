package Section10_Abstract_Interface_Inner.sinavlar.sinav6;

public class Soru9
{
    public static void main(String[] args)
    {
        C c = new C();

        System.out.println(c.methodA());

        System.out.println(c.methodB());

        c = new D();

        System.out.println(c.methodA());

        System.out.println(c.methodB());
    }
}
interface Alfa
{
    String A = "AA";

    String methodA();
}

interface Beta
{
    String B = "BB";

    String methodB();
}

class C implements Alfa, Beta
{
    public String methodA()
    {
        return A+B;
    }

    public String methodB()
    {
        return B+A;
    }
}

class D extends C implements Alfa, Beta
{
    String D = "DD";

    public String methodA()
    {
        return D+methodB();
    }
}

