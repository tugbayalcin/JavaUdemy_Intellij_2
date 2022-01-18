package Section9_GenelTekrar.TelevizyonSimulasyonu;

public class HaberKanali extends Kanal
{
/*
    * Kanal classimin default constructori olmadigindan burayi extend ederken hata verdi.
    * Dedi ki super classinda bir constructor var, default degil, ve sen buraya onunla birebir eslesen bir constructor
    * tanimlamak zorundasin dedi.
    * alt enter ile tanimladik.
*/

   private String haberTuru; // ekonomi, spor, saglik, dunya etc olabilir

    public HaberKanali(String kanalAdi, int kanalNo, String tur)
    {
        super(kanalAdi, kanalNo);
        this.haberTuru = tur;
    }
}
