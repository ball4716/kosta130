package com.kosta._0722;

import java.util.Arrays;
import java.util.Random;

public class ArraySortTest {
	int su[];
	Random r;
	
	//일차원배열 객체생성식: 자료형 배열명[]=new 자료형[배열크기];
	public ArraySortTest() {
		// TODO Auto-generated constructor stub
		su = new int[5];
		r = new Random();//해주지 않으면 NullPointerException 발생
		// r.nextInt(10); ->null.nextInt(10) : NullPointerException 발생
	}
	
	public void printArray(){
		System.out.print("[");
		for(int i=0; i<su.length; i++){//su.length:5
			System.out.print(su[i]);
			if(i<su.length-1)
				System.out.print(", ");
		}
		System.out.println("]");
	}//printArray
	
	public void inputArray(){//임의의 수(난수)를 배열에 입력
		//r.nextInt(bound) bound:5 ----> 0~4중 랜덤
		for (int i = 0; i < su.length; i++) {
			su[i] = r.nextInt(100) + 1; // 0~99 + 1 ----> 1~100
		}
	}
	
	public void sortArray(){//인덱스: 0 1 2 3 4
		int tmp;//임시 변수
		for(int i=0; i<su.length-1; i++){//비교 왼쪽데이터 인덱스 (0~3)
			for(int j=i+1; j<su.length; j++){//비교 오른쪽데이터 인덱스 (1~4)
				if(su[i]>su[j]){//오름차순정렬의 조건: 왼쪽데이터가 크다면
					this.swap(i,j);
				}
			}
		}
	}
	
	public void swap(int i,int j){
		int tmp;
		tmp = su[i];
		su[i] = su[j];
		su[j] = tmp;
	}
	
	public static void main(String[] args) {
		ArraySortTest ast = new ArraySortTest();
		ast.inputArray();
		System.out.print("정렬전 데이터:");
		ast.printArray();
		
		ast.sortArray();
		System.out.print("정렬후 데이터:");
		ast.printArray();
		
		int su[]={23,34,11,8,102,33};
		Arrays.sort(su);
		
		for(int i =0; i<su.length; i++){
			System.out.println(su[i]);
		}
		
		String names[]={"홍길동","길라임","김주원","이순신","김유신"};
		Arrays.sort(names);
		
		for(int i =0; i<names.length; i++){
			System.out.println(names[i]);
		}
	}
}
