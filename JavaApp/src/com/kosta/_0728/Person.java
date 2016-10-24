package com.kosta._0728;

public class Person {
/*
 JavaBeans(자바빈즈) : 서로 관련 있는 속성들을 하나의 클래스 이름으로 저장
 ---> 또다른 이름: VO, DTO
 
 규칙)
  - 속성들은 private 사용
  - 멤버를 접근할수 있는 public한 게터메소드(get으로 시작하는),
        세터메소드(set으로 시작하는) 정의.
  - public 생성자를 정의.
 */
	private String name;
	private int age;
	private String job;
	
	public Person() {
		
	}//기본생성자

	public Person(String name, int age, String job) {
		this.name = name;
		this.age = age;
		this.job = job;
	}//오버로딩 생성자
	
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
