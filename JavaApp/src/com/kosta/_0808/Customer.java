package com.kosta._0808;

public class Customer extends Thread{//(��������)������ Ŭ����
	Account account;
	
	public Customer(Account account) {
		this.account = account;
	}
	@Override
	public void run() {
		try {
			for(int i=1; i<201; i++){
				Thread.sleep(50);//0.05�� ���� ���
				account.deposit(1000);
				//����ڸ�
				System.out.println("������ ["+ getName()+"]"+i+"ȸ");
				if(account.getTotal()>=500000) break;
				//��� ��ǥ�ݾ�: 50����
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
