package com.example.demo.model.jobs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "JOBS_SUB1")
@Entity
public class JobSub1Item extends BaseJobItem {
    // column 설정안하면 JobSub1JoinItem join 컬럼과 출돌이남 -_-
    @Column(name = "root_code")
    private String rootCode;
    public JobSub1Item() {
        super();
    }
    public JobSub1Item(String code, String rootCode, String name)
    {
        super(code, name);
        this.rootCode = rootCode;
    }
}
