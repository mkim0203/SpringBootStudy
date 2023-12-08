package com.example.demo.model.jobs;

import com.example.demo.model.jobs.table.BaseJobItem;
import com.example.demo.model.jobs.table.JobsSub4;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name = "JOBS_SUB4")
@Entity
public class JobSub4Item extends JobsSub4 {

    public JobSub4Item() {
        super();
    }
    public JobSub4Item(String code, String sub3Code, String name) {
        super(code, sub3Code, name);
    }
}
