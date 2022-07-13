package dev.tcon.dms.service;

import dev.tcon.dms.entities.Agency;
import dev.tcon.dms.entities.Customer;
import dev.tcon.dms.entities.Submission;
import dev.tcon.dms.repo.AgencyRepo;
import dev.tcon.dms.repo.CustomerRepo;
import dev.tcon.dms.repo.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {
    private final SubmissionRepo submissionRepo;
    private final CustomerRepo customerRepo;
    private final AgencyRepo agencyRepo;
    @Autowired
    public SubmissionService(SubmissionRepo submissionRepo,CustomerRepo customerRepo, AgencyRepo agencyRepo){
        this.customerRepo = customerRepo;
        this.agencyRepo = agencyRepo;
        this.submissionRepo =submissionRepo;
    }

    public Submission create(Submission submission, Long customerId, Long agencyId){
        Customer customer = customerRepo.getById(customerId);
        Agency agency = agencyRepo.getById(agencyId);

        submission.setAgency(agency);
        submission.setCustomer(customer);

        return submissionRepo.save(submission);
    }

    public List<Submission> getAll(){return submissionRepo.findAll();}

    public Submission getById(Long id){
        return submissionRepo.getById(id);
    }
}
