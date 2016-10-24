package com.kosta._0728;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTest extends Frame implements ActionListener{
	Button bt;
	int cnt;
	
	public EventTest() {
		
		bt = new Button("나버튼");
		/*
		 <이벤트처리> - 컴포넌트에 기능을 부여하는 것
		 
		 1. 이벤트를 발생시키는 컴포넌트를 찾기 (~했을때)
		    - 버튼을 클릭했을때~
		    - 버튼: 이벤트소스(★Event Source)
		 2. 이벤트소스에 적용할 Event분석
		    Button ----> ActionEvent 적용
		    
		 3. 이벤트리스너(interface) 만들기!!
		    - ActionEvent에서 Event 날리기
		      Action
		    - Listener 붙이기
		      Action + Listener : ActionListener
		      
		 4. 클래스에 구현
		    - implements ActionListener
		      (구현의 약속)     
		    ----> public void atcionPerformed(ActionEvent e){
		             //이벤트 발생시 실행할 코드(기능)!!
		              
		          }//이벤트 핸들러(이벤트처리부)
		 5. EventSource ---- EventHandler
		        소스와 처리부를 연결!!(감시자 등록)
                       
                       방법) 이벤트소스.add + ActionListener(이벤트처리부의 위치);
                       bt.addActionlistener(this);
		 */
		
		setLayout(new FlowLayout());//상단에서 가운데 정렬
		add(bt);
		
		setTitle("이벤트");
		setSize(300,300);
		setVisible(true);
		
		//Button bt:이벤트소스
		//(소스와 핸들러)연결자 등록
		bt.addActionListener(this);
	}//생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {///이벤트 처리부
		//버튼에 추가할 기능 구현!!
		
		//1.콘솔에 안녕출력
		//System.out.println("안녕~!!");
		
		//2.프로그램종료
		//System.exit(0);// 0또는 양수: 정상적인 종료
		
		//3. 안녕을 프레임 타이틀에 출력
		cnt++;
		setTitle("안녕-"+cnt);
	}
	
	public static void main(String[] args) {
		new EventTest();
	}

}
