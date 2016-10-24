--0825/emp_info.sql
/*
 나도 주석
 7788사번을 갖는 사원의 사원번호, 사원명, 급여를 출력
 */
declare --선언부
	-- (실행부에서 사용할)변수선언
	-- 변수명 자료형;
	a emp.empno%type;--number(4);
	b emp.ename%type;
	c emp.sal%type;
begin--실행부
	--sql문(select,insert,delete,update), 조건문, 반복문
	--select문을 작성할 시에는 조회하는 컬럼을 저장할 into절을 반드시 명시
	select empno, ename, sal into a,b,c --선언부에서 변수 선언!
	from EMP
	where empno=7788;
/*	
	dbms_output.put_line(a);
	dbms_output.put_line(b);
	dbms_output.put_line(c);
*/
	dbms_output.put_line(a||'사원의 이름은 '||b||'이고 급여는 '||c||'입니다!!');
end;
/