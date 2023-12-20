package com.example.demo.service.mybatis;

import com.example.demo.mapper.JobRootMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobMybatisService implements IJobMybatisService {
    @Autowired
    JobRootMapper _rootDao;
    @Override
    public String getTest() {
        return _rootDao.selectTest();
    }
}
