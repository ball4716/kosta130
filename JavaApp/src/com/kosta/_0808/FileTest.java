package com.kosta._0808;

import java.io.File;
import java.io.FileOutputStream;

public class FileTest {
	public static void main(String[] args) throws Exception{
		//File f = new File(String ���);
		/*
		  <�ڹ��� ���ϰ�� ǥ�����>
		  - �⺻: ��ü��� ���� ǥ��!!
		    "C:\ball4716\workspace\JavaApp\0808\a.txt"
		  
		  - �� ����(���丮)�� ������ �����ϱ� ���� '/'�� ���
		    "C:/ball4716/workspace/JavaApp/0808/a.txt"
		    
		  - ��Ŭ������ JavaProject�� ������ ������Ʈ���� ��δ�
		        ������Ʈ������� ������ ���·� ����ϴ� ���� ����.
		    "0808/a.txt" 
		 */
		File f = new File("abb.txt");
		File f2 = new File("0808");
		System.out.println("�����ϴ� ����?"+f.exists());
		
		System.out.println("f�� �����Դϱ�?"+f.isFile());
		System.out.println("f�� ���丮(����)�Դϱ�?"+f.isDirectory());
		
		System.out.println("f2�� �����Դϱ�?"+f2.isFile());
		System.out.println("f2�� ���丮(����)�Դϱ�?"+f2.isDirectory());
		
		System.out.println("�����̸�: "+f.getName());
		System.out.println("f.getPath(): "+f.getPath());
		System.out.println("f.getAbsolutePath(): "+f.getAbsolutePath());
		System.out.println("f.getCanonicalPath(): "+f.getCanonicalPath());
		
		System.out.println("f.getParent(): "+f.getParent());//f: a.txt
		System.out.println("f.length(): "+f.length());//����,����:1  �ѱ�:2//
		
		//���������
		boolean flag = f.delete();
		if(flag){
			System.out.println("���ϻ�������!!");
		}else{
			System.out.println("���ϻ�������");
		}
		
		File f3= new File("junghoon/jeong/a.txt");
		System.out.println("���������� ����? "+f3.exists());
		boolean flag2 = f3.mkdirs();//mkdirs: make directory
		
		if(flag2){
			System.out.println("������������!!");
		}else{
			System.out.println("������������!!");
		}
		
		//���ϻ�������� FileOutputStream, FileWriter�� ������ ����
		FileOutputStream fos = new FileOutputStream("junghoon/jeong/b.txt");
	}
}