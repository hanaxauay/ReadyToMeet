package com.final2.readytomeet.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AppoSaveForm {

    @NotNull
    private String appo_category;

    @NotBlank
    @Size(min = 2, message = "최소 두 글자 이상 적어주세요.")
    private String appo_title;

    @NotNull
    private String appo_time;

    @NotNull
    private int appo_min_mem;

    @NotNull
    private int appo_max_mem;

    @NotBlank
    private String appo_place;

    @NotNull
    @Size(min = 5, message = "최소 5글자 이상 적어주세요.")
    private String appo_content;

}
