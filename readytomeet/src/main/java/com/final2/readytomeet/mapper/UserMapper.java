package com.final2.readytomeet.Mapper;

import com.final2.readytomeet.dto.AppoDto;
import com.final2.readytomeet.dto.UserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    //Activity 전체 약속 검색
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_PLACE, DATE_FORMAT(APPO_DATE,'%m / %d %H:%i') FROM APPOINTMENT WHERE NOT APPO_CATEGORY IN ('카풀', '택시', '유급', '무급') ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectActivityAllList();
    @Insert(" INSERT INTO USER VALUES(#{user_id}, #{user) ")
    int insert(UserDto dto);
    @Select(" SELECT * FROM USER WHERE USER_ID=#{user_id} ")
    UserDto selectOne(String user_id);
    @Update(" UPDATE USER SET USER_NICKNAME=#{user_nickname}, USER_PW=#{user_pw}, USER_PHONE=#{user_phone}, USER_EMAIL=#{user_email}, USER_LOCATION=#{user_location}, USER_CONTENT=#{user_content} WHERE USER_ID=#{user_id} ")
    int update(UserDto dto);


}
