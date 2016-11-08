package com.kosta.myapp.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kosta.s1108.domain.MemberVO;
import com.kosta.s1108.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
public class MemberDAOTest {

	@Autowired
	// ==@Inject
	private MemberDAO dao;

	@Test
	public void testTime() throws Exception {
		System.out.println(dao.getTime());
	}

	@Test
	public void testInsertMember() throws Exception {
		MemberVO vo = new MemberVO();
		/*
		 * vo.setUserid("lime"); vo.setUserpw("999"); vo.setUsername("차라임");
		 * vo.setEmail("lime@daum.net");
		 */

		Map<String, String> map = new HashMap<>();
		map.put("userid", "lime3");
		map.put("userpw", "999");
		map.put("username", "차라임");
		map.put("email", "lime3@naver.com");
		
		dao.insertMember(map);
	}
}
