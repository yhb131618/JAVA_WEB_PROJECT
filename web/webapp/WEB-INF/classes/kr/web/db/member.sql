-- merber table
create table member(
	num int primary key auto_increment,
	id varchar(20) not null,
	pass varchar(20) not null,
	name varchar(30) not null,
	age int not null,
	email varchar(30) not null,
	phone varchar(30) not null
)

select * from member;


-- insert(저장)
insert into member(id, pass, name, age, email, phone)
values('admin', 'admin', '관리자', 40, 'bit@naver.com', '010-111-111');

select * from member;

-- update(수정)
update member set age=45, phone='010-1111-1111' where id = 'admin';

select * from member;

-- delete(삭제)
delete from member where id = 'admin';
