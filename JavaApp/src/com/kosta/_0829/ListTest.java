package com.kosta._0829;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListTest {
	
   public static void printAll(List<String> list){//��ü��Ҹ� ���
	              //List list = new ArrayList();
	              //List list = new Vector();
	   for(int i=0; i<list.size(); i++){
		    System.out.println(list.get(i));
	   }
   }

	
   public static void main(String[] args) {
	  //ArrayList<E>  ������:Element(���)
	  /*
	      ArrayList<String> list = new ArrayList<>();
	      List<String> list1 = new ArrayList<>();
	      List<String> list2 = new Vector<>();
	      List<String> list3 = new LinkedList<>();
	     �������̽�                          Ŭ����  	      
	   */
	   ArrayList<String> list1 = new ArrayList<>();
	      list1.add("�̱���");
	      list1.add("�̴��");
	      list1.add("�ֻ��");
	      list1.add("�ֿ���");
	      list1.add("Ȳ����");
	      
	   printAll(list1);  
	   
	   System.out.println("===============");
	   Vector<String> list2 = new Vector<>();
	      list2.add("������");
	      list2.add("������");
	      list2.add("������");
	      list2.add("����ȯ");
	      list2.add("������");
	      
	    printAll(list2); 
	    
	    System.out.println("===============");
	    LinkedList<String> list3 = new LinkedList<>();
	      list3.add("�Ǽ���");
	      list3.add("��ҿ�");
	      list3.add("������");
	      list3.add("������");
	      list3.add("�̼���");
	      
	    printAll(list3);  
	    
	    
	    //������ �߰�, �����߰�(0�ε��� �����ֱ�!!)
	    ArrayList<String> list4 = new ArrayList<>();
	    
	    System.currentTimeMillis();
	    long start = System.nanoTime();
	    for(int i=0; i<100000; i++){
	    	list4.add(0,"ȫ�浿");
	    }
	    long end = System.nanoTime();
	    System.out.println("list4 �߰��ð�(ArrayList): "+ (end-start));
	    
	    
	    LinkedList<String> list5 = new LinkedList<>();
	    
	    start = System.nanoTime();
	    for(int i=0; i<100000; i++){
	    	list5.add("ȫ�浿");
	    }
	    end = System.nanoTime();
	    System.out.println("list5 �߰��ð�(LinkedList): "+ (end-start));
	    
	    	    
   }//main
}



