
/*
 if_else_test.sql
 예1: 사번 7788은 SCOTT사원이고 커미션을 받지 않습니다.
 예2: 사번 7654은 MARTIN사원이고 커미션을 1400 받습니다. 
*/

declare
   vename emp.ename%type;
   vcomm emp.comm%type;
   vempno emp.empno%type;
   vsal emp.sal%type;
begin
   select ename,comm,empno,sal into vename,vcomm,vempno,vsal
   from emp
   where empno=7788;
   
   if (vcomm is not null) -- 커미션을 받는다면
    then 
       dbms_output.put_line('사번 '||vempno||'은 '||vename||'사원이고 커미션을 '||
                         vcomm ||'받습니다.');
       --연봉출력: 급여*12+커미션
       dbms_output.put_line('연봉출력: '||(vsal*12 + vcomm));
    else --커미션을 받지않는다면
       dbms_output.put_line('사번 '||vempno||'은 '||vename||'사원이고 커미션을 '||
                         '받지 않습니다.');
       --연봉출력: 급여*12
       dbms_output.put_line('연봉출력: '||vsal*12);                  
   end if; 
   
end;
/
