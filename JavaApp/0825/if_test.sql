--0825/if_test.sql
declare
	--변수선언
	su1 number;
	su2 number := 33;
begin
	su1 := 44;
	--su3 number; --에러발생
	--su3 number:=44; --에러발생
	
	if (su1 < su2)
		then dbms_output.put_line(su1||'은 '||su2||'보다 작다!!');
	end if;
	
	if su1 >= su2
		then dbms_output.put_line(su1||'은 '||su2||'보다 크거나 같다!!');
	end if;
end;
/