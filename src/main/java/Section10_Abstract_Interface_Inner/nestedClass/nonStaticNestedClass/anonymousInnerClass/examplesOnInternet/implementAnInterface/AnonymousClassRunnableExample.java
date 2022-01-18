package Section10_Abstract_Interface_Inner.nestedClass.nonStaticNestedClass.anonymousInnerClass.examplesOnInternet.implementAnInterface;

public class AnonymousClassRunnableExample
{
    public static void main(String[] args) {
        // Implementing Runnable Interface and overriding run()
        Runnable r = new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Test Thread");
                }
            }
        };
        Thread thread = new Thread(r);
        thread.start();
        for (int i = 0; i < 4; i++) {
            System.out.println("Main Thread");
        }
    }

}
