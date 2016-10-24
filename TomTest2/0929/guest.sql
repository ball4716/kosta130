drop table guest;
create table guest(
	id number(8) constraint guest_id_pk primary key,
	name varchar2(15) not null,
	pass varchar2(15) not null,
	email varchar2(30),
	tel varchar2(15),
	contents varchar2(200),
	gdate date
);

create sequence guest_seq
start with 1
increment by 1
nocycle
nocache;

select * from guest;

insert into guest values (guest_seq.nextval,'길동1','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동2','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동3','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동4','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동5','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동6','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동7','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동8','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동9','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동10','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동11','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동12','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동13','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동14','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동15','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동16','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동17','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동18','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동19','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동20','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동21','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동22','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동23','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동24','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동25','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동26','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동27','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동28','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동29','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동30','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동31','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동32','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동33','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동34','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동35','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);
insert into guest values (guest_seq.nextval,'길동36','1234','gildong@daum.net','1234-5678','동에번쩍',sysdate);

select id,name,pass,tel,gdate,contents
from (select id,name,pass,tel,gdate,contents, rownum rn
	  from ( select id,name,pass,tel,gdate,contents
		     from guest
		     order by id desc))
where rn between 1 and 10;


--2페이지
select id,name,pass,tel,gdate,contents
from (select id,name,pass,tel,gdate,contents, rownum rn
	  from ( select id,name,pass,tel,gdate,contents
		     from guest
		     order by id desc))
where rn between 11 and 20;

--2페이지
select id,name,pass,tel,gdate,contents
from (select id,name,pass,tel,gdate,contents, rownum rn
	  from ( select id,name,pass,tel,gdate,contents
		     from guest
		     order by id desc))
where rn between 21 and 30;

--1 ---> 1(page*10-9)~10
--2 ---> 11~20
--3 ---> 21~30
