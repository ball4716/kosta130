package com.kosta._0726;

public class StringConvertTest {//���ڿ� ��ȯ �׽�Ʈ
	
	public void convert1(){
		String s1="�츮����";
		s1 = s1+"���ѹα�����~!!";
		System.out.println(s1);
		/*
		  1. StringŬ���� ��ü����
		  2. ���ڿ� ��ȯ�� ���� �ӽ÷� StringBufferŬ���� ��ü ����
		  3. StringBufferŬ������ append()�޼ҵ� ����
		  4. StringBuffer�� String���� ��ȯ
		  5. StringBufferŬ���� ��ü �Ҹ�
		 */
	}
	
	public void convert2(){
		StringBuffer s1 = new StringBuffer("�츮����");
		s1.append("���ѹα�����~!!");
		System.out.println(s1);
		/*
		  1. StringBufferŬ���� ��ü ����
		  2. append()�޼ҵ� ����
		  
		  = + + + ����
		  append().append().append() �̰� ȿ����!
		 */
	}
	
	public static void main(String[] args) {
		StringConvertTest sct = new StringConvertTest(); //�������ڿ�
		sct.convert1();
		sct.convert2();
	}
}
