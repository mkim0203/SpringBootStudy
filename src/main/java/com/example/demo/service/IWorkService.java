package com.example.demo.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.example.demo.model.DataNotFoundException;
import com.example.demo.model.Work;


@Validated
public interface IWorkService {
	public List<Work> getAll();

	public List<Work> getList(String workNameLike);

	public Work get(int workNumber);

	public void insert(@NotNull Work model) throws Exception;

	public void update(@NotNull Work model) throws DataNotFoundException;

	public void delete(int workNumber) throws DataNotFoundException;
	
	public void test(@NotNull Work model);
}
