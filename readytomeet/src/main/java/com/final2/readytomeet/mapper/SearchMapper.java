package com.final2.readytomeet.Mapper;

import com.final2.readytomeet.dto.AppoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {

    List<AppoDto> selectAllAppos(String keyword);
}
