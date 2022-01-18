package JavaClasses.objectClass;

public class Finalize {
    public static void main(String[] args) {
        // Bu method garbage collector gelip her seyi silip supurmeden once otomatik olarak cagirilir
        // bir cesit temizlik yapar
        // kullanimdan kaldirilmistir
        Finalize obj = new Finalize();
        System.out.println(obj.hashCode());
        obj = null;
        // calling garbage collector
        System.gc();
        System.out.println("end of garbage collection");
    }
    @Override
    protected void finalize()
    {
        System.out.println("finalize method called");
    }
}
