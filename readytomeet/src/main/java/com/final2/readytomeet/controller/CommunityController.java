package com.final2.readytomeet.controller;

import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.dto.Pagination;
import com.final2.readytomeet.Mapper.CommunityMapper;
import com.final2.readytomeet.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/community")
public class CommunityController {

  @Autowired
  private CommunityMapper map;
  @Autowired
  private CommunityService service;

  @GetMapping("/list")
  public String selectList(Model model, @RequestParam(defaultValue = "1") int page) {

    // 총 게시물 수
    int totalListCnt = map.findAllCnt();
    Pagination pagination = new Pagination(totalListCnt, page);
    int startIndex = pagination.getStartIndex();
    int pageSize = pagination.getPageSize();
    List<CommunityDto> communityList = map.findListPaging(startIndex, pageSize);

    model.addAttribute("communityList", communityList);
    model.addAttribute("pagination", pagination);

    return "communitylist";
  }
  @GetMapping("/write")
  public String gotocommunitywrite(){
    return "communitywrite";
  }

  @PostMapping("/writepro")
  public String write(CommunityDto dto, Model model, @RequestParam(name = "file", required = false) MultipartFile file){
    try {
      if (file != null && !file.isEmpty()) {
        service.write(dto, file);
      } else {
        service.write(dto, null);
      }
      model.addAttribute("message", "글 작성이 완료되었습니다.");
      model.addAttribute("searchUrl", "/community/list");
      return "message";
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("message", "글 작성 중 오류가 발생했습니다.");
      model.addAttribute("searchUrl", "/community/list");
      return "message";
    }
  }

  @GetMapping("/view")
  public String selectOne(Model model, int share_seq) {
    // 해당 게시물의 조회수를 1 증가시킵니다.
    service.updateViewCount(share_seq);
    model.addAttribute("dto", service.selectOne(share_seq));
    return "communityview";
  }

  @GetMapping("/updateform")
  public String updateform(Model model, int share_seq){
    model.addAttribute("dto", service.selectOne(share_seq));
    return "communityupdate";
  }
  @PostMapping("/update")
  public String update(CommunityDto dto, Model model) {
    model.addAttribute("message","글 수정이 완료되었습니다");
    model.addAttribute("searchUrl","/community/list");
    if(service.update(dto) > 0) {
      return "message";
    }else {
      return "redirect:/COMMUNITY/updateform?share_seq=" + dto.getShare_seq();
    }
  }
  @GetMapping("/delete")
  public String delete(int share_seq, Model model) {
    model.addAttribute("message","삭제가 완료되었습니다");
    model.addAttribute("searchUrl","/community/list");
    if(service.delete(share_seq) > 0) {
      return "message";
    } else {
      return "redirect:/community/view?share_seq=" + share_seq;
    }
  }



















}
