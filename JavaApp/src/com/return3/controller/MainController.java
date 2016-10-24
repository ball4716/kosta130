package com.return3.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;

import com.return3.model.AdminModelAddStockAllThread;
import com.return3.model.AdminModelPassword;
import com.return3.model.AdminModelStock;
import com.return3.model.SoundModelThread;
import com.return3.model.UserModelCoin;
import com.return3.model.UserModelCup;
import com.return3.model.UserModelCupThread;
import com.return3.model.UserModelDrinkThread;
import com.return3.view.AdminViewPassword;
import com.return3.view.UserView;

public class MainController extends MouseInputAdapter implements ActionListener {
	// 모델
	AdminModelStock admin_model_stock;
	UserModelCup user_model_cup;
	UserModelCoin user_model_coin;
	// 뷰
	UserView user_view;
	
	// 패스워드 모델
	AdminViewPassword admin_view_password;

	public JLabel big_cup, middle_cup, small_cup;
	JButton money_100, money_500, money_1000, money_return;
	JLabel money_stock;

	public Image cup_s_dis, cup_s_en, cup_m_dis, cup_m_en, cup_l_dis, cup_l_en;
	public JLabel la_small, la_middle, la_big;

	JButton bt_admin;

	JLabel la_coca, la_cider, la_fanta, la_mount;
	JLabel la_cup_s, la_cup_m, la_cup_l;
	DefaultTableModel dtm_drink, dtm_cup_money;
	JButton bt_coca_add_all, bt_cider_add_all, bt_fanta_add_all, bt_mount_add_all;
	JButton bt_cups_add_all, bt_cupm_add_all, bt_cupl_add_all;
	JProgressBar bar_coca, bar_cider, bar_fanta, bar_mountaindew;
	JButton bt_coca_add, bt_cider_add, bt_fanta_add, bt_mount_add;
	JButton bt_cups_add, bt_cupm_add, bt_cupl_add;
	
	Thread thrd_coca, thrd_cider, thrd_fanta, thrd_mount, thrd_cups, thrd_cupm, thrd_cupl;
	Thread thrd_coca_all, thrd_cider_all, thrd_fanta_all, thrd_mount_all, thrd_cups_all, thrd_cupm_all, thrd_cupl_all;
	boolean coca_all_onoff,cider_all_onoff,fanta_all_onoff,mount_all_onoff,cups_all_onoff,cupm_all_onoff,cupl_all_onoff;
	SoundModelThread sound_coca, sound_cider, sound_fanta, sound_mount;
	SoundModelThread sound_coca_all, sound_cider_all, sound_fanta_all, sound_mount_all;
	
	public MainController() {
		// Model 초기화
		admin_model_stock = new AdminModelStock();

		user_model_cup = new UserModelCup();
		user_model_coin = new UserModelCoin();

		// View 초기화
		user_view = new UserView();
		admin_view_password = new AdminViewPassword();

		initializationVar();
		setAdminView();
		eventUp();
		
	}

