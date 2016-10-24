package com.kosta._0725;

import java.util.Random;

public class GoodLuckLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 임의의 난수를 이용 1~45까지의 중복되지 않는 숫자 6개 생성
		
		int lotto[]=new int[6]; //{3,0,0,0,0,0}
		
		Random r = new Random();
		
		lotto[0] = r.nextInt(10)+1;//0~44 + 1 : 1~45
		
		do{
			lotto[1] = r.nextInt(45)+1;//0~44 +1 : 1~45
		}while(lotto[1] == lotto[0]);
		
		do{
			lotto[1] = r.nextInt(45)+1;//0~44 +1 : 1~45
		}while(lotto[2] == lotto[1] || lotto[2] == lotto[0]);
		
		do{
			lotto[1] = r.nextInt(45)+1;//0~44 +1 : 1~45
		}while(lotto[3] == lotto[2] || lotto[3] == lotto[1] || lotto[4] == lotto[0]);
		
		do{
			lotto[1] = r.nextInt(45)+1;//0~44 +1 : 1~45
		}while(lotto[4] == lotto[3] || lotto[4] == lotto[2] || lotto[4] == lotto[1] || lotto[4] == lotto[0]);
	}

}
