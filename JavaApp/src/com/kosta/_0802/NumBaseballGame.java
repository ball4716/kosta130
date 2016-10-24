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
		// Game ���� �ʱ�ȭ
		baseballRandNum = new int[3];
		baseballAnswer = new int[3];
		cnt = 0;
		ballCnt = 0;
		strikeCnt = 0;
		rand = new Random();

		// title
		setTitle("���ھ߱�����");

		// ��ư �ʱ�ȭ
		bt_new = new JButton("������");
		bt_clear = new JButton("�����");
		bt_answer = new JButton("����");
		bt_exit = new JButton("������");

		// textArea�ʱ�ȭ + ��ũ�� ���̱�
		ta = new JTextArea();
		ta.setEditable(false);// textArea�� �����Է� �Ұ�

		scroll_bar = new JScrollPane(ta);
		scroll_bar.setBorder(new BevelBorder(BevelBorder.LOWERED));

		// textField�ʱ�ȭ + �� �ʱ�ȭ
		tf = new JTextField(40);
		tf.setEditable(false);// ���ʿ� �Է� �Ұ�

		lb = new JLabel("�Է�: ");

		// ���̾ƿ� �ʱ�ȭ
		pnl_text = new JPanel();
		pnl_text_area = new JPanel();
		pnl_text_field = new JPanel();

		pnl_button = new JPanel();

		// ȭ�鱸��
		// ����ȭ�� ����
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

		// ����ȭ�� ����
		pnl_button.setLayout(new GridLayout(7, 1, 40, 40));
		pnl_button.add(new JLabel());
		pnl_button.add(bt_new);
		pnl_button.add(bt_clear);
		pnl_button.add(bt_answer);
		pnl_button.add(bt_exit);
		pnl_button.setBackground(Color.orange);

		// ��üȭ�� ����
		setLayout(new BorderLayout());
		add("Center", pnl_text);
		add("East", pnl_button);

		// ȭ�� ���̱�
		setBounds(300, 300, 600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ������, ���� ���� ȣ��
		eventUp();
	}

	private void eventUp() {
		// ������(������)
		bt_new.addActionListener(this);
		bt_clear.addActionListener(this);
		bt_answer.addActionListener(this);
		bt_exit.addActionListener(this);
		
		tf.addActionListener(this);
		
		// ���� ����
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
			cnt = 0;// �����Է� Ƚ�� �ʱ�ȭ
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
			ta.append("������ " + baseballRandNum[0] + baseballRandNum[1] + baseballRandNum[2] + "�Դϴ�!\n");
			bt_answer.setEnabled(false);// ��������� ���� ��ư ��Ȱ��ȭ
			bt_clear.setEnabled(true);// ��������� ����� ��ư Ȱ��ȭ
			tf.setText("");//TextField ����
			tf.setEditable(false);
			return;
		} else if (obj == bt_exit) {
			System.exit(0);
		} // JButton ����
	}//customButtonAction end

	private void customTextAction(Object obj) {
		if (obj == tf) {
			ballCnt = 0;// �� Ƚ�� �Ź� �ʱ�ȭ
			strikeCnt = 0;// ��Ʈ����ũ Ƚ�� �Ź� �ʱ�ȭ

			String answerStr = tf.getText();
			if(!answerStr.matches("[1-9]{3}")){
			//if (!answerStr.matches("[\\d]{3}")) {
				JOptionPane.showMessageDialog(this, "0�� ������ �ߺ����� �ʴ� ���ڸ����ڸ� �Է����ּ���");
				tf.setText("");
				return;
			} // ���ڸ� ���� ������ �Է� ����

			//int answerNum = Integer.parseInt(answerStr);
			//baseballAnswer[0] = answerNum / 100;
			//baseballAnswer[1] = (answerNum % 100) / 10;
			//baseballAnswer[2] = answerNum % 10;
			for (int i = 0; i < baseballAnswer.length; i++) {
				baseballAnswer[i] = answerStr.charAt(i)-48;
			}//�Է� ���� String ---> int ��ȯ
			

			for (int i = 0; i < baseballAnswer.length - 1; i++) {
				for (int j = i + 1; j < baseballAnswer.length; j++) {
					if (baseballAnswer[i] == baseballAnswer[j]) {
						JOptionPane.showMessageDialog(this, "�ߺ����� �ʴ� ���ڸ� �Է����ּ���");
						tf.setText("");
						return;
					}
				}
			} // ���ڸ��� �ߺ� ����

			cnt++;//�����Է��� ��������Ƚ�� ����
			bt_clear.setEnabled(true);//���� �Է��� ����� ��ư Ȱ��ȭ
			
			for (int i = 0; i < baseballRandNum.length; i++) {
				for (int j = 0; j < baseballAnswer.length; j++) {
					if (baseballRandNum[i] == baseballAnswer[j]) {
						if (i == j)
							strikeCnt++;
						else
							ballCnt++;
					}
				}
			} // ��Ʈ����ũ �� ����

			if (strikeCnt == 3) {
				ta.append("�����մϴ�~!!^^" + baseballAnswer[0] + baseballAnswer[1]
						+ baseballAnswer[2] + "�� �����Դϴ�!\n");
				// ���������� ��ư, �ؽ�Ʈ �ʵ� ��Ȱ��ȭ
				tf.setEditable(false);
				bt_answer.setEnabled(false);
				tf.setText("");// textField ����
				return;
			} // ��Ʈ����ũ �޼�

			ta.append(cnt + "ȸ : " + baseballAnswer[0] + baseballAnswer[1] + baseballAnswer[2]);
			ta.append(" : " + ballCnt + "�� " + strikeCnt + "��Ʈ����ũ\n");

			tf.setText("");// textField ����
		} // textField ����
	}//customTextAction end


	public static void main(String[] args) {
		new NumBaseballGame();
	}

}
