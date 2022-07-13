package dev.tcon.dms.controllers;

import dev.tcon.dms.entities.Address;
import dev.tcon.dms.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAll(){return ResponseEntity.ok(addressService.getAll());}
    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getById(id));
    }

    @PostMapping("/address")
    public ResponseEntity<Address> getById(@RequestBody Address address){
        return ResponseEntity.ok(addressService.create(address));
    }
}
