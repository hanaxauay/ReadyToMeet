package com.final2.readytomeet.repository;

import com.final2.readytomeet.dto.ImageUploadDto;
import org.springframework.web.multipart.MultipartFile;

public interface ImageRepository {
    public void write(ImageUploadDto dto, MultipartFile file) throws Exception;
}
