package com.kosta._0810;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectReadTest {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("person.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object ob= ois.readObject();
			Person p = (Person)ob;//p�ڽ� = (�ڽ�)ob�θ�;
			System.out.println("�̸�: "+p.name);
			System.out.println("����: "+p.age);
			System.out.println("����: "+p.job);
			
			System.out.println("============");
			
			Person p2 = (Person)ois.readObject();
			System.out.println("�̸�: "+p2.name);
			System.out.println("����: "+p2.age);
			System.out.println("����: "+p2.job);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
