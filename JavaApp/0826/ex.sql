-- ex.sql

drop table 입고;
  --참조테이블
drop table 상품;


create table 상품
   (
         상품코드 char(4) constraint 상품_pk primary key,
         상품명    varchar2(15) not null,
         제조사    varchar2(15),
         소비자가격 number,
         재고수량  number default 0 --컬럼명이 명시되지 않았을때 기본값
   ); 

create table 입고
   (
	     입고번호 number constraint 입고_pk primary key, --일련번호
	     상품코드 char(4) constraint 입고_fk  references 상품(상품코드), 
	            --상품테이블에 저장된 상품코드를 참조
	     입고일자 date,
	     입고수량 number,
	     입고단가 number,
	     입고금액 number	     
   );


  
   
   
drop sequence 입고_seq;
create sequence 입고_seq
   start with 1
   increment by 1
   nocycle
   nocache;

   
   
 insert into 상품 (상품코드,상품명,제조사,소비자가격)
            values ('a001','마우스','삼송',1000);        

 insert into 상품 (상품코드,상품명,제조사,소비자가격)
            values ('a002','키보드','LC',2000);        

 insert into 상품 (상품코드,상품명,제조사,소비자가격)
            values ('a003','스피커','사우미',3000);
            
            
create or replace trigger product_insert
  after insert on 입고 -- 입고테이블에서 입력이 발생한 후
  for each row
  begin
     update 상품 set 재고수량 = 재고수량 + :new.입고수량
     where 상품코드 = :new.상품코드;
  end;
  /
   
            
 select * from 상품;   
 
 --입고번호,상품코드,입고일자,입고수량,입고단가,입고금액
insert into 입고 values (입고_seq.nextval, 'a002',sysdate,10,1000,10000);
insert into 입고 values (입고_seq.nextval, 'a002',sysdate,10,1000,10000);
insert into 입고 values (입고_seq.nextval, 'a002',sysdate,20,1000,10000);

select * from 입고;


update 입고 set 입고수량=40
where 입고번호 =7;  -- 20  ----> 40


delete from 입고
where 입고번호=4;  -- 10 ----->  0
