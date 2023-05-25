select * from mysql.user;
show databases;

use mysql;
show tables;

use yeosu;
set AUTOCOMMIT=true;	-- 자동커밋 설정
show variables like 'autocommit';	-- 자동커밋 설정 확인
-- 테스트용 샘플 테이블 작성
create table sample1(item1 varchar(50) primary key, item2 int default 0, item3 datetime default current_timestamp);
insert into sample1 values ('kimkitae', 90, default);
insert into sample1 values ('chotaejeong', 60, default);
insert into sample1 values ('chokyoheing', 80, default);
select * from sample1;
-- drop table sample1;
-- 자동 커밋이 설정되어 있으므로 커밋하지 않아도 됨
commit;
select * from tbl_place;
select * from tbl_user;
drop table tbl_place;
update tbl_user set pw='rFPNhUtHXxUHGMVMhNXGplnn6v8C4wmdVeUZNGFX56+ikGqS1x5IPTor9R9njBr5aW8ISw=='where id = 'lys24';
select * from tbl_place where cate=? order by pcode desc limit 1;
-- ALTER TABLE sequence_table auto_increment=1; (MYSQL AUTO_INCREMENT 초기화)
-- auto_increment (시퀀스역할)

create table tbl_user(id varchar(20) primary key, pw varchar(300) not null, name varchar(20), phone varchar(13), addr varchar(300), email varchar(50), regdate datetime default current_timestamp);
create table tbl_notice(idx int auto_increment primary key, title varchar(100) not null, content varchar(1000), author varchar(20), file1 varchar(200), regdate datetime default current_timestamp, readcnt int default 0);
create table tbl_place(pcode varchar(20) primary key, pname varchar(20), cate varchar(6), addr varchar(300), phone varchar(13), comm varchar(1000), pic varchar(200), lat double, lng double);
create table tbl_cate(cate varchar(6), gname varchar(50), cname varchar(50));

create table tbl_qna();
create table tbl_review(
	r_num int auto_increment primary key, 
	cate varchar(20),
	pcode varchar(20),
	id varchar(20),
	review varchar(500),
	pic varchar(150),
	regdate datetime default current_timestamp	
	);

select cate, cname, gname from tbl_cate where cate like '01'||'%' order by cate;

select * from tbl_cate where cate='01';
