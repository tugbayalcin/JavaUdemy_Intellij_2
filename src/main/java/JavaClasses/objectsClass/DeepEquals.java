package JavaClasses.objectsClass;

public class DeepEquals
{
    public static void main(String[] args)
    {
        /*
        public static boolean deepEquals(Object a, Object b)
        {
            if (a == b)
                return true;
            else if (a == null || b == null)
                return false;
            else
                return Arrays.deepEquals0(a, b);
        }
         */
        // Objects.equals'da yalnşzca a'nin null olup olmadigi kontrol ediliyordu
        // burada ise  a veya  b'nin null olup olmadigi kontrol ediliyor
        // ardindan Arrays class'indaki deepEquals methodu kullanilarak karsilastirma yapiliyor
        // Arrays class'indaki methoda bakar isek de booool booool instanceof kullanildigini gorursun
        // object type ile ilgili kısmin seni goturdugu deepEquals methodunu da incelersen,
        // her bir elemanin tek tek karsilastirildigini goreceksin

    }
}
