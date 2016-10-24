package com.kosta._0829;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapTest {
   public static void main(String[] args) {
	  //Map<K, V>  : Key�� ������ �ڷ��� ���, Value(������)�� ������ �ڷ��� ���
	  //Map == �Ź��� Ŭ����
	   
	  Map<String,String> pwds=new HashMap<>();//�н����� ����
	    //�������Է�
	    //pwds.put(String key,String value); 
	    pwds.put("gildong", "1234");
	    pwds.put("lime", "9999");
	    pwds.put("juwon", "7777");
	  
	  
	  Map<String,Person> infos=new HashMap<>();//����� ����
	    Person p = new Person("���浿", "�л�", "gildong@naver.com");
	    infos.put("gildong", p);
	    infos.put("lime", new Person("�����", "����Ʈ���", "lime@daum.net"));
	    infos.put("juwon", new Person("���ֿ�","����","juwon@gmail.com"));
	    
	    
	  Scanner scan = new Scanner(System.in);  
	     System.out.print("���̵�:"); 
	     String id = scan.nextLine();
	     
	     String pass = pwds.get(id);//pass: 1234,9999,7777, null
	     if(pass==null){//���̵����!!
	    	 System.out.println(" #��ġ�ϴ� ���̵� ����!!");
	     }else{//���̵�����!!
	    	 System.out.print("���:");
	    	 String inPass = scan.nextLine();
	    	 if(pass.equals(inPass)){//�����ġ
	    		 System.out.println("<����� ����>");
	    		 System.out.println( infos.get(id) );
	    	 }else{//�������ġ
	    		 System.out.println(" #��й�ȣ�� Ȯ���ϼ���!!");
	    	 }
	     }
	  
   }
}




