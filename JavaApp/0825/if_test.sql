--0825/if_test.sql
declare
	--��������
	su1 number;
	su2 number := 33;
begin
	su1 := 44;
	--su3 number; --�����߻�
	--su3 number:=44; --�����߻�
	
	if (su1 < su2)
		then dbms_output.put_line(su1||'�� '||su2||'���� �۴�!!');
	end if;
	
	if su1 >= su2
		then dbms_output.put_line(su1||'�� '||su2||'���� ũ�ų� ����!!');
	end if;
end;
/