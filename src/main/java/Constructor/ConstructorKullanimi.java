package Constructor;

public class ConstructorKullanimi
{

    String name="Tuba";//githubtan ilk editimi yapip commitliyorum
    String sName;//git'te degisiklik yapip + commitledim -> github'a pushlamak icin
    int number=12345;
    String programName;

    public ConstructorKullanimi()
    {
        //yukarda degiskenlerime ne yazdiysam o degerleri atar ve heapten alan tutar
    }

    public ConstructorKullanimi(String n){
        name =n;
        //bu constructor ise heapten alan alirken sorar name icin deger yolla bana ben de name e onu atayayim
    }

    public ConstructorKullanimi(String n,String sn){
        name =n;
        sName=sn;
        //bu constructor ise heapten alan alirken sorar name ve sName icin deger yolla bana onu koyayim name ve sNmae icin
    }

    public ConstructorKullanimi(String name, String sName, int number) {
        this.name = name;
        this.sName = sName;
        this.number = number;
    }

    public ConstructorKullanimi(String name, String sName, int number, String programName) {
        this.name = name;
        this.sName = sName;
        this.number = number;
        this.programName = programName;
    }

    public void bilgilerimiYazdir()
    {
        System.out.printf("Name:%s - Surname:%s - Number:%d - Program:%s",name,sName,number,programName);
    }
}
