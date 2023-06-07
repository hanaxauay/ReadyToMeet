package com.final2.readytomeet.controller;


import com.final2.readytomeet.dto.ImageUploadDto;
import com.final2.readytomeet.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/image")
public class ImageContorller {

    @Autowired
    private ImageRepository repository;


    @GetMapping("/mypage")
    public String myPage(){
        return "mypage";
    }
    @PostMapping("/write")
    public String write(ImageUploadDto dto, Model model, @RequestParam(name = "file", required = false) MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()){
                repository.write(dto, file);
            } else{
                repository.write(dto, null);
            }
            model.addAttribute("message", "사진 업로드 완료");
            model.addAttribute("searchUrl", "/mypage");
            return "message";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "사진 업로드 오류");
            return "message";
        }
    }

}
