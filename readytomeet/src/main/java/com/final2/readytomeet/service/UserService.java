package com.final2.readytomeet.service;

import com.final2.readytomeet.Mapper.UserMapper;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface UserService {
    //note 전체회원 조회
    List<UserDto> userList();


    //note 유저정보보기
    UserDto readUser(int id);


    //note 유저 정보 수정
    public int update(UserDto dto);



    public void write(UserDto dto, MultipartFile file) throws Exception;



}
