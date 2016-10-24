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
 <이벤트 처리> - 컴포넌트에 기능 부여
 
 1. 이벤트소스(EventSource) 선정.
 	(~할때)  ---> Type잡아내기
 	
 	Button bt_hello
 	Button bt_clear
 	Button bt_exit
 	
 2. 이벤트소스에 적용할 Listener인터페이스	
 
 	Action + Listener : ActionListener
 					  -----> implements ActionListener
 					  		 구현의 약속(인터페이스에 선언된 메소드를 구현)
 					  -----> public void actionPerformed(ActionEvent e){
 					  
 					  		 }-----> ★ 이벤트 핸들러(이벤트 처리부)
 					  		 
 					  		  -----> 기능부여
 					  		 
 3. 감시자(연결자)등록 : 어디에? setVisible(true); 밑에
    -----> 이벤트소스와 이벤트처리부를 연결
    -----> 어떻게? 이벤트소스.add + 인터페이스명(핸들러위치);
    			bt_hello.addActionListener(this);
    			
 ※참고
   class A implements ActionListener{
   		public void actionPerformed(ActionEvent e){}
   }
 */

/*
 	<이벤트처리> - 컴포넌트에 기능을 부여
 1. 이벤트소스
    - 체크박스를 클릭했을때
    Checkbox : 이벤트소스
      ---->API문서----->    add~Listener();
                 ----->    addItemListener(ItemListener l);
                 ----->    Item이벤트 적용
 2. 리스너를 등록
      implements ItemListener
      -----> void itemStateChanged(ItemEvent e) {} : 이벤트 핸들러
      
 3. 연결자 등록
      cb.addItemListener(this);
 */
	
	public HelloEventTest() {
		tf = new TextField(20);
		//텍스트필드에 대한 쓰기금지 설정
		tf.setEditable(false);
		
		cbg = new CheckboxGroup();
		cb1 = new Checkbox("자바초급", cbg, true);
		cb2 = new Checkbox("자바중급", cbg, false);
		cb3 = new Checkbox("자바고급", cbg, false);
		
		bt_hello = new Button("안녕");
		bt_clear = new Button("지우기");
		bt_exit = new Button("종료");
		
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
		
		//프레임 설정
		setTitle("안녕 이벤트");
		setLayout(new BorderLayout());
		add("North",topPnl);
		add("Center",centerPnl);
		add("South",botPnl);
		
		setSize(500,500);
		setVisible(true);
		
		//감시자,연결자등록
		//이벤트소스.add리스너(핸들러위치);
		bt_hello.addActionListener(this);
		bt_clear.addActionListener(this);
		bt_exit.addActionListener(this);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		//버튼을 눌렀을때의 기능 정의
		Object ob = e.getSource();//이벤트소스의 레퍼런스를 리턴!!
		//만약 안녕버튼을 클릭했다면 Object ob = bt_hello;
		//만약 지우기버튼을 클릭했다면 Object ob = bt_clear;
		//만약 종료버튼을 클릭했다면 Object ob = bt_exit;
		
		/*
		 컴포넌트
		   속성얻기 ----> 데이터=getXXX();
		   속성설정 ----> setXXX(데이터);
		   
		 TextField tf;// text==String==label
		 	tf.getText();
		 	tf.setText("자바초급안녕~!!");
		 	
		 텍스트필드에 대한 지우기 기능 정의
		 	tf.setText(null);//NullPointerException 발생 가능성!
		 	tf.setText(""); //권장
		 */
		
		if(ob == bt_hello){
			//CheckboxGroup : cb1, cb2, cb3등록 ---> 이중 선택은 한개!!
			Checkbox cc = cbg.getSelectedCheckbox();//cc == cb1,cb2,cb3레퍼런스중 하나
			//Checkbox cc = cb1;
			tf.setText(cc.getLabel()+"안녕~!!");
						//자바초급
			/*
			if(cb1.getState()) //
				tf.setText("자바초급안녕~!!");
			else if(cb2.getState())
				tf.setText("자바중급안녕~!!");
			else
				tf.setText("자바고급안녕~!!");
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
		tf.setText(cbg.getSelectedCheckbox().getLabel()+"안녕~!!*^-^*");
		
	}//itemStateChanged
	
	public static void main(String[] args) {
		//main()을 포함한 클래스 : JavaApplication
		//메모리할당된 모든 클래스 : Object
		//메모리할당된 클래스 중 특정 클래스 : Instance
		//예) A인스턴스
		new HelloEventTest();
	}

}
