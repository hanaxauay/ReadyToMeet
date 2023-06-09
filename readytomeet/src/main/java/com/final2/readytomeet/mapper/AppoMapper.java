package com.final2.readytomeet.mapper;

import com.final2.readytomeet.dto.AppoDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppoMapper {

    //--------------------------------select---------------------------------
    //전체 약속 검색
    @Select(" SELECT * FROM APPOINTMENT ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectAppointmentAllList();

    //한 약속 검색
    @Select(" SELECT * FROM APPOINTMENT WHERE APPO_SEQ=#{appo_seq} ")
    AppoDto selectAppointmentOneList(int appo_seq);

    //세부 카테고리 전체 검색
    @Select(" SELECT * FROM APPOINTMENT WHERE APPO_CATEGORY=#{appo_category} ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectSubCategoryAllList();

    //가까운 시간 순 검색
    @Select(" SELECT * FROM APPOINTMENT ORDER BY APPO_TIME ")
    List<AppoDto> selectAppointmentRecentTime();

    //가까운 거리 순 검색 (예정)


    //세부 카테고리 내 검색
    //약속명 내 검색
    //약속장소 내 검색
    //작성자 내 검색

    //--------------------------------insert---------------------------------
    //Activity 약속 생성
    @Insert(" INSERT INTO APPOINTMENT VALUES(NULL, #{appo_title}, #{appo_content}, NULL, #{appo_host}, #{appo_place, #{appo_time}, #{appo_min_mem}, #{appo_max_mem}, #{appo_category}, NULL, NULL, #{appo_using}) ")
    int insertActivity(AppoDto appodto);

    //Vehicle 약속 생성
    @Insert(" INSERT INTO APPOINTMENT VALUES(NULL, #{appo_title}, #{appo_content}, NULL, #{appo_host}, #{appo_place}, #{appo_time}, #{appo_min_mem}, #{appo_max_mem}, #{appo_category}, #{appo_start_place}, NULL, #{appo_using}) ")
    int insertVehicle(AppoDto appodto);

    //Work 약속 생성
    @Insert(" INSERT INTO APPOINTMENT VALUES(NULL, #{appo_title}, #{appo_content}, NULL, #{appo_host}, #{appo_place}, #{appo_time}, #{appo_min_mem}, #{appo_max_mem}, #{appo_category}, NULL, #{appo_pay}, #{appo_using}) ")
    int insertWork(AppoDto appodto);

    //--------------------------------update---------------------------------
    //Activity 약속 수정
    @Update(" UPDATE APPOINTMENT SET APPO_TITLE=#{appo_title}, APPO_CONTENT=#{appo_content}, APPO_PLACE=#{appo_place}, APPO_TIME=#{appo_time}, APPO_MIN_MEM=#{appo_min_mem}, APPO_MAX_MEM=#{appo_max_mem} ")
    int updateActivity(AppoDto appodto);

    //Vehicle 약속 수정
    @Update(" UPDATE APPOINTMENT SET APPO_TITLE=#{appo_title}, APPO_CONTEMT=#{appo_content}, APPO_PALCE=#{appo_place}, APPO_TIME=#{appo_time}, APPO_MIN_MEM=#{appo_min_mem}, APPO_MAX_MEM=#{appo_max_mem}, APPO_START_PALCE=#{appo_start_place} ")
    int updateVehicle(AppoDto appodto);

    //Work 약속 수정
    @Update(" UPDATE APPOINTMENT SET APPO_TITLE=#{appo_title}, APPO_CONTENT=#{appo_content}, APO_PLACE=#{appo_place}, ppo_time=#{appo_time}, APPO_MIN_MEM=#{appo_min_mem}, APPO_MAX_MEM=#{appo_max_mem}, APPO_PAY=#{appo_pay} ")
    int updateWork(AppoDto appodto);


    //--------------------------------delete---------------------------------
    //약속 삭제
    @Delete(" DELETE FROM APPOINTMENT WHERE APPO_SEQ=#{appo_seq} ")
    int deleteAppointment(int appo_seq);
}














