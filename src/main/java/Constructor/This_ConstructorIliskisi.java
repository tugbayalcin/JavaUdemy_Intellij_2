package Constructor;

public class This_ConstructorIliskisi
{
    String name="Tuba";
    String sName;
    int number=12345;
    String programName;

    public This_ConstructorIliskisi()
    {
        //yukarda degiskenlerime ne yazdiysam o degerleri atar ve heapten alan tutar
    }

    public This_ConstructorIliskisi(String n){
        name =n;
        //bu constructor ise heapten alan alirken sorar name icin deger yolla bana onu koyayim name icin
    }

    public This_ConstructorIliskisi(String n,String sn){
        this(n);//bu satir yukardaki constructor'i calistirir
        sName=sn;
        //bu constructor ise heapten alan alirken sorar name ve sName icin deger yolla bana onu koyayim name ve sNmae icin
    }

    public This_ConstructorIliskisi(String name, String sName, int number) {
        this.name = name;
        this.sName = sName;
        this.number = number;
    }

    public This_ConstructorIliskisi(String name, String sName, int number, String programName) {
        this(name,sName,number);//bu satir yukardaki constructor'i calistir
        this.programName = programName;
    }

    public void bilgilerimiYazdir()
    {
        System.out.printf("Name:%s - Surname:%s - Number:%d - Program:%s",name,sName,number,programName);
    }

}
