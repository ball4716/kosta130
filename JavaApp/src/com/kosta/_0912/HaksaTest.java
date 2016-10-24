package com.kosta._0912;

import java.util.Scanner;

public class HaksaTest {
	HaksaDTO haksa;
	HaksaDAO haksaDao;
	Scanner sc;
	
	public HaksaTest() {
		haksaDao = new HaksaDAO();
		sc = new Scanner(System.in);
		int choiceMain;
		
		do{
		System.out.print("======== 메뉴 선택 ========\n"
						+"1. 등록\n"
						+"2. 찾기\n"
						+"3. 삭제\n"
						+"4. 전체 출력\n"
						+"---------------------------\n"
						+"0. 종료\n"
						+"---------------------------\n"
						+"번호를 선택해 주세요..");
		String ch_main = sc.next();
		choiceMain = Integer.parseInt(ch_main);
		
			while(choiceMain==1){
				System.out.print("======== 메뉴 선택 ========\n"
						+"1. 학생\n"
						+"2. 교수\n"
						+"3. 관리자\n"
						+"4. 이전메뉴\n"
						+"번호를 선택해 주세요..");
				String ch_plus = sc.next();
				int choicePlus = Integer.parseInt(ch_plus);
				
				if(choicePlus==1){
					//dto를 통해 dao에서 학생 정보 등록
					int jobno = 10;
					String job = haksaDao.selectJob(10);
					System.out.print("이름 : ");
					String insertName = sc.next();
					System.out.print("나이 : ");
					String age = sc.next();
					int insertAge = Integer.parseInt(age);
					System.out.print("학번 : ");
					String insertStuNum = sc.next();
					haksa = new HaksaDTO(insertName, insertAge, insertStuNum, jobno, job);
					haksaDao.insert(haksa);
				}else if(choicePlus==2){
					//dto를 통해 dao에서 교수 정보 등록
				}else if(choicePlus==3){
					//dto를 통해 dao에서 관리자 정보 등록
				}else{//4.이전메뉴 선택
					break;
				}
			}//등록메뉴
			
			while(choiceMain==2){
				System.out.println("찾을 이름을 선택해주세요.");
				System.out.print("이름 : ");
				String findName = sc.next();
				System.out.print("나이 : ");
				String age = sc.next();
				int findAge = Integer.parseInt(age);
				//얻은 정보를 바탕으로 dao에서 정보 추출후 하나 출력
				break;
			}//찾기메뉴
			
			while(choiceMain==3){
				System.out.println("삭제할 사람의 이름을 입력해주세요.");
				System.out.print("이름 : ");
				//dao를 이용하여 삭제
				break;
			}//삭제메뉴
			
			while(choiceMain==4){
				//dao를 이용하여 전체 출력
			}
			
		}while(choiceMain != 0);	
	}

	public static void main(String[] args) {
		new HaksaTest();
	}

}
