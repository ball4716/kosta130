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
		//기존 나이 변경
		op.setAge(np.getAge());
		//기본 직업 변경
		op.setJob(np.getJob());
	}//update
	public void select(){//전체 데이터를 출력
		//배열: index와 length
		//벡터: index와 size()
		System.out.println("#사람목록");
		for (int i = 0; i < persons.size(); i++) {
			System.out.print((i+1)+": ");
			System.out.println(persons.get(i));
		}
	}
}