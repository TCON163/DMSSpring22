package dev.tcon.dms.service;

import dev.tcon.dms.DTO.DataDTO;
import dev.tcon.dms.DTO.FileDTO;
import dev.tcon.dms.entities.File;


import dev.tcon.dms.repo.FileRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class FileService {

    private final FileRepo fileRepo;



    @Autowired
    public FileService(FileRepo fileRepo ){
        this.fileRepo =fileRepo;

    }



    public File storeFile(FileDTO fileDTO) throws IOException{
        File newFile = new File();

        newFile.setFileName(fileDTO.getFileName());
        newFile.setFileType(fileDTO.getFileType());
        newFile.setData(fileDTO.getData());

        return  fileRepo.save(newFile);





    }


    public List<File> getAllFiles(){return fileRepo.findAll();}




    public File getFile(Long id){


        return fileRepo.getById(id);


    }
}
