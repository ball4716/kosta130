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
		return "������� "+name+"�̰� ������ "+salary+", ������ "+jobTitle;
	}

}

class EmployeeManager extends Manager{
	private String department;//�μ�
	
	public EmployeeManager(String name, int salary, String jobTitle, String department) {
		//System.out.println();
		super(name, salary, jobTitle);
		//�����ڴ� ����� �ȵǹǷ�! ��������� ȣ���ؼ� ���� Ŭ���� �����ڸ� ȣ��
		//������ �ȿ��� this() �Ǵ� super()�� ȣ��ÿ��� �ݵ�� ù�ٿ� ��ġ
		//���� this()�� super()�� �Բ� �� �� ����
		this.department = department;
	}
	
	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return super.getDetails()+", �μ����� "+department;
	}
	
}

public class ManagerTest {

	public static void main(String[] args) {
		EmployeeManager em = new EmployeeManager("ȫ�浿", 3000, "���α׷���", "��ǰ���ߺ�");
		
		System.out.println(em.getDetails());
	}

}
