package com.kosta._0725;

public class Car {
	String carName; //�ڵ����̸�
	int wheelNum;	//������
	int velocity;	//�ӵ�
	
	public Car(String carName, int wheelNum, int velocity) {
		this.carName = carName;
		this.wheelNum = wheelNum;
		this.velocity = velocity;
	}

	@Override
	public String toString(){
	//Ŭ������ ����(����ʵ���� ������ ��)�� ǥ���ϴ� �޼ҵ�
		return "�� ���� "+carName+"�̰� �ӵ��� "+velocity+", �������� "+wheelNum+"�Դϴ�.";
	}
	
	public boolean equals(Car c){
	//��ü����(Ŭ������ ���� �ʵ���� �� ����) ��
		if(carName.equals(c.carName) && wheelNum == c.wheelNum && velocity == c.velocity)
			// '==' ���ʿ� �⺻�ڷ����� ������ ���� ��
			// '==' ���ʿ� ���۷����� ���� �Ҵ�� �޸𸮸� ��(new�� �����ߴ��� ���� �ߴ���!)
			// equals�� ��ü�� ���� ��
			
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Car c1,c2;
		c1 = new Car("�ҳ�Ÿ", 4, 100);
		c2 = new Car("�ҳ�Ÿ", 4, 200);
		//c2 = c1;
		System.out.println(c2.toString());
		
		//�Ҵ�� �޸� ��
		if(c1 == c2){
			System.out.println("c1�� c2�� ���� ���۷���(�޸� ����!!)");
		}else{
			System.out.println("c1�� c2�� �ٸ� ���۷���(�޸� �ٸ�)");
		}
		
		//��ü ���� ��
		if(c1.equals(c2)){
			System.out.println("c1�� c2�� ��ü���배��!!");
		}else{
			System.out.println("c1�� c2�� ��ü����ٸ�!!");
		}
	}

}
