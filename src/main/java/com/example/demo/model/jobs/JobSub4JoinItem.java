package com.example.demo.model.jobs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "JOBS_SUB4")
public class JobSub4JoinItem {
    @Id
    private String code;
    private String name;

    /**
     * 세분류 item. data 양방향 처리
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub3_code")
    private JobSub3JoinItem sub3;
}
