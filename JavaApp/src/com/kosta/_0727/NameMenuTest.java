package com.kosta._0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest {
	
	static int indexCount=0;

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
		String choiceStr;
		int choiceNum;

		while (flag) {
			System.out.println("<�̸��޴�>");
			System.out.println("1.�߰� 2.���� 3.���� 4.�˻� 5.������");
			System.out.print("��ȣ==>");
			choiceStr=br.readLine();
			if(!choiceStr.matches("[0-9]")){
				System.out.println("#��ȣ�� �Է��ϼ���!!\n");
				choiceNum = -1;
			}else{
				choiceNum = Integer.parseInt(choiceStr);
			}
			
			switch (choiceNum) {
			case 1:
				if(menu.indexFullCheck ==5){
					System.out.println("#�� �̻� �Է��� �� �����ϴ�\n"
							+ "\t�� �� �̻��� �̸��� ���� ������ �� �Է��ϼ���!!");
					break;
				}
				System.out.print("�߰��̸�: ");
				menu.addName(br.readLine());
				System.out.println();
				break;
			case 2:
				if(menu.indexFullCheck ==0){
					System.out.println("#�� �̻� ������ �� �����ϴ�\n"
							+ "\t�� �� �̻��� �̸��� ���� �߰��� �� �����ϼ���!!");
					break;
				}
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