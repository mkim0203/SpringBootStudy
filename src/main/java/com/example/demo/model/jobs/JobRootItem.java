package com.example.demo.model.jobs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "JOBS_ROOT")
@Entity
public class JobRootItem extends BaseJobItem {
    public JobRootItem() {
        super();
    }
    public JobRootItem(String code, String name) {
        super(code, name);
    }
}
