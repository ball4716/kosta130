package com.kosta._0831.model;

public class PersonDTO {
	//�Ǵٸ� �̸�: PersonBean PersonVO(Value Object) DTO(Date Transfer Object)
	//DB�����ؼ� �ϴ� �� ------> ���̺��� ���ڵ� �ϳ��� ��ü�� ǥ��!!
	
	private int no;
	private String name;
	private int age;
	private String job;
	
	public PersonDTO() {
	}

	public PersonDTO(int no, String name, int age, String job) {
		this.no = no;
		this.name = name;
		this.age = age;
		this.job = job;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
