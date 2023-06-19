package com.final2.readytomeet.service.impl;

import com.final2.readytomeet.Mapper.CommunityMapper;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.final2.readytomeet.Mapper.UserMapper;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.templateparser.markup.decoupled.IDecoupledTemplateLogicResolver;

import java.io.File;
import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


//    @Override
//    public List<UserDto> selectList() {
//        return UserMapper.selectList();
//    }
//

    @Override
    public UserDto selectOne(String user_id) {
        return userMapper.selectOne(user_id);
    }
    @Override
    public int update(UserDto dto) {
        return userMapper.update(dto);
    }

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
