package com.example.demo.service;

import com.example.demo.model.jobs.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
public interface IJobService {
    List<JobRootItem> getJobRootAll();
    List<JobSub1Item> getJobSub1All();
    List<JobSub2Item> getJobSub2All();
    List<JobSub3Item> getJobSub3All();
    List<JobSub4Item> getJobSub4All();

    List<JobRootJoinItem> getJobRootJoinAll();

    Optional<JobRootJoinItem> getJobRootJoinAByRootId(String rootCode);

    Boolean deleteSub2ById(String code);

    List<JobRootJoinItem> searchSub1NameLike(String keyword);
    List<JobRootJoinItem> searchSub1NameLikeOrName2Like(String keyword, String keyword2);
    List<JobRootJoinItem> searchSub1CodeIn(List<String> codes);

    List<JobRootJoinItem> searchSub1CodeQuery(String code);


    Optional<JobR1joinItem> searchSubCode(String code);

    Boolean save(JobRootJoinItem row);

    Boolean saveSub3(JobSub3Item row);
}
