package com.example.demo.model.jobs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "JOBS_SUB2")
@Entity
public class JobSub2Item extends  BaseJobItem {
    @Column(name = "sub1_code")
    private String job1Code;

    public JobSub2Item() {
        super();
    }

    public JobSub2Item(String code, String job1Code, String name) {
        super(code, name);
        this.job1Code = job1Code;
    }
}
