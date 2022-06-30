package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Works")
public class Work {
	@Column(name = "WORK_NAME")
	private String workName;
	
	@Id
 	@Column(name = "WORK_NUMBER")
	private int workNumber;

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public int getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(int workNumber) {
		this.workNumber = workNumber;
	}

	@Override
	public String toString() {
		return "Works [workName=" + workName + ", workNumber=" + workNumber + "]";
	}
			
}
