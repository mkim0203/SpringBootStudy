package com.example.demo.service;

import com.example.demo.model.JobItem;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface IJobService {
    List<JobItem> getAll();
}
