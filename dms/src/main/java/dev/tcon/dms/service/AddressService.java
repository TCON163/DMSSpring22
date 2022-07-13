package dev.tcon.dms.service;

import dev.tcon.dms.entities.Address;
import dev.tcon.dms.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepo addressRepo;

    @Autowired
    public AddressService(AddressRepo addressRepo){
        this.addressRepo =addressRepo;
    }


    public Address create(Address address){
        return addressRepo.save(address);
    }
}
