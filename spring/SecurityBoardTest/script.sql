create table tblboardMember(
    id varchar2(30) not null primary key,
    pw varchar2(65) not null,
    name varchar2(30) not null,
    email varchar2(100) not null,
    gender char(1) not null,
    regdate date default sysdate not null,
    enabled char(1) default '1'
);
alter table tblboardMember modify (pw varchar2(65));
commit;
drop table tblboardAuth;
create table tblboardAuth(
    id varchar2(30) not null references tblboardMember(id),
    auth varchar2(50) not null
);
select m.id,m.pw,m.name,m.email,m.gender,m.regdate,m.enabled,a.auth from tblboardMember m left outer join tblboardAuth a on m.id = a.id where m.id = 'dog';
select * from tblboardMember;
select * from tblboardAuth;

create table tblBoard(
    seq number primary key,
    subject varchar2(1000) not null,
    content varchar2(2000) not null,
    regdate date default sysdate not null,
    id varchar2(30) not null references tblboardMember(id)
);
commit;
create SEQUENCE seqBoard;
select * from tblBoard where seq = '1';