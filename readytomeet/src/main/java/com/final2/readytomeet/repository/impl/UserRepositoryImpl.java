package com.final2.readytomeet.repository.impl;


import com.final2.readytomeet.Mapper.UserMapper;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.repository.UserRepository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserRepositoryImpl implements UserRepository {

    @Inject
    SqlSession sqlSession;

    @Autowired
    private UserMapper userMapper;

    //note 전체회원조회
    @Override
    public List<UserDto> userList() {
        List<UserDto> res = new ArrayList<UserDto>();
        res = userMapper.list();
        return res;
    }

    //note 회원정보 상세 조회
    @Override
    public UserDto viewUser(String user_id){
        return sqlSession.selectOne("user.viewUser", user_id);
    }

    
    //note 유저정보보기
    @Override
    public UserDto readUser(String user_id){
        UserDto dto = userMapper.readUser(user_id);
        return dto;
    }
    
    
    
    
    @Override
    public void deleteUser(String user_id) {
        sqlSession.delete("user.deleteUser", user_id);
    }

    @Override
    public boolean check(String user_id, String user_pw){
        boolean result = false;
        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", user_id);
        map.put("user_pw", user_pw);
        int count = sqlSession.selectOne("user.checkPw", map);
        if(count == 1) result = true;
        return result;
    }





    @Override
    public void updateUser(UserDto dto) {

    }

    @Override
    public boolean checkPw(String userId, String userPw) {
        return false;
    }

//    private final List<UserDto> userList = new ArrayList<>();
//
//    @Override
//    public Optional<UserDto> getUserProfile(String user_id) {
//        return userList.stream()
//                .filter(user -> user.getUser_id().equals(user_id))
//                .findFirst();
//    }









//    // 회원 프로필 사진 수정
//    @Override
//    public void updateUimage(String user_id, String user_img) throws Exception {
//        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("user_id", user_id);
//        paramMap.put("user_img", user_img);
//        sqlSession.update(NAMESPACE + ".updateUimage", paramMap);
//    }
//


}
