package com.kosta._0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{//������ ���� ����� ����!!
					  //�Է�: in.readLine()  ���: out.write(���޸޽���)
	BufferedReader in;
	OutputStream out; //���� ���� �Է�, ��� ��ü ����!!
	
	Vector<Service> vc;
	
	String nickName; //��? Ŭ���̾�Ʈ�� ��ȭ���� ����
	
/*	<�츮�鸸�� ���� ��űԾ�-protocol>
	100: ��������

	200: ��ȭ������
	250: ��ȭ������
	
	300: ��ȭ����

	400: ��ȭ����

	900: ���α׷�����*/

	
	public Service(Socket s, Server server) {
		try {
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = s.getOutputStream();
			
			//server = new Server();
			//this.server = server;//new Server();
			vc = server.vc;
			
			start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Ŭ���̾�Ʈ�� sendTF�� ���� ������ �޽��� �б�
	@Override
	public void run() {
		try {
			while(true){
				String fromMsg = in.readLine(); //"�ȳ��ϼ���" "@@�ȳ��ϼ���"
				System.out.println(fromMsg);
				//"100|�浿"  "300|�ȳ��ϼ���"  "400|���"
				String [] dataArr =fromMsg.split("\\|");
				//'|'�� �������� ���ڿ� �и� ===> ���ڿ��迭
				
				int protocol = Integer.parseInt(dataArr[0]);
				switch(protocol){
					case 100://��ȭ������
						nickName = dataArr[1];
						break;
					case 200://��ȭ������
						break;
					case 250://��ȭ������
						break;
					case 300://��ȭ����
						messageAll("["+nickName+"]�� "+dataArr[1]);//[�浿]�� �ȳ��ϼ���
						break;
					case 400://��ȭ����
						nickName = dataArr[1];
						break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//run
	
	public void messageAll(String msg){//��ü Ŭ���̾�Ʈ���� �޽����� ������!!
		for(int i=0; i<vc.size(); i++){//���Ϳ��� �����Ǵ� Ŭ���̾�Ʈ ����ŭ
			try {
				Service ser = vc.get(i);
				ser.messageTo(msg);
			} catch (IOException e) {
				System.out.println("Ŭ���̾�Ʈ ���� ����!!");
				//������ ���� Ŭ���̾�Ʈ�� ���Ϳ��� ����
				vc.remove(i--);//1�� ���������Ƿ� �ε����� 1�����ؾ���
			}
		}
	}
	
	public void messageTo(String msg) throws IOException{//�Ѱ��� Ŭ���̾�Ʈ���� �޽����� ������(�����޽�������)
		out.write((msg+"\n").getBytes());
	}

}
