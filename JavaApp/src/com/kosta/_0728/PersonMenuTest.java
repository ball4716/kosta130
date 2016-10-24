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
			System.out.println("<사람메뉴>");
			System.out.println("1.추가 2.검색 3.수정 4.삭제");
			System.out.print("번호입력==> ");
			choiceStr=br.readLine();
			choiceNum = Integer.parseInt(choiceStr);
			System.out.println();
			
			switch (choiceNum) {
			case 1:
				System.out.print("이름: ");
				 insertName=br.readLine();
				System.out.print("나이: ");
				 insertAge=Integer.parseInt(br.readLine());
				System.out.print("직업: ");
				 insertJob=br.readLine();
				 
				//세개의 관련있는 데이터들을 하나의 이름으로 정의
				ip=new Person(insertName,insertAge,insertJob);
				menu.insert(ip);
				System.out.println();
				break;
			case 2:
				menu.select();
				System.out.println();
				break;
			case 3:
				System.out.print("수정할 번호: ");
				updateIdx = Integer.parseInt(br.readLine())-1;
				System.out.print("나이: ");
				updateAge = Integer.parseInt(br.readLine());
				System.out.print("직업: ");
				updateJob = br.readLine();
				updateName = menu.persons.get(updateIdx).getName();
				
				//						name, age, job
				//Person p = new Person(null, age, job);//수정할 사람 정보
				//up=new Person(updateName,updateAge,updateJob);
				up=new Person();
				up.setAge(updateAge);
				up.setJob(updateJob);
				
				menu.update(updateIdx, up);
				System.out.println();
				break;
			case 4:
				System.out.print("삭제할 번호: ");
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
