package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class GroupInfoDetail {
    private String infoItem;
    private String description;
    @NotBlank
    private String needItem;

}
