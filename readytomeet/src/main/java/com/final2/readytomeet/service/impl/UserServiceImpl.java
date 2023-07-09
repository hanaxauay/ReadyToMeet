package com.final2.readytomeet.service.impl;




import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.repository.UserRepository;
import com.final2.readytomeet.service.UserService;


import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;
//    @Autowired
//    private UserMapper userMapper;

    //note 전체회원 조회
    @Override
    public List<UserDto> userList() {
        return userRepository.userList();
    }


    //note 회원 정보 상세 조회
    @Override
    public UserDto viewUser(String user_id){
        return userRepository.viewUser(user_id);
    }

//    @Override
//    public void deleteUser(String user_id){
//
//    }





//    @Override
//    public UserDto getUserProfile(String user_id){
//        Optional<UserDto> user = userRepository.findById(user_id);
//
//        if (user != null ){
//            return userMapper.getUserProfile(user_id);
//        } else {
//            return null;
//        }
//    }







    //note 프로필 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


//    @Override
//    public UserDto getUserProfile(String user_id){
//        UserDto userDto = userRepository.getUserProfile(user_id)
//                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + user_id));
//        return userMapper.toUserDto(user_id);
//    }

//    public void upload(UserDto dto, MultipartFile file) throws Exception {
//        String projectPath = "E:/files/";
//        UUID uuid = UUID.randomUUID();
//
//        if(file != null && !file.isEmpty()) {
//            String user_img = uuid + "_" + file.getOriginalFilename();
//            File saveFile = new File(projectPath, user_img);
//            file.transferTo(saveFile);
//            dto.setUser_img(user_img);
//            dto.setUser_path("/download/" + user_img);
//        }
//        userMapper.upload(dto);
//    }
//


}
