package com.kosta._0810;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectReadTest {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("person.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object ob= ois.readObject();
			Person p = (Person)ob;//p자식 = (자식)ob부모;
			System.out.println("이름: "+p.name);
			System.out.println("나이: "+p.age);
			System.out.println("직업: "+p.job);
			
			System.out.println("============");
			
			Person p2 = (Person)ois.readObject();
			System.out.println("이름: "+p2.name);
			System.out.println("나이: "+p2.age);
			System.out.println("직업: "+p2.job);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
