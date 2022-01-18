package Section8_Inheritance;

public class KonuyuToparlayalim
{
    public static void main(String[] args)
    {
        Canli canli= new Canli();
        canli.adiniSoyle();

        Kartal kartal = new Kartal(); // ben urada Canli kartal=new Kartal() dedigimde Canli sinifinin adini soyle methodu
        // calisir ve Canli sinifinda uc methodu olmadigi icin alttaki kartal.uc satiri calismaz
        // cunku Kartal() calisma aninda tanimlanan bir seydir. ve compiler bunu onceden bilmedigi icin sadece Kartal a ozgu degerlere erisemez
        kartal.adiniSoyle();
        kartal.uc(); // bu durumu onceden cozmek icin explicit atama yapariz. Panda orneginde yapiyorum dikkatli bak: DOWNCASTING

        Canli panda = new Panda();
        panda.adiniSoyle();
        ((Panda)panda).yuvarlan();
    }
    public static Canli rastgelSec() // calisma aninda atama nasil oluyor asagidaki yapi gosteriyor
    {
        int sec = (int)Math.random()*3;
        Canli canli;
        if(sec==0)
        {
            canli=new Canli();
        }
        else if(sec==1)
        {
            canli = new Kartal();
        }
        else
        {
            canli = new Panda();
        }
        return  canli;
    }
}
class Canli
{
    public void adiniSoyle()
    {
        System.out.println("Ben bir canli sinifi nesnesiyim ");
    }
}
class Kartal extends Canli
{
    @Override
    public void adiniSoyle() {
        System.out.println("Ben bir Kartal sinifi nesnesiyim");
    }
    public void uc()
    {
        System.out.println("Ben ucabilirim");
    }
}
class Panda extends Canli
{
    @Override
    public void adiniSoyle() {
        System.out.println("Ben bir Panda sinifi nesnesiyim");
    }
    public void yuvarlan()
    {
        System.out.println("Ben yuvarlanmayi cok severim");
    }
}
