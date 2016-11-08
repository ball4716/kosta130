package com.kosta.s1108.persistence;

import java.util.Map;

import com.kosta.s1108.domain.MemberVO;

public interface MemberDAO {
	public String getTime();
	
	//public void insertMember(MemberVO vo);
	public void insertMember(Map<String, String> map);
}
