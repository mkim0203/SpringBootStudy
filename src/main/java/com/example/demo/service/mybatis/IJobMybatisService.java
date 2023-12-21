package com.example.demo.service.mybatis;

import com.example.demo.model.jobs.JobRootItem;
import org.springframework.validation.annotation.Validated;

@Validated
public interface IJobMybatisService {
    String getTest();

    JobRootItem getCode(String code);
    JobRootItem findByCode(JobRootItem model);
}
