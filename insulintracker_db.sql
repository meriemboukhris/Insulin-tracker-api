drop database insulintrackerdb;
drop user meriem;
create user meriem with password 'password';
create database insulintrackerdb with template=template0 owner=meriem;
\connect insulintrackerdb;
alter default privileges grant all on tables to meriem;
alter default privileges grant all on sequences to meriem;

create table users_ins(
user_id integer primary key not null,
first_name varchar(20) not null,
last_name varchar(20) not null,
email varchar(20) not null,
password text not null,
gender varchar(20) not null,
age varchar(20) not null,
height varchar(20) not null,
weight varchar(20) not null
);


create table blood_glucose_levels(
index integer primary key not null,
Day varchar(50) not null,
user_id integer not null,
bG_before_breakfast varchar(20) not null,
bG_2h_after_breakfast varchar(20) not null,
bG_before_lunch varchar(20) not null,
bG_2h_after_lunch varchar(20) not null,
bG_before_dinner varchar(20) not null,
bG_2h_after_dinner varchar(20) not null,
Notes varchar(50) not null
);
alter table blood_glucose_levels add constraint BG_users_fk
foreign key (user_id) references users_ins(user_id);

create table insulineDoses(
index integer primary key not null,
blood_Glucose varchar(30) not null,
insuline_dose varchar(30)  not null
);
INSERT INTO insulineDoses(index, blood_Glucose, insuline_dose)
VALUES (1, '61-150', '0');
INSERT INTO insulineDoses(index, blood_Glucose, insuline_dose)
VALUES (2, '151-200', '3');
INSERT INTO insulineDoses(index, blood_Glucose, insuline_dose)
VALUES (3, '201-250', '5');
INSERT INTO insulineDoses(index, blood_Glucose, insuline_dose)
VALUES (4, '251-300', '8');
INSERT INTO insulineDoses(index, blood_Glucose, insuline_dose)
VALUES (5, '301-350', '10');
INSERT INTO insulineDoses(index, blood_Glucose, insuline_dose)
VALUES (6, '351-400', '12');
INSERT INTO insulineDoses(index, blood_Glucose, insuline_dose)
VALUES (7, 'Higher than 400', 'Doctor should be contacted');

create sequence users_ins_seq increment 1 start 1000;
create sequence blood_glucose_levels_seq increment 1 start 1;
