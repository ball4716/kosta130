package com.kosta._0829;

public class Person {
    private String name;
    private String job;
    private String email;
    
	public Person(String name, String job, String email) {
		this.name = name;
		this.job = job;
		this.email = email;
	}
    
	@Override
	public String toString() {
		return "[�̸�:"+name+", ����:"+job+", �̸���:"+email+"]";
	}
    
}
