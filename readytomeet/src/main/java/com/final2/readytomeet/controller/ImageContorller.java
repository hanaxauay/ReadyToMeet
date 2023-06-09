package com.final2.readytomeet.controller;


import com.final2.readytomeet.Mapper.ImageMapper;
import com.final2.readytomeet.dto.ImageUploadDto;
import com.final2.readytomeet.repository.ImageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;


@Controller
@RequestMapping("/image")
public class ImageContorller {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImageMapper imageMapper;


    @GetMapping("/mypage")
    public String myPage(){
        return "mypage";
    }

//    @ResponseBody
//    @GetMapping("/download/{filename}")
//    public Resource showImage(@PathVariable String filename) throws MalformedURLException {
//        return new UrlResource("file:" + file.getFullPath(filename));
//    }

    @PostMapping("/upload")
    public String upload(ImageUploadDto dto, Model model, @RequestParam(name = "file", required = false) MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()){
                imageRepository.upload(dto, file);
            } else{
                imageRepository.upload(dto, null);
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
