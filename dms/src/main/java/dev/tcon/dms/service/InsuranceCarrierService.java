package dev.tcon.dms.service;

import dev.tcon.dms.entities.InsuranceCarrier;
import dev.tcon.dms.repo.InsuranceCarrierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceCarrierService {
    private final InsuranceCarrierRepo insuranceCarrierRepo;

    @Autowired
    public InsuranceCarrierService(InsuranceCarrierRepo insuranceCarrierRepo){
        this.insuranceCarrierRepo =insuranceCarrierRepo;
    }


    public InsuranceCarrier create(InsuranceCarrier insuranceCarrier){
        return insuranceCarrierRepo.save(insuranceCarrier);
    }
}
