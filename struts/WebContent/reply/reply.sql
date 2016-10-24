-- reply/reply.sql

-- ´ñ±ÛÅ×ÀÌºí
drop table reply;
create table reply(
	no		number primary key,		-- ´ñ±Û ¹øÈ£
	name 	varchar2(15) not null,	
	content varchar2(200) not null
);

drop sequence reply_seq;
create sequence reply_seq
start with 1
increment by 1
nocycle
nocache;