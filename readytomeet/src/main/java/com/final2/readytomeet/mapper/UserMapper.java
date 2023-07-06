package com.final2.readytomeet.Mapper;

import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.dto.UserDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
@Repository
public interface UserMapper {

    public List<Map<String, Object>> getUser();

    public UserDto readUser(String user_Id);





//    @Update(" UPDATE USER SET USER_IMG=#{user_img}, USER_PATH=#{user_path} WHERE USER_ID=#{user_id} ")
//    int upload(UserDto dto);
//
//    // 회원 프로필 이미지 변경
//    @Update(" UPDATE USER SET user_img=#{user_img} WHERE user_id=#{user_id} ")
//    void updateUimage(UserDto dto);
//
////    @Select(" SELECT * FROM USER WHERE USER_ID=#{user_id} ")
////    UserDto readUser(String user_id);
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
