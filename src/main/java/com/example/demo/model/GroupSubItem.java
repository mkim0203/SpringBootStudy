package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GroupSubItem {
    @NotNull
    private Integer subGroupSeq;
    @NotBlank
    private String Data;
}
