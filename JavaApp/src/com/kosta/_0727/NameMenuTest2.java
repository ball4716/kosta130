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
			System.out.println("<이름메뉴>");
			System.out.println("1.추가 2.삭제 3.수정 4.검색 5.나가기");
			System.out.print("번호==>");
			choiceStr=br.readLine();
			if(!choiceStr.matches("[0-9]+")){
				System.out.println("#번호만 입력하세요!!\n");
				choiceNum = -1;
			}else{
				choiceNum = Integer.parseInt(choiceStr);
			}
			
			switch (choiceNum) {
			case 1:
				if(menu.names.size() == 5){
					System.out.println("#더 이상 삭제할 수 없습니다\n"
							+ "\t한 개 이상의 이름을 먼저 추가한 후 삭제하세요!!");
					break;
				}
				System.out.print("추가이름: ");
				menu.insert(br.readLine());
				System.out.println();
				break;
			case 2:
				System.out.print("삭제이름: ");
				menu.delete(br.readLine());
				System.out.println();
				break;
			case 3:
				System.out.print("수정이름: ");
				oldName = br.readLine();
				System.out.print("변경이름: ");
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