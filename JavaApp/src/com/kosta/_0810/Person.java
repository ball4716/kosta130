package com.kosta._0810;

import java.io.Serializable;

public class Person implements Serializable{
					//��ü����ȭ �Ҽ� �ִ� Ŭ����
	String name="���浿";
	transient int age=13;//transient: ��ü����ȭ�� ���� �������� �ʰ���
	String job="�л�";
}
