package Section11_Generic_Package_Jar.Generics.GenericClass;

public class GenericDiziYazdir<GelenVeriTuru>
{
    // burasi su sekilde calisiyor: elmaz isareti icerisine ne yazilirsa, class icindeki her yere de o yaziliyor, refactor rename gibi
    // yazilan tur icin ozellesmis bir class elde etmmis gibi oluyoruz
    public void yazdir(GelenVeriTuru[] dizi)
    {
        for (GelenVeriTuru gecici:dizi)
        {
            System.out.println(gecici);
        }
    }
}
