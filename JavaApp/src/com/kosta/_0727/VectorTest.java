package com.kosta._0727;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		Vector v = new Vector(5, 3);//(int ��ũ��, int ����ġ)
		//Vector:
		//����������(i=new Integer(13) d=new Double(13.5) s=new String("�ȳ�"))�� ���� Ŭ����
		
		System.out.println("������ ��ũ��: "+v.capacity());//5
		System.out.println("������ ���(������)����: "+v.size());//0
		
		//������ �Է�
		for (int i = 1; i < 10; i++) {//i: 1~9
			v.addElement(new Integer(i));
		}
		
		System.out.println("������ ��ũ��: "+v.capacity());//5+3+3 : 11
		System.out.println("������ ���(������)����: "+v.size());//9
		
		v.addElement(new Double(3.14));
		v.addElement(new Double(9.87));
		v.addElement(new String("�ڹ�"));
		
		System.out.println("������ ��ũ��: "+v.capacity());//11+3 : 14
		System.out.println("������ ���(������)����: "+v.size());//12
		
		System.out.println("������ ù��° ���: "+v.firstElement());//11+3 : 14
		System.out.println("������ ������ ���: "+v.lastElement());//12
		
		//������ ��ü��� ���
		Enumeration enu = v.elements();//���ͳ��� ��ü�����͸� ������
		//Enumeration : ������ �������̽�
		
		System.out.println("=====��ü���������=====");
		while(enu.hasMoreElements()){
			System.out.println(enu.nextElement());
		}
	}
}
