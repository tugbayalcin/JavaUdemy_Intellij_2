package Section10_Abstract_Interface_Inner.nestedClass.nonStaticNestedClass.anonymousInnerClass.examplesOnInternet.anonymousClassExample;

public class Test
{
    public static void main(String[] args) {

        // Anonymous Inner class 1
        Greeter englishGreet = new Greeter() {
            // This is equivalent code of extending Greeter class and then overriding wish() method
            public void wish() {
                System.out.println("Hi");
            }
        };
        // Greater class'inin methodunu override ettim ve yalnizca bu objeye ozgu olarak  baska bir sey yazdirmasini sagladim

        // Anonymous Inner class 2
        Greeter frenchGreet = new Greeter() {
            // This is equivalent code of extending Greeter class and then overriding wish() method
            public void wish() {
                System.out.println("tout le monde");
            }
        };
        // Greater class'inin methodunu yukarida bir anonymous class yardimiyla yalnizca o objeye ozgu olarak
        // override etmis ve icini degistirmistim ancak bu, ayni methodu bir kere daha anonymous ile override edip
        // bu sefer icine daha da baska bir sey yazmama engel degil
        // simdi de baska bir obje olusturarak yine yalnizca bu objeye ozgu olarak baska bir sey yazdirmasini sagladim

        englishGreet.wish(); // Hi
        frenchGreet.wish(); // tout le monde

        // son olarak da Greater class'indan obje ureterek wish()' methodunu cagiralim ve ne yazdirdigina bakalim
        Greeter britanGreet = new Greeter();
        britanGreet.wish(); // Hello
        // orjinal method ne yazdiriyorsa onu yazdirdi
    }
}
class Greeter
{
    public void wish()
    {
        System.out.println("Hello");
    }
    // Greeter class'imizin wish() adinda bir methodu var ve bu method cagrildiginda Hello yazdiriyor
    // simdi test class'inda denemelerimizi yapalim.
}

