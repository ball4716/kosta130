package com.kosta._0810;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriteTest {
	public static void main(String[] args) {
		//��ü����
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"));
			Person p = new Person();
			oos.writeObject(p);
			
			Person p2 = new Person();
			p2.name = "������";
			p2.age = 15;
			p2.job = "�л�";
			
			oos.writeObject(p2);
			
			System.out.println("��ü���� ����!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
