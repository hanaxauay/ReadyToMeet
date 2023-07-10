package com.final2.readytomeet.controller;

import com.final2.readytomeet.Mapper.AppoMapper;
import com.final2.readytomeet.dto.AppoDto;
import com.final2.readytomeet.dto.Pagination;
import com.final2.readytomeet.service.AppoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@Controller
@RequestMapping("/appointment")
public class AppoController {
    // 로그인 세션 추가 시 추가 수정 필요!! //

    @Autowired
    private AppoService apposervice;
    @Autowired
    private AppoMapper map;
    //-------------Activity 페이지 관련 컨트롤----------------
    //Activity 기본 페이지 목록 출력
    @GetMapping("/activityList/all")
    public String selectActivityAllList(Model model,
                                        @RequestParam(required = false) String type,
                                        @RequestParam(required = false) String keyword,
                                        @RequestParam(defaultValue = "1") int page) {
        int totalListCnt;
        List<AppoDto> appointmentList;
        Pagination pagination;

        if (type != null && keyword != null && !type.isEmpty() && !keyword.isEmpty()) {
            if (type.equals("all")) {
                // 전체 검색 처리
                totalListCnt = map.findSearchCnt("appo_title", keyword)
                    + map.findSearchCnt("appo_place", keyword)
                    + map.findSearchCnt("appo_host", keyword);
                pagination = new Pagination(totalListCnt, page);
                int startIndex = pagination.getStartIndex();
                int pageSize = pagination.getPageSize();
                appointmentList = map.findSearchListPaging("appo_title", keyword, startIndex, pageSize);
            } else {
                // 특정 필드 검색 처리
                totalListCnt = map.findSearchCnt(type, keyword);
                pagination = new Pagination(totalListCnt, page);
                int startIndex = pagination.getStartIndex();
                int pageSize = pagination.getPageSize();
                appointmentList = map.findSearchListPaging(type, keyword, startIndex, pageSize);
            }
        } else {
            totalListCnt = map.findAllCnt();
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = map.findListPaging(startIndex, pageSize);
            model.addAttribute("subCategoryText", "전체"); // Set the subCategoryText to "전체"
        }

        model.addAttribute("activityList", appointmentList);
        model.addAttribute("pagination", pagination); // Add pagination information to the model

        return "activityBaseListPage";
    }

