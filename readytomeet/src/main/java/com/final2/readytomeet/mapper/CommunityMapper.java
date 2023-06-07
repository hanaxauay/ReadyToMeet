package com.final2.readytomeet.mapper;

import com.final2.readytomeet.dto.CommunityDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityMapper {

  @Insert("INSERT INTO SHARE VALUES (NULL, #{share_category}, #{share_title}, #{share_content},NOW(), 'admin', #{filename}, #{filepath})")
  int write(CommunityDto dto);








}
