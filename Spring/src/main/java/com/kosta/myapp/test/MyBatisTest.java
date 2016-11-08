package com.kosta.myapp.test;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//SqlSession ��ü Ȯ��!! ----> iBatis�� SqlMapClient ����

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MyBatisTest {

	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory(){
		System.out.println("SqlFactory: "+sqlFactory);
	}
	
	@Test
	public void testSession(){
		SqlSession session = sqlFactory.openSession();
		System.out.println("Session: "+session);
	}
}
