-- pro_test.sql

create or replace procedure del_deptno(delno number)
is

begin
	delete from dept03
	where deptno=delno;
	dbms_output.put_line('#'||delno||'�� �μ��� �����Ͽ����ϴ�!!');
end;
/