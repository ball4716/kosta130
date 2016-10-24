package com.kosta._0810;

import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args) throws Exception{
		String host="naver.com";//네트워크 망에서 서비스를 제공하는
		InetAddress ia = InetAddress.getByName(host);
		System.out.println("호스트 이름: "+ia.getHostName());
		System.out.println("호스트 주소: "+ia.getHostAddress());
		System.out.println("============특정도메인에 매핑된 주소===========");
		InetAddress addrs[] = InetAddress.getAllByName(host);
		for (int i = 0; i < addrs.length; i++) {
			System.out.println("호스트주소들:"+addrs[i].getHostAddress());
		}
		
		
	}
}
