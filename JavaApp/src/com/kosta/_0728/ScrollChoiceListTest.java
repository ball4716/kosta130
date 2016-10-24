package com.kosta._0728;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Scrollbar;

public class ScrollChoiceListTest extends Frame{
	Label la;
	Scrollbar sb;
	Choice cho;
	List list;
	
	Panel topLeftp,bottomLeftp;
	
	public ScrollChoiceListTest(){
		la = new Label("빨강");
		
		//Scrollbar(int orientation) 0:수평, 1:수직
		//Scrollbar(int 방향, int value, int visible, int minimum, int maximum)
		//min: 최소좌표, max: 최대좌표값, value: 조절바의 시작위치, visible: 조절바의 가로너비
		
		sb = new Scrollbar(Scrollbar.HORIZONTAL,50,10,0,100);
		cho = new Choice();//접어서 펼치는 형태
			cho.add("서울");
			cho.add("대전");
			cho.add("대구");
			cho.add("부산");
			cho.add("광주");
			cho.add("울산");
			
		list = new List(2,true); //한번에 보여주는 형태
			list.add("야구");
			list.add("축구");
			list.add("농구");
			list.add("배구");
			list.add("탁구");
			list.add("족구");
			list.add("피구");
			list.add("구구");
			
		topLeftp = new Panel();
		topLeftp.setLayout(new BorderLayout(0,1));//Panel Layout 기본값: FlowLayout
		topLeftp.add("North", new Label());
		topLeftp.add("South", new Label());
		topLeftp.add("West",la);
		topLeftp.add("Center", sb);
		topLeftp.setBackground(Color.orange);
		
		bottomLeftp = new Panel();
		bottomLeftp.add(list);
		
		//this.Frame의 기본 레이아웃: BorderLayout
		setTitle("비주얼컴포넌트테스트");
		setLayout(new GridLayout(2,2));
		add(topLeftp);
		add(cho);
		//add(list);
		add(bottomLeftp);
		
		setSize(600, 200);
		setVisible(true);
	}//생성자
	
	public static void main(String[] args) {
		new ScrollChoiceListTest();
	}
}
