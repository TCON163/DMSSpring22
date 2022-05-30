package dev.tcon.dms.service;


import dev.tcon.dms.entities.SubmissionFolder;
import dev.tcon.dms.exceptions.ResourceNotFound;
import dev.tcon.dms.repo.SubmissionFolderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionFolderService {

    private final SubmissionFolderRepo submissionFolderRepo;

    @Autowired
    public SubmissionFolderService(SubmissionFolderRepo submissionFolderRepo) {this.submissionFolderRepo = submissionFolderRepo;}


    public List<SubmissionFolder> getAll() {return submissionFolderRepo.findAll();}

    public SubmissionFolder getByID(Long id){
        return submissionFolderRepo.findById(id).orElseThrow(()-> new ResourceNotFound("No submission folder with id of "+id));
    }

    public SubmissionFolder createOrSave(SubmissionFolder submissionFolder){ return submissionFolderRepo.saveAndFlush(submissionFolder);}
}
