package com.final2.readytomeet.Mapper;

import com.final2.readytomeet.dto.CommunityDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommunityMapper {

    @Select("SELECT * FROM SHARE ORDER BY SHARE_SEQ DESC")
    List<CommunityDto> selectList();
    @Insert("INSERT INTO SHARE VALUES (NULL, #{share_category}, #{share_title}, #{share_content},NOW(),  #{user_id}, #{filename}, #{filepath}, 0, #{user_nickname})")
    int write(CommunityDto dto);
    @Select(" SELECT * FROM SHARE WHERE SHARE_SEQ=#{SHARE_SEQ}")
    CommunityDto selectOne(int share_seq);
    @Update(" UPDATE SHARE SET SHARE_CATEGORY=#{share_category},SHARE_TITLE=#{share_title}, SHARE_CONTENT=#{share_content} WHERE SHARE_SEQ=#{share_seq}")
    int update(CommunityDto dto);
    @Delete(" DELETE FROM SHARE WHERE SHARE_SEQ=#{SHARE_SEQ} ")
    int delete(int share_seq);
    @Update("UPDATE SHARE SET SHARE_VIEW = SHARE_VIEW + 1 WHERE SHARE_SEQ = #{share_seq}")
    int updateViewCount(int share_seq);
    @Select("SELECT COUNT(*) AS TOTAL_COUNT FROM SHARE")
    int findAllCnt();
    @Select("SELECT * FROM SHARE ORDER BY SHARE_SEQ DESC LIMIT #{startIndex}, #{pageSize}")
    List<CommunityDto> findListPaging(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);
}