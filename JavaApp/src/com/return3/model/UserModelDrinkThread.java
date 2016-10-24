package com.return3.model;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;

import com.return3.view.UserView;

public class UserModelDrinkThread extends Thread {

	UserView user_view;
	AdminModelStock admin_model_stock;
	DefaultTableModel dtm;
	int cup_size;
	JLabel label_drink;
	int min_range;// 0으로 초기화
	JProgressBar bar_drink;
	int idx;
	int loop_num;

	public UserModelDrinkThread(AdminModelStock admin_model_stock, DefaultTableModel dtm, int cup_size,
			JLabel label_drink, JProgressBar bar_drink, int idx, UserView user_view) {
		this.admin_model_stock = admin_model_stock;
		this.dtm = dtm;
		this.cup_size = cup_size;
		this.label_drink = label_drink;
		this.min_range = 500;
		this.bar_drink = bar_drink;
		this.idx = idx;
		this.loop_num = 0;
		
		this.user_view = user_view;
		
		start();
	}

	@Override
	public void run() {
		try {
			if(cup_size == 0)
				loop_num=500;
			else if(cup_size == 1)
				loop_num=1000;
			else if(cup_size == 2)
				loop_num=1500;
			while (loop_num-->0 && admin_model_stock.getDrink_stock()[idx] > min_range) {
				int i = Integer.parseInt("" + dtm.getValueAt(0, idx));
				dtm.setValueAt(--i, 0, idx);
				int[] drink_stock = admin_model_stock.getDrink_stock();
				drink_stock[idx] = Integer.parseInt("" + dtm.getValueAt(0, idx));
				admin_model_stock.setDrink_stock(drink_stock);
				label_drink.setText("" + dtm.getValueAt(0, idx) + "cc");
				bar_drink.setValue(Integer.parseInt("" + dtm.getValueAt(0, idx)));
				if(cup_size == 0)
					Thread.sleep(40);
				else if(cup_size == 1)
					Thread.sleep(20);
				else if(cup_size == 2)
					Thread.sleep(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		admin_model_stock.fileWrite();
	}
}