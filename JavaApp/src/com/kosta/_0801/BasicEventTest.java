package com.kosta._0801;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//API���� ---> Button ---> addActionListener();
public class BasicEventTest extends Frame implements ActionListener{
	Button bt,bt2; //null // ��ü(������Ʈ, �����̳�)����
	int count;//=0;
	
	public BasicEventTest(){
		bt = new Button("�ȳ�");
		bt2 = new Button("������");
		
		//�����̳�.add(������Ʈ);
		setLayout(new FlowLayout());
		add(bt);
		add(bt2);
		
		setSize(300,300);
		setVisible(true);
		
		//������ ��� (�ҽ��� ó����)
		bt.addActionListener(this);
		//bt��ư�� Ŭ�������� �� Ŭ������ ��ġ�� actionPerformed()�� ȣ���ϰڴ�!!
		bt2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//�̺�Ʈ ó����
		//�������
		
		//����: ActionEvent�Ķ���Ϳ��� �̺�Ʈ �ҽ��� ���۷����� ����!!
		Object ob = e.getSource();
		//ù��° ��ư Ŭ���� : Object ob = bt;
		//�ι�° ��ư Ŭ���� : Object ob = bt2;
		
		if(ob == bt){//��ư bt�� Ŭ��������
			//if()���� �߰��� ����: ���� �ٸ� ������Ʈ�� ������ �޼ҵ带 ȣ���ϰ�
			//�޼ҵ� ������ ���� �ٸ� ����� �����ϰ��� ������ �̸� ����.
			count++;
			setTitle("�ȳ�"+count);
			
		}else if(ob == bt2){//��ư bt2�� Ŭ��������
			System.exit(0);
		}
		
	}//actionPerformed
	
	public static void main(String[] args) {
		new BasicEventTest();
	}

}
