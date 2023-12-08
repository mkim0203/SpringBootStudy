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
public class JobsSub3 extends BaseJobItem {
    @Column(name = "sub2_code")
    private String sub2Code;
    public JobsSub3() {}
    public JobsSub3(String code, String sub2Code, String name) {
        super(code, name);
        this.sub2Code = sub2Code;
    }
}
