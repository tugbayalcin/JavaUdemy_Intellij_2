package Section9_GenelTekrar.TelevizyonSimulasyonu;

public class Kanal
{
    private String KanalAdi;
    private int KanalNo;


    public Kanal() {
    }

    public Kanal(String kanalAdi, int kanalNo) {
        KanalAdi = kanalAdi;
        KanalNo = kanalNo;
    }

    public String getKanalAdi() {
        return KanalAdi;
    }

    public void setKanalAdi(String kanalAdi) {
        KanalAdi = kanalAdi;
    }

    public int getKanalNo() {
        return KanalNo;
    }

    public void setKanalNo(int kanalNo) {
        KanalNo = kanalNo;
    }
    public String kanalBilgisiniGoster()
    {
        return "Kanalin Adi:"+ KanalAdi+" Kanalin Numarasi:"+KanalNo;
    }
}

