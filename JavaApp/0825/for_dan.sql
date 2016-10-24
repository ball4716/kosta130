---->for_dan.sql
--3단에서 5단까지 출력

declare
	k number := 1;
begin
	for i in 3..5
	loop
		dbms_output.put_line('<'||i||'단>');
		for j in 1..9
		loop
			dbms_output.put_line(i||'*'||j||'='||i*j);
		end loop; --inner for loop
	end loop; --outer for loop
	
	dbms_output.put_line('=======================');
	--WHILE문 : 6단 출력
	while k<10
	loop
		dbms_output.put_line(6||'*'||k||'='||6*k);
		k := k+1;
	end loop;
end;
/