package com.kosta._0726;

public class StringConvertTest {//문자열 변환 테스트
	
	public void convert1(){
		String s1="우리나라";
		s1 = s1+"대한민국만세~!!";
		System.out.println(s1);
		/*
		  1. String클래스 객체생성
		  2. 문자열 변환을 위해 임시로 StringBuffer클래스 객체 생성
		  3. StringBuffer클래스의 append()메소드 실행
		  4. StringBuffer를 String으로 변환
		  5. StringBuffer클래스 객체 소멸
		 */
	}
	
	public void convert2(){
		StringBuffer s1 = new StringBuffer("우리나라");
		s1.append("대한민국만세~!!");
		System.out.println(s1);
		/*
		  1. StringBuffer클래스 객체 생성
		  2. append()메소드 실행
		  
		  = + + + 보다
		  append().append().append() 이게 효과적!
		 */
	}
	
	public static void main(String[] args) {
		StringConvertTest sct = new StringConvertTest(); //가변문자열
		sct.convert1();
		sct.convert2();
	}
}
