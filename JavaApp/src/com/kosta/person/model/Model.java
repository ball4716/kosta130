package com.kosta.person.model;

import java.util.Vector;

import javax.swing.JOptionPane;

public class Model {
	public Vector<Person> persons;//데이터 저장소
	
	public Model() {
		persons = new Vector<>();
	}
	
	public void insert(Person p){//데이터 입력
		persons.add(p);
	}
	
/*	public void delete(int deleteIdx){//데이터 삭제
		persons.remove(deleteIdx);
	}*/
	
	public boolean delete(int deleteNo){//데이터 삭제
		for (int i = 0; i < persons.size(); i++) {
			Person p=persons.get(i);
			if(p.getNo()==deleteNo){
				persons.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void update(Person old_p, Person update_p){//데이터수정
		//Person old_p = select2(updateNo);
		//old_p.setName(update_p.getName());
		old_p.setAge(update_p.getAge());
		old_p.setAge(update_p.getAge());
	}
	
	public Person select(int no){//데이터검색(한개의 Person), 수정폼에서 사용
		for(int i=0; i<persons.size();i++){
			Person p=persons.get(i);
			if(p.getNo()==no){
				return p;
			}
		}
		return null;//일치하는 번호를 찾지 못했음
	}
	
	public Vector<Person> selectAll(){//데이터검색(전체 Person)
		return persons;
	}
}