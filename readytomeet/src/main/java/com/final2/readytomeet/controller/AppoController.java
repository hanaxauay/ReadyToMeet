package com.final2.readytomeet.controller;

import com.final2.readytomeet.dto.AppoDto;
import com.final2.readytomeet.service.AppoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointment")
public class AppoController {
    // 로그인 세션 추가 시 추가 수정 필요!! //

    @Autowired
    private AppoService apposervice;

    //-------------Activity 페이지 관련 컨트롤----------------
    //Activity 기본 페이지 목록 출력
    @GetMapping("/activityAllList")
    public String selectActivityAllList(Model model){
        model.addAttribute("activityList", apposervice.selectAppointmentAllList());
        return "activityBaseListPage";
    }

    //Activity 세부 카테고리 페이지 이동
    @GetMapping("/activityCafeList") //카페
    public String selectActivityCafeList(Model model){
        return "";
    }
    @GetMapping("/activityRestaurantList") //식당
    public String selectActivityRestaurantList(Model model){
        return "";
    }
    @GetMapping("/activitySportList") //스포츠
    public String selectActivitySportList(Model model){
        return "";
    }@GetMapping("/activityOutdoorList") //야외활동
    public String selectActivityOutdoorList(Model model){
        return "";
    }@GetMapping("/activityBuyList") //구매
    public String selectActivityBuyList(Model model){
        return "";
    }@GetMapping("/activityGameList") //게임
    public String selectActivityGameList(Model model){
        return "";
    }@GetMapping("/activityOthersList") //기타
    public String selectActivityOthersList(Model model){
        return "";
    }

    //Activity 상세페이지 이동 (예정)
    @GetMapping("/detailActivityPage")
    public String detailActivityPage(Model model, int appo_seq){
        model.addAttribute("activityDto", apposervice.selectAppointmentOneList(appo_seq));
        return "";
    }

    //Activity 약속 생성 폼 이동
    @GetMapping("/insertActivityForm")
    public String insertActivityForm(){
        return "activitywrite";
    }

    //Activity 약속 생성
    @PostMapping("/insertActivity")
    public String insertActivity(AppoDto appodto){
        if(apposervice.insertActivity(appodto) > 0){
            //성공 시 해당 약속 상세페이지 이동
            return "redirect:/appointment/detailActivityPage";
        }else {
            //실패 시 처리 작업 필요하면 추가
            return "redirect:/appointment/insertActivityForm";
        }
    }


    //Activity 약속 수정 폼 이동 (예정)
    @GetMapping("/updateActivityForm")
    public String updateActivityForm(Model model, int appo_seq){
        model.addAttribute("activity", apposervice.selectAppointmentOneList(appo_seq));
        return "";
    }

    //Activity 약속 수정 (예정)
    @PostMapping("/updateActivity")
    public String updateActivity(AppoDto appodto){
        if(apposervice.updateActivity(appodto) > 0){
            //성공 시 해당 약속 상세페이지 이동
            return "redirect:/appointment/detailActivityPage";
        }else {
            //실패 시 처리 작업 필요하면 추가
            return "redirect:/appointment/ ";
        }

    }

    //Activity 약속 삭제 (예정)



    //--------------Vehicle 페이지 관련 컨트롤-----------------
    //Vehicle 기본 페이지 목록 출력
    @GetMapping("/vehicleAllList")
    public String selectVehicleAllList(Model model){
        model.addAttribute("vehicleList", apposervice.selectAppointmentAllList());
        return "vehicleBaseListPage";
    }

    //Vehicle 상세페이지 이동 (예정)
    @GetMapping("/detailVehiclePage")
    public String detailVehiclePage(Model model, int appo_seq){
        model.addAttribute("vehicleDto", apposervice.selectAppointmentOneList(appo_seq));
        return "";
    }

    //Vehicle 약속 생성 폼 이동
    @GetMapping("/insertVehicleForm")
    public String insertVehicleForm(){
        return "vehiclewrite";
    }

    //Vehicle 약속 생성
    @PostMapping("/insertVehicle")
    public String insertVehicle(AppoDto appodto){
        if(apposervice.insertVehicle(appodto) > 0){
            //성공 시 해당 약속 상세페이지
            return "redirect:/appointment/detailVehiclePage";
        }else {
            //실패 시 처리 작업 필요하면 추가
            return "redirect:/appointment/insertVehicleForm";
        }
    }


    //--------------Work 페이지 관련 컨트롤-----------------
    //Work 기본 페이지 목록 출력
    @GetMapping("/workAllList")
    public String selectWorkAllList(Model model){
        model.addAttribute("workList", apposervice.selectAppointmentAllList());
        return "vehicleBaseListPage";
    }

    //Work 상세페이지 이동 (예정)
    @GetMapping("/detailWorkPage")
    public String detailWorkPage(Model model, int appo_seq){
        model.addAttribute("workDto", apposervice.selectAppointmentOneList(appo_seq));
        return "";
    }

    //Work 약속 생성 폼 이동
    @GetMapping("/insertWorkForm")
    public String insertWorkForm(){
        return "workwrite";
    }

    //Work 약속 생성
    @PostMapping("/insertWork")
    public String insertWork(AppoDto appodto){
        if(apposervice.insertWork(appodto) > 0){
            //성공 시 해당 약속 상세페이지
            return "redirect:/appointment/detailWorkPage";
        }else {
            //실패 시 처리 작업 필요하면 추가
            return "redirect:/appointment/insertWorkForm";
        }
    }
}
