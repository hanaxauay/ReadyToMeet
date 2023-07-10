package com.final2.readytomeet.service;

import com.final2.readytomeet.Mapper.JoinMapper;
import com.final2.readytomeet.dto.JoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final JoinMapper joinMapper;

    @Autowired
    public JoinService(JoinMapper joinMapper){
        this.joinMapper = joinMapper;
    }

    public void addUser(JoinDto joinDto){
        joinMapper.insertUser(joinDto);
    }
}
