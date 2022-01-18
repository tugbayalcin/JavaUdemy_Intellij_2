package Section8_Inheritance;

public class Deneme
{
    public static void main(String[] args)
    {
        Object obj1 = new Dede();
        System.out.println("Objeden olusturulan dede icin:" + obj1);

        Dede obj2 = new Dede();
        System.out.println("Dededen olusturulan dede icin:" + obj2);

        Dede obj3 = new Baba();
        System.out.println("Dededen olusturulan Baba icin:" + obj3);
        // obj3. dedigimizde Dede classinda bulunan elemanlarin kullanilabilir moldugunu goruruz
        // bu da demektir ki obj3'un scope alani Dede'dir

        Baba obj4 = new Baba();
        System.out.println("Babadan olusturulan Baba icin:" + obj4);
        // obj4. dedigimizde hem Dede classinin hem de Baba classinin elemanlarini kullanabildigimi goruruz
        // bu da demektir ki obj4'un scope alani Baba'dir, Baba ayni zamanda; Dede'nin sahip oldugu her seye sahiptir

        Dede obj5 = new Cocuk(3,0);
        System.out.println("Dededen olusturulan cocuk icin:" + obj5);

        Baba obj6 = new Cocuk(3,0);
        System.out.println("Babadan olusturulan cocuk icin:" + obj6);

        Cocuk obj7 = new Cocuk(3,0);
        System.out.println("Cocuktan olusturulan cocuk icin:" + obj7);
    }
}
class Dede
{
    private int nesil=1;
    private String hobby3 = "Kitap Okuma";

    public Dede(){} // dedenin default constructor i
    public Dede(int nesil) // dedenin sahip oldugu tek degiskeni iceren constructor i
    {
        this.nesil = nesil;
    }

    public int getNesil() {
        return nesil;
    }

    public void setNesil(int nesil) {
        this.nesil = nesil;
    }

    public String getHobby3() {
        return hobby3;
    }

    public void setHobby3(String hobby3) {
        this.hobby3 = hobby3;
    }

    public void nesiliYazdir()
    {
        System.out.println("Dedenin nesli: " + nesil );
    }
    public void dedeMethodu()
    {
        System.out.println("Dede methodu calisti.");
    }
    public void erisimMethoduDede()
    {
        this.hobby3 = hobby3;
    }

}
class Baba extends Dede
{
   private int cocukSayisi;
   private String hobby1 = "Yüzme";
   private String hobby2 = "Gitar Çalma";
   private String hobby3 = "Kitap Okuma";

    public Baba(){} // dedenin defaultconstructori ile olusturulmus, babanin default constructori
    public Baba(int nesil) // dedenin tek degiskeni ile olusturulmus, babanin default constructori
    {
        super(nesil);
    }
    public Baba(int nesil,int cocukSayisi) // dedenin tek degiskeni ve babanin tek degiskeni ile olusturulmus constructor
    {
        setNesil(2);
        this.cocukSayisi = cocukSayisi;
    }




    public int getCocukSayisi() {
        return cocukSayisi;
    }

    public void setCocukSayisi(int cocukSayisi) {
        this.cocukSayisi = cocukSayisi;
    }

    public String getHobby1() {
        return hobby1;
    }

    public void setHobby1(String hobby1) {
        this.hobby1 = hobby1;
    }

    public String getHobby2() {
        return hobby2;
    }

    public void setHobby2(String hobby2) {
        this.hobby2 = hobby2;
    }

    @Override
    public String getHobby3() {
        return hobby3;
    }

    @Override
    public void setHobby3(String hobby3) {
        this.hobby3 = hobby3;
    }

    public void AdiniSoyle()
    {
        System.out.println("Ben bir babayim");
    }
    public void babaMethodu()
    {
        System.out.println("Baba Methodu Calisti");
    }
    public void erisimMethoduBaba()
    {
        this.hobby1 = hobby1;
        this.hobby2 = hobby2;
        this.hobby3 = hobby3;
        super.getHobby3();

    }
}
class Cocuk extends Baba
{
    private int kardesSayisi;
    private String isim = "Tugba";
    private String hobby2 = "Gitar Çalma";
    private String hobby3 = "Kitap Okuma";

    public Cocuk(int nesil, int cocukSayisi) {
        super(nesil, cocukSayisi);
    }

    public Cocuk(int nesil, int cocukSayisi, int kardesSayisi, String isim) {
        super(nesil, cocukSayisi);
        this.kardesSayisi = kardesSayisi;
        this.isim = isim;
    }

    public int getKardesSayisi() {
        return kardesSayisi;
    }

    public void setKardesSayisi(int kardesSayisi) {
        this.kardesSayisi = kardesSayisi;
    }

    @Override
    public String getHobby2() {
        return hobby2;
    }

    @Override
    public void setHobby2(String hobby2) {
        this.hobby2 = hobby2;
    }

    @Override
    public String getHobby3() {
        return hobby3;
    }

    @Override
    public void setHobby3(String hobby3) {
        this.hobby3 = hobby3;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
    public void cocukMethodu()
    {
        System.out.println("cocuk Methodu Calisti");
    }
    public void erisimMethoduCocuk()
    {
        this.hobby2= hobby2;
        this.hobby3=hobby3;
        super.getHobby2();
        super.getHobby3();
        super.getHobby1(); // cocukta hobby1 olmamasina ragmen baba classta yer alan hobby1'e erisim saglanabiliyor
        // peki dede classta olan hobby3 degiskenine nasil erisecegiz?

    }

    @Override
    public String toString() {
        return "Cocuk{" +
                "kardesSayisi=" + kardesSayisi +
                ", isim='" + isim + '\'' +
                '}';
    }
}
