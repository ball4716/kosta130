--test.sql

/*
 dept���̺��� �����ؼ� dept_copy���̺��� ����
 */

drop table dept_copy;

create table dept_copy
as select * from dept;
-- ����(�÷�,�ڷ���)�� �����͸� ����