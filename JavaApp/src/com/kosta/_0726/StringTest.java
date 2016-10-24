package com.kosta._0726;

public class StringTest {
	public static void main(String[] args) {
		//Object s1="java";
		//Object s2="JAVA";
		String s1="java";
		String s2="JAVA";
		
		//문자열의 내용비교 ★ : 객체명.equals(객체명), 메모리비교 : ==
		
		if(s1.equals(s2)){//equals는 String 자식클래스의 오버라이딩된 equals 메소드 호출!
			System.out.println("s1과 s2문자열 내용 같음!!");
		}else{
			System.out.println("s1과 s2문자열 내용 다름!");
		}
		
		//대소문자 구분 없이 비교
		if(s1.equalsIgnoreCase(s2)){
			System.out.println("s1과 s2는 철자가 같음!!");
		}else{
			System.out.println("s1과 s2는 철자가 다름!!");
		}
		
		String str="JavaProgramming";
		//인덱스:     012345678901234
		
		System.out.println("str의 문자열길이: "+str.length());
		
		//문자열 대문자로 변경
		System.out.println("str을 대문자로 변경: "+str.toUpperCase());
		//문자열 소문자로 변경
		System.out.println("str을 소문자로 변경: "+str.toLowerCase());
		
		//문자열내에 'a' ----> 'o' 변환(대체) : replace
		System.out.println("str.replace('a', 'o'): "+str.replace('a', 'o'));
		//str = str.replace('a', 'o');
		System.out.println("STR= "+str);
		
		//특정문자('P')에 해당하는 인덱스를 얻어오기!!
		//문자와 숫자는 호환이 가능!!  ---> 'a'(97)<100
		System.out.println("str.indexOf('P'): "+str.indexOf('P'));
		//str.indexOf(97) == str.indexOf('a')
		
		//특정인덱스에 해당하는 문자를 얻어오기
		//charAt(int index)
		System.out.println("str.charAt(4): "+str.charAt(4));
		
		//부분substring(int beginIndex)
		System.out.println("str.substring(str.indexOf('P')): "+
							str.substring(str.indexOf('P')));
						  //str.substring(4);
		
		//특정문자열로 시작: startsWith(String prefix)
		//특정문자열로 끝나는지 체크: endsWith(String suffix)
		System.out.println("str.startsWith(\"JAVA\"): "+str.startsWith("Java"));
		System.out.println("str.endsWith(\"ing\"): "+str.endsWith("ing"));
		
		//
		System.out.println("현재문자열 str길이(문자갯수): "+str.length());
		str = str + "  ";
		System.out.println("STR= "+str+"("+str.length()+")");
		
		//문자열 앞뒤의 연속된 문자열을 제거: trim()
		str = str.trim();
		System.out.println("STR(공백제거)= "+str+"("+str.length()+")");
		

		/*
		 * 		   str.getBytes()			   str.toCharArray()
		 * 			<-----------                ------------->
		 *  byte b[]			String str="abc"			char ch[]
		 *  ={97,98,99}                                     ={'a','b','c'}
		 *  	    ----------->                <-------------
		 *  		new String(b);				new String(ch);
		 */
		String str2 = "abc";
		byte b[] = str2.getBytes();
		for (int  i= 0; i < b.length;i++) {
			System.out.println("["+i+"]="+b[i]);
		}
		
		char ch[] = str2.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			System.out.println("ch["+i+"]="+ch[i]);
		}
		
		String str3 = new String(b);
		System.out.println("STR3 = "+str3);
		
	}
}
