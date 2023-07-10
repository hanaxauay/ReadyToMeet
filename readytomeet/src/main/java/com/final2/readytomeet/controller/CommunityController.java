package com.final2.readytomeet.controller;

import com.final2.readytomeet.Mapper.CommunityMapper;
import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.dto.Pagination;
import com.final2.readytomeet.dto.UserDto;
import com.final2.readytomeet.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/community")
public class CommunityController {

  @Autowired
  private CommunityMapper map;
  @Autowired
  private CommunityService service;

  @GetMapping("/list")
  public String selectList(Model model, @RequestParam(defaultValue = "1") int page,
                           @RequestParam(required = false) String type,
                           @RequestParam(required = false) String keyword) {
    int totalListCnt;
    List<CommunityDto> communityList;
    Pagination pagination;

    if (type != null && keyword != null && !type.isEmpty() && !keyword.isEmpty()) {
      if (type.equals("all")) {
        // 전체 검색 처리
        totalListCnt = map.findSearchCnt("share_title", keyword)
            + map.findSearchCnt("share_content", keyword)
            + map.findSearchCnt("user_nickname", keyword);
        pagination = new Pagination(totalListCnt, page);
        int startIndex = pagination.getStartIndex();
        int pageSize = pagination.getPageSize();
        communityList = map.findSearchListPaging("share_title", keyword, startIndex, pageSize);
      } else {
        // 특정 필드 검색 처리
        totalListCnt = map.findSearchCnt(type, keyword);
        pagination = new Pagination(totalListCnt, page);
        int startIndex = pagination.getStartIndex();
        int pageSize = pagination.getPageSize();
        communityList = map.findSearchListPaging(type, keyword, startIndex, pageSize);
      }
    } else {
      // 검색 조건이 없는 경우 전체 레코드를 검색
      totalListCnt = map.findAllCnt();
      pagination = new Pagination(totalListCnt, page);
      int startIndex = pagination.getStartIndex();
      int pageSize = pagination.getPageSize();
      communityList = map.findListPaging(startIndex, pageSize);
    }

    model.addAttribute("communityList", communityList);
    model.addAttribute("pagination", pagination);
    model.addAttribute("pageNumbers", IntStream.rangeClosed(pagination.getStartPage(), pagination.getEndPage()).boxed().collect(Collectors.toList()));

    return "communitylist";
  }

  @GetMapping("/write")
  public String gotocommunitywrite(HttpSession session) {
    UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
    if (loginUser != null) {
      return "communitywrite";
    } else {
      // 로그인되지 않은 상태 처리
      return "redirect:/login";
    }
  }

  @PostMapping("/writepro")
  public String write(CommunityDto dto, Model model,
                      @RequestParam(name = "file", required = false) MultipartFile file,
                      HttpSession session,
                      @RequestParam(required = false) String type,
                      @RequestParam(required = false) String keyword) {
    try {
      UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
      if (loginUser != null) {
        dto.setUser_id(loginUser.getUser_id()); // user_id 설정
        dto.setUser_nickname(loginUser.getUser_nickname()); // user_nickname 설정

        if (file != null && !file.isEmpty()) {
          service.write(dto, file);
        } else {
          service.write(dto, null);
        }

        model.addAttribute("user_id", dto.getUser_id());
        model.addAttribute("user_nickname", dto.getUser_nickname());
        model.addAttribute("message", "글 작성이 완료되었습니다.");
        if (type != null && keyword != null && !keyword.isEmpty()) {
          model.addAttribute("searchUrl", "/community/list?type=" + type + "&keyword=" + keyword);
        } else {
          model.addAttribute("searchUrl", "/community/list");
        }

        return "message";
      } else {
        // 로그인되지 않은 상태 처리
        model.addAttribute("error", "로그인이 필요합니다.");
        return "login";
      }
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
  public String updateForm(Model model, int share_seq, HttpSession session) {
    UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
    CommunityDto communityDto = service.selectOne(share_seq);

    // 작성자와 로그인한 사용자가 같은 경우에만 수정 가능
    if (loginUser != null && loginUser.getUser_id().equals(communityDto.getUser_id())) {
      model.addAttribute("dto", communityDto);
      return "communityupdate";
    } else if (loginUser == null) {
      // 로그인하지 않은 경우
      model.addAttribute("message", "로그인이 필요합니다.");
      model.addAttribute("searchUrl", "/login");
      return "message";
    } else {
      // 작성자가 아닌 경우
      model.addAttribute("message", "해당 게시물은 수정할 수 없습니다.");
      model.addAttribute("searchUrl", "/community/view?share_seq=" + share_seq);
      return "message";
    }
  }

  @PostMapping("/update")
  public String update(CommunityDto dto, Model model, HttpSession session,
                       @RequestParam(required = false) String type,
                       @RequestParam(required = false) String keyword) {
    UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
    CommunityDto originalDto = service.selectOne(dto.getShare_seq());

    // 작성자와 로그인한 사용자가 같은 경우에만 수정 가능
    if (loginUser != null && loginUser.getUser_id().equals(originalDto.getUser_id())) {
      model.addAttribute("message", "글 수정이 완료되었습니다.");
      if (type != null && keyword != null && !keyword.isEmpty()) {
        model.addAttribute("searchUrl", "/community/list?type=" + type + "&keyword=" + keyword);
      } else {
        model.addAttribute("searchUrl", "/community/list");
      }
      if (service.update(dto) > 0) {
        return "message";
      } else {
        return "redirect:/community/updateform?share_seq=" + dto.getShare_seq();
      }
    } else if (loginUser == null) {
      // 로그인하지 않은 경우
      model.addAttribute("message", "로그인이 필요합니다.");
      model.addAttribute("searchUrl", "/login");
      return "message";
    } else {
      // 작성자가 아닌 경우
      model.addAttribute("message", "글 작성자만 수정할 수 있습니다.");
      model.addAttribute("searchUrl", "/community/view?share_seq=" + dto.getShare_seq());
      return "message";
    }
  }

  @GetMapping("/delete")
  public String delete(int share_seq, Model model, HttpSession session,
                       @RequestParam(required = false) String type,
                       @RequestParam(required = false) String keyword) {
    UserDto loginUser = (UserDto) session.getAttribute("loggedInUser");
    CommunityDto communityDto = service.selectOne(share_seq);

    // 작성자와 로그인한 사용자가 같은 경우에만 삭제 가능
    if (loginUser != null && loginUser.getUser_id().equals(communityDto.getUser_id())) {
      model.addAttribute("message", "삭제가 완료되었습니다.");
      if (type != null && keyword != null && !keyword.isEmpty()) {
        model.addAttribute("searchUrl", "/community/list?type=" + type + "&keyword=" + keyword);
      } else {
        model.addAttribute("searchUrl", "/community/list");
      }
      if (service.delete(share_seq) > 0) {
        return "message";
      } else {
        model.addAttribute("message", "삭제 중 오류가 발생했습니다.");
        return "message";
      }
    } else if (loginUser == null) {
      // 로그인하지 않은 경우
      model.addAttribute("message", "로그인이 필요합니다.");
      model.addAttribute("searchUrl", "/login");
      return "message";
    } else {
      // 작성자가 아닌 경우
      model.addAttribute("message", "해당 게시물은 삭제할 수 없습니다.");
      model.addAttribute("searchUrl", "/community/view?share_seq=" + share_seq);
      return "message";
    }
  }



















}
