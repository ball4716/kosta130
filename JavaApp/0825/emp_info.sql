--0825/emp_info.sql
/*
 ���� �ּ�
 7788����� ���� ����� �����ȣ, �����, �޿��� ���
 */
declare --�����
	-- (����ο��� �����)��������
	-- ������ �ڷ���;
	a emp.empno%type;--number(4);
	b emp.ename%type;
	c emp.sal%type;
begin--�����
	--sql��(select,insert,delete,update), ���ǹ�, �ݺ���
	--select���� �ۼ��� �ÿ��� ��ȸ�ϴ� �÷��� ������ into���� �ݵ�� ���
	select empno, ename, sal into a,b,c --����ο��� ���� ����!
	from EMP
	where empno=7788;
/*	
	dbms_output.put_line(a);
	dbms_output.put_line(b);
	dbms_output.put_line(c);
*/
	dbms_output.put_line(a||'����� �̸��� '||b||'�̰� �޿��� '||c||'�Դϴ�!!');
end;
/