package com.example.demo.repository;

import com.example.demo.model.jobs.JobR1joinItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobR1JoinPepository extends JpaRepository<JobR1joinItem, String> {

}
