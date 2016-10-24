---> pro_test2.sql
---> 프로시저명 : del_ename(delName varchar2)

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
		dbms_output.put_line('#'||delName||'을 삭제하였습니다!!');
	else
		dbms_output.put_line('#'||delName||'은 존재하지않습니다!!');
	end if;
end;
/