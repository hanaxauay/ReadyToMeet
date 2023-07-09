package com.final2.readytomeet.repository.impl;


import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository {

    @Inject
    SqlSession sqlSession;

    //note 전체회원조회
    @Override
    public List<UserDto> userList() {
        return sqlSession.selectList("user.userList");
    }

    //note 회원정보 상세 조회
    @Override
    public UserDto viewUser(String user_id){
        return sqlSession.selectOne("user.viewUser", user_id);
    }

//    private final List<UserDto> userList = new ArrayList<>();
//
//    @Override
//    public Optional<UserDto> getUserProfile(String user_id) {
//        return userList.stream()
//                .filter(user -> user.getUser_id().equals(user_id))
//                .findFirst();
//    }









//    // 회원 프로필 사진 수정
//    @Override
//    public void updateUimage(String user_id, String user_img) throws Exception {
//        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("user_id", user_id);
//        paramMap.put("user_img", user_img);
//        sqlSession.update(NAMESPACE + ".updateUimage", paramMap);
//    }
//


}
