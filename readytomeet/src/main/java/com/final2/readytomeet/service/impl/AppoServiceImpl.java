package com.final2.readytomeet.service.impl;

import com.final2.readytomeet.controller.AppoController;
import com.final2.readytomeet.controller.LoginController;
import com.final2.readytomeet.dto.AppoDto;
import com.final2.readytomeet.repository.AppoRepository;
import com.final2.readytomeet.service.AppoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppoServiceImpl implements AppoService {

    private final AppoRepository apporepository;
    private final LoginController loginController;

    //전체 약속 검색
//    @Override
//    public List<AppoDto> selectAppointmentAllList() {
//        return apporepository.selectAppointmentAllList();
//    }

    //Activity 전체 약속 검색
    @Override
    public List<AppoDto> selectActivityAllList() {
        return apporepository.selectActivityAllList();
    }
    //Activity 세부 카테고리 전체 검색
    @Override
    public List<AppoDto> selectActivityCafeList() {
        return apporepository.selectActivityCafeList();
    }
    @Override
    public List<AppoDto> selectActivityRestaurantList() {
        return apporepository.selectActivityRestaurantList();
    }
    @Override
    public List<AppoDto> selectActivitySportList() {
        return apporepository.selectActivitySportList();
    }
    @Override
    public List<AppoDto> selectActivityOutdoorList() {
        return apporepository.selectActivityOutdoorList();
    }
    @Override
    public List<AppoDto> selectActivityBuyList() {
        return apporepository.selectActivityBuyList();
    }
    @Override
    public List<AppoDto> selectActivityGameList() {
        return apporepository.selectActivityGameList();
    }
    @Override
    public List<AppoDto> selectActivityOthersList() {
        return apporepository.selectActivityOthersList();
    }

    //Vehicle 전체 약속 검색
    @Override
    public List<AppoDto> selectVehicleAllList() {
        return apporepository.selectVehicleAllList();
    }
    //Vehicle 세부 카테고리 전체 검색
    @Override
    public List<AppoDto> selectVehicleCarpoolList() {
        return apporepository.selectVehicleCarpoolList();
    }
    @Override
    public List<AppoDto> selectVehicleTaxiList() {
        return apporepository.selectVehicleTaxiList();
    }

    //Work 전체 약속 검색
    @Override
    public List<AppoDto> selectWorkAllList() {
        return apporepository.selectWorkAllList();
    }
    //Work 세부 카테고리 전체 검색
    @Override
    public List<AppoDto> selectWorkPaidList() {
        return apporepository.selectWorkPaidList();
    }
    @Override
    public List<AppoDto> selectWorkUnpaidList() {
        return apporepository.selectWorkUnpaidList();
    }

    //한 약속 검색
    @Override
    public AppoDto selectAppointmentOneList(int appo_seq) {
        return apporepository.selectAppointmentOneList(appo_seq);
    }


    //Activity 약속 생성
    @Override
    public int insertActivity(AppoDto appoDto) {

        return apporepository.insertActivity(appoDto);
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
