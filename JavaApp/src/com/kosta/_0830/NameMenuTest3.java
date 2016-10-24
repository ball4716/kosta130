package com.kosta._0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest3 {
   
   public static void main(String[] args) throws IOException {
	  //프로그램 제어, 반복되는 메뉴출력
	   
	   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   NameMenu3 menu = new NameMenu3();
	   int num;
	   
	   do{
		   
		   String str;
		  
			  System.out.println("<이름메뉴>");
		      System.out.println("1.추가 2.삭제 3.수정 4.검색 5.나가기");
		      System.out.print("번호==> ");
		      str = in.readLine();
		      //str.matches("[0-9]+"); //숫자조합 체크
		      //!str.matches("[0-9]+"); //숫자아닌조합 체크
		      if(!str.matches("[0-9]+")){//str: "abc" "1a"
		    	  System.out.println("#번호만 입력하세요!!\n");	
		    	  num=-1;
		      }else{
		    	  num = Integer.parseInt(str);//Integer.parseInt("1");-->1		    	  
		      }
		      
		      System.out.println();
			  switch(num){
			     case 1: //추가
			    	     
			    	     System.out.print("이름: ");
			    	     String name = in.readLine();//콘솔입력
			    	  
			    	     
			    	     menu.insert(name);			    	 
			    	     break;
				 
			     case 2: 
			    	     System.out.print("삭제할 이름: ");
			    	     String delName = in.readLine();
			    	     
			    	     menu.delete(delName);
					     break;
					     
				 case 3: 	
					     System.out.print("수정할이름(기존이름): ");
					     String oldName = in.readLine();
					     System.out.print("변경할이름(새이름): ");
					     String newName = in.readLine();
					     
					     menu.update(oldName, newName);
					     break;
				 case 4: 
					     menu.selectAll();
			  }//switch
			  System.out.println();
			  
	    }while(num != 5);//메뉴에서 5번을 선택시 나가기
	   
	    System.out.println("-- END --");
	   
   }//main
}