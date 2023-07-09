package com.final2.readytomeet.controller;


import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    //note 회원목록
    @RequestMapping("user/list")
    public String userList(Model model){
        List<UserDto> list = userService.userList();
        model.addAttribute("list", list);
        return "userlist";
    }


    //note 회원 상세정보 조회
    @RequestMapping("user/view")
    public String userView(String user_id, Model model){
        model.addAttribute("dto", userService.viewUser(user_id));
        return "user/userview";
    }












//    @RequestMapping("user/view")
//    public String getUserProfile(String user_id, Model model, HttpSession session) {
//        UserDto userDto = userService.viewUser(user_id);
//        session.setAttribute("userDto", userDto);
//        model.addAttribute("userDto", userDto);
//        return "userview";
//    }




    //note 프로필 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//    @GetMapping("/view")
//    public String getUser(Model model, HttpSession session, String user_id){
//        UserDto loggedInUser = (UserDto) session.getAttribute("loggedInUser");
//
//
//        UserDto userDto = userService.getUser(String.valueOf(loggedInUser));
//        model.addAttribute("userDto", userDto);
//        return "userview";
//    }
//



    //note 프로필정보출력중
//    @GetMapping("/view")
//    public String getUserProfile(String user_id, Model model) {
//
//            UserDto userDto = userService.getUserProfile(user_id);
//            model.addAttribute("user", userDto);
//            return "userview";
//
//    }



//    @RequestMapping("/login")
//    public String login() {
//        logger.info("LOGIN PAGE");
//
//        return "login";
//    }


//    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
//    public String userLogin(UserDto dto, HttpServletRequest request) {
//
//        HttpSession session = request.getSession();
//        UserDto res = userService.login(dto);
//
//        if( res != null ) {
//
//            session.setAttribute("res", res);
//            return "redirect:main";
//        } else {
//            return "redirect:login";
//        }
//    }
//
//
//





//    @Autowired
//    UserController(UserService userService){
//        this.userService = userService;
//    }
//
//    @GetMapping("/user")
//    @ResponseBody
//    public List<Map<String, Object>> getUser(){
//        return userService.getUser();
//    }


    //note 회원 목록 조회








//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public void viewGet(HttpSession session, Model model) throws Exception{
//        String user_id  = (String) session.getAttribute("user_id");
//
//        UserDto dto = userService.readUser(user_id);
//
//        model.addAttribute("dto", dto);
//
//
//    }






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
//
//    @GetMapping("/updateform")
//    public String updateform(Model model, String user_id) {
//        model.addAttribute("dto");
//        return "userupdate";
//    }
//
//    /* 회원 정보 업데이트 */
//    @GetMapping("/update")
//    public String updateGet(HttpSession session, Model model) throws Exception {
//        model.addAttribute("userDto", userService.readUser((String)session.getAttribute("user_id")));
//
//        return "userupdate";
//
//    }


//    @PostMapping("/update")
//    public String updatePOST(UserDto dto) throws Exception {
//        service.updateUser(dto);
//        return "userview";
//    }


//    @GetMapping("update")
//    public String gotouserview() {
//        return "userview";
//    }


}
