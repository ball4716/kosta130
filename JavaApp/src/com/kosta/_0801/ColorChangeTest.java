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
   //��ü����	
   Label la_red, la_blue, la_green;
   Scrollbar sb_red, sb_blue, sb_green;
   TextArea ta;
   
   /*
     <�̺�Ʈ ó��> : ��ũ�ѹٸ� ���������� �������� �����ض�~!!
     							setBackground(Color��ü);
     							setBackground(Color.�����ʵ��);
     							setBackground(new Color(red,green,blue);
    - �̺�Ʈ �ҽ� : sb_red, sb_blue, sb_green
        ----> Ŭ����: Scrollbar
          addAdjustmentListener(AdjustmentListener l)
                
    - �̺�Ʈ ������: AdjustmentListener(�������̽�)
        implements AdjustmentListener
        ----> void adjustmentBalueChanged(AdjustmentEvent e) {}
        
    - �����ڸ޼ҵ� ���: sb_red.addAdjustmentListener(this);
    */
   
   
   Panel leftp, redp, bluep, greenp;   
	
   public ColorChangeTest() {
	  //��ü���� 
	  la_red = new Label("����"); 
	  la_blue = new Label("�Ķ�"); 
	  la_green = new Label("�ʷ�"); 
	   
	  //sb_red = new Scrollbar(orientation, value, visible, minimum, maximum)
	  sb_red = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
	  sb_blue = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
	  sb_green = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
	
	  
	  ta = new TextArea();
	    ta.setBackground(Color.BLACK);
	     
	  redp = new Panel();
	    redp.setLayout(new BorderLayout());//��������
	    redp.add(la_red, "West");
	    redp.add(sb_red, "Center");
	    
	  greenp = new Panel();
		  greenp.setLayout(new BorderLayout());//��������
		  greenp.add(la_green, "West");
		  greenp.add(sb_green, "Center");
	    
	  bluep = new Panel();
		  bluep.setLayout(new BorderLayout());//��������
		  bluep.add(la_blue, "West");
		  bluep.add(sb_blue, "Center");
	  
	  leftp = new Panel();
	     leftp.setLayout(new GridLayout(5, 1, 0, 10));
	     leftp.add(new Label());
	     leftp.add(redp);
	     leftp.add(greenp);
	     leftp.add(bluep);
	     leftp.setBackground(Color.orange);
	     
	  setTitle("���ٲٱ�");
	  setLayout(new GridLayout(1,2));//���� 1�� �⺻
	  add(leftp);
	  add(ta);
	  
	  setSize(600,300);
	  setVisible(true);
	  
	  //������
	  sb_red.addAdjustmentListener(this);
	  sb_green.addAdjustmentListener(this);
	  sb_blue.addAdjustmentListener(this);
	 
   }//������
   
   @Override
   public void adjustmentValueChanged(AdjustmentEvent e) {
	   // ��� ����
	   int r = sb_red.getValue();
	   int g = sb_green.getValue();
	   int b = sb_blue.getValue();
	   
	   Color color;
	   color = new Color(r, g, b);
	   ta.setBackground(color);
	   //TextArea���ھ���
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
