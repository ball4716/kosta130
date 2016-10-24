package com.kosta._0726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest {
	
	static int indexCount=0;

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
		String choiceStr;
		int choiceNum;

		while (flag) {
			do{
				flag=false;
				System.out.println("<이름메뉴>");
				System.out.println("1.추가 2.삭제 3.수정 4.검색 5.나가기");
				System.out.print("번호==>");
				choiceStr=br.readLine();
				if(!choiceStr.matches("[0-9]")){
					System.out.println("#번호만 입력하세요!!\n");
					flag=true;
				}
			}while(flag);
			
			choiceNum = Integer.parseInt(choiceStr);
			
			System.out.println();
			switch (choiceNum) {
			case 1:
				if(menu.indexFullCheck ==5){
					System.out.println("#더 이상 입력할 수 없습니다\n"
							+ "\t한 개 이상의 이름을 먼저 삭제한 후 입력하세요!!");
					flag=true;
					break;
				}
				System.out.print("추가이름: ");
				menu.addName(br.readLine());
				System.out.println();
				flag=true;
				break;
			case 2:
				System.out.print("삭제이름: ");
				menu.delName(br.readLine());
				System.out.println();
				flag=true;
				break;
			case 3:
				System.out.print("수정이름: ");
				oldName = br.readLine();
				System.out.print("변경이름: ");
				newName = br.readLine();
				menu.editName(oldName, newName);
				System.out.println();
				flag = true;
				break;
			case 4:
				menu.listName();
				System.out.println();
				flag = true;
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