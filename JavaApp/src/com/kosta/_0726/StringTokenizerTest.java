package com.kosta._0726;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		System.out.println("구분자를 통한 데이터분리하기1: StringTokenizer클래스 사용");
		//구분자를 통한 데이터분리하기1: StringTokenizer클래스 사용
		
		//토큰 : (구분되는)데이터 하나하나!!
		//StringTokenizer(String str, String delim); str: 기준문자열  delimiter: 구분자
		String tel="010-7722-4716";
		
		StringTokenizer st = new StringTokenizer(tel, "-");
		//st: ["010" "1234" "4567"] 토큰이 열거
		//여기서 데이터를 데이터요소(토큰),엘리먼트 라고한다
		
		//토큰데이터 꺼내오기
		while(st.hasMoreTokens()){//st.hasMoreTokens(); st에 토큰 가지고있으면 true 없으면 false 리턴
			System.out.println(st.nextToken());
		}
		
		System.out.println("구분자를 통한 데이터분리하기2: String클래스 - split()메소드");
		//구분자를 통한 데이터분리하기2: String클래스 - split()메소드
		//tel.split(String regex); // regex: Regular Expression(정규표현식, 정규식)
		String tels[] = tel.split("-");
		for (int i = 0; i < tels.length; i++) {
			System.out.println(tels[i]);
		}
		
		//StringTokenizer는 공백은 데이터로 처리하지 않는다
		//split은 공백도 데이터로 처리한다
		
	}//main
}
