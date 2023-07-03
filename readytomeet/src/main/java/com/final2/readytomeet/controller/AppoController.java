package com.final2.readytomeet.controller;

import com.final2.readytomeet.dto.AppoDto;
import com.final2.readytomeet.service.AppoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/appointment")
public class AppoController {
    // 로그인 세션 추가 시 추가 수정 필요!! //

    @Autowired
    private AppoService apposervice;

    //-------------Activity 페이지 관련 컨트롤----------------
    //Activity 기본 페이지 목록 출력
    @GetMapping("/activityList/all")
    public String selectActivityAllList(Model model){
        model.addAttribute("activityList", apposervice.selectActivityAllList());
        String subCategoryText = "전체";
        model.addAttribute("subCategoryText",subCategoryText);
        return "activityBaseListPage";
    }

    //Activity 세부 카테고리 페이지 이동
    @GetMapping("/activityList/cafe") //카페
    public String selectActivityCafeList(Model model){
        model.addAttribute("activityList", apposervice.selectActivityCafeList());
        String subCategoryText = "카페";
        model.addAttribute("subCategoryText",subCategoryText);
        return "activityBaseListPage";
    }
    @GetMapping("/activityList/restaurant") //맛집
    public String selectActivityRestaurantList(Model model){
        model.addAttribute("activityList", apposervice.selectActivityRestaurantList());
        String subCategoryText = "맛집";
        model.addAttribute("subCategoryText",subCategoryText);
        return "activityBaseListPage";
    }
    @GetMapping("/activityList/sport") //스포츠
    public String selectActivitySportList(Model model){
        model.addAttribute("activityList", apposervice.selectActivitySportList());
        String subCategoryText = "스포츠";
        model.addAttribute("subCategoryText",subCategoryText);
        return "activityBaseListPage";
    }@GetMapping("/activityList/outdoor") //야외활동
    public String selectActivityOutdoorList(Model model){
        model.addAttribute("activityList", apposervice.selectActivityOutdoorList());
        String subCategoryText = "야외활동";
        model.addAttribute("subCategoryText",subCategoryText);
        return "activityBaseListPage";
    }@GetMapping("/activityList/buy") //구매
    public String selectActivityBuyList(Model model){
        model.addAttribute("activityList", apposervice.selectActivityBuyList());
        String subCategoryText = "구매";
        model.addAttribute("subCategoryText",subCategoryText);
        return "activityBaseListPage";
    }@GetMapping("/activityList/game") //게임
    public String selectActivityGameList(Model model){
        model.addAttribute("activityList", apposervice.selectActivityGameList());
        String subCategoryText = "게임";
        model.addAttribute("subCategoryText",subCategoryText);
        return "activityBaseListPage";
    }@GetMapping("/activityList/others") //기타
    public String selectActivityOthersList(Model model){
        model.addAttribute("activityList", apposervice.selectActivityOthersList());
        String subCategoryText = "기타";
        model.addAttribute("subCategoryText",subCategoryText);
        return "activityBaseListPage";
    }

    //Activity 상세페이지 이동
    @GetMapping("/detailActivity")
    public String detailActivityPage(Model model, int appo_seq){
        model.addAttribute("activityDto", apposervice.selectAppointmentOneList(appo_seq));
        return "activityDetailPage";
    }

    //Activity 약속 생성 폼 이동
    @GetMapping("/insertActivityForm")
    public String insertActivityForm(){
        return "activityWrite";
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
        model.addAttribute("activityDto", apposervice.selectAppointmentOneList(appo_seq));
        return "activityWrite";
    }

    //Activity 약속 수정 (예정)
    @PostMapping("/updateActivity")
    public String updateActivity(AppoDto appodto){
        if(apposervice.updateActivity(appodto) > 0){
            //성공 시 해당 약속 상세페이지 이동
            return "redirect:/appointment/detailActivityPage";
        }else {
            //실패 시 처리 작업 필요하면 추가
            return "redirect:/appointment/updateActivityForm";
        }
    }

    //Activity 약속 삭제
    @GetMapping("/deleteActivity")
    public String deleteActivity(int appo_seq){
        //삭제 시 필요한 메세지 추가
        apposervice.deleteAppointment(appo_seq);
        return "activityList/all";
    }


    //----------------Vehicle 페이지 관련 컨트롤-----------------
    //Vehicle 기본 페이지 목록 출력
    @GetMapping("/vehicleList/all")
    public String selectVehicleAllList(Model model){
        model.addAttribute("vehicleList", apposervice.selectVehicleAllList());
        String subCategoryText = "전체";
        model.addAttribute("subCategoryText",subCategoryText);
        return "vehicleBaseListPage";
    }

