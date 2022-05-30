package dev.tcon.dms.controllers;

import dev.tcon.dms.DTO.FileDTO;
import dev.tcon.dms.DTO.ResponseMessage;
import dev.tcon.dms.entities.DataFile;
import dev.tcon.dms.entities.File;
import dev.tcon.dms.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @CrossOrigin
    @GetMapping("/file")
    public ResponseEntity<List<File>> getAll(){ return ResponseEntity.ok(fileService.getAllFiles());}

    @CrossOrigin
    @GetMapping("/file/{id}")
    public ResponseEntity<DataFile> getFileById(@PathVariable Long id){
        return ResponseEntity.ok(fileService.getFile(id));
    }

    @CrossOrigin
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile( @RequestBody FileDTO fileDTO){
        try{
            return ResponseEntity.ok(fileService.storeFile(fileDTO.getFormData(),fileDTO));
        }catch (IOException exception){
            return ResponseEntity.badRequest().body(new ResponseMessage("Unable to upload file"));
        }
    }
}
