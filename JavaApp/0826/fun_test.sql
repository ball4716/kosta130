--fun_test.sql
/*
����) Ư�����(��������� ����)���� ���ʽ��� �����Ϸ��� �ϴµ�
	�޿��� 200%�� �ش��ϴ� ����� �����Ϸ� �Ѵ�
	�� ���ʽ� �ݾ��� FUNCTION�� ���� ���Ͻÿ�
�Լ���: call_bonus
*/

create or replace function call_bonus(vename emp.ename%type)
return number
is
	--vsal number; --vsal emp.sal%type;
	vsal number := 0;
	bonus number;
begin
	--dbms_output.put_line('�ȳ�~!!');
	
	select sal into vsal
	from emp
	where ename=vename;
	
	--dbms_output.put_line(sal); --�÷��ν�X
	--dbms_output.put_line(vsal); --�����ν�O
	bonus := vsal*2;
	
	return bonus;
end;
/

--fun_test.sql
/*
����) Ư�����(��������� ����)���� ���ʽ��� �����Ϸ��� �ϴµ�
	�޿��� 200%�� �ش��ϴ� ����� �����Ϸ� �Ѵ�
	�� ���ʽ� �ݾ��� FUNCTION�� ���� ���Ͻÿ�
�Լ���: call_bonus
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
	
	--dbms_output.put_line(sal); --�÷��ν�X
	--dbms_output.put_line(vsal); --�����ν�O
	bonus := vsal*2;
	
	return vename||'����� ���ʽ� �ݾ��� '||bonus||'�Դϴ�.';
end;
/
show error