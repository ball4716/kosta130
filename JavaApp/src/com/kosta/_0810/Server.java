package com.kosta._0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{//�ܺ� Ŭ����: Ŭ���̾�Ʈ ���� ���
	
	ServerSocket ss;
	Vector<Service> v;//�����ϴ� Ŭ���̾�Ʈ���� ����
	
	public Server() {
		try {
			ss = new ServerSocket(6000);//������ �����Ű�� IP, ��õ� 6000��
			v = new Vector<>();
			new Thread(this).start();
					//this ---> run()�޼ҵ��� ��ġ
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		//���ü��ళ�� : Thread
		System.out.println("Server Start.....");
		while(true){//�������� ������ ǥ��!!
			//----> ���� �������� �𸣴� Ŭ���̾�Ʈ�� ���� ��⸦ ���� �ݺ�!!
			try {
				Socket s = ss.accept();//Ŭ���̾�Ʈ ��� �޼ҵ�!!
				//���� s: ���ӵ� Ŭ���̾�Ʈ�� Socket�� ����
				Service ser = new Service(s);
				
				v.add(ser);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//run
	
	//============================================
	class Service extends Thread{//���� Ŭ����: �޽��� ����� ����
		OutputStream out;//���� -----> Ŭ���̾�Ʈ
		BufferedReader in;//���� <----- Ŭ���̾�Ʈ
		
		public Service(Socket s) {
			try {
				out = s.getOutputStream();
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				
				start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//������
		public void run(){
			try {
				while(true){
					String fromClient = in.readLine();//6.Ŭ���̾�Ʈ�� ���� �޽��� �о����
					
					//String toClient = "���� ���� ���� ����̴ϴ�~^^@@@";
					//out.write(toClient.getBytes());
					messageAll(fromClient);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//run
			
	}//����Ŭ���� Service END
	
	public void messageAll(String msg){//��ü ���� Ŭ���̾�Ʈ���� �޽����� ����
		for (int i = 0; i < v.size(); i++) {
			try {
				Service service = v.get(i);
				service.out.write((msg+"\n").getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//����(Service)�� ǥ��
	}
	//============================================
	public static void main(String[] args) {
		new Server();
	}
}
