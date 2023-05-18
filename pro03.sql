select * from mysql.user;

show databases;


use yeosu;

use jeju;


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
-- commit;
