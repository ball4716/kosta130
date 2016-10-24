package com.kosta._0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest3 {
   
   public static void main(String[] args) throws IOException {
	  //���α׷� ����, �ݺ��Ǵ� �޴����
	   
	   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   NameMenu3 menu = new NameMenu3();
	   int num;
	   
	   do{
		   
		   String str;
		  
			  System.out.println("<�̸��޴�>");
		      System.out.println("1.�߰� 2.���� 3.���� 4.�˻� 5.������");
		      System.out.print("��ȣ==> ");
		      str = in.readLine();
		      //str.matches("[0-9]+"); //�������� üũ
		      //!str.matches("[0-9]+"); //���ھƴ����� üũ
		      if(!str.matches("[0-9]+")){//str: "abc" "1a"
		    	  System.out.println("#��ȣ�� �Է��ϼ���!!\n");	
		    	  num=-1;
		      }else{
		    	  num = Integer.parseInt(str);//Integer.parseInt("1");-->1		    	  
		      }
		      
		      System.out.println();
			  switch(num){
			     case 1: 
			    	     if(menu.names.size() == 5){
			    	      System.out.println("#�� �̻� �Է��� �� �����ϴ�\n"+
			                 "�� �� �̻��� �̸��� ���� ������ �� �Է��ϼ���!!");
			    	      break;
			    	     }
			    	     
			    	     System.out.print("�̸�: ");
			    	     String name = in.readLine();
			    	     
			    	     if(menu.existName(name)){
			    	       System.out.println("#�̹� �Էµ� �̸��Դϴ�!!");
			    	       break;
			    	     }
			    	     
			    	     menu.insert(name);			    	 
			    	     break;
				 
			     case 2: 
			    	     System.out.print("������ �̸�: ");
			    	     String delName = in.readLine();
			    	     //!true ----> false   !false ----> true
			    	     if(!menu.existName(delName)){
				    	   System.out.println("#�������� �ʴ� �̸��Դϴ�!!");
				    	   break;
				    	 }
			    	     menu.delete(delName);
					     break;
					     
				 case 3: 	
					     System.out.print("�������̸�(�����̸�): ");
					     String oldName = in.readLine();
					     System.out.print("�������̸�(���̸�): ");
					     String newName = in.readLine();
					     
					     if(!menu.existName(oldName)){
					    	System.out.println("#�������� �ʴ� �̸��Դϴ�!!");
					    	break;
					     }
					     
					     menu.update(oldName, newName);
					     break;
				 case 4: 
					     menu.selectAll();
			  }//switch
			  System.out.println();
			  
	    }while(num != 5);//�޴����� 5���� ���ý� ������
	   
	    System.out.println("-- END --");
	   
   }//main
}