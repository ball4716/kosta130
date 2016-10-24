package com.kosta._0725;

public class Car {
	String carName; //자동차이름
	int wheelNum;	//바퀴수
	int velocity;	//속도
	
	public Car(String carName, int wheelNum, int velocity) {
		this.carName = carName;
		this.wheelNum = wheelNum;
		this.velocity = velocity;
	}

	@Override
	public String toString(){
	//클래스의 상태(멤버필드들이 가지는 값)를 표현하는 메소드
		return "이 차는 "+carName+"이고 속도는 "+velocity+", 바퀴수는 "+wheelNum+"입니다.";
	}
	
	public boolean equals(Car c){
	//객체내용(클래스가 갖는 필드들의 값 각각) 비교
		if(carName.equals(c.carName) && wheelNum == c.wheelNum && velocity == c.velocity)
			// '==' 양쪽에 기본자료형이 있으면 값을 비교
			// '==' 양쪽에 레퍼런스가 오면 할당된 메모리를 비교(new를 따로했는지 같이 했는지!)
			// equals는 객체의 내용 비교
			
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Car c1,c2;
		c1 = new Car("소나타", 4, 100);
		c2 = new Car("소나타", 4, 200);
		//c2 = c1;
		System.out.println(c2.toString());
		
		//할당된 메모리 비교
		if(c1 == c2){
			System.out.println("c1과 c2는 같은 레퍼런스(메모리 같음!!)");
		}else{
			System.out.println("c1과 c2는 다른 레퍼런스(메모리 다름)");
		}
		
		//객체 내용 비교
		if(c1.equals(c2)){
			System.out.println("c1과 c2는 객체내용같음!!");
		}else{
			System.out.println("c1과 c2는 객체내용다름!!");
		}
	}

}
