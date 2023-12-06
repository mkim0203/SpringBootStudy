package com.example.demo.repository;

import com.example.demo.model.JobItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface JobRepository extends JpaRepository<JobItem, String> {


}
