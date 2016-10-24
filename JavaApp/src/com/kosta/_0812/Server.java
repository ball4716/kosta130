package com.kosta._0812;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server extends Thread{//���ϼ����غ�, Ŭ���̾�Ʈ ���� ���!!
	
	ServerSocket ss;	
	
	Vector<Service> allVC;//���ӵ� ��� Ŭ���̾�Ʈ���� ����(��ü�����)
	Vector<Service> waitVC;//���Ǿ��� Ŭ���̾�Ʈ���� ����(���ǻ����) ��
	
	Vector<Room> roomVC;//������ ���� ����  
	//RoomŬ������ �Ӽ� ====> Vector<Service> myRoom; (������) ��
	
	
	public Server() {
	  try {
		ss = new ServerSocket(8282); //�ڽ��� ip�� ��õ� ��Ʈ��ȣ�� ��������!!
		allVC = new Vector<>();
		waitVC = new Vector<>();
		roomVC = new Vector<>();
		
	    start();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	}//������
	
	public void run(){//������޼ҵ�: �ٸ� ���μ������� ������ ��ġ�� �ʰڴ�
	  try {
		  
		  System.out.print("���� ����.....");
		while(true){			  
			Socket s = ss.accept(); 
			 //Ŭ���̾�Ʈ ���� ��� : new Socket(host,port); �� ����!!				
			Service service = new Service(s,this);//Service�����ڿ��� ���ϰ�ü����!!
			 allVC.add(service);//��ü�����
			 waitVC.add(service);//���ǻ����
		  }
	   } catch (IOException e) {
		e.printStackTrace();
	  }
	}//run
	
	
	
	
    public static void main(String[] args) {
		new Server();
	}
}
