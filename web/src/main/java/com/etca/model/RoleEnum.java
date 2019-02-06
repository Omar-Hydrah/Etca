package com.etca.model;

public enum RoleEnum{
	admin("admin"),
	user("user"),
	author("author");

	private String role;

	RoleEnum(String role){
		this.role = role;
	}

	public String getRole(){return this.role;}
}