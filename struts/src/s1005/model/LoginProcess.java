package s1005.model;

import java.util.HashMap;

import s1005.beans.UserInfo;

public class LoginProcess {
	//DBǥ��
	//loginó��(���̵�,��й�ȣ Ȯ��) - login
	
	HashMap<String, UserInfo> userInfo;
	HashMap<String, String> userPass;
	
	public LoginProcess() {
		userInfo = new HashMap<>();
		userPass = new HashMap<>();
		
		//DB������
		userInfo.put("gildong", new UserInfo("���浿", "010-1234-5678", "gildong@kosta.com"));
		userInfo.put("lime", new UserInfo("�����", "010-3333-4444", "lime@kosta.com"));
		userInfo.put("juwon", new UserInfo("���ֿ�", "010-4432-3321", "won@kosta.com"));
	
		userPass.put("gildong", "1111");
		userPass.put("lime", "2222");
		userPass.put("juwon", "3333");
	}
	
	public UserInfo login(String userid, String userpwd) {
		System.out.println(userid+", "+userpwd);
		String dpass = userPass.get(userid);
		System.out.println("�н�����: "+dpass);
		if(dpass == null)//���̵� �������� �ʴ´ٸ�
			return null;
		
		if(!dpass.equals(userpwd))//���̵� ����, ��й�ȣ ����ġ
			return null;
		
		//���̵� ����, ��й�ȣ ��ġ ������ �Ʒ��� �ڵ带 ����!!
		UserInfo info = userInfo.get(userid);
		System.out.println("userid:"+info.getName());
		return info;
	}
}
