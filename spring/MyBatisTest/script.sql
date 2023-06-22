create table tblMyBatis(
    seq number primary key,
    name varchar2(30) not null,
    age number(3) not null,
    address varchar2(300) not null,
    gender char(1) not null
);
create sequence seqMyBatis;

insert into tblmybatis values(seqMyBatis.nextVal,'홍길동',20,'서울시 송파구','m');
commit;
select * from tblmybatis;

create table tblCode (
    seq number primary key,         -- 번호(PK)
    subject varchar2(500) not null, -- 제목
    code varchar2(2000) not null,   -- 코드 조각
    regdate date default sysdate not null, 
    language varchar2(50) not null  -- 언어종류
);

create sequence seqCode;
commit;
select * from tblcode;
select seq,subject,regdate,language from tblcode order by seq desc;

drop table tbladdress;
  drop SEQUENCE seqaddress;
  
  create table tblAddress(
    seq number primary key,
    name varchar2(30) not null,
    age number(3) not null,
    address varchar2(300) not null
  );
  
  commit;
  
  create SEQUENCE seqaddress;
  
  create table tblEmail(
    seq number primary key,
    email varchar2(100) not null,
    pseq number not null references tblAddress(seq)
    
  );
  
  create sequence seqEmail;
  