package com.example.demo.model.jobs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "JOBS_SUB4")
@Entity
public class JobSub4Item extends BaseJobItem {
    @Column(name = "sub3_code")
    private String job3Code;
    public JobSub4Item() {
        super();
    }
    public JobSub4Item(String code, String sub3Code, String name) {
        super(code, name);
        this.job3Code = sub3Code;
    }
}
