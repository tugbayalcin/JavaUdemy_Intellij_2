package Section10_Abstract_Interface_Inner.nestedClass.nonStaticNestedClass.anonymousInnerClass.examplesOnInternet.extendAClass;

public class Test_1
{
    public static void main(String[] args) {

        // Annonymous Inner class
        Greeter greeter = new Greeter() {

            // This is equivalent code of extending Greeter class and then overriding wish() method
            public void wish() {
                System.out.println("Hi");
                frenchWish();// Only can access inside this anonymous class
            }

            String frenchwish = "tout le monde"; // Can declare local variables
            //static String spanishWish = "mundo"; //not allowed, Only static constants allowed
            static final String spanWish = "mundo"; // Can declare static constants

            //Can write its own methods inside anonymous inner class
            public void frenchWish() {

                System.out.println(frenchwish);
                System.out.println(spanWish);

                // greater'in variable ve kendi methodlarina nasil erisiliyor??????
            }
        };

        greeter.wish(); // Hi
        // Can't call anonymous inner class methods, because it's depending on parent reference
        // p.frenchWish();

        Greeter p1 = new Greeter();
        p1.wish();//Hello
    }
}
class Greeter {

    public void wish() {
        System.out.println("Hello");
    }
}
