package com.final2.readytomeet.service.impl;

import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.final2.readytomeet.Mapper.UserMapper;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public UserDto selectOne(String user_id) {
        return userMapper.selectOne(user_id);
    }
    @Override
    public void update(UserDto dto) {
        userMapper.update(dto);
    }




}
