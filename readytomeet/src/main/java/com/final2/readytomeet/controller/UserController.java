package com.final2.readytomeet.controller;


import com.final2.readytomeet.Mapper.UserMapper;

import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.inject.Inject;

import javax.servlet.http.HttpSession;
import java.util.List;



@Controller
public class UserController {


    @Inject
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    //note 회원목록
    @RequestMapping("member/list")
    public String userList(Model model){
        List<UserDto> list = userService.userList();
        model.addAttribute("list", list);
        return "memberlist";
    }


    //note 유저 정보 불러오기
    @RequestMapping("user/readuser")
    public String readUser(Integer id, Model model){
        model.addAttribute("dto", userService.readUser(id));
        return "userview";
    }


    @RequestMapping("user/select")
    public String selectOne(Model model, Integer id){
        try {
            userService.selectOne(id);
            model.addAttribute("dto", userService.selectOne(id));

        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return "redirect:/user/readuser?id="+"1";
    }


        //note 회원 정보 수정

    @RequestMapping("user/updateform")
    public String update(@ModelAttribute UserDto userDto){
        userService.update(userDto.getId());
        return "redirect:/member/list";
    }







//        @GetMapping("user/updateform")
//        public String updateform(Model model, Integer id, HttpSession session) {
//            UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
//            UserDto userDto = userService.selectOne(id);
//            model.addAttribute("dto", userDto);
//            return "userupdate";
//        }
//
//    @PostMapping("user/update")
//    public String update(UserDto dto, Model model, HttpSession session) {
//        UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
//        UserDto originalDto = userService.selectOne(dto.getId());
//
//        try {
//            if (loginUser != null && loginUser.getUser_id().equals(originalDto.getUser_id())) {
//                model.addAttribute("message", "정보 수정이 완료되었습니다.");
//                model.addAttribute("searchUrl", "/member/list");
//                if (userService.update(dto) > 0) {
//                    return "message";
//                } else {
//                    return "redirect:/user/updateform?user_id=" + dto.getUser_id();
//                }
//            } else if (loginUser == null) {
//                // 로그인하지 않은 경우
//                model.addAttribute("message", "로그인이 필요합니다.");
//                model.addAttribute("searchUrl", "/login");
//                return "message";
//            } else {
//                // 작성자가 아닌 경우
//                model.addAttribute("message", "글 작성자만 수정할 수 있습니다.");
//                model.addAttribute("searchUrl", "/user/readuser?id=" + dto.getId());
//                return "message";
//            } // 작성자와 로그인한 사용자가 같은 경우에만 수정 가능
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:/user/readuser?id="+"1";
//    }
//



    @GetMapping("/delete")
    public String delete(Integer id, Model model, HttpSession session) {
        UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
        UserDto userDto = userService.readUser(id);
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
