create table Haksa(
	name varchar2(15) constraint Haksa_name_pk primary key,
	age number(3),
	info varchar2(15),
	jobno number(2),
	constraint Haksa_jobno_fk foreign key(jobno) references Job(jobno)
);

create table Job(
	jobno number(2) constraint Job_jobno_pk primary key,
	jobname varchar2(15)
);

insert into Job values (10,'학생');
insert into Job values (20,'교수');
insert into Job values (30,'관리자');