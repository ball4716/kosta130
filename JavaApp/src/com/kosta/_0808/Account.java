package com.kosta._0808;

public class Account {//�����
	private int total;//������
	
	public synchronized void deposit(int account){//��ݱ��
		total += account;//�ܺο��� ���޹��� �ݾ��� �����뿡 ����
	}
	
	public int getTotal(){//�ΰ����� ������� ��� �ѱݾ��� �˷��ֱ�
		return total;
	}
}
