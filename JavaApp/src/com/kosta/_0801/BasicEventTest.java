package com.kosta._0801;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//API문서 ---> Button ---> addActionListener();
public class BasicEventTest extends Frame implements ActionListener{
	Button bt,bt2; //null // 객체(컴포넌트, 컨테이너)선언
	int count;//=0;
	
	public BasicEventTest(){
		bt = new Button("안녕");
		bt2 = new Button("나가기");
		
		//컨테이너.add(컴포넌트);
		setLayout(new FlowLayout());
		add(bt);
		add(bt2);
		
		setSize(300,300);
		setVisible(true);
		
		//연결자 등록 (소스와 처리부)
		bt.addActionListener(this);
		//bt버튼을 클릭했을때 현 클래스에 위치한 actionPerformed()를 호출하겠다!!
		bt2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//이벤트 처리부
		//기능정의
		
		//구분: ActionEvent파라미터에는 이벤트 소스의 레퍼런스가 전달!!
		Object ob = e.getSource();
		//첫번째 버튼 클릭시 : Object ob = bt;
		//두번째 버튼 클릭시 : Object ob = bt2;
		
		if(ob == bt){//버튼 bt를 클릭했을때
			//if()무이 추가된 이유: 서로 다른 컴포넌트가 동일한 메소드를 호출하고
			//메소드 내에서 서로 다른 기능을 구현하고자 했을때 이를 구분.
			count++;
			setTitle("안녕"+count);
			
		}else if(ob == bt2){//버튼 bt2를 클릭했을때
			System.exit(0);
		}
		
	}//actionPerformed
	
	public static void main(String[] args) {
		new BasicEventTest();
	}

}
