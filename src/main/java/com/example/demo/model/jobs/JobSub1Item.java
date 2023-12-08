package com.example.demo.model.jobs;

import com.example.demo.model.jobs.table.JobsSub1;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "JOBS_SUB1")
@Entity
public class JobSub1Item extends JobsSub1 {
    public JobSub1Item() {
        super();
    }
    public JobSub1Item(String code, String rootCode, String name)
    {
        super(code, rootCode, name);
    }
}
