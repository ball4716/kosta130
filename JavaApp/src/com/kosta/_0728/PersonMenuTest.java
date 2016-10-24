package com.kosta._0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.kosta._0728.PersonMenu;

public class PersonMenuTest {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PersonMenu menu = new PersonMenu();
		boolean flag = true;
		String choiceStr;
		int choiceNum;
		String insertName,insertJob;
		int insertAge;
		String updateName,updateJob;
		int updateIdx,updateAge;
		int deleteIdx;
		
		Person ip;
		Person up;

		while (flag) {
			System.out.println("<����޴�>");
			System.out.println("1.�߰� 2.�˻� 3.���� 4.����");
			System.out.print("��ȣ�Է�==> ");
			choiceStr=br.readLine();
			choiceNum = Integer.parseInt(choiceStr);
			System.out.println();
			
			switch (choiceNum) {
			case 1:
				System.out.print("�̸�: ");
				 insertName=br.readLine();
				System.out.print("����: ");
				 insertAge=Integer.parseInt(br.readLine());
				System.out.print("����: ");
				 insertJob=br.readLine();
				 
				//������ �����ִ� �����͵��� �ϳ��� �̸����� ����
				ip=new Person(insertName,insertAge,insertJob);
				menu.insert(ip);
				System.out.println();
				break;
			case 2:
				menu.select();
				System.out.println();
				break;
			case 3:
				System.out.print("������ ��ȣ: ");
				updateIdx = Integer.parseInt(br.readLine())-1;
				System.out.print("����: ");
				updateAge = Integer.parseInt(br.readLine());
				System.out.print("����: ");
				updateJob = br.readLine();
				updateName = menu.persons.get(updateIdx).getName();
				
				//						name, age, job
				//Person p = new Person(null, age, job);//������ ��� ����
				//up=new Person(updateName,updateAge,updateJob);
				up=new Person();
				up.setAge(updateAge);
				up.setJob(updateJob);
				
				menu.update(updateIdx, up);
				System.out.println();
				break;
			case 4:
				System.out.print("������ ��ȣ: ");
				deleteIdx=Integer.parseInt(br.readLine())-1;
				menu.delete(deleteIdx);
				System.out.println();
				break;
			case 5:
				flag = false;
				break;
			default:
				break;
			}// switch~case end
			if (!flag)
				break;
		} // while end
		System.out.println("-- END --");
	}
}
