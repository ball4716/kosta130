package com.kosta._0829;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ForEachTest {
	public static void main(String[] args) {
		// for(�ʱⰪ; ���ǽ�; ������)
		// for(��������:�迭) ===> for(�ڷ��� ������:�迭��)
		// ===> ������ for��, forEach�� (JDK5���� ����)
		int su[] = { 11, 22, 33, 44, 55 };

		for (int i = 0; i < su.length; i++) {
			System.out.println(su[i]);
		}
		System.out.println("=========");
		for (int i : su) {// su�迭�� ũ�⸸ŭ loop�� ���鼭 ���� ������ ���� i�� ����
			System.out.println(i);
		}

		List<String> list = new ArrayList<>();
		list.add("��ȣâ");
		list.add("������");
		list.add("������");
		list.add("���ٿ�");
		list.add("�ֿ뼮");

		for (String str : list) {// ����: �ε����� ����� �� ����!!
			System.out.println(str);
		}
		System.out.println("===========");
		Set<String> set = new HashSet<>();
		set.add("������");
		set.add("������");
		set.add("�ȼ���");
		set.add("��ö");
		set.add("äȿ��");
		set.add("������");
		set.add("��ö");
		

		for (String name : set) {
			System.out.println(name);
		}
	}
}
