drop table account
drop table ranking

drop sequence account_seq
drop sequence ranking_seq



create table account(
	num number(38) NOT NULL,
	id varchar2(500),
	pw varchar2(500),
	nick varchar2(500),
	constraint account_nick_pk primary key(nick)
)
create table ranking(
	num number(38) NOT NULL,
	nick varchar2(500),
	difficult varchar2(500),
	month varchar2(500),
	constraint ranking_nick_fk foreign key(nick)
	references account(nick)
)




create sequence account_seq
start with 1
nocache

create sequence ranking_seq
start with 1
nocache




select * from account

select * from ranking

