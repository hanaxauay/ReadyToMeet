package com.final2.readytomeet.repository.impl;


import com.final2.readytomeet.Mapper.UserInfoMapper;
import com.final2.readytomeet.dto.UserInfoDto;
import com.final2.readytomeet.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class UserInfoRepositoryImpl implements UserInfoRepository {


    @Autowired
    private UserInfoMapper userinfomapper;


    @Override
    public List<UserInfoDto> selectUserInfolList(int appo_seq) {
        List<UserInfoDto> res = new ArrayList<UserInfoDto>();
        res = userinfomapper.selectUserInfolList(appo_seq);
        return res;
    }

    //한 약속 검색
//    @Override
//    public AppoDto selectAppointmentOneList(int appo_seq) {
//        AppoDto res = null;
//        res = appomapper.selectAppointmentOneList(appo_seq);
//        return res;
//    }

    //약속첨여
    @Override
    public int insertUserInfo(UserInfoDto userinfodto) {
        int res = 0;
        res = userinfomapper.insertUserInfo(userinfodto);
        return res;
    }

    //약속 취소
    @Override
    public int deleteUserInfoId(String user_id) {
        int res = 0;
        res = userinfomapper.deleteUserInfoId(user_id);
        return res;
    }

    //약속 삳제
    @Override
    public int deleteUserInfoAppo(int appo_seq) {
        int res = 0;
        res = userinfomapper.deleteUserInfoAppo(appo_seq);
        return 0;
    }


}
