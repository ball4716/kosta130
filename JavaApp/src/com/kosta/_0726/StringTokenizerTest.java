package com.kosta._0726;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		System.out.println("�����ڸ� ���� �����ͺи��ϱ�1: StringTokenizerŬ���� ���");
		//�����ڸ� ���� �����ͺи��ϱ�1: StringTokenizerŬ���� ���
		
		//��ū : (���еǴ�)������ �ϳ��ϳ�!!
		//StringTokenizer(String str, String delim); str: ���ع��ڿ�  delimiter: ������
		String tel="010-7722-4716";
		
		StringTokenizer st = new StringTokenizer(tel, "-");
		//st: ["010" "1234" "4567"] ��ū�� ����
		//���⼭ �����͸� �����Ϳ��(��ū),������Ʈ ����Ѵ�
		
		//��ū������ ��������
		while(st.hasMoreTokens()){//st.hasMoreTokens(); st�� ��ū ������������ true ������ false ����
			System.out.println(st.nextToken());
		}
		
		System.out.println("�����ڸ� ���� �����ͺи��ϱ�2: StringŬ���� - split()�޼ҵ�");
		//�����ڸ� ���� �����ͺи��ϱ�2: StringŬ���� - split()�޼ҵ�
		//tel.split(String regex); // regex: Regular Expression(����ǥ����, ���Խ�)
		String tels[] = tel.split("-");
		for (int i = 0; i < tels.length; i++) {
			System.out.println(tels[i]);
		}
		
		//StringTokenizer�� ������ �����ͷ� ó������ �ʴ´�
		//split�� ���鵵 �����ͷ� ó���Ѵ�
		
	}//main
}
