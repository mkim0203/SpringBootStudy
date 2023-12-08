package com.example.demo.model.jobs;

import com.example.demo.model.jobs.table.JobsSub2;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "JOBS_SUB2")
public class JobSub2JoinItem extends JobsSub2 {
    /**
     * 중분류 item. data 양방향 처리
     * rest api로 데이터 전달시 순함 참조 안되도록 ignore 추가
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub1_code", insertable = false, updatable = false)
    private JobSub1JoinItem sub1;

    @OneToMany(mappedBy = "sub2", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<JobSub3JoinItem> sub3List;
}
