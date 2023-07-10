package com.final2.readytomeet.service;

import com.final2.readytomeet.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface UserService {
    //note 전체회원 조회
    List<UserDto> userList();


    //note 유저정보보기
    UserDto readUser(int id);




    //note 마이페이지 바로
    UserDto selectOne(String user_id);

    //note 유저 정보 수정
    public int update(UserDto userDto);



    public void write(UserDto dto, MultipartFile file) throws Exception;



}
