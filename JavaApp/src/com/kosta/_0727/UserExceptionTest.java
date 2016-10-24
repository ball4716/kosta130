package com.kosta._0727;


class MyException1 extends Exception {
	
	public MyException1(String msg) {
		super(msg);
	}
}

class MyException2 extends Exception {
	
	public MyException2(String msg) {
		super(msg);
	}
}

public class UserExceptionTest {//사용자 정의 예외클래스
	public static void main(String[] args) {
		int su=3;
		
			try {
				if(su%2==0)
					throw new MyException1("사용자 짝수 예외");
				else
					throw new MyException2("사용자 홀수 예외");
			} catch (MyException1 e) {
				e.printStackTrace();
			} catch (MyException2 e) {
				e.printStackTrace();
			}
		
	}
}
