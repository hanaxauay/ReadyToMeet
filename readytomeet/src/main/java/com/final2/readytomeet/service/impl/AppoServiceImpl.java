package com.final2.readytomeet.service.impl;

import com.final2.readytomeet.dto.AppoDto;
import com.final2.readytomeet.repository.AppoRepository;
import com.final2.readytomeet.service.AppoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppoServiceImpl implements AppoService {

    @Autowired
    private AppoRepository apporepository;

    //전체 약속 검색
    @Override
    public List<AppoDto> selectAppointmentAllList() {
        return apporepository.selectAppointmentAllList();
    }

    //한 약속 검색
    @Override
    public AppoDto selectAppointmentOneList(int appo_seq) {
        return apporepository.selectAppointmentOneList(appo_seq);
    }


    //Activity 약속 생성
    @Override
    public int insertActivity(AppoDto appodto) {
        return apporepository.insertActivity(appodto);
    }
    //Vehicle 약속 생성
    @Override
    public int insertVehicle(AppoDto appodto) {
        return apporepository.insertVehicle(appodto);
    }
    //Work 약속 생성
    @Override
    public int insertWork(AppoDto appodto) {
        return apporepository.insertWork(appodto);
    }


    //Activity 약속 수정
    @Override
    public int updateActivity(AppoDto appodto) {
        return apporepository.updateActivity(appodto);
    }
    //Vehicle 약속 수정
    @Override
    public int updateVehicle(AppoDto appodto) {
        return apporepository.updateVehicle(appodto);
    }
    //Work 약속 수정
    @Override
    public int updateWork(AppoDto appodto) {
        return apporepository.updateWork(appodto);
    }
}
