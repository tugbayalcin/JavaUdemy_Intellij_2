package Constructor;

public class This_ConstructorIliskisi2
{
    String name="Tuba";
    String sName;
    int number=12345;
    String programName;
    static String staticSehir = "ETOBICOKE";

    static void staticMethod(){
        System.out.println("Ben bir static methodum");
       // static int i =5;  COMPILER TIME ERROR !!! method icinde static bir degisken tanimlayamayiz
    }

    public This_ConstructorIliskisi2()
    {
        //yukarda degiskenlerime ne yazdiysam o degerleri atar ve heapten alan tutar
        System.out.println("Parametre almayan, normalde otomatik olusan ve gozukmeyen default constructor calistirildi");
    }

    public This_ConstructorIliskisi2(String n){
        name =n;
        //bu constructor ise heapten alan alirken sorar name icin deger yolla bana onu koyayim name icin
        System.out.println("1 parametreli consructor calistirildi");
    }

    public This_ConstructorIliskisi2(String n, String sn){
        this(n);//bu satir yukardaki constructor'i calistirir
        sName=sn;
        //bu constructor ise heapten alan alirken sorar name ve sName icin deger yolla bana onu koyayim name ve sNmae icin
        System.out.println("2 parametreli constructor calistirildi");
    }

    public This_ConstructorIliskisi2(String name, String sName, int number) {
        this(name,sName);
        this.number = number;
        System.out.println("3 parametreli constructor calistirildi");

    }

    public This_ConstructorIliskisi2(String name, String sName, int number, String programName) {
        this(name,sName,number);//bu satir yukardaki constructor'i calistir
        this.programName = programName;
        System.out.println("4 parametreli constructor calistirildi");

    }

    public void bilgilerimiYazdir()
    {
        //this(); // -> default constructori temsil edip calistiracak this(); kodu normal methodlarin icine yazilamaz
        // -> anliyoruzki this(...); kullanimi sadece constructorlar icindir ve sadece constructor iclerinde kullanilabilriler
        System.out.printf("Name:%s - Surname:%s - Number:%d - Program:%s",name,sName,number,programName);
    }


    @Override
    public String toString() {
        return "This_ConstructorIliskisi2{" +
                "name='" + name + '\'' +
                ", sName='" + sName + '\'' +
                ", number=" + number +
                ", programName='" + programName + '\'' +
                '}'
                +"   -> toString() methodu calisti";//son satiri elle yazdim

        //sout(obj) dedigim zaman normalde stackte tutulan obj alanini reference numarasi yazdirilir
        //ama class'imiza object class'indan toString() methodunu override edip yazarsak
        //sout(obj); yazdigimiz an heapteki obj alaninin icindeki degiskenlerin degerlerine bakip
        //toString methodunun icinde yazan idafeyi yazacak
    }
}

class Deneme
{
    //Bu Nesne tum methodlardan erisilebilir mi?
    This_ConstructorIliskisi2 globalObje = new This_ConstructorIliskisi2();

    public static void main(String[] args)
    {
        This_ConstructorIliskisi2 obj=new This_ConstructorIliskisi2();
        obj.bilgilerimiYazdir();
        System.out.println(obj);

        This_ConstructorIliskisi2 obj2=new This_ConstructorIliskisi2("tuba2");
        obj2.bilgilerimiYazdir();
        System.out.println(obj2);

        This_ConstructorIliskisi2 obj3=new This_ConstructorIliskisi2("tuba3","yalcin");
        obj3.bilgilerimiYazdir();
        System.out.println(obj3);

        This_ConstructorIliskisi2 obj4=new This_ConstructorIliskisi2("tuba4","yalcin2",26);
        obj4.bilgilerimiYazdir();
        System.out.println(obj4);

        This_ConstructorIliskisi2 obj5=new This_ConstructorIliskisi2("tuba5","yalcin3",26,"yazilim muh.");
        obj5.bilgilerimiYazdir();
        System.out.println(obj5);


        //intellij'e gostermese de obje ile class'in static verilerine erisilebilir
        //class'in static mallarini objes ile cagirabilirsin ama bu mantikli degil
        obj5.staticSehir ="Istanbul";
        obj5.staticMethod();
    }

    public void nonStaticMethod()
    {
        // static olmayan bir methoddan static olan baska method ve degiskenlere erisebiliriz
        This_ConstructorIliskisi2.staticSehir="Balikesir";
        This_ConstructorIliskisi2.staticMethod();

        // static olmayan bir methoddan static olmayan baska method ve degiskenlere erisebiliriz
        globalObje.name="tuba";
        System.out.println(nonStaticInt);
    }

    //primitive , reference tipli olsun olmasin farketmez STATIC DEGILLERSE Static bir methodtan direk erisilemezler
    int nonStaticInt=10;
    String nonStaticString="tugba";
    This_ConstructorIliskisi2 nonStaticObje = new This_ConstructorIliskisi2();

    //static ya da static olmayan bir methodtan direk erisilebilriler
    static This_ConstructorIliskisi2 staticObje=new This_ConstructorIliskisi2();


    public static void staticMethodX(){
        //Static bir methodtan static olan verilere erisilebilir mi? Evet

        This_ConstructorIliskisi2.staticMethod();
        This_ConstructorIliskisi2.staticSehir="Bartin";

        System.out.println(This_ConstructorIliskisi2.staticSehir); // static degsikenler ve static methodlar, Static bir method'ta direk cagirabilirler
        System.out.println(staticObje);

        //static bir methodtan static olmayan bir degiskene ve methoda DIREK erisilebilir mi? -HAYIR
        //System.out.println(nonStaticInt);//static olmayan primitive data
        //nonStaticMethod();//static olmayan method
        //System.out.println(nonStaticString);//static olmayan yari ilkel+yari reference tipli veriye ulasilamaz
        //System.out.println(nonStaticObje);//static olmayan reference tipli veriler static methodtan direk  erisilemezler


        //static olmayan bir degisken ve method static olan bir methodta, obje yardimiyla kullanilir!!!
        System.out.println(new Deneme().nonStaticInt);//heapte obje olustu, objenin reference numarasi bir degiskeni=e verilmedi
                                                        //bu yuzden sadece 1 kez kullanildi ve bir daha kullanilamaz
                                                        //garbageCollector gelesecek bunu silecek

        Deneme denemeObj=new Deneme();//obje olusturuldu heapte, ve bir degiskene reference numrasi verildi, her daim elimizde dursun diye
        denemeObj.nonStaticMethod();
        System.out.println(denemeObj.nonStaticObje);
        System.out.println(denemeObj.nonStaticString);



    }

}
