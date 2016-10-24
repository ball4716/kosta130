package com.kosta._0722;

public class GoodLuckLottoTest {
	public static void main(String[] args) {
		GoodLuckLotto glo = new GoodLuckLotto();
		System.out.println("           ★★ 금주 행운의 로또번호 ★★");
		for(int i=0; i<5; i++){
			glo.inputLotto();
			glo.sortLotto();
			glo.printLotto(i);
			System.out.println();
		}
	}
}