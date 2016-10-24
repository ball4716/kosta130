package com.kosta._0728;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTest extends Frame implements ActionListener{
	Button bt;
	int cnt;
	
	public EventTest() {
		
		bt = new Button("����ư");
		/*
		 <�̺�Ʈó��> - ������Ʈ�� ����� �ο��ϴ� ��
		 
		 1. �̺�Ʈ�� �߻���Ű�� ������Ʈ�� ã�� (~������)
		    - ��ư�� Ŭ��������~
		    - ��ư: �̺�Ʈ�ҽ�(��Event Source)
		 2. �̺�Ʈ�ҽ��� ������ Event�м�
		    Button ----> ActionEvent ����
		    
		 3. �̺�Ʈ������(interface) �����!!
		    - ActionEvent���� Event ������
		      Action
		    - Listener ���̱�
		      Action + Listener : ActionListener
		      
		 4. Ŭ������ ����
		    - implements ActionListener
		      (������ ���)     
		    ----> public void atcionPerformed(ActionEvent e){
		             //�̺�Ʈ �߻��� ������ �ڵ�(���)!!
		              
		          }//�̺�Ʈ �ڵ鷯(�̺�Ʈó����)
		 5. EventSource ---- EventHandler
		        �ҽ��� ó���θ� ����!!(������ ���)
                       
                       ���) �̺�Ʈ�ҽ�.add + ActionListener(�̺�Ʈó������ ��ġ);
                       bt.addActionlistener(this);
		 */
		
		setLayout(new FlowLayout());//��ܿ��� ��� ����
		add(bt);
		
		setTitle("�̺�Ʈ");
		setSize(300,300);
		setVisible(true);
		
		//Button bt:�̺�Ʈ�ҽ�
		//(�ҽ��� �ڵ鷯)������ ���
		bt.addActionListener(this);
	}//������
	
	@Override
	public void actionPerformed(ActionEvent e) {///�̺�Ʈ ó����
		//��ư�� �߰��� ��� ����!!
		
		//1.�ֿܼ� �ȳ����
		//System.out.println("�ȳ�~!!");
		
		//2.���α׷�����
		//System.exit(0);// 0�Ǵ� ���: �������� ����
		
		//3. �ȳ��� ������ Ÿ��Ʋ�� ���
		cnt++;
		setTitle("�ȳ�-"+cnt);
	}
	
	public static void main(String[] args) {
		new EventTest();
	}

}
