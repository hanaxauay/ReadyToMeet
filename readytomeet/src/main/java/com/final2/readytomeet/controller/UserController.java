package com.final2.readytomeet.controller;


import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.annotation.Resource;
import javax.inject.Inject;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Inject
    private UserService service;

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



    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String pofile(HttpSession session, Model model) throws Exception {
//        Object userObj = session.getAttribute("login");
//        UserDto dto = (UserDto) userObj;
//        String user_id = dto.getUser_id();
//
//        model.addAttribute("UserDto", dto);

        String user_id = (String) session.getAttribute("login");

        UserDto dto = service.readUser(user_id);

       model.addAttribute("UserDto", dto);


        return "userview";
    }

    /* 회원 정보 보기 */
//    @GetMapping("/user")
//    public void userGet(HttpSession session, Model model) throws Exception {
//        String user_id = (String) session.getAttribute("user_id");
//
//        UserDto dto = service.readUser(user_id);
//
//        model.addAttribute("UserDto", dto);
//
//    }
//
//
//    @GetMapping("/view")
//    public String readUser(String user_id, Model model) {
//        model.addAttribute("dto", service.readUser(user_id));
//        return "userview";
//    }



    @PostMapping("/upload")
    public String upload(UserDto dto, Model model, @RequestParam(name = "file", required = false) MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                service.upload(dto, file);
            } else {
                service.upload(dto, null);
            }
            model.addAttribute("message", "사진 업로드 완료되었습니다.");
            model.addAttribute("searchUrl", "/user/view");
            return "message";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "사진 업로드 중 오류가 발생했습니다.");
            model.addAttribute("searchUrl", "/user/view");
            return "message";
        }
    }


    @GetMapping("/updateform")
    public String updateform(Model model, String user_id) {
        model.addAttribute("dto");
        return "userupdate";
    }

    /* 회원 정보 업데이트 */
    @GetMapping("/update")
    public String updateGet(HttpSession session, Model model) throws Exception {
        model.addAttribute("userDto", service.readUser((String)session.getAttribute("user_id")));

        return "userupdate";

    }


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
