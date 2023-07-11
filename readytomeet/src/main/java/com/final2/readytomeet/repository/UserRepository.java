package com.final2.readytomeet.repository;

import com.final2.readytomeet.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



public interface UserRepository {
    //note 전체회원조회
    public List<UserDto> userList();


    //note 유저정보보기
    public UserDto readUser(int id);



    UserDto selectOne(Integer id);



}