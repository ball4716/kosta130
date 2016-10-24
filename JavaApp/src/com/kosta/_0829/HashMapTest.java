package com.kosta._0829;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapTest {
   public static void main(String[] args) {
	  //Map<K, V>  : Key로 설정할 자료형 명시, Value(데이터)로 설정할 자료형 명시
	  //Map == 신발장 클래스
	   
	  Map<String,String> pwds=new HashMap<>();//패스워드 정보
	    //데이터입력
	    //pwds.put(String key,String value); 
	    pwds.put("gildong", "1234");
	    pwds.put("lime", "9999");
	    pwds.put("juwon", "7777");
	  
	  
	  Map<String,Person> infos=new HashMap<>();//사용자 정보
	    Person p = new Person("나길동", "학생", "gildong@naver.com");
	    infos.put("gildong", p);
	    infos.put("lime", new Person("라라임", "스턴트우먼", "lime@daum.net"));
	    infos.put("juwon", new Person("길주원","군인","juwon@gmail.com"));
	    
	    
	  Scanner scan = new Scanner(System.in);  
	     System.out.print("아이디:"); 
	     String id = scan.nextLine();
	     
	     String pass = pwds.get(id);//pass: 1234,9999,7777, null
	     if(pass==null){//아이디없음!!
	    	 System.out.println(" #일치하는 아이디가 없음!!");
	     }else{//아이디존재!!
	    	 System.out.print("비번:");
	    	 String inPass = scan.nextLine();
	    	 if(pass.equals(inPass)){//비번일치
	    		 System.out.println("<사용자 정보>");
	    		 System.out.println( infos.get(id) );
	    	 }else{//비번불일치
	    		 System.out.println(" #비밀번호를 확인하세요!!");
	    	 }
	     }
	  
   }
}




