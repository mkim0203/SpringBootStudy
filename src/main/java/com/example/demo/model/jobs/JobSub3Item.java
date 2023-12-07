package com.example.demo.model.jobs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "JOBS_SUB3")
@Entity
public class JobSub3Item extends BaseJobItem {
    @Column(name = "sub2_code")
    private String job2Code;
    public JobSub3Item() {
        super();
    }
    public JobSub3Item(String code, String job2Code, String name) {
        super(code, name);
        this.job2Code = job2Code;
    }
}
