package com.final2.readytomeet.repository.impl;

import com.final2.readytomeet.dto.AppoDto;
import com.final2.readytomeet.mapper.AppoMapper;
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
//    @Override
//    public List<AppoDto> selectAppointmentAllList() {
//        List<AppoDto> res = new ArrayList<AppoDto>();
//        res = appomapper.selectAppointmentAllList();
//        return res;
//    }

    //Activity 전체 약속 검색
    @Override
    public List<AppoDto> selectActivityAllList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectActivityAllList();
        return res;
    }

    //Activity 세부 카테고리 검색
    @Override
    public List<AppoDto> selectActivityCafeList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectActivityCafeList();
        return res;
    }
    @Override
    public List<AppoDto> selectActivityRestaurantList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectActivityRestaurantList();
        return res;
    }
    @Override
    public List<AppoDto> selectActivitySportList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectActivitySportList();
        return res;
    }
    @Override
    public List<AppoDto> selectActivityOutdoorList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectActivityOutdoorList();
        return res;
    }
    @Override
    public List<AppoDto> selectActivityBuyList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectActivityBuyList();
        return res;
    }
    @Override
    public List<AppoDto> selectActivityGameList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectActivityGameList();
        return res;
    }
    @Override
    public List<AppoDto> selectActivityOthersList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectActivityOthersList();
        return res;
    }

    //Vehicle 전체 약속 검색
    @Override
    public List<AppoDto> selectVehicleAllList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectVehicleAllList();
        return res;
    }
    //Vehicle 세부 카테고리 전체 검색
    @Override
    public List<AppoDto> selectVehicleCarpoolList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectVehicleCarpoolList();
        return res;
    }
    @Override
    public List<AppoDto> selectVehicleTaxiList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectVehicleTaxiList();
        return res;
    }

    //Work 전체 약속 검색
    @Override
    public List<AppoDto> selectWorkAllList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectWorkAllList();
        return res;
    }
    //Work 세부 카테고리 전체 검색
    @Override
    public List<AppoDto> selectWorkPaidList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectWorkPaidList();
        return res;
    }
    @Override
    public List<AppoDto> selectWorkUnpaidList() {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectWorkUnpaidList();
        return res;
    }

    //[카테고리 검색창] 세부 카테고리 검색
    @Override
    public List<AppoDto> selectSubCategorySearchList(String appo_search) {
        List<AppoDto> res = new ArrayList<AppoDto>();
        res = appomapper.selectSubCategorySearchList(appo_search);
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




}
