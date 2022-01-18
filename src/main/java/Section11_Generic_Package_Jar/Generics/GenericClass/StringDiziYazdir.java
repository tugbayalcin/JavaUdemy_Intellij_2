package Section11_Generic_Package_Jar.Generics.GenericClass;

public class StringDiziYazdir
{
    // bu method yalnizca String diziler icin calisir
    public static void yazdir(String[] dizi)
    {
        for (String gecici:dizi)
        {
            System.out.println(gecici);
        }
    }
}
