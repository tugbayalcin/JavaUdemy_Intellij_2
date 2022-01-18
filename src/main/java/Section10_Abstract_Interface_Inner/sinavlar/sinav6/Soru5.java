package Section10_Abstract_Interface_Inner.sinavlar.sinav6;

public class Soru5
{
    public static void main(String[] args)
    {
        R r = new R();

        System.out.println(r.methodA());

        System.out.println(r.methodB());
    }
}
interface InterfaceA
{
    String p = "AA";

    String methodA();
}

interface InterfaceB extends InterfaceA
{
    String q = "BB";

    String methodB();
}

class R implements InterfaceA, InterfaceB
{
    public String methodA()
    {
        return q+p;
    }

    public String methodB()
    {
        return p+q;
    }
}


// cevap: BBAA
//        AABB