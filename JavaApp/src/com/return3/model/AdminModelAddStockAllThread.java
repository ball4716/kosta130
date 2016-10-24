package com.return3.model;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;

public class AdminModelAddStockAllThread extends Thread {

	AdminModelStock admin_model_stock;
	DefaultTableModel dtm;
	JLabel label;
	int idx;
	int max_range;
	int sleep_time;
	boolean is_drink;
	JProgressBar bar_drink;
	int[] cup_or_drink;

	public AdminModelAddStockAllThread(AdminModelStock admin_model_stock, DefaultTableModel dtm, JLabel label, int idx,
			int max_range, int sleep_time, boolean is_drink, JProgressBar bar_drink) {
		this.admin_model_stock = admin_model_stock;
		this.dtm = dtm;
		this.label = label;
		this.idx = idx;
		this.max_range = max_range;
		this.sleep_time = sleep_time;
		this.is_drink = is_drink;
		this.bar_drink = bar_drink;

		start();
	}

	synchronized public void run() {
		try {
			if(!is_drink)
				cup_or_drink = admin_model_stock.getCup_stock();
			else
				cup_or_drink = admin_model_stock.getDrink_stock();
			while (cup_or_drink[idx] < max_range) {
				int i = Integer.parseInt("" + dtm.getValueAt(0, idx));
				dtm.setValueAt(++i, 0, idx);
				if (!is_drink) {
					int[] cup_stock = admin_model_stock.getCup_stock();
					cup_stock[idx] = Integer.parseInt("" + dtm.getValueAt(0, idx));
					admin_model_stock.setCup_stock(cup_stock);
					label.setText("" + dtm.getValueAt(0, idx)+"°³");
				} else {
					int[] drink_stock = admin_model_stock.getDrink_stock();
					drink_stock[idx] = Integer.parseInt("" + dtm.getValueAt(0, idx));
					admin_model_stock.setDrink_stock(drink_stock);
					label.setText("" + dtm.getValueAt(0, idx)+"cc");
				}
				if (is_drink)
					bar_drink.setValue(Integer.parseInt("" + dtm.getValueAt(0, idx)));
				Thread.sleep(sleep_time);
			}
			admin_model_stock.fileWrite();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
