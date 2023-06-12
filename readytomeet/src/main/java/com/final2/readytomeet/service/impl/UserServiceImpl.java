package com.final2.readytomeet.service.impl;

import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.final2.readytomeet.Mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto selectOne(String user_id) {
        return userMapper.selectOne(user_id);
    }
    @Override
    public int update(UserDto dto) {
        return userMapper.update(dto);
    }




}
