package dev.tcon.dms.controllers;

import dev.tcon.dms.entities.SubmissionFolder;
import dev.tcon.dms.service.SubmissionFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SubmissionFolderController {

    private final SubmissionFolderService service;

    @Autowired
    public SubmissionFolderController(SubmissionFolderService service){this.service = service;}

    @CrossOrigin
    @GetMapping("/submissionFolder")
    public ResponseEntity<List<SubmissionFolder>> getAllFolders(){return ResponseEntity.ok(service.getAll());}

    @CrossOrigin
    @GetMapping("/submissionFolder/{id}")
    public ResponseEntity<SubmissionFolder> getFolderbyID(@PathVariable Long id){return ResponseEntity.ok(service.getByID(id));}

    @CrossOrigin
    @PostMapping("/submissionFolder")
    public ResponseEntity<SubmissionFolder> createFolder(@RequestBody SubmissionFolder folder){
        return ResponseEntity.ok(service.createOrSave(folder));
    }
}
