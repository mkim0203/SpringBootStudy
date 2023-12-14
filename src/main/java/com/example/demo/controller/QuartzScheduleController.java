package com.example.demo.controller;

import com.example.demo.common.model.ResultCode;
import com.example.demo.common.model.ResultModel;
import com.example.demo.model.QzJobStatus;
import com.example.demo.model.qz.ChangeJobCrontab;
import com.example.demo.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Valid
@RestController
@RequestMapping("/qz-schedule")
public class QuartzScheduleController {
    @Autowired
    QuartzService _qzService;

    @GetMapping("/")
    public ResultModel<List<QzJobStatus>> searchQzJobs() {
        ResultModel<List<QzJobStatus>> retValue = new ResultModel<>();
        retValue.setData( _qzService.getAllJobs());
        retValue.setCode(ResultCode.OK);
        return retValue;
    }

    @DeleteMapping("/{name}")
    public ResultModel<Boolean> stopQzJob(@PathVariable String name) {
        ResultModel<Boolean> retValue = new ResultModel<>();
        Boolean result = _qzService.removeJob(name);
        retValue.setData(result);
        return retValue;
    }

    @GetMapping("/running")
    public ResultModel<Boolean> isRunning() {
        ResultModel<Boolean> retValue = new ResultModel<>();
        Boolean result = _qzService.IsRunning();
        retValue.setData(result);
        retValue.setCode(ResultCode.OK);
        return retValue;
    }

    @GetMapping("/is-crontab/{data}")
    public ResultModel<Boolean> isCrontab(@PathVariable String data) {
        ResultModel<Boolean> retValue = new ResultModel<>();
        retValue.setData(_qzService.isCrontab(data));
        retValue.setCode(ResultCode.OK);
        return retValue;
    }

    @PutMapping("/jobs/{job-name}/crontab")
    public ResultModel<Boolean> updateCrontab(@PathVariable(name = "job-name") String jobName, @RequestBody ChangeJobCrontab requestModel) {
        ResultModel<Boolean> retValue = new ResultModel<>();
        Boolean success = _qzService.updateJobCrontab(jobName, requestModel.getCrontab());
        retValue.setData(success);
        retValue.setCode(success ? ResultCode.SUCCESS : ResultCode.FAIL);
        return retValue;
    }
}
