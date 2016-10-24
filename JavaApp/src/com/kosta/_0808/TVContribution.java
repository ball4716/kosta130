package com.kosta._0808;

public class TVContribution {
	public static void main(String[] args) {
		//5���� �������� (��ٸ��� �ʴ�) ������
		Account account = new Account();
		/*
		Customer c1 = new Customer(account);
		Customer c2 = new Customer(account);
		...
		c1.start();
		c2.start();
		...
		*/
		
		Customer customers[] = new Customer[5];
		for (int i = 0; i < customers.length; i++) {
			customers[i] = new Customer(account);//�����尴ü����
			customers[i].start();//������ run()����
		}
		
		try {
			for (int i = 0; i < customers.length; i++) {
				//customers[i] : ������
				customers[i].join();
				//�����尡 �۾��� ����ĥ������ main()�޼ҵ尡 ��ٸ���.
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("�� ��ݾ�:"+account.getTotal());
	}
}
