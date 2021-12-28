package Section12_CollectionFramework;

import java.util.ArrayList;

public class C03_ArrayListvsArray
{
    public static void main(String[] args) {
        // ArrayList ile Array arasindaki farklara bakalim:

        // -------------------------------------------------------------------------------------------------------------
        ArrayList<String> isimlerListesi = new ArrayList<>(); // String ArrayList tanimlandi
        String[] isimlerDizisi = new String[1000000]; // 1000000 elemanli StringDizi tanimlandi

        // sistem saatini milisaniye cinsinden alalim, ve bu sayi uzun bir sayi oldugu icin long tipinde bir degiskene atayalim
        long baslamaZamani = System.currentTimeMillis();

        // dizi elemanlarinin atandigi dongu
        for(int i=0; i<1000000; i++)
        {
            isimlerDizisi[i] = "deneme" +i;
        }
        long bitmeZamani = System.currentTimeMillis();
        System.out.println("Dizi calisma suresi:" + (bitmeZamani-baslamaZamani) + " milisaniye");

        baslamaZamani = System.currentTimeMillis();
        // liste elemanlarinin atandigi dongu
        for(int i=0; i<1000000; i++)
        {
            isimlerListesi.add("deneme" + i);
            // burada indexe ihtiyacim yok aslinda ama islemi 1 milyon kez yaptimak istedigim icin belirttim
        }
        bitmeZamani = System.currentTimeMillis();
        System.out.println("Listenin calisma suresi: " + (bitmeZamani-baslamaZamani) + " milisaniye");
        //--------------------------------------------------------------------------------------------------------------
                                        //*********************//
        //--------------------------------------------------------------------------------------------------------------
        baslamaZamani = System.currentTimeMillis();
        isimlerDizisi[4000000] = "yeni deger";
        bitmeZamani = System.currentTimeMillis();
        System.out.println("Dizinin eleman degistirme suresi: " + (bitmeZamani-baslamaZamani) + " milisaniye");
        // Dizi direk indexi buldu ve oradaki elemani degistirdi, hic zaman almadi

        baslamaZamani = System.currentTimeMillis();
        isimlerListesi.add(4000000,"yeni deger");
        bitmeZamani = System.currentTimeMillis();
        System.out.println("Listenin eleman degistirme suresi: " + (bitmeZamani-baslamaZamani) + " milisaniye");
        // Liste araya eleman eklerken diger elemanlari kaydirir, yani arkada cok fazla is yapar
        //--------------------------------------------------------------------------------------------------------------
    }
}
