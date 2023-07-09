package com.final2.readytomeet.service;

import com.final2.readytomeet.Mapper.UserMapper;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    //note 전체회원 조회
    List<UserDto> userList();

    //note 회원 정보 상세 조회
    UserDto viewUser(String user_id);


    //note 프로필출력중!!!!!!!!!!!!!!!!!!!
//    public UserDto getUserProfile(String user_id);


}
