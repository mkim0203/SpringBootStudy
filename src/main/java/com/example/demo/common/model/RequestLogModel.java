package com.example.demo.common.model;

public class RequestLogModel {
	private String ControllerName;
	private String MethodName;
	private String Url;
	private String HttpMethodType;

	public RequestLogModel() {
	}

	public RequestLogModel(String controllerName, String methodName, String url, String httpMethodType) {
		ControllerName = controllerName;
		MethodName = methodName;
		Url = url;
		HttpMethodType = httpMethodType;
	}

	public String getControllerName() {
		return ControllerName;
	}

	public void setControllerName(String controllerName) {
		ControllerName = controllerName;
	}

	public String getMethodName() {
		return MethodName;
	}

	public void setMethodName(String methodName) {
		MethodName = methodName;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getHttpMethodType() {
		return HttpMethodType;
	}

	public void setHttpMethodType(String httpMethodType) {
		HttpMethodType = httpMethodType;
	}

	@Override
	public String toString() {
		return "RequestLogModel [" + ControllerName + "::" + MethodName + "(), Url=" + Url + ", HttpMethodType="
				+ HttpMethodType + "]";
	}

}
