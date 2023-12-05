package com.example.demo.service;

import com.example.demo.model.GroupInfo;
import com.example.demo.model.ValidateItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Slf4j
@Service
public class ValidItemService implements IValidItemService {
    @Override
    public boolean checkUserId(String userId) {
        // null 이면 interface valid 에서 걸러짐.
        if(userId == null) log.debug("userid is null");
        return true;
    }

    @Override
    public boolean checkAvg(Integer avg) {
        return true;
    }

    @Override
    public boolean checkItem(ValidateItem item) {
        return true;
    }

    @Override
    public boolean checkGroupInfo(GroupInfo group) {
        if(Objects.isNull(group.getSubItems())) log.debug("sub items is null");
        else log.debug(String.valueOf(group.getSubItems().size()));
        return true;
    }
}
