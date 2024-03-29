package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Work;

public interface WorkRepository  extends JpaRepository<Work, Integer> {
	public Work findByWorkNumber(int workNumber);
	public List<Work> findByWorkNameLike(String likeWorkName);
	// 여러개 할려면 findByWorkNumberAndWorkName
}
