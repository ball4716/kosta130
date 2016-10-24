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
	Panel p1, p2, p3;//카드 표현
	Panel bluep, redp, yellowp;
	
	Button bt1, bt2, bt3;
	
	CardLayout card; //생성자와 추가된 메소드(이벤트처리부)에서 사용하기 위해서
	
	public CardTest() {
		f = new Frame("카드레이아웃 테스트");
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		
		bluep = new Panel();
			bluep.setBackground(Color.blue);
		redp = new Panel();
			redp.setBackground(Color.red);
		yellowp = new Panel();
			yellowp.setBackground(Color.yellow);
		
		bt1 = new Button("다음");
		bt2 = new Button("다음");
		bt3 = new Button("다음");
		
		//카드구성하기
		p1.setLayout(new BorderLayout(0,10));//수평간격, 수직간격
			p1.add("Center", bluep);
			p1.add("South", bt1);
		
		p2.setLayout(new BorderLayout(0,10));//수평간격, 수직간격
			p2.add("Center", redp);
			p2.add("South", bt2);
		
		p3.setLayout(new BorderLayout(0,10));//수평간격, 수직간격
			p3.add("Center", yellowp);
			p3.add("South", bt3);
			
		//프레임에 카드레이아웃 설정후 카드(p1,p2,p3) 붙이기
		card = new CardLayout();
		f.setLayout(card);
			//f.add("별명alias", 붙일 컴포넌트);
			f.add("a1", p1);
			f.add("a2", p2); //p2의 별명을 문자열 "a2"로 정하겠다!!
			f.add("a3", p3);
			
		//card.show(Cointainer parent, String name);
		// 를     보여라              어디에                무엇을(별명)
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
	}//생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//obj: bt1, bt2, bt3의 레퍼런스
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
