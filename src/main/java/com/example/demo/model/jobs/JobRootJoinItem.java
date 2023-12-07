package com.example.demo.model.jobs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 대분류 item
 */
@Getter
@Setter
@Entity
@Table(name = "JOBS_ROOT")
public class JobRootJoinItem {

    @Id
    private String code;
    private String name;

    /**
     * 대분류에 포함된 중분류
      */
    @OneToMany(mappedBy = "root", fetch = FetchType.LAZY)
    private List<JobSub1JoinItem> sub1List;

    public JobRootJoinItem() {
        // 기본 생성자
    }
}
