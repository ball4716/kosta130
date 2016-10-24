--loop_test.sql
--1부터 10까지 출력하기
--3,6,9
declare
	i number := 0;
	j number := 3;
begin
	loop
		i := i+1;
		dbms_output.put_line(i);
		exit when i=10;
	end loop;
	dbms_output.put_line('-------------------------------');
	
	loop
		dbms_output.put_line(j);
		if (j=9)
			then exit;
		end if;
		j := j+3;
	end loop;
end; 
/