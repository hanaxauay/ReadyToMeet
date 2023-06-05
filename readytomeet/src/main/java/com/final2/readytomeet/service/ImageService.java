//package com.final2.readytomeet.service;
//
//import com.final2.readytomeet.repository.ImageRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.Value;
//import org.springframework.stereotype.Service;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.UUID;
//
//@RequiredArgsConstructor
//@Service
//public class ImageService {
//
//    private final ImageRepository imageRepository;
//
////    @Value("")
////    private String uploadFolder;
//
////    public void upload(ImageUploadDto imageUploadDto, PrincipalDetails principalDetails) {
////        //동일 사진 업로드 했을 때 사진 덮어 씌워지는거 방지
////        UUID uuid = UUID.randomUUID();
////        String imageFileName = uuid + "_" + imageUploadDto.getFile().getOrignalFilename();
////
////        Path imageFilePath = Paths.get(uploadFolder + imageFileName);
////
////        try {
////            Files.write(imageFilePath, imageUploadDto.getFile().getBytes());
////        } catch(Exception e) {
////            e.printStackTrace();
////        }
////    }
//}