	private void initializationVar() {// 변수 초기화
		// 관리자 창 작동을 위한 초기화
		la_coca = user_view.admin_view.la_coca;
		la_cider = user_view.admin_view.la_cider;
		la_fanta = user_view.admin_view.la_fanta;
		la_mount = user_view.admin_view.la_mount;
		la_cup_s = user_view.admin_view.la_cups;
		la_cup_m = user_view.admin_view.la_cupm;
		la_cup_l = user_view.admin_view.la_cupl;
		bt_coca_add_all = user_view.admin_view.bt_coca_add_all;
		bt_cider_add_all = user_view.admin_view.bt_cider_add_all;
		bt_fanta_add_all = user_view.admin_view.bt_fanta_add_all;
		bt_mount_add_all = user_view.admin_view.bt_mount_add_all;
		bt_cups_add_all = user_view.admin_view.bt_cups_add_all;
		bt_cupm_add_all = user_view.admin_view.bt_cupm_add_all;
		bt_cupl_add_all = user_view.admin_view.bt_cupl_add_all;
		bt_coca_add = user_view.admin_view.bt_coca_add;
		bt_cider_add = user_view.admin_view.bt_cider_add;
		bt_fanta_add = user_view.admin_view.bt_fanta_add;
		bt_mount_add = user_view.admin_view.bt_mount_add;
		bt_cups_add = user_view.admin_view.bt_cups_add;
		bt_cupm_add = user_view.admin_view.bt_cupm_add;
		bt_cupl_add = user_view.admin_view.bt_cupl_add;
		dtm_drink = user_view.admin_view.dtm_drink;
		dtm_cup_money = user_view.admin_view.dtm_cup_money;

		// 동전버튼 작동을 위한 초기화
		money_100 = user_view.user_view_coin.money_100;
		money_500 = user_view.user_view_coin.money_500;
		money_1000 = user_view.user_view_coin.money_1000;
		money_return = user_view.user_view_coin.money_return;
		money_stock = user_view.user_view_coin.la_insert_coin;

		// 컴 드래그를 위한 초기화
		big_cup = user_view.user_view_cup.la_big;
		middle_cup = user_view.user_view_cup.la_middle;
		small_cup = user_view.user_view_cup.la_small;

		// 컵 활성화/비활성화시 이미지 변경을 위한 초기화
		cup_s_dis = user_view.user_view_cup.cup_s_dis;
		cup_s_en = user_view.user_view_cup.cup_s_en;
		cup_m_dis = user_view.user_view_cup.cup_m_dis;
		cup_m_en = user_view.user_view_cup.cup_m_en;
		cup_l_dis = user_view.user_view_cup.cup_l_dis;
		cup_l_en = user_view.user_view_cup.cup_l_en;

		// 컵 활성화/비활성화를 위한 초기화
		la_small = user_view.user_view_cup.la_small;
		la_middle = user_view.user_view_cup.la_middle;
		la_big = user_view.user_view_cup.la_big;

		// 관리자 창 호출을 위한 초기화
		bt_admin = user_view.user_view_admin.bt_admin;

		// 음료수 바 작동을위한 초기화
		bar_coca = user_view.user_view_drinkbar.bar_coca;
		bar_cider = user_view.user_view_drinkbar.bar_cider;
		bar_fanta = user_view.user_view_drinkbar.bar_fanta;
		bar_mountaindew = user_view.user_view_drinkbar.bar_mountaindew;
		
		//자동 충전 켜기 끄기를 위한 초기화
		coca_all_onoff = true;
		cider_all_onoff = true;
		fanta_all_onoff = true;
		mount_all_onoff = true;
		cups_all_onoff = true;
		cupm_all_onoff = true;
		cupl_all_onoff = true;
	}

