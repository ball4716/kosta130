package com.kosta._0729;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HelloEventTest extends Frame implements ActionListener, ItemListener{
	TextField tf;
	CheckboxGroup cbg;
	Checkbox cb1,cb2,cb3;
	Button bt_hello, bt_clear, bt_exit;
	Panel topPnl, centerPnl, botPnl; 
	
/*
 <�̺�Ʈ ó��> - ������Ʈ�� ��� �ο�
 
 1. �̺�Ʈ�ҽ�(EventSource) ����.
 	(~�Ҷ�)  ---> Type��Ƴ���
 	
 	Button bt_hello
 	Button bt_clear
 	Button bt_exit
 	
 2. �̺�Ʈ�ҽ��� ������ Listener�������̽�	
 
 	Action + Listener : ActionListener
 					  -----> implements ActionListener
 					  		 ������ ���(�������̽��� ����� �޼ҵ带 ����)
 					  -----> public void actionPerformed(ActionEvent e){
 					  
 					  		 }-----> �� �̺�Ʈ �ڵ鷯(�̺�Ʈ ó����)
 					  		 
 					  		  -----> ��ɺο�
 					  		 
 3. ������(������)��� : ���? setVisible(true); �ؿ�
    -----> �̺�Ʈ�ҽ��� �̺�Ʈó���θ� ����
    -----> ���? �̺�Ʈ�ҽ�.add + �������̽���(�ڵ鷯��ġ);
    			bt_hello.addActionListener(this);
    			
 ������
   class A implements ActionListener{
   		public void actionPerformed(ActionEvent e){}
   }
 */

/*
 	<�̺�Ʈó��> - ������Ʈ�� ����� �ο�
 1. �̺�Ʈ�ҽ�
    - üũ�ڽ��� Ŭ��������
    Checkbox : �̺�Ʈ�ҽ�
      ---->API����----->    add~Listener();
                 ----->    addItemListener(ItemListener l);
                 ----->    Item�̺�Ʈ ����
 2. �����ʸ� ���
      implements ItemListener
      -----> void itemStateChanged(ItemEvent e) {} : �̺�Ʈ �ڵ鷯
      
 3. ������ ���
      cb.addItemListener(this);
 */
	
	public HelloEventTest() {
		tf = new TextField(20);
		//�ؽ�Ʈ�ʵ忡 ���� ������� ����
		tf.setEditable(false);
		
		cbg = new CheckboxGroup();
		cb1 = new Checkbox("�ڹ��ʱ�", cbg, true);
		cb2 = new Checkbox("�ڹ��߱�", cbg, false);
		cb3 = new Checkbox("�ڹٰ��", cbg, false);
		
		bt_hello = new Button("�ȳ�");
		bt_clear = new Button("�����");
		bt_exit = new Button("����");
		
		topPnl = new Panel();
		centerPnl = new Panel();
		botPnl = new Panel();
		
		
		topPnl.setLayout(new FlowLayout());
		topPnl.setBackground(Color.orange);
		topPnl.add(tf);
		
		centerPnl.setLayout(new GridLayout(3,1));
		centerPnl.add(cb1);
		centerPnl.add(cb2);
		centerPnl.add(cb3);
		
		botPnl.setLayout(new FlowLayout());
		botPnl.setBackground(Color.pink);
		botPnl.add(bt_hello);
		botPnl.add(bt_clear);
		botPnl.add(bt_exit);
		
		//������ ����
		setTitle("�ȳ� �̺�Ʈ");
		setLayout(new BorderLayout());
		add("North",topPnl);
		add("Center",centerPnl);
		add("South",botPnl);
		
		setSize(500,500);
		setVisible(true);
		
		//������,�����ڵ��
		//�̺�Ʈ�ҽ�.add������(�ڵ鷯��ġ);
		bt_hello.addActionListener(this);
		bt_clear.addActionListener(this);
		bt_exit.addActionListener(this);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		//��ư�� ���������� ��� ����
		Object ob = e.getSource();//�̺�Ʈ�ҽ��� ���۷����� ����!!
		//���� �ȳ��ư�� Ŭ���ߴٸ� Object ob = bt_hello;
		//���� ������ư�� Ŭ���ߴٸ� Object ob = bt_clear;
		//���� �����ư�� Ŭ���ߴٸ� Object ob = bt_exit;
		
		/*
		 ������Ʈ
		   �Ӽ���� ----> ������=getXXX();
		   �Ӽ����� ----> setXXX(������);
		   
		 TextField tf;// text==String==label
		 	tf.getText();
		 	tf.setText("�ڹ��ʱ޾ȳ�~!!");
		 	
		 �ؽ�Ʈ�ʵ忡 ���� ����� ��� ����
		 	tf.setText(null);//NullPointerException �߻� ���ɼ�!
		 	tf.setText(""); //����
		 */
		
		if(ob == bt_hello){
			//CheckboxGroup : cb1, cb2, cb3��� ---> ���� ������ �Ѱ�!!
			Checkbox cc = cbg.getSelectedCheckbox();//cc == cb1,cb2,cb3���۷����� �ϳ�
			//Checkbox cc = cb1;
			tf.setText(cc.getLabel()+"�ȳ�~!!");
						//�ڹ��ʱ�
			/*
			if(cb1.getState()) //
				tf.setText("�ڹ��ʱ޾ȳ�~!!");
			else if(cb2.getState())
				tf.setText("�ڹ��߱޾ȳ�~!!");
			else
				tf.setText("�ڹٰ�޾ȳ�~!!");
				*/
		}else if(ob == bt_clear){
			tf.setText("");
		}else{
			System.exit(0);
		}
		
	}//actionPerformed
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		tf.setText(cbg.getSelectedCheckbox().getLabel()+"�ȳ�~!!*^-^*");
		
	}//itemStateChanged
	
	public static void main(String[] args) {
		//main()�� ������ Ŭ���� : JavaApplication
		//�޸��Ҵ�� ��� Ŭ���� : Object
		//�޸��Ҵ�� Ŭ���� �� Ư�� Ŭ���� : Instance
		//��) A�ν��Ͻ�
		new HelloEventTest();
	}

}
