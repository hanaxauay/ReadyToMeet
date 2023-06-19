package com.final2.readytomeet.service;

import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

//    public List<UserDto> selectList();
    public UserDto selectOne(String user_id);
    public int update(UserDto dto);
    public void upload(UserDto dto, MultipartFile file) throws Exception;
}
