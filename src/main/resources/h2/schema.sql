DROP TABLE works IF EXISTS;
create table works (
    work_number int not null,
    work_name varchar(255) not null,
    primary key (work_number)
);
 

DROP TABLE users IF EXISTS;
CREATE TABLE USERS (
	user_id varchar(255) not null,
	user_password varchar(255) not null
);

DROP TABLE EMPLOYEE IF EXISTS;
create table EMPLOYEE (
    id int not null,
    name varchar(255) not null,
    role varchar(255) not null,
    primary key (id)
);

DROP TABLE JOBS IF EXISTS;
create table JOBS (
    code varchar(4) not null,
    name varchar(255) not null,
    primary key (code)
);