    //Activity 세부 카테고리 페이지 이동
    @GetMapping("/activityList/cafe")
    public String selectActivityCafeList(Model model,
                                         @RequestParam(required = false) String keyword,
                                         @RequestParam(defaultValue = "1") int page) {
        int totalListCnt;
        List<AppoDto> appointmentList;
        Pagination pagination;

        if (keyword != null && !keyword.isEmpty()) {
            // 특정 필드 검색 처리
            totalListCnt = map.findSearchCnt("appo_title", keyword)
                + map.findSearchCnt("appo_place", keyword)
                + map.findSearchCnt("appo_host", keyword);
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = map.findSearchListPaging("appo_title", keyword, startIndex, pageSize);
        } else {
            appointmentList = apposervice.selectActivityCafeList();
            totalListCnt = appointmentList.size();
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = appointmentList.subList(startIndex, Math.min(startIndex + pageSize, totalListCnt));
            String subCategoryText = "카페";
            model.addAttribute("subCategoryText", subCategoryText);
        }

        model.addAttribute("activityList", appointmentList);
        model.addAttribute("pagination", pagination);

        return "activityBaseListPage";
    }
    @GetMapping("/activityList/restaurant")
    public String selectActivityRestaurantList(Model model,
                                               @RequestParam(required = false) String keyword,
                                               @RequestParam(defaultValue = "1") int page) {
        int totalListCnt;
        List<AppoDto> appointmentList;
        Pagination pagination;

        if (keyword != null && !keyword.isEmpty()) {
            // Handle specific field search
            totalListCnt = map.findSearchCnt("appo_title", keyword)
                + map.findSearchCnt("appo_place", keyword)
                + map.findSearchCnt("appo_host", keyword);
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = map.findSearchListPaging("appo_title", keyword, startIndex, pageSize);
        } else {
            appointmentList = apposervice.selectActivityRestaurantList(); // Retrieve the restaurant list using apposervice.selectActivityRestaurantList()
            totalListCnt = appointmentList.size(); // Get the total count of the restaurant list
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = appointmentList.subList(startIndex, Math.min(startIndex + pageSize, totalListCnt)); // Apply pagination to the restaurant list
            String subCategoryText = "맛집";
            model.addAttribute("subCategoryText", subCategoryText); // Set the subCategoryText to "맛집"
        }

        model.addAttribute("activityList", appointmentList);
        model.addAttribute("pagination", pagination); // Add pagination information to the model

        return "activityBaseListPage";
    }
    @GetMapping("/activityList/sport")
    public String selectActivitySportList(Model model,
                                          @RequestParam(required = false) String keyword,
                                          @RequestParam(defaultValue = "1") int page) {
        int totalListCnt;
        List<AppoDto> appointmentList;
        Pagination pagination;

        if (keyword != null && !keyword.isEmpty()) {
            // Handle specific field search
            totalListCnt = map.findSearchCnt("appo_title", keyword)
                + map.findSearchCnt("appo_place", keyword)
                + map.findSearchCnt("appo_host", keyword);
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = map.findSearchListPaging("appo_title", keyword, startIndex, pageSize);
        } else {
            appointmentList = apposervice.selectActivitySportList(); // Retrieve the sport list using apposervice.selectActivitySportList()
            totalListCnt = appointmentList.size(); // Get the total count of the sport list
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = appointmentList.subList(startIndex, Math.min(startIndex + pageSize, totalListCnt)); // Apply pagination to the sport list
            String subCategoryText = "스포츠";
            model.addAttribute("subCategoryText", subCategoryText); // Set the subCategoryText to "스포츠"
        }

        model.addAttribute("activityList", appointmentList);
        model.addAttribute("pagination", pagination); // Add pagination information to the model

        return "activityBaseListPage";
    }
    @GetMapping("/activityList/outdoor")
    public String selectActivityOutdoorList(Model model,
                                            @RequestParam(required = false) String keyword,
                                            @RequestParam(defaultValue = "1") int page) {
        int totalListCnt;
        List<AppoDto> appointmentList;
        Pagination pagination;

        if (keyword != null && !keyword.isEmpty()) {
            // Handle specific field search
            totalListCnt = map.findSearchCnt("appo_title", keyword)
                + map.findSearchCnt("appo_place", keyword)
                + map.findSearchCnt("appo_host", keyword);
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = map.findSearchListPaging("appo_title", keyword, startIndex, pageSize);
        } else {
            appointmentList = apposervice.selectActivityOutdoorList(); // Retrieve the outdoor activity list using apposervice.selectActivityOutdoorList()
            totalListCnt = appointmentList.size(); // Get the total count of the outdoor activity list
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = appointmentList.subList(startIndex, Math.min(startIndex + pageSize, totalListCnt)); // Apply pagination to the outdoor activity list
            String subCategoryText = "야외활동";
            model.addAttribute("subCategoryText", subCategoryText); // Set the subCategoryText to "야외활동"
        }

        model.addAttribute("activityList", appointmentList);
        model.addAttribute("pagination", pagination); // Add pagination information to the model

        return "activityBaseListPage";
    }
    @GetMapping("/activityList/buy")
    public String selectActivityBuyList(Model model,
                                        @RequestParam(required = false) String keyword,
                                        @RequestParam(defaultValue = "1") int page) {
        int totalListCnt;
        List<AppoDto> appointmentList;
        Pagination pagination;

        if (keyword != null && !keyword.isEmpty()) {
            // Handle specific field search
            totalListCnt = map.findSearchCnt("appo_title", keyword)
                + map.findSearchCnt("appo_place", keyword)
                + map.findSearchCnt("appo_host", keyword);
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = map.findSearchListPaging("appo_title", keyword, startIndex, pageSize);
        } else {
            appointmentList = apposervice.selectActivityBuyList(); // Retrieve the buy activity list using apposervice.selectActivityBuyList()
            totalListCnt = appointmentList.size(); // Get the total count of the buy activity list
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = appointmentList.subList(startIndex, Math.min(startIndex + pageSize, totalListCnt)); // Apply pagination to the buy activity list
            String subCategoryText = "구매";
            model.addAttribute("subCategoryText", subCategoryText); // Set the subCategoryText to "구매"
        }

        model.addAttribute("activityList", appointmentList);
        model.addAttribute("pagination", pagination); // Add pagination information to the model

        return "activityBaseListPage";
    }
    @GetMapping("/activityList/game")
    public String selectActivityGameList(Model model,
                                         @RequestParam(required = false) String keyword,
                                         @RequestParam(defaultValue = "1") int page) {
        int totalListCnt;
        List<AppoDto> appointmentList;
        Pagination pagination;

        if (keyword != null && !keyword.isEmpty()) {
            // Handle specific field search
            totalListCnt = map.findSearchCnt("appo_title", keyword)
                + map.findSearchCnt("appo_place", keyword)
                + map.findSearchCnt("appo_host", keyword);
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = map.findSearchListPaging("appo_title", keyword, startIndex, pageSize);
        } else {
            appointmentList = apposervice.selectActivityGameList(); // Retrieve the game activity list using apposervice.selectActivityGameList()
            totalListCnt = appointmentList.size(); // Get the total count of the game activity list
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = appointmentList.subList(startIndex, Math.min(startIndex + pageSize, totalListCnt)); // Apply pagination to the game activity list
            String subCategoryText = "게임";
            model.addAttribute("subCategoryText", subCategoryText); // Set the subCategoryText to "게임"
        }

        model.addAttribute("activityList", appointmentList);
        model.addAttribute("pagination", pagination); // Add pagination information to the model

        return "activityBaseListPage";
    }
    @GetMapping("/activityList/others")
    public String selectActivityOthersList(Model model,
                                           @RequestParam(required = false) String keyword,
                                           @RequestParam(defaultValue = "1") int page) {
        int totalListCnt;
        List<AppoDto> appointmentList;
        Pagination pagination;

        if (keyword != null && !keyword.isEmpty()) {
            // Handle specific field search
            totalListCnt = map.findSearchCnt("appo_title", keyword)
                + map.findSearchCnt("appo_place", keyword)
                + map.findSearchCnt("appo_host", keyword);
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = map.findSearchListPaging("appo_title", keyword, startIndex, pageSize);
        } else {
            appointmentList = apposervice.selectActivityOthersList(); // Retrieve the others activity list using apposervice.selectActivityOthersList()
            totalListCnt = appointmentList.size(); // Get the total count of the others activity list
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            appointmentList = appointmentList.subList(startIndex, Math.min(startIndex + pageSize, totalListCnt)); // Apply pagination to the others activity list
            String subCategoryText = "기타";
            model.addAttribute("subCategoryText", subCategoryText); // Set the subCategoryText to "기타"
        }

        model.addAttribute("activityList", appointmentList);
        model.addAttribute("pagination", pagination); // Add pagination information to the model

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
    public String updateActivityForm(Model model, Integer appo_seq){
//        model.addAttribute("activityDto", apposervice.selectAppointmentOneList(appo_seq));
        return "activityUpdate";
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
//        apposervice.deleteAppointment(appo_seq);
        return "activityList/all";
    }


    //----------------Vehicle 페이지 관련 컨트롤-----------------
    //Vehicle 기본 페이지 목록 출력
    @GetMapping("/vehicleList/all")
    public String selectVehicleAllList(Model model,
                                       @RequestParam(required = false) String type,
                                       @RequestParam(required = false) String keyword,
                                       @RequestParam(defaultValue = "1") int page) {
        int totalListCnt;
        List<AppoDto> vehicleList;
        Pagination pagination;

        if (type != null && keyword != null && !type.isEmpty() && !keyword.isEmpty()) {
            if (type.equals("all")) {
                // 전체 검색 처리
                totalListCnt = map.findSearchCnt("appo_title", keyword)
                    + map.findSearchCnt("appo_place", keyword)
                    + map.findSearchCnt("appo_host", keyword);
                pagination = new Pagination(totalListCnt, page);
                int startIndex = pagination.getStartIndex();
                int pageSize = pagination.getPageSize();
                vehicleList = map.findSearchListPaging("appo_title", keyword, startIndex, pageSize);
            } else {
                // 특정 필드 검색 처리
                totalListCnt = map.findSearchCnt(type, keyword);
                pagination = new Pagination(totalListCnt, page);
                int startIndex = pagination.getStartIndex();
                int pageSize = pagination.getPageSize();
                vehicleList = map.findSearchListPaging(type, keyword, startIndex, pageSize);
            }
        } else {
            totalListCnt = map.findAllCnt();
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            vehicleList = map.findListPaging(startIndex, pageSize);
        }

        model.addAttribute("vehicleList", vehicleList);
        model.addAttribute("pagination", pagination);
        String subCategoryText = "전체";
        model.addAttribute("subCategoryText", subCategoryText);

        return "vehicleBaseListPage";
    }
    //Vehicle 세부 카테고리 페이지 이동
    @GetMapping("/vehicleList/carpool") // 카풀
    public String selectVehicleCarpoolList(Model model,
                                           @RequestParam(required = false) String keyword,
                                           @RequestParam(defaultValue = "1") int page) {
        int totalListCnt;
        List<AppoDto> vehicleList;
        Pagination pagination;

        if (keyword != null && !keyword.isEmpty()) {
            // 특정 필드 검색 처리
            totalListCnt = map.findSearchCnt("appo_title", keyword)
                + map.findSearchCnt("appo_place", keyword)
                + map.findSearchCnt("appo_host", keyword);
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            vehicleList = map.findSearchListPaging("appo_title", keyword, startIndex, pageSize);
        } else {
            vehicleList = apposervice.selectVehicleCarpoolList();
            totalListCnt = vehicleList.size();
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            vehicleList = vehicleList.subList(startIndex, Math.min(startIndex + pageSize, totalListCnt));
        }

        model.addAttribute("vehicleList", vehicleList);
        model.addAttribute("pagination", pagination);
        String subCategoryText = "카풀";
        model.addAttribute("subCategoryText", subCategoryText);

        return "vehicleBaseListPage";
    }
    @GetMapping("/vehicleList/taxi") // 택시
    public String selectVehicleTaxiList(Model model,
                                        @RequestParam(required = false) String keyword,
                                        @RequestParam(defaultValue = "1") int page) {
        int totalListCnt;
        List<AppoDto> vehicleList;
        Pagination pagination;

        if (keyword != null && !keyword.isEmpty()) {
            // 특정 필드 검색 처리
            totalListCnt = map.findSearchCnt("appo_title", keyword)
                + map.findSearchCnt("appo_place", keyword)
                + map.findSearchCnt("appo_host", keyword);
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            vehicleList = map.findSearchListPaging("appo_title", keyword, startIndex, pageSize);
        } else {
            vehicleList = apposervice.selectVehicleTaxiList();
            totalListCnt = vehicleList.size();
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            vehicleList = vehicleList.subList(startIndex, Math.min(startIndex + pageSize, totalListCnt));
        }

        model.addAttribute("vehicleList", vehicleList);
        model.addAttribute("pagination", pagination);
        String subCategoryText = "택시";
        model.addAttribute("subCategoryText", subCategoryText);

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
    public String updateVehicle(AppoDto appodto){
        if(apposervice.updateVehicle(appodto) > 0){
            //성공 시 해당 약속 상세페이지 이동
            return "redirect:/appointment/detailVehiclePage";
        }else {
            //실패 시 처리 작업 필요하면 추가
            return "redirect:/appointment/ ";
        }
    }

    //Vehicle 약속 삭제
    @GetMapping("/deleteVehicle")
    public String deleteVehicle(int appo_seq){
        //삭제 시 필요한 메세지 추가
//        apposervice.deleteAppointment(appo_seq);
        return "vehicleList/all";
    }


    //--------------Work 페이지 관련 컨트롤-----------------
    //Work 기본 페이지 목록 출력
    @GetMapping("/workList/all")
    public String selectWorkAllList(Model model,
                                    @RequestParam(required = false) String type,
                                    @RequestParam(required = false) String keyword,
                                    @RequestParam(defaultValue = "1") int page) {
        int totalListCnt;
        List<AppoDto> workList;
        Pagination pagination;

        if (type != null && keyword != null && !type.isEmpty() && !keyword.isEmpty()) {
            if (type.equals("all")) {
                // 전체 검색 처리
                totalListCnt = map.findSearchCnt("appo_title", keyword)
                    + map.findSearchCnt("appo_place", keyword)
                    + map.findSearchCnt("appo_host", keyword);
                pagination = new Pagination(totalListCnt, page);
                int startIndex = pagination.getStartIndex();
                int pageSize = pagination.getPageSize();
                workList = map.findSearchListPaging("appo_title", keyword, startIndex, pageSize);
            } else {
                // 특정 필드 검색 처리
                totalListCnt = map.findSearchCnt(type, keyword);
                pagination = new Pagination(totalListCnt, page);
                int startIndex = pagination.getStartIndex();
                int pageSize = pagination.getPageSize();
                workList = map.findSearchListPaging(type, keyword, startIndex, pageSize);
            }
        } else {
            totalListCnt = map.findAllCnt();
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            workList = map.findListPaging(startIndex, pageSize);
        }

        model.addAttribute("workList", workList);
        model.addAttribute("pagination", pagination);
        String subCategoryText = "전체";
        model.addAttribute("subCategoryText", subCategoryText);

        return "workBaseListPage";
    }

    //Work 세부 카테고리 페이지 이동
    @GetMapping("/workList/paid") // 유급
    public String selectWorkPaidList(Model model,
                                     @RequestParam(required = false) String keyword,
                                     @RequestParam(defaultValue = "1") int page) {
        int totalListCnt;
        List<AppoDto> workList;
        Pagination pagination;

        if (keyword != null && !keyword.isEmpty()) {
            // 특정 필드 검색 처리
            totalListCnt = map.findSearchCnt("appo_title", keyword)
                + map.findSearchCnt("appo_place", keyword)
                + map.findSearchCnt("appo_host", keyword);
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            workList = map.findSearchListPaging("appo_title", keyword, startIndex, pageSize);
        } else {
            workList = apposervice.selectWorkPaidList();
            totalListCnt = workList.size();
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            workList = workList.subList(startIndex, Math.min(startIndex + pageSize, totalListCnt));
        }

        model.addAttribute("workList", workList);
        model.addAttribute("pagination", pagination);
        String subCategoryText = "유급";
        model.addAttribute("subCategoryText", subCategoryText);

        return "workBaseListPage";
    }
    @GetMapping("/workList/unpaid") // 무급
    public String selectWorkUnpaidList(Model model,
                                       @RequestParam(required = false) String keyword,
                                       @RequestParam(defaultValue = "1") int page) {
        int totalListCnt;
        List<AppoDto> workList;
        Pagination pagination;

        if (keyword != null && !keyword.isEmpty()) {
            // 특정 필드 검색 처리
            totalListCnt = map.findSearchCnt("appo_title", keyword)
                + map.findSearchCnt("appo_place", keyword)
                + map.findSearchCnt("appo_host", keyword);
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            workList = map.findSearchListPaging("appo_title", keyword, startIndex, pageSize);
        } else {
            workList = apposervice.selectWorkUnpaidList();
            totalListCnt = workList.size();
            pagination = new Pagination(totalListCnt, page);
            int startIndex = pagination.getStartIndex();
            int pageSize = pagination.getPageSize();
            workList = workList.subList(startIndex, Math.min(startIndex + pageSize, totalListCnt));
        }

        model.addAttribute("workList", workList);
        model.addAttribute("pagination", pagination);
        String subCategoryText = "무급";
        model.addAttribute("subCategoryText", subCategoryText);

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
//        apposervice.deleteAppointment(appo_seq);
        return "workList/all";
    }




}
