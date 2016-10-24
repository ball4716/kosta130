package com.kosta._0722;

abstract class Shape{
	abstract void draw();
	void hello(){
		System.out.println("130�� �ȳ�~!!");
	}
}//Shape

class Rectangle extends Shape {
	@Override
	void draw(){
		System.out.println("�簢���׸���");
	}
}//Rectangle

class Triangle extends Shape {
	@Override
	void draw() {
		System.out.println("�ﰢ���׸���");
	}
}//Triangle

class Circle extends Shape{
	@Override
	void draw() {	
		System.out.println("���׸���");
	}
}//Circle

public class AbstractTest {
	public static void main(String[] args) {
		Shape s;// = new Shape(); ����: �߻�Ŭ������ ������ ��ü�����Ұ�
		s = new Rectangle();
			s.draw();
		s = new Triangle();
			s.draw();
		s = new Circle();
			s.draw();
	}
}
