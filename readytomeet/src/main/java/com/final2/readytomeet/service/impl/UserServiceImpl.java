package com.final2.readytomeet.service.impl;




import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.final2.readytomeet.Mapper.UserMapper;



@Service
public class UserServiceImpl implements UserService {
    //
//    @Autowired
//    private UserDao dao;
    @Autowired
    private UserMapper userMapper;
//    //
//    @Inject
//    private UserRepository userRepository;

    //note 로그인
//    @Override
//    public UserDto login(UserDto dto){
//        return dao.login(dto);
//    }
//
//

//    @Autowired
//    UserServiceImpl(UserMapper userMapper){
//        this.userMapper = userMapper;
//    }
//    public List<Map<String, Object>> getUser(){
//        return userMapper.getUser();
//    }
//
//    @Override
//    public void upload(UserDto dto, MultipartFile file) throws Exception {
//
//    }
//
//    @Override
//    public UserDto readUser(String user_id) {
//        return null;
//    }


    //note 로그인


    //note 회원정보 조회
    @Override
    public UserDto readUser(String user_id){
        UserDto dto = null;

        try {
            dto = userMapper.readUser(user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dto;
    }

//    @Override
//    public List<UserDto> selectList() {
//        return UserMapper.selectList();
//    }
//


//    //note 회원정보 수정
//    @Override
//    public void modifyUser(UserDto userDto) throws Exception{
//        userRepository.updateUser(userDto);
//    }
//
//    //note 회원 프로필 사진 수정
//    @Override
//    public void modifyUimage(String user_id, String user_img) throws Exception {
//        userRepository.updateUimage(user_id, user_img);
//    }
//
//
//





//
//    @Override
//    public UserDto readUser(String user_id) throws Exception{
//        return repository.readUser(user_id);
//    }
////    @Override
////    public void updateUser(UserDto dto) {
////        try {
////            repository.updateUser(dto);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////
////    }

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
