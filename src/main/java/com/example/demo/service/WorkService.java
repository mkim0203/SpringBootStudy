package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.model.DataNotFoundException;
import com.example.demo.model.Work;
import com.example.demo.repository.WorkRepository;

@Service
@Validated
public class WorkService implements IWorkService {

	@Autowired
	WorkRepository workDao;

	@Override
	public List<Work> getAll() {
		return workDao.findAll();
	}

	@Override
	public List<Work> getList(String workNameLike) {
		if (StringUtils.isEmpty(workNameLike) || StringUtils.isBlank(workNameLike)) {
			return getAll();
		} else {
			String searchString = "%" + workNameLike + "%";
			return workDao.findByWorkNameLike(searchString);
		}
	}

	@Override
	public Work get(int workNumber) {
		System.out.println("workService get =>" + workNumber);
		// Work data = null;

		try {
			// Work data = workDao.getReferenceById(workNumber);
			// Work data = workDao.findById(workNumber);
//			System.out.println("check point 1");
//			System.out.println("data : "+data);

			Work data = workDao.findByWorkNumber(workNumber);

			return data;
		} catch (javax.persistence.EntityNotFoundException ex) {
			System.out.println("NOT FOUND");
			return null;
		} catch (Exception e) {
			System.out.println("Test");
			System.out.println(e.getMessage());
			return null;
		}
		// return data;
	}

	@Override
	public void insert(Work model) throws Exception {
		if (workDao.existsById(model.getWorkNumber()) == true) {
			throw new Exception("이미 있는 항목 work");
		} else {
			workDao.save(model);
		}
	}

	@Override
	public void update(Work model) throws DataNotFoundException {
		if (workDao.existsById(model.getWorkNumber()) == true) {
			workDao.save(model);
		} else {
			System.out.println("not found work number" + model.getWorkNumber());
			throw new DataNotFoundException(model.getWorkNumber());
		}
	}

	@Override
	public void delete(int workNumber) throws DataNotFoundException {
		if (workDao.existsById(workNumber) == true) {
			workDao.deleteById(workNumber);
		} else {
			throw new DataNotFoundException(workNumber);
		}
	}

	@Override
	public void test(Work model) {
		// TODO Auto-generated method stub
		System.out.println("test");
	}


}
