--pro_test.sql
/*
���ν�����: dept_info
*/

create or replace procedure dept_info
is
	--��������, Ŀ������
	cursor cur is select deptno, dname, loc from dept;
	vdept dept%rowtype;--���̺��%rowtype;--���̺��.�÷���%type;
		--vdeptŸ������ deptno, dname, loc�÷��� �����ϰ���
begin
	open cur;
		dbms_output.put_line('�μ���ȣ/�μ���/�μ���ġ');
		dbms_output.put_line('==================');
		
		loop
			fetch cur into vdept; -- deptno, dname,loc
			--fetch�ѹ� ����� �ѹ��� ����� ��������
			exit when cur%notfound; --Ŀ���� ����� ���� ���ٸ�
			dbms_output.put_line(vdept.deptno||'/'||vdept.dname||'/'||vdept.loc);
		end loop;
	close cur;
end;
/

create or replace procedure dept_member(vdeptno in dept.deptno%type, haeun out number)--�Ķ���� ���� �μ�����
is
	--(����ο��� �����)���� ����
	--Ŀ������
	cursor cur is select empno, ename, sal, hiredate from emp where deptno = vdeptno;
	vemp emp%rowtype;
	cnt number := 0;
begin
	haeun := 333;
	
	dbms_output.put_line('�����ȣ-�����-�޿�-�Ի���');
	dbms_output.put_line('=====================');
	
	for vemp in cur
	loop
		dbms_output.put_line(vemp.empno||' - '||vemp.ename||' - '||vemp.sal||' - '||vemp.hiredate);
		cnt := cnt + 1;
	end loop;
	dbms_output.put_line(vdeptno||'�����: '||cnt||'��');
end;
/

create or replace procedure sal_graph
is
	cursor cur is select ename, sal from emp order by sal desc;
	vemp emp%rowtype;
	cnt number := 0;
	graph varchar2(100) := '';
begin
	dbms_output.put_line('*************�޿��׷���**************');
	
	for vemp in cur
	loop
		cnt := floor(vemp.sal/100);
		for vemp in 1..cnt
		loop
			graph := graph||'*';
		end loop;
		dbms_output.put_line(vemp.ename||'('||vemp.sal||')');
		dbms_output.put_line(graph);
		graph := '';
	end loop;
end;
/
show error














