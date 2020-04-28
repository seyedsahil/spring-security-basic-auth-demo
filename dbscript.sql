use demo;

create table resource (
	id int identity(1, 1) primary key not null,
	name varchar(32) unique not null
);

insert into resource(name) values ('Table'), ('Chair');
