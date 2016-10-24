package s1006.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginActionForm extends ActionForm{
	//���ȿ� �Էµ� �����Ϳ� ���� ��ȿ�� �˻�
	private String userid;
	private String userpwd;
	
	
	
	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getUserpwd() {
		return userpwd;
	}



	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}



	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// ���͸޼ҵ带 ���� �ʱ�ȭ�� �����Ϳ� ���� ��ȿ�� �˻�
		
		 ActionErrors errs = new ActionErrors();//�����޽��� ��� �ٱ���(��ٱ���)
		
		//���̵� ===> ��, ������ ������ ���̵� üũ(��:"gil dong"," gildong")
		if(userid==null || userid.length()==0){//�� �� üũ
			//errs.add("��� ������ Ű��", new ActionMessage("properties���Ͽ� �����ϴ� Ű��"));
			errs.add("errorid", new ActionMessage("invalidid","���̵� �Է�!!"));
		}else if(userid.indexOf(" ")>-1 || userid.indexOf("\t")>-1 || userid.indexOf("\n")>-1){
			//���� üũ
			errs.add("errorid", new ActionMessage("invalidid","������ ������ �� �����ϴ�!!"));
		}
		
		//��� ===> ��
		if(userpwd==null || userpwd.length()==0){//��üũ
			errs.add("errorpwd", new ActionMessage("invalidpass"));
		}
		return errs;
	}
}
