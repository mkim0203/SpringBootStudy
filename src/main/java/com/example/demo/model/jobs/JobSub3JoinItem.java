package com.example.demo.model.jobs;

import com.example.demo.model.jobs.table.JobsSub3;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "JOBS_SUB3")
public class JobSub3JoinItem extends JobsSub3 {

    /**
     * 소분류 item. data 양방향 처리
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub2_code", insertable = false, updatable = false)
    private JobSub2JoinItem sub2;


    @OneToMany(mappedBy = "sub3", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<JobSub4JoinItem> sub3List;
}
