package GercekHayattaInterface.Abstract;

import GercekHayattaInterface.Entities.Customer;

public abstract class BaseCustomerManager implements ICustomerServices
{
    @Override
    public void save(Customer customer) throws Exception
    {
        System.out.println("---------    Save "+customer.getFirstName().toUpperCase()+" to DB    -----------");
    }
}
