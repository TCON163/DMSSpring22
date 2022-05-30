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



    public void storeFile(FileDTO fileDTO) throws IOException{
        File newFile = new File();

        newFile.setFileName(fileDTO.getFileName());
        newFile.setFileType(fileDTO.getFileType());
        newFile.setData(fileDTO.getData());

        fileRepo.save(newFile);





    }


    public List<File> getAllFiles(){return fileRepo.findAll();}




    public DataDTO getFile(Long id){


        File file =  fileRepo.getById(id);

        DataDTO data = new DataDTO();
        data.setFileExtension(file.getFileType());
        data.setFilename(file.getFileName());
        data.setData(file.getData());

        return data;
    }
}
