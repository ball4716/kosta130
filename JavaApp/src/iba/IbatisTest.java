package iba;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public class IbatisTest {
	public static void main(String[] args) throws Exception{
		SqlMapClient smc = MyAppSqlConfig.getSqlMapInstance();
		//'SMITH'사원 삭제
		//smc.delete(String id);
		//int t = smc.delete("delEname");
		//int t = smc.delete(String id, Object value);
		int t = smc.delete("emp.deleteEname", "KING");
		
		if(t==1){
			System.out.println("삭제성공!!");
		}else{
			System.out.println("삭제실패!!");
		}
		
		//7788사원에 대한 사원명
		String ename = (String)smc.queryForObject("emp.select");
		System.out.println("사원명: "+ename);
		
		//특정사원명에 대한 사번 검색
		//smc.queryForObject(arg0);//조회된 행의 갯수가 0,1
		//smc.queryForList(arg0);//조회된 행의 갯수가 2개 이상이 예상되어질때
		String empName="MARTIN";
		int empno = (int) smc.queryForObject("emp.selectEmpno", empName);
		
		System.out.println(empName+"사원의 사번은 "+empno+"입니다!!");
		
		//전체사원의 사원명을 조회,출력하시오!!
		System.out.println("#전체 사원명#");
		List<String> list = smc.queryForList("emp.selectEnameAll");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(" "+list.get(i));
		}
		
		//전체 부서명을 출력하시오
		System.out.println("======전체부서명======");
		List<String> dnameList = smc.queryForList("dept.select");
		for (int i = 0; i < dnameList.size(); i++) {
			System.out.println(" "+dnameList.get(i));
		}
	}
}
