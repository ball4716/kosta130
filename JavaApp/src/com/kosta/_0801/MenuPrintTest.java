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
	//선언
	Panel northPnl, centerPnl, southPnl;
	CheckboxGroup dayRadioGroup;
	Checkbox morningRadio, afternoonRadio, eveningRadio;
	Checkbox degibarCheck, subakbarCheck, bosukbarCheck;
	TextArea ta;
	Choice dayChoice;
	
	/*
	 1. 이벤트소스: morningRadio, afternoonRadio, eveningRadio
	             degibarCheck, subakbarCheck, bosukbarCheck
	    ----> Checkbox, Choice
	          addItemListener(ItemListener l)
	          addItemListener(ItemListener l)
	 2. 이벤트리스너
	    implements ItemListener
	    
	    ----> public void itemStateChanged(Item
	 */
		
	public MenuPrintTest() {
		//초기화
		northPnl = new Panel();
		centerPnl = new Panel();
		southPnl = new Panel();
		
		dayRadioGroup = new CheckboxGroup();
		morningRadio = new Checkbox("아침", dayRadioGroup, true);
		afternoonRadio = new Checkbox("점심", dayRadioGroup, false);
		eveningRadio = new Checkbox("저녁", dayRadioGroup, false);
		
		degibarCheck = new Checkbox("돼지바");
		subakbarCheck = new Checkbox("수박바");
		bosukbarCheck = new Checkbox("보석바");
		
		ta= new TextArea();
		
		dayChoice = new Choice();
		dayChoice.add(morningRadio.getLabel());
		dayChoice.add(afternoonRadio.getLabel());
		dayChoice.add(eveningRadio.getLabel());
		//배치
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
		});//익명 클래스 윈도우 닫기 버튼 작동
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {//이벤트 처리부
		Object ob = e.getSource();//이벤트를 발생시킨 소스의 레퍼런스 얻어오기
		
		if(ob == dayChoice){
			String item = dayChoice.getSelectedItem();//item: "아침" "점심" "저녁"
			if(item.equals("아침"))
				morningRadio.setState(true);
			else if(item.equals("점심"))
				afternoonRadio.setState(true);
			else
				eveningRadio.setState(true);
		}
		
		//기능 정의
		//setText(문자열) : 1. clear 2. 텍스트쓰기: 기존문자열 덮어쓰기
		//append(문자열) : 기존문자열에 이어쓰기
		
		//체크박스 : 상태(state)를 갖는 컴포넌트 : getState() setState(boolean)
		Checkbox cc = dayRadioGroup.getSelectedCheckbox();
		//현재 선택되어진 체크박스의 레퍼런스를 리턴
		//Checkbox cc = morningCheck/afternoonCheck/eveningCheck ;
		String label = cc.getLabel();
		
		ta.setText("\t    *** "+label+" ***\n\n"
				+"\t1. 돼지바 : "+degibarCheck.getState()+"\n"
				+"\t2. 수박바 : "+subakbarCheck.getState()+"\n"
				+"\t3. 보석바 : "+bosukbarCheck.getState()+"\n");
		
		dayChoice.select(label);
		
	}
	
	public static void main(String[] args) {
		new MenuPrintTest();
	}
}
