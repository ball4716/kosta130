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
		return "[이름:"+name+", 직업:"+job+", 이메일:"+email+"]";
	}
    
}
