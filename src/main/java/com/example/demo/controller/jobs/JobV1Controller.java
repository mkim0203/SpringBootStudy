package com.example.demo.controller.jobs;

import com.example.demo.common.model.ResultCode;
import com.example.demo.common.model.ResultModel;
import com.example.demo.model.JobItem;
import com.example.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/jobs")
public class JobV1Controller {
    @Autowired
    JobService _service;

    @GetMapping("/")
    public ResultModel<List<JobItem>> searchAll() {
        ResultModel<List<JobItem>> retValue = new ResultModel<>();
        retValue.setData(_service.getAll());
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }
}
