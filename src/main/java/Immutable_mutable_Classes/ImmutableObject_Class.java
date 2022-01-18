package Immutable_mutable_Classes;


//IMMUTABLE-DEGISTIRILEMEYEN CLASS
final class Bilgisayar extends Object//Bu class extend edilemez
{
    private final int cekirdekSayisi;
    private final int ramBoyutu;
    private final String[] ureticiFirmalari;

    public Bilgisayar(int cekirdekSayisi, int ramBoyutu, String[] ureticiFirmalari) {
        this.cekirdekSayisi = cekirdekSayisi;
        this.ramBoyutu = ramBoyutu;
        this.ureticiFirmalari = ureticiFirmalari;

    }

   //Setter methodlar olmamali

    public int getCekirdekSayisi() {
        return cekirdekSayisi;

    }

    public int getRamBoyutu() {
        return ramBoyutu;

    }

    public String[] getUreticiFirmalari()
    {
        //IMMUTABLE OBJECT
        String[] kopyaFirmaIsimleri = new String[ureticiFirmalari.length];
        for (int i = 0; i < kopyaFirmaIsimleri.length; i++)
        {
           // kopyaFirmaIsimleri=ureticiFirmalari; bunu asla yapma cunku yaparsan kopyaFirmaIsimlerini tanimlamana gerek yok,
           // yine dizinin kendi referansi ile dolayisi ile ta kendisiyle calismis olursun
            kopyaFirmaIsimleri[i]=ureticiFirmalari[i];

        }
        return kopyaFirmaIsimleri;


    }



}
