package com.kosta._0722;

public class NameMenu {
	String names[]; // �迭: (�̸�)������ ����

	public NameMenu() {
		// TODO Auto-generated constructor stub
		names = new String[5];
	}
	// String names[]�迭: (������ �̸�)�����͸� ����
	// �޼ҵ�: �����͸� �߰�,�˻�,����,�������

	public void addName(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) {
				names[i] = name;
				break;
			} else {
				continue;
			}
			// if(names[i]!=null){
			// System.out.println("����� ����á���ϴ�.");
			// }//����� ����á���� ���
		}
	}// �߰�

	public void delName(String name) {
		for (int i = 0; i < names.length; i++) {//������� �ϴ� �̸��� �迭���� ã��
			//names[i] : �迭�� ����� ��, name: ���� �̸�
			//if (names[i].equals(name)) {//���ڿ� ���� ��: ���ڿ�.equals(�񱳹��ڿ�)
			//NullPointerException �߻� ����!!
			//if (name.equals(names[i])) {//�ܼ��Է��� null�Է��� ����. �ּ� ���ڿ� ""
			
			if (names[i] != null && names[i].equals(name)) {
				//NullPointerException�߻�����: null.�ʵ�� �Ǵ� null.�޼ҵ��()
				// A||B : A�� true��� B�� ������� ����.
				// A&&B : A�� false��� B�� ������� ����.
				names[i] = null;//����ǥ��
				break;
			}
		}
	}// ����

	public void editName(String oldName, String newName) {
		for (int i = 0; i < names.length; i++) {
			/*
			if (names[i] == null) {
				continue;
			} else if (names[i].equals(oldName)) {
				names[i] = newName;
			}
			*/
			if (names[i] != null && names[i].equals(oldName)){
				names[i] = newName;
			}
		}
	}// ����

	public void listName() {
		System.out.println("[�̸����]");
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null)
				System.out.println(names[i]);
		}
	}// ��ü�˻�
	// �޼ҵ�: �����͸� �߰�,�˻�,����,���� ���

}
