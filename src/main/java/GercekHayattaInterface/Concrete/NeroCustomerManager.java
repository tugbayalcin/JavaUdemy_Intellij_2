package GercekHayattaInterface.Concrete;

import GercekHayattaInterface.Abstract.BaseCustomerManager;
import GercekHayattaInterface.Entities.Customer;

public class NeroCustomerManager extends BaseCustomerManager {

    //Nero check etmeden customer'i direk save ediyor
    @Override
    public void save(Customer customer) throws Exception
    {
        super.save(customer);
        System.out.println("NeroCustomerManager Classinda override edilmis save(Customer c) methodu calisti " +
                "ve customer kaydedildi!!!");
    }
}
