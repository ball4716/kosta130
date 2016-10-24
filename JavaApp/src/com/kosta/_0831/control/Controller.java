package com.kosta._0831.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.kosta._0831.model.PersonDAO;
import com.kosta._0831.model.PersonDTO;
import com.kosta._0831.view.InputForm;
import com.kosta._0831.view.MainView;
import com.kosta._0831.view.UpForm;

public class Controller implements ActionListener{
	/*
	 <��Ʈ�ѷ�(����)�� ����>
	 - ��ü ���α׷��� ���� �帧 ����!!
	 1. ����� ��û �м�
	 2. ����ڰ� �Է��� �����͸� ������
	 3. �𵨰�ü����!! M m = new M();	���� = m.method();
	 4. ������ �̵�
	 �߰��ɼ�) 2���� ����: ��ȿ�� �˻�
	 */
	
	//����
	MainView view_main;
	InputForm view_form;
	UpForm view_upform;
	
	int tmpNo;//������ȣ�� ����.
	
	public Controller() {
		view_main = new MainView();
		/*PersonDAO dao = new PersonDAO();
		ArrayList<PersonDTO> list = dao.selectAll();
		view_main.displayTable(list);*/
		view_main.displayTable(new PersonDAO().selectAll());
		view_form = new InputForm();
		view_upform = new UpForm();
		
		eventUp();
	}//������
	
	private void eventUp(){
		//���κ�
		view_main.bt_insert.addActionListener(this);
		view_main.bt_delete.addActionListener(this);
		view_main.bt_update.addActionListener(this);
		view_main.bt_exit.addActionListener(this);
		
		//�Է���
		view_form.bt_cancel.addActionListener(this);
		view_form.bt_submit.addActionListener(this);
		
		//������
		view_upform.bt_cancel.addActionListener(this);
		view_upform.bt_submit.addActionListener(this);
	}//eventUp
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//��ư�� ���۷��� ������
		if(obj == view_main.bt_insert){//1.����: �Է¹�ư Ŭ���ߴٸ�
			//4.�������̵�
			view_form.initForm();
			view_main.setVisible(false);
			view_form.setVisible(true);
		} else if(obj == view_form.bt_cancel){//1.�Է���: ��ҹ�ư�� Ŭ���ߴٸ�
			//4.�������̵�
			view_form.setVisible(false);
			view_main.setVisible(true);
		} else if(obj == view_form.bt_submit){//1.�Է���: �Է¹�ư�� Ŭ���ߴٸ�
			//2.����ڰ� �Է��� ������ ������
			String name = view_form.tf_name.getText().trim();
			String age = view_form.tf_age.getText().trim();
			String job = view_form.tf_job.getText().trim();
			PersonDTO person = new PersonDTO(0, name, Integer.parseInt(age), job);
			
			//3. �𵨰�ü����
			PersonDAO dao = new PersonDAO();
			
			//boolean flag = dao.insert(person);
			if(dao.insert(person)){//(flag){ //�Է¼���!!
				ArrayList<PersonDTO> list = dao.selectAll();
				view_main.displayTable(list);
				//4. �������̵�
				view_form.setVisible(false);
				view_main.setVisible(true);
			} else {//�Է� ����!!
				//JOptionPane.showMessageDialog(view_form, "�Է°��� Ȯ���ϼ���!!");
				view_form.showMsg("�Է°��� Ȯ���ϼ���!!");
				view_form.initForm();
			}
		} else if(obj == view_main.bt_delete){//1. ����: ������ưŬ��(DB �����)
			String no = view_main.showInput("������ ��ȣ:");
			System.out.println("������ȣ:"+no);
			PersonDAO dao = new PersonDAO();
			boolean flag = dao.delete(Integer.parseInt(no));
			if(flag){//������ �� �Ǿ��ٸ�
				//----> Ŭ���̾�Ʈ���� ������ ����� ���������!
				view_main.displayTable(dao.selectAll());//���ο� ������ ���Ű��
			} else {//������ �ȵǾ��ٸ�
				//----> ��ġ�Ǵ� ���� ��ã�Ҵ�!! : ��ȣ�� ���� x
				view_main.showMsg("��ġ�ϴ� ��ȣ�� �����ϴ�!!");
			}
		} else if(obj == view_main.bt_update){//����: ������ư Ŭ��(������ ���ϴ±���!!)
			//(��κ���) ������ȣ ������
			int row = view_main.table.getSelectedRow();//JTable ���õ� �� �ε���
			
			//���� JTable���� ���õ� ���� ���ٸ� -1����
			if(row == -1){
				view_main.showMsg("������ ���� �����ϼ���!");
				return;
			}
			
			int upNo = Integer.parseInt(""+view_main.table.getValueAt(row, 0));
			
			tmpNo = upNo;
			
			//������ȣ�� ����(�𵨷κ���) �����͸� ������
			PersonDAO dao = new PersonDAO();
			PersonDTO dto = dao.select(upNo); //��ȣ�� �ش��ϴ� �������(PersonDTO)�� ������
			
			view_upform.tf_name.setText(dto.getName());  
			view_upform.tf_age.setText(dto.getAge()+"");//setText(13+"")  
			view_upform.tf_job.setText(dto.getJob());  
			
			//1.���κ� ---> �������̵�
				//---> setVisible();
			view_main.setVisible(false);
			view_upform.setVisible(true);
			//2.�������� �ѷ��� �����͸� �˻�
				//---> DAO	select(���ϴ� ��ȣ);
			//�Է����� ��ĭ�� ���, �������� ä���� ĭ�� ���
			
			/*
			 		int upNo = Integer.parseInt(Object.toString());
			 		int upNo = Integer.parseInt((String)Object);
			 		
			 	JDK5 ---> AutoBoxing(Ŭ������ ��ȯ), UnBoxing(�⺻�ڷ������� ��ȯ)
			 	
			 		int su1 = new Integer(13); //��ڽ�
			 		
			 		Integer su2 = 15; //����ڽ�
			 */
			// int = (Integer)Object
		} else if (obj == view_upform.bt_cancel){//������: ��ҹ�ư Ŭ��
			//4.
			view_upform.setVisible(false);
			view_main.setVisible(true);
		} else if (obj == view_upform.bt_submit){//������: ������ưŬ��
			//����ڰ� ����� �������� DB������ ���ϴ±���!!
			String age = view_upform.tf_age.getText();
			String job = view_upform.tf_job.getText();
			
			//age�� job�� Ŭ������ �����ִ� �۾�
			PersonDTO dto = new PersonDTO();//no,name,age,job ---> 0,null,0,null
			dto.setAge(Integer.parseInt(age));//---> 0,null,18,null
			dto.setJob(job);//---> 0,null,18,"�屺"
			dto.setNo(tmpNo);
			
			PersonDAO dao = new PersonDAO();
			if(dao.update(dto)){
				view_main.displayTable(dao.selectAll());
				//(DB)����� ������ JTable �信 �ݿ�
				view_upform.setVisible(false);
				view_main.setVisible(true);
			} else {
				view_upform.showMsg("��������!!");
			}
		} else if (obj == view_main.bt_exit){
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
