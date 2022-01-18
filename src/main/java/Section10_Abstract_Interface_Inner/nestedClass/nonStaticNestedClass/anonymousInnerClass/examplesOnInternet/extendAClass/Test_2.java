package Section10_Abstract_Interface_Inner.nestedClass.nonStaticNestedClass.anonymousInnerClass.examplesOnInternet.extendAClass;

public class Test_2 { // bu ornegi anlamadim?????????
    public static void main(String[] args) {

        //Anonymous class extending Thread class and overriding run()
        Thread thread = new Thread() {

            public void run() {

                for (int i = 0; i < 5; i++) {

                    System.out.println("Test thread");
                }
            }
        };

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
        }

    }
}
