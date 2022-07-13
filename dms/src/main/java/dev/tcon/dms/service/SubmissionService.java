package dev.tcon.dms.service;

import dev.tcon.dms.entities.Submission;
import dev.tcon.dms.repo.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {
    private final SubmissionRepo submissionRepo;
    @Autowired
    public SubmissionService(SubmissionRepo submissionRepo){
        this.submissionRepo =submissionRepo;
    }

    public Submission create(Submission submission){
        return submissionRepo.save(submission);
    }
}
