package com.kosta._0829;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesTest {
   public static void main(String[] args) throws Exception{
	  Properties pro = new Properties();//�Ӽ�Ŭ����
	  //������: �Ӽ�, property, attribute
	  //���׸��� ������� �ʴ� ����? String������(text)�� �Է�!!   
	  
	    //������ �Է�
	    //pro.setProperty(String key,String value);//key:����, value:������
	    pro.setProperty("k1", "���浿");
	    pro.setProperty("k2", "������");
	    pro.setProperty("k3", "���ֿ�");
	    pro.setProperty("k1", "ȫ�浿");
	    
        //������ ��ȸ
	    System.out.println("k1Ű�� ���尪="+pro.getProperty("k1"));
	    System.out.println("k2Ű�� ���尪="+pro.getProperty("k2"));
	    System.out.println("k3Ű�� ���尪="+pro.getProperty("k3"));
	    System.out.println("k4Ű�� ���尪="+pro.getProperty("k4"));
	    
	    //properties������ �ε��ϱ�!!
	    //pro.load(Reader reader);
	     pro.load(new FileReader("src/com/kosta/_0829/test.properties"));
	     System.out.println("�̸�: "+ pro.getProperty("name"));
	     System.out.println("����: "+pro.getProperty("age"));
	     System.out.println("����: "+pro.getProperty("job"));
   }
}



