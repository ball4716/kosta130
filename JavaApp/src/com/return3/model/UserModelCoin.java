package com.return3.model;

public class UserModelCoin {
	int coin = 0;

	public int getCoin() {//사용자의 투입금액 얻기
		return coin;
	}

	public void setCoin(int selectCoin) {//투입금액 증가
		this.coin = selectCoin;
	}

	public void insertCoin(int selectCoin) {// 동전에 따라 투입된 금액을 반환하는 메소드\
		this.coin = coin + selectCoin;
	}

}
