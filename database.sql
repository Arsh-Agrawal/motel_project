drop database dbs_project;

create database dbs_project;

use dbs_project;

	-- entities table

create table user(
	id int(3) auto_increment primary key,
	fname varchar(10) not null,
	lname varchar(10) not null,
	address varchar(40) not null,
	phone varchar(10) not null,
	dob varchar(10) not null
);

create table type(
	id int(2) auto_increment not null primary key,
	name varchar(10) not null,
	beds int(2) not null,
	cost_per_night int(4) not null
);

create table room(
	room_no int(4) auto_increment primary key,
	status boolean default 0,
	floor int(2) not null,
	type_id int(2) references type
	-- foreign key (type_id) references type(id)
);

create table facilities(
	id int(2) not null primary key,
	name varchar(10) not null,
	cost int(3) not null,
	hours int(1) not null
);

create table room_service(
	id int(2) not null primary key,
	name varchar(10) not null ,
	cost int(3) not null,
	quantity int(1) not null
);

create table bill(
	id int(3) auto_increment,
	u_id int(3) references user,
	price int(9) not null,
	discount int(2) not null,
	primary key(id,u_id)
);

	-- relationship table

create table books(
	u_id int(3) references user ,
	room_no int(4) references room ,
	check_in date not null,
	check_out date not null,
	primary key(u_id,room_no)
);	

create table uses(
	u_id int(3) references user ,
	f_id int(2) references facilities ,
	primary key(u_id,f_id)

);

create table orders(
	u_id int(3) references user,
	r_id int(2) references room_service,
	primary key(u_id,r_id)
);

create table admin(
	username varchar(20),
	password varchar(20)
);

insert into admin values("testing", "test1");
