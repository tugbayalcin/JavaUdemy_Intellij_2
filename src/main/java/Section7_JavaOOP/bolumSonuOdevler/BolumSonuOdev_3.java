package Section7_JavaOOP.bolumSonuOdevler;

public class BolumSonuOdev_3
{
    // SORU3: Hesap makinesi sinifi olusturun.
    // Bu sinifta  islem yapabilmek icin methodlariniz olsun
    // Bu methodlara istenilen sayida parametre gecilkebilmeli - varargs methodu - yani sinirsiz parametre alan method
    // Bolme islemi icin 0 degerinde olujsacak sikintiyi onkemek adina gerekli kontrolleri yapiniz

    private static long HATA_KODU_0 =1234567890;//INSTANCE VARIABLE

    public static long getHataKodu0() {//encapsulation'in mantigi degiskenimize herkes erisemesin, erismek isteyen getter yazsin
                                    // buna ilave olarak degistirmek isteyen de setter yazsin
        return HATA_KODU_0;
    }


    public static final long HATA_KODU =1234567890;//degiskenim her yerden direk kullanilsin, ve degistirilmesin, yani UNIQE-ESSIZ bir ortak deger olsun


    public static void main(String[] args)
    {


        //TOPLAMA - ADDITION
        System.out.println("Toplam: " + HesapMakinesi.toplama(10,12,14));//36
        System.out.println("Toplam: " + 36);//yukardaki kodumuz bunu gibi calisir, yani degiskenimizi sadece bir kez kullanabilriz

        //CIKARMA - SUBSTRACTION
        int cikarmaIslemiSonucu=HesapMakinesi.cikarma(15,4,3);
        System.out.println("Fark: " + cikarmaIslemiSonucu);

        //CARPMA - MULTIPLICATION
        System.out.println("Carpim: " + HesapMakinesi.carpma(10,12,5));

        //BOLME -DIVISION
        //yanlis mantik
        if(4!=0)
            System.out.println("4 sifira esit degilse kendisni yazdir"+4);


        //dogru mantik
        double bolum =HesapMakinesi.bolme(100,0,1);//elimizdeki bolum sayisi
        //1.olasilik -> bolenler arasinda 0 olan bir parametre olmasi                --> bolum==hataCodumuz hataCodumuzu yazdiririz
        //2.olasilik -> tum parametrelerin guzel verilmesi - o'dan baska deger yani  --> bolum'u yazdiririz
        //3. olasilik -> bolunen degerin yani ilk parametrenin 0 Olma durumu         --> bolum ==0 sonucunu yazdirirz

        if(bolum!=0)//40/5/2=4 - 4!=0 - 4 sayisi 0'a esit degilse if in icine gir
        {
            //1.OLASILIK ICIN CALISIR
            if(bolum==BolumSonuOdev_3.HATA_KODU) //methodumuz cidden hata kodunun kendisini dondurmus mu hata, codu almadiysak
                System.out.println("Hata Kodumuz: " + bolum);
           //2.OLASILIK ICIN CALISIR
            else//bolumumuzu yazdirir
                System.out.println("Bolum:" + bolum);
        }
        //3.OLASILIK ICIN CALISIR
        else //bolum 0'a esitse
            System.out.println("Ilk parametremiz yani bolunen sayimiz:" +bolum +"'a esittir, bu sebepten dolayi da bolum: "+bolum);




    }//main methodun sonu
}

class HesapMakinesi //EK BILGI: .java file inda sadece bir tane public class olur, onun da adi dosya ile ayni olmak zorundadir
{
    void method1(){
        System.out.println(BolumSonuOdev_3.getHataKodu0()+5);//1234567890+5

    }
    public static int toplama(int ... parametreler) // kac tane parametre alacagimizi bilmedigimiz durumlarda ... koyariz
    {                        //int[] parametreler  gibi dusun
        int toplam=0;
        for(int parametre:parametreler)//foreach loop'u  int[] parametre={10,12,14};
        {
            //int parametre =10;-> degisken olusturuldu(declaration)
            //:parametre        -> int[] paramette arrayindaki intler sirasiyla buna atanacak
            toplam=toplam+parametre;//0=0+10 - 10=10+12  - 22=22+14  -> 36
        }
        return toplam;
    }
    public static int cikarma(int ... parametreler)//15,4,3 parametreleri aliyor -> yani 15-4-3=8
    {                        //int[] parametre ={15,4,3}
        int fark =parametreler[0];//ilk parametre bizim sayimizdir elimizzde tutalim, diger parametreler bundan cikarilacak

        for(int i=1; i<parametreler.length;i++)//i=1 ve i=2 icin toplamda 2 kez donecek
        {
            fark =fark-parametreler[i]; //15=15-4  - 11=11-3 -> 8
        }
        return fark;//8 sayisini integer olarak dondur
    }

    public static int carpma(int ... parametreler)//int[] parametre={10,12,5}
    {
        int carpim=1;

        for(int parametre:parametreler)// : isareti-> parametre arrayinin icine girip ilk elemandan baslayip sona kadar tel tek gezmemizi saglar
        {
            //int parametre=10;  - parametre=12;  - parametre=5;
            //carpim=carpim*parametre; // 1=1*10  - 10=10*12 - 120=120*5  -> 600
            carpim *=parametre;
        }
        return carpim;//600 integer degeri return edildi
    }

    public static double bolme(int ... parametreler)//40,5,2,2,0,2
    {
        //parametre[0] -> BOLUNEN'dir
        //parametre[1],parametre[2] ,parametre[3],...,etc -> BOLEN'dir
        double bolum = parametreler[0];//Ilk parametremiz bizim sayimizdir, sonraki parametreler bolme icin kullanilir

        for(int i=1;i< parametreler.length;i++)//ilk parametre bolunen oldugu icin 0'dan degil 1'den basladik loop'umuza
        {
            if(parametreler[i]!=0)//olur da herhangi bir parametre (mesela 5 ya da 2) 0'a esit olursa onu BOLME ISLEMINE DAHIL ETME
            {
                bolum=bolum / parametreler[i];//2
            }
            else
            {
                System.out.println("Parametrelerden biri 0'dir. Bolme islemi yapilamadi ya da yarim kaldi \n buyuzden bolum'u return etmedik\nHata Codunu return ettik");
                return  BolumSonuOdev_3.HATA_KODU;//long bir sabit deger - method bu long deger i return edrken double 'a casting yapip dondurur
            }
        }
        return bolum;
    }
}

