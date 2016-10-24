package com.kosta._0722;

abstract class Shape{
	abstract void draw();
	void hello(){
		System.out.println("130기 안녕~!!");
	}
}//Shape

class Rectangle extends Shape {
	@Override
	void draw(){
		System.out.println("사각형그리기");
	}
}//Rectangle

class Triangle extends Shape {
	@Override
	void draw() {
		System.out.println("삼각형그리기");
	}
}//Triangle

class Circle extends Shape{
	@Override
	void draw() {	
		System.out.println("원그리기");
	}
}//Circle

public class AbstractTest {
	public static void main(String[] args) {
		Shape s;// = new Shape(); 에러: 추상클래스는 스스로 객체생성불가
		s = new Rectangle();
			s.draw();
		s = new Triangle();
			s.draw();
		s = new Circle();
			s.draw();
	}
}
