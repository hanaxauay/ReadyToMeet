package com.final2.readytomeet.service;

import com.final2.readytomeet.dto.AppoDto;

import java.util.List;

public interface AppoService {
//    public List<AppoDto> selectAppointmentAllList();

//    public List<AppoDto> selectSubCategorySearchList();

    public List<AppoDto> selectActivityAllList();

    public List<AppoDto> selectActivityCafeList();
    public List<AppoDto> selectActivityRestaurantList();
    public List<AppoDto> selectActivitySportList();
    public List<AppoDto> selectActivityOutdoorList();
    public List<AppoDto> selectActivityBuyList();
    public List<AppoDto> selectActivityGameList();
    public List<AppoDto> selectActivityOthersList();


    public List<AppoDto> selectVehicleAllList();

    public List<AppoDto> selectVehicleCarpoolList();
    public List<AppoDto> selectVehicleTaxiList();


    public List<AppoDto> selectWorkAllList();

    public List<AppoDto> selectWorkPaidList();
    public List<AppoDto> selectWorkUnpaidList();


    public AppoDto selectAppointmentOneList(int appo_seq);


    //약속 생성
    public int insertActivity(AppoDto appodto);

    public int insertVehicle(AppoDto appodto);

    public int insertWork(AppoDto appodto);


    //약속 수정
    public int updateActivity(AppoDto appodto);
    public int updateVehicle(AppoDto appodto);
    public int updateWork(AppoDto appodto);

    public int deleteAppointment(int appo_seq);
}
