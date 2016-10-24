package com.kosta._0726;

public class NameMenu {
	String names[]; // �迭: (�̸�)������ ����
	public int indexFullCheck;

	public NameMenu() {
		names = new String[5];
		indexFullCheck=0;
	}
	// String names[]�迭: (������ �̸�)�����͸� ����
	// �޼ҵ�: �����͸� �߰�,�˻�,����,�������

	public void addName(String name) {
		if(existName(name)){
			System.out.println("#�̹� �Էµ� �̸��Դϴ�!!");
			return;
		}
		
/*		for (int i = 0; i < names.length; i++) {
			if(names[i]==null){
				break;
			}else if(i==names.length-1){
				System.out.println("#�� �̻� �Է��� �� �����ϴ�");
				System.out.println("\t�� �� �̻��� �̸��� ���� ������ �� �Է��ϼ���!!");
				return;
			}
		}//�ε��� �ʰ� ����	
*/		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) {
				names[i] = name;
				indexFullCheck++;
				break;
				//return true;
			}
		}//�̸� ����
		
		//return false;
	}// �߰�

	public void delName(String name) {
		if(!existName(name)){
			System.out.println("#�������� �ʴ� �̸��Դϴ�!!");
			return;
		}
		
		for (int i = 0; i < names.length; i++) {//������� �ϴ� �̸��� �迭���� ã��
			if (names[i] != null && names[i].equals(name)) {
				names[i] = null;//����ǥ��
				indexFullCheck--;
				break;
			}
		}
	}// ����

	public void editName(String oldName, String newName) {
		if(!existName(oldName)){
			System.out.println("#�������� �ʴ� �̸��Դϴ�!!");
			return;
		}
		
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null && names[i].equals(oldName)){
				names[i] = newName;
			}
		}
	}// ����
	
	private boolean existName(String searchName){
		for (int i = 0; i < names.length; i++) {
			if(names[i]!=null && names[i].equals(searchName)){
				return true;
			}
		}
		return false;
	}//�̸� �ߺ� üũ

	public void listName() {
		System.out.println("[�̸����]");
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null)
				System.out.println(names[i]);
		}
	}// ��ü�˻�
	// �޼ҵ�: �����͸� �߰�,�˻�,����,���� ���

}
