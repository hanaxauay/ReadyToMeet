package com.final2.readytomeet.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

/*
*
* 이미지 업로드 dto
*
* */
@Data

public class ImageUploadDto {

    private String filename;

    private String filepath;

    public ImageUploadDto(){
        super();
    }

    public ImageUploadDto(String filename, String filepath) {
        this.filename = filename;
        this.filepath = filepath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

}
