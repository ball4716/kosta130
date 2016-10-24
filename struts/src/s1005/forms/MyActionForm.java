package s1005.forms;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class MyActionForm extends ActionForm{
	//����ڰ� �Է��� �����Ϳ� ���� ��ȿ�� �˻�
	private String username;//�ݵ�� input�� name�� ��ġ��ų ��!!
	private String userage;
	
	public String getUserage() {
		return userage;
	}

	public void setUserage(String userage) {
		this.userage = userage;
	}

	public String getUsername(){
		System.out.println("getUsername()");
		return username;
	}
	
	public void setUsername(String username){
		System.out.println("setUsername() : "+username);
		this.username = username;
	}
	
/*	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		//�ʱ�ȭ �۾�, ���� �۾�
		System.out.println("reset()");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}*/
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		//��ȿ�� �˻�
		System.out.println("validate()");
		
		System.out.println("userage: "+userage);
		
		ActionErrors errors = new ActionErrors();
		//errors: �����޽����� ��� �ٱ��� ==> �� �ٱ���
		
		//�����޽��� ���!!
		//errors.add(String key1, new ActionMessage(String key2);
		//key1: ��� ������ Ű��
		//key2: application.properties���Ͽ� ���ǵ� �Ӽ���
		
/*		if(userage > 100){
			System.out.println("���������ϼ���!");
		}*/
		
		if(username.length()==0)//�Էµ� ���� ���ٸ�
			errors.add("err", new ActionMessage("testError"));
		
		
		return errors;//�� �ٱ��� ���Ͻ� ���� ������ ǥ�� : �����͵��� ���� ��ȿ�ϴ�
		//return null;//null ���Ͻ� ���� ������ ǥ��
	}

}
