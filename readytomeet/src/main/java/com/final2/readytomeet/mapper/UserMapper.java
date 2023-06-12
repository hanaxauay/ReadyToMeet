package com.final2.readytomeet.Mapper;

import com.final2.readytomeet.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select(" SELECT * FROM USER WHERE USER_ID=#{user_id} ")
    UserDto selectOne(String user_id);
    @Update(" UPDATE USER SET USER_NICKNAME=#{user_nickname}" +
            "USER_PW=#{user_pw}, USER_PHONE=#{user_phone}" +
            "USER_EMAIL=#{user_email}, USER_LOCATION=#{user_location}, USER_CONTENT=#{user_content} ")
    int update(UserDto dto);


}
