package com.example.demo.service;

import com.example.demo.model.JobItem;
import com.example.demo.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class JobService implements IJobService {
    @Autowired
    JobRepository _jobDao;

    public List<JobItem> getAll() {
        return _jobDao.findAll();
    }
}
