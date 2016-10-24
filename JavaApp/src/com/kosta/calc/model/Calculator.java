package com.kosta.calc.model;

//가장 잘 만들어진 모델은 어떤 모델?
//어떤 뷰에서나 사용할 수 있는 클래스 모델
public class Calculator {
	private int su1;
	private int su2;
	private String oper;//사칙 연산자를 지정
	
	private int result;//결과 저장
	
	public Calculator(int su1, int su2, String oper) {
		this.su1 = su1;
		this.su2 = su2;
		this.oper = oper;
		choice();
	}
	
	public String getResult(){
		return "결과값: "+su1+oper+su2+"="+result;
	}
	
	public void choice(){
		if(oper.equals("+")) plus();
		else if(oper.equals("-")) minus();
		else if(oper.equals("*")) multi();
		else div();
	}
	
	public void plus(){
		result=su1+su2;
	}
	public void minus(){
		result=su1-su2;
	}
	public void multi(){
		result=su1*su2;
	}
	public void div(){
		result=su1/su2;
	}
}
