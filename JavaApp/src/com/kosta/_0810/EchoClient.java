package com.kosta._0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) {
		//Ŭ���̾�Ʈ(���񽺿�û��ü): ���ϼ��� ��û
		
		try {
			//3. ������ ������ �õ�
			//Socket s = new Socket(String host, int port);
			Socket s = new Socket("192.168.0.133", 5000);
			System.out.println("�������� ����~!!");
			
			//4. ���Ͽ� ���� ����°�ü ����
			//�������� �����͸� �����ϱ�
			//������ ���� �����͸� ������
			OutputStream out = s.getOutputStream();//����ũ(������)
			InputStream is = s.getInputStream();//����Ŀ(�о����)
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			
			//�������� �޽��� ����!!
			String str="����� ������ ��Ҿ��\n";
			//5.
			out.write(str.getBytes()); //write(int c), write(byte[])
			
			//8. (������ ������ �޽��� �б�)���� -----> Ŭ���̾�Ʈ
			String fromServer = in.readLine();
			System.out.println("from Server MSG: "+fromServer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
