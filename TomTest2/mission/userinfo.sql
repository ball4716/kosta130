drop table userinfo;
create table userinfo(
   id       varchar2(20)  primary key,
   pass     varchar2(20)  not null,
   name     varchar2(30)  not null,
   jumin    varchar2(14)  not null,
   birth    varchar2(10),
   zip      varchar2(7),
   addr     varchar2(100),
   email    varchar2(50)  not null,
   job      varchar2(30)
);

select * from userinfo;

delete from userinfo;

update userinfo set pass='1111' where id='gildong';