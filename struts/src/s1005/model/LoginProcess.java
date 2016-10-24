package s1005.model;

import java.util.HashMap;

import s1005.beans.UserInfo;

public class LoginProcess {
	//DB표현
	//login처리(아이디,비밀번호 확인) - login
	
	HashMap<String, UserInfo> userInfo;
	HashMap<String, String> userPass;
	
	public LoginProcess() {
		userInfo = new HashMap<>();
		userPass = new HashMap<>();
		
		//DB데이터
		userInfo.put("gildong", new UserInfo("나길동", "010-1234-5678", "gildong@kosta.com"));
		userInfo.put("lime", new UserInfo("길라임", "010-3333-4444", "lime@kosta.com"));
		userInfo.put("juwon", new UserInfo("김주원", "010-4432-3321", "won@kosta.com"));
	
		userPass.put("gildong", "1111");
		userPass.put("lime", "2222");
		userPass.put("juwon", "3333");
	}
	
	public UserInfo login(String userid, String userpwd) {
		System.out.println(userid+", "+userpwd);
		String dpass = userPass.get(userid);
		System.out.println("패스워드: "+dpass);
		if(dpass == null)//아이디가 존재하지 않는다면
			return null;
		
		if(!dpass.equals(userpwd))//아이디 존재, 비밀번호 불일치
			return null;
		
		//아이디 존재, 비밀번호 일치 했을때 아래의 코드를 실행!!
		UserInfo info = userInfo.get(userid);
		System.out.println("userid:"+info.getName());
		return info;
	}
}
