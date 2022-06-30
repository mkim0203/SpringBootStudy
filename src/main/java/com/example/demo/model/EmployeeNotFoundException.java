package com.example.demo.model;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}
