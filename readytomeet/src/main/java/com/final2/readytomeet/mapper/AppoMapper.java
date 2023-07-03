package com.final2.readytomeet.Mapper;

import com.final2.readytomeet.dto.AppoDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppoMapper {

    // 지도 추가 후 검색 조건에 거리제한 걸어야 함!! //

    //--------------------------------select---------------------------------
//    //모든 약속 검색
//    @Select(" SELECT * FROM APPOINTMENT ORDER BY APPO_SEQ DESC ")
//    List<AppoDto> selectAppointmentAllList();

    //Activity 전체 약속 검색
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_PLACE, DATE_FORMAT(APPO_TIME,'%m/%d') AS APPO_DATE1, DATE_FORMAT(APPO_TIME,'%H:%i') AS APPO_DATE2" +
            " FROM APPOINTMENT WHERE NOT APPO_CATEGORY IN ('카풀', '택시', '유급', '무급') ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectActivityAllList();
    //Activity 세부 카테고리 전체 검색
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_PLACE, DATE_FORMAT(APPO_TIME,'%m/%d') AS APPO_DATE1, DATE_FORMAT(APPO_TIME,'%H:%i') AS APPO_DATE2 FROM APPOINTMENT WHERE APPO_CATEGORY='카페' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectActivityCafeList();
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_PLACE, DATE_FORMAT(APPO_TIME,'%m/%d') AS APPO_DATE1, DATE_FORMAT(APPO_TIME,'%H:%i') AS APPO_DATE2 FROM APPOINTMENT WHERE APPO_CATEGORY='맛집' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectActivityRestaurantList();
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_PLACE, DATE_FORMAT(APPO_TIME,'%m/%d') AS APPO_DATE1, DATE_FORMAT(APPO_TIME,'%H:%i') AS APPO_DATE2 FROM APPOINTMENT WHERE APPO_CATEGORY='스포츠' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectActivitySportList();
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_PLACE, DATE_FORMAT(APPO_TIME,'%m/%d') AS APPO_DATE1, DATE_FORMAT(APPO_TIME,'%H:%i') AS APPO_DATE2 FROM APPOINTMENT WHERE APPO_CATEGORY='야외활동' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectActivityOutdoorList();
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_PLACE, DATE_FORMAT(APPO_TIME,'%m/%d') AS APPO_DATE1, DATE_FORMAT(APPO_TIME,'%H:%i') AS APPO_DATE2 FROM APPOINTMENT WHERE APPO_CATEGORY='구매' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectActivityBuyList();
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_PLACE, DATE_FORMAT(APPO_TIME,'%m/%d') AS APPO_DATE1, DATE_FORMAT(APPO_TIME,'%H:%i') AS APPO_DATE2 FROM APPOINTMENT WHERE APPO_CATEGORY='게임' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectActivityGameList();
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_PLACE, DATE_FORMAT(APPO_TIME,'%m/%d') AS APPO_DATE1, DATE_FORMAT(APPO_TIME,'%H:%i') AS APPO_DATE2 FROM APPOINTMENT WHERE APPO_CATEGORY='기타' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectActivityOthersList();

    //Vehicle 전체 약속 검색
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_START_PLACE, APPO_PLACE, DATE_FORMAT(APPO_TIME,'%m/%d') AS APPO_DATE1, DATE_FORMAT(APPO_TIME,'%H:%i') AS APPO_DATE2 FROM APPOINTMENT WHERE APPO_CATEGORY='카풀' OR APPO_CATEGORY='택시' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectVehicleAllList();
    //Vehicle 세부 카테고리 전체 검색
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_START_PLACE, APPO_PLACE, DATE_FORMAT(APPO_TIME,'%m/%d') AS APPO_DATE1, DATE_FORMAT(APPO_TIME,'%H:%i') AS APPO_DATE2 FROM APPOINTMENT WHERE APPO_CATEGORY='카풀' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectVehicleCarpoolList();
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_START_PLACE, APPO_PLACE, DATE_FORMAT(APPO_TIME,'%m/%d') AS APPO_DATE1, DATE_FORMAT(APPO_TIME,'%H:%i') AS APPO_DATE2 FROM APPOINTMENT WHERE APPO_CATEGORY='택시' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectVehicleTaxiList();


    //Work 전체 약속 검색
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_PLACE, DATE_FORMAT(APPO_TIME,'%m/%d') AS APPO_DATE1, DATE_FORMAT(APPO_TIME,'%H:%i') AS APPO_DATE2 FROM APPOINTMENT WHERE APPO_CATEGORY='유급' OR APPO_CATEGORY='무급' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectWorkAllList();
    //Work 세부 카테고리 전체 검색
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_PLACE, DATE_FORMAT(APPO_TIME,'%m/%d') AS APPO_DATE1, DATE_FORMAT(APPO_TIME,'%H:%i') AS APPO_DATE2 FROM APPOINTMENT WHERE APPO_CATEGORY='유급' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectWorkPaidList();
    @Select(" SELECT APPO_SEQ, APPO_TITLE, APPO_PLACE, DATE_FORMAT(APPO_TIME,'%m/%d') AS APPO_DATE1, DATE_FORMAT(APPO_TIME,'%H:%i') AS APPO_DATE2 FROM APPOINTMENT WHERE APPO_CATEGORY='무급' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectWorkUnpaidList();


    //한 약속 검색
    @Select(" SELECT * FROM APPOINTMENT WHERE APPO_SEQ=#{appo_seq} ")
    AppoDto selectAppointmentOneList(int appo_seq);



    //[카테고리 검색창]세부 카테고리 내 검색 (쿼리문 체크 필요)
    @Select(" SELECT * FROM APPOINTMENT WHERE APPO_CATEGORY LIKE='%${appo_search}%' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectSubCategorySearchList(String appo_search);
    //[카테고리 검색창] 약속명 내 검색
    @Select(" SELECT * FROM APPOINTMENT WHERE APPO_TITLE LIKE='%${appo_search}%' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectTitleSearchList(String appo_search);
    //[카테고리 검색창] 약속장소 내 검색
    @Select(" SELECT * FROM APPOINTMENT WHERE APPO_PLACE LIKE='%${appo_search}%' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectPlaceSearchList(String appo_search);
    //[카테고리 검색창] 작성자 내 검색
    @Select(" SELECT * FROM APPOINTMENT WHERE APPO_TITLE LIKE='%${appo_search}%' ORDER BY APPO_SEQ DESC ")
    List<AppoDto> selectHostSearchList(String appo_search);


    //--------------------------------insert---------------------------------
    //Activity 약속 생성
    @Insert(" INSERT INTO APPOINTMENT VALUES(NULL, #{appo_title}, #{appo_content}, NULL, #{appo_host}, #{appo_place}, #{appo_time}, #{appo_min_mem}, #{appo_max_mem}, #{appo_category}, NULL, NULL, #{appo_using}) ")
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














