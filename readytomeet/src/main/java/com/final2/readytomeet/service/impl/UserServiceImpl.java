package com.final2.readytomeet.service.impl;




import com.final2.readytomeet.Mapper.UserMapper;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.repository.UserRepository;
import com.final2.readytomeet.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.inject.Inject;
import java.io.File;
import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    //note 전체회원 조회
    @Override
    public List<UserDto> userList() {

        return userRepository.userList();
    }


    //note 회원 정보 상세 조회
//    @Override
//    public UserDto viewUser(String user_id){
//        return userRepository.viewUser(user_id);
//    }

    //note 유저정보보기
    @Override
    public UserDto readUser(int id){
        return userRepository.readUser(id);
    }


    //note 유저 정보 수정
    @Override
    public int update(UserDto dto){
        return userMapper.update(dto);
    }


    //note 게시글 보기



    @Override
    public void write(UserDto dto, MultipartFile file) throws Exception {
        String projectPath = "E:/files/";
        UUID uuid = UUID.randomUUID();

        if(file != null && !file.isEmpty()) {
            String filename = uuid + "_" + file.getOriginalFilename();
            File saveFile = new File(projectPath, filename);
            file.transferTo(saveFile);
            dto.setUser_img(filename);
            dto.setUser_path("/download/" + filename);
        }
        userMapper.write(dto);
    }

}
