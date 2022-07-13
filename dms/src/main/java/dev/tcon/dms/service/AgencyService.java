package dev.tcon.dms.service;

import dev.tcon.dms.entities.Address;
import dev.tcon.dms.entities.Agency;
import dev.tcon.dms.entities.Agent;
import dev.tcon.dms.repo.AddressRepo;
import dev.tcon.dms.repo.AgencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {

    private final AgencyRepo agencyRepo;
    private final AddressRepo addressRepo;

    @Autowired
    public AgencyService(AgencyRepo agencyRepo, AddressRepo addressRepo){
        this.addressRepo= addressRepo;
        this.agencyRepo =agencyRepo;
    }


    public Agency create(Agency agency, Long id){
        Address address = addressRepo.getById(id);

        agency.setMailAddress(address);
        agency.setPhysicalAddress(address);
        agency.setSameMailingAndPhysicalAddress(true);

        return agencyRepo.save(agency);
    }


    public List<Agency> getAll(){return agencyRepo.findAll();}

    public Agency getById(Long id){
        return agencyRepo.getById(id);
    }
}
