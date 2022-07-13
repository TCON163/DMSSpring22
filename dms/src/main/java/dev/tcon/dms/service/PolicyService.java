package dev.tcon.dms.service;

import dev.tcon.dms.entities.Policy;
import dev.tcon.dms.repo.PolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

    private final PolicyRepo policyRepo;

    @Autowired
    public PolicyService(PolicyRepo policyRepo){
        this.policyRepo =policyRepo;
    }

    public Policy create(Policy policy){
        return policyRepo.save(policy);
    }
}
