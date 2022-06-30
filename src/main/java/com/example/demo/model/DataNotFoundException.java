package com.example.demo.model;

public class DataNotFoundException extends RuntimeException {

	public DataNotFoundException(Object id) {
		super("항목을 찾을수 없습니다. [" + (id == null ? "[null data]" : id)  + "]");
	}
}
