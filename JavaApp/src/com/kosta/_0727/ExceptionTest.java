package com.kosta._0727;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class ExceptionTest {
	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("a.txt");
			// ������ ��δ� "����̺�:\���\���ϸ�" "C:\ball4716\workspace\JavaApp\a.txt"
			// ��Ŭ���� JavaProject�� ���� ������Ʈ������ ��θ� �����ϴ� ���� ����!
			//System.out.println(fr.read());//���̻� ���� ���ڰ� ������ -1����
			//(char)97 98 99 -1 -1
			int i;
			while((i=fr.read()) != -1){
				System.out.print((char)i+" ");
			}
		} catch (FileNotFoundException e) {
			//try������ ���ܰ� �߻������� ������ ��!!
			System.out.println("���ܰ�ü e : "+e);//e == e.toString()
			System.out.println("���ܰ�ü e.toString() : "+e.toString());
			System.out.println("e.getMessage() : "+e.getMessage());
			e.printStackTrace();//���ΰ� �ΰ����踦 ��Ȯ�� �����ش�
		} catch (IOException e) {

		}
	}// main
}
