package com.kosta._0726;

public class MatchesTest {
	public static void main(String[] args) {
		String str="c";
		
		//str.matches(String regex)
		System.out.println(str.matches("[abc]"));
		//a�Ǵ� b�Ǵ� c���ڰ� �߻�
		//str�� [a]��� ��Ģ�� ������ �˻�
		
		/*
		 * [a] : a���ڰ� 1�� ����
		 * [a]? : a���ڰ� 0~1�� ����
		 * [a]* : a���ڰ� 0�� ~ �� ����
		 * [a]+ : a���ڰ� 1�� ~ �� ����
		 */
		
		String str2="bbbbbbbbbcac";
		System.out.println(str2.matches("[abc]*"));
		
		System.out.println("=========��  �� ����=========");
		//���ڰ˻�(��������)
		String str3="34";
		System.out.println(str3.matches("[0123456789]")); //0~9�� �ϳ�
		System.out.println(str3.matches("[0123456789]?"));//0~9�� �ϳ�, ��������
		System.out.println(str3.matches("[0123456789]*"));//0~9������ 0 ~ ��
		System.out.println(str3.matches("[0123456789]+"));//0~9������ 1 ~ ��
		System.out.println(str3.matches("[0-9]+"));//0~9������ 1 ~ ��
		System.out.println(str3.matches("[\\d]+"));//0~9������ 1 ~ ��
		
		
		System.out.println("=========������ ����=========");
		//����������
		String str4="adF4h";
		System.out.println(str4.matches("[a-zA-Z]+"));
		System.out.println(str4.matches("[a-zA-Z]{3}"));//3�ڸ�
		System.out.println(str4.matches("[a-zA-Z]{3,6}"));//3�ڸ�~6�ڸ�
		
		//������������ �ƴ� ���� üũ
		if(!str4.matches("[a-zA-Z]+")){
			//�����ڸ� �Է��ϼ���!!!
			System.out.println("�����ڸ� �Է��ϼ���!!");
		}

		System.out.println("=========��  �� ����=========");
		//�ѱ�����
		String str5="�����";
		System.out.println(str5.matches("[��-�R]+"));
		
	}

}
