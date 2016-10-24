package com.return3.model;

import java.awt.Image;

import javax.swing.JLabel;

public class UserModelCupThread extends Thread {

	AdminModelStock admin_model_stock;
	JLabel la_size;
	Image en, dis;
	int idx;
	int x,y;

	public UserModelCupThread(AdminModelStock admin_model_stock, JLabel la_size, Image en, Image dis, int idx) {
		this.admin_model_stock = admin_model_stock;
		this.la_size = la_size;
		this.en = en;
		this.dis = dis;
		this.idx = idx;
	}

	@Override
	public void run() {
		try {
			if (idx == 0) {
				//la_size.setLocation((int) la_size.getLocation().getX(), (int) la_size.getLocation().getY());
				Thread.sleep(10000);
			} else if (idx == 1) {
				//la_size.setLocation((int) la_size.getLocation().getX(), (int) la_size.getLocation().getY());
				Thread.sleep(15000);
			} else if (idx == 2) {
				//la_size.setLocation((int) la_size.getLocation().getX(), (int) la_size.getLocation().getY());
				Thread.sleep(20000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (idx == 0)
				la_size.setLocation(650, 500);
			else if (idx == 1)
				la_size.setLocation(750, 480);
			else if (idx == 2)
				la_size.setLocation(870, 460);

		}
	}
}
