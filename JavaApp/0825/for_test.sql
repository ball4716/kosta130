---> for_test.sql

declare

begin
	for i in 1..10
	loop
		dbms_output.put_line('���� SQL�� �� ���ƿ�~!!');	
	end loop;
	
	dbms_output.put_line('--------------------');	
	--10���� 1���� ���
	for i in reverse 1..10 --for(int i=1; i<=10; i++)
	loop
		dbms_output.put_line(i);	
	end loop;
end;
/