package com.final2.readytomeet.service;

import com.final2.readytomeet.dto.AppoDto;

import java.util.List;

public interface AppoService {
    public List<AppoDto> selectAppointmentAllList();

    public AppoDto selectAppointmentOneList(int appo_seq);


    //Activity 약속 생성
    int insertActivity(AppoDto appodto);

    public int insertVehicle(AppoDto appodto);

    public int insertWork(AppoDto appodto);


    public int updateActivity(AppoDto appodto);
    public int updateVehicle(AppoDto appodto);
    public int updateWork(AppoDto appodto);
}
