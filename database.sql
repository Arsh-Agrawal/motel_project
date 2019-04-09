-- drop database dbs_project;

-- create database dbs_project;

-- use dbs_project;

	-- entities table

create table user(
	id int auto_increment primary key,
	fname varchar(10) not null,
	lname varchar(10) not null,
	address varchar(40) not null,
	phone varchar(10) not null
);

create table type(
	id int auto_increment not null primary key,
	name varchar(10) not null,
	beds int not null,
	cost_per_night int not null
);

create table room(
	room_no int auto_increment primary key,
	status boolean default 0,
	floor int not null,
	type_id int references type
	-- foreign key (type_id) references type(id)
);

create table facilities(
	id int not null primary key,
	name varchar(10) not null,
	cost int not null
);

create table room_service(
	id int not null primary key,
	name varchar(10) not null ,
	cost int not null
);

create table bill(
	id int auto_increment,
	u_id int references user,
	price int not null,
	discount int not null,
	primary key(id,u_id)
);

	-- relationship table

create table books(
	u_id int references user ,
	room_no int references room ,
	check_in date not null,
	check_out date not null,
	primary key(u_id,room_no)
);	

-- for facilities
create table uses(
	u_id int references user ,
	f_id int references facilities ,
	hours int not null,
	primary key(u_id,f_id)

);

-- for room_serviceu
create table orders(
	u_id int references user,
	r_id int references room_service,
	quantity int not null,
	primary key(u_id,r_id)
);

create table admin(
	username varchar(20),
	password varchar(20)
);

insert into admin values("testing", "test1");
insert into admin values("test2", "test2");

insert into type values("Single", 1, 2000);
insert into type values("Double", 2, 4000);
insert into type values("Deluxe", 2, 5000);


insert into room values(0, 1);
insert into room values(0, 1);
insert into room values(0, 1);
insert into room values(0, 1);
insert into room values(0, 1);
insert into room values(0, 2);
insert into room values(0, 2);
insert into room values(0, 2);
insert into room values(0, 2);
insert into room values(0, 2);
insert into room values(0, 3);
insert into room values(0, 3);
insert into room values(0, 3);
insert into room values(0, 3);
insert into room values(0, 3);
insert into room values(1, 1);
insert into room values(1, 1);
insert into room values(1, 1);
insert into room values(1, 1);
insert into room values(1, 1);
insert into room values(1, 2);
insert into room values(1, 2);
insert into room values(1, 2);
insert into room values(1, 2);
insert into room values(1, 2);
insert into room values(1, 3);
insert into room values(1, 3);
insert into room values(1, 3);
insert into room values(1, 3);
insert into room values(1, 3);
insert into room values(2, 1);
insert into room values(2, 1);
insert into room values(2, 1);
insert into room values(2, 1);
insert into room values(2, 1);
insert into room values(2, 2);
insert into room values(2, 2);
insert into room values(2, 2);
insert into room values(2, 2);
insert into room values(2, 2);
insert into room values(2, 3);
insert into room values(2, 3);
insert into room values(2, 3);
insert into room values(2, 3);
insert into room values(2, 3);
insert into room values(3, 1);
insert into room values(3, 1);
insert into room values(3, 1);
insert into room values(3, 1);
insert into room values(3, 1);
insert into room values(3, 2);
insert into room values(3, 2);
insert into room values(3, 2);
insert into room values(3, 2);
insert into room values(3, 2);
insert into room values(3, 3);
insert into room values(3, 3);
insert into room values(3, 3);
insert into room values(3, 3);
insert into room values(3, 3);


					

