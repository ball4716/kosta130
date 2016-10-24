package com.kosta._0722;

public class NameMenu {
	String names[]; // 배열: (이름)데이터 저장

	public NameMenu() {
		// TODO Auto-generated constructor stub
		names = new String[5];
	}
	// String names[]배열: (복수의 이름)데이터를 저장
	// 메소드: 데이터를 추가,검색,삭제,수정기능

	public void addName(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) {
				names[i] = name;
				break;
			} else {
				continue;
			}
			// if(names[i]!=null){
			// System.out.println("목록이 가득찼습니다.");
			// }//목록이 가득찼을때 출력
		}
	}// 추가

	public void delName(String name) {
		for (int i = 0; i < names.length; i++) {//지우고자 하는 이름을 배열에서 찾기
			//names[i] : 배열에 저장된 값, name: 지울 이름
			//if (names[i].equals(name)) {//문자열 내용 비교: 문자열.equals(비교문자열)
			//NullPointerException 발생 가능!!
			//if (name.equals(names[i])) {//콘솔입력은 null입력이 없다. 최소 빈문자열 ""
			
			if (names[i] != null && names[i].equals(name)) {
				//NullPointerException발생이유: null.필드명 또는 null.메소드명()
				// A||B : A가 true라면 B는 실행되지 않음.
				// A&&B : A가 false라면 B는 실행되지 않음.
				names[i] = null;//삭제표현
				break;
			}
		}
	}// 삭제

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
	}// 수정

	public void listName() {
		System.out.println("[이름목록]");
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null)
				System.out.println(names[i]);
		}
	}// 전체검색
	// 메소드: 데이터를 추가,검색,삭제,수정 기능

}
