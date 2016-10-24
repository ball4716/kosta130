package com.kosta._0727;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		Vector v = new Vector(5, 3);//(int 방크기, int 증가치)
		//Vector:
		//참조데이터(i=new Integer(13) d=new Double(13.5) s=new String("안녕"))를 갖는 클래스
		
		System.out.println("벡터의 방크기: "+v.capacity());//5
		System.out.println("벡터의 요소(데이터)갯수: "+v.size());//0
		
		//데이터 입력
		for (int i = 1; i < 10; i++) {//i: 1~9
			v.addElement(new Integer(i));
		}
		
		System.out.println("벡터의 방크기: "+v.capacity());//5+3+3 : 11
		System.out.println("벡터의 요소(데이터)갯수: "+v.size());//9
		
		v.addElement(new Double(3.14));
		v.addElement(new Double(9.87));
		v.addElement(new String("자바"));
		
		System.out.println("벡터의 방크기: "+v.capacity());//11+3 : 14
		System.out.println("벡터의 요소(데이터)갯수: "+v.size());//12
		
		System.out.println("벡터의 첫번째 요소: "+v.firstElement());//11+3 : 14
		System.out.println("벡터의 마지막 요소: "+v.lastElement());//12
		
		//벡터의 전체요소 출력
		Enumeration enu = v.elements();//벡터내의 전체데이터를 얻어오기
		//Enumeration : 열거형 인터페이스
		
		System.out.println("=====전체데이터출력=====");
		while(enu.hasMoreElements()){
			System.out.println(enu.nextElement());
		}
	}
}
