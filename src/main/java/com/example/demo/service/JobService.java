package com.example.demo.service;

import com.example.demo.model.jobs.*;
import com.example.demo.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class JobService implements IJobService {

    @Autowired
    JobRootRepository _jobRootDao;
    @Autowired
    JobSub1Repository _jobSub1Dao;
    @Autowired
    JobSub2Repository _jobSub2Dao;
    @Autowired
    JobSub3Repository _jobSub3Dao;
    @Autowired
    JobSub4Repository _jobSub4Dao;
    @Autowired
    JobRootJoinRepository _jobRootJoinDao;

    public List<JobRootItem> getJobRootAll() {
        return _jobRootDao.findAll();
    }

    @Override
    public List<JobSub1Item> getJobSub1All() {
        return _jobSub1Dao.findAll();
    }

    @Override
    public List<JobSub2Item> getJobSub2All() {
        return _jobSub2Dao.findAll();
    }

    @Override
    public List<JobSub3Item> getJobSub3All() {
        return _jobSub3Dao.findAll();
    }

    @Override
    public List<JobSub4Item> getJobSub4All() {
        return _jobSub4Dao.findAll();
    }

    @Override
    public List<JobRootJoinItem> getJobRootJoinAll() {
        return _jobRootJoinDao.findAll();
    }

    @Override
    public List<JobRootJoinItem> searchSub1NameLike(String keyword) {
        return _jobRootJoinDao.findBySub1List_NameContaining(keyword);
    }

    @Override
    public List<JobRootJoinItem> searchSub1NameLikeOrName2Like(String keyword, String keyword2) {
        return _jobRootJoinDao.findBySub1List_NameContainingOrSub1List_NameContaining(keyword, keyword2);
    }

    @Override
    public List<JobRootJoinItem> searchSub1CodeIn(List<String> codes) {
        return _jobRootJoinDao.findBySub1List_CodeIn(codes);
    }

    @Override
    public List<JobRootJoinItem> searchSub1CodeQuery(String code) {
        return _jobRootJoinDao.findBySub1Code(code);
    }

    @Override
    public List<JobTemp1Item> searchSub1CodeNativeQuery(String code) {
        List<JobTemp1Item> result = _jobRootJoinDao.findBySub1Code2(code);
        for (JobTemp1Item item : result) {
            System.out.println(item.toString());
        }

        return result;
    }
}
