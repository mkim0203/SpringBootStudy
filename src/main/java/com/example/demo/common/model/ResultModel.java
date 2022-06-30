package com.example.demo.common.model;

public class ResultModel<T> extends BaseResultModel {
	private T data;

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
