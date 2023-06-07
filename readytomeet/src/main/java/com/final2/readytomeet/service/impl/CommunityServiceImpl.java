package com.final2.readytomeet.service.impl;

import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.mapper.CommunityMapper;
import com.final2.readytomeet.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class CommunityServiceImpl implements CommunityService {

  @Autowired
  private CommunityMapper communityMapper;

  @Override
  public void write(CommunityDto dto, MultipartFile file) throws Exception {
    String projectPath = "E:/files/";
    UUID uuid = UUID.randomUUID();

    if(file != null && !file.isEmpty()) {
      String filename = uuid + "_" + file.getOriginalFilename();
      File saveFile = new File(projectPath, filename);
      file.transferTo(saveFile);
      dto.setFilename(filename);
      dto.setFilepath("/download/" + filename);
    }
    communityMapper.write(dto);
  }




}
