package com.kosta._0727;

import java.util.Vector;

public class NameMenu2 {
	Vector<String> names; // �̸� �����͸� �����ϴ� �����
	private int indexReturn;
	
	public NameMenu2() {
		names = new Vector<>();
		indexReturn=-1;
	}
	
	public void insert(String name){//�̸� �Է�,����
		if(existName(name)){
			System.out.println("#�̹� �����ϴ� �̸��Դϴ�!");
			return;
		}else{
			names.add(name);
		}
	}
	
	public void delete(String delName){//�̸� ����
		if(!existName(delName)){
			System.out.println("#�ش� �̸��� �������� �ʽ��ϴ�!");
			return;
		}else{
			names.remove(indexReturn);
		}
	}
	
	public void update(String oldName, String newName){//�̸� ����
		if(!existName(oldName)){
			System.out.println("#�ش� �̸��� �������� �ʽ��ϴ�!");
			return;
		}else{
			names.set(indexReturn, newName);
			return;
		}
	}
	
	public void selectAll(){//��ü�̸����
		System.out.println("[�̸����]");
		for (int i = 0; i < names.size(); i++) { //Vector�� �ε��� ǥ��!!
			System.out.println(names.get(i));
		}
	}
	
	private boolean existName(String searchName){
		int i;
		for (i = 0; i < names.size(); i++) {
			if(names.get(i).equals(searchName)){
				indexReturn=i;
				return true;
			}
		}
		return false;
	}
}
