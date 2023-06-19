package com.final2.readytomeet.service;

import com.final2.readytomeet.dto.CommunityDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface CommunityService {
  public List<CommunityDto> selectList();
  public CommunityDto selectOne(int share_seq);
  public void write(CommunityDto dto, MultipartFile file) throws Exception;
  public int update(CommunityDto dto);
  public int delete(int share_seq);
  public void updateViewCount(int share_seq);
}
