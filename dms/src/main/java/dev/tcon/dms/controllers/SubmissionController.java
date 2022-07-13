package dev.tcon.dms.controllers;

import dev.tcon.dms.entities.Submission;
import dev.tcon.dms.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SubmissionController {

    private final SubmissionService submissionService;

    @Autowired
    public SubmissionController(SubmissionService submissionService){
        this.submissionService = submissionService;
    }

    @GetMapping("/submission")
    public ResponseEntity<List<Submission>> getAll(){return ResponseEntity.ok(submissionService.getAll());}
    @GetMapping("/submission/{id}")
    public ResponseEntity<Submission> getById(@PathVariable Long id){
        return ResponseEntity.ok(submissionService.getById(id));
    }

    @PostMapping("/submission/customer/{customerId}/agency/{agencyId}")
    public ResponseEntity<Submission> getById(@RequestBody Submission submission, @PathVariable Long customerId, @PathVariable Long agencyId){
        return ResponseEntity.ok(submissionService.create(submission, customerId,agencyId));
    }
}
