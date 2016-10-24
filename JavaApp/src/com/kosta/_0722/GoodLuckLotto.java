package com.kosta._0722;

import java.util.Random;

public class GoodLuckLotto {
	int lotto[];
	int tmp;
	Random rand;
	
	
	public GoodLuckLotto() {
		// TODO Auto-generated constructor stub
		lotto = new int[6];
		rand = new Random();
		tmp=0;
	}
	
	public void inputLotto() {
		for(int i =0; i<lotto.length; i++){
			lotto[i] = rand.nextInt(45)+1;
		}
		for(int i =0; i<lotto.length-1;i++){
			for(int j=i+1; j<lotto.length;j++){
				if(lotto[i]==lotto[j])
					this.inputLotto();
			}
		}//ban same number
	}//inputLotto end
	
	public void sortLotto(){
		for(int i=0; i<lotto.length-1; i++){
			for(int j=i+1; j<lotto.length; j++){
				if(lotto[i]>lotto[j])
					this.swap(i,j);
			}
		}
	}//sortLotto end

	private void swap(int i, int j) {
		// TODO Auto-generated method stub
		tmp=lotto[i];
		lotto[i]=lotto[j];
		lotto[j]=tmp;
	}//swap end
	
	public void printLotto(int i){
		System.out.print(i+1+"ȸ: ");
		for(int j=0; j<lotto.length; j++){
			System.out.printf("%2d",lotto[j]);
			if(j<lotto.length-1)
				System.out.print(", ");
		}
	}
	
}//GoodluckLotto end