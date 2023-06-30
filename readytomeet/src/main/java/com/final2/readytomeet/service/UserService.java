package com.final2.readytomeet.service;

import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {


//    public List<UserDto> selectList();

//    public UserDto login(UserDto dto);


    public void upload(UserDto dto, MultipartFile file) throws Exception;



    // 회원 정보
    public UserDto readUser(String uid) throws Exception;

    // 회원 정보 수정
    public void modifyUser(UserDto userDto) throws Exception;

    // 회원 프로필 사진 수정
    public void modifyUimage(String uid, String uimage) throws Exception;
}
