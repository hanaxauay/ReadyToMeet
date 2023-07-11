package com.final2.readytomeet.Mapper;

import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.dto.UserDto;
import org.apache.ibatis.annotations.*;



import java.util.List;


@Mapper
public interface UserMapper {

    //note 회원 리스트 출력
    @Select(" SELECT * FROM USER ORDER BY ID ")
    List<UserDto> list();

    
    //note 유저 정보 보기
    @Select(" SELECT * FROM USER WHERE ID=#{id} ")
    UserDto readUser(int id);

    //note 로그인 시 필요
    @Select(" SELECT * FROM USER WHERE USER_ID=#{user_id} ")
    UserDto loginUser(String user_id);

    @Select(" SELECT * FROM USER WHERE ID=#{id} ")
    UserDto selectOne(Integer id);



    @Insert(" INSERT INTO USER VALUES (#{user_img}, #{user_path}) ")
    int write(UserDto dto);

//    @Update(" UPDATE USER SET USER_NICKNAME=#{user_nickname}, USER_PW=#{user_pw}, USER_PHONE=#{user_phone}, USER_EMAIL=#{user_email}, USER_LOCATION=#{user_location}, USER_CONTENT=#{user_content} WHERE ID=#{id} ")
//    void update(UserDto userDto);

    @Update(" UPDATE USER SET USER_ID=#{user_id}, USER_PW=#{user_pw}, USER_PHONE=#{user_phone}, USER_EMAIL=#{user_email}, USER_NAME=#{user_name}, USER_NICKNAME=#{user_nickname}, USER_AGE=#{user_age}, USER_GENDER=#{user_gender}, USER_LOCATION=#{user_location} WHERE ID=#{id} ")
    Integer update(Integer id);
    

}
