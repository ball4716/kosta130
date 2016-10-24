package com.kosta._0808;

public class Account {//모금함
	private int total;//저금통
	
	public synchronized void deposit(int account){//모금기능
		total += account;//외부에서 전달받은 금액을 저금통에 저금
	}
	
	public int getTotal(){//인가받은 사람에게 모금 총금액을 알려주기
		return total;
	}
}
