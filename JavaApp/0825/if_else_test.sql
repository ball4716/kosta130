
/*
 if_else_test.sql
 ��1: ��� 7788�� SCOTT����̰� Ŀ�̼��� ���� �ʽ��ϴ�.
 ��2: ��� 7654�� MARTIN����̰� Ŀ�̼��� 1400 �޽��ϴ�. 
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
   
   if (vcomm is not null) -- Ŀ�̼��� �޴´ٸ�
    then 
       dbms_output.put_line('��� '||vempno||'�� '||vename||'����̰� Ŀ�̼��� '||
                         vcomm ||'�޽��ϴ�.');
       --�������: �޿�*12+Ŀ�̼�
       dbms_output.put_line('�������: '||(vsal*12 + vcomm));
    else --Ŀ�̼��� �����ʴ´ٸ�
       dbms_output.put_line('��� '||vempno||'�� '||vename||'����̰� Ŀ�̼��� '||
                         '���� �ʽ��ϴ�.');
       --�������: �޿�*12
       dbms_output.put_line('�������: '||vsal*12);                  
   end if; 
   
end;
/
