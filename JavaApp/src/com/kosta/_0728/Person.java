package com.kosta._0728;

public class Person {
/*
 JavaBeans(�ڹٺ���) : ���� ���� �ִ� �Ӽ����� �ϳ��� Ŭ���� �̸����� ����
 ---> �Ǵٸ� �̸�: VO, DTO
 
 ��Ģ)
  - �Ӽ����� private ���
  - ����� �����Ҽ� �ִ� public�� ���͸޼ҵ�(get���� �����ϴ�),
        ���͸޼ҵ�(set���� �����ϴ�) ����.
  - public �����ڸ� ����.
 */
	private String name;
	private int age;
	private String job;
	
	public Person() {
		
	}//�⺻������

	public Person(String name, int age, String job) {
		this.name = name;
		this.age = age;
		this.job = job;
	}//�����ε� ������
	
	@Override
		public String toString() {
			return "["+name+","+age+","+job+"]";
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
