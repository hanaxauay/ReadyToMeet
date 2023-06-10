package com.final2.readytomeet.repository.impl;

import com.final2.readytomeet.dto.AppoDto;
import com.final2.readytomeet.Mapper.AppoMapper;
import com.final2.readytomeet.repository.AppoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppoRepositoryImpl implements AppoRepository {
    // 로그인 세션 추가 시 추가 수정 필요 //

    @Autowired
    private AppoMapper appomapper;

    //전체 약속 검색
    @Override
    public List<AppoDto> selectAppointmentAllList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectAppointmentAllList();
        return res;
    }

    //한 약속 검색
    @Override
    public AppoDto selectAppointmentOneList(int appo_seq) {
        AppoDto res = null;
        res = appomapper.selectAppointmentOneList(appo_seq);
        return res;
    }

    //Activity 약속 생성
    @Override
    public int insertActivity(AppoDto appodto) {
        int res = 0;
        res = appomapper.insertActivity(appodto);
        return res;
    }

    //Vehicle 약속 생성
    @Override
    public int insertVehicle(AppoDto appodto) {
        int res = 0;
        res = appomapper.insertVehicle(appodto);
        return res;
    }

    //Work 약속 생성
    @Override
    public int insertWork(AppoDto appodto) {
        int res = 0;
        res = appomapper.insertWork(appodto);
        return res;
    }

    //Activity 약속 수정
    @Override
    public int updateActivity(AppoDto appodto) {
        int res = 0;
        res = appomapper.updateActivity(appodto);
        return res;
    }

    //Vehicle 약속 수정
    @Override
    public int updateVehicle(AppoDto appodto) {
        int res = 0;
        res = appomapper.updateVehicle(appodto);
        return res;
    }

    //Work 약속 수정
    @Override
    public int updateWork(AppoDto appodto) {
        int res = 0;
        res = appomapper.updateWork(appodto);
        return res;
    }

    //세부 카테고리 전체 검색
    @Override
    public List<AppoDto> selectSubCategoryAllList() {
        return null;
    }


}
