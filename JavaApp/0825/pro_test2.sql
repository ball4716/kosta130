---> pro_test2.sql
---> ���ν����� : del_ename(delName varchar2)

create or replace procedure del_ename(delName varchar2)
is
	cnt number;
begin
	select count(*) into cnt
	from emp03
	where ename=delName;
	
	if(cnt>0)
	then
		delete from emp03
		where ename = delName;
		dbms_output.put_line('#'||delName||'�� �����Ͽ����ϴ�!!');
	else
		dbms_output.put_line('#'||delName||'�� ���������ʽ��ϴ�!!');
	end if;
end;
/