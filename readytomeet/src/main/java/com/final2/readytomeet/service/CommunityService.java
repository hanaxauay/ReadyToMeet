package com.final2.readytomeet.service;

import com.final2.readytomeet.dto.CommunityDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface CommunityService {
  public void write(CommunityDto dto, MultipartFile file) throws Exception;
}
