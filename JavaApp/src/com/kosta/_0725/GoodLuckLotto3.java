package com.kosta._0725;

import java.util.Arrays;
import java.util.Random;

public class GoodLuckLotto3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int lotto[]=new int[45]; //{3,0,0,0,0,0}
		
		Random r = new Random();
		
		for (int i = 0; i < lotto.length; i++) {
			lotto[i]=i+1;
		}
		
		//¹øÈ£¼¯±â
		int temp;
		int randIdx;
		for (int i = 0; i < lotto.length; i++) {
			randIdx = r.nextInt(44)+1;
			temp = lotto[0];
			lotto[0] = lotto[randIdx];
			lotto[randIdx] = temp;
		}
		
		//Arrays.sort(lotto);
		
		for (int i = 0; i < 6; i++) {
			System.out.println("lotto["+i+"]="+lotto[i]);
		}
	}

}
