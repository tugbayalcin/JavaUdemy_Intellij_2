package GercekHayattaInterface;
import GercekHayattaInterface.Abstract.BaseCustomerManager;
import GercekHayattaInterface.Concrete.NeroCustomerManager;
import GercekHayattaInterface.Concrete.StarbucksCustomerManager;
import GercekHayattaInterface.Entities.Customer;

import java.util.Date;

public class InterfaceKullanimi {
    public static void main(String[] args) throws Exception

    {
        GercekHayattaInterface.Abstract.BaseCustomerManager customerManager = new NeroCustomerManager();//Polimorphism

        //Default Constructor ile ilgili Note olsun diye yazdik
        //customerManager.save(new Customer());//new Customer() bir degiskene atanmamis bir objesir.
                                            // Heap'te olusturdugu alanin icinde 5 tane degisken vardir
                                            //Bu 5 degiskenin degerleri de suanlik default'tur




        Date date1=new Date();//Heapte olusturdugu date1 alaninin icinde -> Sun Oct 10 00:36:40 EET 2021  yazar
        System.out.println(date1);//Date Class'inin icinde toString() Methodu override edildigi icin sout() ile objenin
                                    //reference numarasini degil icini yazdirabildik

        //5 tane bilgisi olan customer1 objesini heap bellek'te creat ettik
        GercekHayattaInterface.Entities.Customer customer1=new GercekHayattaInterface.Entities.Customer(7,"Tugba","Yalcin",date1,"12345678910");


        //Nero isletmesi database'ine Customer save ediyor, bu icin de NeroCustomerManager Class'inin icindeki save methodunu kullaniyor
        customerManager.save(customer1);





        System.out.println("\n-------------------------------------------------------------------\n");


        //Starbucks Isletmesi Database'ine Customer  Class'ina ait bir Objeyi kaydetmek istiyor, HADI YAPALIM
         BaseCustomerManager customerManager2 = new StarbucksCustomerManager();//Polimorphism
         customerManager2.save(new Customer(11,"Asel","Yalcin",new Date(),"98765432100"));




    }


}
