--pro_test.sql
/*
프로시저명: dept_info
*/

create or replace procedure dept_info
is
	--변수선언, 커서선언
	cursor cur is select deptno, dname, loc from dept;
	vdept dept%rowtype;--테이블명%rowtype;--테이블명.컬럼명%type;
		--vdept타입으로 deptno, dname, loc컬럼을 참조하겠음
begin
	open cur;
		dbms_output.put_line('부서번호/부서명/부서위치');
		dbms_output.put_line('==================');
		
		loop
			fetch cur into vdept; -- deptno, dname,loc
			--fetch한번 실행시 한번의 결과행 가져오기
			exit when cur%notfound; --커서에 인출된 행이 없다면
			dbms_output.put_line(vdept.deptno||'/'||vdept.dname||'/'||vdept.loc);
		end loop;
	close cur;
end;
/

create or replace procedure dept_member(vdeptno in dept.deptno%type, haeun out number)--파라미터 통해 부서정보
is
	--(실행부에서 사용할)변수 선언
	--커서정의
	cursor cur is select empno, ename, sal, hiredate from emp where deptno = vdeptno;
	vemp emp%rowtype;
	cnt number := 0;
begin
	haeun := 333;
	
	dbms_output.put_line('사원번호-사원명-급여-입사일');
	dbms_output.put_line('=====================');
	
	for vemp in cur
	loop
		dbms_output.put_line(vemp.empno||' - '||vemp.ename||' - '||vemp.sal||' - '||vemp.hiredate);
		cnt := cnt + 1;
	end loop;
	dbms_output.put_line(vdeptno||'사원수: '||cnt||'명');
end;
/

create or replace procedure sal_graph
is
	cursor cur is select ename, sal from emp order by sal desc;
	vemp emp%rowtype;
	cnt number := 0;
	graph varchar2(100) := '';
begin
	dbms_output.put_line('*************급여그래프**************');
	
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














