drop database dbs_project;

create database dbs_project;

use dbs_project;

	-- entities table

create table user(
	id int(3) auto_increment primary key,
	fname varchar(10) not null,
	lname varchar(10) not null,
	address varchar(40) not null,
	phone varchar(10) not null
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
	cost int(3) not null
);

create table room_service(
	id int(2) not null primary key,
	name varchar(10) not null ,
	cost int(3) not null
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

-- for facilities
create table uses(
	u_id int(3) references user ,
	f_id int(2) references facilities ,
	hours int(1) not null,
	primary key(u_id,f_id)

);

-- for room_serviceu
create table orders(
	u_id int(3) references user,
	r_id int(2) references room_service,
	quantity int(1) not null,
	primary key(u_id,r_id)
);

create table admin(
	username varchar(20),
	password varchar(20)
);

insert into admin values("testing", "test1");
insert into admin values("test2", "test2");

insert into type values("Single", "1", "2000");
insert into type values("Double", "2", "4000");
insert into type values("Deluxe", "2", "5000");


insert into room values("0", "1");
insert into room values("0", "1");
insert into room values("0", "1");
insert into room values("0", "1");
insert into room values("0", "1");
insert into room values("0", "2");
insert into room values("0", "2");
insert into room values("0", "2");
insert into room values("0", "2");
insert into room values("0", "2");
insert into room values("0", "3");
insert into room values("0", "3");
insert into room values("0", "3");
insert into room values("0", "3");
insert into room values("0", "3");
insert into room values("1", "1");
insert into room values("1", "1");
insert into room values("1", "1");
insert into room values("1", "1");
insert into room values("1", "1");
insert into room values("1", "2");
insert into room values("1", "2");
insert into room values("1", "2");
insert into room values("1", "2");
insert into room values("1", "2");
insert into room values("1", "3");
insert into room values("1", "3");
insert into room values("1", "3");
insert into room values("1", "3");
insert into room values("1", "3");
insert into room values("2", "1");
insert into room values("2", "1");
insert into room values("2", "1");
insert into room values("2", "1");
insert into room values("2", "1");
insert into room values("2", "2");
insert into room values("2", "2");
insert into room values("2", "2");
insert into room values("2", "2");
insert into room values("2", "2");
insert into room values("2", "3");
insert into room values("2", "3");
insert into room values("2", "3");
insert into room values("2", "3");
insert into room values("2", "3");
insert into room values("3", "1");
insert into room values("3", "1");
insert into room values("3", "1");
insert into room values("3", "1");
insert into room values("3", "1");
insert into room values("3", "2");
insert into room values("3", "2");
insert into room values("3", "2");
insert into room values("3", "2");
insert into room values("3", "2");
insert into room values("3", "3");
insert into room values("3", "3");
insert into room values("3", "3");
insert into room values("3", "3");
insert into room values("3", "3");


					

