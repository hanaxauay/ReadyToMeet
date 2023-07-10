package com.final2.readytomeet.controller;


import com.final2.readytomeet.Mapper.UserMapper;
import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.AppoService;
import com.final2.readytomeet.service.UserService;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class UserController {

    @Inject
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AppoService apposervice;

    //note 회원목록
    @RequestMapping("member/list")
    public String userList(Model model){
        List<UserDto> list = userService.userList();
        model.addAttribute("list", list);
        return "memberlist";
    }


    //note 유저 정보 불러오기
    @RequestMapping("user/readuser")
    public String readUser(String user_id, Model model){
        model.addAttribute("dto", userService.readUser(user_id));
        return "userview";
    }

    //note 내가 작성한 게시글

    @RequestMapping("board/list")
    public String selectActivityAll(Model model) {
        List<CommunityDto> communityList = userMapper.findListPaging(0, 5); // 첫 번째 5개의 활동만 가져옵니다.

        model.addAttribute("communityList", communityList);
        model.addAttribute("activityList", apposervice.selectActivityAllList().subList(0, 5)); // 첫 번째 5개의 활동만 전달합니다.
        model.addAttribute("workList", apposervice.selectWorkAllList().subList(0, 5)); // 첫 번째 5개의 활동만 전달합니다.
        model.addAttribute("vehicleList", apposervice.selectVehicleAllList().subList(0, 5)); // 첫 번째 5개의 활동만 전달합니다.
        return "all";
    }


    @GetMapping("user/updateform")
    public String updateform(Model model, String user_id, HttpSession session) {
        UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
        UserDto userDto = userService.readUser(user_id);


            model.addAttribute("dto", userDto);
            return "userupdate";

    }
    @PostMapping("user/update")
    public String update(UserDto dto, Model model, HttpSession session) {
        UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
        UserDto originalDto = userService.readUser(dto.getUser_id());

        // 작성자와 로그인한 사용자가 같은 경우에만 수정 가능
        if (loginUser != null && loginUser.getUser_id().equals(originalDto.getUser_id())) {
            model.addAttribute("message", "글 수정이 완료되었습니다.");
            model.addAttribute("searchUrl", "/member/list");
            if (userService.update(dto) == null ) {
                return "message";
            } else {
                return "redirect:/user/updateform?user_id=" + dto.getUser_id();
            }
        } else if (loginUser == null) {
            // 로그인하지 않은 경우
            model.addAttribute("message", "로그인이 필요합니다.");
            model.addAttribute("searchUrl", "/login");
            return "message";
        } else {
            // 작성자가 아닌 경우
            model.addAttribute("message", "글 작성자만 수정할 수 있습니다.");
            model.addAttribute("searchUrl", "/user/readuser?user_id=" + dto.getUser_id());
            return "message";
        }
    }
    @GetMapping("/delete")
    public String delete(String user_id, Model model, HttpSession session) {
        UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
        UserDto userDto = userService.readUser(user_id);
        return "memberlist";
    }











//    @Resource(name = "uimagePath")
//    private String uimagePath;
//
//
//    //note 회원 프로필 이미지 수정처리
//
//    public String userImgModify(String user_id,
//                                MultipartFile file,
//                                HttpSession session,
//                                RedirectAttributes redirectAttributes) throws Exception {
//        if (file == null) {
//            redirectAttributes.addFlashAttribute("msg", "FAIL");
//            return "redirect:/user/view";
//        }
//        String uploadFile = UploadFileUtils.uploadFile(uimagePath, file.getOriginalFilename(), file.getBytes());
//        String front = uploadFile.substring(0, 12);
//        String end = uploadFile.substring(14);
//        String user_img = front + end;
//        service.modifyUimage(user_id, user_img);
//        Object userObj = session.getAttribute("login");
//        UserDto userDto = (UserDto) userObj;
//        userDto.setUser_img(user_img);
//        session.setAttribute("login", userDto);
//        redirectAttributes.addFlashAttribute("msg", "SUCCESS");
//        return "redirect:/uset/view";
//    }


//    @PostMapping("/upload")
//    public String upload(UserDto dto, Model model, @RequestParam(name = "file", required = false) MultipartFile file) {
//        try {
//            if (file != null && !file.isEmpty()) {
//                userService.upload(dto, file);
//            } else {
//                userService.upload(dto, null);
//            }
//            model.addAttribute("message", "사진 업로드 완료되었습니다.");
//            model.addAttribute("searchUrl", "/user/view");
//            return "message";
//        } catch (Exception e) {
//            e.printStackTrace();
//            model.addAttribute("message", "사진 업로드 중 오류가 발생했습니다.");
//            model.addAttribute("searchUrl", "/user/view");
//            return "message";
//        }
//    }
//


}
