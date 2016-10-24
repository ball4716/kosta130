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

insert into guest values (guest_seq.nextval,'�浿1','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿2','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿3','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿4','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿5','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿6','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿7','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿8','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿9','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿10','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿11','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿12','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿13','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿14','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿15','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿16','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿17','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿18','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿19','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿20','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿21','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿22','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿23','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿24','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿25','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿26','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿27','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿28','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿29','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿30','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿31','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿32','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿33','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿34','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿35','1234','gildong@daum.net','1234-5678','������½',sysdate);
insert into guest values (guest_seq.nextval,'�浿36','1234','gildong@daum.net','1234-5678','������½',sysdate);

select id,name,pass,tel,gdate,contents
from (select id,name,pass,tel,gdate,contents, rownum rn
	  from ( select id,name,pass,tel,gdate,contents
		     from guest
		     order by id desc))
where rn between 1 and 10;


--2������
select id,name,pass,tel,gdate,contents
from (select id,name,pass,tel,gdate,contents, rownum rn
	  from ( select id,name,pass,tel,gdate,contents
		     from guest
		     order by id desc))
where rn between 11 and 20;

--2������
select id,name,pass,tel,gdate,contents
from (select id,name,pass,tel,gdate,contents, rownum rn
	  from ( select id,name,pass,tel,gdate,contents
		     from guest
		     order by id desc))
where rn between 21 and 30;

--1 ---> 1(page*10-9)~10
--2 ---> 11~20
--3 ---> 21~30
