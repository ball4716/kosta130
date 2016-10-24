/**
 * 
 */
package com.kosta._0725;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Hyunyoung
 *
 */
public class GoodLuckLotto2 {
	int lotto[];
	Random r;
	
	public GoodLuckLotto2() {
		// TODO Auto-generated constructor stub
		lotto = new int[6];//6자리 정수
		r = new Random();
	}
	
	public void printLotto(){
		Arrays.sort(lotto);
		for (int i = 0; i < lotto.length; i++) {
			System.out.printf("%2d",lotto[i]);
			if(i<lotto.length-1)System.out.print(", ");
		}
		System.out.println();
	}
	
	public void createLotto(){
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = r.nextInt(45)+1; //1~45 난수를 저장
			if(duplicateCheck(i))
				i--;
		}
		
	}//번호 생성
	
	public boolean duplicateCheck(int idx){//idx: 난수가 저장된 인덱스
		//중복된 수 발견시 true 리턴
		//1-->0   2-->1,0   3-->2,1,0   4-->3,2,1,0
		for (int i = idx-1; i > -1; i--) {
			if(lotto[idx] == lotto[i]) return true;//중복된 수 발견시
		}
		return false;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("★★금주 행운의 로또번호★★");
		for (int i = 0; i < 6; i++) {
			GoodLuckLotto2 good = new GoodLuckLotto2();
			
			System.out.print(i+1+"회: ");
			good.createLotto();
			good.printLotto();
		}
	}

}
