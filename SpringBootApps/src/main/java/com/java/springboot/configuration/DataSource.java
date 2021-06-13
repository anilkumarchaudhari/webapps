package com.java.springboot.configuration;

public class DataSource {

	private String serverurl;
	private Integer port;
	
	public DataSource(String serverurl, Integer port) {
		this.serverurl = serverurl;
		this.port = port;
	}
	public String getServerurl() {
		return serverurl;
	}
	public void setServerurl(String serverurl) {
		this.serverurl = serverurl;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	@Override
	public String toString() {
		return String.format("DataSource [serverurl=%s, port=%s]", serverurl, port);
	}
	
}
