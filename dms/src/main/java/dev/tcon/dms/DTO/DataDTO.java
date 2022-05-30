package dev.tcon.dms.DTO;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class DataDTO {

    private String filename;
    private String fileExtension;

    private byte[] data;
}
