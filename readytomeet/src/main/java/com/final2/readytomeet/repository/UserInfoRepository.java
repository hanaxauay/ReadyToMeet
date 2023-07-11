package com.final2.readytomeet.repository;


import com.final2.readytomeet.dto.UserInfoDto;

import java.util.List;

public interface UserInfoRepository {
    List<UserInfoDto> selectUserInfolList(int appo_seq);
    int insertUserInfo(UserInfoDto userinfodto);
    int deleteUserInfoId(String user_id);
    int deleteUserInfoAppo(int appo_seq);
}
