package com.return3.hash_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.event.MouseInputAdapter;

import com.return3.hash_model.NumberHashmapModel;
import com.return3.hash_view.AddNumberView;
import com.return3.hash_view.ListNumberView;
import com.return3.hash_view.MainNumberView;
import com.return3.hash_view.UpdateNumberView;

public class MainController extends MouseAdapter implements ActionListener {
	MainNumberView number_view;
	ListNumberView list_number_view;
	AddNumberView add_number_view;
	UpdateNumberView up_number_view;
	NumberHashmapModel number_hashmap_model;
	Iterator<String> iter;
	boolean flag = true;

	public MainController() {
		number_view = new MainNumberView();
		list_number_view = new ListNumberView();
		add_number_view = new AddNumberView();
		up_number_view = new UpdateNumberView();

		number_hashmap_model = new NumberHashmapModel();

		eventUp();
	}

	public void eventUp() {
		// ����ȭ�� ��ư��
		for (int i = 0; i < number_view.number_button.length; i++) {
			number_view.number_button[i].addActionListener(this);
		}
		number_view.add_button.addActionListener(this);
		number_view.del_button.addActionListener(this);
		number_view.bot_button.addActionListener(this);

		// �˾� ��ư��
		number_view.new_btn.addActionListener(this);
		number_view.update_btn.addActionListener(this);
		number_view.cancel_btn.addActionListener(this);

		// ����Ʈ������
		list_number_view.search_field.addMouseListener(this);
		for (int i = 0; i < list_number_view.key_button.length; i++)
			list_number_view.key_button[i].addMouseListener(this);
		list_number_view.up_button.addActionListener(this);

		// �߰�������
		for (int i = 0; i < add_number_view.key_button.length; i++)
			add_number_view.key_button[i].addMouseListener(this);
		add_number_view.add_submit_button.addActionListener(this);
		add_number_view.cancel_button.addActionListener(this);

		// ��ȭ��ȣ�� ������
		list_number_view.bot_button.addActionListener(this);
		list_number_view.del_button.addActionListener(this);
		list_number_view.addMouseListener(this);

		// ������Ʈ ������
		up_number_view.cancel_button.addActionListener(this);
		up_number_view.up_submit_button.addActionListener(this);
		for (int i = 0; i < up_number_view.key_button.length; i++) {
			up_number_view.key_button[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// ��ȭ��ȣ �Է� ȭ�� ��ư
		if (obj == number_view.number_button[0]) {// 1��Ŭ��
			addHipen(true);
			number_view.number_field.setText(number_view.number_field.getText() + "1");
		} else if (obj == number_view.number_button[1]) {// 2��Ŭ��
			addHipen(true);
			number_view.number_field.setText(number_view.number_field.getText() + "2");
		} else if (obj == number_view.number_button[2]) {// 3��Ŭ��
			addHipen(true);
			number_view.number_field.setText(number_view.number_field.getText() + "3");
		} else if (obj == number_view.number_button[3]) {// 4��Ŭ��
			addHipen(true);
			number_view.number_field.setText(number_view.number_field.getText() + "4");
		} else if (obj == number_view.number_button[4]) {// 5��Ŭ��
			addHipen(true);
			number_view.number_field.setText(number_view.number_field.getText() + "5");
		} else if (obj == number_view.number_button[5]) {// 6��Ŭ��
			addHipen(true);
			number_view.number_field.setText(number_view.number_field.getText() + "6");
		} else if (obj == number_view.number_button[6]) {// 7��Ŭ��
			addHipen(true);
			number_view.number_field.setText(number_view.number_field.getText() + "7");
		} else if (obj == number_view.number_button[7]) {// 8��Ŭ��
			addHipen(true);
			number_view.number_field.setText(number_view.number_field.getText() + "8");
		} else if (obj == number_view.number_button[8]) {// 9��Ŭ��
			addHipen(true);
			number_view.number_field.setText(number_view.number_field.getText() + "9");
		} else if (obj == number_view.number_button[9]) {// 0��Ŭ��
			addHipen(true);
			number_view.number_field.setText(number_view.number_field.getText() + "0");
		} else if (obj == number_view.add_button) {// �߰�
			if (number_view.number_field.getText().length() == 0)
				return;
			number_view.add_pnl.setVisible(true);
			// ��ư ��Ȱ��ȭ
			for (int i = 0; i < number_view.number_button.length; i++) {
				number_view.number_button[i].setEnabled(false);
			}
			number_view.add_button.setEnabled(false);
			number_view.del_button.setEnabled(false);
			number_view.bot_button.setEnabled(false);
		} else if (obj == number_view.del_button) {// �ؽ�Ʈ�ʵ� �����
			if (number_view.number_field.getText().length() == 0)
				return;
			delHipen(true);
			number_view.number_field.setText(
					number_view.number_field.getText().substring(0, number_view.number_field.getText().length() - 1));
		} else if (obj == number_view.bot_button) {// ��ȭ��ȣ�η� �Ѿ��
			list_number_view.listModel.removeAllElements();
			iter = number_hashmap_model.number_map.keySet().iterator();
			while (iter.hasNext()) {
				String keys = (String) iter.next();
				list_number_view.listModel.addElement(keys + " : " + number_hashmap_model.number_map.get(keys));
			}

			list_number_view.number_list.setModel(list_number_view.listModel);
			number_view.setVisible(false);
			list_number_view.search_field.setEnabled(false);
			list_number_view.setVisible(true);
		} else if (obj == number_view.new_btn || obj == number_view.update_btn) {// ��ȭ��ȣ
																					// ����
																					// �߰�
			add_number_view.name_field.setEnabled(false);
			add_number_view.num_label.setText(number_view.number_field.getText());
			number_view.add_pnl.setVisible(false);
			number_view.setVisible(false);
			add_number_view.setVisible(true);
		} else if (obj == number_view.cancel_btn) {// ���
			number_view.add_pnl.setVisible(false);
			// ��ư Ȱ��ȭ
			for (int i = 0; i < number_view.number_button.length; i++) {
				number_view.number_button[i].setEnabled(true);
			}
			number_view.add_button.setEnabled(true);
			number_view.del_button.setEnabled(true);
			number_view.bot_button.setEnabled(true);
		}

		// ��ȭ��ȣ��
		if (obj == list_number_view.bot_button) {// ��ȭ��ȣ �Է� ȭ������ �Ѿ��

			list_number_view.setVisible(false);
			number_view.setVisible(true);
		} else if (obj == list_number_view.up_button) {// ��ȭ��ȣ ���� ȭ������ �Ѿ��
			if (list_number_view.number_list.getSelectedIndex() < 0)
				return;
			String key = list_number_view.listModel.getElementAt(list_number_view.number_list.getSelectedIndex());
			key = key.substring(0, key.indexOf(" :"));
			up_number_view.name_label.setText(key);
			up_number_view.num_field.setText(number_hashmap_model.number_map.get(key));
			list_number_view.setVisible(false);
			up_number_view.setVisible(true);
		}

		// �߰�
		if (obj == add_number_view.add_submit_button) {// ���ο� ��ȣ �߰�
			int cnt = 0;
			if (add_number_view.name_field.getText().length() == 0)
				return;
			// ���ο� ��ȣ �߰��� �̸� �ߺ� x Ű���� �ϳ����̹Ƿ� �ߺ��� Ű�� �ڿ� ���ڸ� �ٿ� Ű���� �������ش�!
			String name = add_number_view.name_field.getText();
			String nameTmp = add_number_view.name_field.getText();
			while (number_hashmap_model.number_map.containsKey(name)) {
				cnt++;
				nameTmp = nameTmp + cnt;
				if (cnt < 10) {
					name = nameTmp;
					nameTmp = nameTmp.substring(0, nameTmp.length() - 1);
				} else if (cnt > 9 && cnt < 100) {
					name = nameTmp;
					nameTmp = nameTmp.substring(0, nameTmp.length() - 2);
				} else if (cnt > 99 && cnt < 1000) {
					name = nameTmp;
					nameTmp = nameTmp.substring(0, nameTmp.length() - 3);
				}
			}

			number_hashmap_model.number_map.put(name, add_number_view.num_label.getText());

			System.out.println("key/value: " + name + "/" + number_hashmap_model.number_map.get(name));

			// ����ȭ������ ���ư���
			add_number_view.name_field.setText("");
			add_number_view.setVisible(false);
			number_view.setVisible(true);

			number_view.add_pnl.setVisible(false);

			// ��ư Ȱ��ȭ
			number_view.number_field.setText("");
			for (int i = 0; i < number_view.number_button.length; i++) {
				number_view.number_button[i].setEnabled(true);
			}
			number_view.add_button.setEnabled(true);
			number_view.del_button.setEnabled(true);
			number_view.bot_button.setEnabled(true);

		} else if (obj == add_number_view.cancel_button) {
			add_number_view.name_field.setText("");
			add_number_view.setVisible(false);
			number_view.setVisible(true);

			number_view.add_pnl.setVisible(false);
			// ��ư Ȱ��ȭ
			for (int i = 0; i < number_view.number_button.length; i++) {
				number_view.number_button[i].setEnabled(true);
			}
			number_view.add_button.setEnabled(true);
			number_view.del_button.setEnabled(true);
			number_view.bot_button.setEnabled(true);
		}

		// ����
		if (obj == list_number_view.del_button) {
			if (!list_number_view.number_list.isSelectedIndex(list_number_view.number_list.getSelectedIndex()))
				return;
			else {
				String sub = list_number_view.number_list.getSelectedValue();
				sub = sub.substring(0, sub.indexOf(" :"));
				number_hashmap_model.number_map.remove(sub);

				list_number_view.eng_pnl.setVisible(false);
				list_number_view.bot_button.setEnabled(true);
				list_number_view.search_field.setText("");

				list_number_view.listModel.removeAllElements();
				iter = number_hashmap_model.number_map.keySet().iterator();
				while (iter.hasNext()) {
					String keys = (String) iter.next();
					list_number_view.listModel.addElement(keys + " : " + number_hashmap_model.number_map.get(keys));
				}

				list_number_view.number_list.setModel(list_number_view.listModel);
			}
		}

		// ������Ʈ

		if (obj == up_number_view.key_button[0]) {// 1��Ŭ��
			addHipen(false);
			up_number_view.num_field.setText(up_number_view.num_field.getText() + "1");
		} else if (obj == up_number_view.key_button[1]) {// 2��Ŭ��
			addHipen(false);
			up_number_view.num_field.setText(up_number_view.num_field.getText() + "2");
		} else if (obj == up_number_view.key_button[2]) {// 3��Ŭ��
			addHipen(false);
			up_number_view.num_field.setText(up_number_view.num_field.getText() + "3");
		} else if (obj == up_number_view.key_button[3]) {// 4��Ŭ��
			addHipen(false);
			up_number_view.num_field.setText(up_number_view.num_field.getText() + "4");
		} else if (obj == up_number_view.key_button[4]) {// 5��Ŭ��
			addHipen(false);
			up_number_view.num_field.setText(up_number_view.num_field.getText() + "5");
		} else if (obj == up_number_view.key_button[5]) {// 6��Ŭ��
			addHipen(false);
			up_number_view.num_field.setText(up_number_view.num_field.getText() + "6");
		} else if (obj == up_number_view.key_button[6]) {// 7��Ŭ��
			addHipen(false);
			up_number_view.num_field.setText(up_number_view.num_field.getText() + "7");
		} else if (obj == up_number_view.key_button[7]) {// 8��Ŭ��
			addHipen(false);
			up_number_view.num_field.setText(up_number_view.num_field.getText() + "8");
		} else if (obj == up_number_view.key_button[8]) {// 9��Ŭ��
			addHipen(false);
			up_number_view.num_field.setText(up_number_view.num_field.getText() + "9");
		} else if (obj == up_number_view.key_button[9]) {// 0��Ŭ��
			addHipen(false);
			up_number_view.num_field.setText(up_number_view.num_field.getText() + "0");
		} else if (obj == up_number_view.up_submit_button) {// �߰�
			if (up_number_view.num_field.getText().length() == 0)
				return;

			// �����̹Ƿ� �̸��� �ߺ��� ������ ����!!
			String name = up_number_view.name_label.getText();
			// ������ ���� ����
			number_hashmap_model.number_map.put(name, up_number_view.num_field.getText());

			list_number_view.eng_pnl.setVisible(false);
			list_number_view.bot_button.setEnabled(true);
			list_number_view.search_field.setText("");

			// ����Ʈ�Ѹ���
			list_number_view.listModel.removeAllElements();
			iter = number_hashmap_model.number_map.keySet().iterator();
			while (iter.hasNext()) {
				String keys = (String) iter.next();
				list_number_view.listModel.addElement(keys + " : " + number_hashmap_model.number_map.get(keys));
			}

			list_number_view.number_list.setModel(list_number_view.listModel);

			up_number_view.setVisible(false);
			list_number_view.setVisible(true);
		} else if (obj == up_number_view.key_button[10]) {// �ؽ�Ʈ�ʵ� �����
			if (up_number_view.num_field.getText().length() == 0)
				return;
			delHipen(false);
			up_number_view.num_field.setText(
					up_number_view.num_field.getText().substring(0, up_number_view.num_field.getText().length() - 1));
		} else if (obj == up_number_view.cancel_button){
			up_number_view.setVisible(false);
			list_number_view.setVisible(true);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();

		// �˻�
		if (obj == list_number_view.search_field) {
			if (flag) {
				list_number_view.eng_pnl.setVisible(true);
				list_number_view.bot_button.setEnabled(false);
				flag = false;
			} else {
				list_number_view.eng_pnl.setVisible(false);
				list_number_view.bot_button.setEnabled(true);
				list_number_view.search_field.setText("");

				list_number_view.listModel.removeAllElements();
				iter = number_hashmap_model.number_map.keySet().iterator();
				while (iter.hasNext()) {
					String keys = (String) iter.next();
					list_number_view.listModel.addElement(keys + " : " + number_hashmap_model.number_map.get(keys));
				}

				list_number_view.number_list.setModel(list_number_view.listModel);
				list_number_view.setVisible(true);

				flag = true;
			}
		} else if (obj == list_number_view.key_button[0]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "q");
		} else if (obj == list_number_view.key_button[1]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "w");
		} else if (obj == list_number_view.key_button[2]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "e");
		} else if (obj == list_number_view.key_button[3]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "r");
		} else if (obj == list_number_view.key_button[4]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "t");
		} else if (obj == list_number_view.key_button[5]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "y");
		} else if (obj == list_number_view.key_button[6]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "u");
		} else if (obj == list_number_view.key_button[7]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "i");
		} else if (obj == list_number_view.key_button[8]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "o");
		} else if (obj == list_number_view.key_button[9]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "p");
		} else if (obj == list_number_view.key_button[10]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "a");
		} else if (obj == list_number_view.key_button[11]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "s");
		} else if (obj == list_number_view.key_button[12]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "d");
		} else if (obj == list_number_view.key_button[13]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "f");
		} else if (obj == list_number_view.key_button[14]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "g");
		} else if (obj == list_number_view.key_button[15]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "h");
		} else if (obj == list_number_view.key_button[16]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "j");
		} else if (obj == list_number_view.key_button[17]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "k");
		} else if (obj == list_number_view.key_button[18]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "l");
		} else if (obj == list_number_view.key_button[19]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "z");
		} else if (obj == list_number_view.key_button[20]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "x");
		} else if (obj == list_number_view.key_button[21]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "c");
		} else if (obj == list_number_view.key_button[22]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "v");
		} else if (obj == list_number_view.key_button[23]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "b");
		} else if (obj == list_number_view.key_button[24]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "n");
		} else if (obj == list_number_view.key_button[25]) {
			list_number_view.search_field.setText(list_number_view.search_field.getText() + "m");
		} else if (obj == list_number_view.key_button[26]) {// ���ư
			list_number_view.search_field.setText(list_number_view.search_field.getText());
		} else if (obj == list_number_view.key_button[27]) {// �齺���̽�
			if (list_number_view.search_field.getText().length() == 0)
				return;
			list_number_view.search_field.setText(list_number_view.search_field.getText().substring(0,
					list_number_view.search_field.getText().length() - 1));
		} else if (obj == list_number_view.key_button[28]) {// �ѱ�Ű���� ��ȯ
			/*
			 * list_number_view.han_pnl.setVisible(true);
			 * list_number_view.eng_pnl.setVisible(false);
			 */
		} else if (obj == list_number_view.key_button[29]) {// �����̽�
			list_number_view.search_field.setText(list_number_view.search_field.getText() + " ");
		} else if (obj == list_number_view.key_button[30]) {// �����̽�
			list_number_view.search_field.setText(list_number_view.search_field.getText() + " ");
		} else if (obj == list_number_view.key_button[31]) {// �����̽�
			list_number_view.search_field.setText(list_number_view.search_field.getText() + " ");
		} else if (obj == list_number_view.key_button[32]) {// �����̽�
			list_number_view.search_field.setText(list_number_view.search_field.getText() + " ");
		} else if (obj == list_number_view.key_button[33]) {// �����̽�
			list_number_view.search_field.setText(list_number_view.search_field.getText() + " ");
		} else if (obj == list_number_view.key_button[34]) {// ����
			if (list_number_view.search_field.getText().length() == 0)
				return;
			list_number_view.listModel.removeAllElements();
			iter = number_hashmap_model.number_map.keySet().iterator();
			while (iter.hasNext()) {
				String keys = (String) iter.next();
				if (keys.matches("^[a-zA-Z]*" + list_number_view.search_field.getText() + "?[0-9]*")) {
					list_number_view.listModel.addElement(keys + " : " + number_hashmap_model.number_map.get(keys));
				}
			}

			list_number_view.number_list.setModel(list_number_view.listModel);
			list_number_view.eng_pnl.setVisible(false);
			list_number_view.bot_button.setEnabled(true);

		} else if (obj == list_number_view.key_button[35]) {// ����
			if (list_number_view.search_field.getText().length() == 0)
				return;
			list_number_view.listModel.removeAllElements();
			iter = number_hashmap_model.number_map.keySet().iterator();
			while (iter.hasNext()) {
				String keys = (String) iter.next();
				if (keys.matches("^[a-zA-Z]*" + list_number_view.search_field.getText() + "?[0-9]*")) {
					list_number_view.listModel.addElement(keys + " : " + number_hashmap_model.number_map.get(keys));
				}
			}

			list_number_view.number_list.setModel(list_number_view.listModel);
			list_number_view.eng_pnl.setVisible(false);
			list_number_view.bot_button.setEnabled(true);

		} else if (obj == list_number_view.key_button[36]) {// ����
			if (list_number_view.search_field.getText().length() == 0)
				return;
			list_number_view.listModel.removeAllElements();
			iter = number_hashmap_model.number_map.keySet().iterator();
			while (iter.hasNext()) {
				String keys = (String) iter.next();
				if (keys.matches("^[a-zA-Z]*" + list_number_view.search_field.getText() + "?[0-9]*")) {
					list_number_view.listModel.addElement(keys + " : " + number_hashmap_model.number_map.get(keys));
				}
			}

			list_number_view.number_list.setModel(list_number_view.listModel);
			list_number_view.eng_pnl.setVisible(false);
			list_number_view.bot_button.setEnabled(true);

		}

		// �߰�

		if (obj == add_number_view.key_button[0]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "q");
		} else if (obj == add_number_view.key_button[1]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "w");
		} else if (obj == add_number_view.key_button[2]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "e");
		} else if (obj == add_number_view.key_button[3]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "r");
		} else if (obj == add_number_view.key_button[4]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "t");
		} else if (obj == add_number_view.key_button[5]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "y");
		} else if (obj == add_number_view.key_button[6]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "u");
		} else if (obj == add_number_view.key_button[7]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "i");
		} else if (obj == add_number_view.key_button[8]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "o");
		} else if (obj == add_number_view.key_button[9]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "p");
		} else if (obj == add_number_view.key_button[10]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "a");
		} else if (obj == add_number_view.key_button[11]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "s");
		} else if (obj == add_number_view.key_button[12]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "d");
		} else if (obj == add_number_view.key_button[13]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "f");
		} else if (obj == add_number_view.key_button[14]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "g");
		} else if (obj == add_number_view.key_button[15]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "h");
		} else if (obj == add_number_view.key_button[16]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "j");
		} else if (obj == add_number_view.key_button[17]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "k");
		} else if (obj == add_number_view.key_button[18]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "l");
		} else if (obj == add_number_view.key_button[19]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "z");
		} else if (obj == add_number_view.key_button[20]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "x");
		} else if (obj == add_number_view.key_button[21]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "c");
		} else if (obj == add_number_view.key_button[22]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "v");
		} else if (obj == add_number_view.key_button[23]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "b");
		} else if (obj == add_number_view.key_button[24]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "n");
		} else if (obj == add_number_view.key_button[25]) {
			add_number_view.name_field.setText(add_number_view.name_field.getText() + "m");
		} else if (obj == add_number_view.key_button[26]) {// ����ư
			add_number_view.name_field.setText(add_number_view.name_field.getText());
		} else if (obj == add_number_view.key_button[27]) {// �齺���̽�
			if (add_number_view.name_field.getText().length() == 0)
				return;
			add_number_view.name_field.setText(add_number_view.name_field.getText().substring(0,
					add_number_view.name_field.getText().length() - 1));
		} else if (obj == add_number_view.key_button[28]) {// �ѱ�Ű���� ��ȯ
			/*
			 * list_number_view.han_pnl.setVisible(true);
			 * list_number_view.eng_pnl.setVisible(false);
			 */
		} else if (obj == add_number_view.key_button[29]) {// �����̽�
			add_number_view.name_field.setText(add_number_view.name_field.getText() + " ");
		} else if (obj == add_number_view.key_button[30]) {// �����̽�
			add_number_view.name_field.setText(add_number_view.name_field.getText() + " ");
		} else if (obj == add_number_view.key_button[31]) {// �����̽�
			add_number_view.name_field.setText(add_number_view.name_field.getText() + " ");
		} else if (obj == add_number_view.key_button[32]) {// �����̽�
			add_number_view.name_field.setText(add_number_view.name_field.getText() + " ");
		} else if (obj == add_number_view.key_button[33]) {// �����̽�
			add_number_view.name_field.setText(add_number_view.name_field.getText() + " ");
		} else if (obj == add_number_view.key_button[34]) {// ����
			int cnt = 0;
			if (add_number_view.name_field.getText().length() == 0)
				return;
			// ���ο� ��ȣ �߰��� �̸� �ߺ� x Ű���� �ϳ����̹Ƿ� �ߺ��� Ű�� �ڿ� ���ڸ� �ٿ� Ű���� �������ش�!
			String name = add_number_view.name_field.getText();
			String nameTmp = add_number_view.name_field.getText();
			while (number_hashmap_model.number_map.containsKey(name)) {
				cnt++;
				nameTmp = nameTmp + cnt;
				if (cnt < 10) {
					name = nameTmp;
					nameTmp = nameTmp.substring(0, nameTmp.length() - 1);
				} else if (cnt > 9 && cnt < 100) {
					name = nameTmp;
					nameTmp = nameTmp.substring(0, nameTmp.length() - 2);
				} else if (cnt > 99 && cnt < 1000) {
					name = nameTmp;
					nameTmp = nameTmp.substring(0, nameTmp.length() - 3);
				}
			}

			number_hashmap_model.number_map.put(name, add_number_view.num_label.getText());

			System.out.println("key/value: " + name + "/" + number_hashmap_model.number_map.get(name));

			// ����ȭ������ ���ư���
			add_number_view.name_field.setText("");
			add_number_view.setVisible(false);
			number_view.setVisible(true);

			number_view.add_pnl.setVisible(false);

			// ��ư Ȱ��ȭ
			number_view.number_field.setText("");
			for (int i = 0; i < number_view.number_button.length; i++) {
				number_view.number_button[i].setEnabled(true);
			}
			number_view.add_button.setEnabled(true);
			number_view.del_button.setEnabled(true);
			number_view.bot_button.setEnabled(true);

		} else if (obj == add_number_view.key_button[35]) {// ����
			int cnt = 0;
			if (add_number_view.name_field.getText().length() == 0)
				return;
			// ���ο� ��ȣ �߰��� �̸� �ߺ� x Ű���� �ϳ����̹Ƿ� �ߺ��� Ű�� �ڿ� ���ڸ� �ٿ� Ű���� �������ش�!
			String name = add_number_view.name_field.getText();
			String nameTmp = add_number_view.name_field.getText();
			while (number_hashmap_model.number_map.containsKey(name)) {
				cnt++;
				nameTmp = nameTmp + cnt;
				if (cnt < 10) {
					name = nameTmp;
					nameTmp = nameTmp.substring(0, nameTmp.length() - 1);
				} else if (cnt > 9 && cnt < 100) {
					name = nameTmp;
					nameTmp = nameTmp.substring(0, nameTmp.length() - 2);
				} else if (cnt > 99 && cnt < 1000) {
					name = nameTmp;
					nameTmp = nameTmp.substring(0, nameTmp.length() - 3);
				}
			}

			number_hashmap_model.number_map.put(name, add_number_view.num_label.getText());

			System.out.println("key/value: " + name + "/" + number_hashmap_model.number_map.get(name));

			// ����ȭ������ ���ư���
			add_number_view.name_field.setText("");
			add_number_view.setVisible(false);
			number_view.setVisible(true);

			number_view.add_pnl.setVisible(false);

			// ��ư Ȱ��ȭ
			number_view.number_field.setText("");
			for (int i = 0; i < number_view.number_button.length; i++) {
				number_view.number_button[i].setEnabled(true);
			}
			number_view.add_button.setEnabled(true);
			number_view.del_button.setEnabled(true);
			number_view.bot_button.setEnabled(true);

		} else if (obj == add_number_view.key_button[36]) {// ����
			int cnt = 0;
			if (add_number_view.name_field.getText().length() == 0)
				return;
			// ���ο� ��ȣ �߰��� �̸� �ߺ� x Ű���� �ϳ����̹Ƿ� �ߺ��� Ű�� �ڿ� ���ڸ� �ٿ� Ű���� �������ش�!
			String name = add_number_view.name_field.getText();
			String nameTmp = add_number_view.name_field.getText();
			while (number_hashmap_model.number_map.containsKey(name)) {
				cnt++;
				nameTmp = nameTmp + cnt;
				if (cnt < 10) {
					name = nameTmp;
					nameTmp = nameTmp.substring(0, nameTmp.length() - 1);
				} else if (cnt > 9 && cnt < 100) {
					name = nameTmp;
					nameTmp = nameTmp.substring(0, nameTmp.length() - 2);
				} else if (cnt > 99 && cnt < 1000) {
					name = nameTmp;
					nameTmp = nameTmp.substring(0, nameTmp.length() - 3);
				}
			}

			number_hashmap_model.number_map.put(name, add_number_view.num_label.getText());

			System.out.println("key/value: " + name + "/" + number_hashmap_model.number_map.get(name));

			// ����ȭ������ ���ư���
			add_number_view.name_field.setText("");
			add_number_view.setVisible(false);
			number_view.setVisible(true);

			number_view.add_pnl.setVisible(false);

			// ��ư Ȱ��ȭ
			number_view.number_field.setText("");
			for (int i = 0; i < number_view.number_button.length; i++) {
				number_view.number_button[i].setEnabled(true);
			}
			number_view.add_button.setEnabled(true);
			number_view.del_button.setEnabled(true);
			number_view.bot_button.setEnabled(true);

		}

	}

	public void addHipen(boolean add) {
		if (add) {
			if (number_view.number_field.getText().length() == 3 || number_view.number_field.getText().length() == 8)
				number_view.number_field.setText(number_view.number_field.getText() + "-");
		} else if (up_number_view.num_field.getText().length() == 3 || up_number_view.num_field.getText().length() == 8)
			up_number_view.num_field.setText(up_number_view.num_field.getText() + "-");

	}

	public void delHipen(boolean add) {
		if (add) {
			if (number_view.number_field.getText().length() == 4 || number_view.number_field.getText().length() == 9)
				number_view.number_field.setText(number_view.number_field.getText().substring(0,
						number_view.number_field.getText().length() - 1));
			else if (up_number_view.num_field.getText().length() == 4
					|| up_number_view.num_field.getText().length() == 9)
				up_number_view.num_field.setText(up_number_view.num_field.getText().substring(0,
						up_number_view.num_field.getText().length() - 1));

		}

	}

	public static void main(String[] args) {
		new MainController();
	}

}