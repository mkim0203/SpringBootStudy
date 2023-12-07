package com.example.demo.repository;

import com.example.demo.model.jobs.JobRootItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRootRepository extends JpaRepository<JobRootItem, String> {
}
