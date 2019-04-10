-- drop database dbs_project;

-- create database dbs_project;

-- use dbs_project;

	-- entities table

create table user_1(
	id int not null primary key,
	fname varchar(10) not null,
	lname varchar(10) not null,
	address varchar(40) not null,
	phone varchar(10) not null
);

Create sequence user_1_id_seq start with 1
increment by 1;

create table type_1(
	id int not null primary key,
	name varchar(10) not null,
	beds int not null,
	cost_per_night int not null
);

Create sequence type_1_id_seq start with 1
increment by 1;

create table room(
	room_no int not null primary key,
	status boolean default room_no_seq.nextval,0,
	floor int not null,
	type_id int references type_1
	-- foreign key (type_id) references type_1(id)
);

Create sequence room_no_seq start with 1
increment by 1;

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
	id int not null,
	u_id int references user_1,
	price int not null,
	discount int not null,
	primary key(id,u_id)
);

Create sequence bill_id start with 1
increment by 1;

--table to store final prices of facilities usage, roomservice usage and room booking fee

create table allprices(
	u_id int references user_1,
	facilities_price int default 0,
	roomservice_price int default 0;
	roombooking_price int default 0;

);

	-- relationship table

create table books(
	u_id int references user_1 ,
	room_no int references room ,
	check_in date not null,
	check_out date not null,
	primary key(u_id,room_no)
);

-- for facilities
create table uses(
	u_id int references user_1 ,
	f_id int references facilities ,
	hours int not null,
	primary key(u_id,f_id)

);

-- for room_serviceu
create table orders(
	u_id int references user_1,
	r_id int references room_service,
	quantity int not null,
	primary key(u_id,r_id)
);

create table admin(
	user_1name varchar(20),
	password varchar(20)
);

insert into admin values("testing", "test1");
insert into admin values("test2", "test2");

insert into type_1 values(type_1_id_seq.nextval,"Single", 1, 2000);
insert into type_1 values(type_1_id_seq.nextval,"Double", 2, 4000);
insert into type_1 values(type_1_id_seq.nextval,"Deluxe", 2, 5000);


insert into room values(room_no_seq.nextval,0, 1);
insert into room values(room_no_seq.nextval,0, 1);
insert into room values(room_no_seq.nextval,0, 1);
insert into room values(room_no_seq.nextval,0, 1);
insert into room values(room_no_seq.nextval,0, 1);
insert into room values(room_no_seq.nextval,0, 2);
insert into room values(room_no_seq.nextval,0, 2);
insert into room values(room_no_seq.nextval,0, 2);
insert into room values(room_no_seq.nextval,0, 2);
insert into room values(room_no_seq.nextval,0, 2);
insert into room values(room_no_seq.nextval,0, 3);
insert into room values(room_no_seq.nextval,0, 3);
insert into room values(room_no_seq.nextval,0, 3);
insert into room values(room_no_seq.nextval,0, 3);
insert into room values(room_no_seq.nextval,0, 3);
insert into room values(room_no_seq.nextval,1, 1);
insert into room values(room_no_seq.nextval,1, 1);
insert into room values(room_no_seq.nextval,1, 1);
insert into room values(room_no_seq.nextval,1, 1);
insert into room values(room_no_seq.nextval,1, 1);
insert into room values(room_no_seq.nextval,1, 2);
insert into room values(room_no_seq.nextval,1, 2);
insert into room values(room_no_seq.nextval,1, 2);
insert into room values(room_no_seq.nextval,1, 2);
insert into room values(room_no_seq.nextval,1, 2);
insert into room values(room_no_seq.nextval,1, 3);
insert into room values(room_no_seq.nextval,1, 3);
insert into room values(room_no_seq.nextval,1, 3);
insert into room values(room_no_seq.nextval,1, 3);
insert into room values(room_no_seq.nextval,1, 3);
insert into room values(room_no_seq.nextval,2, 1);
insert into room values(room_no_seq.nextval,2, 1);
insert into room values(room_no_seq.nextval,2, 1);
insert into room values(room_no_seq.nextval,2, 1);
insert into room values(room_no_seq.nextval,2, 1);
insert into room values(room_no_seq.nextval,2, 2);
insert into room values(room_no_seq.nextval,2, 2);
insert into room values(room_no_seq.nextval,2, 2);
insert into room values(room_no_seq.nextval,2, 2);
insert into room values(room_no_seq.nextval,2, 2);
insert into room values(room_no_seq.nextval,2, 3);
insert into room values(room_no_seq.nextval,2, 3);
insert into room values(room_no_seq.nextval,2, 3);
insert into room values(room_no_seq.nextval,2, 3);
insert into room values(room_no_seq.nextval,2, 3);
insert into room values(room_no_seq.nextval,3, 1);
insert into room values(room_no_seq.nextval,3, 1);
insert into room values(room_no_seq.nextval,3, 1);
insert into room values(room_no_seq.nextval,3, 1);
insert into room values(room_no_seq.nextval,3, 1);
insert into room values(room_no_seq.nextval,3, 2);
insert into room values(room_no_seq.nextval,3, 2);
insert into room values(room_no_seq.nextval,3, 2);
insert into room values(room_no_seq.nextval,3, 2);
insert into room values(room_no_seq.nextval,3, 2);
insert into room values(room_no_seq.nextval,3, 3);
insert into room values(room_no_seq.nextval,3, 3);
insert into room values(room_no_seq.nextval,3, 3);
insert into room values(room_no_seq.nextval,3, 3);
insert into room values(room_no_seq.nextval,3, 3);


					

