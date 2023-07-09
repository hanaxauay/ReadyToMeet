package com.final2.readytomeet.repository;

import com.final2.readytomeet.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



public interface UserRepository{
    //note 전체회원조회
    public List<UserDto> userList();

    //note 회원정보 상세 조회
    public UserDto viewUser(String user_id);

    //note 유저정보보기
    public UserDto readUser(String user_id);

    public void deleteUser(String user_id);

    boolean check(String user_id, String user_pw);

    public void updateUser(UserDto dto);

    boolean checkPw(String userId, String userPw);


    //note 회원정보
//    public UserDto readUser(String user_id) throws Exception;

//    Optional<UserDto> getUserProfile(String user_id);


}
