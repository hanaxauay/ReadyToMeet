package com.final2.readytomeet.Mapper;


import com.final2.readytomeet.dto.CommunityDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserPageMapper {


    @Select("SELECT * FROM SHARE ORDER BY SHARE_SEQ DESC")
    List<CommunityDto> selectList();
    @Select(" SELECT * FROM SHARE WHERE SHARE_SEQ=#{SHARE_SEQ}")
    CommunityDto selectOne(int share_seq);
    @Select("SELECT COUNT(*) AS TOTAL_COUNT FROM SHARE")
    int findAllCnt();
    @Select("SELECT * FROM SHARE ORDER BY SHARE_SEQ DESC LIMIT #{startIndex}, #{pageSize}")
    List<CommunityDto> findListPaging(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);



}
