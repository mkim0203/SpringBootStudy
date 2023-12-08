package com.example.demo.model.jobs.table;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class JobsRoot extends BaseJobItem {
    public JobsRoot() {}
    public JobsRoot(String code, String name) {
        super(code, name);
    }
}
