create table tblUser (
    seq number primary key,
    username varchar2(100) not null,
    name varchar2(100) not null,
    email varchar2(100) not null,
    age number not null

);
create sequence seqUser;

alter table tblUser
    add
        address varchar2(200);

commit;
