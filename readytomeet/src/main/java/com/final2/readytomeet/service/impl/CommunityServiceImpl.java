package com.final2.readytomeet.service.impl;

import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.Mapper.CommunityMapper;
import com.final2.readytomeet.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class CommunityServiceImpl implements CommunityService {

  @Autowired
  private CommunityMapper communityMapper;

  @Override
  public List<CommunityDto> selectList() {
    return communityMapper.selectList();
  }
  @Override
  public CommunityDto selectOne(int share_seq) {
    return communityMapper.selectOne(share_seq);
  }
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
  @Override
  public int update(CommunityDto dto){
    return communityMapper.update(dto);
  }
  @Override
  public int delete(int share_seq) {
    return communityMapper.delete(share_seq);
  }
  @Override
  public int updateViewCount(int share_seq) {
    return communityMapper.updateViewCount(share_seq);
  }
  @Override
  public int findSearchCnt(String type, String keyword) {
    return communityMapper.findSearchCnt(type, keyword);
  }

  @Override
  public List<CommunityDto> findSearchListPaging(String type, String keyword, int startIndex, int pageSize) {
    return communityMapper.findSearchListPaging(type, keyword, startIndex, pageSize);
  }


}
