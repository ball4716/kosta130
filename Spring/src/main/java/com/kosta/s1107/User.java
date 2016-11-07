package com.kosta.s1107;

public class User {
	private String id;
	private String pass;
	private String name;
	private String location;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String id, String pass, String name, String location) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}