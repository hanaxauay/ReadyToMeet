package com.final2.readytomeet.repository;

import com.final2.readytomeet.dto.AppoDto;

import java.util.List;

public interface AppoRepository {

    public List<AppoDto> selectAppointmentAllList();

    public AppoDto selectAppointmentOneList(int appo_seq);

    public int insertActivity(AppoDto appodto);

    public int insertVehicle(AppoDto appodto);

    public int insertWork(AppoDto appodto);
    public int updateActivity(AppoDto appodto);
    public int updateVehicle(AppoDto appodto);
    public int updateWork(AppoDto appodto);

    List<AppoDto> selectSubCategoryAllList();

}
