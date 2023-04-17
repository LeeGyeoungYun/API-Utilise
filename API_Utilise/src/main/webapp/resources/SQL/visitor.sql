CREATE TABLE visitor(
        id number PRIMARY KEY,--기본키 , 시퀀스 달것임
        visit_ip VARCHAR2(100) NOT NULL, --접속자 아이피
        visit_time date NOT NULL, --접속자 접속시간
        visit_refer VARCHAR2(300) NULL, --접속자가 어느사이트를 타고 들어왔는지
        visit_browser VARCHAR2(400) NOT NULL --접속자 브라우저 정보
)

create sequence visitor_seq  --시퀀스
start with 1
increment by 1
nocache;

select * from VISITOR;
drop table visitor;



