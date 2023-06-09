package com.final2.readytomeet.Mapper;

import com.final2.readytomeet.dto.ImageUploadDto;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageMapper {
    @Insert(" INSERT INTO IMG VALUES(#{filename}, #{filepath}) ")
    int upload(ImageUploadDto dto);

}
