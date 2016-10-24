package com.kosta._0801;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CardTest implements ActionListener{
	Frame f;
	Panel p1, p2, p3;//ī�� ǥ��
	Panel bluep, redp, yellowp;
	
	Button bt1, bt2, bt3;
	
	CardLayout card; //�����ڿ� �߰��� �޼ҵ�(�̺�Ʈó����)���� ����ϱ� ���ؼ�
	
	public CardTest() {
		f = new Frame("ī�巹�̾ƿ� �׽�Ʈ");
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		
		bluep = new Panel();
			bluep.setBackground(Color.blue);
		redp = new Panel();
			redp.setBackground(Color.red);
		yellowp = new Panel();
			yellowp.setBackground(Color.yellow);
		
		bt1 = new Button("����");
		bt2 = new Button("����");
		bt3 = new Button("����");
		
		//ī�屸���ϱ�
		p1.setLayout(new BorderLayout(0,10));//���򰣰�, ��������
			p1.add("Center", bluep);
			p1.add("South", bt1);
		
		p2.setLayout(new BorderLayout(0,10));//���򰣰�, ��������
			p2.add("Center", redp);
			p2.add("South", bt2);
		
		p3.setLayout(new BorderLayout(0,10));//���򰣰�, ��������
			p3.add("Center", yellowp);
			p3.add("South", bt3);
			
		//�����ӿ� ī�巹�̾ƿ� ������ ī��(p1,p2,p3) ���̱�
		card = new CardLayout();
		f.setLayout(card);
			//f.add("����alias", ���� ������Ʈ);
			f.add("a1", p1);
			f.add("a2", p2); //p2�� ������ ���ڿ� "a2"�� ���ϰڴ�!!
			f.add("a3", p3);
			
		//card.show(Cointainer parent, String name);
		// ��     ������              ���                ������(����)
		//card.show(f, "a3");
		
		f.setSize(400,600);
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
	}//������
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//obj: bt1, bt2, bt3�� ���۷���
		if(obj==bt1){
			card.show(f, "a2");
		}else if(obj==bt2){
			card.show(f, "a3");
		}else{
			card.show(f, "a1");
		}
	}
	
	public static void main(String[] args) {
		new CardTest();
	}

}
