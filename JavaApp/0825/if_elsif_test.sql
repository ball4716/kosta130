--if_elsif_test.sql
/*
 DEPTNO DNAME                        LOC
------ ---------------------------- ---------
    10 ACCOUNTING                   NEW YORK
    20 RESEARCH                     DALLAS
    30 SALES                        CHICAGO
    40 OPERATIONS                   BOSTON
����) Ư������� �����ȣ, �����, �Ҽӵ� �μ����� ����Ͻÿ�
 */
declare
	empno emp.empno%type;
	vename emp.ename%type;
	vdeptno emp.deptno%type;
	vdname dept.dname%type;
begin
	select empno, ename, deptno into empno, vename, vdeptno
	from emp
	where empno=7788;
	
	if(vdeptno=10)
		then vdname := 'ACCOUNTING';
	elsif(vdeptno=20)
		then vdname := 'RESEARCH';
	elsif(vdeptno=30)
		then vdname := 'SALES';
	else
		--then
		vdname := 'OPERATIONS';
	end if;
	
	dbms_output.put_line('�����ȣ / ����� / �μ���');
	dbms_output.put_line(empno ||'/'|| vename ||'/'|| vdname);
end;
/