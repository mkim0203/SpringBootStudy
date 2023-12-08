package com.example.demo.model.jobs.table;

import com.example.demo.model.jobs.table.BaseJobItem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Jobs_Sub1 테이블 구조
 */
@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public class JobsSub1 extends BaseJobItem {
    // column 설정안하면 JobSub1JoinItem join 컬럼과 출돌이남 -_-
    @Column(name = "root_code")
    private String rootCode;
    public JobsSub1() {
        super();
    }
    public JobsSub1(String code, String rootCode, String name)
    {
        super(code, name);
        this.rootCode = rootCode;
    }
}
