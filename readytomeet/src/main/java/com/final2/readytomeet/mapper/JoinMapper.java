package com.final2.readytomeet.Mapper;

import com.final2.readytomeet.dto.JoinDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JoinMapper {
    @Insert("INSERT INTO USER(USER_ID, USER_PW, USER_PHONE, USER_EMAIL, USER_NAME, USER_NICKNAME, USER_AGE, USER_GENDER, USER_LOCATION) " +
            "VALUES (#{USER_ID}, #{USER_PW}, #{USER_PHONE}, #{USER_EMAIL}, #{USER_NAME}, #{USER_NICKNAME}, #{USER_AGE}, #{USER_GENDER}, #{USER_LOCATION})")

    void insertUser(JoinDto joinDto);

}
