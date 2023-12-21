package com.example.demo.service.mybatis;

import com.example.demo.mapper.JobRootMapper;
import com.example.demo.model.jobs.JobRootItem;
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

    @Override
    public JobRootItem getCode(String code) {
        return _rootDao.findByColumn(code);
        //return null;
    }

    @Override
    public JobRootItem findByCode(JobRootItem model) {
        return _rootDao.getJobRoot(model);
    }
}
