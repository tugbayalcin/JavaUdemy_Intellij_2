package Section10_Abstract_Interface_Inner.nestedClass.nonStaticNestedClass.anonymousInnerClass;

import java.util.Arrays;

public class denemeAnonymous
{

    PrintStringArray nesne  = new PrintStringArray()
    {
        @Override
        public void print(String[] array) {
            super.print(array);
        }

        @Override
        public void printd(String[] array) {
            super.printd(array);
        }
        // birden fazla method override edildi
        class A {} // anonymous icinde class olusturabildim
        void method(){} // anonymous icinde method olusturabildim
    };

    public static void main(String[] args) {
        String[] array = {"a"};
        System.out.println( Arrays.toString(new PrintStringArray()
        {//sadece 1 tane methodu override edebilirim interface-abstract gibi değil
            @Override
            public String[] getArray(String[] array)
            {
                return super.getArray(array);
            }
        }.getArray(array) ));

    }

}
class PrintStringArray
{
    public void print(String[] array){}
    public void printd(String[] array){}
    public void printc(String[] array){}
    public String[] getArray(String[] array)
    {
        String[] dizi = {"a"};
        return dizi;
    }
}
