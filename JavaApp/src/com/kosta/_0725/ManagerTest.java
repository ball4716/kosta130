package com.kosta._0725;

class Manager{
	private String name;
	private int salary;
	private String jobTitle;
	
	public Manager(String name, int salary, String jobTitle) {
		this.name = name;
		this.salary = salary;
		this.jobTitle = jobTitle;
	}
	
	public String getDetails(){
		return "사원명은 "+name+"이고 연봉은 "+salary+", 직업은 "+jobTitle;
	}

}

class EmployeeManager extends Manager{
	private String department;//부서
	
	public EmployeeManager(String name, int salary, String jobTitle, String department) {
		//System.out.println();
		super(name, salary, jobTitle);
		//생성자는 상속이 안되므로! 명시적으로 호출해서 상위 클래스 생성자를 호출
		//생성자 안에서 this() 또는 super()를 호출시에는 반드시 첫줄에 위치
		//따라서 this()와 super()는 함께 올 수 없다
		this.department = department;
	}
	
	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return super.getDetails()+", 부서명은 "+department;
	}
	
}

public class ManagerTest {

	public static void main(String[] args) {
		EmployeeManager em = new EmployeeManager("홍길동", 3000, "프로그래머", "제품개발부");
		
		System.out.println(em.getDetails());
	}

}
