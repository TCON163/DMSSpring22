package dev.tcon.dms.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FileDTO {

    private String appFileName;

    private String fileName;

    private String fileType;

    private String folder;

    private String subfolder;

    private Long submissionFolderId;

    private byte[] data;




}
