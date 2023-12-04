package com.example.demo.common.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 프로퍼티 load 테스트..
 * @author mhkim
 *
 */
@Component
@Getter
@Setter
@ConfigurationProperties("config")
public class Settings {
	private String projectName;
	private String projectVersion;

	// ServerInfo 를 Setting inner class 로 구성하면 안됨
	private ServerInfo appServer;
	private ServerInfo dbServer;

//	public String getProjectName() {
//		return projectName;
//	}
//
//	public void setProjectName(String projectName) {
//		this.projectName = projectName;
//	}
//
//	public String getProjectVersion() {
//		return projectVersion;
//	}
//
//	public void setProjectVersion(String projectVersion) {
//		this.projectVersion = projectVersion;
//	}
//
//	public ServerInfo getAppServer() {
//		return appServer;
//	}
//
//	public void setAppServer(ServerInfo appServer) {
//		this.appServer = appServer;
//	}
//
//	public ServerInfo getDbServer() {
//		return dbServer;
//	}
//
//	public void setDbServer(ServerInfo dbServer) {
//		this.dbServer = dbServer;
//	}

	@Override
	public String toString() {
		return "Settings [projectName=" + projectName + ", projectVersion=" + projectVersion + ", appServer="
				+ appServer.toString() + ", dbServer=" + dbServer.toString() + "]";
	}
	
}
