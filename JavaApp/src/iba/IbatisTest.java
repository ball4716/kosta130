package iba;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public class IbatisTest {
	public static void main(String[] args) throws Exception{
		SqlMapClient smc = MyAppSqlConfig.getSqlMapInstance();
		//'SMITH'��� ����
		//smc.delete(String id);
		//int t = smc.delete("delEname");
		//int t = smc.delete(String id, Object value);
		int t = smc.delete("emp.deleteEname", "KING");
		
		if(t==1){
			System.out.println("��������!!");
		}else{
			System.out.println("��������!!");
		}
		
		//7788����� ���� �����
		String ename = (String)smc.queryForObject("emp.select");
		System.out.println("�����: "+ename);
		
		//Ư������� ���� ��� �˻�
		//smc.queryForObject(arg0);//��ȸ�� ���� ������ 0,1
		//smc.queryForList(arg0);//��ȸ�� ���� ������ 2�� �̻��� ����Ǿ�����
		String empName="MARTIN";
		int empno = (int) smc.queryForObject("emp.selectEmpno", empName);
		
		System.out.println(empName+"����� ����� "+empno+"�Դϴ�!!");
		
		//��ü����� ������� ��ȸ,����Ͻÿ�!!
		System.out.println("#��ü �����#");
		List<String> list = smc.queryForList("emp.selectEnameAll");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(" "+list.get(i));
		}
		
		//��ü �μ����� ����Ͻÿ�
		System.out.println("======��ü�μ���======");
		List<String> dnameList = smc.queryForList("dept.select");
		for (int i = 0; i < dnameList.size(); i++) {
			System.out.println(" "+dnameList.get(i));
		}
	}
}
