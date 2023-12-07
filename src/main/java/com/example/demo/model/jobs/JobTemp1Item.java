package com.example.demo.model.jobs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
public class JobTemp1Item {
    private String rootCode;
    @Id
    private String subCode;
    private String rootName;
    private String subName;

    public JobTemp1Item(String rootCode, String rootName, String subCode, String subName) {
        this.rootCode = rootCode;
        this.rootName = rootName;
        this.subCode = subCode;
        this.subName = subName;
    }

    @Override
    public String toString() {
        return "JobTemp1Item{" +
                "rootCode='" + rootCode + '\'' +
                ", subCode='" + subCode + '\'' +
                ", rootName='" + rootName + '\'' +
                ", subName='" + subName + '\'' +
                '}';
    }
}
