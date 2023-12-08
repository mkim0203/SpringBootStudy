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
public class JobsSub4 extends BaseJobItem {
    @Column(name = "sub3_code")
    private String sub3Code;
    public JobsSub4() {}
    public JobsSub4(String code, String sub3Code, String name) {
        super(code, name);
        this.sub3Code = sub3Code;
    }
}
