package GercekHayattaInterface.Concrete;

import GercekHayattaInterface.Abstract.BaseCustomerManager;
import GercekHayattaInterface.Abstract.ICustomerCheckService;
import GercekHayattaInterface.Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager //implements ICustomerCheckService
{
    //NOTE1
    //Bir class sadece 1 tane class/Abstract class extend edebilir.
    //Bir class 1'den fazla interface implement edebilir
    //Bir class hem extend hem implement edecekse, extend islemi ilk yapilir,sonra implement islemi yapilir


    //NOTE2 : DEPENDENCY INJECTION KONUSU
    //StarbucksCustomerManager Class'i ICustomerCheckService Interface'ini icindeki sadece ve sadece save abstract methodunun kullanmak isterse
    //public class StarbucksCustomerManager implements ICustomerCheckService yazmamiz dogru olmaz
    //cunku interface'in icindeki tum absract methodlari tek tek OVERRIDE etmek xorunda kalicaz, isimize yaramasa bile
    //bunu yapmamak icin asagida Dependency Injection Ozelligini kullanicaz




    ICustomerCheckService iCustomerCheckService; //interface'den bir obje DECLARE ettik


    //StarbucksCustomerManager Class'i icin bir default constructor methodu olusturduk
    public StarbucksCustomerManager()
    {
        //Section10'da ogrendik -> Interface'lerden direk obje olusturulamaz, cunku Interface'lerin constructorlari olamaz
        //Declaration Type olarak yazilabilir ='den sonraki ifade ise class/abstract class'a ait bir constructor  olmaliydi
        //cunku obje sadece ve sadece bu 2 yapidan olusturulabilir.
        iCustomerCheckService= new CustomerCheckManager();//Initializing Type:CustomerCheckManager

        //Yani -> bu consructor sayesinde CustomerCheckManager() classinin icindeki checkIfRealCustomer(Customer c) methoduna
        // erisebilmek icin bir nesne/object olusturduk, bu nesneyi de save(Customer c) methodunun icinde kullancaz.
    }



    @Override
    public void save(Customer customer) throws Exception  //BaseCustomerManager Abstract Super Class'dan Geldi.
    {                                                     //save methodu istisna firlatabilme kabiliyetine sahiptir - throws Exception


        if(iCustomerCheckService.checkIfRealPerson(customer))
        {
            //super.save(customer);
            /*
            System.out.println("BaseCustomerManager Super Abstract Class'inin icindeki save(Customer c)" +
                    "methodunu StarbucksCustomerManager SubClass'inda override ettik " +
                    "ama superdaki gorevine ilave bir sey yaptirmasaydik override etmeye gerek olmazdi" +
                    "yani sacma bir olay olurdu - hic override etmeden direk super'dan kullanmak gerekirdi");

            */

            //tamamen kendimiz yazmak istiyoruz methodun icini
            System.out.println("---------    Save "+customer.getFirstName().toUpperCase()+" to STARBUCKS's DB    -----------");

        }
        else
        {
             System.out.println("Bu Customer TC Vatandasi degildir, Yani checkIfRealCustomer(Customer c) methodu false return etti" +
                      " bu yuzden customer starbuck databes'ine kaydedilemedi");

             throw new Exception("Customer is invalid!!!");
             //Bu method, customer gercek degilse UNCHECKED bir istisna(exception) olusturabilir
            //bu ihtimali methoda bildirmek icin, bak senin body'inde bir kod var istisna olusturabilir haberin olsun demek icin
            //methodun signature'ina bu bilgilendirmeyi yazariz
            //BILGILENDIRDIKTEN SONRA COMPILER KIRMIZI YAKMAYI BIRAKIR
        }

    }




}
