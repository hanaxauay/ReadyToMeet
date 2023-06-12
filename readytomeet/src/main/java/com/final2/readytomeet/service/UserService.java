package com.final2.readytomeet.service;

import com.final2.readytomeet.dto.UserDto;

public interface UserService {

    public UserDto selectOne(String user_id);
    public void update(UserDto dto);

}
