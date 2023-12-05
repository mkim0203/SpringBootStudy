package com.example.demo.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * model in list model 항목 테스트
 */
@Getter
@Setter
public class GroupInfo {

    public GroupInfo() {
        subItems = new ArrayList<>();
        detail = new GroupInfoDetail();
        permission = new GroupPermission();
    }

    @NotNull
    private Integer groupId;
    @NotNull
    private String groupName;

    /**
     * Valid 가 없으면 list항목에 대하여 정합성 체크 진행하지 않음..
     */
    @Valid
    @Setter(AccessLevel.NONE)
    private final List<GroupSubItem> subItems;
    @Valid
    @Setter(AccessLevel.NONE)
    private final GroupInfoDetail detail;
    @Valid
    private GroupPermission permission;
}
