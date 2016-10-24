-- ex.sql

drop table �԰�;
  --�������̺�
drop table ��ǰ;


create table ��ǰ
   (
         ��ǰ�ڵ� char(4) constraint ��ǰ_pk primary key,
         ��ǰ��    varchar2(15) not null,
         ������    varchar2(15),
         �Һ��ڰ��� number,
         ������  number default 0 --�÷����� ��õ��� �ʾ����� �⺻��
   ); 

create table �԰�
   (
	     �԰��ȣ number constraint �԰�_pk primary key, --�Ϸù�ȣ
	     ��ǰ�ڵ� char(4) constraint �԰�_fk  references ��ǰ(��ǰ�ڵ�), 
	            --��ǰ���̺� ����� ��ǰ�ڵ带 ����
	     �԰����� date,
	     �԰���� number,
	     �԰�ܰ� number,
	     �԰�ݾ� number	     
   );


  
   
   
drop sequence �԰�_seq;
create sequence �԰�_seq
   start with 1
   increment by 1
   nocycle
   nocache;

   
   
 insert into ��ǰ (��ǰ�ڵ�,��ǰ��,������,�Һ��ڰ���)
            values ('a001','���콺','���',1000);        

 insert into ��ǰ (��ǰ�ڵ�,��ǰ��,������,�Һ��ڰ���)
            values ('a002','Ű����','LC',2000);        

 insert into ��ǰ (��ǰ�ڵ�,��ǰ��,������,�Һ��ڰ���)
            values ('a003','����Ŀ','����',3000);
            
            
create or replace trigger product_insert
  after insert on �԰� -- �԰����̺��� �Է��� �߻��� ��
  for each row
  begin
     update ��ǰ set ������ = ������ + :new.�԰����
     where ��ǰ�ڵ� = :new.��ǰ�ڵ�;
  end;
  /
   
            
 select * from ��ǰ;   
 
 --�԰��ȣ,��ǰ�ڵ�,�԰�����,�԰����,�԰�ܰ�,�԰�ݾ�
insert into �԰� values (�԰�_seq.nextval, 'a002',sysdate,10,1000,10000);
insert into �԰� values (�԰�_seq.nextval, 'a002',sysdate,10,1000,10000);
insert into �԰� values (�԰�_seq.nextval, 'a002',sysdate,20,1000,10000);

select * from �԰�;


update �԰� set �԰����=40
where �԰��ȣ =7;  -- 20  ----> 40


delete from �԰�
where �԰��ȣ=4;  -- 10 ----->  0
