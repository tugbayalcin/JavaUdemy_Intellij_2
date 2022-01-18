package Section10_Abstract_Interface_Inner.nestedClass.nonStaticNestedClass.memberInnerClass.InnerClassExample;

public class HesapMakinesi
{
    /* Hesap makinesinin yapabilecegi islemleri teker teker inner classlara yaptiracagiz
       normalde 4 islemi methodlar vasitasi ile de yaptirabilirdik ancak kesirli ifaderle islemler, irrasyonel sayilarla
       islemler gibi yalnizca methodlar ile gerceklestiremeyecegimiz islemler olabilir.
       Bunun icin inner classlardan faydalanabiliriz

     */

    public int carpma(int sayi1, int sayi2)
    {
        Carpma carpma = new Carpma();
        int carpim = carpma.carp(sayi1,sayi2);
        return carpim;
    }

    public String bolme(int sayi1, int sayi2)
    {
        class Bolme
        {
            public String bol(int i,int j)
            {
                if(j==0)
                {
                    System.out.println("Bolen 0 olamaz");
                    return " ";
                }
                else
                {
                    int sonuc = i/j;
                    return  String.valueOf(sonuc); // integeri stringe donusturen method valueOf, stringi int e donusturen pars
                }

            }
        }
        Bolme b = new Bolme();
        String sonuc = b.bol(sayi1,sayi2);
        return sonuc;
    }

    public class Toplama
    {
        public int topla(int i, int j)
        {
            return i+j;
        }
    }

    class Cikarma
    {
        public int cikar(int i, int j)
        {
            if(i>j)
            {
                return i-j;
            }
            else if(i<j)
            {
                return j-i;
            }
            else
                return 0;
        }
    }

    private class Carpma
    {
        public int carp(int i,int j)
        {
            return i*j;
        }
    }

    // bolme classini method icine tasidik, bolme methoduna bak


}

/*
inner classlar method icine, static block icine ve default block icine yazilabilirler. Buna LOCAL INNER CLASS denir
yasam alanlari icinde bulunduklari yapi ile sinirlidir
kullan at gibi olur
ana class icinde diger yerlerde kullanilamazlar
 */
