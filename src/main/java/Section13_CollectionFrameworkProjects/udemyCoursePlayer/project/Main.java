package Section13_CollectionFrameworkProjects.udemyCoursePlayer.project;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Ogrenci ogr1 = new Ogrenci("Ali", "Ali'nin Tanitim Yazisi", "ali_udemy");
        Egitmen emre = new Egitmen("Emre", "Emre Java", "emrealtunbilek");
        Egitmen deneme = new Egitmen("deneme", "deneme Java", "deneme_udemy");
        System.out.println(ogr1);
        System.out.println(emre);

        Ders d1 = new Ders(1, "Giris", 3.5);
        Ders d2 = new Ders(2, "Java Nedir", 9.2);
        Ders d3 = new Ders(3, "Primitive Veri Tipleri", 22.9);
        Ders d4 = new Ders(4, "Diziler", 15.9);
        Ders d5 = new Ders(5, "Methodlar", 15.9);

        Ders d6 = new Ders(6, "Nesneler", 15.9);
        Ders d7 = new Ders(7, "Try-Catch", 15.9);
        Ders d8 = new Ders(8, "Recyclerview", 15.9);
        Ders d9 = new Ders(9, "SharedPreferences", 15.9);
        Ders d10 = new Ders(10, "Firebase", 15.9);

        Kurs javaKursu = new Kurs("Ileri Seviye Java Kursu", emre);
        javaKursu.kursaDersEkle(d1);
        javaKursu.kursaDersEkle(d2);
        javaKursu.kursaDersEkle(d3);
        javaKursu.kursaDersEkle(d4);
        javaKursu.kursaDersEkle(d5);

        javaKursu.kurstanEgitmenSil(emre);

        javaKursu.kursaEgitmenEkle(deneme);
        javaKursu.kurstanEgitmenSil(deneme);

        ogr1.kursaKatil(javaKursu);

        Kurs androidKursu = new Kurs("Android Kursu", emre);
        androidKursu.kursaDersEkle(d6);
        androidKursu.kursaDersEkle(d7);
        androidKursu.kursaDersEkle(d8);
        androidKursu.kursaDersEkle(d9);
        androidKursu.kursaDersEkle(d10);

        ogr1.kursaKatil(androidKursu);
        ogr1.izlenecekDersEkle(d6);
        ogr1.izlenecekDersEkle(d2);
        ogr1.izlenecekDersEkle(d8);
        ogr1.izlenecekDersEkle(d1);
        ogr1.izlenecekDersEkle(d7);


        listeyiOynat(ogr1.getIzlenecekDersListesi());


    }

    public static void listeyiOynat(LinkedList<Ders> izlenecekDersler) {
        Scanner scan = new Scanner(System.in);
        boolean cikis = false;
        boolean ileriDogruHareket = true;

        ListIterator<Ders> iterator = izlenecekDersler.listIterator();
        if (izlenecekDersler.size() == 0) {
            System.out.println("Henuz bir ders eklenmemistir.");
        } else {
            Ders ilkDers = iterator.next();
            System.out.println("Su an izlenen ders: " + ilkDers.getDersBaslik() + " Sure: " + ilkDers.getDakika() + " dk");
        }
        menuGoster();
        while (!cikis) {
            System.out.println("Lutfen Seciminizi Giriniz: ");
            int secim = scan.nextInt();

            switch (secim) {
                case 0:
                    System.out.println("Uygulamadan cikiliyor..");
                    cikis = true;
                    break;
                case 1: {
                    if(!ileriDogruHareket)
                    {
                        ileriDogruHareket = true;
                        if(iterator.hasNext())
                        {
                            iterator.next();
                        }
                    }
                    if (iterator.hasNext()) {
                        Ders ilkDers = iterator.next();
                        System.out.println("===============================================");
                        System.out.println("Su Anda Oynatilan Ders Bilgisi: \nDers No: " + ilkDers.getDersNo() + " Baslik: " + ilkDers.getDersBaslik() + " Sure: " + ilkDers.getDakika() + " dk");
                        System.out.println("===============================================");
                    } else {
                        System.out.println("Listenin sonuna geldiniz.");
                    }
                }
                break;
                case 2: {
                    if(ileriDogruHareket)
                    {
                        ileriDogruHareket = false;
                        if(iterator.hasPrevious())
                        {
                            iterator.previous(); //  burada uzerinden atladigimiz son dersin, yani oynatilan dersin uzerinden
                            // geri yonde yeniden atliyoruz, boylece asagidaki kod gercekten bir onceki derse gidebilecek
                        }
                    }

                    if (iterator.hasPrevious()) {
                        Ders ilkDers = iterator.previous();
                        System.out.println("===============================================");
                        System.out.println("Su Anda Oynatilan Ders Bilgisi: \nDers No: " + ilkDers.getDersNo() + " Baslik: " + ilkDers.getDersBaslik() + " Sure: " + ilkDers.getDakika() + " dk");
                        System.out.println("===============================================");
                    } else {
                        System.out.println("Listenin basina geldiniz.");
                    }
                }
                break;
                case 3:
                    izlenecekDersleriListele(izlenecekDersler);
                    break;
                case 4:
                    menuGoster();
                    break;
            }
        }
    }
    private static void izlenecekDersleriListele(LinkedList<Ders> izlenecekDersler) {
        ListIterator<Ders> iterator = izlenecekDersler.listIterator();
        if (izlenecekDersler.size() == 0) {
            System.out.println("Henuz bir ders eklenmemistir.");
            return;
        } else {
            while (iterator.hasNext()) {
                Ders ilkDers = iterator.next();
                System.out.println("Ders No: " + ilkDers.getDersNo() + " Baslik: " + ilkDers.getDersBaslik() + " Sure: " + ilkDers.getDakika() + " dk");
            }
        }
    }
    private static void menuGoster() {
        System.out.println("******* MENU *******");
        System.out.println("0: CIKIS " +
                "\n1: BIR SONRAKI DERSE GIT " +
                "\n2: BIR ONCEKI DERSE GIT " +
                "\n3: TUM LISTEYI GOSTER " +
                "\n4: MENU GOSTER");
    }
}
