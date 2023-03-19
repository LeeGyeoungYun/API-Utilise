
create table post( -- 게시물 테이블
	pno number primary key,                  --게시판 번호
	postId varchar2(40) not null,		     --게시판 작성아이디
	postPwd varchar2(80) not null,	         --게시판 작성비밀번호
	postComment varchar2(4000) not null,     --게시판 내용  
	delete_flag char(1) DEFAULT 'N' not null,--삭제 여부
	create_date date not null,				 --생성일
	update_date date null,					 --수정일
	delete_date date null				     --삭제일
 
);

select * from post order by pno desc;
drop table post;

create sequence post_seq
start with 1
increment by 1
nocache;

drop sequence post_seq;


select * from post where pno= 1;

