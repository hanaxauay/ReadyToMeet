package com.final2.readytomeet.controller;

import com.final2.readytomeet.Mapper.UserMapper;
import com.final2.readytomeet.chat.dto.ChatRoom;
import com.final2.readytomeet.chat.repository.ChatRoomRepository;
import com.final2.readytomeet.dto.AppoDto;
import com.final2.readytomeet.dto.AppoSaveForm;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.AppoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
@RequestMapping("/appointment")
@Slf4j
@RequiredArgsConstructor
public class AppoController {
    // 로그인 세션 추가 시 추가 수정 필요!! //

    private final AppoService apposervice;
    private final ChatRoomRepository chatRoomRepository;
    private final UserMapper userMapper;

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
    public String detailActivityPage(Model model, @RequestParam int appo_seq, HttpSession session){

        //로그인 세션 가져와서 내가 작성한 글이면 채팅방 개설하기랑 수정 목록 삭제만 들어 있는 detail페이지로 보내기.
        UserDto loggedInUser = (UserDto) session.getAttribute("loggedInUser");
        AppoDto appoDto = apposervice.selectAppointmentOneList(appo_seq);
        if (loggedInUser != null) {

            if (loggedInUser.getUser_id().equals(appoDto.getAppo_host())) {
                model.addAttribute("activityDto", appoDto);
                return "activityDetailPageMine";
            } else {
                model.addAttribute("activityDto", appoDto);
                return "activityDetailPage";
            }
        }
        return "redirect:/login";

    }

    //Activity 약속 생성 폼 이동
    @GetMapping("/insertActivity")
    public String insertActivityForm(Model model) {
        model.addAttribute("appoSaveForm", new AppoSaveForm());
        return "activityWrite";
    }

    //Activity 약속 생성
    @PostMapping("/insertActivity")
    public String insertActivity(@Validated @ModelAttribute("appoSaveForm") AppoSaveForm form, BindingResult bindingResult, HttpSession session,
                                 RedirectAttributes redirectAttributes, Model model) {
        UserDto loggedInUser = (UserDto) session.getAttribute("loggedInUser");

        AppoDto appoDto = new AppoDto();
        appoDto.setAppo_category(form.getAppo_category());
        appoDto.setAppo_title(form.getAppo_title());
        appoDto.setAppo_time(form.getAppo_time());
        appoDto.setAppo_min_mem(form.getAppo_min_mem());
        appoDto.setAppo_max_mem(form.getAppo_max_mem());
        appoDto.setAppo_place(form.getAppo_place());
        appoDto.setAppo_content(form.getAppo_content());

        if (loggedInUser != null) {
            appoDto.setAppo_host(loggedInUser.getUser_id());
        }
            if (bindingResult.hasErrors()) {
                log.info("errors={}", bindingResult);
                return "activityWrite"; // 이걸 전에는 계속 redirect 시켜버리니까 검증결과가 안나오고 계속 원래로 돌아가버리지 하..
            }

            if (apposervice.insertActivity(appoDto) > 0) {
                redirectAttributes.addAttribute("appo_seq", appoDto.getAppo_seq());
                redirectAttributes.addAttribute("status", true);

                redirectAttributes.addAttribute("success", "약속 등록에 성공했습니다");

                //성공 시 해당 약속 상세페이지 이동
                return "redirect:/appointment/activityList/all";
            } else {
                return "redirect:/appointment/insertActivityForm";

            }
    }
            //Activity 약속 수정 폼 이동 (예정)
            @GetMapping("/updateActivityForm")
            public String updateActivityForm (Model model, Integer appo_seq){
//        model.addAttribute("activityDto", apposervice.selectAppointmentOneList(appo_seq));
                return "activityUpdate";
            }

            //Activity 약속 수정 (예정)
            @PostMapping("/updateActivity")
            public String updateActivity (AppoDto appodto){
                if (apposervice.updateActivity(appodto) > 0) {
                    //성공 시 해당 약속 상세페이지 이동
                    return "redirect:/appointment/detailActivityPage";
                } else {
                    //실패 시 처리 작업 필요하면 추가
                    return "redirect:/appointment/updateActivityForm";
                }
            }

            //Activity 약속 삭제
            @GetMapping("/deleteActivity")
            public String deleteActivity ( int appo_seq){
                //삭제 시 필요한 메세지 추가
                apposervice.deleteAppointment(appo_seq);
                return "activityList/all";
            }


            //----------------Vehicle 페이지 관련 컨트롤-----------------
            //Vehicle 기본 페이지 목록 출력
            @GetMapping("/vehicleList/all")
            public String selectVehicleAllList (Model model){
                model.addAttribute("vehicleList", apposervice.selectVehicleAllList());
                String subCategoryText = "전체";
                model.addAttribute("subCategoryText", subCategoryText);
                return "vehicleBaseListPage";
            }

