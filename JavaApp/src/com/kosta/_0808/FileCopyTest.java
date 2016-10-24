package com.kosta._0808;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {
	//a.txt�� �о b.txt��� ���Ͽ� ������ �״�� ���(���Ϻ���)
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("a.txt");
		FileOutputStream fos = new FileOutputStream("b.txt");
		
		byte b[] = new byte[512];//fis -------����Ʈ�迭--------> fos ��������
				
		int i;//i: ���� ����Ʈ���� ����
		while ((i=fis.read(b))!=-1){//fis ----> b
			fos.write(b,0,i);//fos <---- b
		}
		
		//����� ��ü�� �ڿ��� ���� ��ȯ
		fos.close();
		
		System.out.println("���Ϻ��缺��!!");
	}
}
