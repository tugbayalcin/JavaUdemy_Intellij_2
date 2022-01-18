package Section10_Abstract_Interface_Inner.sinavlar.sinav6;

public class Soru12
{
    public static void main(String[] args) {
        M m = new M();

        m.method(new A());

        m.method(new B());

        m.method(new Cclassi());
    }
}
class A { }

class B extends A { }

class Cclassi extends B { }

interface ABC
{
    void method(A a);
}

interface PQR
{
    void method(B b);
}

class M implements ABC, PQR
{
    public void method(A a)
    {
        System.out.println(2);
    }

    public void method(B b)
    {
        System.out.println(3);
    }
}
