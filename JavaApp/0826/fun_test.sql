--fun_test.sql
/*
문제) 특정사원(사원명으로 구분)에게 보너스를 지급하려고 하는데
	급여에 200%에 해당하는 비용을 지급하려 한다
	이 보너스 금액을 FUNCTION을 통해 구하시오
함수명: call_bonus
*/

create or replace function call_bonus(vename emp.ename%type)
return number
is
	--vsal number; --vsal emp.sal%type;
	vsal number := 0;
	bonus number;
begin
	--dbms_output.put_line('안녕~!!');
	
	select sal into vsal
	from emp
	where ename=vename;
	
	--dbms_output.put_line(sal); --컬럼인식X
	--dbms_output.put_line(vsal); --변수인식O
	bonus := vsal*2;
	
	return bonus;
end;
/

--fun_test.sql
/*
문제) 특정사원(사원명으로 구분)에게 보너스를 지급하려고 하는데
	급여에 200%에 해당하는 비용을 지급하려 한다
	이 보너스 금액을 FUNCTION을 통해 구하시오
함수명: call_bonus
*/

create or replace function call_bonus2(vename emp.ename%type)
return varchar2
is
	--vsal number; --vsal emp.sal%type;
	vsal number := 0;
	bonus number;
begin
	
	select sal into vsal
	from emp
	where ename=vename;
	
	--dbms_output.put_line(sal); --컬럼인식X
	--dbms_output.put_line(vsal); --변수인식O
	bonus := vsal*2;
	
	return vename||'사원의 보너스 금액은 '||bonus||'입니다.';
end;
/
show error