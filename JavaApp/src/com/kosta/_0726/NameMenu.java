package com.kosta._0726;

public class NameMenu {
	String names[]; // 배열: (이름)데이터 저장
	public int indexFullCheck;

	public NameMenu() {
		names = new String[5];
		indexFullCheck=0;
	}
	// String names[]배열: (복수의 이름)데이터를 저장
	// 메소드: 데이터를 추가,검색,삭제,수정기능

	public void addName(String name) {
		if(existName(name)){
			System.out.println("#이미 입력된 이름입니다!!");
			return;
		}
		
/*		for (int i = 0; i < names.length; i++) {
			if(names[i]==null){
				break;
			}else if(i==names.length-1){
				System.out.println("#더 이상 입력할 수 없습니다");
				System.out.println("\t한 개 이상의 이름을 먼저 삭제한 후 입력하세요!!");
				return;
			}
		}//인덱스 초과 방지	
*/		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) {
				names[i] = name;
				indexFullCheck++;
				break;
				//return true;
			}
		}//이름 삽입
		
		//return false;
	}// 추가

	public void delName(String name) {
		if(!existName(name)){
			System.out.println("#존재하지 않는 이름입니다!!");
			return;
		}
		
		for (int i = 0; i < names.length; i++) {//지우고자 하는 이름을 배열에서 찾기
			if (names[i] != null && names[i].equals(name)) {
				names[i] = null;//삭제표현
				indexFullCheck--;
				break;
			}
		}
	}// 삭제

	public void editName(String oldName, String newName) {
		if(!existName(oldName)){
			System.out.println("#존재하지 않는 이름입니다!!");
			return;
		}
		
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null && names[i].equals(oldName)){
				names[i] = newName;
			}
		}
	}// 수정
	
	private boolean existName(String searchName){
		for (int i = 0; i < names.length; i++) {
			if(names[i]!=null && names[i].equals(searchName)){
				return true;
			}
		}
		return false;
	}//이름 중복 체크

	public void listName() {
		System.out.println("[이름목록]");
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null)
				System.out.println(names[i]);
		}
	}// 전체검색
	// 메소드: 데이터를 추가,검색,삭제,수정 기능

}
