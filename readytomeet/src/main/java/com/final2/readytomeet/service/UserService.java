package com.final2.readytomeet.service;

import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    public UserDto selectOne(String user_id);
    public void update(UserDto dto);

    public void upload(UserDto dto, MultipartFile file) throws Exception;
}
