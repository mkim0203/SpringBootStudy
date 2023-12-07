DROP TABLE works IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE EMPLOYEE IF EXISTS;

DROP TABLE JOBS IF EXISTS;
DROP TABLE JOBS_SUB4 IF EXISTS;
DROP TABLE JOBS_SUB3 IF EXISTS;
DROP TABLE JOBS_SUB2 IF EXISTS;
DROP TABLE JOBS_SUB1 IF EXISTS;
DROP TABLE JOBS_ROOT IF EXISTS;

create table works (
    work_number int not null,
    work_name varchar(255) not null,
    primary key (work_number)
);
 
CREATE TABLE USERS (
	user_id varchar(255) not null,
	user_password varchar(255) not null
);

create table EMPLOYEE (
    id int not null,
    name varchar(255) not null,
    role varchar(255) not null,
    primary key (id)
);

-- 대분류 코드
create table JOBS_ROOT (
    code varchar(1) not null,
    name varchar(255) not null,
    primary key (code)
);

-- 중분류 코드
create table JOBS_SUB1 (
    code varchar(2) not null,
    root_code varchar(1) not null,
    name varchar(255) not null,
    primary key (code),
    FOREIGN KEY (root_code) REFERENCES JOBS_ROOT(code) ON UPDATE CASCADE
);

-- 소분류 코드
create table JOBS_SUB2 (
    code varchar(3) not null,
    sub1_code varchar(2) not null,
    name varchar(255) not null,
    primary key (code),
    FOREIGN KEY (sub1_code) REFERENCES JOBS_SUB1(code) ON UPDATE CASCADE
);

-- 세분류 코드
create table JOBS_SUB3 (
    code varchar(4) not null,
    sub2_code varchar(3) not null,
    name varchar(255) not null,
    primary key (code),
    FOREIGN KEY (sub2_code) REFERENCES JOBS_SUB2(code) ON UPDATE CASCADE
);

-- 세세분류 코드
create table JOBS_SUB4 (
    code varchar(5) not null,
    sub3_code varchar(4) not null,
    name varchar(255) not null,
    primary key (code),
    FOREIGN KEY (sub3_code) REFERENCES JOBS_SUB3(code) ON UPDATE CASCADE
);

