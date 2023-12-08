package com.example.demo.model.jobs.table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public class JobsSub2 extends BaseJobItem {
    @Column(name = "sub1_code")
    private String sub1Code;
    public JobsSub2() {}
    public JobsSub2(String code, String sub1Code, String name) {
        super(code, name);
        this.sub1Code = sub1Code;
    }
}
