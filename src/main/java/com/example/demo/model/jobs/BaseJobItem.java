package com.example.demo.model.jobs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@Setter
@Getter
@MappedSuperclass
public class BaseJobItem {
    // 상속용 클래스 이면 MappedSuperclass 필요함...

    @Id
    private String code;
    private String name;

    public BaseJobItem() {}
    public BaseJobItem(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
