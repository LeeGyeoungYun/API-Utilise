
/* 회원 엔티티  */
create table users(
	id number primary key,
	username varchar2(40) null,
	password varchar2(50) null,
	email varchar2(100) null,
	nickname varchar2(50) null,
	phone varchar2(30) null,
	create_date date not null,
	modify_date date null
);

/* 소셜 로그인 엔티티  */
create table sns_info(
	id number not null,
	sns_id varchar2(255) not null,
	sns_type varchar2(100) null,
	sns_name varchar2(255) null,
	sns_profile varchar2(255) null,
	sns_connect_date date null
);

--제약조건 설정 참조키 설정
alter table sns_info add constraint FK_SNS_INFO_ID foreign key(id) references users(id); 

--유저테이블 시퀀스
create sequence users_seq
increment by 1
start with 1
nocache;


insert into users( id, username, password,email, nickname,phone, create_date) values (users_seq.nextval, 'a','a','a','a','1',sysdate)