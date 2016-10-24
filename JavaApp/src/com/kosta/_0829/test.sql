--test.sql

/*
 dept테이블을 복사해서 dept_copy테이블을 생성
 */

drop table dept_copy;

create table dept_copy
as select * from dept;
-- 구조(컬럼,자료형)와 데이터를 복사