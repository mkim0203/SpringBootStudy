package com.example.demo.service;

import java.util.List;

import com.example.demo.model.DataNotFoundException;
import com.example.demo.model.Work;

public interface IWorkService {
	public List<Work> getAll();
	public List<Work> getList(String workNameLike);
	public Work get(int workNumber);
	public void insert(Work model) throws Exception;
	public void update(Work model) throws DataNotFoundException;
	public void delete(int workNumber) throws DataNotFoundException;
	
}
