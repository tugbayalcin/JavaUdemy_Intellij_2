package Section11_Generic_Package_Jar.VeterinerlerBirligiSimulasyonu;

public class YonetimPaneli<T>
{
    public void bilgileriGoster(T nesne)
    {
        System.out.println(nesne);
    }
    public <T extends Musteri>void sahipOlduguHayvanlariGoster(T musteri)
    {
        musteri.musteriHayvanlariniListele();
    }
}
