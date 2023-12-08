package com.example.demo.common.model.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * yaml 프로퍼티 설정 테스트
 */
@Component
@ConfigurationProperties("appsetting")
@Data
public class AppSetting {
	private String projectName;
	private String aaaa;
	private ModelData modelData;

	// Setter Getter로 생략하기
//	public String getProjectName() {
//		return projectName;
//	}
//	public void setProjectName(String projectName) {
//		this.projectName = projectName;
//	}
//	public String getAaaa() {
//		return aaaa;
//	}
//	public void setAaaa(String aaaa) {
//		this.aaaa = aaaa;
//	}
//	public ModelData getModelData() {
//		return modelData;
//	}
//	public void setModelData(ModelData modelData) {
//		this.modelData = modelData;
//	}
	
}
