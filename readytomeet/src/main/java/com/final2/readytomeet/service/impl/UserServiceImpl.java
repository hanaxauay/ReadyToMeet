package com.final2.readytomeet.service.impl;



import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.repository.UserRepository;
import com.final2.readytomeet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.final2.readytomeet.Mapper.UserMapper;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.io.File;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Inject
    private UserRepository repository;



//    @Override
//    public List<UserDto> selectList() {
//        return UserMapper.selectList();
//    }
//


    //note 회원정보 수정
    @Override
    public void modifyUser(UserDto userDto) throws Exception{
        repository.updateUser(userDto);
    }

    //note 회원 프로필 사진 수정
    @Override
    public void modifyUimage(String user_id, String user_img) throws Exception {
        repository.updateUimage(user_id, user_img);
    }









    @Override
    public UserDto readUser(String user_id) throws Exception{
        return repository.readUser(user_id);
    }
//    @Override
//    public void updateUser(UserDto dto) {
//        try {
//            repository.updateUser(dto);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    public void upload(UserDto dto, MultipartFile file) throws Exception {
        String projectPath = "E:/files/";
        UUID uuid = UUID.randomUUID();

        if(file != null && !file.isEmpty()) {
            String user_img = uuid + "_" + file.getOriginalFilename();
            File saveFile = new File(projectPath, user_img);
            file.transferTo(saveFile);
            dto.setUser_img(user_img);
            dto.setUser_path("/download/" + user_img);
        }
        userMapper.upload(dto);
    }



}
