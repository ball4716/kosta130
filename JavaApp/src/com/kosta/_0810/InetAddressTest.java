package com.kosta._0810;

import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args) throws Exception{
		String host="naver.com";//��Ʈ��ũ ������ ���񽺸� �����ϴ�
		InetAddress ia = InetAddress.getByName(host);
		System.out.println("ȣ��Ʈ �̸�: "+ia.getHostName());
		System.out.println("ȣ��Ʈ �ּ�: "+ia.getHostAddress());
		System.out.println("============Ư�������ο� ���ε� �ּ�===========");
		InetAddress addrs[] = InetAddress.getAllByName(host);
		for (int i = 0; i < addrs.length; i++) {
			System.out.println("ȣ��Ʈ�ּҵ�:"+addrs[i].getHostAddress());
		}
		
		
	}
}
