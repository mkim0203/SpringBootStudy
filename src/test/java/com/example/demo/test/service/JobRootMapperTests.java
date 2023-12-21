package com.example.demo.test.service;

import com.example.demo.mapper.JobRootMapper;
import com.example.demo.model.jobs.JobRootItem;
import com.example.demo.service.mybatis.JobMybatisService;
import com.example.demo.test.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
public class JobRootMapperTests extends BaseTest {
    @Autowired
    JobMybatisService _service;

    @Test
    public void Test1() {
        writeLog(_service.getTest());
    }

    @Test
    public void getCode() {
        writeLog(_service.getCode("X"));
    }

    @Test
    public void getRootCode() {
        JobRootItem model = new JobRootItem();
        model.setCode("W");
        writeLog(_service.findByCode(model));
    }
}
