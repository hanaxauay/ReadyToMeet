package com.final2.readytomeet.controller;

import com.final2.readytomeet.dto.AppoDto;
import com.final2.readytomeet.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;
    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<AppoDto> searchList = searchService.search(keyword);
        model.addAttribute("searchList", searchList);
        return "viewSearchAll";
    }
}
