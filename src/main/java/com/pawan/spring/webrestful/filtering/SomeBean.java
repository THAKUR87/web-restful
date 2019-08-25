package com.pawan.spring.webrestful.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SomeBean {
	
	private String fileld1;
	private String fileld2;
	@JsonIgnore
	private String fileld3;
	
	
	public SomeBean(String fileld1, String fileld2, String fileld3) {
		super();
		this.fileld1 = fileld1;
		this.fileld2 = fileld2;
		this.fileld3 = fileld3;
	}

	public String getFileld1() {
		return fileld1;
	}
	
	public void setFileld1(String fileld1) {
		this.fileld1 = fileld1;
	}
	
	public String getFileld2() {
		return fileld2;
	}
	
	public void setFileld2(String fileld2) {
		this.fileld2 = fileld2;
	}
	
	public String getFileld3() {
		return fileld3;
	}
	
	public void setFileld3(String fileld3) {
		this.fileld3 = fileld3;
	}
	
	

}
