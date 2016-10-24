package com.kosta._0801;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ColorChangeTest extends Frame implements AdjustmentListener{
   //객체선언	
   Label la_red, la_blue, la_green;
   Scrollbar sb_red, sb_blue, sb_green;
   TextArea ta;
   
   /*
     <이벤트 처리> : 스크롤바를 조정했을때 바탕색을 변경해라~!!
     							setBackground(Color객체);
     							setBackground(Color.색갈필드명);
     							setBackground(new Color(red,green,blue);
    - 이벤트 소스 : sb_red, sb_blue, sb_green
        ----> 클래스: Scrollbar
          addAdjustmentListener(AdjustmentListener l)
                
    - 이벤트 리스너: AdjustmentListener(인터페이스)
        implements AdjustmentListener
        ----> void adjustmentBalueChanged(AdjustmentEvent e) {}
        
    - 연결자메소드 등록: sb_red.addAdjustmentListener(this);
    */
   
   
   Panel leftp, redp, bluep, greenp;   
	
   public ColorChangeTest() {
	  //객체생성 
	  la_red = new Label("빨강"); 
	  la_blue = new Label("파랑"); 
	  la_green = new Label("초록"); 
	   
	  //sb_red = new Scrollbar(orientation, value, visible, minimum, maximum)
	  sb_red = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
	  sb_blue = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
	  sb_green = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
	
	  
	  ta = new TextArea();
	    ta.setBackground(Color.BLACK);
	     
	  redp = new Panel();
	    redp.setLayout(new BorderLayout());//방위정렬
	    redp.add(la_red, "West");
	    redp.add(sb_red, "Center");
	    
	  greenp = new Panel();
		  greenp.setLayout(new BorderLayout());//방위정렬
		  greenp.add(la_green, "West");
		  greenp.add(sb_green, "Center");
	    
	  bluep = new Panel();
		  bluep.setLayout(new BorderLayout());//방위정렬
		  bluep.add(la_blue, "West");
		  bluep.add(sb_blue, "Center");
	  
	  leftp = new Panel();
	     leftp.setLayout(new GridLayout(5, 1, 0, 10));
	     leftp.add(new Label());
	     leftp.add(redp);
	     leftp.add(greenp);
	     leftp.add(bluep);
	     leftp.setBackground(Color.orange);
	     
	  setTitle("색바꾸기");
	  setLayout(new GridLayout(1,2));//가로 1행 기본
	  add(leftp);
	  add(ta);
	  
	  setSize(600,300);
	  setVisible(true);
	  
	  //연결자
	  sb_red.addAdjustmentListener(this);
	  sb_green.addAdjustmentListener(this);
	  sb_blue.addAdjustmentListener(this);
	 
   }//생성자
   
   @Override
   public void adjustmentValueChanged(AdjustmentEvent e) {
	   // 기능 구현
	   int r = sb_red.getValue();
	   int g = sb_green.getValue();
	   int b = sb_blue.getValue();
	   
	   Color color;
	   color = new Color(r, g, b);
	   ta.setBackground(color);
	   //TextArea글자쓰기
	   //1. setText(String text) - TextArea, TextField
	   //ta.setText("r="+r+", g="+g+", b="+b);
	   //2. append(String text) - TextArea
	   ta.append("r="+r+", g="+g+", b="+b+"\n");
	   //System.out.println("r="+r+", g="+g+", b="+b);
	   
   }
   
   public static void main(String[] args) {
	   new ColorChangeTest();
   }

}
