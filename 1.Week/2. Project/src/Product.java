package com.yuantiao.test.web.vo;

public class Product {
	private String id;
	private String name;
	
	public Product(){
		super();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;		
	}
}