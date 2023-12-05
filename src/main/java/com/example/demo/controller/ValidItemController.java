package com.example.demo.controller;

import com.example.demo.model.GroupInfo;
import com.example.demo.model.ValidateItem;
import com.example.demo.service.IValidItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/valid")
public class ValidItemController {
    @Autowired
    IValidItemService _validService;
    @GetMapping("/user")
    public boolean checkUserId(String userId) {
        return _validService.checkUserId(userId);
    }

    @GetMapping("/avg")
    public boolean checkAvg(Integer avg) {
        return _validService.checkAvg(avg);
    }

    @PostMapping("/model")
    public boolean checkModel(@RequestBody ValidateItem item) {
        return _validService.checkItem(item);
    }

    @PostMapping("/group")
    public boolean checkGroup(@RequestBody GroupInfo info) { return _validService.checkGroupInfo(info); }
}
