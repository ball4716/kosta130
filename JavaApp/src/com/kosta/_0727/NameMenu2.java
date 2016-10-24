package com.kosta._0727;

import java.util.Vector;

public class NameMenu2 {
	Vector<String> names; // 이름 데이터를 저장하는 저장소
	private int indexReturn;
	
	public NameMenu2() {
		names = new Vector<>();
		indexReturn=-1;
	}
	
	public void insert(String name){//이름 입력,저장
		if(existName(name)){
			System.out.println("#이미 존재하는 이름입니다!");
			return;
		}else{
			names.add(name);
		}
	}
	
	public void delete(String delName){//이름 삭제
		if(!existName(delName)){
			System.out.println("#해당 이름이 존재하지 않습니다!");
			return;
		}else{
			names.remove(indexReturn);
		}
	}
	
	public void update(String oldName, String newName){//이름 수정
		if(!existName(oldName)){
			System.out.println("#해당 이름이 존재하지 않습니다!");
			return;
		}else{
			names.set(indexReturn, newName);
			return;
		}
	}
	
	public void selectAll(){//전체이름출력
		System.out.println("[이름목록]");
		for (int i = 0; i < names.size(); i++) { //Vector의 인덱스 표현!!
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