            //Vehicle 세부 카테고리 페이지 이동
            @GetMapping("/vehicleList/carpool") //카풀
            public String selectVehicleCarpoolList (Model model){
                model.addAttribute("vehicleList", apposervice.selectVehicleCarpoolList());
                String subCategoryText = "카풀";
                model.addAttribute("subCategoryText", subCategoryText);
                return "vehicleBaseListPage";
            }
            @GetMapping("/vehicleList/taxi") //택시
            public String selectVehicleTaxiList (Model model){
                model.addAttribute("vehicleList", apposervice.selectVehicleTaxiList());
                String subCategoryText = "택시";
                model.addAttribute("subCategoryText", subCategoryText);
                return "vehicleBaseListPage";
            }


            //Vehicle 상세페이지 이동 (예정)
            @GetMapping("/detailVehicle")
            public String detailVehiclePage (Model model,int appo_seq){
                model.addAttribute("vehicleDto", apposervice.selectAppointmentOneList(appo_seq));
                return "vehicleDetail";
            }

            //Vehicle 약속 생성 폼 이동
            @GetMapping("/insertVehicleForm")
            public String insertVehicleForm () {
                return "vehicleWrite";
            }

            //Vehicle 약속 생성
            @PostMapping("/insertVehicle")
            public String insertVehicle (AppoDto appodto){
                if (apposervice.insertVehicle(appodto) > 0) {
                    //성공 시 해당 약속 상세페이지
                    return "redirect:/appointment/detailVehiclePage";
                } else {
                    //실패 시 처리 작업 필요하면 추가
                    return "redirect:/appointment/insertVehicleForm";
                }
            }

            //Vehicle 약속 수정 폼 이동 (예정)
            @GetMapping("/updateVehicleForm")
            public String updateVehicleForm (Model model,int appo_seq){
                model.addAttribute("vehicleDto", apposervice.selectAppointmentOneList(appo_seq));
                return "vehicleWrite";
            }

            //Vehicle 약속 수정 (예정)
            @PostMapping("/updateVehicle")
            public String updateVehicle (AppoDto appodto,int appo_seq){
                if (apposervice.updateVehicle(appodto) > 0) {
                    //성공 시 해당 약속 상세페이지 이동
                    return "redirect:/appointment/detailVehiclePage(appo_seq)";
                } else {
                    //실패 시 처리 작업 필요하면 추가
                    return "redirect:/appointment/ ";
                }
            }

            //Vehicle 약속 삭제
            @GetMapping("/deleteVehicle")
            public String deleteVehicle ( int appo_seq){
                //삭제 시 필요한 메세지 추가
                apposervice.deleteAppointment(appo_seq);
                return "vehicleList/all";
            }


            //--------------Work 페이지 관련 컨트롤-----------------
            //Work 기본 페이지 목록 출력
            @GetMapping("/workList/all")
            public String selectWorkAllList (Model model){
                model.addAttribute("workList", apposervice.selectWorkAllList());
                String subCategoryText = "전체";
                model.addAttribute("subCategoryText", subCategoryText);
                return "workBaseListPage";
            }

            //Work 세부 카테고리 페이지 이동
            @GetMapping("/workList/paid") //유급
            public String selectWorkPaidList (Model model){
                model.addAttribute("workList", apposervice.selectWorkPaidList());
                String subCategoryText = "유급";
                model.addAttribute("subCategoryText", subCategoryText);
                return "workBaseListPage";
            }
            @GetMapping("/workList/unpaid") //무급
            public String selectWorkUnpaidList (Model model){
                model.addAttribute("workList", apposervice.selectWorkUnpaidList());
                String subCategoryText = "무급";
                model.addAttribute("subCategoryText", subCategoryText);
                return "workBaseListPage";
            }

            //Work 상세페이지 이동 (예정)
            @GetMapping("/detailWorkPage")
            public String detailWorkPage (Model model,int appo_seq){
                model.addAttribute("workDto", apposervice.selectAppointmentOneList(appo_seq));
                return "workDetail";
            }

            //Work 약속 생성 폼 이동
            @GetMapping("/insertWorkForm")
            public String insertWorkForm () {
                return "workWrite";
            }

            //Work 약속 생성
            @PostMapping("/insertWork")
            public String insertWork (AppoDto appodto){
                if (apposervice.insertWork(appodto) > 0) {
                    //성공 시 해당 약속 상세페이지
                    return "redirect:/appointment/detailWorkPage";
                } else {
                    //실패 시 처리 작업 필요하면 추가
                    return "redirect:/appointment/insertWorkForm";
                }
            }

            //Work 약속 수정 폼 이동 (예정)
            @GetMapping("/updateWorkForm")
            public String updateWorkForm (Model model,int appo_seq){
                model.addAttribute("workDto", apposervice.selectAppointmentOneList(appo_seq));
                return "workWrite";
            }

            //Work 약속 수정 (예정)
            @PostMapping("/updateWork")
            public String updateWork (AppoDto appodto){
                if (apposervice.updateWork(appodto) > 0) {
                    //성공 시 해당 약속 상세페이지 이동
                    return "redirect:/appointment/detailWorkPage";
                } else {
                    //실패 시 처리 작업 필요하면 추가
                    return "redirect:/appointment/ ";
                }
            }

            //Work 약속 삭제
            @GetMapping("/deleteWork")
            public String deleteWork ( int appo_seq){
                //삭제 시 필요한 메세지 추가
                apposervice.deleteAppointment(appo_seq);
                return "workList/all";
            }


        }
