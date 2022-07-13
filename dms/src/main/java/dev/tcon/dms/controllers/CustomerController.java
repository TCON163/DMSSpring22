package dev.tcon.dms.controllers;

import dev.tcon.dms.entities.Customer;
import dev.tcon.dms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAll(){return ResponseEntity.ok(customerService.getAll());}
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getById(id));
    }

    @PostMapping("/customer/address/{id}")
    public ResponseEntity<Customer> getById(@RequestBody Customer customer, @PathVariable Long id){
        return ResponseEntity.ok(customerService.create(customer, id));
    }
}
