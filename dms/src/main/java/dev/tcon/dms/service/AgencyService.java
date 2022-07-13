package dev.tcon.dms.service;

import dev.tcon.dms.entities.Agency;
import dev.tcon.dms.repo.AgencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgencyService {

    private final AgencyRepo agencyRepo;

    @Autowired
    public AgencyService(AgencyRepo agencyRepo){
        this.agencyRepo =agencyRepo;
    }


    public Agency create(Agency agency){
        return agencyRepo.save(agency);
    }
}
