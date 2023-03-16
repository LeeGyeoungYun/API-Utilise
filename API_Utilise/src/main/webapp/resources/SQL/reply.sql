
create table REPLY(
	rno number primary key,					--댓글번호
	pno number not null,				    --게시물 번호 (참조키)
	replyId varchar2(40) not null,          --댓글 아이디
	replyPwd varchar2(80) not null,         --댓글 패스워드
	replyComment varchar2(4000) not null,   --댓글 내용
	replyClass number not null,             --댓글과 대댓글을 구별하기 위함 댓글이면 0, 대댓글이면 1로 표시
	replyOrder number not null,             --댓글과 대댓글 관계에 맞게 정렬되어 페이지에 정렬된 상태로 전달하기 위해서 추가
	replyGroupNum number not null,          -- 대댓글이 특정 댓글에 종속되어있다는 것을 표시하기 위한 수단
	create_date date not null,				--생성일
	update_date date null,					--수정일
	delete_date date null				    --삭제일
);

select * from reply order by rno

create sequence rno_seq  -- 댓글 시퀀스 생성
start with 1
increment by 1
nocache;

