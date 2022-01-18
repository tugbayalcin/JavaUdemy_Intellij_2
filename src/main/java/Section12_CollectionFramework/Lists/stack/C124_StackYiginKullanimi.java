package Section12_CollectionFramework.Lists.stack;

import java.util.LinkedList;
import java.util.Stack;

public class C124_StackYiginKullanimi
{
    public static void main(String[] args) {
        Stack<String> yigin = new Stack<>(); // herhangi bir parametre alan constructor'i yoktur
        // first in last out  yani ilk giren son cikar mantigiyla calisir
        // ust uste dizilmis kitaplar veya tabaklar olarak dusunebilirsin

        // documantasyonuna baktigimizda vector class'indan extends edildigini (turetildigini) goruruz
        // yani vector'un ozel bir halidir
        // methodlarin cogu synchronized olarak tanimlanmistir

        // Bunun alternatifi olarak LinkedList kullanilabilir

        yigin.add("Tugba");
        yigin.add("Asel");
        yigin.add("Ayse");
        System.out.println(yigin);
        // yazdirirken normal sirali olarak yazdirdi
        // ilk giren son cikar mantigini gormek istiyorsan methodlari kullanmalisin

        System.out.println(yigin.pop()); // yiginin en son elemanini dondurur ve bunu bize gosterdikten sonra yigindan cikarir
        System.out.println(yigin);
        System.out.println(yigin.peek()); // en sondaki elemani gosterir ama yigindan cikarmaz
        System.out.println(yigin);
        System.out.println(yigin.push("Nil")); // en sona nil degeri eklendi
        System.out.println();
        System.out.println(yigin.isEmpty()); // yiginin bos olup olmadigini kontrol eder
        System.out.println(yigin);
        System.out.println(yigin.search("narin")); // listede yoksa negatif deger donduruyor
        System.out.println(yigin.search("Asel")); // eleman kacinci siradaysa onu verir, indisi degil !!!
        System.out.println(yigin.search("asel")); // case sensitive

        // Bu yapi yerine LinkedList'i nasil kullaniriz ona bakalim:
        LinkedList<String> yigin2 = new LinkedList<>();
        yigin2.push("Zeynep");
        yigin2.push("Ece");
        yigin2.push("Meryem"); // push ile ekledigimizde en son eklenen en basta 1. sirada gorunur
        System.out.println(yigin2);
        // add ile ekledigimizde ilk ekledigimiz 1, ikinci ekledigimiz 2 olur ve pop ile cikarirken 2 cikartilir
        // yine son eklenen cikarilmis olur
        // push ile ekledigimizde ilk ekledigimiz 1, ikinci eleman ekledigimizde artik bu eleman 1 onceki eleman 2 olur ve
        // pop ile cikarirken daima 1 olan eleman cikarilir yani son eklenen cikarilir
        // pushlarin arasinda add diyerek ortaligi biraz karistiralim :)
        yigin2.push("Elif"); // basa ekliyor (soldan ekliyor, sol bastan)
        yigin2.push("Dilber");
        yigin2.add("Beyza"); // sona ekliyor (sagdan ekliyor, sag bastan)
        yigin2.push("Begum");
        System.out.println(yigin2);

        System.out.println(yigin2.pop()); // son elemani gosterecek yani en ustteki elemani ve yigindan cikaracak
        System.out.println(yigin2);


    }
}
