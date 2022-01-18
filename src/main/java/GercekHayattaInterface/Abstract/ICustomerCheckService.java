package GercekHayattaInterface.Abstract;

import GercekHayattaInterface.Entities.Customer;

public interface ICustomerCheckService
{
    boolean checkIfRealPerson(Customer customer);
}
