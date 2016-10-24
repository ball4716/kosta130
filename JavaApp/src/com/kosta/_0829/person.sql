--person.sql

drop table person;
create table person(
	no		number primary key,
	name	varchar2(15) not null,
	age		number not null,
	job		varchar2(15) not null
);

drop sequence person_seq;
create sequence person_seq
start with 1
increment by 1
nocycle
nocache;

select * from person