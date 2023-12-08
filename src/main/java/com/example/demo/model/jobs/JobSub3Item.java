package com.example.demo.model.jobs;

import com.example.demo.model.jobs.table.BaseJobItem;
import com.example.demo.model.jobs.table.JobsSub3;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name = "JOBS_SUB3")
@Entity
public class JobSub3Item extends JobsSub3 {

    public JobSub3Item() {
        super();
    }
    public JobSub3Item(String code, String sub2Code, String name) {
        super(code, sub2Code, name);
    }
}
