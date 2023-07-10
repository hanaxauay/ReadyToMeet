package com.final2.readytomeet.Mapper;

import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.dto.UserDto;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;



import java.util.List;


@Mapper
public interface UserMapper {
//    @Select(" SELECT user_id, user_phone, user_email, user_name, user_nickname, user_age, user_gender, user_location FROM USER ORDER BY user_id ")
    @Select(" SELECT * FROM USER ORDER BY user_id")
    List<UserDto> list();

    @Select(" SELECT * FROM USER WHERE USER_ID=#{user_id} ")
    UserDto selectOne(String user_id);

    //note 유저 정보 보기
    @Select(" SELECT * FROM USER WHERE USER_ID=#{user_id} ")
    UserDto readUser(String user_id);

    @Delete(" DELETE FROM USER WHERE USER_ID=#{user_id} ")
    UserDto deleteUser(String user_id);


    //    @Select(" SELECT * FROM USER WHERE USER_ID=#{user_id} ")
//    UserDto getUserById(String user_id);

    //
//    @Update(" UPDATE USER SET USER_NICKNAME=#{user_nickname}, USER_PW=#{user_pw}, USER_PHONE=#{user_phone}, USER_EMAIL=#{user_email}, USER_LOCATION=#{user_location}, USER_CONTENT=#{user_content} WHERE USER_ID=#{user_id} ")
//    void updateUser(UserDto dto);
//
//

    @Select("SELECT COUNT(*) AS TOTAL_COUNT FROM SHARE")
    int findAllCnt();
    @Select("SELECT * FROM SHARE ORDER BY SHARE_SEQ DESC LIMIT #{startIndex}, #{pageSize}")
    List<CommunityDto> findListPaging(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);


}
