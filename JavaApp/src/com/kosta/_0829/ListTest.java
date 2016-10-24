package com.kosta._0829;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListTest {
	
   public static void printAll(List<String> list){//전체요소를 출력
	              //List list = new ArrayList();
	              //List list = new Vector();
	   for(int i=0; i<list.size(); i++){
		    System.out.println(list.get(i));
	   }
   }

	
   public static void main(String[] args) {
	  //ArrayList<E>  데이터:Element(요소)
	  /*
	      ArrayList<String> list = new ArrayList<>();
	      List<String> list1 = new ArrayList<>();
	      List<String> list2 = new Vector<>();
	      List<String> list3 = new LinkedList<>();
	     인터페이스                          클래스  	      
	   */
	   ArrayList<String> list1 = new ArrayList<>();
	      list1.add("이길학");
	      list1.add("이대원");
	      list1.add("최상균");
	      list1.add("최예나");
	      list1.add("황혜정");
	      
	   printAll(list1);  
	   
	   System.out.println("===============");
	   Vector<String> list2 = new Vector<>();
	      list2.add("박종민");
	      list2.add("박지혜");
	      list2.add("신유동");
	      list2.add("이종환");
	      list2.add("최필한");
	      
	    printAll(list2); 
	    
	    System.out.println("===============");
	    LinkedList<String> list3 = new LinkedList<>();
	      list3.add("권성준");
	      list3.add("김소영");
	      list3.add("김현영");
	      list3.add("오정훈");
	      list3.add("이성욱");
	      
	    printAll(list3);  
	    
	    
	    //데이터 추가, 삽입추가(0인덱스 끼워넣기!!)
	    ArrayList<String> list4 = new ArrayList<>();
	    
	    System.currentTimeMillis();
	    long start = System.nanoTime();
	    for(int i=0; i<100000; i++){
	    	list4.add(0,"홍길동");
	    }
	    long end = System.nanoTime();
	    System.out.println("list4 추가시간(ArrayList): "+ (end-start));
	    
	    
	    LinkedList<String> list5 = new LinkedList<>();
	    
	    start = System.nanoTime();
	    for(int i=0; i<100000; i++){
	    	list5.add("홍길동");
	    }
	    end = System.nanoTime();
	    System.out.println("list5 추가시간(LinkedList): "+ (end-start));
	    
	    	    
   }//main
}



