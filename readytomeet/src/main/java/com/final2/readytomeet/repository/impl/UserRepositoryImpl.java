package com.final2.readytomeet.repository.impl;


import com.final2.readytomeet.Mapper.UserMapper;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.repository.UserRepository;

import org.apache.catalina.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;


import java.util.ArrayList;
import java.util.List;


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

    //note 유저정보보기
    @Override
    public UserDto readUser(int id){
        UserDto dto = userMapper.readUser(id);
        return dto;
    }



    @Override
    public UserDto selectOne(Integer id) {
        UserDto dto = userMapper.selectOne(id);
        return dto;
    }

//    @Override
//    public int update(UserDto userDto){
//        int res = 0;
//        res = userMapper.update(userDto);
//        return res;
//    }







}
