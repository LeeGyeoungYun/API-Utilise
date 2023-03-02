
create table weatherCraw(

	wc_no number(38) primary key, -- 네이버 날씨 크롤링 데이터 번호
	wc_region varchar2(40) not null, -- 지역
	wc_day varchar2(20) not null, -- 요일
	wc_date varchar2(20) not null, -- 날짜
	wc_weather varchar2(20) not null, -- 날씨
	wc_lowest varchar2(20) not null, -- 최저기온
	wc_highest varchar2(20) not null, --최고기온
	wc_creation_date date not null, -- 생성일
	wc_modify_date date -- 수정일
	
);

create sequence wc_seq
start with 1
increment by 1
nocache;

select * from WEATHERCRAW;
drop table WEATHERCRAW;