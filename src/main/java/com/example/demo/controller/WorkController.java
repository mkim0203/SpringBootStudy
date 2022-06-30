package com.example.demo.controller;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.aop.RunningLog;
import com.example.demo.common.model.BaseResultModel;
import com.example.demo.common.model.ResultModel;
import com.example.demo.model.Work;
import com.example.demo.service.WorkService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class WorkController {

	@Autowired
	WorkService workService;
	
//	/**
//	 * 조회
//	 * @return
//	 */
//	@ApiOperation(value="조회", notes="작업 목록 조회")
//	@GetMapping("/works")
//	@RunningLog
//	public ResponseEntity<BaseResultModel> getAll() {
//		ResultModel<List<Work>> retValue = new ResultModel<List<Work>>();
//		List<Work> data = workService.getAll();
//		if(data != null && data.size() > 0) {
//			System.out.println(data.size());
//			retValue.setData(data);
//			retValue.setCode("SUCCES");
//			
//			return new ResponseEntity<BaseResultModel>(retValue, HttpStatus.OK);
//			
//			
//		} else 
//			return new ResponseEntity<BaseResultModel>(HttpStatus.NOT_FOUND);
//	}
	
	@GetMapping("/works")
	public ResponseEntity<BaseResultModel> GetList(@RequestParam(required = false) String workName) throws Exception {
		ResultModel<List<Work>> retValue = new ResultModel<List<Work>>();
		List<Work> data = workService.getList(workName);
		if(data != null && data.size() > 0) {
			System.out.println(data.size());
			retValue.setData(data);
			retValue.setCode("SUCCES");
			
			return new ResponseEntity<BaseResultModel>(retValue, HttpStatus.OK);
		} else 
			return new ResponseEntity<BaseResultModel>(HttpStatus.NOT_FOUND);

	}
	
	@GetMapping("/works/{workNumber}")
	public ResponseEntity<Work> get(@PathVariable int workNumber) throws Exception  {
		System.out.println(workNumber);
		Work data;
//		try {
			data = workService.get(workNumber);
			if(data != null) {		
				System.out.println(data);
				return new ResponseEntity<Work>(data, HttpStatus.OK);
			}
			else {
				System.out.println("test3");
				//return new ResponseEntity<Work>(HttpStatus.NOT_FOUND);
				throw new NotFoundException();
			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//			
//			return new ResponseEntity<Work>(HttpStatus.BAD_REQUEST);
//		}

		
	}
	
	@PostMapping("/works")
	public ResponseEntity<String> Add(@RequestBody Work model) throws Exception {
		System.out.println(model);
		if(model !=null) {
			try {
				workService.insert(model);
			} catch (Exception e) {
				System.out.println(e);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			}
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("");
	}
	
	@PutMapping("/works/{workNumber}")
	public ResponseEntity<String> Update(@PathVariable int workNumber, @RequestBody Work model) throws Exception {
		System.out.println(workNumber);
		if(model != null && model.getWorkNumber() != workNumber) {
			model.setWorkNumber(workNumber);
		} 
		workService.update(model);
		return ResponseEntity.ok("변경을 완료했습니다.");
		
//		try {
//			workService.update(model);
//		} catch (NotFoundException e) {
//			// TODO Auto-generated catch block
//			throw e;
//			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//		}
		
		
	}
	
	@DeleteMapping("/works/{workNumber}")
	public ResponseEntity<String> Delete(@PathVariable int workNumber) throws Exception {
//		try {
//			workService.delete(workNumber);
//		} catch (NotFoundException e){
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//		}
		workService.delete(workNumber);
		return ResponseEntity.ok("삭제를 완료했습니다.");
	}
}
