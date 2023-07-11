package com.final2.readytomeet.service;

import com.final2.readytomeet.dto.UserInfoDto;

import java.util.List;

public interface UserInfoService {

    List<UserInfoDto> selectUserInfolList(int appo_seq);
    int insertUserInfo(UserInfoDto userinfodto);
    int deleteUserInfoId(String user_id);
}
