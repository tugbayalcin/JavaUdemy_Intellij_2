package Section10_Abstract_Interface_Inner.nestedClass.nonStaticNestedClass.anonymousInnerClass.examplesOnInternet.argumentOfMethodOrConstructor;

import java.util.*;

public class AnonymousClassAsMethodArgExample2 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Peter", "Ashja", "Zahreen", "Mike");
        Set<String> names = new TreeSet<String>();
        names.addAll(list);

        System.out.println(names);

        // reverse order by passing anonymous class as argument to constructor
        names = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        names.addAll(list);
        System.out.println(names);
        



                

    }
}
