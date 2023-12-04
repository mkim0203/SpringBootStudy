package com.example.demo.common.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseResultModel {

	private ResultCode code;

	// java enum 출력시 문자열로 반환됨.
//	@Setter(AccessLevel.NONE)
//	private String code;
//
//	public String getCode() {
//		return resultCode.toString();
//	}

	//	public String getCode() {
//		return code;
//	}
//	public void setCode(String code) {
//		this.code = code;
//	}
	
}
