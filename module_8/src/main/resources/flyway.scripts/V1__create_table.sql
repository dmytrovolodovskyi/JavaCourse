create table buildings (
	id int not null primary key auto_increment,
    address varchar(45) not null
);

create table flats (
	id int not null primary key auto_increment,
    floor int(32) not null,
    number int(32) not null,
    area float not null,
    building_id int,
    foreign key (building_id) references buildings(id)
);

create table members (
	id int not null primary key auto_increment,
    name varchar(45) not null,
    flat_id int,
    foreign key (flat_id) references flats(id)
);

create table residents (
	id int not null primary key auto_increment,
    name varchar(45) not null,
    email varchar(45) not null,
    has_access boolean default false,
    member_id int,
    flat_id int,
    foreign key (member_id) references members(id),
    foreign key (flat_id) references flats(id)
);

create table roles (
	id int not null primary key auto_increment,
    role enum("member", "staff"),
    member_id int,
    foreign key (member_id) references members(id)
);