package Section10_Abstract_Interface_Inner.nestedClass.nonStaticNestedClass.anonymousInnerClass.examplesOnInternet.argumentOfMethodOrConstructor;

public class Test
{
    public static void main(String[] args) {

        // Anonymous inner class as constructor argument
        new Thread( new Runnable() {

            public void run(){

                for(int i=0; i<5; i++) {
                    System.out.println("Test Thread");
                }
            }
        }).start();

        for(int i=0; i<5; i++){
            System.out.println("Main Thread");
        }
    }
}
