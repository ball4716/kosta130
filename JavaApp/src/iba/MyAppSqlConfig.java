package iba;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MyAppSqlConfig {
	/*
	 	sqlMapConfig.xml(sql문을 포함한 XML) 문서를 객체화 시켜주는 클래스
	 	
	 	SqlMapClient클래스 : XML에 작성한 sql문을 호출
	 */
	
	private static final SqlMapClient sqlMap;
	
	static{
		try{
		String resource = "./iba/sqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("MyAppSqlConfig초기화 중 에러");
		}	
	}
	
	public static SqlMapClient getSqlMapInstance(){
		return sqlMap;
	}
}
