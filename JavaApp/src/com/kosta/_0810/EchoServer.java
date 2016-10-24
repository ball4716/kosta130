package com.kosta._0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) {
		//����(���񽺸� �����ϴ� ��ü) ====> ���ϼ��� ����
		
		try {
			//1. �������� ��ü����
			//ServerSocket ss = new ServerSocket(int port);
			ServerSocket ss = new ServerSocket(5000);//0~65535
			//~1024��ȣ: �� �˷��� ��Ʈ ��ȣ(�̹� ������� ���ɼ��� ū ��ȣ)
			//���� �������� PC�� ip�ּҰ� �⺻���� host�ּҷ� ���
			
			System.out.println("���� ������....");
			
			//2. Ŭ���̾�Ʈ ���� ���
			Socket s = ss.accept();//���Ӵ�����, Ŭ���̾�Ʈ ���ӽ� ����!!
			
			InetAddress ia = s.getInetAddress();
			
			System.out.println("������ Ŭ���̾�Ʈ: ["+ia+"]");
			
			//4. ���Ͽ� ���� ����� ��ü ����
			//Ŭ���̾�Ʈ���� �޽��� ����
			OutputStream out = s.getOutputStream();//����ũ(������)
			//Ŭ���̾�Ʈ�� ���� �޽����� �о����
			InputStream is = s.getInputStream();//����Ŀ(�о����)
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			
			//6. Ŭ���̾�Ʈ�� ���� �޽����� �о����!! (read() ---> readLine())
			String fromClient = in.readLine();
			System.out.println("Ŭ���̾�Ʈ�� �����޽���"+fromClient);
			
			//7.Ŭ���̾�Ʈ���� �޽��� ����(���� ----> Ŭ���̾�Ʈ)
			out.write(("����� ip�ּҴ� ["+ia.getHostAddress()+"]�̰�, ���� ���� ���� ����̴ϴ�!!\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
