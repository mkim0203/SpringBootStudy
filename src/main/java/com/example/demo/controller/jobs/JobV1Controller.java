package com.example.demo.controller.jobs;

import com.example.demo.common.model.ResultCode;
import com.example.demo.common.model.ResultModel;
import com.example.demo.model.JobItem;
import com.example.demo.model.jobs.*;
import com.example.demo.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1/jobs")
public class JobV1Controller {
    @Autowired
    JobService _service;

    @GetMapping("/root")
    public ResultModel<List<JobRootItem>> searchRootAll() {
        ResultModel<List<JobRootItem>> retValue = new ResultModel<>();
        retValue.setData(_service.getJobRootAll());
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }

    @GetMapping("/sub1")
    public ResultModel<List<JobSub1Item>> searchSub1All() {
        ResultModel<List<JobSub1Item>> retValue = new ResultModel<>();
        retValue.setData(_service.getJobSub1All());
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }
    @GetMapping("/sub2")
    public ResultModel<List<JobSub2Item>> searchSub2All() {
        ResultModel<List<JobSub2Item>> retValue = new ResultModel<>();
        retValue.setData(_service.getJobSub2All());
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }
    @GetMapping("/sub3")
    public ResultModel<List<JobSub3Item>> searchSub3All() {
        ResultModel<List<JobSub3Item>> retValue = new ResultModel<>();
        retValue.setData(_service.getJobSub3All());
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }
    @GetMapping("/sub4")
    public ResultModel<List<JobSub4Item>> searchSub4All() {
        ResultModel<List<JobSub4Item>> retValue = new ResultModel<>();
        retValue.setData(_service.getJobSub4All());
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }

    @GetMapping("/roots/sub1s")
    public ResultModel<List<JobRootJoinItem>> searchRootSub1All() {
        ResultModel<List<JobRootJoinItem>> retValue = new ResultModel<>();
        retValue.setData(_service.getJobRootJoinAll());
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }

    @GetMapping("/roots/sub1s/{name}")
    public ResultModel<List<JobRootJoinItem>> searchSub1NameLike(@PathVariable String name) {
        ResultModel<List<JobRootJoinItem>> retValue = new ResultModel<>();
        retValue.setData(_service.searchSub1NameLike(name));
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }

    @GetMapping("/roots/sub1s/names")
    public ResultModel<List<JobRootJoinItem>> searchSub1NamesLike(@RequestParam String[] names) {
        ResultModel<List<JobRootJoinItem>> retValue = new ResultModel<>();
        retValue.setData(_service.searchSub1NameLikeOrName2Like(names[0], names[1]));
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }

    @GetMapping("/roots/sub1s/codes")
    public ResultModel<List<JobRootJoinItem>> searchSub1CodesIn(@RequestParam List<String> codes) {
        log.debug(String.join(",", codes));
        ResultModel<List<JobRootJoinItem>> retValue = new ResultModel<>();
        retValue.setData(_service.searchSub1CodeIn(codes));
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }

    @GetMapping("/roots/sub1s/codes2")
    public ResultModel<List<JobRootJoinItem>> searchSub1Code2(@RequestParam String code) {
        ResultModel<List<JobRootJoinItem>> retValue = new ResultModel<>();
        retValue.setData(_service.searchSub1CodeQuery(code));
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }

    @GetMapping("/roots/sub1s/{sub1-code}}")
    public ResultModel<Optional<JobR1joinItem>> searchR1Sub1Code(@PathVariable(name = "sub1-code") String code) {
        ResultModel<Optional<JobR1joinItem>> retValue = new ResultModel<>();
        retValue.setData(_service.searchSubCode(code));
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }

    @PostMapping("/roots")
    public ResultModel<Boolean> searchR1Sub1Code(@RequestBody JobRootJoinItem data) {
        ResultModel<Boolean> retValue = new ResultModel<>();
        retValue.setData(_service.save(data));
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }

    @PostMapping("/sub3")
    public ResultModel<Boolean> searchR1Sub1Code(@RequestBody JobSub3Item data) {
        ResultModel<Boolean> retValue = new ResultModel<>();
        retValue.setData(_service.saveSub3(data));
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }


    @GetMapping("/roots/{root-code}")
    public ResultModel<Optional<JobRootJoinItem>> searchRootSub1All(@PathVariable(name = "root-code") String rootCode) {
        ResultModel<Optional<JobRootJoinItem>> retValue = new ResultModel<>();
        retValue.setData(_service.getJobRootJoinAByRootId(rootCode));
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }

    @DeleteMapping("/sub2/{code}")
    public ResultModel<Boolean> deleteSub2ById(@PathVariable String code) {
        ResultModel<Boolean> retValue = new ResultModel<>();
        retValue.setData(_service.deleteSub2ById(code));
        retValue.setCode(ResultCode.SUCCESS);

        return retValue;
    }

}
