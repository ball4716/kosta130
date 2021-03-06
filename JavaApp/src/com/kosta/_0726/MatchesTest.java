package com.kosta._0726;

public class MatchesTest {
	public static void main(String[] args) {
		String str="c";
		
		//str.matches(String regex)
		System.out.println(str.matches("[abc]"));
		//a또는 b또는 c문자가 발생
		//str이 [a]라는 규칙을 갖는지 검사
		
		/*
		 * [a] : a문자가 1번 출현
		 * [a]? : a문자가 0~1번 출현
		 * [a]* : a문자가 0번 ~ ∞ 출현
		 * [a]+ : a문자가 1번 ~ ∞ 출현
		 */
		
		String str2="bbbbbbbbbcac";
		System.out.println(str2.matches("[abc]*"));
		
		System.out.println("=========숫  자 조합=========");
		//숫자검사(숫자조합)
		String str3="34";
		System.out.println(str3.matches("[0123456789]")); //0~9중 하나
		System.out.println(str3.matches("[0123456789]?"));//0~9중 하나, 생략가능
		System.out.println(str3.matches("[0123456789]*"));//0~9조합이 0 ~ ∞
		System.out.println(str3.matches("[0123456789]+"));//0~9조합이 1 ~ ∞
		System.out.println(str3.matches("[0-9]+"));//0~9조합이 1 ~ ∞
		System.out.println(str3.matches("[\\d]+"));//0~9조합이 1 ~ ∞
		
		
		System.out.println("=========영문자 조합=========");
		//영문자조합
		String str4="adF4h";
		System.out.println(str4.matches("[a-zA-Z]+"));
		System.out.println(str4.matches("[a-zA-Z]{3}"));//3자리
		System.out.println(str4.matches("[a-zA-Z]{3,6}"));//3자리~6자리
		
		//영문자조합이 아닌 값을 체크
		if(!str4.matches("[a-zA-Z]+")){
			//영문자만 입력하세요!!!
			System.out.println("영문자만 입력하세요!!");
		}

		System.out.println("=========한  글 조합=========");
		//한글조합
		String str5="김두한";
		System.out.println(str5.matches("[ㄱ-힣]+"));
		
	}

}
