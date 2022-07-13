package dev.tcon.dms.service;

import dev.tcon.dms.entities.Customer;
import dev.tcon.dms.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo =customerRepo;
    }

    public Customer create(Customer customer){
        return customerRepo.save(customer);
    }
}
