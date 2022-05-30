package dev.tcon.dms.service;

import dev.tcon.dms.DTO.FileDTO;
import dev.tcon.dms.entities.DataFile;
import dev.tcon.dms.entities.File;
import dev.tcon.dms.entities.SubmissionFolder;
import dev.tcon.dms.repo.DataFileRepo;
import dev.tcon.dms.repo.FileRepo;
import dev.tcon.dms.repo.SubmissionFolderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Service
public class FileService {

    private final FileRepo fileRepo;
    private final DataFileRepo dataFileRepo;
    private final SubmissionFolderRepo submissionFolderRepo;

    @Autowired
    public FileService(FileRepo fileRepo, DataFileRepo dataFileRepo, SubmissionFolderRepo submissionFolderRepo){
        this.fileRepo =fileRepo;
        this.dataFileRepo = dataFileRepo;
        this.submissionFolderRepo = submissionFolderRepo;
    }



    public File storeFile(MultipartFile file, FileDTO fileDTO) throws IOException{

        SubmissionFolder submissionFolder = submissionFolderRepo.getById(fileDTO.getSubmissionFolderId());

        File upload = new File();
        upload.setAppFileName(fileDTO.getAppFileName());
        upload.setFileName(StringUtils.cleanPath(file.getOriginalFilename()));
        upload.setFileType(StringUtils.cleanPath(file.getContentType()));
        upload.setFolder(fileDTO.getFolder());
        upload.setSubfolder(fileDTO.getSubfolder());
        upload.setSubmissionFolder(submissionFolder);

        upload =fileRepo.saveAndFlush(upload);


        DataFile dataFile = new DataFile();
        dataFile.setFile(upload);
        dataFile.setData(file.getBytes());

        dataFile = dataFileRepo.saveAndFlush(dataFile);

        upload.setDataFile(dataFile);

        upload = fileRepo.saveAndFlush(upload);
        submissionFolder.getFiles().add(upload);
        submissionFolderRepo.saveAndFlush(submissionFolder);

        return upload;


    }


    public List<File> getAllFiles(){return fileRepo.findAll();}

    public Set<File> getAllFilesInFolder(Long id){
        SubmissionFolder submissionFolder = submissionFolderRepo.getById(id);
        return fileRepo.getSetOfFilesBySubmissionFolder(submissionFolder);
    }


    public DataFile getFile(Long id){
        return  dataFileRepo.getById(id);
    }
}
