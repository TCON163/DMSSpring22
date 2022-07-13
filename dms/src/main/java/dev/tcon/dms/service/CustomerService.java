package dev.tcon.dms.service;

import dev.tcon.dms.entities.Address;
import dev.tcon.dms.entities.Customer;
import dev.tcon.dms.repo.AddressRepo;
import dev.tcon.dms.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final AddressRepo addressRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo,AddressRepo addressRepo){

        this.customerRepo =customerRepo;
        this.addressRepo = addressRepo;
    }

    public Customer create(Customer customer, Long id){

        Address address = addressRepo.getById(id);

        customer.setMailAddress(address);
        customer.setPhysicalAddress(address);

        return customerRepo.save(customer);
    }


    public List<Customer> getAll(){
        return customerRepo.findAll();
    }

    public Customer getById(Long id){return customerRepo.getById(id);}
}
