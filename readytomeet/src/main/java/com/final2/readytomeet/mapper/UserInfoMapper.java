package com.final2.readytomeet.Mapper;

import com.final2.readytomeet.dto.UserInfoDto;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface UserInfoMapper {

    //채팅방 참여인원 저장

    //--------------------------------select---------------------------------

    //한 약속의 참여유저 검색
    @Select(" SELECT * FROM USERINFO WHERE APPO_SEQ=#{appo_seq} ")
    //UserInfoDto selectUserInfo(int appo_seq);
    List<UserInfoDto> selectUserInfolList(int appo_seq);


    //--------------------------------insert---------------------------------
    //약속 참여
    @Insert(" INSERT INTO USERINFO VALUES(#{user_id}, #{appo_seq} ")
    int insertUserInfo(UserInfoDto userinfodto);


    //--------------------------------delete---------------------------------
    //약속 취소
    @Delete(" DELETE FROM USERINFO WHERE USER_ID=#{user_id} ")
    int deleteUserInfoId(String user_id);
    //약속 삭제
    @Delete(" DELETE FROM USERINFO WHERE APPO_SEQ=#{appo_seq} ")
    int deleteUserInfoAppo(int appo_seq);

}














