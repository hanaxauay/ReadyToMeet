package com.final2.readytomeet.repository;

import com.final2.readytomeet.dto.AppoDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AppoRepository {

//    public List<AppoDto> selectAppointmentAllList();

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


    List<AppoDto> selectSubCategorySearchList(String appo_search);
    public AppoDto selectAppointmentOneList(int appo_seq);


    public int insertActivity(AppoDto appodto);
    public int insertVehicle(AppoDto appodto);
    public int insertWork(AppoDto appodto);


    public int updateActivity(AppoDto appodto);
    public int updateVehicle(AppoDto appodto);
    public int updateWork(AppoDto appodto);

    public int deleteAppointment(int appo_seq);

}
