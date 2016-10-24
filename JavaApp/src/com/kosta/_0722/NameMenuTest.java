package com.kosta._0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest {

	public static void main(String[] args) throws IOException {
		// ���α׷� ����, �ݺ��Ǵ� �޴����
		// ��ü ���α׷��� ���� ��Ʈ��(�帧����)
		// NameMenu��ü ����. �ʿ��� ��Ȳ�� �˸��� �޼ҵ带 ȣ��.
		// �ݺ� ��Ʈ��
		// �޴����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		NameMenu menu = new NameMenu();
		boolean flag = true;
		String newName, oldName;
		int choice;

		while (flag) {
			System.out.println("<�̸��޴�>");
			System.out.println("1.�߰� 2.���� 3.���� 4.�˻� 5.������");
			System.out.print("��ȣ==>");
			choice = Integer.parseInt(br.readLine());

			System.out.println();
			switch (choice) {
			case 1:
				System.out.print("�߰��̸�: ");
				menu.addName(br.readLine());
				System.out.println();
				break;
			case 2:
				System.out.print("�����̸�: ");
				menu.delName(br.readLine());
				System.out.println();
				break;
			case 3:
				System.out.print("�����̸�: ");
				oldName = br.readLine();
				System.out.print("�����̸�: ");
				newName = br.readLine();
				menu.editName(oldName, newName);
				System.out.println();
				break;
			case 4:
				menu.listName();
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