    //Vehicle 세부 카테고리 페이지 이동
    @GetMapping("/vehicleList/carpool") //카풀
    public String selectVehicleCarpoolList(Model model){
        model.addAttribute("vehicleList", apposervice.selectVehicleCarpoolList());
        String subCategoryText = "카풀";
        model.addAttribute("subCategoryText",subCategoryText);
        return "vehicleBaseListPage";
    }
    @GetMapping("/vehicleList/taxi") //택시
    public String selectVehicleTaxiList(Model model){
        model.addAttribute("vehicleList", apposervice.selectVehicleTaxiList());
        String subCategoryText = "택시";
        model.addAttribute("subCategoryText",subCategoryText);
        return "vehicleBaseListPage";
    }


    //Vehicle 상세페이지 이동 (예정)
    @GetMapping("/detailVehicle")
    public String detailVehiclePage(Model model, int appo_seq){
        model.addAttribute("vehicleDto", apposervice.selectAppointmentOneList(appo_seq));
        return "vehicleDetail";
    }

    //Vehicle 약속 생성 폼 이동
    @GetMapping("/insertVehicleForm")
    public String insertVehicleForm(){
        return "vehicleWrite";
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

    //Vehicle 약속 수정 폼 이동 (예정)
    @GetMapping("/updateVehicleForm")
    public String updateVehicleForm(Model model, int appo_seq){
        model.addAttribute("vehicleDto", apposervice.selectAppointmentOneList(appo_seq));
        return "vehicleWrite";
    }

    //Vehicle 약속 수정 (예정)
    @PostMapping("/updateVehicle")
    public String updateVehicle(AppoDto appodto, int appo_seq){
        if(apposervice.updateVehicle(appodto) > 0){
            //성공 시 해당 약속 상세페이지 이동
            return "redirect:/appointment/detailVehiclePage(appo_seq)";
        }else {
            //실패 시 처리 작업 필요하면 추가
            return "redirect:/appointment/ ";
        }
    }

    //Vehicle 약속 삭제
    @GetMapping("/deleteVehicle")
    public String deleteVehicle(int appo_seq){
        //삭제 시 필요한 메세지 추가
        apposervice.deleteAppointment(appo_seq);
        return "vehicleList/all";
    }


    //--------------Work 페이지 관련 컨트롤-----------------
    //Work 기본 페이지 목록 출력
    @GetMapping("/workList/all")
    public String selectWorkAllList(Model model){
        model.addAttribute("workList", apposervice.selectWorkAllList());
        String subCategoryText = "전체";
        model.addAttribute("subCategoryText",subCategoryText);
        return "workBaseListPage";
    }

    //Work 세부 카테고리 페이지 이동
    @GetMapping("/workList/paid") //유급
    public String selectWorkPaidList(Model model){
        model.addAttribute("workList", apposervice.selectWorkPaidList());
        String subCategoryText = "유급";
        model.addAttribute("subCategoryText",subCategoryText);
        return "workBaseListPage";
    }
    @GetMapping("/workList/unpaid") //무급
    public String selectWorkUnpaidList(Model model){
        model.addAttribute("workList", apposervice.selectWorkUnpaidList());
        String subCategoryText = "무급";
        model.addAttribute("subCategoryText",subCategoryText);
        return "workBaseListPage";
    }

    //Work 상세페이지 이동 (예정)
    @GetMapping("/detailWorkPage")
    public String detailWorkPage(Model model, int appo_seq){
        model.addAttribute("workDto", apposervice.selectAppointmentOneList(appo_seq));
        return "workDetail";
    }

    //Work 약속 생성 폼 이동
    @GetMapping("/insertWorkForm")
    public String insertWorkForm(){
        return "workWrite";
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

    //Work 약속 수정 폼 이동 (예정)
    @GetMapping("/updateWorkForm")
    public String updateWorkForm(Model model, int appo_seq){
        model.addAttribute("workDto", apposervice.selectAppointmentOneList(appo_seq));
        return "workWrite";
    }

    //Work 약속 수정 (예정)
    @PostMapping("/updateWork")
    public String updateWork(AppoDto appodto){
        if(apposervice.updateWork(appodto) > 0){
            //성공 시 해당 약속 상세페이지 이동
            return "redirect:/appointment/detailWorkPage";
        }else {
            //실패 시 처리 작업 필요하면 추가
            return "redirect:/appointment/ ";
        }
    }

    //Work 약속 삭제
    @GetMapping("/deleteWork")
    public String deleteWork(int appo_seq){
        //삭제 시 필요한 메세지 추가
        apposervice.deleteAppointment(appo_seq);
        return "workList/all";
    }




}
