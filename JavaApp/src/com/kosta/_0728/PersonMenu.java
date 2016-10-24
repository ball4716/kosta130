package com.kosta._0728;

import java.util.Vector;

public class PersonMenu {
	Vector<Person> persons;
	public PersonMenu() {
		persons=new Vector<>();
	}
	public void insert(Person p){
		persons.add(p);
	}
	public void delete(int deleteIdx){
		persons.remove(deleteIdx);
	}
	public void update(int updateIdx, Person np){
		//persons.set(updateIdx, p);
		Person op = persons.get(updateIdx);
		//���� ���� ����
		op.setAge(np.getAge());
		//�⺻ ���� ����
		op.setJob(np.getJob());
	}//update
	public void select(){//��ü �����͸� ���
		//�迭: index�� length
		//����: index�� size()
		System.out.println("#������");
		for (int i = 0; i < persons.size(); i++) {
			System.out.print((i+1)+": ");
			System.out.println(persons.get(i));
		}
	}
}