package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "JOBS")
@Entity
public class JobItem {
    @Id
    private String code;
    private String name;

    public JobItem() {}

    public JobItem(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "JobItem{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
