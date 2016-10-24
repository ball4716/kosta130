package com.kosta._0802;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ItemMoveTest extends Frame implements ActionListener{
	List list_l, list_r;
	TextField tf_l,tf_r;
	Button bt_r,bt_r_all,bt_l,bt_l_all;
	Panel pnl_L, pnl_R, pnl_C;
	
	
	public ItemMoveTest() {
		//초기화
		list_l = new List();
		list_r = new List();
		tf_l = new TextField();
		tf_r = new TextField();
		bt_r = new Button("▷");
		bt_r_all = new Button("▶");
		bt_l = new Button("◁");
		bt_l_all = new Button("◀");
		
		pnl_L = new Panel();
		pnl_R = new Panel();
		pnl_C = new Panel();
		
		//배치
		pnl_L.setLayout(new BorderLayout());
		pnl_L.add("Center",list_l);
		pnl_L.add("South", tf_l);
		
		pnl_R.setLayout(new BorderLayout());
		pnl_R.add("Center", list_r);
		pnl_R.add("South", tf_r);
		
		pnl_C.setLayout(new GridLayout(6,3,10,10));
		for(int i=0; i<16; i++){
			if(i==4||i==7||i==10||i==13){
				if(i==4)
					pnl_C.add(bt_r);
				else if(i==7)
					pnl_C.add(bt_r_all);
				else if(i==10)
					pnl_C.add(bt_l);
				else if(i==13)
					pnl_C.add(bt_l_all);
				continue;
			}
			pnl_C.add(new Label(""));
		}
		//널레이아웃에 붙을 컴포넌트들은 좌표(x, y)와 크기(가로,세로)가 필요함!!
		/*bt_r.setBounds(40, 55, 50, 50);
		bt_r_all.setBounds(40, 115, 50, 50);
		bt_l.setBounds(40, 175, 50, 50);
		bt_l_all.setBounds(40, 235, 50, 50);
		
		pnl_C.setLayout(null);
		pnl_C.add(bt_r);
		pnl_C.add(bt_r_all);
		pnl_C.add(bt_l);
		pnl_C.add(bt_l_all);*/
		pnl_C.setBackground(Color.orange);
		
		setTitle("ItemMove");
		setLayout(new GridLayout(1,3));
		add(pnl_L);
		add(pnl_C);
		add(pnl_R);
		
		setSize(400,400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//TextField에서 엔터를 쳤을때
		tf_l.addActionListener(this);
		tf_r.addActionListener(this);
		
		//Button을 클릭했을때
		bt_r.addActionListener(this);
		bt_r_all.addActionListener(this);
		bt_l.addActionListener(this);
		bt_l_all.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		/*
		 <공통 기능 정의>
		 1. 데이터 가져오기 get
		 2. 데이터 복사하기 add
		 3. 기존 데이터를 삭제(움직이는 효과 표현) remove
		 */
		
		if(obj==tf_l){
			if(!tf_l.getText().equals(""))
				list_l.add(tf_l.getText());
			tf_l.setText("");
		}else if(obj==tf_r){
			if(!tf_r.getText().equals(""))
				list_r.add(tf_r.getText());
			tf_r.setText("");
		}//텍스트 필드 입력 설정
		
		if(obj==bt_r && list_l.isIndexSelected(list_l.getSelectedIndex())){
			list_r.add(list_l.getSelectedItem());
			list_l.remove(list_l.getSelectedItem());
		}else if(obj == bt_r_all){
			for (int i = 0; i < list_l.getItemCount(); i++) {
				list_r.add(list_l.getItem(i));
			}
			list_l.removeAll();
		}else if(obj == bt_l && list_r.isIndexSelected(list_r.getSelectedIndex())){
			list_l.add(list_r.getSelectedItem());
			list_r.remove(list_r.getSelectedItem());
		}else if(obj == bt_l_all){
			for (int i = 0; i < list_r.getItemCount(); i++) {
				list_l.add(list_r.getItem(i));
			}
			list_r.removeAll();
		}
	}
	
	public static void main(String[] args) {
		new ItemMoveTest();
	}

}
