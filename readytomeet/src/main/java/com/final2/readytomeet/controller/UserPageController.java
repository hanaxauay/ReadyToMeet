package com.final2.readytomeet.controller;

import com.final2.readytomeet.Mapper.UserPageMapper;
import com.final2.readytomeet.dto.CommunityDto;
import com.final2.readytomeet.dto.UserPagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequestMapping("/user")
@Controller
public class UserPageController {

    @Autowired
    private UserPageMapper map;



    @GetMapping("/list")
    public String selectList(Model model, @RequestParam(defaultValue = "1") int page) {
        int totalListCnt = map.findAllCnt();
        UserPagination pagination = new UserPagination(totalListCnt, page);
        int startIndex = pagination.getStartIndex();
        int pageSize = pagination.getPageSize();
        List<CommunityDto> communityList = map.findListPaging(startIndex, pageSize);

        model.addAttribute("communityList", communityList);
        model.addAttribute("pagination", pagination);
        model.addAttribute("pageNumbers", IntStream.rangeClosed(pagination.getStartPage(), pagination.getEndPage()).boxed().collect(Collectors.toList()));

        return "userView";
    }

}
