package com.final2.readytomeet.service.impl;


import com.final2.readytomeet.dto.UserInfoDto;
import com.final2.readytomeet.repository.UserInfoRepository;
import com.final2.readytomeet.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userinforepository;

    //참여 유저 검색
    @Override
    public List<UserInfoDto> selectUserInfolList(int appo_seq) {
        return userinforepository.selectUserInfolList(appo_seq);
    }

    //약속 참여
    @Override
    public int insertUserInfo(UserInfoDto userinfodto) {
        return userinforepository.insertUserInfo(userinfodto);
    }

    //약속 취소
    @Override
    public int deleteUserInfoId(String user_id) {
        return userinforepository.deleteUserInfoId(user_id);
    }

}
