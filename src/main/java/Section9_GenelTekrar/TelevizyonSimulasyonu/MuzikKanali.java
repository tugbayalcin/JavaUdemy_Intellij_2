package Section9_GenelTekrar.TelevizyonSimulasyonu;

public class MuzikKanali extends Kanal
{

    private String muzikTuru;

    public MuzikKanali(String kanalAdi, int kanalNo, String muzikTuru)
    {
        super(kanalAdi, kanalNo);
        this.muzikTuru = muzikTuru;
    }
}
