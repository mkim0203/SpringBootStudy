package com.example.demo.model.jobs;

import com.example.demo.model.jobs.table.JobsSub1;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 중분류 item
 */
@Getter
@Setter
@Entity
@Table(name = "JOBS_SUB1")
public class JobSub1JoinItem extends JobsSub1 {
    /**
     * 대분류 item. data 양방향 처리 
     * rest api로 데이터 전달시 순함 참조 안되도록 ignore 추가 
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "root_code", insertable = false, updatable = false)
    private JobRootJoinItem  root;

    /**
     * 중분류에 포함된 소분류 목록
     */
    @OneToMany(mappedBy = "sub1", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<JobSub2JoinItem> sub2List;

    public JobSub1JoinItem() {
        // 기본 생성자
    }
}
