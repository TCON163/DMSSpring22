package dev.tcon.dms.service;

import dev.tcon.dms.entities.InsuranceMarket;
import dev.tcon.dms.repo.InsuranceMarketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceMarketService {

    private final InsuranceMarketRepo insuranceMarketRepo;

    @Autowired
    public InsuranceMarketService(InsuranceMarketRepo insuranceMarketRepo){
        this.insuranceMarketRepo =insuranceMarketRepo;
    }


    public InsuranceMarket create(InsuranceMarket insuranceMarket){
      return   insuranceMarketRepo.save(insuranceMarket);
    }

    public List<InsuranceMarket> getAll(){
        return insuranceMarketRepo.findAll();
    }

    public InsuranceMarket getById(Long id){
        return insuranceMarketRepo.getById(id);
    }
}
