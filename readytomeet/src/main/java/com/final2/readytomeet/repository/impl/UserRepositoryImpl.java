package com.final2.readytomeet.repository.impl;


import com.final2.readytomeet.Mapper.UserMapper;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

import static javax.xml.stream.XMLStreamConstants.NAMESPACE;


@Repository
public class UserRepositoryImpl implements UserRepository {
//
    @Inject
    private SqlSession sqlSession;


    private static final String namespace = "com.final2.readytomeet.Mapper.UserMapper";

    //note 회원정보조회
    @Override
    public UserDto readUser(String user_id) throws Exception {
        //테스트(컨트롤러) 호출 -> 정보를 저장 -> DB로이동
        UserDto dto = sqlSession.selectOne(namespace+".readUser", user_id); //괄호안의 물음표를 콤마뒤에 쓰는거임
        return dto;
    }
//
//    /* 회원정보조회 - ID, PW 정보에 해당하는 사용자 정보*/
//    @Override
//    public UserDto readUserWithIDPW(String user_id, String user_pw) throws Exception {
//
//        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("user_id", user_id);
//        paramMap.put("user_pw", user_pw);
//
//
//        return sqlSession.selectOne("readUserWithIDPW", paramMap);
//    }
//
//    // 회원정보 수정처리
//    @Override
//    public void updateUser(UserDto dto) throws Exception{
//        sqlSession.update(NAMESPACE + ".updateUser", dto);
//    }
//
//
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
