package com.example.demo.model.jobs;

import com.example.demo.model.jobs.table.JobsSub1;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "JOBS_SUB1")
@Entity
public class JobR1joinItem extends JobsSub1 {


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code", insertable = false, updatable = false)
    private JobRootItem  root;

}
