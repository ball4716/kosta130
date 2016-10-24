package com.return3.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AdminModelStock {
	int drink_stock[];
	int cup_stock[];
	int money;
	Scanner sc;
	String str[] = new String[10];

	public AdminModelStock() {
		int drink_stock[] = new int[4];
		int cup_stock[] = new int[3];
		int money=0;
		
		fileRead(drink_stock,cup_stock,money);
	}

	
	public int[] getDrink_stock() {
		return drink_stock;
	}
	
	public void setDrink_stock(int[] drink_stock) {
		this.drink_stock = drink_stock;
	}
	
	public int[] getCup_stock() {
		return cup_stock;
	}
	
	public void setCup_stock(int[] cup_stock) {
		this.cup_stock = cup_stock;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void fileRead(int[] drink_stock, int[] cup_stock, int money) {
		int n;
		try {
			sc = new Scanner(new FileInputStream("input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			drink_stock[i] = sc.nextInt();
		}

		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			cup_stock[i] = sc.nextInt();
		}

		money = sc.nextInt();
		
		this.drink_stock = drink_stock;
		this.cup_stock = cup_stock;
		this.money = money;
	}

	public void fileWrite() {
		try {
			FileWriter fw = new FileWriter("input.txt");
			str[0] = "4\r\n";
			for (int i = 1; i < 5; i++) {
				if (i == 4)
					str[i] = "" + this.drink_stock[i - 1] + "\r\n";
				else
					str[i] = "" + this.drink_stock[i - 1] + " ";

			}
			str[5] = "3\r\n";
			for (int i = 6; i < 9; i++) {
				if (i == 8)
					str[i] = "" + this.cup_stock[i - 6] + "\r\n";
				else
					str[i] = "" + this.cup_stock[i - 6] + " ";
			}
			str[9] = "" + this.money;

			for (int i = 0; i < 10; i++) {
				fw.write(str[i].replace("", ""));
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
