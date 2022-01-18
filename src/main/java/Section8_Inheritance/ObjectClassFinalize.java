package Section8_Inheritance;

public class ObjectClassFinalize // artik kullanimda olmayan bir methoddur(java9'dan sonra kalkti)
{
    public static void main(String[] args)
    {
        A nesne1 = new A(10);
        A nesne2 = new A(15);
        // bellekte A sinifindan 2 kutu olusturdum
        nesne1=nesne2;
        /* nesne2'yi nesne1'e atadim. Artik nesne1'in de degeri 15, yani nesne1'in referansi degisti ve gitti nesne2'nin referansini aldi
           boylece en basta heapte olusan nesne1 kutusu bosa cikti. Artik ona erisimimiz yok. cop oldu
           burada biz isteriz ki garbage collector gelsin bu copu temizlesin ve onun kapladigi alani bize geri versin ama durum boyle olmayacak
           biz gc nin ne zaman calisacagini bilemeyiz buna jvm karar verir


        */
        for (int i=0; i<100;i++)
        {
            nesne2=new A(500); // bu dongu ilk calistiginda artik 15 degerini tutan kutu cop oldu,
                                         // ve dongu her calistiginda new ile olusacak olan kutu nesne2 ye atanacagi icin,
                                         // bir onceki adimda olusan kutu cop oacak
                                         // ancak bu donguyle bile hala gc tetiklenmedi
            if(i==10)
            {
                System.gc(); // bu satir ile artik zorla gc yi calisitiriyoruz, gc calisinca finalize tetiklenir. terminalde finalizein tetiklendigini goreceksin
            }


        }
    }
}
class A
{
    int i;
    public A(int parametre)
    {
        this.i=parametre;
    }

    @Override
    protected void finalize() throws Throwable  // DEPRECATED SINCE 9: yani java9'dan beri kullanimda degil
    {
        // bu method geriye deger dondurmeyen bir method
        // kulanimd aolmadigi icin dokumantasyonuna da erisemiyoruz
        System.out.println("Finalize tetiklendi");
    }
}

