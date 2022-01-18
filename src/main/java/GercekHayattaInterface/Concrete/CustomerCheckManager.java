package GercekHayattaInterface.Concrete;

import GercekHayattaInterface.Abstract.ICustomerCheckService;
import GercekHayattaInterface.Entities.Customer;

public class CustomerCheckManager implements ICustomerCheckService {

    @Override
    public boolean checkIfRealPerson(Customer customer)
    {
        //Normalde bu methodun icine kodlar yazilir
        //Elimizde bilgilerle olusturulan customer gercekten TC vatandasi mi diye devletin database'ine bakilarak kontrol edilir

        //ama biz simdilik sanki kontrol edilmis ve gercekten customer1'in tc vatandasi oldugunu tastiklemisiz gibi davrancaz
        //ve checkIfRealPerson() methodundan true degerini retunr edicez

        return true;
    }
}
