package com.final2.readytomeet.kakaoLogin;

import com.final2.readytomeet.dto.UserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface KakaoMapper {
    @Insert("INSERT INTO USER (USER_ID, USER_PW, USER_PHONE, USER_EMAIL, USER_NAME, USER_NICKNAME, USER_AGE, USER_GENDER, USER_LOCATION) " +
            "VALUES (#{user_id}, #{user_pw}, #{user_phone}, #{user_email}, #{user_name}, #{user_nickname}, #{user_age}, #{user_gender}, #{user_location})")
    int insertUser(@Param("user_id") String user_id, @Param("user_pw") String user_pw, @Param("user_phone") String user_phone,
                   @Param("user_email") String user_email, @Param("user_name") String user_name, @Param("user_nickname") String user_nickname,
                   @Param("user_age") int user_age, @Param("user_gender") int user_gender, @Param("user_location") String user_location);
}

