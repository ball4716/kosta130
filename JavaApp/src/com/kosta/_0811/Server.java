package com.kosta._0811;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server extends Thread{// ���ϼ����غ�, Ŭ���̾��Ʈ ���� ���!!

	ServerSocket ss;
	Vector<Service> vc;//���ӵ� Ŭ���̾�Ʈ���� ����

	public Server() {
		try {
			ss = new ServerSocket(8000); // �ڽ��� ip�� ��õ� ��Ʈ��ȣ�� ���� ����!!
			vc = new Vector<>();
			start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// ������

	public void run() {// ������޼ҵ�: �ٸ� ���μ������� ������ ��ġ�� �ʰڴ�.
		try {
			System.out.println("���� ����....");
			
			while (true) {
				Socket s = ss.accept();
				//Ŭ���̾�Ʈ ���� ���
				//client�� new Socket(String host, int port) ���ً����� ���������� loop
				
				Service service = new Service(s, this);
				vc.add(service);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}

}
