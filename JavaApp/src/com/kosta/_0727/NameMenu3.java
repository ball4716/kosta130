package com.kosta._0727;


import java.util.Vector;

public class NameMenu3 {
   Vector<String> names;//이름 데이터를 저장하는 저장소
   
   public NameMenu3() {
	   names = new Vector<>();
   }
   
   public void insert(String name){//이름입력,저장
	   names.add(name);
   }
   
   public void selectAll(){//전체이름출력,검색
	  System.out.println("[이름목록]");
	  for(int i=0; i<names.size(); i++){//Vector의 인덱스 표현!!
		 //String name =  names.get(i);
		 System.out.println(" "+names.get(i));//(name);
	  }
   }
   
   public void delete(String delName){//이름삭제
	  for(int i=0; i<names.size(); i++){
		  if(delName.equals(names.get(i))){
			  names.remove(i);//벡터로 부터 이름삭제
			  break;
		  }
	  }
   }
   
   public void update(String oldName, String newName){//이름수정
	  for(int i=0; i<names.size(); i++){
			  if(oldName.equals(names.get(i))){
				  names.set(i, newName); //벡터로 부터 수정
				  break;
			  }
	  } 
   }
   
   //이름 존재유무를 리턴하는 메소드
   public boolean existName(String searchName){//이름이 존재하면 true리턴
	  for(int i=0; i<names.size(); i++){
		  if(searchName.equals(names.get(i))){
			  return true;
		  }
	  }
	  return false; 
   }//existName
}