package com.kosta._0802;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.border.BevelBorder;

public class NumBaseballGame extends JFrame implements ActionListener {
	JButton bt_new, bt_clear, bt_answer, bt_exit;
	JTextArea ta;
	JTextField tf;
	JLabel lb;
	JScrollPane scroll_bar;
	JPanel pnl_text, pnl_text_area, pnl_text_field;
	JPanel pnl_button;

	int[] baseballRandNum;
	int[] baseballAnswer;
	int cnt, ballCnt, strikeCnt;
	Random rand;

	public NumBaseballGame() {
		// Game 진행 초기화
		baseballRandNum = new int[3];
		baseballAnswer = new int[3];
		cnt = 0;
		ballCnt = 0;
		strikeCnt = 0;
		rand = new Random();

		// title
		setTitle("숫자야구게임");

		// 버튼 초기화
		bt_new = new JButton("새게임");
		bt_clear = new JButton("지우기");
		bt_answer = new JButton("정답");
		bt_exit = new JButton("나가기");

		// textArea초기화 + 스크롤 붙이기
		ta = new JTextArea();
		ta.setEditable(false);// textArea에 직접입력 불가

		scroll_bar = new JScrollPane(ta);
		scroll_bar.setBorder(new BevelBorder(BevelBorder.LOWERED));

		// textField초기화 + 라벨 초기화
		tf = new JTextField(40);
		tf.setEditable(false);// 최초에 입력 불가

		lb = new JLabel("입력: ");

		// 레이아웃 초기화
		pnl_text = new JPanel();
		pnl_text_area = new JPanel();
		pnl_text_field = new JPanel();

		pnl_button = new JPanel();

		// 화면구성
		// 좌측화면 구성
		pnl_text_field.setLayout(new FlowLayout());
		pnl_text_field.add(lb);
		pnl_text_field.add(tf);
		pnl_text_field.setBackground(Color.orange);

		pnl_text_area.setLayout(new BorderLayout(10, 10));
		pnl_text_area.add("North", new JLabel());
		pnl_text_area.add("South", new JLabel());
		pnl_text_area.add("East", new JLabel());
		pnl_text_area.add("West", new JLabel());
		pnl_text_area.add("Center", scroll_bar);
		pnl_text_area.setBackground(Color.orange);

		pnl_text.setLayout(new BorderLayout(10, 10));
		pnl_text.add("Center", pnl_text_area);
		pnl_text.add("South", pnl_text_field);
		pnl_text.setBackground(Color.orange);

		// 우측화면 구성
		pnl_button.setLayout(new GridLayout(7, 1, 40, 40));
		pnl_button.add(new JLabel());
		pnl_button.add(bt_new);
		pnl_button.add(bt_clear);
		pnl_button.add(bt_answer);
		pnl_button.add(bt_exit);
		pnl_button.setBackground(Color.orange);

		// 전체화면 구성
		setLayout(new BorderLayout());
		add("Center", pnl_text);
		add("East", pnl_button);

		// 화면 보이기
		setBounds(300, 300, 600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 연결자, 최초 상태 호출
		eventUp();
	}

	private void eventUp() {
		// 연결자(감시자)
		bt_new.addActionListener(this);
		bt_clear.addActionListener(this);
		bt_answer.addActionListener(this);
		bt_exit.addActionListener(this);
		
		tf.addActionListener(this);
		
		// 최초 상태
		bt_clear.setEnabled(false);
		bt_answer.setEnabled(false);
	}//eventUp end
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String str = e.getActionCommand();
		System.out.println("strAction="+str);
		if (obj instanceof JButton)
			customButtonAction(obj);
		else
			customTextAction(obj);
	}//handler end
	
	private void customButtonAction(Object obj) {
		if (obj == bt_new) {
			tf.setEditable(true);
			bt_clear.setEnabled(true);
			bt_answer.setEnabled(true);
			cnt = 0;// 정답입력 횟수 초기화
			for (int i = 0; i < baseballRandNum.length; i++) {
				int randNum = rand.nextInt(9)+1;
				if (i == 1 && randNum == baseballRandNum[i - 1]
					|| i == 2 && randNum == baseballRandNum[i - 1]
					|| i == 2 && randNum == baseballRandNum[i - 2]) {
					--i;
					continue;
				}
				baseballRandNum[i] = randNum;
			}
		} else if (obj == bt_clear) {
			ta.setText("");
			if(ta.getText().equals(""))
				bt_clear.setEnabled(false);
		} else if (obj == bt_answer) {
			ta.append("정답은 " + baseballRandNum[0] + baseballRandNum[1] + baseballRandNum[2] + "입니다!\n");
			bt_answer.setEnabled(false);// 정답출력후 정답 버튼 비활성화
			bt_clear.setEnabled(true);// 정답출력후 지우기 버튼 활성화
			tf.setText("");//TextField 비우기
			tf.setEditable(false);
			return;
		} else if (obj == bt_exit) {
			System.exit(0);
		} // JButton 동작
	}//customButtonAction end

	private void customTextAction(Object obj) {
		if (obj == tf) {
			ballCnt = 0;// 볼 횟수 매번 초기화
			strikeCnt = 0;// 스트라이크 횟수 매번 초기화

			String answerStr = tf.getText();
			if(!answerStr.matches("[1-9]{3}")){
			//if (!answerStr.matches("[\\d]{3}")) {
				JOptionPane.showMessageDialog(this, "0을 제외한 중복되지 않는 세자리숫자를 입력해주세요");
				tf.setText("");
				return;
			} // 세자리 숫자 제외의 입력 방지

			//int answerNum = Integer.parseInt(answerStr);
			//baseballAnswer[0] = answerNum / 100;
			//baseballAnswer[1] = (answerNum % 100) / 10;
			//baseballAnswer[2] = answerNum % 10;
			for (int i = 0; i < baseballAnswer.length; i++) {
				baseballAnswer[i] = answerStr.charAt(i)-48;
			}//입력 숫자 String ---> int 변환
			

			for (int i = 0; i < baseballAnswer.length - 1; i++) {
				for (int j = i + 1; j < baseballAnswer.length; j++) {
					if (baseballAnswer[i] == baseballAnswer[j]) {
						JOptionPane.showMessageDialog(this, "중복되지 않는 숫자를 입력해주세요");
						tf.setText("");
						return;
					}
				}
			} // 세자리수 중복 방지

			cnt++;//숫자입력후 게임진행횟수 증가
			bt_clear.setEnabled(true);//숫자 입력후 지우기 버튼 활성화
			
			for (int i = 0; i < baseballRandNum.length; i++) {
				for (int j = 0; j < baseballAnswer.length; j++) {
					if (baseballRandNum[i] == baseballAnswer[j]) {
						if (i == j)
							strikeCnt++;
						else
							ballCnt++;
					}
				}
			} // 스트라이크 볼 측정

			if (strikeCnt == 3) {
				ta.append("축하합니다~!!^^" + baseballAnswer[0] + baseballAnswer[1]
						+ baseballAnswer[2] + "는 정답입니다!\n");
				// 게임종료후 버튼, 텍스트 필드 비활성화
				tf.setEditable(false);
				bt_answer.setEnabled(false);
				tf.setText("");// textField 비우기
				return;
			} // 스트라이크 달성

			ta.append(cnt + "회 : " + baseballAnswer[0] + baseballAnswer[1] + baseballAnswer[2]);
			ta.append(" : " + ballCnt + "볼 " + strikeCnt + "스트라이크\n");

			tf.setText("");// textField 비우기
		} // textField 동작
	}//customTextAction end


	public static void main(String[] args) {
		new NumBaseballGame();
	}

}