	public void eventUp() {// 연결자
		// 코인 연결자
		money_100.addActionListener(this);
		money_500.addActionListener(this);
		money_1000.addActionListener(this);
		money_return.addActionListener(this);

		// 컵 연결자
		big_cup.addMouseMotionListener(this);
		big_cup.addMouseListener(this);
		middle_cup.addMouseMotionListener(this);
		middle_cup.addMouseListener(this);
		small_cup.addMouseMotionListener(this);
		small_cup.addMouseListener(this);

		// 관리자모드 버튼 연결자
		bt_admin.addActionListener(this);

		// 버튼 연결자
		bt_cups_add_all.addMouseListener(this);
		bt_cupm_add_all.addMouseListener(this);
		bt_cupl_add_all.addMouseListener(this);
		bt_cups_add.addMouseListener(this);
		bt_cupm_add.addMouseListener(this);
		bt_cupl_add.addMouseListener(this);

		// 음료연결자
		bt_coca_add_all.addMouseListener(this);
		bt_cider_add_all.addMouseListener(this);
		bt_fanta_add_all.addMouseListener(this);
		bt_mount_add_all.addMouseListener(this);
		bt_coca_add.addMouseListener(this);
		bt_cider_add.addMouseListener(this);
		bt_fanta_add.addMouseListener(this);
		bt_mount_add.addMouseListener(this);
		
		//패스워드
		admin_view_password.password_ok.addActionListener(this);
		admin_view_password.password_cancel.addActionListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == bt_cups_add_all) {//이하 자동 추가
			if(cups_all_onoff){//한번누르면 자동 추가
				bt_cups_add_all.setText("중     지");
				thrd_cups_all = new AdminModelAddStockAllThread(admin_model_stock, dtm_cup_money, la_cup_s, 0, 300, 50, false, null);
				cups_all_onoff = false;
			}else{//다시 누르면 자동추가 끄기
				bt_cups_add_all.setText("자동 충전");
				thrd_cups_all.stop();
				cups_all_onoff = true;
			}
		} else if (obj == bt_cupm_add_all) {
			if(cupm_all_onoff){
				bt_cupm_add_all.setText("중     지");
				thrd_cupm_all = new AdminModelAddStockAllThread(admin_model_stock, dtm_cup_money, la_cup_m, 1, 300, 50, false, null);
				cupm_all_onoff = false;
			} else {
				bt_cupm_add_all.setText("자동 충전");
				thrd_cupm_all.stop();
				cupm_all_onoff = true;
			}
		} else if (obj == bt_cupl_add_all) {
			if(cupl_all_onoff){
				bt_cupl_add_all.setText("중     지");
				thrd_cupl_all = new AdminModelAddStockAllThread(admin_model_stock, dtm_cup_money, la_cup_l, 2, 300, 50, false, null);
				cupl_all_onoff = false;
			} else {
				bt_cupl_add_all.setText("자동 충전");
				thrd_cupl_all.stop();
				cupl_all_onoff = true;
			}
		} else if (obj == bt_coca_add_all) {
			if(coca_all_onoff){
				sound_coca_all = new SoundModelThread("sound/drink.wav",2000);
				bt_coca_add_all.setText("중     지");
				thrd_coca_all = new AdminModelAddStockAllThread(admin_model_stock, dtm_drink, la_coca, 0, 10000, 1, true, bar_coca);
				coca_all_onoff = false;
			} else {
				sound_coca_all.stop();
				bt_coca_add_all.setText("자동 충전");
				thrd_coca_all.stop();
				coca_all_onoff = true;
			}
		} else if (obj == bt_cider_add_all) {
			if(cider_all_onoff){
				sound_cider_all = new SoundModelThread("sound/drink.wav",2000);
				bt_cider_add_all.setText("중     지");
				thrd_cider_all = new AdminModelAddStockAllThread(admin_model_stock, dtm_drink, la_cider, 1, 10000, 1, true, bar_cider);
				cider_all_onoff = false;
			} else {
				sound_cider_all.clip.stop();
				bt_cider_add_all.setText("자동 추가");
				thrd_cider_all.stop();
				cider_all_onoff = true;
			}
		} else if (obj == bt_fanta_add_all) {
			if(fanta_all_onoff){
				sound_fanta_all = new SoundModelThread("sound/drink.wav",2000);
				bt_fanta_add_all.setText("중     지");
				thrd_fanta_all = new AdminModelAddStockAllThread(admin_model_stock, dtm_drink, la_fanta, 2, 10000, 1, true, bar_fanta);
				fanta_all_onoff = false;
			} else {
				sound_fanta_all.clip.stop();
				bt_fanta_add_all.setText("자동 추가");
				thrd_fanta_all.stop();
				fanta_all_onoff = true;
			}
		} else if (obj == bt_mount_add_all) {
			if(mount_all_onoff){
				sound_mount_all = new SoundModelThread("sound/drink.wav",2000);
				bt_mount_add_all.setText("중     지");
				thrd_mount_all = new AdminModelAddStockAllThread(admin_model_stock, dtm_drink, la_mount, 3, 10000, 1, true, bar_mountaindew);
				mount_all_onoff = false;
			} else {
				sound_mount_all.clip.stop();
				bt_mount_add_all.setText("자동 추가");
				thrd_mount_all.stop();
				mount_all_onoff = true;
			}
		} else if (obj == bt_cups_add) {//이하 수동 추가
			thrd_cups = new AdminModelAddStockAllThread(admin_model_stock, dtm_cup_money, la_cup_s, 0, 300, 50, false, null);
		} else if (obj == bt_cupm_add) {
			thrd_cupm = new AdminModelAddStockAllThread(admin_model_stock, dtm_cup_money, la_cup_m, 1, 300, 50, false, null);
		} else if (obj == bt_cupl_add) {
			thrd_cupl = new AdminModelAddStockAllThread(admin_model_stock, dtm_cup_money, la_cup_l, 2, 300, 50, false, null);
		} else if (obj == bt_coca_add) {
			sound_coca = new SoundModelThread("sound/drink.wav",2000);
			thrd_coca = new AdminModelAddStockAllThread(admin_model_stock, dtm_drink, la_coca, 0, 10000, 1, true, bar_coca);
		} else if (obj == bt_cider_add) {
			sound_cider = new SoundModelThread("sound/drink.wav",2000);
			thrd_cider = new AdminModelAddStockAllThread(admin_model_stock, dtm_drink, la_cider, 1, 10000, 1, true, bar_cider);
		} else if (obj == bt_fanta_add) {
			sound_fanta = new SoundModelThread("sound/drink.wav",2000);
			thrd_fanta = new AdminModelAddStockAllThread(admin_model_stock, dtm_drink, la_fanta, 2, 10000, 1, true, bar_fanta);
		} else if (obj == bt_mount_add) {
			sound_mount = new SoundModelThread("sound/drink.wav",2000);
			thrd_mount = new AdminModelAddStockAllThread(admin_model_stock, dtm_drink, la_mount, 3, 10000, 1, true, bar_mountaindew);
		}
	}//mousePressed

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		setCupOnOff(user_model_coin.getCoin());// 컵 작동

		if (obj == money_100) {// 100원 투입
			new SoundModelThread("sound/coin.wav",2000);
			user_model_coin.insertCoin(100);
			money_stock.setText(user_model_coin.getCoin() + "원");
		} else if (obj == money_500) {// 500원 투입
			new SoundModelThread("sound/coin.wav",2000);
			user_model_coin.insertCoin(500);
			money_stock.setText(user_model_coin.getCoin() + "원");
		} else if (obj == money_1000) {// 1000원 투입
			new SoundModelThread("sound/paper.wav",2000);
			user_model_coin.insertCoin(1000);
			money_stock.setText(user_model_coin.getCoin() + "원");
		} else if (obj == money_return) {// 반환
			if (money_stock.getText().equals("투입금액") || money_stock.getText().equals("0원")) {
				// 투입금액 0원시 반환 작동 x
				JOptionPane.showMessageDialog(user_view, "요금을 투입해 주세요");
				return;
			}
			new SoundModelThread("sound/paper.wav",2000);
			new SoundModelThread("sound/change.wav",2000);
			new SoundModelThread("sound/coin.wav",2000);
			JOptionPane.showMessageDialog(user_view, user_model_coin.getCoin() + "원이 반환되었습니다", "잔돈반환", 2);
			user_model_coin.setCoin(0);
			money_stock.setText(user_model_coin.getCoin() + "원");
			big_cup.setLocation(870, 460);
			middle_cup.setLocation(750, 480);
			small_cup.setLocation(650, 500);
		} else if (obj == bt_admin) {
			new SoundModelThread("sound/button.wav",2000);
			if (user_view.admin_view.isVisible())
				user_view.admin_view.setVisible(false);
			else {
				setAdminView();
				admin_view_password.setLocation((int)user_view.getLocation().getX()+370,(int)user_view.getLocation().getY()+320);
				admin_view_password.setVisible(true);
			}
		} else if (obj == admin_view_password.password_ok){
			String password = admin_view_password.password_field.getText();
			if (password == null) {// 비밀번호 같을경우 관리자 모드 진입
				admin_view_password.setVisible(false);
				return;
			} else if (!password.equals(AdminModelPassword.PASSWORD)) {
				admin_view_password.setVisible(false);
				JOptionPane.showMessageDialog(user_view, "비밀번호가 일치하지 않습니다");
			} else{
				user_view.admin_view.setVisible(true);
				admin_view_password.setVisible(false);
			}
		} else if (obj == admin_view_password.password_cancel){
			admin_view_password.setVisible(false);
		} 

		setCupOnOff(user_model_coin.getCoin());// 컵 작동
	}

	public void setCupOnOff(int recent_money) {// 컵 이미지변경과 컵 활성화 및 비활성화
		setAdminView();
		if (recent_money >= 1500) {
			// 컵이미지 변경
			la_small.setIcon(new ImageIcon(cup_s_en));
			la_middle.setIcon(new ImageIcon(cup_m_en));
			la_big.setIcon(new ImageIcon(cup_l_en));
			// 컵 활성화/비활성화
			la_small.setEnabled(true);
			la_middle.setEnabled(true);
			la_big.setEnabled(true);
		} else if (recent_money >= 1000 && recent_money < 1500) {
			la_small.setIcon(new ImageIcon(cup_s_en));
			la_middle.setIcon(new ImageIcon(cup_m_en));
			la_big.setIcon(new ImageIcon(cup_l_dis));

			la_small.setEnabled(true);
			la_middle.setEnabled(true);
			la_big.setEnabled(false);
			la_big.setLocation(870, 460);
		} else if (recent_money >= 500 && recent_money < 1000) {
			la_small.setIcon(new ImageIcon(cup_s_en));
			la_middle.setIcon(new ImageIcon(cup_m_dis));
			la_big.setIcon(new ImageIcon(cup_l_dis));

			la_small.setEnabled(true);
			la_middle.setEnabled(false);
			la_big.setEnabled(false);
			la_middle.setLocation(750, 480);
			la_big.setLocation(870, 460);
		} else {// recent_money<500
			la_small.setIcon(new ImageIcon(cup_s_dis));
			la_middle.setIcon(new ImageIcon(cup_m_dis));
			la_big.setIcon(new ImageIcon(cup_l_dis));

			la_small.setEnabled(false);
			la_middle.setEnabled(false);
			la_big.setEnabled(false);
			la_small.setLocation(650, 500);
			la_middle.setLocation(750, 480);
			la_big.setLocation(870, 460);
		}
		setAdminView();

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// 컵 컴포넌트 x,y 좌표 받아오기
		int big_x = (int) big_cup.getLocation().getX();
		int big_y = (int) big_cup.getLocation().getY();
		int mid_x = (int) middle_cup.getLocation().getX();
		int mid_y = (int) middle_cup.getLocation().getY();
		int small_x = (int) small_cup.getLocation().getX();
		int small_y = (int) small_cup.getLocation().getY();

		if (big_cup.isEnabled() && e.getSource() == big_cup) {// 큰컵 드래그
			big_cup.setLocation((e.getXOnScreen() - big_cup.getSize().width / 4 - user_view.getX() - 30),
					e.getYOnScreen() - big_cup.getSize().height / 2 - user_view.getY() - 30);
		} else if (middle_cup.isEnabled() && e.getSource() == middle_cup) {// 중간컵드래그
			middle_cup.setLocation((e.getXOnScreen() - middle_cup.getSize().width / 4 - user_view.getX() - 30),
					e.getYOnScreen() - middle_cup.getSize().height / 2 - user_view.getY() - 30);

		} else if (small_cup.isEnabled() && e.getSource() == small_cup) {// 작은컵드래그
			small_cup.setLocation((e.getXOnScreen() - small_cup.getSize().width / 4 - user_view.getX() - 30),
					e.getYOnScreen() - small_cup.getSize().height / 2 - user_view.getY() - 30);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Object obj = e.getSource();

		// 컵 컴포넌트 x,y 좌표 받아오기
		int big_x = (int) big_cup.getLocation().getX();
		int big_y = (int) big_cup.getLocation().getY();
		int mid_x = (int) middle_cup.getLocation().getX();
		int mid_y = (int) middle_cup.getLocation().getY();
		int small_x = (int) small_cup.getLocation().getX();
		int small_y = (int) small_cup.getLocation().getY();
		
		setCupOnOff(user_model_coin.getCoin());// 컵 작동

		// 스위치 앞 컵 위치
		int xy[] = new int[2];
		if (obj == big_cup) {
			xy = user_model_cup.cupToMachine(big_x, big_y);
			if (xy[0] != 0 && xy[1] != 0){
				coinCupStockChange(xy[0], xy[1], 1500, big_cup, 2);
				//스레드 넣기
			}
			setCupOnOff(user_model_coin.getCoin());// 컵 작동
		} else if (obj == middle_cup) {
			xy = user_model_cup.cupToMachine(mid_x, mid_y);
			if (xy[0] != 0 && xy[1] != 0){
				coinCupStockChange(xy[0], xy[1], 1000, middle_cup, 1);
				//스레드 넣기
			}
			setCupOnOff(user_model_coin.getCoin());// 컵 작동
		} else if (obj == small_cup) {
			xy = user_model_cup.cupToMachine(small_x, small_y);
			if (xy[0] != 0 && xy[1] != 0){
				coinCupStockChange(xy[0], xy[1], 500, small_cup, 0);
				//스레드 넣기
			}
			setCupOnOff(user_model_coin.getCoin());// 컵 작동
		} else if (obj == bt_cups_add) {//이하 수동 추가 정지
			thrd_cups.stop();
		} else if (obj == bt_cupm_add) {
			thrd_cupm.stop();
		} else if (obj == bt_cupl_add) {
			thrd_cupl.stop();
		} else if (obj == bt_coca_add) {
			sound_coca.clip.stop();
			thrd_coca.stop();
		} else if (obj == bt_cider_add) {
			sound_cider.clip.stop();
			thrd_cider.stop();
		} else if (obj == bt_fanta_add) {
			sound_fanta.clip.stop();
			thrd_fanta.stop();
		} else if (obj == bt_mount_add) {
			sound_mount.clip.stop();
			thrd_mount.stop();
		}
	}//mouseReleased

	public void coinCupStockChange(int x, int y, int coin, JLabel cup, int cup_size) {
		// 돈과 컵 수량 변화 - 파일입출력 연동
		cup.setLocation(x, y);
		cup.setEnabled(false);
		user_model_coin.setCoin(user_model_coin.getCoin() - coin);
		admin_model_stock.setMoney(admin_model_stock.getMoney() + coin);
		money_stock.setText("" + user_model_coin.getCoin() + "원");

		int[] cup_stock = new int[3];
		for (int i = 0; i < cup_stock.length; i++) {// 컵 수량 변경
			if (i == cup_size) {
				cup_stock[i] = admin_model_stock.getCup_stock()[i] - 1;
			} else
				cup_stock[i] = admin_model_stock.getCup_stock()[i];
		}
		admin_model_stock.setCup_stock(cup_stock);
		// 스레드 작동해야함
		
		new SoundModelThread("sound/machineSound.wav",20000);
		if(x==41 && y==625)
			new UserModelDrinkThread(admin_model_stock, dtm_drink, cup_size, la_coca, bar_coca, 0, user_view);
		else if(x==191 && y==625)
			new UserModelDrinkThread(admin_model_stock, dtm_drink, cup_size, la_cider, bar_cider, 1, user_view);
		else if(x==321 && y==625)
			new UserModelDrinkThread(admin_model_stock, dtm_drink, cup_size, la_fanta, bar_fanta, 2, user_view);
		else if(x==491 && y==625)
			new UserModelDrinkThread(admin_model_stock, dtm_drink, cup_size, la_mount, bar_mountaindew, 3, user_view);
		
		new UserModelCupThread(admin_model_stock, la_big, cup_l_en, cup_l_dis, 2 );
		new UserModelCupThread(admin_model_stock, la_middle, cup_m_en, cup_m_dis, 1);
		new UserModelCupThread(admin_model_stock, la_small, cup_s_en, cup_s_dis, 0);

		setAdminView();
		admin_model_stock.fileWrite();// 파일에 쓰기
	}//coinCupStockChange

	public void setAdminView() {// 관리자 화면 세팅
		la_coca.setText("" + admin_model_stock.getDrink_stock()[0] +"cc");
		la_cider.setText("" + admin_model_stock.getDrink_stock()[1] +"cc");
		la_fanta.setText("" + admin_model_stock.getDrink_stock()[2] +"cc");
		la_mount.setText("" + admin_model_stock.getDrink_stock()[3] +"cc");
		la_cup_s.setText("" + admin_model_stock.getCup_stock()[0] +"개");
		la_cup_m.setText("" + admin_model_stock.getCup_stock()[1] +"개");
		la_cup_l.setText("" + admin_model_stock.getCup_stock()[2] +"개");
		
		bar_coca.setValue(admin_model_stock.getDrink_stock()[0]);
		bar_cider.setValue(admin_model_stock.getDrink_stock()[1]);
		bar_fanta.setValue(admin_model_stock.getDrink_stock()[2]);
		bar_mountaindew.setValue(admin_model_stock.getDrink_stock()[3]);

		Vector rowData1 = new Vector();
		if (rowData1.size() > 0)
			rowData1.removeAllElements();
		for (int i = 0; i < admin_model_stock.getDrink_stock().length; i++) {
			rowData1.add(admin_model_stock.getDrink_stock()[i]);
		}
		if (dtm_drink.getRowCount() > 0) {
			for (int i = 0; i < dtm_drink.getRowCount(); i++) {
				dtm_drink.removeRow(i);
			}
		}
		dtm_drink.addRow(rowData1);

		Vector rowData2 = new Vector();
		if (rowData2.size() > 0)
			rowData2.removeAllElements();
		for (int i = 0; i < admin_model_stock.getCup_stock().length; i++) {
			rowData2.add(admin_model_stock.getCup_stock()[i]);
		}
		rowData2.add(admin_model_stock.getMoney());
		if (dtm_cup_money.getRowCount() > 0) {
			for (int i = 0; i < dtm_cup_money.getRowCount(); i++) {
				dtm_cup_money.removeRow(i);
			}
		}
		dtm_cup_money.addRow(rowData2);
	}

	public static void main(String[] args) {
		new MainController();
	}
}
