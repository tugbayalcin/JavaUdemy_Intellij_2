package JavaClasses.objectClass.cloneMethod;

class cloneM
{
    // example geeksfor geeks:
    // Java program to demonstrate that assignment operator only creates a new reference to same object
}

class Test0
{// A test class whose objects are cloned
    int x, y;
    Test0()
    {
        x = 10;
        y = 20;
    }
}
// Driver Class
class Main {
    public static void main(String[] args)
    {
        Test0 ob1 = new Test0(); // yukaridaki test class'indan bir obje olusturduk

        System.out.println(ob1.x + " " + ob1.y); // obje ile class elemanlarina eristik 10 20

        // Creating a new reference variable ob2
        // pointing to same address as ob1
        Test0 ob2 = ob1; // referansini paylasti

        // Any change made in ob2 will
        // be reflected in ob1
        ob2.x = 100; // yeni obje ile x degerinde degisiklik yaptik

        System.out.println(ob1.x + " " + ob1.y); // goruyoruz ki bu degisiklik yalnizca o2 objesine has olmamis
        System.out.println(ob2.x + " " + ob2.y); // cunku referansini paylasmisti
    }
}

