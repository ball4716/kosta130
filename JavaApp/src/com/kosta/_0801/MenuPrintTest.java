package com.kosta._0801;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuPrintTest extends Frame implements ItemListener{
	//����
	Panel northPnl, centerPnl, southPnl;
	CheckboxGroup dayRadioGroup;
	Checkbox morningRadio, afternoonRadio, eveningRadio;
	Checkbox degibarCheck, subakbarCheck, bosukbarCheck;
	TextArea ta;
	Choice dayChoice;
	
	/*
	 1. �̺�Ʈ�ҽ�: morningRadio, afternoonRadio, eveningRadio
	             degibarCheck, subakbarCheck, bosukbarCheck
	    ----> Checkbox, Choice
	          addItemListener(ItemListener l)
	          addItemListener(ItemListener l)
	 2. �̺�Ʈ������
	    implements ItemListener
	    
	    ----> public void itemStateChanged(Item
	 */
		
	public MenuPrintTest() {
		//�ʱ�ȭ
		northPnl = new Panel();
		centerPnl = new Panel();
		southPnl = new Panel();
		
		dayRadioGroup = new CheckboxGroup();
		morningRadio = new Checkbox("��ħ", dayRadioGroup, true);
		afternoonRadio = new Checkbox("����", dayRadioGroup, false);
		eveningRadio = new Checkbox("����", dayRadioGroup, false);
		
		degibarCheck = new Checkbox("������");
		subakbarCheck = new Checkbox("���ڹ�");
		bosukbarCheck = new Checkbox("������");
		
		ta= new TextArea();
		
		dayChoice = new Choice();
		dayChoice.add(morningRadio.getLabel());
		dayChoice.add(afternoonRadio.getLabel());
		dayChoice.add(eveningRadio.getLabel());
		//��ġ
		northPnl.setLayout(new GridLayout(2, 3));
		northPnl.add(morningRadio);
		northPnl.add(afternoonRadio);
		northPnl.add(eveningRadio);
		northPnl.add(degibarCheck);
		northPnl.add(subakbarCheck);
		northPnl.add(bosukbarCheck);
		northPnl.setBackground(Color.orange);
		
		southPnl.setLayout(new FlowLayout());
		southPnl.add(dayChoice);
		southPnl.setBackground(Color.pink);
		
		setLayout(new BorderLayout());
		add("North", northPnl);
		add("Center", ta);
		add("South", southPnl);
		
		
		setSize(300,300);
		setVisible(true);
		
		eventUp();
	}
	
	private void eventUp(){
		morningRadio.addItemListener(this);
		afternoonRadio.addItemListener(this);
		eveningRadio.addItemListener(this);
		
		degibarCheck.addItemListener(this);
		subakbarCheck.addItemListener(this);
		bosukbarCheck.addItemListener(this);
		
		dayChoice.addItemListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});//�͸� Ŭ���� ������ �ݱ� ��ư �۵�
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {//�̺�Ʈ ó����
		Object ob = e.getSource();//�̺�Ʈ�� �߻���Ų �ҽ��� ���۷��� ������
		
		if(ob == dayChoice){
			String item = dayChoice.getSelectedItem();//item: "��ħ" "����" "����"
			if(item.equals("��ħ"))
				morningRadio.setState(true);
			else if(item.equals("����"))
				afternoonRadio.setState(true);
			else
				eveningRadio.setState(true);
		}
		
		//��� ����
		//setText(���ڿ�) : 1. clear 2. �ؽ�Ʈ����: �������ڿ� �����
		//append(���ڿ�) : �������ڿ��� �̾��
		
		//üũ�ڽ� : ����(state)�� ���� ������Ʈ : getState() setState(boolean)
		Checkbox cc = dayRadioGroup.getSelectedCheckbox();
		//���� ���õǾ��� üũ�ڽ��� ���۷����� ����
		//Checkbox cc = morningCheck/afternoonCheck/eveningCheck ;
		String label = cc.getLabel();
		
		ta.setText("\t    *** "+label+" ***\n\n"
				+"\t1. ������ : "+degibarCheck.getState()+"\n"
				+"\t2. ���ڹ� : "+subakbarCheck.getState()+"\n"
				+"\t3. ������ : "+bosukbarCheck.getState()+"\n");
		
		dayChoice.select(label);
		
	}
	
	public static void main(String[] args) {
		new MenuPrintTest();
	}
}
