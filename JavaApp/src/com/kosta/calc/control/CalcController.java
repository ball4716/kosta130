package com.kosta.calc.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kosta.calc.model.Calculator;
import com.kosta.calc.view.CalcView;

public class CalcController implements ActionListener{//����ž
	//����� ���
	CalcView view;
	
	/*
	   �ڡڡ�<��Ʈ�ѷ��� ����>
	   1. ����� ��û�� �м�
	   2. �並 ���� �Էµ� �����͸� ������
	   3. �𵨰�ü������
	   		-3_1. �޼ҵ�ȣ��
	   		-3_2. ������� ������ ����
	   4. ������(JFrame)�̵� : f1.setVisible(false); f2.setVisible(true);
	   
	     �߰�(�ɼ�): ��ȿ���˻�(�信�� ��ġ�� ���� ����)
	           : �츮�� ���� �������� �����Ͱ� �ԷµǾ���� Ȯ��.
	                   ��) int age;
	              --->�������� : 1~100
	              ---> 101 : ��ȿ���� ���� ������!!
	 */
	
	public CalcController() {
		view = new CalcView();
		
		view.bt_calc.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//if(e.getSource()==view.bt_calc){}//1.��� ��û�� ���Դٸ�~!!
		int su1 = Integer.parseInt(view.tf_su1.getText());//2.
		int su2 = Integer.parseInt(view.tf_su2.getText());//2.
		String oper = (String)view.combo.getSelectedItem();//2.
		//String oper = view.combo.getSelectedItem().toString();
		
		//Calculator cal = new Calculator(int su1, int su2, String oper);
		Calculator cal = new Calculator(su1, su2, oper);//3.
		String str = cal.getResult();//3_1, 3_2
		
		view.la_result.setText(str);
	}
	public static void main(String[] args) {
		new CalcController();
	}
}
