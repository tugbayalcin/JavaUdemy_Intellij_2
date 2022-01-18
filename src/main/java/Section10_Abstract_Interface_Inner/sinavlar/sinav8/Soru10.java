package Section10_Abstract_Interface_Inner.sinavlar.sinav8;

public class Soru10 {
    public void main(String[] args)
    {
        ABC abc = new ABC();

        System.out.println(abc.i);

        ABC.XYZ xyz = abc.new XYZ();

        System.out.println(xyz.i);

        ABC.XYZ xyz1 = new ABC().new XYZ();

        System.out.println(xyz1.i);
    }
    class ABC
    {
        int i = 102;

        {
            i--;
        }

        public ABC()
        {
            --i;
        }

        class XYZ
        {
            int i = this.i;

            {
                i++;
            }

            public XYZ()
            {
                ++i;
            }
        }
    }

}
