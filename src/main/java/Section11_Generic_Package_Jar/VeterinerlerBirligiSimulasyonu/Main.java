package Section11_Generic_Package_Jar.VeterinerlerBirligiSimulasyonu;

public class Main
{
    public static void main(String[] args)
    {
        ilkNesneleriOlustur();


    }

    private static void ilkNesneleriOlustur()
    {
        Kedi kedi1 = new Kedi("01.01.2016",true,"Van Kedisi;");
        Kedi kedi2 = new Kedi("01.02.2016",false,"Siyam;");
        Kedi kedi3 = new Kedi("01.04.2016",true,"Tekir;");
        //kedi.bilgileriGoster();
        //System.out.println(kedi);

        Kopek kopek1 = new Kopek("01.01.2020",true,3,"Golden");
        Kopek kopek2 = new Kopek("04.01.2020",false,0,"Dalmaçyali");
        Kopek kopek3 = new Kopek("01.05.2020",true,1,"Pitbul");
        //kopek.bilgileriGoster(); // extend edildigi sinif bilgileri dahil hepsini yazdiriyor, methodu oyle yazdim cunku
        //System.out.println(kopek); // yalnizca kopek sinifina ozgu degerler yazdiriliyor

        Musteri musteri1 = new Musteri("Ayse","2324256","Beyoglu");
        musteri1.musteriyeHayvanEkle(kedi1);
        musteri1.musteriyeHayvanEkle(kopek1);

        Musteri musteri2 = new Musteri("Fatma","6876868","Sisli");
        musteri2.musteriyeHayvanEkle(kedi2);
        musteri2.musteriyeHayvanEkle(kopek2);

        Musteri musteri3 = new Musteri("Neriman","565858","Bakirkoy");
        musteri3.musteriyeHayvanEkle(kedi3);
        musteri3.musteriyeHayvanEkle(kopek3);
        //musteri1.kendiniTanit();
        //System.out.println(musteri1);

        Veteriner veteriner1 = new Veteriner("Melis","5454545","Istanbul Universitesi",5);
        veteriner1.musteriEkle(musteri1);
        veteriner1.musteriEkle(musteri2);

        Veteriner veteriner2 = new Veteriner("Zeynep","8974545","Uskudar Universitesi",2);
        veteriner2.musteriEkle(musteri2);
        veteriner2.musteriEkle(musteri3);

        Veteriner veteriner3 = new Veteriner("Sümeyye","534567845","Sakarya Universitesi",7);
        veteriner3.musteriEkle(musteri3);
        //veteriner1.kendiniTanit();
        //System.out.println(veteriner1);

        veteriner1.musterileriListele();
        veteriner2.musterileriListele();
        veteriner3.musterileriListele();

        SehirVeterinerlikleri ankara = new SehirVeterinerlikleri("Ankara");
        ankara.sehireVeterinerEkle(veteriner1);
        ankara.sehireVeterinerEkle(veteriner2);

        SehirVeterinerlikleri istanbul = new SehirVeterinerlikleri("Istanbul");
        istanbul.sehireVeterinerEkle(veteriner3);

        ankara.sehirdekiToplamVeterinerSayisiniBul();
        istanbul.sehirdekiToplamVeterinerSayisiniBul();

        System.out.println("Yonetim Paneli Baslatiliyor");
        YonetimPaneli<Hayvan> hayvanYonetimPaneli = new YonetimPaneli<>();
        hayvanYonetimPaneli.bilgileriGoster(kedi1);
        hayvanYonetimPaneli.bilgileriGoster(kopek1);

        YonetimPaneli<Musteri> musteriYonetimPaneli = new YonetimPaneli<>();
        musteriYonetimPaneli.bilgileriGoster(musteri1);
        musteriYonetimPaneli.bilgileriGoster(musteri2);

        YonetimPaneli<Veteriner> veterinerYonetimPaneli = new YonetimPaneli<>();
        veterinerYonetimPaneli.bilgileriGoster(veteriner1);
        veterinerYonetimPaneli.bilgileriGoster(veteriner2);

    }
}
