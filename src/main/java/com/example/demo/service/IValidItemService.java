package com.example.demo.service;

import com.example.demo.model.GroupInfo;
import com.example.demo.model.ValidateItem;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



@Validated
public interface IValidItemService {

    boolean checkUserId(@NotNull @Length(min = 6, max = 15) String userId);
    boolean checkAvg(@Min(value = 0) Integer avg);

    boolean checkItem(@NotNull @Valid ValidateItem item);

    boolean checkGroupInfo(@NotNull @Valid GroupInfo group);
}
