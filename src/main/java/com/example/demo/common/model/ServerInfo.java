package com.example.demo.common.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ServerInfo {
	private String ip;
	private String hostName;
	private String description;

//	public String getIp() {
//		return ip;
//	}
//
//	public void setIp(String ip) {
//		this.ip = ip;
//	}
//
//	public String getHostName() {
//		return hostName;
//	}
//
//	public void setHostName(String hostName) {
//		this.hostName = hostName;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}

	@Override
	public String toString() {
		return "ServerInfo [Ip=" + ip + ", HostName=" + hostName + ", Description=" + description + "]";
	}
}
