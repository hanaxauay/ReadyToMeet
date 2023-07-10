package com.final2.readytomeet.service;

import com.final2.readytomeet.dto.JoinDto;
import com.final2.readytomeet.entity.JoinEntity;
import com.final2.readytomeet.repository.JoinRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final JoinRepository joinRepository;
    public void join(JoinDto joinDto) {
        JoinEntity joinEntity = JoinEntity.toJoinEntity(joinDto);
        joinRepository.save(joinEntity);

    }
}
