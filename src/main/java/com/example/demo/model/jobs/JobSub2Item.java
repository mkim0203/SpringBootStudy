package com.example.demo.model.jobs;

import com.example.demo.model.jobs.table.BaseJobItem;
import com.example.demo.model.jobs.table.JobsSub2;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name = "JOBS_SUB2")
@Entity
public class JobSub2Item extends JobsSub2 {
    
    public JobSub2Item() {
        super();
    }
    
    public JobSub2Item(String code, String sub1Code, String name) {
        super(code, sub1Code, name);
    
    }
}
