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
		System.out.print("======== �޴� ���� ========\n"
						+"1. ���\n"
						+"2. ã��\n"
						+"3. ����\n"
						+"4. ��ü ���\n"
						+"---------------------------\n"
						+"0. ����\n"
						+"---------------------------\n"
						+"��ȣ�� ������ �ּ���..");
		String ch_main = sc.next();
		choiceMain = Integer.parseInt(ch_main);
		
			while(choiceMain==1){
				System.out.print("======== �޴� ���� ========\n"
						+"1. �л�\n"
						+"2. ����\n"
						+"3. ������\n"
						+"4. �����޴�\n"
						+"��ȣ�� ������ �ּ���..");
				String ch_plus = sc.next();
				int choicePlus = Integer.parseInt(ch_plus);
				
				if(choicePlus==1){
					//dto�� ���� dao���� �л� ���� ���
					int jobno = 10;
					String job = haksaDao.selectJob(10);
					System.out.print("�̸� : ");
					String insertName = sc.next();
					System.out.print("���� : ");
					String age = sc.next();
					int insertAge = Integer.parseInt(age);
					System.out.print("�й� : ");
					String insertStuNum = sc.next();
					haksa = new HaksaDTO(insertName, insertAge, insertStuNum, jobno, job);
					haksaDao.insert(haksa);
				}else if(choicePlus==2){
					//dto�� ���� dao���� ���� ���� ���
				}else if(choicePlus==3){
					//dto�� ���� dao���� ������ ���� ���
				}else{//4.�����޴� ����
					break;
				}
			}//��ϸ޴�
			
			while(choiceMain==2){
				System.out.println("ã�� �̸��� �������ּ���.");
				System.out.print("�̸� : ");
				String findName = sc.next();
				System.out.print("���� : ");
				String age = sc.next();
				int findAge = Integer.parseInt(age);
				//���� ������ �������� dao���� ���� ������ �ϳ� ���
				break;
			}//ã��޴�
			
			while(choiceMain==3){
				System.out.println("������ ����� �̸��� �Է����ּ���.");
				System.out.print("�̸� : ");
				//dao�� �̿��Ͽ� ����
				break;
			}//�����޴�
			
			while(choiceMain==4){
				//dao�� �̿��Ͽ� ��ü ���
			}
			
		}while(choiceMain != 0);	
	}

	public static void main(String[] args) {
		new HaksaTest();
	}

}
