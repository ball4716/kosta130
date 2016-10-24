-- pro_test.sql

create or replace procedure del_deptno(delno number)
is

begin
	delete from dept03
	where deptno=delno;
	dbms_output.put_line('#'||delno||'번 부서를 삭제하였습니다!!');
end;
/