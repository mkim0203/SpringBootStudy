package com.example.demo.controller;

import com.example.demo.common.model.ResultModel;
import com.example.demo.model.QzJobStatus;
import com.example.demo.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qz-schedule")
public class QuartzScheduleController {
    @Autowired
    QuartzService _qzService;

    @GetMapping("/")
    public ResultModel<List<QzJobStatus>> searchQzJobs() {
        ResultModel<List<QzJobStatus>> retValue = new ResultModel<>();
        retValue.setData( _qzService.getAllJobs());
        return retValue;
    }

    @DeleteMapping("/{name}")
    public ResultModel<Boolean> stopQzJob(@PathVariable String name) {
        ResultModel<Boolean> retValue = new ResultModel<>();
        Boolean result = _qzService.removeJob(name);
        retValue.setData(result);
        return retValue;
    }
}
