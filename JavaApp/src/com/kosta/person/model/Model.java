package com.kosta.person.model;

import java.util.Vector;

import javax.swing.JOptionPane;

public class Model {
	public Vector<Person> persons;//������ �����
	
	public Model() {
		persons = new Vector<>();
	}
	
	public void insert(Person p){//������ �Է�
		persons.add(p);
	}
	
/*	public void delete(int deleteIdx){//������ ����
		persons.remove(deleteIdx);
	}*/
	
	public boolean delete(int deleteNo){//������ ����
		for (int i = 0; i < persons.size(); i++) {
			Person p=persons.get(i);
			if(p.getNo()==deleteNo){
				persons.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void update(Person old_p, Person update_p){//�����ͼ���
		//Person old_p = select2(updateNo);
		//old_p.setName(update_p.getName());
		old_p.setAge(update_p.getAge());
		old_p.setAge(update_p.getAge());
	}
	
	public Person select(int no){//�����Ͱ˻�(�Ѱ��� Person), ���������� ���
		for(int i=0; i<persons.size();i++){
			Person p=persons.get(i);
			if(p.getNo()==no){
				return p;
			}
		}
		return null;//��ġ�ϴ� ��ȣ�� ã�� ������
	}
	
	public Vector<Person> selectAll(){//�����Ͱ˻�(��ü Person)
		return persons;
	}
}