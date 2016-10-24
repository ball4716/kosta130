drop table userinfo;
create table userinfo(
	id      varchar2(20) constraint userinfo_pk primary key,
	pass    varchar2(20) not null,
	name    varchar2(20) not null,
	ssn1    char(6),
	ssn2    char(7),
	phone   varchar2(13),
	addr    varchar2(50),
	job     varchar2(30)
);

select * from userinfo;

insert into userinfo (id,pass,name) 
             values ('admin','1234','°ü¸®ÀÚ');