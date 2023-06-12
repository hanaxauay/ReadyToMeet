package com.final2.readytomeet.service;

import com.final2.readytomeet.Mapper.SearchMapper;
import com.final2.readytomeet.dto.AppoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchMapper searchMapper;

    public List<AppoDto> search(String keyword) {
        return searchMapper.selectAllAppos(keyword);

    }
}
