package com.return3.model;

public class UserModelCoin {
	int coin = 0;

	public int getCoin() {//������� ���Աݾ� ���
		return coin;
	}

	public void setCoin(int selectCoin) {//���Աݾ� ����
		this.coin = selectCoin;
	}

	public void insertCoin(int selectCoin) {// ������ ���� ���Ե� �ݾ��� ��ȯ�ϴ� �޼ҵ�\
		this.coin = coin + selectCoin;
	}

}
