package com.kosta._0727;

import java.util.Vector;

public class VectorTest2 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		
		//데이터 입력(input, add, insert, plus, append)
		v.addElement("홍길동");
		//v.addElement(new Integer(13)); //에러: String으로 자료형이 명시되어있으므로
		v.add("길라임");
		v.add("김주원");
		//벡터는 처음 입력된 데이터부터 인덱스를 부여
		
		//v.add(int index, String element); //특정 인덱스에 데이터를 입력
		/*
		 * 		v: 홍길동 길라임 김주원
		 * 		    0    1    2    3    4
		 *      v: 김유신 홍길동 길라임 김주원
		 *      v: 김유신 이순신 홍길동 길라임 김주원
		 */
		v.add(0, "김유신");
		v.insertElementAt("이순신", 1);
		
		//데이터 삭제(delete, drop, clear, remove)
		//"홍길동"삭제
		//v.remove(int index)
		v.remove(2);
		for (int i = 0; i < v.size(); i++) {
			if ("이순신".equals(v.get(i))){
				v.remove(i);
				break;
			}
		}//가장 추천!
		
		v.remove("길라임");
		
		//v.removeAllElements();//전체데이터 지우기
		//v.clear();//전체데이터 지우기
		
		//데이터 수정(edit, update, set, modify)
		//김주원 ---> 차주원
		for (int i = 0; i < v.size(); i++) {
			if(v.get(i).equals("김주원")){
				//v.set(int index, String element)
				//v.setElementAt(String obj, int index);
				v.set(i, "차주원");
			}
		}
		
		//데이터 검색(search, find, select, get)
		for (int i = 0; i < v.size(); i++) {//벡터의 인덱스
			//v.get(int index)
			//v.elementAt(int index)
			System.out.println(i+" : "+v.get(i));
		}
		
		System.out.println("--프로그램종료--");
		
		
	}//main
}
