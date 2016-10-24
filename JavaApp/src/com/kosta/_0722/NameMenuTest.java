package com.kosta._0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest {

	public static void main(String[] args) throws IOException {
		// 프로그램 제어, 반복되는 메뉴출력
		// 전체 프로그램에 대한 컨트롤(흐름제어)
		// NameMenu객체 생성. 필요한 상황에 알맞은 메소드를 호출.
		// 반복 컨트롤
		// 메뉴출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		NameMenu menu = new NameMenu();
		boolean flag = true;
		String newName, oldName;
		int choice;

		while (flag) {
			System.out.println("<이름메뉴>");
			System.out.println("1.추가 2.삭제 3.수정 4.검색 5.나가기");
			System.out.print("번호==>");
			choice = Integer.parseInt(br.readLine());

			System.out.println();
			switch (choice) {
			case 1:
				System.out.print("추가이름: ");
				menu.addName(br.readLine());
				System.out.println();
				break;
			case 2:
				System.out.print("삭제이름: ");
				menu.delName(br.readLine());
				System.out.println();
				break;
			case 3:
				System.out.print("수정이름: ");
				oldName = br.readLine();
				System.out.print("변경이름: ");
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
