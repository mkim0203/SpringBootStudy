package com.example.demo.model.jobs;

import com.example.demo.model.jobs.table.JobsRoot;

import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name = "JOBS_ROOT")
@Entity
public class JobRootItem extends JobsRoot {
    public JobRootItem() {
        super();
    }
    public JobRootItem(String code, String name) {
        super(code, name);
    }
}
