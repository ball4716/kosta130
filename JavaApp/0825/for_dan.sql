---->for_dan.sql
--3�ܿ��� 5�ܱ��� ���

declare
	k number := 1;
begin
	for i in 3..5
	loop
		dbms_output.put_line('<'||i||'��>');
		for j in 1..9
		loop
			dbms_output.put_line(i||'*'||j||'='||i*j);
		end loop; --inner for loop
	end loop; --outer for loop
	
	dbms_output.put_line('=======================');
	--WHILE�� : 6�� ���
	while k<10
	loop
		dbms_output.put_line(6||'*'||k||'='||6*k);
		k := k+1;
	end loop;
end;
/