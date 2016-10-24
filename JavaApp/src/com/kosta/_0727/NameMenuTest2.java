package com.kosta._0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		NameMenu2 menu = new NameMenu2();
		boolean flag = true;
		String newName, oldName;
		String choiceStr;
		int choiceNum;

		while (flag) {
			System.out.println("<�̸��޴�>");
			System.out.println("1.�߰� 2.���� 3.���� 4.�˻� 5.������");
			System.out.print("��ȣ==>");
			choiceStr=br.readLine();
			if(!choiceStr.matches("[0-9]+")){
				System.out.println("#��ȣ�� �Է��ϼ���!!\n");
				choiceNum = -1;
			}else{
				choiceNum = Integer.parseInt(choiceStr);
			}
			
			switch (choiceNum) {
			case 1:
				if(menu.names.size() == 5){
					System.out.println("#�� �̻� ������ �� �����ϴ�\n"
							+ "\t�� �� �̻��� �̸��� ���� �߰��� �� �����ϼ���!!");
					break;
				}
				System.out.print("�߰��̸�: ");
				menu.insert(br.readLine());
				System.out.println();
				break;
			case 2:
				System.out.print("�����̸�: ");
				menu.delete(br.readLine());
				System.out.println();
				break;
			case 3:
				System.out.print("�����̸�: ");
				oldName = br.readLine();
				System.out.print("�����̸�: ");
				newName = br.readLine();
				menu.update(oldName, newName);
				System.out.println();
				break;
			case 4:
				menu.selectAll();
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