package Section10_Abstract_Interface_Inner.sinavlar.sinav6;

public class Soru11 {
    public static void main(String[] args) {


        Aclass a = new Cclass();

        a.myMethodX(new Integer(121));

        Bclass b = new Cclass();

        b.myMethodX(new Integer(121));

        Cclass c = new Cclass();

        c.myMethodX(new Integer(121));

    }
}
    abstract class Aclass
    {
        abstract void myMethodX(Number N);
    }

    interface Bclass
    {
        abstract void myMethodX(Object O);
    }

    class Cclass extends Aclass implements Bclass
    {
        void myMethodX(Number N)
        {
            System.out.println("Number");
        }

        public void myMethodX(Object O)
        {
            System.out.println("Object");
        }
    }
